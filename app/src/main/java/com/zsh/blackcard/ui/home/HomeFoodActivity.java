package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.PublicDialog;


public class HomeFoodActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton rb_city;
    private EditText et_search;
    private RadioButton rb_sort;
    private RadioButton rb_brand;
    private RadioButton rb_filter;
    private ImageView im_left;
    private TextView tv_name;


    private void bindViews() {
        rb_city = (RadioButton) findViewById(R.id.rb_city);
        et_search = (EditText) findViewById(R.id.et_search);
        rb_sort = (RadioButton) findViewById(R.id.rb_sort);
        rb_brand = (RadioButton) findViewById(R.id.rb_brand);
        rb_filter = (RadioButton) findViewById(R.id.rb_filter);
        im_left = (ImageView) findViewById(R.id.im_left);
        tv_name = (TextView) findViewById(R.id.tv_name);
        rb_sort.setOnClickListener(this);
        rb_brand.setOnClickListener(this);
        rb_filter.setOnClickListener(this);
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_food);
        bindViews();

        LinearLayout ll = (LinearLayout) findViewById(R.id.ll_food_item);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeFoodActivityDetail.class));
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_filter:
                PublicDialog.selectOneDialog(this, "foodSort.json", "推荐",
                        rb_filter);
                break;
            case R.id.rb_brand:
                PublicDialog.selectOneDialog(this, "foodSort.json", "推荐",
                        rb_filter);
                break;
            case R.id.rb_sort:
//                PublicDialog.selectOneDialog(this, "foodSort.json", "推荐",
//                        rb_sort);

                PublicDialog.ageDialog(this);

                break;
        }

    }
}
