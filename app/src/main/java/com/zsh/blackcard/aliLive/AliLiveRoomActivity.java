package com.zsh.blackcard.aliLive;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.alivc.live.pusher.AlivcLivePushConfig;
import com.alivc.live.pusher.AlivcLivePushStatsInfo;
import com.alivc.live.pusher.AlivcLivePusher;
import com.alivc.live.pusher.AlivcPreviewOrientationEnum;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.PublicFragmentAdapter;
import com.zsh.blackcard.aliLive.fragment.LivingNoFragment;
import com.zsh.blackcard.aliLive.fragment.LivingRoomFragment;
import com.zsh.blackcard.utils.NetWorkUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.alivc.live.pusher.AlivcPreviewOrientationEnum.ORIENTATION_LANDSCAPE_HOME_LEFT;
import static com.alivc.live.pusher.AlivcPreviewOrientationEnum.ORIENTATION_LANDSCAPE_HOME_RIGHT;
import static com.alivc.live.pusher.AlivcPreviewOrientationEnum.ORIENTATION_PORTRAIT;

/**
 * Name: AliLiveRoomActivity
 * Author: Shing
 * Date: 2018/1/15 下午12:01
 * Description: ..
 */

public class AliLiveRoomActivity extends BaseAliLiveActivity {
    public enum SurfaceStatus {
        UNINITED, CREATED, CHANGED, DESTROYED, RECREATED
    }

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.preview_view)
    SurfaceView mPreviewView;
    List<Fragment> fragmentList = new ArrayList<>();

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


    private List<Fragment> mFragmentList = new ArrayList<>();
    private PublicFragmentAdapter mFragmentAdapter;

    private GestureDetector mDetector;
    private ScaleGestureDetector mScaleDetector;
    private LivingRoomFragment mLivePushFragment;
    private LivingNoFragment mLivingNoFragment;
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


    @Override
    protected void initView() {
        initparam();
        setContentView(R.layout.living_room_activity);
        ButterKnife.bind(this);


    }

    private void initparam() {


        mPushUrl = getIntent().getStringExtra(URL_KEY);
        mAsync = getIntent().getBooleanExtra(ASYNC_KEY, false);
        mAudioOnly = getIntent().getBooleanExtra(AUDIO_ONLY_KEY, false);
        mVideoOnly = getIntent().getBooleanExtra(VIDEO_ONLY_KEY, false);
        mOrientation = getIntent().getIntExtra(ORIENTATION_KEY, ORIENTATION_PORTRAIT.ordinal());
        mCameraId = getIntent().getIntExtra(CAMERA_ID, Camera.CameraInfo.CAMERA_FACING_FRONT);
        mFlash = getIntent().getBooleanExtra(FLASH_ON, false);
        setOrientation(mOrientation);


    }


    @Override
    protected void initData() {
        mPreviewView.getHolder().addCallback(mCallback);


        mAlivcLivePushConfig = (AlivcLivePushConfig) getIntent().getSerializableExtra(AlivcLivePushConfig.Config);
        mAlivcLivePusher = new AlivcLivePusher();

        try {
            mAlivcLivePusher.init(getApplicationContext(), mAlivcLivePushConfig);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            showDialog(this, e.getMessage());
        } catch (IllegalStateException e) {
            e.printStackTrace();
            showDialog(this, e.getMessage());
        }


        initViewPager();
        mScaleDetector = new ScaleGestureDetector(getApplicationContext(), mScaleGestureDetector);
        mDetector = new GestureDetector(getApplicationContext(), mGestureDetector);
        mNetWork = NetWorkUtils.getAPNType(this);


    }


    private void initViewPager() {


        mLivePushFragment = new LivingRoomFragment().newInstance(mPushUrl, mAsync, mAudioOnly, mVideoOnly, mCameraId, mFlash, mAlivcLivePushConfig.getQualityMode().getQualityMode());
        mLivePushFragment.setAlivcLivePusher(mAlivcLivePusher);
        mLivePushFragment.setStateListener(mStateListener);
        mLivingNoFragment = new LivingNoFragment();

        mFragmentList.add(mLivingNoFragment);
        mFragmentList.add(new LivingRoomFragment());
        mFragmentAdapter = new PublicFragmentAdapter(getSupportFragmentManager(), mFragmentList, null);

        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setCurrentItem(1);
        mViewPager.setOffscreenPageLimit(2);

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
            if (mLivePushFragment != null) {
                mLivePushFragment.setSurfaceView(mPreviewView);
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            mSurfaceStatus = SurfaceStatus.DESTROYED;
        }
    };

    public static void startActivity(Activity activity, AlivcLivePushConfig alivcLivePushConfig, String url, boolean async, boolean audioOnly, boolean videoOnly, AlivcPreviewOrientationEnum orientation, int cameraId, boolean isFlash) {
        Intent intent = new Intent(activity, AliLiveRoomActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(AlivcLivePushConfig.Config, alivcLivePushConfig);
        bundle.putString(URL_KEY, url);
        bundle.putBoolean(ASYNC_KEY, async);
        bundle.putBoolean(AUDIO_ONLY_KEY, audioOnly);
        bundle.putBoolean(VIDEO_ONLY_KEY, videoOnly);
        bundle.putInt(ORIENTATION_KEY, orientation.ordinal());
        bundle.putInt(CAMERA_ID, cameraId);
        bundle.putBoolean(FLASH_ON, isFlash);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, REQ_CODE_PUSH);
    }

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
        mViewPager = null;
        mFragmentAdapter = null;
        mDetector = null;
        mScaleDetector = null;
        mLivePushFragment = null;
        mLivingNoFragment = null;
        mFragmentAdapter = null;
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
        dialog.setTitle("错误提示");
        dialog.setMessage(message);
        dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.show();
    }

//    private Runnable mRunnable = new Runnable() {
//        @Override
//        public void run() {
//            LogUtil.d(TAG, "====== mRunnable run ======");
//
//            new AsyncTask<AlivcLivePushStatsInfo, Void, AlivcLivePushStatsInfo>() {
//                @Override
//                protected AlivcLivePushStatsInfo doInBackground(AlivcLivePushStatsInfo... alivcLivePushStatsInfos) {
//                    try {
//                        alivcLivePushStatsInfo = mAlivcLivePusher.getLivePushStatsInfo();
//                    } catch (IllegalStateException e) {
//
//                    }
//                    return alivcLivePushStatsInfo;
//                }
//
//                @Override
//                protected void onPostExecute(AlivcLivePushStatsInfo alivcLivePushStatsInfo) {
//                    super.onPostExecute(alivcLivePushStatsInfo);
////                    if (mLivingNoFragment != null && mViewPager.getCurrentItem() == 0) {
////                        mLivingNoFragment.updateValue(alivcLivePushStatsInfo);
////                    }
////
//                }
//            }.execute();
//        }
//    };

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
