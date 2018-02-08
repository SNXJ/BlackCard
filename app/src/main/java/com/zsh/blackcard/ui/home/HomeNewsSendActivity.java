package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.SendWeiBoAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ChannelModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.UIUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;

public class HomeNewsSendActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.type_tv)
    TextView type_tv;
    //文字标题集合
    private List<ChannelModel> titleList = new ArrayList<>();
    //菜单id集合
//    private List<String> titList = new ArrayList<>();
    //标记选择发布的类型
    private String type = null;
    //根据上个页面的参数，决定发送什么请求
    private String selectType = null;
    //加载选择图片适配器
    private SendWeiBoAdapter sendWeiBoAdapter;
    //选择图片的URI集合
    private List<LocalMedia> localMedia = new ArrayList<>();
    //存放图片body
    private List<MultipartBody.Part> list = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_news_send);
        ButterKnife.bind(this);
        //文字标题
        titleList = ((List<ChannelModel>) getIntent().getSerializableExtra("listOne"));

        selectType = getIntent().getStringExtra("data");
        if (selectType.equals("1")) {
            recycler.setVisibility(View.GONE);
        } else {
            recycler.setVisibility(View.VISIBLE);
            localMedia.add(new LocalMedia());
            sendWeiBoAdapter = new SendWeiBoAdapter(R.layout.send_weibo_recycler_item, localMedia);
            recycler.setLayoutManager(new GridLayoutManager(this, 4));
            recycler.setAdapter(sendWeiBoAdapter);
            sendWeiBoAdapter.setOnItemClickListener(this);
        }
    }

    @OnClick({R.id.title_back, R.id.send, R.id.hj_eat_set_sort_relative})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.send:
                //发布
                if (selectType.equals("1")) {
                    //发布纯文本
                    initTextSend();
                } else if (selectType.equals("2")) {
                    //发布图片
                    initImage();
                } else {
                    //发布视频
                    initVideo();
                }
                break;
            case R.id.hj_eat_set_sort_relative:
                //选择发布类型
                sendType();
                break;
        }
    }

    //发布图片
    private void initImage() {
        if (!TextUtils.isEmpty(title.getText().toString().trim()) && type != null && localMedia.get(0).getPath() != null) {
            showLoading(this);
            String size = "";
            if (localMedia.size() <= 3 && localMedia.get(localMedia.size() - 1).getPath() == null) {
                size = "2003";
                localMedia.remove(localMedia.get(localMedia.size() - 1));
            } else {
                size = "2004";
                if (localMedia.get(3).getPath() == null) {
                    localMedia.remove(localMedia.get(localMedia.size() - 1));
                }
            }

            DataManager.getInstance(this).RequestHttp(NetApi.postHomeNewsSend(DataManager.getMd5Str("SELFMEDIAADD"), title.getText().toString().trim(), "d6a3779de8204dfd9359403f54f7d27c", size, type, list, localMedia, "2", videoPath), new ResultListener<ResultModel>() {
                @Override
                public void responseSuccess(ResultModel obj) {
                    if (obj.getResult().equals("01")) {
                        UIUtils.showToast("发布成功");
                        finish();
                    }
                }

                @Override
                public void onCompleted() {
                    dialogDismiss();
                }
            });
        } else {
            UIUtils.showToast("请完善发布信息");
        }
    }

    //发布视频
    private void initVideo() {
        if (!TextUtils.isEmpty(title.getText().toString().trim()) && type != null && localMedia.get(0).getPath() != null) {
            showLoading(this);
            DataManager.getInstance(this).RequestHttp(NetApi.postHomeNewsSend(DataManager.getMd5Str("SELFMEDIAADD"), title.getText().toString().trim(), "d6a3779de8204dfd9359403f54f7d27c", "2001", type, list, localMedia, "3", videoPath), new ResultListener<ResultModel>() {
                @Override
                public void responseSuccess(ResultModel obj) {
                    if (obj.getResult().equals("01")) {
                        UIUtils.showToast("发布成功");
                        finish();
                    }
                }

                @Override
                public void onCompleted() {
                    dialogDismiss();
                }
            });
        } else {
            UIUtils.showToast("请完善发布信息");
        }
    }

    //选择发布类型
    private void sendType() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < titleList.size(); i++) {
            items.add(titleList.get(i).getName());
        }


        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                type_tv.setText(titleList.get(options1).getName());
                type = titleList.get(options1).getId();
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(items, null, null);
        pvOptions.show();
    }

    //发送纯文本
    private void initTextSend() {
        if (!TextUtils.isEmpty(title.getText().toString().trim()) && type != null) {
            showLoading(this);
            DataManager.getInstance(this).RequestHttp(NetApi.postHomeNewsSend(DataManager.getMd5Str("SELFMEDIAADD"), title.getText().toString().trim(), "d6a3779de8204dfd9359403f54f7d27c", "2002", type, list, localMedia, "1", videoPath), new ResultListener<ResultModel>() {
                @Override
                public void responseSuccess(ResultModel obj) {
                    if (obj.getResult().equals("01")) {
                        UIUtils.showToast("发布成功");
                        finish();
                    }
                }

                @Override
                public void onCompleted() {
                    dialogDismiss();
                }
            });
        } else {
            UIUtils.showToast("请完善发布信息");
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (selectType.equals("2")) {
            //点击item时，如果路径为空，启动相册
            if (localMedia.get(position).getPath() == null) {
                //如果集合长度大于1，（表示已经有正规图片）
                if (localMedia.size() > 1) {
                    //则移除掉最后的占位符，因为在相册界面，要显示之前已经显示过的图片
                    localMedia.remove(position);
                    //加载相册，传递已经选择的图片集合
                    PictureSelector.create(HomeNewsSendActivity.this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(4)
                            .selectionMedia(localMedia)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    //如果集合长度不大于1，则表示并没有选择任何照片，只有占位符
                } else {
                    //则不传递照片集合，加载相册。
                    PictureSelector.create(HomeNewsSendActivity.this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(4)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                }
            }

            //当图片选择满4张时，再次点击item则为编辑选择图片
            if (localMedia.size() == 4 && localMedia.get(3).getPath() != null) {
                PictureSelector.create(HomeNewsSendActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(4)
                        .selectionMedia(localMedia)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        } else if (selectType.equals("3")) {
            if (localMedia.get(position).getPath() == null) {
                //打开视频选择
                PictureSelector.create(HomeNewsSendActivity.this)
                        .openGallery(PictureMimeType.ofVideo())
                        .selectionMode(PictureConfig.SINGLE)
                        .previewVideo(true)
                        .compress(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (selectType.equals("2")) {
            //在相册界面点击确定后，显示选择的照片
            if (resultCode == RESULT_OK) {
                switch (requestCode) {
                    case PictureConfig.CHOOSE_REQUEST:
                        List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(data);
                        //点击确定后，先清空之前的占位符集合，添加返回的全部图片集合
                        this.localMedia.clear();
                        this.localMedia.addAll(localMedia);
                        //如果图片集合长度不等于4，则表示还没有添加满4张，则继续给新的占位符图片
                        if (localMedia.size() != 4) {
                            this.localMedia.add(new LocalMedia());
                        }
                        //刷新适配器
                        sendWeiBoAdapter.notifyDataSetChanged();
                        break;
                }
                //如果点击了取消或返回键
            } else if (resultCode == RESULT_CANCELED) {
                //此种情况适用于：界面1，已经最少有一张在选图片，在点击时，先清除了占位符，此时在界面2，没有选择任何图片，则继续给新的占位符。
                //如果集合长度不等于1，则表示已经有选择图片了，则给新的占位符
                if (this.localMedia.size() != 1) {
                    this.localMedia.add(new LocalMedia());
                }
            }
        } else if (selectType.equals("3")) {
            //在相册界面点击确定后，显示选择的照片
            if (resultCode == RESULT_OK) {
                switch (requestCode) {
                    case PictureConfig.CHOOSE_REQUEST:
                        List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(data);
                        //点击确定后，先清空之前的占位符集合，添加返回的全部图片集合
                        this.localMedia.clear();
                        this.localMedia.addAll(localMedia);
                        sendWeiBoAdapter.notifyDataSetChanged();
                        boolean isSave = initSuoLueTu(localMedia.get(0).getPath());
                        if (isSave) {
                            UIUtils.showToast("生成缩略图成功");
                        } else {
                            UIUtils.showToast("生成缩略图失败");
                        }
                        break;
                }
            }
        }
    }

    private String videoPath = "";

    //保存缩略图
    private boolean initSuoLueTu(String path) {
        MediaMetadataRetriever media = new MediaMetadataRetriever();
        media.setDataSource(path);
        Bitmap bitmap = media.getFrameAtTime();

        File file = new File(Environment.getExternalStorageDirectory() + "/image");
        if (file.exists()) {
            file.delete();
        }
        file.mkdir();
        File suoluetu = new File(file, "suoluetu.jpg");
        if (suoluetu.exists()) {
            suoluetu.delete();
        }
        try {
            suoluetu.createNewFile();
            suoluetu.getName();
            FileOutputStream fos = new FileOutputStream(suoluetu);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            //设置缩略图路径
            videoPath = suoluetu.getPath();
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            return true;
        }
    }
}
