package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.EatDrinkRecyclerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/5.
 * 汇聚页面指定聚会列表
 */

public class EatDrinkRecyclerAdapter extends BaseMultiItemQuickAdapter<EatDrinkRecyclerModel.PdBean, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public EatDrinkRecyclerAdapter(List<EatDrinkRecyclerModel.PdBean> data) {
        super(data);
        addItemType(EatDrinkRecyclerModel.PdBean.YES, R.layout.hj_child_recycler_item);
        addItemType(EatDrinkRecyclerModel.PdBean.NO, R.layout.hj_child_recycler_no_img_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, EatDrinkRecyclerModel.PdBean item) {
        if (!item.getDistance().equals("0")) {
            helper.setText(R.id.hj_child_recycler_item_age, item.getDistance().substring(0, item.getDistance().indexOf(".")) + "Km    " + item.getAge() + "岁");
        } else {
            helper.setText(R.id.hj_child_recycler_item_age, item.getDistance() + "Km    " + item.getAge() + "岁");
        }
        helper.setText(R.id.hj_child_recycler_startTime_tv, "开始时间：" + item.getSTARTTIME());
        helper.setText(R.id.hj_child_recycler_endTime_tv, "结束时间：" + item.getENDTIME());
        helper.setText(R.id.hj_child_recycler_people_number_tv, "人数：" + item.getCONVERGEPER());
        helper.setText(R.id.hj_child_recycler_type_tv, "方式：" + item.getCONVERGETYPE());
        helper.setText(R.id.hj_child_recycler_title_tv, item.getCONVERGETITLE());
        helper.addOnClickListener(R.id.hj_child_recycler_item_linear);
        helper.addOnClickListener(R.id.tv_add_friend);
        if (item.getCONVERGEIMGS().size() == 1) {
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(0)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_one_img));
        } else if (item.getCONVERGEIMGS().size() == 2) {
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(0)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_one_img));
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(1)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_two_img));
        } else if (item.getCONVERGEIMGS().size() == 3) {
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(0)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_one_img));
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(1)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_two_img));
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(2)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_three_img));
        } else if (item.getCONVERGEIMGS().size() == 4) {
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(0)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_one_img));
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(1)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_two_img));
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(2)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_three_img));
            Glide.with(mContext).load(item.getCONVERGEIMGS().get(3)).into((ImageView) helper.getView(R.id.hj_child_recycler_item_four_img));
        }
    }
}
