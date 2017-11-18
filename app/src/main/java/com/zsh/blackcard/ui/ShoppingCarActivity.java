package com.zsh.blackcard.ui;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.SnappingStepperValueChangeListener;
import com.zsh.blackcard.untils.UIUtils;
import com.zsh.blackcard.view.SnappingStepper;


public class ShoppingCarActivity extends BaseActivity implements SnappingStepperValueChangeListener {
    public SnappingStepper stepper;
    //  public AmountView mAmountView2;
    public ImageView shoppingback;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_shopping_car);
        shopfindID();
        shopOnClick();
        stepper.setOnValueChangeListener(this);
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
        stepper = (SnappingStepper) findViewById(R.id.stepper);

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

    @Override
    public void onValueChange(View view, int value) {
        switch (view.getId()) {
            case R.id.stepper:
                UIUtils.showToast("值=" + value);
                break;
        }
    }
}
