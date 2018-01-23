package com.zsh.blackcard.live;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import com.zego.zegoliveroom.constants.ZegoVideoViewMode;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.live.zego.SystemUtil;
import com.zsh.blackcard.live.zego.ZegoApiManager;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Name: LiveOpenActivity
 * Author: SNXJ
 * Date: 2017-11-17
 * Description: 开启直播
 */
public class LiveOpenActivity extends BaseActivity {
    @BindView(R.id.im_close)
    ImageView imClose;
    @BindView(R.id.im_location)
    ImageView imLocation;
    @BindView(R.id.im_refresh)
    ImageView imRefresh;
    @BindView(R.id.et_edit_title)
    EditText etEditTitle;
    @BindView(R.id.btn_open)
    Button btnOpen;
    @BindView(R.id.tv_xieyi)
    TextView tvXieyi;
    @BindView(R.id.textureView)
    TextureView textureView;
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    private boolean mHasBeenCreated = false;

    protected Resources mResources;
    protected Handler mHandler;

    private void initBaseVariables() {
        mResources = getResources();
        mHandler = new Handler();
    }


    private ZegoLiveRoom mZegoLiveRoom;

    @Override
    protected void initUI() {
        setContentView(R.layout.live_open_activity);
        initBaseVariables();

        mZegoLiveRoom = ZegoApiManager.getInstance().getZegoLiveRoom();
        requestPermis();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mHasBeenCreated) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startPreview();
                }
            }, 500);
        } else {
            mHasBeenCreated = true;
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        if (SystemUtil.isAppBackground()) {
//            stopPreview();
            Log.i("Foreground", "Foreground");
        } else {
            Log.i("Foreground", "Background");
            // app进入后台, 停止预览
            stopPreview();
        }
    }

    private void requestPermis() {
        if (mHasBeenCreated) {
            // 6.0及以上的系统需要在运行时申请CAMERA RECORD_AUDIO权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, 101);
                } else {
                    startPreview();
                }
            } else {
                startPreview();
            }
        } else {
            mHasBeenCreated = true;
        }
    }


    private void startPreview() {
        LogUtils.i("", "+++++++++++++++++++start+++++++++++++");
        // 设置app朝向
        int currentOrientation = LiveOpenActivity.this.getWindowManager().getDefaultDisplay().getRotation();
        mZegoLiveRoom.setAppOrientation(currentOrientation);

        // 设置推流配置
        ZegoAvConfig currentConfig = ZegoApiManager.getInstance().getZegoAvConfig();
        int videoWidth = currentConfig.getVideoEncodeResolutionWidth();
        int videoHeight = currentConfig.getVideoEncodeResolutionHeight();
        if (((currentOrientation == Surface.ROTATION_0 || currentOrientation == Surface.ROTATION_180) && videoWidth > videoHeight) ||
                ((currentOrientation == Surface.ROTATION_90 || currentOrientation == Surface.ROTATION_270) && videoHeight > videoWidth)) {
            currentConfig.setVideoEncodeResolution(videoHeight, videoWidth);
            currentConfig.setVideoCaptureResolution(videoHeight, videoWidth);
        }
        ZegoApiManager.getInstance().setZegoConfig(currentConfig);

        // 设置水印
        ZegoLiveRoom.setWaterMarkImagePath("asset:watermark.png");
        Rect rect = new Rect();
        rect.left = 30;
        rect.top = 10;
        rect.right = 180;
        rect.bottom = 160;
        ZegoLiveRoom.setPreviewWaterMarkRect(rect);

        textureView.setVisibility(View.VISIBLE);
        mZegoLiveRoom.setPreviewView(textureView);
        mZegoLiveRoom.setPreviewViewMode(ZegoVideoViewMode.ScaleAspectFill);
        mZegoLiveRoom.startPreview();

//        mZegoLiveRoom.setFrontCam(tbEnableFrontCam.isChecked());
//        mZegoLiveRoom.enableTorch(tbEnableTorch.isChecked());
        // 设置美颜
        //      mZegoLiveRoom.enableBeautifying(5);
        // 设置滤镜
        //      mZegoLiveRoom.setFilter(5);
    }

    private void stopPreview() {
        textureView.setVisibility(View.INVISIBLE);
        mZegoLiveRoom.stopPreview();
        mZegoLiveRoom.setPreviewView(null);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        stopPreview();
        startPreview();
    }

    @OnClick({R.id.im_close, R.id.im_location, R.id.im_refresh, R.id.btn_open, R.id.tv_xieyi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_close:
                finish();
                break;
            case R.id.im_location:
                break;
            case R.id.im_refresh:
                ActivityUtils.startActivity(LiveOpenActivity.this, LiveAnchorListActivity.class);
                break;
            case R.id.btn_open:
                //startActivity(new Intent(LiveOpenActivity.this, LiveRoomActivity.class));
                SingleAnchorActivity.actionStart(this, "单主播", true, true, 0, 0, getWindowManager().getDefaultDisplay().getRotation());
                break;
            case R.id.tv_xieyi:
                break;
        }
    }

    @OnClick(R.id.textureView)
    public void onClick() {
    }
}
