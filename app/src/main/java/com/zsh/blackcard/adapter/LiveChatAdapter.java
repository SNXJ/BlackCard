package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.LiveChatModel;

import java.util.List;


/**
 * Name: LiveViewerAdapter
 * Author: Shing
 * Date: 2018/1/9 下午5:15
 * Description: ..
 */

public class LiveChatAdapter extends BaseQuickAdapter<LiveChatModel,BaseViewHolder> {

    public LiveChatAdapter(@Nullable List<LiveChatModel> data) {
        super(R.layout.live_char_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiveChatModel item) {
        helper.setText(R.id.tv_chat_text,item.message);

    }
}
