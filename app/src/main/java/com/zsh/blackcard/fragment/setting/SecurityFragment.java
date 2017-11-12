package com.zsh.blackcard.fragment.setting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.MySettingActivity;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class SecurityFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView my_setting_security_login_img,my_setting_security_pay_img,my_setting_security_print_img;
    private FragmentManager fragmentManager;
    private Fragment frg_login,frg_pay;


    @Override
    public void initDate(Bundle savedInstanceState) {
        fragmentManager = getFragmentManager();
        frg_login = new LoginPassFragment();
        frg_pay = new PayPassFragment();
    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.my_setting_security_fragment,null);
        initFindId();
        initOnClick();
        return view;
    }

    private void initOnClick() {
        my_setting_security_login_img.setOnClickListener(this);
        my_setting_security_pay_img.setOnClickListener(this);
        my_setting_security_print_img.setOnClickListener(this);
    }

    private void initFindId() {
        my_setting_security_login_img = (ImageView) view.findViewById(R.id.my_setting_security_login_img);
        my_setting_security_pay_img = (ImageView) view.findViewById(R.id.my_setting_security_pay_img);
        my_setting_security_print_img = (ImageView) view.findViewById(R.id.my_setting_security_print_img);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.my_setting_security_login_img:
                ((MySettingActivity) getActivity()).changeTitle("找回登录密码");
                transaction.replace(R.id.my_setting_container, frg_login);
                break;
            case R.id.my_setting_security_pay_img:
                ((MySettingActivity) getActivity()).changeTitle("找回支付密码");
                transaction.replace(R.id.my_setting_container, frg_pay);
                break;
            case R.id.my_setting_security_print_img:
                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
