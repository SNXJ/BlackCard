package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.EatDrinkModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/23.
 */

public class HjChildRecyclerAdapter extends BaseQuickAdapter<EatDrinkModel.PdBean, BaseViewHolder> {

    public HjChildRecyclerAdapter(int layoutResId, @Nullable List<EatDrinkModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EatDrinkModel.PdBean item) {
//        Glide.with(mContext).load(item.getCONVERGEIMGS().get(0)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_one_img));
//        Glide.with(mContext).load(item.getCONVERGEIMGS().get(1)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_two_img));
//        Glide.with(mContext).load(item.getCONVERGEIMGS().get(2)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_three_img));
//        Glide.with(mContext).load(item.getCONVERGEIMGS().get(3)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_four_img));
        //活动方式
        helper.setText(R.id.hj_child_recycler_type_tv, "方式：" + item.getCONVERGETYPE());
        //设置活动开始事件
        helper.setText(R.id.hj_child_recycler_startTime_tv, "开始时间：" + item.getSTARTTIME());
        //设置活动结束时间
        helper.setText(R.id.hj_child_recycler_endTime_tv, "结束时间：" + item.getENDTIME());
        //设置活动人数
        helper.setText(R.id.hj_child_recycler_people_number_tv, "人数：" + item.getCONVERGEPER());
        //设置活动标题
        helper.setText(R.id.hj_child_recycler_title_tv, item.getCONVERGETITLE());
        helper.addOnClickListener(R.id.hj_child_recycler_linear);
        helper.addOnClickListener(R.id.hj_child_recycler_head_img);
    }
}
