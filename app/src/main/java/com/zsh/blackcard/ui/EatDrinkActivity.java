package com.zsh.blackcard.ui;

import android.content.Intent;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EatDrinkActivity extends BaseActivity {

    @BindView(R.id.hj_recycler_detail_title)
    TextView hj_recycler_detail_title;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        String title = intent.getStringExtra("title");
        hj_recycler_detail_title.setText(title);
    }
}


//    findViewById(R.id.hj_eat_set).setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        startActivity(new Intent(getApplicationContext(), EatDrinkSetActivity.class));
//        }
//        });
//
//        findViewById(R.id.linear_detail).setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        startActivity(new Intent(getApplicationContext(), EatDrinkDetailActivity.class));
//        }
//        });
//
//        findViewById(R.id.blackwb_back).setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//        finish();
//        }
//        });
