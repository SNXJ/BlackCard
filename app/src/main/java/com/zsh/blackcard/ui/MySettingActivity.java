package com.zsh.blackcard.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.fragment.setting.MySettingFragment;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class MySettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img;
    private TextView my_setting_title_tv;
    private FragmentManager fragmentManager;
    private Fragment frg_setting;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setting);
        initFindId();
        initOnClick();
        initDate();
    }

    //子碎片更改activity标题
    public void changeTitle(String titleStr) {
        my_setting_title_tv.setText(titleStr);
    }

    private void initDate() {
        frg_setting = new MySettingFragment();
        //加载默认碎片
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.my_setting_container, frg_setting);
        fragmentTransaction.commit();
    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
    }

    private void initFindId() {
        back_img = (ImageView) findViewById(R.id.blackwb_back);
        my_setting_title_tv = (TextView) findViewById(R.id.my_settng_title_tv);
    }

    @Override
    public void onClick(View v) {
        fragmentBack();
    }

    public void fragmentBack() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            finish();
        } else if (fragmentManager.getBackStackEntryCount() == 1) {
            fragmentManager.popBackStack();
            my_setting_title_tv.setText("设置");
        } else {
            fragmentManager.popBackStack();
        }
    }

    @Override
    public void onBackPressed() {
        fragmentBack();
    }
}
