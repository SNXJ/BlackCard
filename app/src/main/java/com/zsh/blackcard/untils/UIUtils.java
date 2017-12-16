package com.zsh.blackcard.untils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;


/**
 * Toast工具类
 *
 * @author sxj
 * @ClassName: UIUtils
 */
public class UIUtils {
    private static Toast mToast;
    private static AlertDialog dialog;
    private static ProgressDialog progressDialog;
    /**
     * 防止重复点击
     */
    private static long lastClickTime;

    /* 获取上下文对象 */
    public static Context getContext() {
        return BaseApplication.getApplication();
    }

    /* dip转px */
    public static int dip2px(int dip) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /* px转dip */
    public static int px2dip(int px) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /* 获取主线程的ID */
    public static long getMainThreadId() {
        return BaseApplication.getMainThreadId();
    }

    /* 判断当前线程是否在主线程 */
    public static boolean isRunInMainThread() {
        return android.os.Process.myTid() == getMainThreadId();
    }

    /**
     * 获取主线程的handler
     */
    public static Handler getHandler() {
        return BaseApplication.getMainThreadHandler();
    }

    /**
     * 延时在主线程执行runnable
     */
    public static boolean postDelayed(Runnable runnable, long delayMillis) {
        return getHandler().postDelayed(runnable, delayMillis);
    }

    /**
     * 在主线程执行runnable
     */
    public static boolean post(Runnable runnable) {
        return getHandler().post(runnable);
    }

    /**
     * toast显示工具方法，可以在非UI线程中调用，也能防止多次点击一直显示
     */
    public static void showToastSafe(final String text) {
        if (isRunInMainThread()) {
            showToast(text);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showToast(text);
                }
            });
        }
    }

    public synchronized static void showToast(String text) {
        BaseActivity activity = (BaseActivity) BaseActivity
                .getForegroundActivity();
        if (activity != null) {
            if (mToast == null) {
//				mToast = new Toast(activity);
//				LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//				View v = inflater.inflate(R.layout.toast_layout, null);
//				TextView tv = (TextView) v.findViewById(R.id.tv_toast);
//				tv.setText(text);
//				mToast.setView(v);
                mToast = Toast.makeText(activity, text, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
                mToast.setDuration(Toast.LENGTH_SHORT);
            }
            mToast.show();
        }
    }

//    /**
//     * 返回的对话框提醒
//     *
//     * @param activity 当前activity
//     * @param msg      提醒的内容
//     */
//    public static void backAlert(final Activity activity, String msg) {
//        Builder builder = new Builder(activity);
//        dialog = builder.create();
//        View view = View.inflate(activity, R.layout.exit_dialog, null);
//        if (msg != null) {
//            TextView msgText = (TextView) view.findViewById(R.id.tv_msg_dialog);
//            msgText.setText(msg);
//        }
//
//        Button bt_ok = (Button) view.findViewById(R.id.bt_ok);
//        Button bt_cancel = (Button) view.findViewById(R.id.bt_cancel);
//
//        // 取消按钮
//        bt_cancel.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        bt_ok.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                activity.finish();
//            }
//        });
//        builder.setView(view);
//        dialog = builder.show();
//    }

    /**
     * 关闭软键盘
     *
     * @param activity 当前上下文对象
     */
//    public static void closeSoftKeyboard(Activity activity) {
//        InputMethodManager imm = (InputMethodManager) activity
//                .getSystemService(Context.INPUT_METHOD_SERVICE);
//        // 得到InputMethodManager的实例
//        if (imm.isActive()) {
//            // 如果开启
//            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
//                    InputMethodManager.HIDE_NOT_ALWAYS);
//            // 关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
//        } else {
//            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
//                    InputMethodManager.HIDE_NOT_ALWAYS);
//        }
//    }

    /**
     * 控件获取焦点
     *
     * @param view
     */
    public static void getFocus(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 封装等待提示框
     *
     * @param context
     * @return
     */
    public static ProgressDialog newProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("请稍等...");
        return progressDialog;
    }

    public static void dismissProgressDialog() {
        progressDialog.dismiss();
    }
}
