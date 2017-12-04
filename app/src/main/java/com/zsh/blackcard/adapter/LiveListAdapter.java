package com.zsh.blackcard.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.LiveInfoListModel;

import java.util.List;

/**
 * Name: LiveListAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class LiveListAdapter extends BaseQuickAdapter<LiveInfoListModel.DataBean.RoomListBean, BaseViewHolder> {
    private Context context;

    public LiveListAdapter(Context context, @Nullable List<LiveInfoListModel.DataBean.RoomListBean> data) {
        super(R.layout.live_anchor_list_item, data);
        this.context = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, LiveInfoListModel.DataBean.RoomListBean item) {

        helper.setText(R.id.tv_name, item.getRoom_name());
        helper.setText(R.id.tv_name2, item.getAnchor_nick_name());
//        helper.setText(R.id.tv_time, item.getEVALUATEDATE());
//        //TODO
//        helper.setText(R.id.tv_content, item.getEVALUATECONTENT());
////
//        Glide.with(context).load(item.getPORTRAIT()).into((ImageView) helper.getView(R.id.im_head));


    }
}
