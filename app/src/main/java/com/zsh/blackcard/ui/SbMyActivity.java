package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.live.AbMyContributionActivity;
import com.zsh.blackcard.live.AbMyFriendActivity;
import com.zsh.blackcard.live.AbMySettingActivity;
import com.zsh.blackcard.live.AbMySignActivity;
import com.zsh.blackcard.live.AbMyTaskActivity;
import com.zsh.blackcard.live.LiveRankActivity;
import com.zsh.blackcard.model.AbMyModel;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: SbMyActivity
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:尚播  我的：
 */
public class SbMyActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.im_head)
    ImageView imHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_guanzhu)
    TextView tvGuanzhu;
    @BindView(R.id.tv_guanzhu_num)
    TextView tvGuanzhuNum;
    @BindView(R.id.ll_guanzhu)
    LinearLayout llGuanzhu;
    @BindView(R.id.tv_hkb)
    TextView tvHkb;
    @BindView(R.id.tv_hkb_num)
    TextView tvHkbNum;
    @BindView(R.id.ll_hkb)
    LinearLayout llHkb;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.tv_fans_num)
    TextView tvFansNum;
    @BindView(R.id.ll_fans)
    LinearLayout llFans;
    @BindView(R.id.rl_gxbang)
    RelativeLayout rlGxbang;
    @BindView(R.id.rl_sign)
    RelativeLayout rlSign;
    @BindView(R.id.rl_rank)
    RelativeLayout rlRank;
    @BindView(R.id.rl_center)
    RelativeLayout rlCenter;
    @BindView(R.id.ll_sb_setting)
    RelativeLayout llSbSetting;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_sb_my);
        ButterKnife.bind(this);
        iniData();

    }

    private void iniData() {

        DataManager.getInstance(this).RequestHttp(NetApi.getAbMyInfo(DataManager.getMd5Str("MINEDATA"), BaseApplication.getHonouruserId()), new ResultListener<AbMyModel>() {
            @Override
            public void responseSuccess(AbMyModel obj) {
                if ("01".equals(obj.getResult())) {
                    tvGuanzhuNum.setText(obj.getPd().getFOCUSCOUNT());
                    tvHkbNum.setText(obj.getPd().getBLACKCOIN());
                    tvFansNum.setText(obj.getPd().getFANSCOUNT());

                    Glide.with(SbMyActivity.this).load(obj.getPd().getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(SbMyActivity.this))).into(imHead);
                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick({R.id.title_back, R.id.ll_guanzhu, R.id.ll_hkb, R.id.ll_fans, R.id.rl_gxbang, R.id.rl_sign, R.id.rl_rank, R.id.rl_center, R.id.ll_sb_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.ll_guanzhu:
                ActivityUtils.startActivityForData(SbMyActivity.this, AbMyFriendActivity.class, "0");
                break;
            case R.id.ll_hkb:
                startActivity(new Intent(SbMyActivity.this, BlackCurrencyActivity.class));
                break;
            case R.id.ll_fans:
                ActivityUtils.startActivityForData(SbMyActivity.this, AbMyFriendActivity.class, "1");
                break;
            case R.id.rl_gxbang:
                startActivity(new Intent(SbMyActivity.this, AbMyContributionActivity.class));
                break;
            case R.id.rl_sign:
                startActivity(new Intent(SbMyActivity.this, AbMySignActivity.class));
                break;
            case R.id.rl_rank:
                startActivity(new Intent(SbMyActivity.this, LiveRankActivity.class));
                break;
            case R.id.rl_center:
                startActivity(new Intent(SbMyActivity.this, AbMyTaskActivity.class));
                break;
            case R.id.ll_sb_setting:
                startActivity(new Intent(SbMyActivity.this, AbMySettingActivity.class));
                break;
        }
    }
}