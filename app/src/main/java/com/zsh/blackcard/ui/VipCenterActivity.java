package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.VipCenterAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MyVipCenterModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class VipCenterActivity extends BaseActivity {

    private VipCenterAdapter vipCenterAdapter;

    @BindView(R.id.my_vip_center_recycler)
    RecyclerView my_vip_center_recycler;
    @BindView(R.id.my_vip_center_head_img)
    ImageView my_vip_center_head_img;

    @Override
    protected void initUI() {
        setContentView(R.layout.my_vip_center);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {
        DataManager.getInstance(this).RequestHttp(NetApi.postMyVipCenter(DataManager.getMd5Str("MEMBERINFO"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<MyVipCenterModel>() {
            @Override
            public void responseSuccess(MyVipCenterModel obj) {
                if (obj.getResult().equals("01")) {
                    Glide.with(VipCenterActivity.this).load(obj.getMemberInfo().getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(VipCenterActivity.this))).into(my_vip_center_head_img);
                    for (int i = 0; i < obj.getList().size(); i++) {
                        if (i == 0) {
                            obj.getList().get(i).setItemType(1);
                        } else if (i == obj.getList().size() - 1) {
                            obj.getList().get(i).setItemType(3);
                        } else {
                            obj.getList().get(i).setItemType(2);
                        }
                    }

                    vipCenterAdapter = new VipCenterAdapter(obj.getList());
                    my_vip_center_recycler.setLayoutManager(new LinearLayoutManager(VipCenterActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    my_vip_center_recycler.setAdapter(vipCenterAdapter);
                }
            }

            @Override
            public void onCompleted() {

            }
        });


//        vipCenterAdapter = new VipCenterAdapter(this);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    }

    @OnClick(R.id.blackwb_back)
    public void onClick() {
        finish();
    }
}
