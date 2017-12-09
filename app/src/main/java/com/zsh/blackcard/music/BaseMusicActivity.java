package com.zsh.blackcard.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.music.service.PlayService;
import com.zsh.blackcard.music.untils.AppCache;

/**
 * Name: BaseMusicActivity
 * Author: SNXJ
 * Date: 2017-12-09
 * Description:描述：
 */
public abstract class BaseMusicActivity extends BaseActivity {
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    PlayService playService = null;
    PlayServiceConnection mPlayServiceConnection;

    /**
     * 初始化UI
     */
    protected abstract void initView();

    @Override
    protected void initUI() {
        checkService();
        initView();
    }

    public PlayService getPlayService() {
        PlayService playService = AppCache.getPlayService();
        if (playService == null) {
            throw new NullPointerException("play service is null");
        }
        return playService;
    }

    private void checkService() {
        if (AppCache.getPlayService() == null) {
            bindService();
        }
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setClass(this, PlayService.class);
        mPlayServiceConnection = new PlayServiceConnection();
        bindService(intent, mPlayServiceConnection, Context.BIND_AUTO_CREATE);
    }


    private class PlayServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            playService = ((PlayService.PlayBinder) service).getService();
            AppCache.setPlayService(playService);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    @Override
    protected void onDestroy() {
        if (mPlayServiceConnection != null) {
            unbindService(mPlayServiceConnection);
        }
        super.onDestroy();
//        playService.onDestroy();


    }
}
