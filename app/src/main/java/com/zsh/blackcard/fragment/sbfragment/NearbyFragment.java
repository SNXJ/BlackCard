package com.zsh.blackcard.fragment.sbfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;


/**
 * 尚播的附近
 */

public class NearbyFragment extends Fragment {

    public View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.sb_nearbyfragment, null);
        return view;
    }

}
