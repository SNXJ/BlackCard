package com.zsh.blackcard.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 图片处理工具类 核心是LRU算法,即:Least Recently Used的缩写，即最少使用页面置换算法，是为虚拟页式存储管理服务的。
 */
public class ImageUtil {
    /**
     * 中国移动联通wap代理网关
     */
    public static final String proxyMobile = "10.0.0.172";
    /**
     * 中国电信wap代理网关
     */
    public static final String proxyTel = "10.0.0.200";
    public static final String CTWAP = "ctwap";
    public static final String CMWAP = "cmwap";
    public static final String WAP_3G = "3gwap";
    public static final String UNIWAP = "uniwap";
    public static final int HARD_CACHE_CAPACITY = 30; // 定义map集合存的图片数量
    public static final int TYPE_CM_CU_WAP = 4; // 移动联通wap10.0.0.172
    public static final int TYPE_CT_WAP = 5; // 电信wap 10.0.0.200
    public static final int TYPE_OTHER_NET = 6; // 电信,移动,联通,wifi 等net网络
    protected static final String TAG = "ImageUtil";
   private static String insertImage;
    /**
     * 网络类型 0表示其他网络 1表示移动联通 2代表电信
     */
    public static int NetType = 0;
    /**
     * TODO 当mHardBitmapCache的key大于30的时候，会根据LRU算法把最近没有被使用的key放入到这个缓存中。
     * Bitmap使用了SoftReference，当内存空间不足时，此cache中的bitmap会被垃圾回收掉
     * ConcurrentHashMap是支持 高并发、高吞吐量的线程安全HashMap实现.
     */
    private static Map<String, SoftReference<Bitmap>> mSoftBitmapCache = new ConcurrentHashMap<String, SoftReference<Bitmap>>(
            HARD_CACHE_CAPACITY / 2);
    /**
     * 常用数据池 WeakReference与SoftReference都属于软引用,只不过WeakReference是弱引用,
     * 而SoftReference是强引用
     */
    public final static Map<String, SoftReference<Bitmap>> mHardBitmapCache = new LinkedHashMap<String, SoftReference<Bitmap>>(
            HARD_CACHE_CAPACITY / 2, 0.75f, true) {
        public static final long serialVersionUID = -6716765964916804088L;

        @Override
        protected boolean removeEldestEntry(
                Entry<String, SoftReference<Bitmap>> eldest) {
            if (size() > HARD_CACHE_CAPACITY) {
                // 当map的size大于30时，把最近不常用的key放到mSoftBitmapCache中，从而保证mHardBitmapCache的效率
                SoftReference<Bitmap> value = eldest.getValue();
                if (value.get() != null) {
                    mSoftBitmapCache.put(eldest.getKey(),
                            new SoftReference<Bitmap>(value.get()));
                }
                return true;
            } else {
                return false;
            }

        }
    };

//    public static void clearAllMap() {
//        mHardBitmapCache.clear();
//        mSoftBitmapCache.clear();
//        System.gc();
//    }

    /**
     * TODO 从缓存中获取图片
     */
    public static Bitmap getBitmapFromCache(String imagePath) {
        // 先从mHardBitmapCache缓存中获取
        synchronized (mHardBitmapCache) {
            if (mHardBitmapCache.containsKey(imagePath)) {
                SoftReference<Bitmap> softbitmap = mHardBitmapCache
                        .get(imagePath);
                if (softbitmap != null) {
                    final Bitmap bitmap = softbitmap.get();
                    if (bitmap != null) {
                        // 如果找到的话，把元素移到linkedhashmap的最前面，从而保证在LRU算法中是最后被删除
                        mHardBitmapCache.remove(imagePath);
                        mHardBitmapCache.put(imagePath,
                                new SoftReference<Bitmap>(bitmap));
                        return bitmap;
                    }
                }
            }
        }
        // 如果mHardBitmapCache中找不到，到mSoftBitmapCache中找,但要先判断一下这里是否包含key,如果不包含肯定没有
        if (mSoftBitmapCache.containsKey(imagePath)) {
            SoftReference<Bitmap> bitmapReference = mSoftBitmapCache
                    .get(imagePath);
            if (bitmapReference != null) {
                final Bitmap bitmap = bitmapReference.get();
                if (bitmap != null) {
                    return bitmap;
                } else {
                    // 如果key存在,但Soft里的Bitmap为空,那么清除这一组对象
                    mSoftBitmapCache.remove(imagePath);
                }
            }
        }
        return null;
    }

    /**
     * 保存图片到主线程中
     *
     * @param pathName
     * @param bitmap
     * @return 存储的路径
     */
    public static synchronized String saveToSD2(String pathName, Bitmap bitmap) {
        if (bitmap == null || pathName == null) {
            return null;
        }
        String fileName = null;
        if (hasSdcard()) {
            File directory = Environment.getExternalStorageDirectory();
            File file = new File(directory, pathName + "/");
            if (!file.exists()) {
              //  file.mkdirs(); // 创建文件夹
                if (file.mkdirs()) {
                    LogUtils.i("", "mkdirs success");
                } else {
                    LogUtils.i("", "mkdirs fail");
                }
            }
            fileName = new File(file, System.currentTimeMillis() + ".png")
                    .getAbsolutePath();
            FileOutputStream b = null;
            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, b); // 把数据写入文件
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (b != null) {
                        b.flush();
                        b.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
//        else {
//            // System.out.println("没有sd卡");
//        }
        return fileName;

    }

    /***
     * 添加图片至本地相册
     *
     * @param bitmap
     * @param context
     */
    public static synchronized void saveToDCIM(Bitmap bitmap, Context context) {
        if (bitmap == null) {
            return;
        }
        try {
             insertImage = MediaStore.Images.Media.insertImage(
                    context.getContentResolver(), bitmap, "", "");
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri
                    .parse("file://"
                            + Environment.getExternalStorageDirectory())));
            // System.out.println(insertImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否有SD卡 方法
     *
     * @return 是否有SD卡 方法
     */
    public static boolean hasSdcard() {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * TODO 添加BitMap进map集合,并与路径对应
     *
     * @param imagePath String图片路径
     */
    public static void putImageToMap(String imagePath) {
        Bitmap bitmap = getZoomBitmap(imagePath, 150f);
        if (bitmap != null) {
            mHardBitmapCache.put(imagePath, new SoftReference<Bitmap>(bitmap));
        }
    }

    /**
     * 添加本地缓存进map集合,并与路径对应
     *
     * @param imagePath  图片路径
     * @param isCompress 是否要压缩
     */
    public static void putImageToMap(String imagePath, boolean isCompress) {
        if (isCompress) {
            Bitmap bitmap = getZoomBitmap(imagePath, 150f);
            if (bitmap != null) {
                mHardBitmapCache.put(imagePath, new SoftReference<Bitmap>(
                        bitmap));
            }
        } else {
            getHighBitmap(imagePath);
        }
    }

    /**
     * 保存网络图片到map中
     *
     * @param imagePath 图片路径
     * @param bitmap
     */
    public static void putBitmapToMap(String imagePath, Bitmap bitmap) {
        if (bitmap != null) {
            mHardBitmapCache.put(imagePath, new SoftReference<Bitmap>(bitmap));
        }
    }

    /**
     * 方法描述：不压缩直接获取一个图片
     *
     * @param path 图片路径
     * @return Bitmap对象
     */
    public static Bitmap getSoftBitmap(String path) {
        SoftReference<Bitmap> bmp = null;
        bmp = mSoftBitmapCache.get(path);
        if (bmp != null && bmp.get() != null) {
            return bmp.get();
        }

        mSoftBitmapCache.remove(path);
        return null;
    }

    /**
     * 从内存中取一张图片
     *
     * @param path 图片路径
     * @return Bitmap
     */
    public static Bitmap getBitmap(String path) {
//        Bitmap bmp = new SoftReference<Bitmap>(getZoomBitmap(path, 300F)).get();
        return new SoftReference<Bitmap>(getZoomBitmap(path, 300F)).get();
    }

    /**
     * TODO 添加BitMap进map集合,并与路径对应
     *
     * @param imagePath String图片路径
     */
    public static void putURLImageToMap(String imagePath, Bitmap bitmap) {
        if (!mHardBitmapCache.containsKey(imagePath)) {
            if (bitmap == null) {
                return;
            }
            mHardBitmapCache.put(imagePath, new SoftReference<Bitmap>(bitmap));
        }
    }

    public static void putSoftImageToMap(String imagePath, Bitmap bitmap) {
        if (!mSoftBitmapCache.containsKey(imagePath)) {
            if (bitmap == null) {
                return;
            }
            mSoftBitmapCache.put(imagePath, new SoftReference<Bitmap>(bitmap));
        }
    }

    /**
     * TODO 缩放图片
     *
     * @param imagePath
     * @param scale     压缩比率 可以为空,那么是默认是200,这个值越大则 压缩比越小 如果压缩率是0,则表示不压缩
     * @return 一个缩放好的bitmap
     */
    public static Bitmap getZoomBitmap(String imagePath, Float scale) {
        if (!new File(imagePath).exists()) {
            return null;
        }

        if (scale == null) {
            scale = 200f;
        }
        Bitmap bm = null;
        if (scale > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            bm = BitmapFactory.decodeFile(imagePath, options);
            int be = (int) (options.outHeight / (float) scale);
            if (be <= 1) {
                be = 1;
            }
            options.inSampleSize = be; // be=2.表示压缩为原来的1/2,以此类推
            options.inJustDecodeBounds = false;
            bm = BitmapFactory.decodeFile(imagePath, options);
        } else {
            bm = BitmapFactory.decodeFile(imagePath);
        }
        return bm;
    }

    /**
     * 获取原版图片不压缩
     *
     * @param dir    图片存在的目录
     * @param imgUrl 图片名
     * @return
     */
    public static Bitmap getHighBitmap(File dir, String imgUrl) {
        String imagePath = new File(dir, URLEncoder.encode(imgUrl))
                .getAbsolutePath();
        if (!new File(imagePath).exists()) {
            return null;
        }

//        Bitmap bm = BitmapFactory.decodeFile(imagePath);
        return BitmapFactory.decodeFile(imagePath);
    }

    /**
     * 获取原版图片不压缩
     *
     * @param imagePath 图片路径
     * @return
     */
    public static Bitmap getHighBitmap(String imagePath) {
//        Bitmap bm = BitmapFactory.decodeFile(imagePath);
        return BitmapFactory.decodeFile(imagePath);
    }

    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    /**
     * 圆形的bitmap对象
     *
     * @param bitmap
     * @return
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        // 圆形图片宽高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        // 正方形的边长
        int r = 0;
        // 取最短边做边长
        if (width > height) {
            r = height;
        } else {
            r = width;
        }
        // 构建一个bitmap
        Bitmap backgroundBmp = Bitmap.createBitmap(r, r, Config.ARGB_8888);
        // new一个Canvas，在backgroundBmp上画图
        Canvas canvas = new Canvas(backgroundBmp);
        Paint paint = new Paint();
        // 设置边缘光滑，去掉锯齿
        paint.setAntiAlias(true);
        // 宽高相等，即正方形
        RectF rect = new RectF(0, 0, r, r);
        // 通过制定的rect画一个圆角矩形，当圆角X轴方向的半径等于Y轴方向的半径时，
        // 且都等于r/2时，画出来的圆角矩形就是圆形
        canvas.drawRoundRect(rect, r /(float) 2, r / (float)2, paint);
        // 设置当两个图形相交时的模式，SRC_IN为取SRC图形相交的部分，多余的将被去掉
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        // canvas将bitmap画在backgroundBmp上
        canvas.drawBitmap(bitmap, null, rect, paint);
        // 返回已经绘画好的backgroundBmp
        return backgroundBmp;
    }

    /**
     * ImageView旋转动画封装方法
     *
     * @param imageView
     * @param fromDegrees 动画开始的位置角度
     * @param toDegrees   动画结束的位置角度
     */
    public static void setAnimation(ImageView imageView, float fromDegrees,
                                    float toDegrees) {
        RotateAnimation animation;
        animation = new RotateAnimation(fromDegrees, toDegrees,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animation.setDuration(200);
        animation.setFillAfter(true); // 让控件停止在动画结束的状态下
        imageView.startAnimation(animation);
    }

    /**
     * TODO @author 图片加载回调接口
     */
    public interface ImageCallback {
        void loadImage(Bitmap bitmap, String imagePath);
    }

}
