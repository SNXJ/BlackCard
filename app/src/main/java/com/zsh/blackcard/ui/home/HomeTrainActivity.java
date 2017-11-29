package com.zsh.blackcard.ui.home;

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
import com.zsh.blackcard.listener.DateListener;
import com.zsh.blackcard.ui.TicketSearchActivity;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: HomeTrainActivity
 * Author: SNXJ
 * Date: 2017-11-09
 * Description:描述：
 */
public class HomeTrainActivity extends BaseActivity {
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
    private String date;
    Map<String, String> map = new TreeMap<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_trian_home);
        ButterKnife.bind(this);

    }

    private void initData() {

//        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postTrain(map), new ResultListener<TrainModel>() {
//            @Override
//            public void responseSuccess(TrainModel obj) {
//
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//        });
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
                exchangeTv();
                break;
            case R.id.rl_date:
                PublicDialog.dateDialog(HomeTrainActivity.this, "请选择日期", new DateListener() {
                    @Override
                    public void dateListener(String date) {
                        tvDateGo.setText(date);
                    }
                });
                break;
            case R.id.btn_search:
                //   startActivity(new Intent(HomeTrainActivity.this,CommonPassengerActivity.class));
                startActivity(new Intent(HomeTrainActivity.this, TicketSearchActivity.class));
                break;
        }
    }

    private void exchangeTv() {
        String str1 = (String) tvExchange01.getText();
        String str2 = (String) tvExchange02.getText();
        tvExchange01.setText(str2);
        tvExchange02.setText(str1);
    }
}
