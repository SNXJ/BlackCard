package com.zsh.blackcard.fragment.Abfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;

/**
 * Name: AbTypeFragment
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbTypeFragment extends BaseFragment {
    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.sb_typefragment, null);
        return view;
    }
}
