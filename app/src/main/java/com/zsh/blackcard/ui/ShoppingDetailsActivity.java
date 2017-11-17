package com.zsh.blackcard.ui;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.SnappingStepperValueChangeListener;
import com.zsh.blackcard.untils.UIUtils;
import com.zsh.blackcard.view.SnappingStepper;


public class ShoppingDetailsActivity extends BaseActivity implements SnappingStepperValueChangeListener {
    SnappingStepper stepper;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_shopping_details);

        stepper = (SnappingStepper) findViewById(R.id.stepper);

        stepper.setOnValueChangeListener(this);


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
