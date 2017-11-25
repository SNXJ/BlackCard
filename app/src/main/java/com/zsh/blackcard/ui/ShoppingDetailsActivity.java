package com.zsh.blackcard.ui;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.view.SnappingStepper;


public class ShoppingDetailsActivity extends BaseActivity {
    SnappingStepper stepper;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_shopping_details);

        stepper = (SnappingStepper) findViewById(R.id.stepper);



    }

}
