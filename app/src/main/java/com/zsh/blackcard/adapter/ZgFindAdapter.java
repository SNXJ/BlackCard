package com.zsh.blackcard.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
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
        addItemType(ZgFindModel.PdBean.IMAGE_ONE, R.layout.zg_find_image_one_item);
        addItemType(ZgFindModel.PdBean.IMAGE_THREE, R.layout.zg_find_image_three_item);
        addItemType(ZgFindModel.PdBean.TEXT, R.layout.zg_find_text_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgFindModel.PdBean item) {
        switch (item.getItemType()) {
            case ZgFindModel.PdBean.VIDEO:
                helper.setText(R.id.zg_find_video_title, item.getTITLE());
                helper.setText(R.id.zg_find_video_number, item.getPAGEVIEWS() + "万人浏览");
                ((JZVideoPlayerStandard) helper.getView(R.id.zg_find_video)).setUp(item.getSHOWVIDEO(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
                ImageView thumbImageView = ((JZVideoPlayerStandard) helper.getView(R.id.zg_find_video)).thumbImageView;
                thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                if (item.getVIDEOBACKIMAGE().size() != 0) {
                    Glide.with(mContext).load(item.getVIDEOBACKIMAGE().get(0)).into(thumbImageView);
                }
                break;
            case ZgFindModel.PdBean.IMAGE_ONE:
                helper.setText(R.id.zg_find_image_title, item.getTITLE());
                helper.setText(R.id.zg_find_image_number, item.getPAGEVIEWS() + "万人浏览");
                Glide.with(mContext).load(item.getVIDEOBACKIMAGE().get(0)).into((ImageView) helper.getView(R.id.zg_find_image_img));
                break;
            case ZgFindModel.PdBean.IMAGE_THREE:
                helper.setText(R.id.zg_find_image_title, item.getTITLE());
                helper.setText(R.id.zg_find_image_number, item.getPAGEVIEWS() + "万人浏览");
                Glide.with(mContext).load(item.getVIDEOBACKIMAGE().get(0)).into((ImageView) helper.getView(R.id.img_one));
                Glide.with(mContext).load(item.getVIDEOBACKIMAGE().get(1)).into((ImageView) helper.getView(R.id.img_two));
                Glide.with(mContext).load(item.getVIDEOBACKIMAGE().get(2)).into((ImageView) helper.getView(R.id.img_three));
                break;
            case ZgFindModel.PdBean.TEXT:
                helper.setText(R.id.zg_find_image_title, item.getTITLE());
                helper.setText(R.id.zg_find_image_number, item.getPAGEVIEWS() + "万人浏览");
                break;
        }
    }
}
