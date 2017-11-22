package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.TicketSearchActivity;

/**
 * 计划
 */

public class HomePlaneActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_plane_home);
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ActivityUtils
                startActivity(new Intent(HomePlaneActivity.this, TicketSearchActivity.class));
            }
        });
    }
}
