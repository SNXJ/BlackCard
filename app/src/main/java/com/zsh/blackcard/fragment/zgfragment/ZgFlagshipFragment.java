package com.zsh.blackcard.fragment.zgfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgFlagRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZCY on 2018/1/11.
 * 旗舰店碎片
 */

public class ZgFlagshipFragment extends BaseFragment {

    @BindView(R.id.zg_flag_fragment_recycler)
    RecyclerView zg_flag_fragment_recycler;

    private ZgFlagRecyclerAdapter zgFlagRecyclerAdapter;

    @Override
    public void initDate(Bundle savedInstanceState) {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.flagship_image_1);
        list.add(R.mipmap.flagship_image_2);
        list.add(R.mipmap.flagship_image_3);
        list.add(R.mipmap.flagship_image_4);

        zgFlagRecyclerAdapter = new ZgFlagRecyclerAdapter(R.layout.zg_flag_fragment_recycler_item,list);
        zg_flag_fragment_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        zg_flag_fragment_recycler.setAdapter(zgFlagRecyclerAdapter);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.zg_flag_fragment,null);
        ButterKnife.bind(this,view);
        return view;
    }
}
