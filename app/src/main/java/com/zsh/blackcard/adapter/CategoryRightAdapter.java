package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.CategoryRightModel;

import java.util.List;

/**
 * Name: CategoryLeftAdapter
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:
 * 尊购界面商品分类右边列表 适配器
 */
public class CategoryRightAdapter extends BaseQuickAdapter<CategoryRightModel.PdBean, BaseViewHolder> {

    public CategoryRightAdapter(int layoutResId, @Nullable List<CategoryRightModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryRightModel.PdBean item) {
        helper.setText(R.id.category_right_name_tv,item.getSHOPNAME());
        helper.setText(R.id.category_right_count_tv,"共"+item.getPRODUCT_COUNT()+"件宝贝");
        Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.category_right_head_img));
        Glide.with(mContext).load(item.getPRODUCTIMGS().get(0)).into((ImageView) helper.getView(R.id.category_right_one_img));
        Glide.with(mContext).load(item.getPRODUCTIMGS().get(1)).into((ImageView) helper.getView(R.id.category_right_two_img));
        Glide.with(mContext).load(item.getPRODUCTIMGS().get(2)).into((ImageView) helper.getView(R.id.category_right_three_img));
        Glide.with(mContext).load(item.getPRODUCTIMGS().get(3)).into((ImageView) helper.getView(R.id.category_right_four_img));
    }
}
