package com.zsh.blackcard.fragment.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;

/**
 * Created by kkkkk on 2017/11/11.
 */

public class AboutFragment extends BaseFragment {

    private View view;

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.my_setting_about_fragment,null);
        return view;
    }
}