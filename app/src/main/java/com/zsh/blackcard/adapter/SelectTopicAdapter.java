package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.TopicListModel;

import java.util.List;


/**
 * Name: SelectTopicAdapter
 * Author: Shing
 * Date: 17/12/26 上午11:07
 * Description: ..
 */

public class SelectTopicAdapter extends BaseQuickAdapter<TopicListModel.PdBean,BaseViewHolder> {
    public SelectTopicAdapter(@Nullable List<TopicListModel.PdBean> data) {
        super(R.layout.item_select_topic,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TopicListModel.PdBean item) {

            helper.setText(R.id.tv_topic,"#"+item.getTITLE()+"#");
            helper.setText(R.id.tv_des,item.getDESCRIPTION());
            if(null!=item.getTITLE()){
                helper.setText(R.id.tv_img_,item.getTITLE().substring(0,1));
            }


    }
}
