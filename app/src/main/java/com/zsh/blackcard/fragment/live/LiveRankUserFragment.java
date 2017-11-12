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
 * Description:   用户等级页面：
 */

public class LiveRankUserFragment extends BaseFragment {

    @Override
    public void initDate(Bundle savedInstanceState) {

    }



    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.live_rank_anchor_fragment, null);

        return view;
    }
}
