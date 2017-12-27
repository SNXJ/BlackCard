package com.zsh.blackcard.fragment.Abfragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbreComFragmentAdapter;
import com.zsh.blackcard.live.LiveRoomActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: AbReComFragmemt
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbReComFragmemt extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    List<String> list = new ArrayList<>();

    @Override
    public void initDate(Bundle savedInstanceState) {
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        AbreComFragmentAdapter adapter = new AbreComFragmentAdapter(list);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivity(getActivity(), LiveRoomActivity.class);
            }
        });
    }

    @Override
    public View initView(LayoutInflater inflater) {
//        view = View.inflate(getActivity(), R.layout.sb_rdfragment, null);
        view = View.inflate(getActivity(), R.layout.ab_recom_fragment, null);
        ButterKnife.bind(getActivity());
        return view;
    }


}
