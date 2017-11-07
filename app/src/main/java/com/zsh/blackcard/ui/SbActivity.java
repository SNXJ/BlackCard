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
import com.zsh.blackcard.fragment.sbfragment.NearbyFragment;
import com.zsh.blackcard.fragment.sbfragment.RdFragment;
import com.zsh.blackcard.fragment.sbfragment.TypeFragment;


public class SbActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton rb_sbhome;
    private RadioButton rb_sb2;
    private RadioButton rb_sbmy;
    private RadioButton rb_recommend;
    private RadioButton rb_nearby;
    private RadioButton rb_type;
    private ViewPager sbvp;
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_sb);
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
                        break;

                    case 1:
                        rb_nearby.setChecked(true);
                        break;

                    case 2:
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
        rb_sbmy = (RadioButton) findViewById(R.id.radio_btn_sbmy);
        rb_recommend = (RadioButton) findViewById(R.id.sb_recommend_tv);
        rb_nearby = (RadioButton) findViewById(R.id.sb_nearby_tv);
        rb_type = (RadioButton) findViewById(R.id.sb_type_tv);
        sbvp = (ViewPager) findViewById(R.id.sb_vp);

        rb_sbmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sbmyintent = new Intent(SbActivity.this,SbMyActivity.class);
                startActivity(sbmyintent);
            }
        });
    }
    private void Httpclient() {
        //获取链接管理器
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        //获取当前网络信息对象
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        //ActiveNetworkInfo不为空
        if (netInfo!=null) {
            //网络是否已经链接
            boolean available = netInfo.isAvailable();
            //网络是否链接好并可以传递数据
            boolean connected = netInfo.isConnected();
            if (available&&connected) {
                int type = netInfo.getType();
                if (type==ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(this, "wifi网路可用", Toast.LENGTH_SHORT).show();
                }else if(type==ConnectivityManager.TYPE_MOBILE) {
                    Toast.makeText(this, "手机流量可用网路可用", Toast.LENGTH_SHORT).show();
                }
                // Toast.makeText(this, "网路可用", 0).show();
            }else {
                Toast.makeText(this, "网路不可用", Toast.LENGTH_SHORT).show();
            }
        }else {
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
