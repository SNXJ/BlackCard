package com.zsh.blackcard.ui;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.fragment.sbfragment.NearbyFragment;
import com.zsh.blackcard.fragment.sbfragment.RdFragment;
import com.zsh.blackcard.fragment.sbfragment.TypeFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 尚播Activity
 */

public class SbActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton rb_sbhome;
    private RadioButton rb_sb2;
    private RadioButton live_btn;
    private RadioButton rb_sbmy;
    private RadioButton rb_recommend;
    private RadioButton rb_nearby;
    private RadioButton rb_type;
    private ViewPager sbvp;
    private int defaultPage = 0;

    /**
     * /**
     * 从尚播界面会去主页面时，通过传值确定首页选中相对应的页面。
     */
    @OnClick(R.id.sb_home_back)
    public void onClick() {
        Intent intent = new Intent();
        intent.putExtra("default", defaultPage);
        setResult(1, intent);
        finish();
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_sb);
        ButterKnife.bind(this);
        //获取从哪个MainActivity传递过来的数值标识
        defaultPage = getIntent().getIntExtra("default", 0);
        //网络请求判断
        Httpclient();
        sbfindId();
        // VeiwPager添加适配器
        addAdapter();
        // ViewPager滑动监听事件
        sbvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rb_recommend.setChecked(true);
                        rb_nearby.setChecked(false);
                        rb_type.setChecked(false);
                        break;

                    case 1:
                        rb_recommend.setChecked(false);
                        rb_type.setChecked(false);
                        rb_nearby.setChecked(true);
                        break;

                    case 2:
                        rb_recommend.setChecked(false);
                        rb_nearby.setChecked(false);
                        rb_type.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        // button按钮的监听
        rb_recommend.setOnClickListener(this);
        rb_nearby.setOnClickListener(this);
        rb_type.setOnClickListener(this);
    }


    private void addAdapter() {
        sbvp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new RdFragment();
                        break;

                    case 1:
                        fragment = new NearbyFragment();
                        break;

                    case 2:
                        fragment = new TypeFragment();
                        break;
                }
                return fragment;
            }
        });
    }

    private void sbfindId() {
        rb_sb2 = (RadioButton) findViewById(R.id.radio_btn_sb2);
        live_btn = (RadioButton) findViewById(R.id.live_btn);
        rb_sbmy = (RadioButton) findViewById(R.id.radio_btn_sbmy);
        rb_recommend = (RadioButton) findViewById(R.id.sb_recommend_tv);
        rb_nearby = (RadioButton) findViewById(R.id.sb_nearby_tv);
        rb_type = (RadioButton) findViewById(R.id.sb_type_tv);
        sbvp = (ViewPager) findViewById(R.id.sb_vp);
        rb_sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent sbmyintent = new Intent(SbActivity.this, LiveRankActivity.class);
//                startActivity(sbmyintent);
            }
        });
        rb_sbmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sbmyintent = new Intent(SbActivity.this, SbMyActivity.class);
                startActivity(sbmyintent);

            }
        });
        live_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublicDialog.openLiveDialog(SbActivity.this);
                //  startActivity(new Intent(SbActivity.this, LiveActivity.class));//弹窗
                // startActivity(new Intent(SbActivity.this, LiveOpenActivity.class));
            }
        });
    }

    private void Httpclient() {
        //获取链接管理器
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        //获取当前网络信息对象
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        //ActiveNetworkInfo不为空
        if (netInfo != null) {
            //网络是否已经链接
            boolean available = netInfo.isAvailable();
            //网络是否链接好并可以传递数据
            boolean connected = netInfo.isConnected();
            if (available && connected) {
                int type = netInfo.getType();
                if (type == ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(this, "wifi网路可用", Toast.LENGTH_SHORT).show();
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    Toast.makeText(this, "手机流量可用网路可用", Toast.LENGTH_SHORT).show();
                }
                // Toast.makeText(this, "网路可用", 0).show();
            } else {
                Toast.makeText(this, "网路不可用", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "网路不可用", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sb_recommend_tv:
                sbvp.setCurrentItem(0);
                break;

            case R.id.sb_nearby_tv:
                sbvp.setCurrentItem(1);
                break;

            case R.id.sb_type_tv:
                sbvp.setCurrentItem(2);
                break;
        }
    }

}
