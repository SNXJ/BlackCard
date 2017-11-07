package com.zsh.blackcard.fragment.integral;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;


/**
 * Created by admin on 2017/10/20.
 */

public class IntegralincomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.integralincomefragment,null);
        return view;
    }
}
