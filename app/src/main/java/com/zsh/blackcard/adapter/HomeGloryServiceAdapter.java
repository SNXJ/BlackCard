package com.zsh.blackcard.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomeGloryServerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * 荣耀服务适配器
 */

public class HomeGloryServiceAdapter extends BaseMultiItemQuickAdapter<HomeGloryServerModel.PdBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeGloryServiceAdapter(List<HomeGloryServerModel.PdBean> data) {
        super(data);
        addItemType(HomeGloryServerModel.PdBean.LEFT, R.layout.home_glory_service_recycler_first_item);
        addItemType(HomeGloryServerModel.PdBean.CENTER, R.layout.home_glory_service_recycler_item);
        addItemType(HomeGloryServerModel.PdBean.RIGHT, R.layout.home_glory_service_recycler_last_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGloryServerModel.PdBean item) {
        Glide.with(mContext).load(item.getSERVICEIMGS()).into((ImageView) helper.getView(R.id.home_glory_service_recycler_item_img));
        helper.setText(R.id.home_glory_service_recycler_item_tv, item.getSERVICETYPE());
    }
}
