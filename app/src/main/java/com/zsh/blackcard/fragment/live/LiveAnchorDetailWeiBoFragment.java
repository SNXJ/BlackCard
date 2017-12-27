package com.zsh.blackcard.fragment.live;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.LiveAncherWeiBoFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

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
        initMyDate();
    }

    List<String> list = new ArrayList<>();
    RecyclerView recyclerView;

    public void initMyDate() {
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        LiveAncherWeiBoFragmentAdapter adapter = new LiveAncherWeiBoFragmentAdapter(list);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ActivityUtils.startActivity(getActivity(), LiveRoomActivity.class);
            }
        });
    }

    @Override
    public View initView(LayoutInflater inflater) {

        View view = View.inflate(getActivity(), R.layout.live_anchor_weibo_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.id_stickynavlayout_innerscrollview);
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
