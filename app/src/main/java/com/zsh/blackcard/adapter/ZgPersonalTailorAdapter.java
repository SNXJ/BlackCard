package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ZgPersonalTailorModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/24.
 * 尊购侧滑界面私人定制列表适配器
 */

public class ZgPersonalTailorAdapter extends BaseQuickAdapter<ZgPersonalTailorModel.PdBean, BaseViewHolder> {
    public ZgPersonalTailorAdapter(int layoutResId, @Nullable List<ZgPersonalTailorModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgPersonalTailorModel.PdBean item) {
        Glide.with(mContext).load(item.getPERSONALIMGS()).into((ImageView) helper.getView(R.id.zg_drawer_personal_recycler_img));
        helper.setText(R.id.zg_drawer_personal_recycler_china_tv, item.getIMGSCNCHAR());
        helper.setText(R.id.zg_drawer_personal_recycler_english_tv, item.getIMGENCHAR());
        helper.addOnClickListener(R.id.zg_drawer_personal_recycler_more_tv);
    }
}
