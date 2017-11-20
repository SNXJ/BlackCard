package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class HomeHotelActivityDetail extends BaseActivity {

    RelativeLayout rl_comment;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_hotel_detail);

        rl_comment = (RelativeLayout) findViewById(R.id.rl_comment);
        rl_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeHotelActivityDetail.this, CommentActivity.class));
            }
        });
    }
}
