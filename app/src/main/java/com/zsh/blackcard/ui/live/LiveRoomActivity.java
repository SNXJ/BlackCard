package com.zsh.blackcard.ui.live;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.PublicDialog;

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
                PublicDialog.liveDialog(LiveRoomActivity.this);
            }
        });
    }
}
