package com.zsh.blackcard.live;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.PublicFragmentAdapter;
import com.zsh.blackcard.aliLive.AliLivePlayActivity;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.fragment.live.LiveAnchorMoreFragment;
import com.zsh.blackcard.fragment.live.LiveAnchorVideoFragment;
import com.zsh.blackcard.fragment.live.LiveAnchorWeiboFragment;
import com.zsh.blackcard.listener.BitmapListener;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LiveAncherDetailsModel;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.BitmapUtils;
import com.zsh.blackcard.utils.FastBlur;
import com.zsh.blackcard.utils.TabLayoutUntil;
import com.zsh.blackcard.utils.UIUtils;
import com.zsh.blackcard.view.LiveBeatView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: LiveAnchorDetails
 * Author: SNXJ
 * Date: 2017-11-10
 * Description: 主播详情
 */
public class LiveAnchorDetails extends BaseActivity {
    @BindView(R.id.id_stickynavlayout_topview)//id_stickynavlayout_topview
            RelativeLayout idStickynavlayoutTopview;

    @BindView(R.id.id_stickynavlayout_indicator)
    TabLayout tab;
    @BindView(R.id.id_stickynavlayout_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_describe)
    TextView tvDescribe;
    @BindView(R.id.tv_follow)
    TextView tvFollow;
    @BindView(R.id.view_living)
    LiveBeatView viewLiving;
    @BindView(R.id.tv_living)
    TextView tvLiving;
    @BindView(R.id.ll_living)
    LinearLayout llLiving;
    @BindView(R.id.top_bg)
    ImageView topBg;
    private String[] mTitles = new String[]{"黑微博", "小视频", "资料"};
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;

    private String anchor_id;
    private LiveAncherDetailsModel.PdBean topData;

    @Override
    protected void initUI() {
        setContentView(R.layout.live_anchor2_details);
        ButterKnife.bind(this);
        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);
        anchor_id = getIntent().getStringExtra("data");

        anchor_id = "d6a3779de8204dfd9359403f54f7d27c";//Temp
        initTopData(anchor_id);
        initDatas();
    }

    private void initTopData(String anchor_id) {

        DataManager.getInstance(this).RequestHttp(NetApi.getLiveAncherDetails(DataManager.getMd5Str("USERDATA"), anchor_id), new ResultListener<LiveAncherDetailsModel>() {
            @Override
            public void responseSuccess(LiveAncherDetailsModel obj) {
                if ("01".equals(obj.getResult())) {
                    topData = obj.getPd();
                    setTopData();
                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setTopData() {

        tvName.setText(topData.getNICKNAME());
        tvDescribe.setText(topData.getSIGNNAME());
        tvFollow.setText("关注 " + topData.getFANSCOUNT() + "  |  粉丝 " + topData.getFANSCOUNT() + " 万");
        if ("0".equals(topData.getLIVE_ONLINE())) {
            viewLiving.stop();
            viewLiving.setVisibility(View.INVISIBLE);
            tvLiving.setText("未直播");
        } else {
            viewLiving.start();
            tvLiving.setText("直播中");
        }

        setTopBg(topData.getPORTRAIT());
    }

    private void setTopBg(final String url) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                BitmapUtils.getbitmapByUrl(url, new BitmapListener() {
                    @Override
                    public void bitmapListener(Bitmap bitmap) {
                        final Message msg = Message.obtain();
                        if (null != bitmap) {

                            msg.what = 1;
                            msg.obj = bitmap;
                        }
                        mHandler.sendMessage(msg);
                    }
                });
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    topBg.setImageBitmap(new FastBlur().fastblur(bitmap, 30, topBg));

                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void initDatas() {
        fragments.add(new LiveAnchorWeiboFragment());
        fragments.add(LiveAnchorVideoFragment.newInstance(mTitles[1]));
        fragments.add(LiveAnchorMoreFragment.newInstance(anchor_id));


        PublicFragmentAdapter adapter = new PublicFragmentAdapter(getSupportFragmentManager(), fragments, mTitles);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(adapter);
        tab.setupWithViewPager(mViewPager);
        TabLayoutUntil.setTabIndicator(tab, 30, 30);
    }


    @OnClick({R.id.im_back, R.id.ll_living})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.ll_living:
                if ("1".equals(topData.getLIVE_ONLINE())) {
                    ActivityUtils.startActivityForData(LiveAnchorDetails.this, AliLivePlayActivity.class, topData.getPublishUrl());
                } else {
                    UIUtils.showToast("主播并未开播");
                }
                break;
        }
    }
}
