package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * 收获地址管理详情
 */

public class TakeAdressDetailsActivity extends BaseActivity {
    private TextView newaddress_tv;
    private ImageView take2back;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_take_adress_details);
        take2findID();
    }


    private void take2findID() {
        newaddress_tv = (TextView) findViewById(R.id.add_newaddress);
        take2back = (ImageView) findViewById(R.id.take2_back);
        take2back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        newaddress_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TakeAdressDetailsActivity.this, TakeAddressActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            //do something...
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
