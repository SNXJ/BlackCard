package com.zsh.blackcard.aliLive;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alivc.player.AliVcMediaPlayer;
import com.alivc.player.MediaPlayer;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.LiveChatAdapter;
import com.zsh.blackcard.adapter.LiveViewerAdapter;
import com.zsh.blackcard.custom.KeyboardStatusDetector;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.model.LiveChatModel;
import com.zsh.blackcard.utils.CharUtils;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.view.GiftItemView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tyrantgit.widget.HeartLayout;


/**
 * Name: AliLivePlayActivity
 * Author: Shing
 * Date: 2018/1/22 下午2:25
 * Description: ..
 */

public class AliLivePlayActivity extends BaseAliLiveActivity {
    @BindView(R.id.im_live_head)
    ImageView imLiveHead;
    @BindView(R.id.im_name)
    TextView imName;
    @BindView(R.id.im_num)
    TextView imNum;
    @BindView(R.id.viewer_recycler_view)
    RecyclerView viewerRecyclerView;
    @BindView(R.id.chat_recycler_view)
    RecyclerView chat_recycler_view;
    @BindView(R.id.gift_item_view)
    GiftItemView giftItemView;
    @BindView(R.id.heart_layout)
    HeartLayout heartLayout;
    @BindView(R.id.chat)
    ImageView chat;
    @BindView(R.id.im_share)
    ImageView imShare;
    @BindView(R.id.im_heart)
    ImageView imHeart;
    @BindView(R.id.im_gif)
    ImageView imGif;
    @BindView(R.id.rl_buttom)
    RelativeLayout rlButtom;
    @BindView(R.id.send_edit)
    EditText sendEdit;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.layout_send_message)
    LinearLayout layoutSendMessage;
    @BindView(R.id.rl_root)
    RelativeLayout rootView;

    @BindView(R.id.surfaceView)
    SurfaceView mSurfaceView;

    private AliVcMediaPlayer mPlayer;
    private String TAG = "++++++++AliLivePlayActivity+++++++++++";

    private String mUrl;
    private LiveViewerAdapter viewerAdapter;
    private LiveChatAdapter liveChatAdapter;


    private Random mRandom;

    @Override
    protected void initView() {
        setContentView(R.layout.alilive_play_activity);
        ButterKnife.bind(this);

    }

    @Override
    protected void initData() {
        mSurfaceView.getHolder().addCallback(callback);

        initVodPlayer();
        setPlaySource();
        replay();
        initTempDate();

    }

    SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        public void surfaceCreated(SurfaceHolder holder) {
            holder.setType(SurfaceHolder.SURFACE_TYPE_GPU);
            holder.setKeepScreenOn(true);

            // 对于从后台切换到前台,需要重设surface;部分手机锁屏也会做前后台切换的处理
            if (mPlayer != null) {
                mPlayer.setVideoSurface(mSurfaceView.getHolder().getSurface());
            }

            Log.d(TAG, "AlivcPlayeron SurfaceCreated over.");
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
            Log.d(TAG, "onSurfaceChanged is valid ? " + holder.getSurface().isValid());
            if (mPlayer != null)
                mPlayer.setSurfaceChanged();
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            Log.d(TAG, "onSurfaceDestroy.");
        }
    };

    private void initVodPlayer() {
        mPlayer = new AliVcMediaPlayer(this, mSurfaceView);
        mPlayer.setPreparedListener(new MyPreparedListener(this));
        mPlayer.setFrameInfoListener(new MyFrameInfoListener(this));
        mPlayer.setErrorListener(new MyErrorListener(this));
        mPlayer.setCompletedListener(new MyPlayerCompletedListener(this));
        mPlayer.setSeekCompleteListener(new MySeekCompleteListener(this));
        mPlayer.setStoppedListener(new MyStoppedListener(this));
        mPlayer.enableNativeLog();
    }


    private static class MyErrorListener implements MediaPlayer.MediaPlayerErrorListener {

        private WeakReference<AliLivePlayActivity> activityWeakReference;

        public MyErrorListener(AliLivePlayActivity activity) {
            activityWeakReference = new WeakReference<AliLivePlayActivity>(activity);
        }

        @Override
        public void onError(int i, String s) {
            LogUtils.i("+++++++onError++++++++", i + "+++++++++++++++" + s);

//            AliLivePlayActivity activity = activityWeakReference.get();
//            if (activity != null) {
//                activity.onError(i, s);
//            }
        }
    }

    private void onError(int i, String msg) {
        Toast.makeText(AliLivePlayActivity.this.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private static class MyPreparedListener implements MediaPlayer.MediaPlayerPreparedListener {

        private WeakReference<AliLivePlayActivity> activityWeakReference;

        public MyPreparedListener(AliLivePlayActivity activity) {
            activityWeakReference = new WeakReference<AliLivePlayActivity>(activity);
        }

        @Override
        public void onPrepared() {
            AliLivePlayActivity activity = activityWeakReference.get();
            if (activity != null) {
                activity.onPrepared();
            }
        }

    }

    void onPrepared() {

        LogUtils.i("+++++++onPrepared+++++++", "onPrepared--- ");
        Toast.makeText(AliLivePlayActivity.this.getApplicationContext(), "准备成功", Toast.LENGTH_SHORT).show();

    }

    private static class MyStoppedListener implements MediaPlayer.MediaPlayerStoppedListener {

        private WeakReference<AliLivePlayActivity> activityWeakReference;

        public MyStoppedListener(AliLivePlayActivity activity) {
            activityWeakReference = new WeakReference<AliLivePlayActivity>(activity);
        }


        @Override
        public void onStopped() {
            AliLivePlayActivity activity = activityWeakReference.get();
            if (activity != null) {
                activity.onStopped();
            }
        }
    }

    void onStopped() {

    }

    private static class MySeekCompleteListener implements MediaPlayer.MediaPlayerSeekCompleteListener {


        private WeakReference<AliLivePlayActivity> activityWeakReference;

        public MySeekCompleteListener(AliLivePlayActivity activity) {
            activityWeakReference = new WeakReference<AliLivePlayActivity>(activity);
        }

        @Override
        public void onSeekCompleted() {
            AliLivePlayActivity activity = activityWeakReference.get();
            if (activity != null) {
                activity.onSeekCompleted();
            }
        }
    }

    void onSeekCompleted() {

        LogUtils.i("+++++++onSeekCompleted+++++++", "onSeekCompleted--- ");

    }

    private static class MyPlayerCompletedListener implements MediaPlayer.MediaPlayerCompletedListener {

        private WeakReference<AliLivePlayActivity> activityWeakReference;

        public MyPlayerCompletedListener(AliLivePlayActivity activity) {
            activityWeakReference = new WeakReference<AliLivePlayActivity>(activity);
        }

        @Override
        public void onCompleted() {
            AliLivePlayActivity activity = activityWeakReference.get();
            if (activity != null) {
                activity.onCompleted();
            }
        }

    }

    private void onCompleted() {
        LogUtils.i("+++++++onCompleted+++++++", "onCompleted--- ");

        finish();
//        isCompleted = true;
    }

    private static class MyFrameInfoListener implements com.alivc.player.MediaPlayer.MediaPlayerFrameInfoListener {

        private WeakReference<AliLivePlayActivity> activityWeakReference;

        public MyFrameInfoListener(AliLivePlayActivity activity) {
            activityWeakReference = new WeakReference<AliLivePlayActivity>(activity);
        }

        @Override
        public void onFrameInfoListener() {
            AliLivePlayActivity activity = activityWeakReference.get();
            if (activity != null) {
//                activity.onFrameInfoListener();
            }
        }
    }


    private void setPlaySource() {
        mUrl = getIntent().getStringExtra("data");

        if (null != mUrl) {

            finish();
        }
    }


    private void start() {

        if (mPlayer != null) {
            mPlayer.prepareAndPlay(mUrl);
        }
    }

    private void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
        }
    }

    private void stop() {
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }

    private void resume() {
        if (mPlayer != null) {
            mPlayer.play();
        }
    }

    private void destroy() {
        if (mPlayer != null) {
            mPlayer.stop();
            mPlayer.destroy();
        }
    }

    private void replay() {
        stop();
        start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        heartHandler.postDelayed(heartRunnable, 1000);

    }

    @Override
    protected void onStop() {
        super.onStop();

        savePlayerState();
    }

    private void savePlayerState() {
        if (mPlayer.isPlaying()) {

            // 不可见，暂停播放器
            pause();
        }
    }

    @Override
    protected void onDestroy() {
        stop();
        destroy();
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }


    List<Integer> viewList = new ArrayList<>();
    List<LiveChatModel> chatList = new ArrayList<>();


    public void initTempDate() {


        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        viewerRecyclerView.setLayoutManager(llm);
        viewList.add(R.mipmap.room_image_3);
        viewList.add(R.mipmap.room_image_4);
        viewList.add(R.mipmap.room_image_5);
        viewList.add(R.mipmap.room_image_1);
//        viewList.add(R.mipmap.room_image_1);
//        viewList.add(R.mipmap.room_image_1);
//        viewList.add(R.mipmap.room_image_1);
        viewerAdapter = new LiveViewerAdapter(viewList);
        viewerRecyclerView.setAdapter(viewerAdapter);
//聊天
        mRandom = new Random();

        for (int i = 0; i < 3; i++) {//模拟数据
            LiveChatModel m = new LiveChatModel();

            m.name = CharUtils.getRandomString(8);
            m.level = (int) (Math.random() * 100 + 1);
//            m.color = randomColor();
            m.message = CharUtils.getRandomString(20);
            chatList.add(m);
        }
        chat_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        liveChatAdapter = new LiveChatAdapter(chatList);
        chat_recycler_view.setAdapter(liveChatAdapter);


        handler.postDelayed(runnable, 1000);

        initKeyBoard();

    }


    @OnClick({R.id.im_live_head, R.id.gift_item_view, R.id.chat, R.id.im_share, R.id.im_heart, R.id.im_gif, R.id.tv_send, R.id.im_live_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_live_head:
                break;
            case R.id.gift_item_view:
                break;
            case R.id.chat:
                layoutSendMessage.setVisibility(View.VISIBLE);
                rlButtom.setVisibility(View.GONE);
                sendEdit.requestFocus();
                InputMethodManager inputManager =
                        (InputMethodManager) sendEdit.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(sendEdit, 0);
                break;
            case R.id.im_share:
                PublicDialog.shareDialog(this);
                break;
            case R.id.im_heart:
                PublicDialog.liveDialog(this);
                break;
            case R.id.im_gif:

                break;
            case R.id.im_live_close:
                finish();

                break;

        }
    }


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (chatList != null) {
                LiveChatModel m = new LiveChatModel();

                m.name = CharUtils.getRandomString(8);
                m.level = (int) (Math.random() * 100 + 1);
                m.message = CharUtils.getRandomString(20);
                chatList.add(m);
                liveChatAdapter.notifyDataSetChanged();
                chat_recycler_view.scrollToPosition(liveChatAdapter.getItemCount() - 1);
//
            }
            handler.postDelayed(this, 1000);
        }
    };
    Handler heartHandler = new Handler();
    Runnable heartRunnable = new Runnable() {
        @Override
        public void run() {
            heartLayout.post(new Runnable() {
                @Override
                public void run() {
                    heartLayout.addHeart(randomColor());
                }
            });
            heartHandler.postDelayed(this, 1000);
        }
    };


    public void setSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
    }

    @Override
    public void onPause() {
        super.onPause();
        heartHandler.removeCallbacks(heartRunnable);
    }


    private int randomColor() {
        return Color.rgb(mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }


    /**
     * 键盘监听
     */
    private void initKeyBoard() {
        new KeyboardStatusDetector()
                .registerView(rootView)
                .setVisibilityListener(new KeyboardStatusDetector.KeyboardVisibilityListener() {
                    @Override
                    public void onVisibilityChanged(boolean keyboardVisible) {

                        if (keyboardVisible) {
                            layoutSendMessage.setVisibility(View.VISIBLE);
                            rlButtom.setVisibility(View.GONE);
                        } else {
                            layoutSendMessage.setVisibility(View.GONE);
                            rlButtom.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }

}
