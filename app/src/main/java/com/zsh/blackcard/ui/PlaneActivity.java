package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * 计划
 */

public class PlaneActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_plane_home);
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlaneActivity.this,TicketSearchActivity.class));
            }
        });
    }
}
