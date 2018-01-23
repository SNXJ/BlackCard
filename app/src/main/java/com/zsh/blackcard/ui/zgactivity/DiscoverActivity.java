package com.zsh.blackcard.ui.zgactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgDiscoverAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: DiscoverActivity
 * Author: Shing
 * Date: 2018/1/10 下午3:59
 * Description: 新——发现
 */

public class DiscoverActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ZgDiscoverAdapter zgDiscoverAdapter;
    List<Integer> list = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.zg_discover_activtity);
        ButterKnife.bind(this);

        initData();


    }

    private void initData() {
        list.add(R.mipmap.find_image_1);
        list.add(R.mipmap.find_image_1);
        list.add(R.mipmap.find_image_1);
        list.add(R.mipmap.find_image_1);
        list.add(R.mipmap.find_image_1);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        zgDiscoverAdapter = new ZgDiscoverAdapter(list);
        recyclerView.setAdapter(zgDiscoverAdapter);
    }


    @OnClick(R.id.title_back)
    public void onViewClicked() {
        finish();
    }
}
