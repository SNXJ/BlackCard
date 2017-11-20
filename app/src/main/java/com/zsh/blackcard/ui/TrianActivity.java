package com.zsh.blackcard.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.PublicDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Name: TrianActivity
 * Author: SNXJ
 * Date: 2017-11-09
 * Description:描述：
 */
public class TrianActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tv_exchange_01)
    TextView tvExchange01;
    @BindView(R.id.tv_exchange_02)
    TextView tvExchange02;
    @BindView(R.id.im_exchange)
    ImageView imExchange;
    @BindView(R.id.tv_date_go)
    TextView tvDateGo;
    @BindView(R.id.rl_date)
    RelativeLayout rlDate;
    @BindView(R.id.cb_student)
    CheckBox cbStudent;
    @BindView(R.id.cb_gaotie)
    CheckBox cbGaotie;
    @BindView(R.id.btn_search)
    Button btnSearch;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_trian_home);
    }

    @OnClick({R.id.title_back, R.id.tv_exchange_01, R.id.tv_exchange_02, R.id.im_exchange, R.id.rl_date, R.id.cb_student, R.id.cb_gaotie, R.id.btn_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_exchange_01:
                break;
            case R.id.tv_exchange_02:
                break;
            case R.id.im_exchange:
                break;
            case R.id.rl_date:
                PublicDialog.dataDialog(TrianActivity.this);
                break;
//            case R.id.cb_student:
//                break;
//            case R.id.cb_gaotie:
//                break;
            case R.id.btn_search:
                //   startActivity(new Intent(TrianActivity.this,CommonlyActivity.class));
                startActivity(new Intent(TrianActivity.this, TicketSearchActivity.class));
                break;
        }
    }
}
