package com.zsh.blackcard.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.music.model.Music;
import com.zsh.blackcard.music.service.OnPlayerEventListener;
import com.zsh.blackcard.music.service.PlayService;
import com.zsh.blackcard.music.untils.Actions;
import com.zsh.blackcard.music.untils.AppCache;
import com.zsh.blackcard.music.untils.CoverLoader;
import com.zsh.blackcard.music.untils.FileUtils;
import com.zsh.blackcard.music.untils.PlayModeEnum;
import com.zsh.blackcard.music.untils.Preferences;
import com.zsh.blackcard.music.untils.ScreenUtils;
import com.zsh.blackcard.music.untils.SystemUtils;
import com.zsh.blackcard.music.widget.AlbumCoverView;
import com.zsh.blackcard.music.widget.IndicatorLayout;
import com.zsh.blackcard.untils.UIUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.wcy.lrcview.LrcView;

/**
 * Name: PlayFragment
 * Author: SNXJ
 * Date: 2017-12-08
 * Description:描述：
 */
public class PlayFragment extends BaseFragment implements View.OnClickListener,
        ViewPager.OnPageChangeListener, SeekBar.OnSeekBarChangeListener, OnPlayerEventListener,
        LrcView.OnPlayClickListener {
    protected Handler mHandler = new Handler(Looper.getMainLooper());

    @BindView(R.id.ll_content)
    LinearLayout llContent;
    @BindView(R.id.iv_play_page_bg)
    ImageView ivPlayingBg;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_artist)
    TextView tvArtist;
    @BindView(R.id.vp_play_page)
    ViewPager vpPlay;
    @BindView(R.id.il_indicator)
    IndicatorLayout ilIndicator;
    @BindView(R.id.sb_progress)
    SeekBar sbProgress;
    @BindView(R.id.tv_current_time)
    TextView tvCurrentTime;
    @BindView(R.id.tv_total_time)
    TextView tvTotalTime;
    @BindView(R.id.iv_mode)
    ImageView ivMode;
    @BindView(R.id.iv_play)
    ImageView ivPlay;
    @BindView(R.id.iv_next)
    ImageView ivNext;
    @BindView(R.id.iv_prev)
    ImageView ivPrev;
    private AlbumCoverView mAlbumCoverView;
    private LrcView mLrcViewSingle;
    private LrcView mLrcViewFull;
    private SeekBar sbVolume;

    private AudioManager mAudioManager;
    private List<View> mViewPagerContent;
    private int mLastProgress;
    private boolean isDraggingProgress;

    @Override
    public void initDate(Bundle savedInstanceState) {

    }


    @Override
    public View initView(LayoutInflater inflater) {
        ButterKnife.bind(getActivity());
        return View.inflate(getActivity(), R.layout.fragment_play, null);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //  initSystemBar();
        initViewPager();
        ilIndicator.create(mViewPagerContent.size());
        initPlayMode();
        onChangeImpl(getPlayService().getPlayingMusic());

        getPlayService().setOnPlayEventListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(Actions.VOLUME_CHANGED_ACTION);
        getContext().registerReceiver(mVolumeReceiver, filter);
    }

    protected PlayService getPlayService() {
        PlayService playService = AppCache.getPlayService();
        if (playService == null) {
            //  throw new NullPointerException("play service is null");
        }
        return playService;
    }

    @Override
    public void onStart() {
        super.onStart();
        ivBack.setOnClickListener(this);
        ivMode.setOnClickListener(this);
        ivPlay.setOnClickListener(this);
        ivPrev.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        sbProgress.setOnSeekBarChangeListener(this);
        sbVolume.setOnSeekBarChangeListener(this);
        vpPlay.addOnPageChangeListener(this);
    }

    /**
     * 沉浸式状态栏
     */
    private void initSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ScreenUtils.init(getActivity());
            int top = ScreenUtils.getStatusBarHeight();
            llContent.setPadding(0, top, 0, 0);
        }
    }

    private void initViewPager() {
        View coverView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_play_page_cover, null);
        View lrcView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_play_page_lrc, null);
        mAlbumCoverView = (AlbumCoverView) coverView.findViewById(R.id.album_cover_view);
        mLrcViewSingle = (LrcView) coverView.findViewById(R.id.lrc_view_single);
        mLrcViewFull = (LrcView) lrcView.findViewById(R.id.lrc_view_full);
        sbVolume = (SeekBar) lrcView.findViewById(R.id.sb_volume);
        mAlbumCoverView.initNeedle(getPlayService().isPlaying());
        mLrcViewFull.setOnPlayClickListener(this);
        initVolume();

        mViewPagerContent = new ArrayList<>(2);
        mViewPagerContent.add(coverView);
        mViewPagerContent.add(lrcView);
        vpPlay.setAdapter(new PlayPagerAdapter(mViewPagerContent));
    }

    private void initVolume() {
        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
        sbVolume.setMax(mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        sbVolume.setProgress(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
    }

    private void initPlayMode() {
        int mode = Preferences.getPlayMode();
        ivMode.setImageLevel(mode);
    }

    @Override
    public void onChange(Music music) {
        onChangeImpl(music);
    }

    @Override
    public void onPlayerStart() {
        ivPlay.setSelected(true);
        mAlbumCoverView.start();
    }

    @Override
    public void onPlayerPause() {
        ivPlay.setSelected(false);
        mAlbumCoverView.pause();
    }

    /**
     * 更新播放进度
     */
    @Override
    public void onPublish(int progress) {
        if (!isDraggingProgress) {
            sbProgress.setProgress(progress);
        }

        if (mLrcViewSingle.hasLrc()) {
            mLrcViewSingle.updateTime(progress);
            mLrcViewFull.updateTime(progress);
        }
    }

    @Override
    public void onBufferingUpdate(int percent) {
        sbProgress.setSecondaryProgress(sbProgress.getMax() * 100 / percent);
    }

    @Override
    public void onTimer(long remain) {
    }

    @Override
    public void onMusicListUpdate() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_mode:
                switchPlayMode();
                break;
            case R.id.iv_play:
                play();
                break;
            case R.id.iv_next:
                next();
                break;
            case R.id.iv_prev:
                prev();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        ilIndicator.setCurrent(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == sbProgress) {
            if (Math.abs(progress - mLastProgress) >= DateUtils.SECOND_IN_MILLIS) {
                tvCurrentTime.setText(formatTime(progress));
                mLastProgress = progress;
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar == sbProgress) {
            isDraggingProgress = true;
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar == sbProgress) {
            isDraggingProgress = false;
            if (getPlayService().isPlaying() || getPlayService().isPausing()) {
                int progress = seekBar.getProgress();
                getPlayService().seekTo(progress);

                if (mLrcViewSingle.hasLrc()) {
                    mLrcViewSingle.updateTime(progress);
                    mLrcViewFull.updateTime(progress);
                }
            } else {
                seekBar.setProgress(0);
            }
        } else if (seekBar == sbVolume) {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, seekBar.getProgress(),
                    AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        }
    }

    @Override
    public boolean onPlayClick(long time) {
        if (getPlayService().isPlaying() || getPlayService().isPausing()) {
            getPlayService().seekTo((int) time);
            if (getPlayService().isPausing()) {
                getPlayService().playPause();
            }
            return true;
        }
        return false;
    }

    private void onChangeImpl(Music music) {
        if (music == null) {
            return;
        }

        tvTitle.setText(music.getTitle());
        tvArtist.setText(music.getArtist());
        sbProgress.setProgress((int) getPlayService().getCurrentPosition());
        sbProgress.setSecondaryProgress(0);
        sbProgress.setMax((int) music.getDuration());
        mLastProgress = 0;
        tvCurrentTime.setText("00:00");
        tvTotalTime.setText(formatTime(music.getDuration()));
        setCoverAndBg(music);
        setLrc(music);
        if (getPlayService().isPlaying() || getPlayService().isPreparing()) {
            ivPlay.setSelected(true);
            mAlbumCoverView.start();
        } else {
            ivPlay.setSelected(false);
            mAlbumCoverView.pause();
        }
    }

    private void play() {
        getPlayService().playPause();
    }

    private void next() {
        getPlayService().next();
    }

    private void prev() {
        getPlayService().prev();
    }

    private void switchPlayMode() {
        PlayModeEnum mode = PlayModeEnum.valueOf(Preferences.getPlayMode());
        switch (mode) {
            case LOOP:
                mode = PlayModeEnum.SHUFFLE;
                UIUtils.showToast("随机播放");
                break;
            case SHUFFLE:
                mode = PlayModeEnum.SINGLE;
                UIUtils.showToast("单曲循环");
                break;
            case SINGLE:
                mode = PlayModeEnum.LOOP;
                UIUtils.showToast("列表循环");
                break;
        }
        Preferences.savePlayMode(mode.value());
        initPlayMode();
    }

    private void onBackPressed() {
        getActivity().onBackPressed();
        ivBack.setEnabled(false);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ivBack.setEnabled(true);
            }
        }, 300);
    }

    private void setCoverAndBg(final Music music) {
        mAlbumCoverView.setCoverBitmap(CoverLoader.getInstance().loadRound(music));
        ivPlayingBg.setImageBitmap(CoverLoader.getInstance().loadBlur(music));
    }

    private void setLrc(final Music music) {
        if (music.getType() == Music.Type.LOCAL) {
            String lrcPath = FileUtils.getLrcFilePath(music);
            if (!TextUtils.isEmpty(lrcPath)) {
                loadLrc(lrcPath);
//            } else {
//                new SearchLrc(music.getArtist(), music.getTitle()) {
//                    @Override
//                    public void onPrepare() {
//                        // 设置tag防止歌词下载完成后已切换歌曲
//                        vpPlay.setTag(music);
//
//                        loadLrc("");
//                        setLrcLabel("正在搜索歌词");
//                    }
//
//                    @Override
//                    public void onExecuteSuccess(@NonNull String lrcPath) {
//                        if (vpPlay.getTag() != music) {
//                            return;
//                        }
//
//                        // 清除tag
//                        vpPlay.setTag(null);
//
//                        loadLrc(lrcPath);
//                        setLrcLabel("暂无歌词");
//                    }
//
//                    @Override
//                    public void onExecuteFail(Exception e) {
//                        if (vpPlay.getTag() != music) {
//                            return;
//                        }
//
//                        // 清除tag
//                        vpPlay.setTag(null);
//
//                        setLrcLabel("暂无歌词");
//                    }
//                }.execute();
            }
        } else {
            String lrcPath = FileUtils.getLrcDir() + FileUtils.getLrcFileName(music.getArtist(), music.getTitle());
            loadLrc(lrcPath);
        }
    }

    private void loadLrc(String path) {
        File file = new File(path);
        mLrcViewSingle.loadLrc(file);
        mLrcViewFull.loadLrc(file);
    }

    private void setLrcLabel(String label) {
        mLrcViewSingle.setLabel(label);
        mLrcViewFull.setLabel(label);
    }

    private String formatTime(long time) {
        return SystemUtils.formatTime("mm:ss", time);
    }

    private BroadcastReceiver mVolumeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            sbVolume.setProgress(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        }
    };

    @Override
    public void onDestroy() {
        getContext().unregisterReceiver(mVolumeReceiver);
        super.onDestroy();
    }

    /**
     * 正在播放ViewPager适配器，包含歌词和封面
     */
    public class PlayPagerAdapter extends PagerAdapter {
        private List<View> mViews;

        public PlayPagerAdapter(List<View> views) {
            mViews = views;
        }

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViews.get(position));
            return mViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }
    }
}
