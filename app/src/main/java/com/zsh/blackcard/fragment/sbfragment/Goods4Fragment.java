package com.zsh.blackcard.fragment.sbfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.R;


/**
 * 商品页面  activity_commodity
 */

public class Goods4Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.id.goodsjs_1, null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
