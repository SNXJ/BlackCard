package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.live.AbMyContributionActivity;
import com.zsh.blackcard.ui.live.AbMySignActivity;
import com.zsh.blackcard.ui.live.AbMyTaskActivity;
import com.zsh.blackcard.ui.live.LiveRankActivity;
import com.zsh.blackcard.ui.live.AbMyFollowActivity;


/**
 * Name: SbMyActivity
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:尚播  我的：
 */
public class SbMyActivity extends BaseActivity implements View.OnClickListener {

    private ImageView title_back;
    private TextView title_tv;
    private ImageView im_head;
    private TextView tv_name;
    private TextView tv_guanzhu;
    private TextView tv_hkb;
    private TextView tv_fans;
    private TextView tv_guanzhu_num;
    private TextView tv_hkb_num;
    private TextView tv_fans_num;
    private RelativeLayout rl_gxbang;
    private RelativeLayout rl_sign;
    private RelativeLayout rl_rank;
    private RelativeLayout rl_center;


    private void bindViews() {
        title_back = (ImageView) findViewById(R.id.title_back);
        title_tv = (TextView) findViewById(R.id.title_tv);
        im_head = (ImageView) findViewById(R.id.im_head);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_guanzhu = (TextView) findViewById(R.id.tv_guanzhu);
        tv_hkb = (TextView) findViewById(R.id.tv_hkb);
        tv_fans = (TextView) findViewById(R.id.tv_fans);
        tv_guanzhu_num = (TextView) findViewById(R.id.tv_guanzhu_num);
        tv_hkb_num = (TextView) findViewById(R.id.tv_hkb_num);
        tv_fans_num = (TextView) findViewById(R.id.tv_fans_num);
        rl_gxbang = (RelativeLayout) findViewById(R.id.rl_gxbang);
        rl_sign = (RelativeLayout) findViewById(R.id.rl_sign);
        rl_rank = (RelativeLayout) findViewById(R.id.rl_rank);
        rl_center = (RelativeLayout) findViewById(R.id.rl_center);

        title_back.setOnClickListener(this);
        im_head.setOnClickListener(this);
        tv_name.setOnClickListener(this);
        tv_guanzhu.setOnClickListener(this);
        tv_hkb.setOnClickListener(this);
        tv_fans.setOnClickListener(this);
        tv_guanzhu_num.setOnClickListener(this);
        tv_hkb_num.setOnClickListener(this);
        tv_fans_num.setOnClickListener(this);
        rl_gxbang.setOnClickListener(this);
        rl_sign.setOnClickListener(this);
        rl_rank.setOnClickListener(this);
        rl_center.setOnClickListener(this);
    }


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_sb_my);
        bindViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.rl_gxbang:
                startActivity(new Intent(SbMyActivity.this, AbMyContributionActivity.class));
                break;
            case R.id.rl_sign:
                startActivity(new Intent(SbMyActivity.this, AbMySignActivity.class));
                break;
            case R.id.rl_center:
                startActivity(new Intent(SbMyActivity.this, AbMyTaskActivity.class));
                break;
            case R.id.rl_rank:
                startActivity(new Intent(SbMyActivity.this, LiveRankActivity.class));

                break;
            case R.id.tv_guanzhu:
            case R.id.tv_guanzhu_num:
                startActivity(new Intent(SbMyActivity.this, AbMyFollowActivity.class));
                break;
            case R.id.tv_hkb:
            case R.id.tv_hkb_num:
                startActivity(new Intent(SbMyActivity.this, BlackcoffeecurrencyActivity.class));
                break;
            case R.id.tv_fans_num:
            case R.id.tv_fans:
                startActivity(new Intent(SbMyActivity.this, AbMyFollowActivity.class));
                break;
            case R.id.im_head:
                break;

            default:
                break;
        }

    }

}