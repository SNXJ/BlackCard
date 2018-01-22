package com.zsh.blackcard.ui.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MainDJMusicAdapter;
import com.zsh.blackcard.adapter.MainGloryMusicLibAdapter;
import com.zsh.blackcard.adapter.MainGloryMusicSongAdapter;
import com.zsh.blackcard.adapter.MusicSongAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.MyImageLoader;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MainGloryMusicDJModel;
import com.zsh.blackcard.model.MainGloryMusicLibModel;
import com.zsh.blackcard.model.MainGloryMusicSongModel;
import com.zsh.blackcard.model.MainMusicGloryModel;
import com.zsh.blackcard.model.MusicRankAllModel;
import com.zsh.blackcard.model.MusicRankingModel;
import com.zsh.blackcard.model.MusicRecommendModel;
import com.zsh.blackcard.music.BaseMusicActivity;
import com.zsh.blackcard.music.MusicDetailActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.BannerUtils;

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

public class MainMusicActivity extends BaseMusicActivity {
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

    private List<String> topList = new ArrayList<>();
    private List<String> singerList = new ArrayList<>();

    private String[] type = new String[]{"21", "1", "12", "2", "11", "24", "22"};
    private String[] typeStr = new String[]{"飙升榜", "新歌榜", "歌手榜", "热歌榜", "原创榜", "赞赏榜", "老歌榜"};
    //榜单推荐列表适配器
    private MusicSongAdapter musicSongAdapter;
    //电台适配器
    private MainDJMusicAdapter mainDJMusicAdapter;
    //曲库推荐适配器
    private MainGloryMusicLibAdapter mainGloryMusicLibAdapter;
    //歌单推荐适配器
    private MainGloryMusicSongAdapter mainGloryMusicSongAdapter;

    @Override
    protected void initView() {
        setContentView(R.layout.home_main_music_activity);
        ButterKnife.bind(this);
        //头部广告和歌手推荐
        initTopBanner();
        //歌单推荐
        initSongRV();
        //曲库推荐接口
        initSongLibRV();
        //榜单推荐接口
        initRankRV();
        //电台接口
        initDjRV();
    }

    //电台接口
    private void initDjRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.postMainGloryMusicDJ(DataManager.getMd5Str("RADIOSTATIONLIST")), new ResultListener<MainGloryMusicDJModel>() {
            @Override
            public void responseSuccess(final MainGloryMusicDJModel obj) {
                if (obj.getResult().equals("01")) {
                    DJOneRecyclerView.setLayoutManager(new GridLayoutManager(MainMusicActivity.this, 3, LinearLayoutManager.HORIZONTAL, false));
                    mainDJMusicAdapter = new MainDJMusicAdapter(R.layout.music_main_dj_item, obj.getPd());
                    DJOneRecyclerView.setAdapter(mainDJMusicAdapter);

                    mainDJMusicAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            MusicDetailActivity.DT_NAME = obj.getPd().get(position).getCh_name();
                            ActivityUtils.startActivity(MainMusicActivity.this, MusicDetailActivity.class);
                        }
                    });
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //榜单推荐接口
    private void initRankRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.getMusicRanking(DataManager.getMd5Str("BILLLIST"), "1", "21,1,12,2,11,24,22"), new ResultListener<MusicRankAllModel>() {
            @Override
            public void responseSuccess(final MusicRankAllModel obj) {
                rankRecyclerView.setLayoutManager(new LinearLayoutManager(MainMusicActivity.this, LinearLayoutManager.HORIZONTAL, false));
                musicSongAdapter = new MusicSongAdapter(R.layout.music_rank_item, obj.getPd());
                rankRecyclerView.setAdapter(musicSongAdapter);
                musicSongAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        MusicDetailActivity.rankType = (type[position]);
                        MusicDetailActivity.rankStr = (typeStr[position]);
                        MusicDetailActivity.rankImgUrl = obj.getPd().get(position).getBillboard().getPic_s640();
                        ActivityUtils.startActivity(MainMusicActivity.this, MusicDetailActivity.class);
                    }
                });
                musicSongAdapter.setEmptyView(R.layout.home_hotel_empty_layout, rankRecyclerView);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //曲库推荐
    private void initSongLibRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.getMusicRecommendList(DataManager.getMd5Str("SONGLIST")), new ResultListener<MusicRecommendModel>() {
            @Override
            public void responseSuccess(final MusicRecommendModel obj) {
//                dataList = obj.getPd().getSong_list();
//                setData();
                if (obj.getResult().equals("01")) {
                    libRecyclerView.setLayoutManager(new LinearLayoutManager(MainMusicActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    mainGloryMusicLibAdapter = new MainGloryMusicLibAdapter(R.layout.music_lib_item, obj.getPd().getResult().getList());
                    libRecyclerView.setAdapter(mainGloryMusicLibAdapter);

                    mainGloryMusicLibAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            MusicDetailActivity.setData((List<MusicRecommendModel.PdBean.ResultBean.ListBean>) adapter.getData(), position);
                            ActivityUtils.startActivity(MainMusicActivity.this, MusicDetailActivity.class);
                        }
                    });
                }
            }

            @Override
            public void onCompleted() {

            }
        });



//        DataManager.getInstance(this).RequestHttp(NetApi.postMainGloryMusicLib(DataManager.getMd5Str("MUSICLIBRARY")), new ResultListener<MainGloryMusicLibModel>() {
//            @Override
//            public void responseSuccess(final MainGloryMusicLibModel obj) {
//                if (obj.getResult().equals("01")) {
//                    libRecyclerView.setLayoutManager(new LinearLayoutManager(MainMusicActivity.this, LinearLayoutManager.HORIZONTAL, false));
//                    mainGloryMusicLibAdapter = new MainGloryMusicLibAdapter(R.layout.music_lib_item, obj.getPd());
//                    libRecyclerView.setAdapter(mainGloryMusicLibAdapter);
//
//                    mainGloryMusicLibAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                            MusicDetailActivity.ALBUM_ID = obj.getPd().get(position).getAlbum_id();
//                            ActivityUtils.startActivity(MainMusicActivity.this, MusicDetailActivity.class);
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//        });
    }

    //歌单推荐
    private void initSongRV() {
        showLoading(this);
        DataManager.getInstance(this).RequestHttp(NetApi.postMainGloryMusicSong(DataManager.getMd5Str("SONGRECOMMEND"), "0"), new ResultListener<MainGloryMusicSongModel>() {
            @Override
            public void responseSuccess(final MainGloryMusicSongModel obj) {
                if (obj.getResult().equals("01")) {
                    songRecyclerView.setLayoutManager(new LinearLayoutManager(MainMusicActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    mainGloryMusicSongAdapter = new MainGloryMusicSongAdapter(R.layout.music_song_item, obj.getSong_recommend());
                    songRecyclerView.setAdapter(mainGloryMusicSongAdapter);

                    mainGloryMusicSongAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            MusicDetailActivity.setDataSong(obj.getSong_recommend().get(position).getSong_list(), position);
                            ActivityUtils.startActivity(MainMusicActivity.this, MusicDetailActivity.class);
                        }
                    });
                }
            }

            @Override
            public void onCompleted() {
                dialogDismiss();
            }
        });
    }

    private List<String> singIdList = new ArrayList<>();

    //头部广告和歌手推荐
    private void initTopBanner() {
        DataManager.getInstance(this).RequestHttp(NetApi.postMainGloryMusic(DataManager.getMd5Str("SONGRECOMMEND")), new ResultListener<MainMusicGloryModel>() {
            @Override
            public void responseSuccess(MainMusicGloryModel obj) {
                if (obj.getResult().equals("01")) {
                    for (int i = 0; i < obj.getAds().size(); i++) {
                        topList.add(obj.getAds().get(i).getSHOWIMG());
                    }

                    for (int i = 0; i < obj.getSingerList().size(); i++) {
                        singerList.add(obj.getSingerList().get(i).getSinger_pic());
                        singIdList.add(obj.getSingerList().get(i).getSinger_id());
                    }
                    //头部广告
                    BannerUtils.bannerNoImg(topBanner, topList, 3000);
                    //歌手推荐
                    BannerUtils.bannerNoImg(singerBanner, singerList, 3000);
                    singerBanner.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            MusicDetailActivity.TING_ID = (singIdList.get(position));
                            ActivityUtils.startActivity(MainMusicActivity.this, MusicDetailActivity.class);
                        }
                    });
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }


    @OnClick(R.id.title_back)
    public void onViewClicked() {
        finish();
    }
}