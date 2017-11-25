package com.zsh.blackcard.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeGloryMagazineModel;
import com.zsh.blackcard.model.HomeGloryServiceModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * 荣耀杂志适配器
 */

public class HomeGloryMagazineAdapter extends BaseMultiItemQuickAdapter<HomeGloryMagazineModel, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeGloryMagazineAdapter(List<HomeGloryMagazineModel> data) {
        super(data);
        addItemType(HomeGloryMagazineModel.LEFT, R.layout.home_glory_magazine_recycler_first_item);
        addItemType(HomeGloryMagazineModel.CENTER, R.layout.home_glory_magazine_recycler_item);
        addItemType(HomeGloryMagazineModel.RIGHT, R.layout.home_glory_magazine_recycler_last_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGloryMagazineModel item) {

        if (helper.getLayoutPosition() == 0) {
            initLoadImage(helper);
        } else if (helper.getLayoutPosition() == 1) {
            initLoadImage(helper);
        } else if (helper.getLayoutPosition() == 2) {
            initLoadImage(helper);
        } else {
            initLoadImage(helper);
        }
    }

    private void initLoadImage(BaseViewHolder helper) {
        switch (helper.getItemViewType()) {
            case HomeGloryMagazineModel.LEFT:
                helper.setImageResource(R.id.home_glory_magazine_recycler_item_img, R.mipmap.home_image_9);
                break;
            case HomeGloryMagazineModel.CENTER:
                if(helper.getLayoutPosition() == 2){
                    helper.setImageResource(R.id.home_glory_magazine_recycler_item_img, R.mipmap.home_image_10);
                }else{
                    helper.setImageResource(R.id.home_glory_magazine_recycler_item_img, R.mipmap.home_image_11);
                }
                break;
            case HomeGloryMagazineModel.RIGHT:
                helper.setImageResource(R.id.home_glory_magazine_recycler_item_img, R.mipmap.home_image_12);
                break;
        }
    }
}
