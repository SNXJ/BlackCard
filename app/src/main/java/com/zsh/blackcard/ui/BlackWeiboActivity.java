package com.zsh.blackcard.ui;

import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.BlackwbAdapter;


public class BlackWeiboActivity extends BaseActivity {
    private ImageView wbback;
    private GridView blackwbgv;
    private Integer[] wbimages={
            R.mipmap.blog_image_2,
            R.mipmap.blog_image_3,
            R.mipmap.home_image_4,
            R.mipmap.home_image_5,
            R.mipmap.home_image_6,
            R.mipmap.home_image_7
    };

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_black_weibo);
        wbfindID();
        wbOnClick();
        BlackwbAdapter blackwbAdapter=new BlackwbAdapter(wbimages,this);
        blackwbgv.setAdapter(blackwbAdapter);
    }

    private void wbOnClick() {
        wbback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void wbfindID() {
        blackwbgv = (GridView) findViewById(R.id.black_item_gv);
        wbback = (ImageView) findViewById(R.id.blackwb_back);
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
