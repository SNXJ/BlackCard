package com.zsh.blackcard.ui;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.view.AmountView;


public class ShoppingCarActivity extends BaseActivity {
    public AmountView mAmountView;
    public AmountView mAmountView2;
    public ImageView shoppingback;
    @Override
    protected void initUI() {
        setContentView(R.layout.activity_shopping_car);
        shopfindID();
        shopOnClick();
        mAmountView.setGoods_storage(50);
        mAmountView2.setGoods_storage(50);
        mAmountView.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                Toast.makeText(getApplicationContext(), "Amount=>  " + amount, Toast.LENGTH_SHORT).show();
            }
        });
        mAmountView2.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                Toast.makeText(getApplicationContext(), "Amount=>  " + amount, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void shopOnClick() {
        shoppingback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void shopfindID() {
        mAmountView = (AmountView) findViewById(R.id.amount_view);
        mAmountView2 = (AmountView) findViewById(R.id.amount_view2);
        shoppingback = (ImageView) findViewById(R.id.shopping_back);
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
