package com.zsh.blackcard.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeTopModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * 头条适配器
 */

public class HomeTopAdapter extends BaseMultiItemQuickAdapter<HomeTopModel.PdBean, BaseViewHolder> {

    private Context context;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeTopAdapter(List<HomeTopModel.PdBean> data, Context context) {
        super(data);
        this.context = context;
        addItemType(HomeTopModel.PdBean.LEFT, R.layout.home_top_recycler_first_item);
        addItemType(HomeTopModel.PdBean.CENTER, R.layout.home_top_recycler_item);
        addItemType(HomeTopModel.PdBean.RIGHT, R.layout.home_top_recycler_last_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeTopModel.PdBean item) {
        switch (helper.getItemViewType()) {
            case HomeTopModel.PdBean.LEFT:
                helper.setText(R.id.home_top_recycler_item_tv, item.getSHOPNAME());
                Glide.with(context).load(item.getIMAGES()).into((ImageView) helper.getView(R.id.home_top_recycler_item_img));
                break;
            case HomeTopModel.PdBean.CENTER:
                helper.setText(R.id.home_top_recycler_item_tv, item.getSHOPNAME());
                Glide.with(context).load(item.getIMAGES()).into((ImageView) helper.getView(R.id.home_top_recycler_item_img));
                break;
            case HomeTopModel.PdBean.RIGHT:
                helper.setText(R.id.home_top_recycler_item_tv, item.getSHOPNAME());
                Glide.with(context).load(item.getIMAGES()).into((ImageView) helper.getView(R.id.home_top_recycler_item_img));
                break;
        }
    }
}
