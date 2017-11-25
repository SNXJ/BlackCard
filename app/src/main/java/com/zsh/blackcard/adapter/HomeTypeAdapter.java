package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.HomePrivilegeModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/21.
 * title头部适配器
 */

public class HomeTypeAdapter extends BaseQuickAdapter<HomePrivilegeModel.PdBean,BaseViewHolder> {

    public HomeTypeAdapter(int layoutResId, @Nullable List<HomePrivilegeModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomePrivilegeModel.PdBean item) {
        helper.setText(R.id.home_type_recycler_tv,item.getPRIVILEGENAME());
        Glide.with(mContext).load(item.getPRIVILEGEIMGS()).into((ImageView) helper.getView(R.id.home_type_recycler_img));
    }
}
