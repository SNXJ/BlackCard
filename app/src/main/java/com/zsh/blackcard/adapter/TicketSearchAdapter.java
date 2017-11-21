package com.zsh.blackcard.adapter;


import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.TicketSearchModel;

import java.util.List;

/**
 * Name: TicketSearchAdapter
 * Author: SNXJ
 * Date: 2017-11-21
 * Description:描述：
 */
public class TicketSearchAdapter extends BaseQuickAdapter<TicketSearchModel, BaseViewHolder> {


    private int type;

    public TicketSearchAdapter(List<TicketSearchModel> data, int type) {
        super(R.layout.ticket_search_train_item, data);

        // super(R.layout.ticket_search_plan_item, data);
        this.type = type;
    }

    @Override
    protected void convert(final BaseViewHolder helper, TicketSearchModel item) {
        helper.getView(R.id.ll_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
