package com.zsh.blackcard.music;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MusicDetailDjAdapter;
import com.zsh.blackcard.adapter.MusicDetailReOtherAdapter;
import com.zsh.blackcard.adapter.MusicDetailRecommendAdapter;
import com.zsh.blackcard.adapter.MusicSingerSongAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.BitmapListener;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MusicDetailListModel;
import com.zsh.blackcard.model.MusicDjModel;
import com.zsh.blackcard.model.MusicRankingModel;
import com.zsh.blackcard.model.MusicRecommendModel;
import com.zsh.blackcard.model.MusicSingerModel;
import com.zsh.blackcard.model.MusicSingerSongsModel;
import com.zsh.blackcard.model.MusicSongDetailsModel;
import com.zsh.blackcard.music.model.Music;
import com.zsh.blackcard.music.service.OnPlayerEventListener;
import com.zsh.blackcard.music.utils.AppCache;
import com.zsh.blackcard.music.utils.PlayModeEnum;
import com.zsh.blackcard.music.utils.Preferences;
import com.zsh.blackcard.utils.BitmapUtils;
import com.zsh.blackcard.utils.FastBlur;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.UIUtils;

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
public class MusicDetailActivity extends BaseMusicActivity implements OnPlayerEventListener {
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.iv_play_bar_cover)
    ImageView ivPlayBarCover;
    @BindView(R.id.tv_play_bar_title)
    TextView tvPlayBarTitle;
    @BindView(R.id.tv_play_bar_artist)
    TextView tvPlayBarArtist;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.iv_play_bar_play)
    ImageView ivPlayBarPlay;
    @BindView(R.id.iv_play_bar_next)
    ImageView ivPlayBarNext;
    @BindView(R.id.pb_play_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.fl_play_bar)
    FrameLayout flPlayBar;
    @BindView(R.id.im_top_bg)
    ImageView imTopBg;
    @BindView(R.id.rl_top_bg)
    ImageView rlTopBg;
    private MusicDetailDjAdapter djdapter;
    private MusicSingerSongAdapter singerSongAdapter;
    private MusicDetailRecommendAdapter recommendAdapter;
    private MusicDetailReOtherAdapter reOtherAdapter;
    List<MusicDetailListModel.PdBean.ResultBean.SonglistBean> listDjData = new ArrayList<>();
    private boolean isPlayFragmentShow = false;

    public static String rankType = null;
    public static String rankStr = null;
    public static String rankImgUrl = null;
    public static int position;
    public static MusicDjModel.PdBean.ResultBean.ChannellistBean djData = null;
    public static List<MusicRecommendModel.PdBean.ResultBean.ListBean> recommendDataList;
    public static List<MusicRankingModel.PdBean.SongListBean> reOtherDataList = new ArrayList<>();
    private List<MusicSingerSongsModel.PdBean.SonglistBean> singerSongList = new ArrayList<>();
    public static MusicSingerModel.PdBean.ArtistBean SingerData = null;

    public static void setData(List<MusicRecommendModel.PdBean.ResultBean.ListBean> recommendDataList2, int pos) {
        recommendDataList = recommendDataList2;
        position = pos;
    }

    @Override
    protected void onDestroy() {
        rankType = null;
        rankStr = null;
        rankImgUrl = null;

        if (null != recommendDataList) {
            recommendDataList = null;
        }
        if (null != reOtherDataList) {
            reOtherDataList = null;
        }
        if (null != singerSongList) {
            singerSongList = null;
        }
        if (null != listDjData) {
            listDjData = null;
        }
        if (null != SingerData) {
            SingerData = null;
        }
        if (null != djData) {
            djData = null;
        }
        if (null != mMusicList) {
            mMusicList = null;
        }
        super.onDestroy();
    }


    @Override
    protected void initView() {
        setContentView(R.layout.music_details);
        ButterKnife.bind(this);
        bindServerCompleted();
        initData();
    }

    private String[] dataType = new String[]{"SINGER0", "RANK1", "RECOMMEND2", "REOTHER3", "DJ4"};//

    private void initData() {
        showLoading(this);

        if (null != recommendDataList && recommendDataList.size() > 0) {
            switchLoopData("2");
            setRecommendListData();
        } else if (null != djData) {
            initDjData();
        } else if (null != reOtherDataList && reOtherDataList.size() > 0) {
            switchLoopData("3");
            setReOtherData(3);
        } else if (null != SingerData) {
            getSingerSongData();
        } else if (null != rankType) {
            getRankDataByType();
        }


    }

    private void switchLoopData(String type) {
        LogUtils.i("++++++++++++++", "++++++++++++++++" + type);
        switch (type) {
            case "0":
                getSingerMusicList();
                break;
            case "1":
                getReOtherMusicList();
                break;
            case "2":
                getReMusicList();
                break;
            case "3":
                getReOtherMusicList();
                break;
            case "4":
                getDjMusicList();
                break;
        }
    }

    private void getSingerMusicList() {
        if (singerSongList == null) {
            return;
        }
        for (int i = 0; i < singerSongList.size(); i++) {
            Music music = getMusicbyId(singerSongList.get(i).getSong_id());
            if (null != music) {
                mMusicList.add(music);
            }
        }
        LogUtils.i("++++++++++++", "++++++++singerSongList+++++++++++" + mMusicList.size());
        AppCache.setMusicList(mMusicList);
    }

    private void getReMusicList() {
        if (recommendDataList == null) {
            return;
        }
        for (int i = 0; i < recommendDataList.size(); i++) {
            Music music = getMusicbyId(recommendDataList.get(i).getSong_id());
            if (null != music) {
                mMusicList.add(music);
            }
        }
        LogUtils.i("++++++++++++", "++++++++mMusicList+++++++++++" + mMusicList.size());
        AppCache.setMusicList(mMusicList);
    }

    private void getReOtherMusicList() {
        if (reOtherDataList == null) {
            return;
        }
        for (int i = 0; i < reOtherDataList.size(); i++) {
            Music music = getMusicbyId(reOtherDataList.get(i).getSong_id());
            if (null != music) {
                mMusicList.add(music);
            }
        }
        LogUtils.i("++++++++++++", "++++++++mMusicList+++++++++++" + mMusicList.size());
        AppCache.setMusicList(mMusicList);
    }

    private void getDjMusicList() {
        if (listDjData == null) {
            return;
        }
        for (int i = 0; i < listDjData.size(); i++) {
            Music music = getMusicbyId(listDjData.get(i).getSongid());
            if (null != music) {
                mMusicList.add(music);
            }
        }
        LogUtils.i("++++++++++++", "++++++++mMusicList+++++++++++" + mMusicList.size());
        AppCache.setMusicList(mMusicList);
    }

    private void getRankDataByType() {
        LogUtils.i("+++++++rankType+++++++", "++++++排行榜+++++++");
        DataManager.getInstance(this).RequestHttp(NetApi.getRankingList(DataManager.getMd5Str("BILLLIST"), "1", rankType + ""), new ResultListener<MusicRankingModel>() {
            @Override
            public void responseSuccess(MusicRankingModel obj) {
                reOtherDataList = obj.getPd().getSong_list();
                //TODO
                setReOtherData(1);
                switchLoopData("1");
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setTopBg(final String url, String title) {
        tv_title.setText(title);
        new Thread(new Runnable() {
            @Override
            public void run() {
                BitmapUtils.getbitmapByUrl(url, new BitmapListener() {
                    @Override
                    public void bitmapListener(Bitmap bitmap) {
                        final Message msg = Message.obtain();
                        if (null == bitmap) {
                            msg.what = 0;
                            msg.obj = null;
                        } else {
                            msg.what = 1;
                            msg.obj = bitmap;
                        }
                        mHandler.sendMessage(msg);
                    }
                });
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    rlTopBg.setImageBitmap(new FastBlur().fastblur(bitmap, 50, rlTopBg));
                    imTopBg.setImageBitmap(bitmap);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void getSingerSongData() {
        setTopBg(SingerData.getAvatar_middle(), "歌手");
        DataManager.getInstance(this).RequestHttp(NetApi.getSingerSongs(DataManager.getMd5Str("SONGLIST"), SingerData.getTing_uid(), "1"), new ResultListener<MusicSingerSongsModel>() {
            @Override
            public void responseSuccess(MusicSingerSongsModel obj) {
                // TODO没有数据
                singerSongList = obj.getPd().getSonglist();
                setSingerSongData();

                switchLoopData("0");

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setSingerSongData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        singerSongAdapter = new MusicSingerSongAdapter(singerSongList);
        recyclerView.setAdapter(singerSongAdapter);
        singerSongAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                getSongDetail(singerSongList.get(position).getSong_id(), position);
            }
        });
        singerSongAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        dialogDismiss();
    }

    private void setDjData() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        djdapter = new MusicDetailDjAdapter(listDjData);
        recyclerView.setAdapter(djdapter);
        djdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                getSongDetail(listDjData.get(position).getSongid(), position);
            }
        });
        djdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        dialogDismiss();
    }

    private void setRecommendListData() {
        setTopBg(recommendDataList.get(position).getPic_big(), "曲库");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recommendAdapter = new MusicDetailRecommendAdapter(recommendDataList);
        recyclerView.setAdapter(recommendAdapter);
        recommendAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                getSongDetail(recommendDataList.get(position).getSong_id(), position);
//                AppCache.getPlayService().play(mMusicList.get(position));

            }
        });
        recommendAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        dialogDismiss();
    }

    private void setReOtherData(int type) {
        LogUtils.i("+++++++rankType+++++++", "++++曲库++other+++++++" + type);
        if (type == 1) {//排行榜
            setTopBg(rankImgUrl, rankStr);
        } else {
            setTopBg(reOtherDataList.get(position).getPic_big(), "曲库");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reOtherAdapter = new MusicDetailReOtherAdapter(reOtherDataList);
        recyclerView.setAdapter(reOtherAdapter);
        reOtherAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                getSongDetail(reOtherDataList.get(position).getSong_id(), position);

            }
        });
        reOtherAdapter.setEmptyView(R.layout.home_hotel_empty_layout, recyclerView);
        dialogDismiss();
    }

    private List<Music> mMusicList = new ArrayList<>();


    private Music getMusicbyId(final String songId) {
        final Music music = new Music();
        DataManager.getInstance(this).RequestHttp(NetApi.getSongDetails(DataManager.getMd5Str("SONGPLAY"), songId), new ResultListener<MusicSongDetailsModel>() {
            @Override
            public void responseSuccess(MusicSongDetailsModel obj) {
                if (null == obj) {
                    return;
                }
                if (null == obj.getPd()) {
                    return;
                }
                MusicSongDetailsModel.PdBean.BitrateBean musicData = obj.getPd().getBitrate();
                MusicSongDetailsModel.PdBean.SonginfoBean songinfo = obj.getPd().getSonginfo();
                if (null == musicData.getFile_link()) {
                    return;
                }
                music.setSongId(songId);
                music.setType(Music.Type.ONLINE);
                music.setTitle(songinfo.getTitle());
                music.setArtist(songinfo.getAuthor());
                music.setSongLrc(songinfo.getLrclink().getLrcContent());
                music.setAlbum(songinfo.getAlbum_title());
                music.setPic_small(songinfo.getPic_small());
                music.setCoverPath(songinfo.getPic_huge());
                music.setPath(musicData.getFile_link());
                music.setDuration(musicData.getFile_duration() * 1000);
            }

            @Override
            public void onCompleted() {

            }
        });
        return music;
    }

    private void getSongDetail(final String songId, int position) {
        if (null != mMusicList && position < mMusicList.size() - 1) {//TODO
            if (songId.equals(mMusicList.get(position))) {
                Preferences.savePlayMode(PlayModeEnum.LOOP.value());
                AppCache.getPlayService().play(mMusicList.get(position));
            }
        }
        DataManager.getInstance(this).RequestHttp(NetApi.getSongDetails(DataManager.getMd5Str("SONGPLAY"), songId), new ResultListener<MusicSongDetailsModel>() {
            @Override
            public void responseSuccess(MusicSongDetailsModel obj) {
                MusicSongDetailsModel.PdBean.BitrateBean musicData = obj.getPd().getBitrate();
                MusicSongDetailsModel.PdBean.SonginfoBean songinfo = obj.getPd().getSonginfo();
                Music music = new Music();
                music.setSongId(songId);
                music.setType(Music.Type.ONLINE);
                music.setTitle(songinfo.getTitle());
                music.setArtist(songinfo.getAuthor());
                music.setSongLrc(songinfo.getLrclink().getLrcContent());
                music.setAlbum(songinfo.getAlbum_title());
                music.setPic_small(songinfo.getPic_small());
                music.setCoverPath(songinfo.getPic_huge());
                music.setPath(musicData.getFile_link());
                music.setDuration(musicData.getFile_duration() * 1000);
                Preferences.savePlayMode(PlayModeEnum.LOOP.value());
                if (null == musicData.getFile_link()) {
                    UIUtils.showToast("歌曲解析错误");
                    return;
                }
                AppCache.getPlayService().play(music);
                UIUtils.showToast("开始播放");
                //showPlayingFragment();
                //TODO
//                onChangeImpl(getPlayService().getPlayingMusic());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDjData() {
        setTopBg(djData.getThumb(), "电台");
        DataManager.getInstance(this).RequestHttp(NetApi.getMusicDjSongList(DataManager.getMd5Str("CANNELSONG"), djData.getCh_name()), new ResultListener<MusicDetailListModel>() {
            @Override
            public void responseSuccess(MusicDetailListModel obj) {
                if (null != obj && null != obj.getPd()) {
                    listDjData = obj.getPd().getResult().getSonglist();
                    setDjData();
                    switchLoopData("4");
                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //    @Override
    public void bindServerCompleted() {
        getPlayService().setOnPlayEventListener(this);
        onChangeImpl(getPlayService().getPlayingMusic());

    }


    @Override
    public void onChange(Music music) {
        LogUtils.i("", "+++++++onChange+++++++++");
        onChangeImpl(music);
        if (mPlayFragment != null && mPlayFragment.isAdded()) {
            mPlayFragment.onChange(music);
        }
    }

    @Override
    public void onPlayerStart() {
        ivPlayBarPlay.setSelected(true);
        if (mPlayFragment != null && mPlayFragment.isAdded()) {
            mPlayFragment.onPlayerStart();
        }
    }

    @Override
    public void onPlayerPause() {
        ivPlayBarPlay.setSelected(false);
        if (mPlayFragment != null && mPlayFragment.isAdded()) {
            mPlayFragment.onPlayerPause();
        }
    }

    /**
     * 更新播放进度
     */
    @Override
    public void onPublish(int progress) {
        mProgressBar.setProgress(progress);
        if (mPlayFragment != null && mPlayFragment.isAdded()) {
            mPlayFragment.onPublish(progress);
        }
    }

    @Override
    public void onBufferingUpdate(int percent) {
        if (mPlayFragment != null && mPlayFragment.isAdded()) {
            mPlayFragment.onBufferingUpdate(percent);
        }
    }

    @Override
    public void onMusicListUpdate() {
        //TODO
    }


    private void onChangeImpl(Music music) {
        if (music == null) {
            return;
        }
        tvPlayBarTitle.setText(music.getTitle());
        tvPlayBarArtist.setText(music.getArtist());
        ivPlayBarPlay.setSelected(getPlayService().isPlaying() || getPlayService().isPreparing());
        mProgressBar.setMax((int) music.getDuration());
        mProgressBar.setProgress((int) getPlayService().getCurrentPosition());
        setPlayBarCover(music);

    }

    private void setPlayBarCover(final Music music) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BitmapUtils.getbitmapByUrl(music.getPic_small(), new BitmapListener() {
                    @Override
                    public void bitmapListener(Bitmap bitmap) {
                        final Message msg = Message.obtain();
                        if (null == bitmap) {
                            msg.what = 0;
                            msg.obj = null;
                        } else {
                            msg.what = 1;
                            msg.obj = bitmap;
                        }
                        myHandler.sendMessage(msg);
                    }
                });
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    private Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    ivPlayBarCover.setImageBitmap((Bitmap) msg.obj);
                    break;
                case 0:
                    ivPlayBarCover.setImageBitmap(null);
                    break;
                default:
                    ivPlayBarCover.setImageBitmap(null);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void play() {
        getPlayService().playPause();
    }

    private void next() {
        getPlayService().next();
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


    @OnClick({R.id.iv_play_bar_play, R.id.fl_play_bar, R.id.play_random})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fl_play_bar:
                showPlayingFragment();
                break;
            case R.id.iv_play_bar_play:
                play();
                break;
            case R.id.iv_play_bar_next:
                next();
                break;
            case R.id.play_random:
                Preferences.savePlayMode(PlayModeEnum.SHUFFLE.value());

                if (null != mMusicList && mMusicList.size() > 0) {
                    AppCache.getPlayService().play(mMusicList.get(0));
                    showPlayingFragment();
                } else {
                    return;
                }
                break;
        }
    }
}
