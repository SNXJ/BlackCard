package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.fragment.HjFragment;
import com.zsh.blackcard.fragment.HomeFragment;
import com.zsh.blackcard.fragment.MyFragment;
import com.zsh.blackcard.ui.zgactivity.zgmyindentfragment.SlidingFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public HomeFragment fg_home;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_main);
        // 查找控件的方法
        findId();
        initData();
        //网络请求判断
       // Httpclient();
    }

    public SlidingFragment fg_slid;
    public HjFragment fg_hj;
    public MyFragment fg_my;
    public FragmentManager flhome;
    public RadioButton rbt_home;
    public RadioButton rbt_zg;
    public RadioButton rbt_sb;
    public RadioButton rbt_hj;
    public RadioButton rbt_my;


//    private void Httpclient() {
//        //获取链接管理器
//        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        //获取当前网络信息对象
//        NetworkInfo netInfo = cm.getActiveNetworkInfo();
//
//        //ActiveNetworkInfo不为空
//        if (netInfo != null) {
//            //网络是否已经链接
//            boolean available = netInfo.isAvailable();
//            //网络是否链接好并可以传递数据
//            boolean connected = netInfo.isConnected();
//            if (available && connected) {
//                int type = netInfo.getType();
//                if (type == ConnectivityManager.TYPE_WIFI) {
//                    Toast.makeText(this, "wifi网路可用", Toast.LENGTH_SHORT).show();
//                } else if (type == ConnectivityManager.TYPE_MOBILE) {
//                    Toast.makeText(this, "手机流量可用网路可用", Toast.LENGTH_SHORT).show();
//                }
//                // Toast.makeText(this, "网路可用", 0).show();
//            } else {
//                Toast.makeText(this, "网路不可用", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(this, "网路不可用", Toast.LENGTH_SHORT).show();
//        }
//    }

    private void initData() {
        flhome = getSupportFragmentManager();
        FragmentTransaction transaction = flhome.beginTransaction();
        fg_home = new HomeFragment();
        fg_slid = new SlidingFragment();
        fg_hj = new HjFragment();
        fg_my = new MyFragment();
        //尊购？
        transaction.add(R.id.flall, fg_home);
        transaction.add(R.id.flall, fg_slid);
        transaction.add(R.id.flall, fg_hj);
        transaction.add(R.id.flall, fg_my);
        transaction.show(fg_home);
        transaction.hide(fg_slid);
        transaction.hide(fg_hj);
        transaction.hide(fg_my);
        transaction.commit();
    }

    private void findId() {
        rbt_home = (RadioButton) findViewById(R.id.radio_btn_home);
        rbt_zg = (RadioButton) findViewById(R.id.radio_btn_zg);
        rbt_sb = (RadioButton) findViewById(R.id.radio_btn_sb);
        rbt_hj = (RadioButton) findViewById(R.id.radio_btn_hj);
        rbt_my = (RadioButton) findViewById(R.id.radio_btn_my);
        rbt_home.setOnClickListener(this);
        rbt_zg.setOnClickListener(this);
        rbt_sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SbActivity.class);
                startActivity(intent);
                            }
        });
        rbt_hj.setOnClickListener(this);
        rbt_my.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radio_btn_home:
                FragmentTransaction transaction1 = flhome.beginTransaction();
                transaction1.show(fg_home);
                transaction1.hide(fg_slid);
                transaction1.hide(fg_hj);
                transaction1.hide(fg_my);
                transaction1.commit();
                break;
            case R.id.radio_btn_zg:
                FragmentTransaction transaction2 = flhome.beginTransaction();
                transaction2.hide(fg_home);
                transaction2.show(fg_slid);
                transaction2.hide(fg_hj);
                transaction2.hide(fg_my);
                transaction2.commit();
                break;
            case R.id.radio_btn_sb:
                FragmentTransaction transaction3 = flhome.beginTransaction();
                transaction3.hide(fg_home);
                transaction3.hide(fg_slid);
                transaction3.hide(fg_hj);
                transaction3.hide(fg_my);
                transaction3.commit();
                break;
            case R.id.radio_btn_hj:
                FragmentTransaction transaction4 = flhome.beginTransaction();
                transaction4.hide(fg_home);
                transaction4.hide(fg_slid);
                transaction4.show(fg_hj);
                transaction4.hide(fg_my);
                transaction4.commit();
                break;
            case R.id.radio_btn_my:
                FragmentTransaction transaction5 = flhome.beginTransaction();
                transaction5.hide(fg_home);
                transaction5.hide(fg_slid);
                transaction5.hide(fg_hj);
                transaction5.show(fg_my);
                transaction5.commit();
                break;
            default:
                break;
        }

    }
}