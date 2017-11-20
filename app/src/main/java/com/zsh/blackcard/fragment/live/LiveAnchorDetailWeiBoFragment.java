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
public class LiveAnchorDetailWeiBoFragment extends BaseFragment {
    public static final String TITLE = "title";
    private String mTitle = "";
    @Override
    public void initDate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
        }
    }




    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.live_anchor_weibo_fragment, null);
        return view;
    }

    public static LiveAnchorDetailWeiBoFragment newInstance(String title) {
        LiveAnchorDetailWeiBoFragment fragment = new LiveAnchorDetailWeiBoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }
}
