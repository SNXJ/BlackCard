package com.zsh.blackcard.ui;

import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.ChangeAddressPopwindow;
import com.zsh.blackcard.R;

/**
 * 收货地址管理
 */
public class TakeAddressActivity extends BaseActivity {
    private TextView takemoretv;
    private ImageView takeback;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_take_address);
        takefindID();
        takeOnClick();
    }

    private void takeOnClick() {
        takeback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        takemoretv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(TakeAddressActivity.this);
                mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
                mChangeAddressPopwindow.showAtLocation(takemoretv, Gravity.BOTTOM, 0, 0);
                mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
                    @Override
                    public void onClick(String province, String city, String area) {
                        // TODO Auto-generated method stub
                        Toast.makeText(TakeAddressActivity.this,
                                province + "-" + city + "-" + area,
                                Toast.LENGTH_LONG).show();
                        takemoretv.setText(province + city + area);
                    }
                });
            }
        });
    }

    private void takefindID() {
        takemoretv = (TextView) findViewById(R.id.take_more_tv);
        takeback = (ImageView) findViewById(R.id.take_back);
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