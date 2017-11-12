package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class HomeFoodActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food);
       LinearLayout ll=(LinearLayout) findViewById(R.id.ll_food_item);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeFoodActivityDetail.class));
            }
        });
    }


}
