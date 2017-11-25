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
        helper.setText(R.id.category_right_tv,item.getBRANDNAME());
        Glide.with(mContext).load(item.getICONIMGS()).into((ImageView) helper.getView(R.id.category_right_img));
    }
}
