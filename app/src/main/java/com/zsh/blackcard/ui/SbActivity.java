package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.PublicFragmentAdapter;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.fragment.Abfragment.AbNearbyFragment;
import com.zsh.blackcard.fragment.Abfragment.AbReComFragmemt;
import com.zsh.blackcard.fragment.Abfragment.AbTypeFragment;
import com.zsh.blackcard.live.AbSearchActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.TabLayoutUntil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 尚播Activity
 */

public class SbActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.sb_vp)
    ViewPager sbVp;
    @BindView(R.id.radio_btn_sb2)
    RadioButton radioBtnSb2;
    @BindView(R.id.live_btn)
    RadioButton liveBtn;
    @BindView(R.id.radio_btn_sbmy)
    RadioButton radioBtnSbmy;
    @BindView(R.id.sb_home_back)
    ImageView sbHomeBack;
    @BindView(R.id.im_search)
    ImageView imSearch;
    @BindView(R.id.ab_tab_layout)
    TabLayout abTabLayout;
    private List<Fragment> fragments = new ArrayList<>();

    private int defaultPage = 0;
    private String[] title = {"推荐", "附近", "分类"};

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_sb);
        ButterKnife.bind(this);
        //获取从哪个MainActivity传递过来的数值标识
        defaultPage = getIntent().getIntExtra("default", 0);
        //网络请求判断
//        Httpclient();
        initDate();
    }

    public void initDate() {
        fragments.add(new AbReComFragmemt());
        fragments.add(new AbNearbyFragment());
        fragments.add(new AbTypeFragment());
        PublicFragmentAdapter adapter = new PublicFragmentAdapter(getSupportFragmentManager(), fragments, title);
        sbVp.setOffscreenPageLimit(4);
        sbVp.setAdapter(adapter);
        abTabLayout.setupWithViewPager(sbVp);
        TabLayoutUntil.setTabIndicator(abTabLayout, 40, 40);
    }


    @Override
    protected void onResume() {
        super.onResume();
        radioBtnSb2.setChecked(true);
    }


    @OnClick({R.id.sb_home_back, R.id.im_search, R.id.radio_btn_sb2, R.id.live_btn, R.id.radio_btn_sbmy})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sb_home_back:


                backIntent();
                break;
            case R.id.im_search:
                ActivityUtils.startActivity(this, AbSearchActivity.class);
                break;
            case R.id.radio_btn_sb2:
                break;
            case R.id.live_btn:
                PublicDialog.openLiveDialog(SbActivity.this, radioBtnSb2);
                break;
            case R.id.radio_btn_sbmy:
//                Intent sbmyintent = new Intent(SbActivity.this, SbMyActivity.class);
//                startActivity(sbmyintent);
                ActivityUtils.startActivity(SbActivity.this, SbMyActivity.class);
                break;
        }
    }

    /**
     * /**
     * 从尚播界面会去主页面时，通过传值确定首页选中相对应的页面。
     */
    private void backIntent() {
        Intent intent = new Intent();
        intent.putExtra("default", defaultPage);
        setResult(1, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        backIntent();

    }

}
