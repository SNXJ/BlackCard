package com.zsh.blackcard.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ZgPersonalTailorDatailModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/19.
 * 私人定制详情适配器
 */

public class ZgPersonalDetailAdapter extends BaseMultiItemQuickAdapter<ZgPersonalTailorDatailModel.PdBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ZgPersonalDetailAdapter(List<ZgPersonalTailorDatailModel.PdBean> data) {
        super(data);
        addItemType(ZgPersonalTailorDatailModel.PdBean.ONE, R.layout.zg_personal_one_item);
        addItemType(ZgPersonalTailorDatailModel.PdBean.TWO, R.layout.zg_personal_two_item);
        addItemType(ZgPersonalTailorDatailModel.PdBean.THREE, R.layout.zg_personal_three_item);
        addItemType(ZgPersonalTailorDatailModel.PdBean.FOUR, R.layout.zg_personal_four_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgPersonalTailorDatailModel.PdBean item) {
        switch (item.getItemType()) {
            case ZgPersonalTailorDatailModel.PdBean.ONE:
                Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.zg_personal_recycler_item_img));
                helper.setText(R.id.zg_personal_recycler_item_title_tv, item.getTITLE());
                helper.setText(R.id.zg_personal_recycler_item_content_tv, item.getCONTENT());
                break;
            case ZgPersonalTailorDatailModel.PdBean.TWO:
                Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.zg_personal_recycler_item_img));
                helper.setText(R.id.zg_personal_recycler_item_title_tv, item.getTITLE());
                helper.setText(R.id.zg_personal_recycler_item_content_tv, item.getCONTENT());
                break;
            case ZgPersonalTailorDatailModel.PdBean.THREE:
                Glide.with(mContext).load(item.getSHOWIMG()).into((ImageView) helper.getView(R.id.zg_personal_recycler_item_img));
                helper.setText(R.id.zg_personal_recycler_item_content_tv, item.getCONTENT());
                break;
            case ZgPersonalTailorDatailModel.PdBean.FOUR:
                helper.setText(R.id.zg_personal_recycler_item_title_tv, item.getTITLE());
                helper.setText(R.id.zg_personal_recycler_item_content_tv, item.getCONTENT());
                break;
        }
    }
}
