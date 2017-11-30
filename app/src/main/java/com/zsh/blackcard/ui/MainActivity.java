package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.fragment.HjFragment;
import com.zsh.blackcard.fragment.HomeFragment;
import com.zsh.blackcard.fragment.MyFragment;
import com.zsh.blackcard.ui.zgactivity.zgmyindentfragment.SlidingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class MainActivity extends BaseActivity implements HomeFragment.SendMainActivity {

    private Fragment frg_home, frg_zg, frg_hj, frg_my, frg_replace;
    private FragmentManager fragmentManager;

    @BindView(R.id.radio_btn_hj)
    RadioButton radio_btn_hj;
    @BindView(R.id.radio_btn_home)
    RadioButton radio_btn_home;
    @BindView(R.id.radio_btn_zg)
    RadioButton radio_btn_zg;
    @BindView(R.id.radio_btn_my)
    RadioButton radio_btn_my;

    //默认页面编码
    private int defaultPage = 0;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    FragmentTransaction fragmentTransaction;

    private void initData() {
        //获取碎片管理器
        fragmentManager = getSupportFragmentManager();
        frg_home = new HomeFragment();
        frg_zg = new SlidingFragment();
        frg_hj = new HjFragment();
        frg_my = new MyFragment();


        // 默认加载第一个碎片页面
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_container, frg_home);
        fragmentTransaction.commit();
        frg_replace = frg_home;

    }

    //定制号码选择控制
    @OnCheckedChanged({R.id.radio_btn_home, R.id.radio_btn_zg, R.id.radio_btn_sb, R.id.radio_btn_hj, R.id.radio_btn_my})
    public void onChecked(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.radio_btn_home:
                if (isChecked) {
                    replaceFragment(frg_home);
                    defaultPage = 0;
                }
                break;
            case R.id.radio_btn_zg:
                if (isChecked) {
                    replaceFragment(frg_zg);
                    defaultPage = 1;
                }
                break;
            case R.id.radio_btn_sb:
                if (isChecked) {
                    Intent intent = new Intent(this, SbActivity.class);
                    intent.putExtra("default", defaultPage);
                    startActivityForResult(intent, 1);
                }
                break;
            case R.id.radio_btn_hj:
                if (isChecked) {
                    replaceFragment(frg_hj);
                    defaultPage = 3;
                }
                break;
            case R.id.radio_btn_my:
                if (isChecked) {
                    replaceFragment(frg_my);
                    defaultPage = 4;
                }
                break;
        }
    }

    //封装隐藏和显示布局方法
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction
                fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.hide(frg_replace).show(fragment).commit();
        } else {
            fragmentTransaction.hide(frg_replace).add(R.id.main_container, fragment).commit();
        }

        frg_replace = fragment;
    }

    @Override
    public void goIntent() {
        radio_btn_hj.setChecked(true);
    }

    /**
     * 默认从尚播界面回来时，自动选择上个页面
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1 && requestCode == 1) {
            defaultPage = data.getIntExtra("default", 0);
            if (defaultPage == 0) {
                radio_btn_home.setChecked(true);
            } else if (defaultPage == 1) {
                radio_btn_zg.setChecked(true);
            } else if (defaultPage == 3) {
                radio_btn_hj.setChecked(true);
            } else if (defaultPage == 4) {
                radio_btn_my.setChecked(true);
            }
        }
    }
}