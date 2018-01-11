package com.zsh.blackcard.fragment.zgfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgSpecialRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZCY on 2018/1/11.
 * 专柜区碎片
 */

public class ZgSpecialFragment extends BaseFragment{

    @BindView(R.id.zg_special_frg_recycler)
    RecyclerView zg_special_frg_recycler;

    private ZgSpecialRecyclerAdapter zgSpecialRecyclerAdapter;

    @Override
    public void initDate(Bundle savedInstanceState) {
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.cabinet_image_2);
        list.add(R.mipmap.cabinet_image_3);
        list.add(R.mipmap.cabinet_image_4);
        list.add(R.mipmap.cabinet_image_5);
        list.add(R.mipmap.cabinet_image_6);
        list.add(R.mipmap.cabinet_image_7);
        list.add(R.mipmap.cabinet_image_8);
        list.add(R.mipmap.cabinet_image_9);
        zgSpecialRecyclerAdapter = new ZgSpecialRecyclerAdapter(R.layout.zg_special_fragment_recycler_item,list);
        zg_special_frg_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        zg_special_frg_recycler.setAdapter(zgSpecialRecyclerAdapter);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.zg_special_fragment,null);
        ButterKnife.bind(this,view);
        return view;
    }
}
