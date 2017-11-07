package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;


public class IntegralActivity extends BaseActivity {
    private RadioButton rbt_bills;
    private RadioButton rbt_exchange;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_integral);
        integralfindID();
        integralOnClick();
    }

    private void integralOnClick() {
        rbt_bills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent billsintent = new Intent(IntegralActivity.this,IntegralbillsActivity.class);
                startActivity(billsintent);
            }
        });
        rbt_exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exchangeintent = new Intent(IntegralActivity.this, DiscountExchangeActivity.class);
                startActivity(exchangeintent);
            }
        });
    }

    private void integralfindID() {
        rbt_bills = (RadioButton) findViewById(R.id.integral_rbt_bills);
        rbt_exchange = (RadioButton) findViewById(R.id.integral_rbt_exchange);
    }
}
