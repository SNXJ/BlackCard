package com.zsh.blackcard.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeGloryServiceModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * 荣耀服务适配器
 */

public class HomeGloryServiceAdapter extends BaseMultiItemQuickAdapter<HomeGloryServiceModel, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeGloryServiceAdapter(List<HomeGloryServiceModel> data) {
        super(data);
        addItemType(HomeGloryServiceModel.LEFT, R.layout.home_glory_service_recycler_first_item);
        addItemType(HomeGloryServiceModel.CENTER, R.layout.home_glory_service_recycler_item);
        addItemType(HomeGloryServiceModel.RIGHT, R.layout.home_glory_service_recycler_last_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGloryServiceModel item) {
        switch (helper.getItemViewType()) {
            case HomeGloryServiceModel.LEFT:
                helper.setImageResource(R.id.home_glory_service_recycler_item_img,R.mipmap.home_image_5);
                helper.setText(R.id.home_glory_service_recycler_item_tv,"艺海品鉴");
                break;
            case HomeGloryServiceModel.CENTER:
                helper.setImageResource(R.id.home_glory_service_recycler_item_img,R.mipmap.home_image_6);
                helper.setText(R.id.home_glory_service_recycler_item_tv,"金鹿救援");
                break;
            case HomeGloryServiceModel.RIGHT:
                helper.setImageResource(R.id.home_glory_service_recycler_item_img,R.mipmap.home_image_7);
                helper.setText(R.id.home_glory_service_recycler_item_tv,"九富投资顾问");
                break;
        }
    }
}
