package com.zsh.blackcard.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.OrderDialogModel;
import com.zsh.blackcard.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: OrderPayActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description: 订单支付
 */
public class OrderPayActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.im_img)
    ImageView imImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.btn_pay)
    Button btnPay;
    @BindView(R.id.cb_wx_pay)
    CheckBox cbWxPay;
    @BindView(R.id.cb_ali_pay)
    CheckBox cbAliPay;
    private OrderDialogModel data;
    private String order_id;//订单号

    @Override
    protected void initUI() {
        setContentView(R.layout.order_pay_activity);
        ButterKnife.bind(this);
        data = (OrderDialogModel) getIntent().getSerializableExtra("Serializable");
        tvName.setText(data.getDj_item_name());
        tvTime.setText(data.getDj_item_des());
        tvDes.setText(data.getDj_item_date());
        tvMoney.setText("订单金额￥" + data.getDj_item_money() + "");
        order_id = data.getDj_return_id();
        Glide.with(this).load(data.getDj_item_img()).into(imImg);
    }

    @OnClick({R.id.title_back, R.id.btn_pay, R.id.cb_wx_pay, R.id.cb_ali_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.btn_pay:
                UIUtils.showToast("联系客服");
                break;
            case R.id.cb_wx_pay:
                cbAliPay.setChecked(false);
                break;
            case R.id.cb_ali_pay:
                cbWxPay.setChecked(false);
                //服务器拼接订单
                break;

        }
    }


    private void alipay() {
        final String orderInfo = "";   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(OrderPayActivity.this);

                String result = alipay.payV2(orderInfo, true).toString();

                Message msg = new Message();
//                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
//           Result result = new Result((String) msg.obj);
//            Toast.makeText(this, result.getResult(),
//                    Toast.LENGTH_LONG).show();
        }

        ;
    };


}
