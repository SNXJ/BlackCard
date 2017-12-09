package com.zsh.blackcard.music;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicDetailDjAdapter;
import com.zsh.blackcard.adapter.MusicDetailReOtherAdapter;
import com.zsh.blackcard.adapter.MusicDetailRecommendAdapter;
import com.zsh.blackcard.adapter.MusicSingerSongAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicDetailListModel;
import com.zsh.blackcard.model.MusicRankingModel;
import com.zsh.blackcard.model.MusicRecommendModel;
import com.zsh.blackcard.model.MusicSingerModel;
import com.zsh.blackcard.model.MusicSingerSongsModel;
import com.zsh.blackcard.model.MusicSongDetailsModel;
import com.zsh.blackcard.music.model.Music;
import com.zsh.blackcard.music.untils.AppCache;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MusicDetailActivity
 * Author: SNXJ
 * Date: 2017-12-07
 * Description:描述：
 */
public class MusicDetailActivity extends BaseMusicActivity {
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MusicDetailDjAdapter djdapter;
    private MusicSingerSongAdapter singerSongAdapter;
    private MusicDetailRecommendAdapter recommendAdapter;
    private MusicDetailReOtherAdapter reOtherAdapter;
    List<MusicDetailListModel.PdBean.ResultBean.SonglistBean> listDjData = new ArrayList<>();
    private boolean isPlayFragmentShow = false;
    private String ch_name;
    private static String singerId;
    static List<MusicRecommendModel.PdBean.ResultBean.ListBean> recommendDataList;
    static List<MusicRankingModel.PdBean.SongListBean> reOtherDataList;

    public static void setRecommendData(List<MusicRecommendModel.PdBean.ResultBean.ListBean> dataList) {
        recommendDataList = dataList;
    }

    public static void setReOtherData(List<MusicRankingModel.PdBean.SongListBean> dataList) {
        reOtherDataList = dataList;
    }

    public static void setSingerId(String id) {
        singerId = id;
    }

    @Override
    protected void initView() {
        setContentView(R.layout.music_details);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        ch_name = getIntent().getStringExtra("data");
        if (null != recommendDataList) {
            setRecommendListData();
        } else if (null != ch_name) {
            initDjData();
        } else if (null != reOtherDataList) {
            setReOtherData();
        } else if (null != singerId) {
            getSingerData();
        }
    }

    private void getSingerData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getSingerSongs(DataManager.getMd5Str("SONGLIST"), singerId, "1"), new ResultListener<MusicSingerSongsModel>() {
            @Override
            public void responseSuccess(MusicSingerSongsModel obj) {
                // TODO没有数据
//
                setSingerSomgData();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setSingerSomgData() {
        List<MusicSingerModel.PdBean.ArtistBean> dataList = null;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        singerSongAdapter = new MusicSingerSongAdapter(dataList);
        recyclerView.setAdapter(singerSongAdapter);
        singerSongAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //  getSongDetail(listData.get(position).getSongid());
            }
        });

        singerSongAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);

    }

    private void setDjData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        djdapter = new MusicDetailDjAdapter(listDjData);
        recyclerView.setAdapter(djdapter);
        djdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                getSongDetail(listDjData.get(position).getSongid());
            }
        });

    }

    private void setRecommendListData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recommendAdapter = new MusicDetailRecommendAdapter(recommendDataList);
        recyclerView.setAdapter(recommendAdapter);
        recommendAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                getSongDetail(listData.get(position).getSongid());

            }
        });

    }

    private void setReOtherData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reOtherAdapter = new MusicDetailReOtherAdapter(reOtherDataList);
        recyclerView.setAdapter(reOtherAdapter);
        reOtherAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                getSongDetail(listData.get(position).getSongid());

            }
        });

    }

    private void getSongDetail(String songId) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getSongDetails(DataManager.getMd5Str("SONGPLAY"), songId), new ResultListener<MusicSongDetailsModel>() {
            @Override
            public void responseSuccess(MusicSongDetailsModel obj) {
                MusicSongDetailsModel.PdBean.BitrateBean musicData = obj.getPd().getBitrate();
                MusicSongDetailsModel.PdBean.SonginfoBean songinfo = obj.getPd().getSonginfo();
                Music music = new Music();
                music.setType(Music.Type.ONLINE);
                music.setTitle(songinfo.getTitle());
                music.setArtist(songinfo.getAuthor());
                music.setAlbum(songinfo.getAlbum_title());
                music.setCoverPath(songinfo.getPic_huge());
                music.setPath(musicData.getFile_link());
                music.setDuration(musicData.getFile_duration() * 1000);
                AppCache.getPlayService().play(music);

                showPlayingFragment();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDjData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).getMusicDjSongList(DataManager.getMd5Str("CANNELSONG"), ch_name), new ResultListener<MusicDetailListModel>() {
            @Override
            public void responseSuccess(MusicDetailListModel obj) {
                listDjData = obj.getPd().getResult().getSonglist();
                setDjData();
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.im_back)
    public void onClick() {
        finish();
    }

    private PlayFragment mPlayFragment;

    private void showPlayingFragment() {
        if (isPlayFragmentShow) {
            return;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fragment_slide_up, 0);
        if (mPlayFragment == null) {
            mPlayFragment = new PlayFragment();
            ft.replace(android.R.id.content, mPlayFragment);
        } else {
            ft.show(mPlayFragment);
        }
        ft.commitAllowingStateLoss();
        isPlayFragmentShow = true;
    }

    private void hidePlayingFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(0, R.anim.fragment_slide_down);
        ft.hide(mPlayFragment);
        ft.commitAllowingStateLoss();
        isPlayFragmentShow = false;
    }

    @Override
    public void onBackPressed() {
        if (mPlayFragment != null && isPlayFragmentShow) {
            hidePlayingFragment();
            return;
        }
        super.onBackPressed();
    }

}
