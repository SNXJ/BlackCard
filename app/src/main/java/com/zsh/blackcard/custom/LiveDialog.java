package com.zsh.blackcard.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.hardware.Camera;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.alivc.live.pusher.AlivcLivePusher;
import com.zsh.blackcard.R;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.SharedPreferencesUtils;

import static com.alivc.live.pusher.AlivcLivePushCameraTypeEnum.CAMERA_TYPE_BACK;
import static com.alivc.live.pusher.AlivcLivePushCameraTypeEnum.CAMERA_TYPE_FRONT;

/**
 * Name: LiveDialog
 * Author: Shing
 * Date: 2018/1/24 上午9:38
 * Description: 直播的弹窗
 */

public class LiveDialog {
    private Context mContext;

    public LiveDialog(Context context) {
        this.mContext = context;
    }

    /**
     * 直播  美颜页面
     *
     * @param mContext
     */

    public void liveBeautyDialog(final Activity mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_beauty_dialog_layout, null);
        final Dialog dialog = showDialogView(view, mContext);
    }

    /**
     * 直播  更多设置页面
     */
    private boolean flashState = true;
    private int mCameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;


    public void liveMoreDialog(final FragmentManager fm, AlivcLivePusher alivcLivePusher, int cameraId) {
        mAlivcLivePusher = alivcLivePusher;
        mCameraId = cameraId;
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_more_dialog_layout, null);
        final Dialog dialog = showDialogView(view, (Activity) mContext);

        ImageView beauty = view.findViewById(R.id.beauty);
        ImageView music = view.findViewById(R.id.music);
        final ImageView mFlash = view.findViewById(R.id.flash);
        final ImageView camera = view.findViewById(R.id.camera);

        mFlash.setSelected(!flashState);
        mFlash.setClickable(mCameraId == CAMERA_TYPE_FRONT.getCameraId() ? false : true);

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LiveDialog(mContext).liveBeautyDialog((Activity) mContext);
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LiveMusicDialog mMusicDialog = null;

                if (mMusicDialog == null) {
                    mMusicDialog = LiveMusicDialog.newInstance();
                    mMusicDialog.setAlivcLivePusher(mAlivcLivePusher);
                }
                mMusicDialog.show(fm, "beautyDialog");
            }
        });
        mFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAlivcLivePusher.setFlash(!mFlash.isSelected());
                flashState = !mFlash.isSelected();
                LogUtils.i("++++++++++++++", "+++++++flashState++++++" + flashState);
                mFlash.post(new Runnable() {
                    @Override
                    public void run() {
                        mFlash.setSelected(!mFlash.isSelected());
                    }
                });

            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mCameraId == CAMERA_TYPE_FRONT.getCameraId()) {
                    mCameraId = CAMERA_TYPE_BACK.getCameraId();
                } else {
                    mCameraId = CAMERA_TYPE_FRONT.getCameraId();
                }
                mAlivcLivePusher.switchCamera();
                mFlash.post(new Runnable() {
                    @Override
                    public void run() {
                        LogUtils.i("++++++++++++++", flashState + "+++++++mCameraId++++++" + mCameraId);

                        mFlash.setClickable(mCameraId == CAMERA_TYPE_FRONT.getCameraId() ? false : true);
                        if (mCameraId == CAMERA_TYPE_FRONT.getCameraId()) {
                            mFlash.setSelected(false);
                        } else {
                            mFlash.setSelected(flashState);
                        }
                    }
                });


            }
        });
    }

    /**
     * 直播预览美颜设置
     */

    public void liveOpenBeautyDialog(AlivcLivePusher alivcLivePusher) {
        mAlivcLivePusher = alivcLivePusher;


        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_open_beauty_dialog_layout, null);
        final Dialog dialog = showDialogView(view, (Activity) mContext);
        sbBlush = view.findViewById(R.id.progress_beauty_blush);
        sbWhite = view.findViewById(R.id.progress_beauty_white);
        sbSkin = view.findViewById(R.id.progress_beauty_skin);
        sbRed = view.findViewById(R.id.progress_beauty_red);
        sbFace = view.findViewById(R.id.progress_beauty_face);
        sbJaw = view.findViewById(R.id.progress_beauty_jaw);
        sbEye = view.findViewById(R.id.progress_beauty_eye);

        tvBlush = view.findViewById(R.id.progress_blush_mun);
        tvWhite = view.findViewById(R.id.progress_white_mun);
        tvSkin = view.findViewById(R.id.progress_skin_mun);
        tvRed = view.findViewById(R.id.progress_red_mun);
        tvFace = view.findViewById(R.id.progress_face_mun);
        tvJaw = view.findViewById(R.id.progress_jaw_mun);
        tvEye = view.findViewById(R.id.progress_eye_mun);

        open_close_beauty = view.findViewById(R.id.open_close_beauty);


        sbBlush.setOnSeekBarChangeListener(onSeekBarChangeListener);
        sbWhite.setOnSeekBarChangeListener(onSeekBarChangeListener);
        sbSkin.setOnSeekBarChangeListener(onSeekBarChangeListener);
        sbRed.setOnSeekBarChangeListener(onSeekBarChangeListener);
        sbFace.setOnSeekBarChangeListener(onSeekBarChangeListener);
        sbJaw.setOnSeekBarChangeListener(onSeekBarChangeListener);
        sbEye.setOnSeekBarChangeListener(onSeekBarChangeListener);


        sbBlush.setProgress(SharedPreferencesUtils.getIntData(mContext, "01", 50));
        tvBlush.setText(SharedPreferencesUtils.getIntData(mContext, "01", 50) + "");

        sbWhite.setProgress(SharedPreferencesUtils.getIntData(mContext, "02", 50));
        tvWhite.setText(SharedPreferencesUtils.getIntData(mContext, "02", 50) + "");

        sbSkin.setProgress(SharedPreferencesUtils.getIntData(mContext, "03", 50));
        tvSkin.setText(SharedPreferencesUtils.getIntData(mContext, "03", 50) + "");

        sbRed.setProgress(SharedPreferencesUtils.getIntData(mContext, "04", 50));
        tvRed.setText(SharedPreferencesUtils.getIntData(mContext, "04", 50) + "");

        sbFace.setProgress(SharedPreferencesUtils.getIntData(mContext, "05", 50));
        tvFace.setText(SharedPreferencesUtils.getIntData(mContext, "05", 50) + "");

        sbJaw.setProgress(SharedPreferencesUtils.getIntData(mContext, "06", 50));
        tvJaw.setText(SharedPreferencesUtils.getIntData(mContext, "06", 50) + "");

        sbEye.setProgress(SharedPreferencesUtils.getIntData(mContext, "07", 50));
        tvEye.setText(SharedPreferencesUtils.getIntData(mContext, "07", 50) + "");

        Boolean selected = !SharedPreferencesUtils.getBooleanData(mContext, "on_off", true);
        open_close_beauty.setText(selected ? "关闭美颜" : "打开美颜");
        mAlivcLivePusher.setBeautyOn(selected);

        open_close_beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAlivcLivePusher != null) {
                    try {
                        boolean selected = open_close_beauty.isSelected();
                        mAlivcLivePusher.setBeautyOn(selected);
                        open_close_beauty.setText(selected ? "关闭美颜" : "打开美颜");

                        open_close_beauty.setSelected(!selected);
                        SharedPreferencesUtils.putBooleanData(mContext, "on_off", !selected);
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    private SeekBar sbBlush, sbWhite, sbSkin, sbRed, sbFace, sbJaw, sbEye;
    private TextView tvBlush, tvWhite, tvSkin, tvRed, tvFace, tvJaw, tvEye, open_close_beauty;
    private AlivcLivePusher mAlivcLivePusher;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            try {
                int seekBarId = seekBar.getId();

                if (sbBlush.getId() == seekBarId) {
                    mAlivcLivePusher.setBeautyCheekPink(sbBlush.getProgress());
                    tvBlush.setText(String.valueOf(progress));
                    SharedPreferencesUtils.putIntData(mContext, "01", progress);

                } else if (sbWhite.getId() == seekBarId) {
                    mAlivcLivePusher.setBeautyWhite(sbWhite.getProgress());
                    tvWhite.setText(String.valueOf(progress));

                    SharedPreferencesUtils.putIntData(mContext, "02", progress);
                } else if (sbSkin.getId() == seekBarId) {
                    mAlivcLivePusher.setBeautyBuffing(sbSkin.getProgress());
                    tvSkin.setText(String.valueOf(progress));
                    SharedPreferencesUtils.putIntData(mContext, "03", progress);
                } else if (sbRed.getId() == seekBarId) {
                    mAlivcLivePusher.setBeautyRuddy(sbRed.getProgress());
                    tvRed.setText(String.valueOf(progress));
                    SharedPreferencesUtils.putIntData(mContext, "04", progress);
                } else if (sbFace.getId() == seekBarId) {
                    mAlivcLivePusher.setBeautySlimFace(sbFace.getProgress());
                    tvFace.setText(String.valueOf(progress));
                    SharedPreferencesUtils.putIntData(mContext, "05", progress);
                } else if (sbJaw.getId() == seekBarId) {
                    mAlivcLivePusher.setBeautyShortenFace(sbJaw.getProgress());
                    tvJaw.setText(String.valueOf(progress));
                    SharedPreferencesUtils.putIntData(mContext, "06", progress);
                } else if (sbEye.getId() == seekBarId) {
                    mAlivcLivePusher.setBeautyBigEye(sbEye.getProgress());
                    tvEye.setText(String.valueOf(progress));
                    SharedPreferencesUtils.putIntData(mContext, "07", progress);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    /**
     * 把自定义布局设置到dialog
     *
     * @param view
     * @param mContext
     * @return
     */
    public Dialog showDialogView(View view, final Activity mContext) {
        final Dialog dialog = new Dialog(mContext, R.style.pub_loading_dialog);
        dialog.setContentView(view);
        setWinLP(dialog, mContext);
        return dialog;
    }

    /**
     * 设置dialog 属性
     *
     * @param dialog
     * @param mContext
     */
    private void setWinLP(Dialog dialog, Activity mContext) {
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dailog_anim_enterorout_window_up);
        dialog.show();
        WindowManager windowManager = mContext.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (int) (display.getWidth()); // 设置宽度
        dialog.getWindow().setAttributes(lp);
    }

}
