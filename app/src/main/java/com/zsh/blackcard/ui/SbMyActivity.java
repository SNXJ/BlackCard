package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class SbMyActivity extends BaseActivity {
    private ImageView blackwbback;

    @Override
    protected void initUI() {
        //setContentView(R.layout.activity_sb_my);
        setContentView(R.layout.activity_zg_my);
        //sbmyfindID();
    }

    private void sbmyfindID() {
        blackwbback = (ImageView) findViewById(R.id.blackwb_back);
        blackwbback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SbMyActivity.this, SbActivity.class);
                startActivity(intent);
            }
        });
    }

}