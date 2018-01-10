package com.zsh.blackcard.live.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;

import butterknife.ButterKnife;


/**
 * Name: LivingNoFragment
 * Author: Shing
 * Date: 2018/1/9 下午3:49
 * Description: ..
 */

public class LivingNoFragment extends BaseFragment {
    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.living_no_fragment, null);
        //初始化ButterKnife
        ButterKnife.bind(this, view);
        return view;
    }
}
