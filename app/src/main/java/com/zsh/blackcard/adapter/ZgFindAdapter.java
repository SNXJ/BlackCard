package com.zsh.blackcard.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ZgFindModel;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by kkkkk on 2017/12/6.
 * 尊购发现页面条目对应适配器
 */

public class ZgFindAdapter extends BaseMultiItemQuickAdapter<ZgFindModel.PdBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ZgFindAdapter(List<ZgFindModel.PdBean> data) {
        super(data);
        addItemType(ZgFindModel.PdBean.VIDEO, R.layout.zg_find_video_item);
        addItemType(ZgFindModel.PdBean.IMAGE, R.layout.zg_find_image_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgFindModel.PdBean item) {
        switch (item.getItemType()) {
            case ZgFindModel.PdBean.VIDEO:
                helper.setText(R.id.zg_find_video_title, item.getTITLE());
                helper.setText(R.id.zg_find_video_number, item.getPAGEVIEWS() + "万人浏览");
                ((JZVideoPlayerStandard)helper.getView(R.id.zg_find_video)).setUp(item.getSHOWVIDEO(),JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"");
                break;
            case ZgFindModel.PdBean.IMAGE:
                helper.setText(R.id.zg_find_image_title,item.getTITLE());
                helper.setText(R.id.zg_find_image_number,item.getPAGEVIEWS());
//                Glide.with(mContext).load(item.get)
                break;
        }
    }
}
