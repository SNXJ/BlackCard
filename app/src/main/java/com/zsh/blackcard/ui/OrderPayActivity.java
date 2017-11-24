package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HoteldetailsItemModel;
import com.zsh.blackcard.untils.UIUtils;

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
    HoteldetailsItemModel.PdBean item;

    @Override
    protected void initUI() {
        setContentView(R.layout.order_pay_activity);
        ButterKnife.bind(this);
        item = (HoteldetailsItemModel.PdBean) getIntent().getSerializableExtra("Serializable");

        tvName.setText(item.getHOTELDETNAME());
        tvTime.setText(item.getMyDES());
        tvDes.setText(item.getHOTELDETBEDTYPE());
        tvMoney.setText("订单金额￥" + item.getHOTELDETPRICE() + "");

        Glide.with(this).load(item.getHOTELDETIMGS()).into(imImg);
    }

    @OnClick({R.id.title_back, R.id.btn_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.btn_pay:
                UIUtils.showToast("联系客服");
                break;
        }
    }
}
