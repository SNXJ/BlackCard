package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 常用乘客
 */
public class CommonlyActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.rb_check)
    RadioButton rbCheck;
    @BindView(R.id.im_edit)
    ImageView imEdit;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_id_num)
    TextView tvIdNum;
    @BindView(R.id.btn_add)
    Button btn_add;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_commonly);
    }


    @OnClick({R.id.title_back, R.id.tv_save, R.id.rb_check, R.id.im_edit,R.id.btn_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_save:
                break;
            case R.id.rb_check:
                break;
            case R.id.im_edit:
                break;
            case R.id.btn_add:
                startActivity( new Intent(CommonlyActivity.this,TicketAddActivity.class));
                break;
        }
    }
}
