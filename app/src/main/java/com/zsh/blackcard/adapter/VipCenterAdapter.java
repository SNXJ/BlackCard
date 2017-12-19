package com.zsh.blackcard.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MyVipCenterModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/10.
 * 我的界面Vip中心适配器
 */

public class VipCenterAdapter extends BaseMultiItemQuickAdapter<MyVipCenterModel.ListBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public VipCenterAdapter(List<MyVipCenterModel.ListBean> data) {
        super(data);
        addItemType(MyVipCenterModel.ListBean.LEFT, R.layout.vip_center_recycler_first_item);
        addItemType(MyVipCenterModel.ListBean.CENTER, R.layout.vip_center_recycler_item);
        addItemType(MyVipCenterModel.ListBean.RIGHT, R.layout.vip_center_recycler_last_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyVipCenterModel.ListBean item) {
        helper.setText(R.id.vip_center_name_tv, item.getWELFARENAME());
        helper.setText(R.id.vip_center_power_tv, "能量值" + item.getENERGYVALUE() + "以上");
    }

}
