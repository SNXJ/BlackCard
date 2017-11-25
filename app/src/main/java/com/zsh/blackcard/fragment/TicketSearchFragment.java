package com.zsh.blackcard.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.TicketSearchAdapter;
import com.zsh.blackcard.model.TicketSearchModel;
import com.zsh.blackcard.ui.TicketSeatActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: TicketSearchFragment
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class TicketSearchFragment extends BaseFragment {
    public static final String TYPE = "TYPE";
    private int mType = 0;

    @Override
    public void initDate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mType = getArguments().getInt(TYPE);
        }
    }

    public static TicketSearchFragment newInstance(int type) {
        TicketSearchFragment fragment = new TicketSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    RecyclerView recyclerView;
    List<TicketSearchModel> dataList = new ArrayList<>();

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.ticket_search_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_title);
        for (int i = 0; i < 10; i++) {
            dataList.add(new TicketSearchModel());
        }
        TicketSearchAdapter adapter;
        if (mType == 1) {
            adapter = new TicketSearchAdapter(dataList, mType);
        } else {
            adapter = new TicketSearchAdapter(dataList, mType);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        //  recyclerView.
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityUtils.startActivity(getActivity(), TicketSeatActivity.class);
            }
        });
        return view;
    }
}
