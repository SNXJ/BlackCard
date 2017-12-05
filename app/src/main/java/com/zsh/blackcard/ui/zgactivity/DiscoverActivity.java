package com.zsh.blackcard.ui.zgactivity;

import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import cn.jzvd.JZUserActionStandard;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Name: DiscoverActivity
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:描述：
 */
public class DiscoverActivity extends BaseActivity {

    //    @BindView(R.id.)
    @BindView(R.id.discover_video)
    JZVideoPlayerStandard jzVideoPlayerStandard;

    @Override
    protected void initUI() {
        setContentView(R.layout.discover_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512469813308&di=a52a2b064d45fb2f09cc2ad79dc0b39e&imgtype=0&src=http%3A%2F%2Fimg2.gamfe.com%2Fuserfiles%2F24409%2Fphoto%2Fshow_201011181905095393.jpg").into(jzVideoPlayerStandard.thumbImageView);
        jzVideoPlayerStandard.setJzUserAction(new JZUserActionStandard() {
            @Override
            public void onEvent(int type, Object url, int screen, Object... objects) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @OnCheckedChanged({R.id.discover_one_rb, R.id.discover_two_rb, R.id.discover_three_rb, R.id.discover_four_rb, R.id.discover_five_rb})
    public void onChecked(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.discover_one_rb:
                break;
            case R.id.discover_two_rb:
                break;
            case R.id.discover_three_rb:
                break;
            case R.id.discover_four_rb:
                break;
            case R.id.discover_five_rb:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if(JZVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }
}
