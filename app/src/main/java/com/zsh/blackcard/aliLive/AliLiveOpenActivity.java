package com.zsh.blackcard.aliLive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AlertDialog;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alivc.live.pusher.AlivcBeautyLevelEnum;
import com.alivc.live.pusher.AlivcFpsEnum;
import com.alivc.live.pusher.AlivcLivePushConfig;
import com.alivc.live.pusher.AlivcLivePushStatsInfo;
import com.alivc.live.pusher.AlivcLivePusher;
import com.alivc.live.pusher.AlivcPreviewOrientationEnum;
import com.alivc.live.pusher.AlivcQualityModeEnum;
import com.alivc.live.pusher.AlivcResolutionEnum;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LivePushModel;
import com.zsh.blackcard.utils.NetWorkUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.alivc.live.pusher.AlivcPreviewOrientationEnum.ORIENTATION_LANDSCAPE_HOME_LEFT;
import static com.alivc.live.pusher.AlivcPreviewOrientationEnum.ORIENTATION_LANDSCAPE_HOME_RIGHT;
import static com.alivc.live.pusher.AlivcPreviewOrientationEnum.ORIENTATION_PORTRAIT;

/**
 * Name: AliLiveOpenActivity
 * Author: Shing
 * Date: 2018/1/17 上午10:07
 * Description: ..
 */

public class AliLiveOpenActivity extends BaseAliLiveActivity {
    public enum SurfaceStatus {
        UNINITED, CREATED, CHANGED, DESTROYED, RECREATED
    }

    @BindView(R.id.preview_view)
    SurfaceView mPreviewView;
    @BindView(R.id.im_close)
    ImageView imClose;
    @BindView(R.id.im_location)
    ImageView imLocation;
    @BindView(R.id.im_switch)
    ImageView imSwitch;
    @BindView(R.id.et_edit_title)
    EditText etEditTitle;
    @BindView(R.id.ll_beautiful)
    LinearLayout llBeautiful;
    @BindView(R.id.btn_open)
    Button btnOpen;
    @BindView(R.id.tv_xieyi)
    TextView tvXieyi;
    @BindView(R.id.main_content)
    FrameLayout mainContent;

    @Override
    protected void initView() {

//        mPushUrl = getIntent().getStringExtra(URL_KEY);
//        mAsync = getIntent().getBooleanExtra(ASYNC_KEY, false);
//        mAudioOnly = getIntent().getBooleanExtra(AUDIO_ONLY_KEY, false);
//        mVideoOnly = getIntent().getBooleanExtra(VIDEO_ONLY_KEY, false);
//        mOrientation = getIntent().getIntExtra(ORIENTATION_KEY, ORIENTATION_PORTRAIT.ordinal());
//        mCameraId = getIntent().getIntExtra(CAMERA_ID, Camera.CameraInfo.CAMERA_FACING_FRONT);
//        mFlash = getIntent().getBooleanExtra(FLASH_ON, false);

        setOrientation(mOrientation);
        setContentView(R.layout.alilive_open_activity);
        ButterKnife.bind(this);
        mAlivcLivePushConfig= new AlivcLivePushConfig();

//        mPreviewView = (SurfaceView) findViewById(R.id.preview_view);
        mPreviewView.getHolder().addCallback(mCallback);

//        mAlivcLivePushConfig = (AlivcLivePushConfig) getIntent().getSerializableExtra(AlivcLivePushConfig.Config);
        mAlivcLivePusher = new AlivcLivePusher();

        setmAlivcLivePushConfig();

        try {
//            mAlivcLivePusher.init(getApplicationContext(), mAlivcLivePushConfig);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            showDialog(this, e.getMessage());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            showDialog(this, e.getMessage());
        }

//        mLivePushFragment = new LivePushFragment().newInstance(mPushUrl, mAsync, mAudioOnly, mVideoOnly, mCameraId, mFlash, mAlivcLivePushConfig.getQualityMode().getQualityMode());
//        mLivePushFragment.setAlivcLivePusher(mAlivcLivePusher);
//        mLivePushFragment.setStateListener(mStateListener);
//        mPushTextStatsFragment = new PushTextStatsFragment();
//        mPushDiagramStatsFragment = new PushDiagramStatsFragment();
//        if (mAsync) {
//            mAlivcLivePusher.startPreviewAysnc(mPreviewView);
//        } else {
//            mAlivcLivePusher.startPreview(mPreviewView);
//        }

        initViewPager();
        mScaleDetector = new ScaleGestureDetector(getApplicationContext(), mScaleGestureDetector);
        mDetector = new GestureDetector(getApplicationContext(), mGestureDetector);
        mNetWork = NetWorkUtils.getAPNType(this);
    }

    @Override
    protected void initData() {


    }
    /**
     * temp
     */
    public void setmAlivcLivePushConfig() {
        mAlivcLivePushConfig.setResolution(AlivcResolutionEnum.RESOLUTION_540P);//分辨率540P，最大支持720P，兼容V1.3.0版1080P
        /**
         * AlivcQualityModeEnum.QM_RESOLUTION_FIRST 清晰度优先
         * AlivcQualityModeEnum.QM_FLUENCY_FIRST 流畅度优先
         * AlivcQualityModeEnum.QM_CUSTOM 自定义
         */
        mAlivcLivePushConfig.setQualityMode(AlivcQualityModeEnum.QM_RESOLUTION_FIRST);
        mAlivcLivePushConfig.setTargetVideoBitrate(1200); //目标码率1200Kbps
        mAlivcLivePushConfig.setMinVideoBitrate(400); //最小码率400Kbps
        mAlivcLivePushConfig.setInitialVideoBitrate(900); //初始码率900Kbps
        mAlivcLivePushConfig.setBeautyOn(true); //关闭美颜
        /**
         * AlivcBeautyLevelEnum.BEAUTY_Normal 标准版
         * AlivcBeautyLevelEnum.BEAUTY_Professional 专业版
         */
        mAlivcLivePushConfig.setBeautyLevel(AlivcBeautyLevelEnum.BEAUTY_Professional);

        // 美白范围0-100
        mAlivcLivePushConfig.setBeautyWhite(70);
// 磨皮范围0-100
        mAlivcLivePushConfig.setBeautyBuffing(40);
// 红润设置范围0-100
        mAlivcLivePushConfig.setBeautyRuddy(40);

// 瘦脸设置范围0-100
        mAlivcLivePushConfig.setBeautyThinFace(40);
// 大眼设置范围0-100
        mAlivcLivePushConfig.setBeautyBigEye(30);
// 收下巴设置范围0-100
        mAlivcLivePushConfig.setBeautyShortenFace(50);
// 腮红设置范围0-100
        mAlivcLivePushConfig.setBeautyCheekPink(15);

        mAlivcLivePushConfig.setPreviewOrientation(AlivcPreviewOrientationEnum.ORIENTATION_PORTRAIT);//竖屏推流
        mAlivcLivePushConfig.setFps(AlivcFpsEnum.FPS_20); //帧率20
        /**
         * 添加水印，起点位置坐标x[0,width) y[0,height)，宽度(0,width]，最多添加3个
         *
         * @param path 水印图片
         * @param x      水印左上角x轴位置 相对位置 0～1
         * @param y      水印右上角y轴位置 相对位置 0～1
         * @param width  水印显示宽度 相对位置 0～1
         */
//        mAlivcLivePushConfig.addWaterMark(waterPath, 0.2, 0.2, 0.3);
        /**
         * AlivcAudioAACProfileEnum.AAC_LC
         * AlivcAudioAACProfileEnum.HE_AAC
         * AlivcAudioAACProfileEnum.HE_AAC_v2
         * AlivcAudioAACProfileEnum.AAC_LD
         */
//        mAlivcLivePushConfig.setAudioProfile(AlivcAudioAACProfileEnum.AlivcAudioAACProfileEnum.AAC_LC);


    }

    private void getPushUrl() {
        DataManager.getInstance(this).RequestHttp(NetApi.getPushUrl(DataManager.getMd5Str("PUSHADDRESS"), BaseApplication.getHonouruserId(),""), new ResultListener<LivePushModel>() {
            @Override
            public void responseSuccess(LivePushModel obj) {


            }

            @Override
            public void onCompleted() {

            }
        });

    }


    @OnClick({R.id.im_close, R.id.im_location, R.id.im_switch, R.id.ll_beautiful, R.id.btn_open, R.id.tv_xieyi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_close:
                break;
            case R.id.im_location:
                break;
            case R.id.im_switch:
                break;
            case R.id.ll_beautiful:
                break;
            case R.id.btn_open:
                break;
            case R.id.tv_xieyi:
                break;
        }
    }

    private static final String TAG = "LivePushActivity";
    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;
    private final long REFRESH_INTERVAL = 1000;
    private static final String URL_KEY = "url_key";
    private static final String ASYNC_KEY = "async_key";
    private static final String AUDIO_ONLY_KEY = "audio_only_key";
    private static final String VIDEO_ONLY_KEY = "video_only_key";
    private static final String ORIENTATION_KEY = "orientation_key";
    private static final String CAMERA_ID = "camera_id";
    private static final String FLASH_ON = "flash_on";
    public static final int REQ_CODE_PUSH = 0x1112;

//    public SurfaceView mPreviewView;
//    private ViewPager mViewPager;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;

    private GestureDetector mDetector;
    private ScaleGestureDetector mScaleDetector;
    //    private LivePushFragment mLivePushFragment;
//    private PushTextStatsFragment mPushTextStatsFragment;
//    private PushDiagramStatsFragment mPushDiagramStatsFragment;
    private AlivcLivePushConfig mAlivcLivePushConfig;

    private AlivcLivePusher mAlivcLivePusher = null;
    private String mPushUrl = null;

    private boolean mAsync = false;
    private boolean mAudioOnly = false;
    private boolean mVideoOnly = false;
    private int mOrientation = ORIENTATION_PORTRAIT.ordinal();

    private SurfaceStatus mSurfaceStatus = SurfaceStatus.UNINITED;
    //    private Handler mHandler = new Handler();
    private boolean isPause = false;

    private int mCameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;
    private boolean mFlash = false;
    AlivcLivePushStatsInfo alivcLivePushStatsInfo = null;

//    private ConnectivityChangedReceiver mChangedReceiver = new ConnectivityChangedReceiver();

    private int mNetWork = 0;



    private void initViewPager() {
//        mViewPager = (ViewPager) findViewById(R.id.tv_pager);
//        mFragmentList.add(mPushTextStatsFragment);
//        mFragmentList.add(mLivePushFragment);
//        mFragmentList.add(mPushDiagramStatsFragment);
//        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
//        mViewPager.setAdapter(mFragmentAdapter);

    }

    private void setOrientation(int orientation) {
        if (orientation == ORIENTATION_PORTRAIT.ordinal()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else if (orientation == ORIENTATION_LANDSCAPE_HOME_RIGHT.ordinal()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (orientation == ORIENTATION_LANDSCAPE_HOME_LEFT.ordinal()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        }
    }

    private GestureDetector.OnGestureListener mGestureDetector = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (mPreviewView.getWidth() > 0 && mPreviewView.getHeight() > 0) {
                float x = motionEvent.getX() / mPreviewView.getWidth();
                float y = motionEvent.getY() / mPreviewView.getHeight();
                try {
                    mAlivcLivePusher.focusCameraAtAdjustedPoint(x, y, true);
                } catch (IllegalStateException e) {

                }
            }
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            if (motionEvent == null || motionEvent1 == null) {
                return false;
            }
            if (motionEvent.getX() - motionEvent1.getX() > FLING_MIN_DISTANCE
                    && Math.abs(v) > FLING_MIN_VELOCITY) {
                // Fling left
            } else if (motionEvent1.getX() - motionEvent.getX() > FLING_MIN_DISTANCE
                    && Math.abs(v) > FLING_MIN_VELOCITY) {
                // Fling right
            }
            return false;
        }
    };

    private float scaleFactor = 1.0f;
    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureDetector = new ScaleGestureDetector.OnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector.getScaleFactor() > 1) {
                scaleFactor += 0.5;
            } else {
                scaleFactor -= 2;
            }
            if (scaleFactor <= 1) scaleFactor = 1;
            try {
                if (scaleFactor >= mAlivcLivePusher.getMaxZoom())
                    scaleFactor = mAlivcLivePusher.getMaxZoom();
                mAlivcLivePusher.setZoom((int) scaleFactor);

            } catch (IllegalStateException e) {

            }
            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

        }
    };

    SurfaceHolder.Callback mCallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (mSurfaceStatus == SurfaceStatus.UNINITED) {
                mSurfaceStatus = SurfaceStatus.CREATED;
                if (mAlivcLivePusher != null) {
                    try {
                        if (mAsync) {
                            mAlivcLivePusher.startPreviewAysnc(mPreviewView);
                        } else {
                            mAlivcLivePusher.startPreview(mPreviewView);
                        }
                    } catch (IllegalArgumentException e) {
                        e.toString();
                    } catch (IllegalStateException e) {
                        e.toString();
                    }
                }
            } else if (mSurfaceStatus == SurfaceStatus.DESTROYED) {
                mSurfaceStatus = SurfaceStatus.RECREATED;
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
            mSurfaceStatus = SurfaceStatus.CHANGED;
//            if (mLivePushFragment != null) {
//                mLivePushFragment.setSurfaceView(mPreviewView);
//            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            mSurfaceStatus = SurfaceStatus.DESTROYED;
        }
    };


    @Override
    protected void onResume() {
        super.onResume();

        if (mAlivcLivePusher != null) {
            try {
                if (!isPause) {
                    if (mAsync) {
                        mAlivcLivePusher.resumeAsync();
                    } else {
                        mAlivcLivePusher.resume();
                    }
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
//        if(mViewPager.getCurrentItem() != 1) {
//            mHandler.post(mRunnable);
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAlivcLivePusher != null) {
            try {
                if (mAlivcLivePusher != null/*.isPushing()*/) {
                    mAlivcLivePusher.pause();
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
//        if(mHandler != null) {
//            mHandler.removeCallbacks(mRunnable);
//        }
    }

    @Override
    protected void onDestroy() {
        if (mAlivcLivePusher != null) {
            try {
                mAlivcLivePusher.destroy();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
//        if(mHandler != null) {
//            mHandler.removeCallbacks(mRunnable);
//            mHandler = null;
//        }
//        unregisterReceiver(mChangedReceiver);
        mFragmentList = null;
        mPreviewView = null;
//        mViewPager = null;
        mFragmentAdapter = null;
        mDetector = null;
        mScaleDetector = null;
//        mLivePushFragment = null;
//        mPushTextStatsFragment = null;
//        mPushDiagramStatsFragment = null;
        mAlivcLivePushConfig = null;

        mAlivcLivePusher = null;

//        mHandler = null;
        alivcLivePushStatsInfo = null;
        super.onDestroy();
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        AlivcPreviewOrientationEnum orientationEnum;
        if (mAlivcLivePusher != null) {
            switch (rotation) {
                case Surface.ROTATION_0:
                    orientationEnum = ORIENTATION_PORTRAIT;
                    break;
                case Surface.ROTATION_90:
                    orientationEnum = ORIENTATION_LANDSCAPE_HOME_RIGHT;
                    break;
                case Surface.ROTATION_270:
                    orientationEnum = ORIENTATION_LANDSCAPE_HOME_LEFT;
                    break;
                default:
                    orientationEnum = ORIENTATION_PORTRAIT;
                    break;
            }
            mAlivcLivePusher.setPreviewOrientation(orientationEnum);
        }
    }

    public AlivcLivePusher getLivePusher() {
        return this.mAlivcLivePusher;
    }

    public SurfaceView getPreviewView() {
        return this.mPreviewView;
    }

    private void showDialog(Context context, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("提示");
        dialog.setMessage(message);
        dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.show();
    }


    public interface PauseState {
        void updatePause(boolean state);
    }

    private PauseState mStateListener = new PauseState() {
        @Override
        public void updatePause(boolean state) {
            isPause = state;
        }
    };

    class ConnectivityChangedReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {

                if (mNetWork != NetWorkUtils.getAPNType(context)) {
                    mNetWork = NetWorkUtils.getAPNType(context);
                    if (mAlivcLivePusher != null) {
                        if (mAlivcLivePusher.isPushing()) {
                            try {
                                mAlivcLivePusher.reconnectPushAsync();
                            } catch (IllegalStateException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        }
    }
}
