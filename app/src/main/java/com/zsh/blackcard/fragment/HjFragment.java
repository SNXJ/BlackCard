package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;


/**
 * 汇聚页面
 */

public class HjFragment extends BaseFragment {

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.hjfragment, null);
        return view;
    }
}
