package com.zsh.blackcard.ui.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicSongAdapter;
import com.zsh.blackcard.custom.MyImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: MainMusicActivity
 * Author: Shing
 * Date: 2018/1/11 上午11:07
 * Description: 音乐首页
 */

public class MainMusicActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.top_banner)
    Banner topBanner;
    @BindView(R.id.songList_recyclerView)
    RecyclerView songRecyclerView;
    @BindView(R.id.lib_recyclerView)
    RecyclerView libRecyclerView;
    @BindView(R.id.singer_banner)
    Banner singerBanner;
    @BindView(R.id.rank_recyclerView)
    RecyclerView rankRecyclerView;
    @BindView(R.id.DJ_one_recyclerView)
    RecyclerView DJOneRecyclerView;

    private List<Integer> bannerList = new ArrayList<>();
    private List<String> tempImgList = new ArrayList<>();
    private MusicSongAdapter adapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.home_main_music_activity);
        ButterKnife.bind(this);

        tempImgList.add("");
        tempImgList.add("");
        tempImgList.add("");
        tempImgList.add("");
        tempImgList.add("");
        tempImgList.add("");
        tempImgList.add("");

        initTopBanner();
        initSongRV();
        initSongLibRV();
        initSingerBanner();
        initRankRV();
        initDjRV();

    }

    private void initDjRV() {
        DJOneRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MusicSongAdapter adapter = new MusicSongAdapter(R.layout.music_main_dj_item, tempImgList);//TODO  最后布局变化
        DJOneRecyclerView.setAdapter(adapter);
    }

    private void initRankRV() {
        rankRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MusicSongAdapter adapter = new MusicSongAdapter(R.layout.music_rank_item, tempImgList);
        rankRecyclerView.setAdapter(adapter);
    }

    private void initSingerBanner() {
        bannerList.add(R.mipmap.magazine_banner_11);
        bannerList.add(R.mipmap.magazine_banner_11);

        singerBanner.setImages(bannerList);
        singerBanner.setImageLoader(new MyImageLoader());
        singerBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        singerBanner.setIndicatorGravity(BannerConfig.CENTER);
        singerBanner.isAutoPlay(true);
        singerBanner.setDelayTime(3000);
        singerBanner.start();
    }

    private void initSongLibRV() {
        libRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MusicSongAdapter adapter = new MusicSongAdapter(R.layout.music_lib_item, tempImgList);
        libRecyclerView.setAdapter(adapter);
    }

    private void initSongRV() {

        songRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MusicSongAdapter adapter = new MusicSongAdapter(R.layout.music_song_item, tempImgList);
        songRecyclerView.setAdapter(adapter);
    }

    private void initTopBanner() {
        bannerList.add(R.mipmap.magazine_banner_11);
        bannerList.add(R.mipmap.magazine_banner_11);

        topBanner.setImages(bannerList);
        topBanner.setImageLoader(new MyImageLoader());
        topBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        topBanner.setIndicatorGravity(BannerConfig.CENTER);
        topBanner.isAutoPlay(true);
        topBanner.setDelayTime(3000);
        topBanner.start();

    }


    @OnClick(R.id.title_back)
    public void onViewClicked() {
        finish();
    }
}