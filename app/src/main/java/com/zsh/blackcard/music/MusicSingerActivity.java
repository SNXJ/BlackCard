package com.zsh.blackcard.music;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicSingerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicSingerModel;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MusicSingerActivity
 * Author: SNXJ
 * Date: 2017-12-08
 * Description:描述：
 */
public class MusicSingerActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tablayout_area)
    TabLayout tablayoutArea;
    @BindView(R.id.tablayout_sex)
    TabLayout tablayoutSex;
    @BindView(R.id.tablayout_type)
    TabLayout tablayoutType;
    @BindView(R.id.singer_recyclerView)
    RecyclerView singerRecyclerView;
    private MusicSingerAdapter adapter;
    private List<MusicSingerModel.PdBean.ArtistBean> dataList = new ArrayList<>();
    private String[] areTab = new String[]{"全部", "内地", "港台", "欧美", "日本", "韩国", "其他"};
    private String[] sexTab = new String[]{"全部", "男", "女", "组合"};
    private String[] typeTab = new String[]{"全部", "流行", "嘻哈", "摇滚", "电子", "民谣", "民歌", "其他"};

    @Override
    protected void initUI() {
        setContentView(R.layout.music_singer_activity);
        ButterKnife.bind(this);

        for (int i = 0; i < areTab.length - 1; i++) {
            tablayoutArea.addTab(tablayoutArea.newTab().setText(areTab[i]));
        }
        for (int i = 0; i < sexTab.length - 1; i++) {
            tablayoutSex.addTab(tablayoutSex.newTab().setText(sexTab[i]));
        }
        for (int i = 0; i < typeTab.length - 1; i++) {
            tablayoutType.addTab(tablayoutType.newTab().setText(typeTab[i]));
        }
        getSingerList();

    }


    private void getSingerList() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getMusicSingerList(DataManager.getMd5Str("HOTARTIST"), "1"), new ResultListener<MusicSingerModel>() {
            @Override
            public void responseSuccess(MusicSingerModel obj) {
                dataList = obj.getPd().getArtist();
                setData();
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setData() {
        singerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MusicSingerAdapter(dataList);
        singerRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MusicDetailActivity.setSingerId(dataList.get(position).getArtist_id());
                ActivityUtils.startActivity(MusicSingerActivity.this, MusicDetailActivity.class);
            }
        });
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }
}
