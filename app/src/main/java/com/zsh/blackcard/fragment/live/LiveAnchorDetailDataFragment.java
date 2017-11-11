package com.zsh.blackcard.fragment.live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;

/**
 * Name: LiveRankAnchorFragment
 * Author: SNXJ
 * Date: 2017-11-10
 * Description:  主播微博：
 */
public class LiveAnchorDetailDataFragment extends BaseFragment {
    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.live_anchor_weibo_fragment, null);
        return view;
    }
}
