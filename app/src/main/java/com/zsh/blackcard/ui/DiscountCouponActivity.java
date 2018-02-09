package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.DisCountAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.DisCountModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 订单中心优惠券
 */
public class DiscountCouponActivity extends BaseActivity {

    @BindView(R.id.discount_recycler)
    RecyclerView discount_recycler;

    private DisCountAdapter disCountAdapter;

    List<DisCountModel.PdBean> list = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_discount_coupon);
        ButterKnife.bind(this);
        initData();

        for (int i = 0; i < 5; i++) {
            DisCountModel.PdBean pd = new DisCountModel.PdBean();

            list.add(pd);
        }
    }

    private void initData() {
//        showLoading(this);

//        DataManager.getInstance(this).RequestHttp(NetApi.postDisCount(DataManager.getMd5Str("COUPONLIST"), "system"), new ResultListener<DisCountModel>() {
//            @Override
//        public void responseSuccess (DisCountModel obj){
//                if(obj.getResult().equals("01")){
//                    disCountAdapter = new DisCountAdapter(R.layout.discount_item,obj.getPd());
//                    discount_recycler.setLayoutManager(new LinearLayoutManager(DiscountCouponActivity.this));
//                    discount_recycler.setAdapter(disCountAdapter);
//                }
//            }
//
//            @Override
//            public void onCompleted() {
//                dialogDismiss();
//            }
//        });

            disCountAdapter = new DisCountAdapter(R.layout.discount_item, list);
            discount_recycler.setLayoutManager(new LinearLayoutManager(DiscountCouponActivity.this));
            discount_recycler.setAdapter(disCountAdapter);
        }
    }