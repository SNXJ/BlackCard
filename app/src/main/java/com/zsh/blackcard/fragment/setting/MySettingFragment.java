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

public class MySettingFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private ImageView my_setting_gr_img, my_setting_msg_img, my_setting_security_img,my_setting_about_img,my_setting_exit_img;
    private FragmentManager fragmentManager;
    private Fragment frg_gr, frg_msg,frg_security,frg_about;

    @Override
    public void initDate(Bundle savedInstanceState) {
        fragmentManager = getFragmentManager();
        frg_gr = new SettingGrFragment();
        frg_msg = new SettingMsgFragment();
        frg_security = new SecurityFragment();
        frg_about = new AboutFragment();
    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.my_setting_fragment, null);
        initFindId();
        initOnClick();
        return view;
    }

    private void initOnClick() {
        my_setting_gr_img.setOnClickListener(this);
        my_setting_msg_img.setOnClickListener(this);
        my_setting_security_img.setOnClickListener(this);
        my_setting_about_img.setOnClickListener(this);
        my_setting_exit_img.setOnClickListener(this);
    }

    private void initFindId() {
        my_setting_gr_img = (ImageView) view.findViewById(R.id.my_setting_gr_img);
        my_setting_msg_img = (ImageView) view.findViewById(R.id.my_setting_msg_img);
        my_setting_security_img = (ImageView) view.findViewById(R.id.my_setting_security_img);
        my_setting_about_img = (ImageView) view.findViewById(R.id.my_setting_about_img);
        my_setting_exit_img = (ImageView) view.findViewById(R.id.my_setting_exit_img);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.my_setting_gr_img:
                ((MySettingActivity) getActivity()).changeTitle("个人资料");
                transaction.replace(R.id.my_setting_container, frg_gr);
                break;
            case R.id.my_setting_msg_img:
                ((MySettingActivity) getActivity()).changeTitle("新消息通知");
                transaction.replace(R.id.my_setting_container, frg_msg);
                break;
            case R.id.my_setting_security_img:
                ((MySettingActivity) getActivity()).changeTitle("帐号与安全");
                transaction.replace(R.id.my_setting_container, frg_security);
                break;
            case R.id.my_setting_about_img:
                ((MySettingActivity) getActivity()).changeTitle("帐号与安全");
                transaction.replace(R.id.my_setting_container, frg_about);
                break;
            case R.id.my_setting_exit_img:

                break;
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
