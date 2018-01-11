package com.zsh.blackcard.fragment.zgfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgFashionRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZCY on 2018/1/11.
 * 时尚圈碎片
 */

public class ZgFashionFragment extends BaseFragment {

    @BindView(R.id.zg_fashion_frg_recycler)
    RecyclerView zg_fashion_frg_recycler;

    private ZgFashionRecyclerAdapter zgFashionRecyclerAdapter;

    @Override
    public void initDate(Bundle savedInstanceState) {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.flagship_image_1);
        list.add(R.mipmap.flagship_image_2);
        list.add(R.mipmap.flagship_image_3);
        list.add(R.mipmap.flagship_image_4);
        zgFashionRecyclerAdapter = new ZgFashionRecyclerAdapter(R.layout.zg_fashion_fragment_recycler_item,list);
        zg_fashion_frg_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        zg_fashion_frg_recycler.setAdapter(zgFashionRecyclerAdapter);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.zg_fashion_fragment,null);
        ButterKnife.bind(this,view);
        return view;
    }
}
