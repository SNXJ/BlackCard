package com.zsh.blackcard.ui;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Created by kkkkk on 2017/11/13.
 */

public class CusCenterChatActivity extends BaseActivity implements View.OnClickListener {

    private ImageView back_img, img_add;
    private RelativeLayout relative_add, relative_add_bottom;
    private RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_house_center_chat);
        initView();
        initOnClick();
        initDate();
    }

    private void initDate() {

    }

    private void initOnClick() {
        back_img.setOnClickListener(this);
        img_add.setOnClickListener(this);
    }

    private void initView() {
        back_img = (ImageView) findViewById(R.id.blackwb_back);
        img_add = (ImageView) findViewById(R.id.img_add);
        relative_add = (RelativeLayout) findViewById(R.id.relative_add);
        relative_add_bottom = (RelativeLayout) findViewById(R.id.relative_add_bottom);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.img_add:
                int width = relative_add.getWidth();
                int height = relative_add.getHeight();
                layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if (relative_add_bottom.getVisibility() == View.GONE) {
                    relative_add_bottom.setVisibility(View.VISIBLE);
                    layoutParams.addRule(RelativeLayout.ABOVE, relative_add_bottom.getId());

                } else {
                    relative_add_bottom.setVisibility(View.GONE);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

                }
                relative_add.setMinimumWidth(width);
                relative_add.setMinimumHeight(height);
                relative_add.setLayoutParams(layoutParams);
                break;
        }
    }
}
