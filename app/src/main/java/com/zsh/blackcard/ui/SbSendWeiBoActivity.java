package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
import com.zsh.blackcard.listener.DateListener;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;

/**
 * Created by kkkkk on 2017/12/7.
 * 发送黑微博
 */

public class SbSendWeiBoActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.send_weiBo_et)
    EditText send_weiBo_et;
    @BindView(R.id.topic_weiBo_tv)
    TextView topic_weiBo_tv;

    @BindView(R.id.send_weiBo_recycler)
    RecyclerView send_weiBo_recycler;

    private SendWeiBoAdapter sendWeiBoAdapter;
    private List<LocalMedia> localMedia = new ArrayList<>();
    private List<MultipartBody.Part> pary;

    @Override
    protected void initUI() {
        setContentView(R.layout.send_weibo_activity);
        ButterKnife.bind(this);
        initRecycler();
    }

    private void initRecycler() {
        //首次进入页面给下方的添加图片占位符
        localMedia.add(new LocalMedia());
        sendWeiBoAdapter = new SendWeiBoAdapter(R.layout.send_weibo_recycler_item, localMedia);
        send_weiBo_recycler.setLayoutManager(new GridLayoutManager(this, 4));
        send_weiBo_recycler.setAdapter(sendWeiBoAdapter);
        sendWeiBoAdapter.setOnItemClickListener(this);
    }

    @OnClick({R.id.blackwb_back, R.id.send_weiBo_tv, R.id.topic_weiBo_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.topic_weiBo_tv:
                ActivityUtils.startActivity(SbSendWeiBoActivity.this, SelectTopicActivity.class);
                SelectTopicActivity.setListener(listener);
                break;
            //发布微博
            case R.id.send_weiBo_tv:
                initSendWeiBo(localMedia);
                break;
        }
    }

    DateListener listener = new DateListener() {
        @Override
        public void dateListener(String data) {
            if (null != data) {
                topic_weiBo_tv.setText(data);
            }
        }
    };

    //发送黑微博
    private void initSendWeiBo(final List<LocalMedia> localMedia) {
        //获取图片集合最后一个元素，如果是占位符则移除，否则就上传
        if (localMedia.get(localMedia.size() - 1).getPath() == null) {
            localMedia.remove(localMedia.size() - 1);
        }

        if (pary == null) {
            pary = new ArrayList<>();
        } else {
            pary.clear();
        }

        DataManager.getInstance(this).RequestHttp(NetApi.postSendWeiBos(DataManager.getMd5Str("CIRCLEADD"), "d6a3779de8204dfd9359403f54f7d27c", send_weiBo_et.getText().toString(), pary, localMedia, "1"), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    finish();
                } else {
                    if (SbSendWeiBoActivity.this.localMedia.size() != 4) {
                        SbSendWeiBoActivity.this.localMedia.add(new LocalMedia());
                        sendWeiBoAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        //点击item时，如果路径为空，启动相册
        if (localMedia.get(position).getPath() == null) {
            //如果集合长度大于1，（表示已经有正规图片）
            if (localMedia.size() > 1) {
                //则移除掉最后的占位符，因为在相册界面，要显示之前已经显示过的图片
                localMedia.remove(position);
                //加载相册，传递已经选择的图片集合
                PictureSelector.create(SbSendWeiBoActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(4)
                        .selectionMedia(localMedia)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
                //如果集合长度不大于1，则表示并没有选择任何照片，只有占位符
            } else {
                //则不传递照片集合，加载相册。
                PictureSelector.create(SbSendWeiBoActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(4)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        }

        //当图片选择满4张时，再次点击item则为编辑选择图片
        if (localMedia.size() == 4 && localMedia.get(3).getPath() != null) {
            PictureSelector.create(SbSendWeiBoActivity.this)
                    .openGallery(PictureMimeType.ofImage())
                    .maxSelectNum(4)
                    .selectionMedia(localMedia)
                    .forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(resultCode + "====" + requestCode);
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
            }
            //如果点击了取消或返回键
        } else if (resultCode == RESULT_CANCELED) {
            //此种情况适用于：界面1，已经最少有一张在选图片，在点击时，先清除了占位符，此时在界面2，没有选择任何图片，则继续给新的占位符。
            //如果集合长度不等于1，则表示已经有选择图片了，则给新的占位符
            if (this.localMedia.size() != 1) {
                this.localMedia.add(new LocalMedia());
            }
        }
    }
}
