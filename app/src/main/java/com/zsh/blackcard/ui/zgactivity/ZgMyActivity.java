package com.zsh.blackcard.ui.zgactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.DiscountCouponActivity;
import com.zsh.blackcard.ui.IntegralActivity;
import com.zsh.blackcard.ui.TakeAdressDetailsActivity;


public class ZgMyActivity extends Activity {
    private TextView mydingdantv;
    private RadioButton myaddress_btn;
    private RadioButton rbt_discount;
    private RadioButton rbt_integral;
    private ImageView zmback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zg_my);
        zgmyfindID();
        zgmyOnClick();

    }

    private void zgmyOnClick() {
        mydingdantv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dingdanintent = new Intent(ZgMyActivity.this,ZgMyIndentActivity.class);
                startActivity(dingdanintent);
            }
        });
        myaddress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dingdanintent = new Intent(ZgMyActivity.this, TakeAdressDetailsActivity.class);
                startActivity(dingdanintent);
            }
        });
        rbt_discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent discountintent = new Intent(ZgMyActivity.this, DiscountCouponActivity.class);
                startActivity(discountintent);
            }
        });
        rbt_integral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent integralintent = new Intent(ZgMyActivity.this, IntegralActivity.class);
                startActivity(integralintent);
            }
        });
        zmback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void zgmyfindID() {
        mydingdantv = (TextView) findViewById(R.id.zgmy_tv_dingdan);
        zmback = (ImageView) findViewById(R.id.zgmyback);
        myaddress_btn = (RadioButton) findViewById(R.id.zgmy_address_btn);
        rbt_discount = (RadioButton) findViewById(R.id.zgmy_rbt_discount);
        rbt_integral = (RadioButton) findViewById(R.id.zgmy_rbt_integral);
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            //do something...
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
