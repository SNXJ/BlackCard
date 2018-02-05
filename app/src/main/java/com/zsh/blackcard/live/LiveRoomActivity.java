package com.zsh.blackcard.live;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Name: LiveRoomActivity
 * Author: SNXJ
 * Date: 2017-11-10
 * Description:描述：
 */
public class LiveRoomActivity extends BaseActivity {
    @Override
    protected void initUI() {
        setContentView(R.layout.live_room_activity);
        findViewById(R.id.im_live_head).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PublicDialog.liveDialog(LiveRoomActivity.this);
            }
        });
    }


//
//    protected void doBusiness(Bundle savedInstanceState) {
//        super.doBusiness(savedInstanceState);
//        mRoomID = ZegoRoomUtil.getRoomID(ZegoRoomUtil.ROOM_TYPE_SINGLE);
//
//        // 登录房间
//        mZegoLiveRoom.loginRoom(mRoomID, mPublishTitle, ZegoConstants.RoomRole.Anchor, new IZegoLoginCompletionCallback() {
//            @Override
//            public void onLoginCompletion(int errorCode, ZegoStreamInfo[] zegoStreamInfos) {
//                if(errorCode == 0){
//                    handleAnchorLoginRoomSuccess(zegoStreamInfos);
//                }else {
//                    handleAnchorLoginRoomFail(errorCode);
//                }
//            }
//        });
//
//        // 设置推流相关回调
//        mZegoLiveRoom.setZegoLivePublisherCallback(new IZegoLivePublisherCallback() {
//            @Override
//            public void onPublishStateUpdate(int stateCode, String streamID, HashMap<String, Object> streamInfo) {
//                //推流状态更新
//                if (stateCode == 0) {
//                    handlePublishSucc(streamID, streamInfo);
//                } else {
//                    handlePublishStop(stateCode, streamID);
//                }
//            }
//
//            @Override
//            public void onJoinLiveRequest(final int seq, String fromUserID, String fromUserName, String roomID) {
//            }
//
//            @Override
//            public void onPublishQualityUpdate(String streamID, ZegoStreamQuality streamQuality) {
//                // 推流质量回调
//                handlePublishQualityUpdate(streamID, streamQuality.quality, streamQuality.videoFPS, streamQuality.videoBitrate);
//            }
//
//            @Override
//            public AuxData onAuxCallback(int dataLen) {
//                return handleAuxCallback(dataLen);
//            }
//
//            @Override
//            public void onCaptureVideoSizeChangedTo(int width, int height) {
//
//            }
//
//            @Override
//            public void onMixStreamConfigUpdate(int errorCode, String streamID, HashMap<String, Object> streamInfo) {
//
//            }
//        });
//
//        // 设置房间回调
//        mZegoLiveRoom.setZegoRoomCallback(new IZegoRoomCallback() {
//            @Override
//            public void onKickOut(int reason, String roomID) {
//
//            }
//
//            @Override
//            public void onDisconnect(int errorCode, String roomID) {
//                handleDisconnect(errorCode, roomID);
//            }
//
//            @Override
//            public void onStreamUpdated(final int type, final ZegoStreamInfo[] listStream, final String roomID) {
//                if (listStream != null && listStream.length > 0) {
//                    switch (type) {
//                        case ZegoConstants.StreamUpdateType.Added:
//                            handleStreamAdded(listStream, roomID);
//                            break;
//                        case ZegoConstants.StreamUpdateType.Deleted:
//                            handleStreamDeleted(listStream, roomID);
//                            break;
//                    }
//                }
//            }
//
//            @Override
//            public void onStreamExtraInfoUpdated(ZegoStreamInfo[] zegoStreamInfos, String s) {
//
//            }
//
//            @Override
//            public void onRecvCustomCommand(String userID, String userName, String content, String roomID) {
//
//            }
//        });
//
//        // 设置 IM 回调
//        mZegoLiveRoom.setZegoIMCallback(new IZegoIMCallback() {
//
//            @Override
//            public void onUserUpdate(ZegoUserState[] listUser, int updateType) {
//                handleUserUpdate(listUser, updateType);
//            }
//
//            @Override
//            public void onRecvRoomMessage(String roomID, ZegoRoomMessage[] listMsg) {
//                handleRecvRoomMsg(roomID, listMsg);
//            }
//
//            @Override
//            public void onRecvConversationMessage(String roomID, String conversationID, ZegoConversationMessage message) {
//                handleRecvConversationMsg(roomID, conversationID, message);
//            }
//        });
//
//        // 设置音频前处理回调
//        mZegoLiveRoom.setZegoAudioPrepCallback(new IZegoAudioPrepCallback() {
//            @Override
//            public void onAudioPrep(ByteBuffer inData, int sampleCount, int bitDepth, int sampleRate, ByteBuffer outData) {
//                // do audioprep something
//
//            }
//        });
//    }
//
//    /**
//     * 设置推流 flag 为 ZegoConstants.PublishFlag.SingleAnchor
//     */
//    @Override
//    protected void initPublishConfigs() {
//        // 单主播模式, 直推CDN
//        mPublishFlag = ZegoConstants.PublishFlag.SingleAnchor;
//    }
//
//    /**
//     * 开始推流
//     */
//    @Override
//    protected void doPublish() {
//        if (mIsPublishing) {
//            stopPublish();
//        } else {
//            startPublish();
//        }
//    }

// BaseLiveActivity.java

//    /**
//     * 开始推流
//     */
//    protected void startPublish() {
//        // 6.0及以上的系统需要在运行时申请CAMERA RECORD_AUDIO权限
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//                    || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{
//                        Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO}, 101);
//            } else {
//                publishStream();
//            }
//        } else {
//            publishStream();
//        }
//    }

//    /**
//     * 设置推流信息，打开预览并推流
//     */
//    protected void publishStream() {
//        if (TextUtils.isEmpty(mPublishStreamID)) {
//            return;
//        }
//
//        ViewLive freeViewLive = getFreeViewLive();
//        if (freeViewLive == null) {
//            return;
//        }
//
//        // 设置流信息
//        freeViewLive.setStreamID(mPublishStreamID);
//        freeViewLive.setPublishView(true);
//
//        // 初始化配置信息, 混流模式使用
//        initPublishConfigs();
//
//        // 输出发布状态
//        recordLog(MY_SELF + ": start publishing(" + mPublishStreamID + ")");
//
//        // 设置水印
//        mZegoLiveRoom.setWaterMarkImagePath("asset:watermark.png");
//        Rect rect = new Rect();
//        rect.left = 50;
//        rect.top = 20;
//        rect.right = 200;
//        rect.bottom = 170;
//        mZegoLiveRoom.setPreviewWaterMarkRect(rect);
//        mZegoLiveRoom.setPublishWaterMarkRect(rect);
//
//        // 开启流量自动控制
//        int properties = ZegoConstants.ZegoTrafficControlProperty.ZEGOAPI_TRAFFIC_FPS
//                | ZegoConstants.ZegoTrafficControlProperty.ZEGOAPI_TRAFFIC_RESOLUTION;
//        mZegoLiveRoom.enableTrafficControl(properties, true);
//
//        // 开始播放
//        mZegoLiveRoom.setPreviewView(freeViewLive.getTextureView());
//        mZegoLiveRoom.startPreview();
//        mZegoLiveRoom.enableMic(mEnableMic);
//        mZegoLiveRoom.enableCamera(mEnableCamera);
//        mZegoLiveRoom.startPublishing(mPublishStreamID, mPublishTitle, mPublishFlag);
//        mZegoLiveRoom.setPreviewViewMode(ZegoVideoViewMode.ScaleAspectFill);
//    }
}
