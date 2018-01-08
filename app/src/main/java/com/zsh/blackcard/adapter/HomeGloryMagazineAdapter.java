package com.zsh.blackcard.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeGloryMagazineModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * 荣耀杂志适配器
 */

public class HomeGloryMagazineAdapter extends BaseMultiItemQuickAdapter<HomeGloryMagazineModel.PdBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeGloryMagazineAdapter(List<HomeGloryMagazineModel.PdBean> data) {
        super(data);
        addItemType(HomeGloryMagazineModel.PdBean.LEFT, R.layout.home_glory_magazine_recycler_first_item);
        addItemType(HomeGloryMagazineModel.PdBean.CENTER, R.layout.home_glory_magazine_recycler_item);
        addItemType(HomeGloryMagazineModel.PdBean.RIGHT, R.layout.home_glory_magazine_recycler_last_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGloryMagazineModel.PdBean item) {
        Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.home_glory_magazine_recycler_item_img));
    }
}
