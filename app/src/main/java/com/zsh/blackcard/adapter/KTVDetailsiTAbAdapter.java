package com.zsh.blackcard.adapter;

import android.content.Context;
import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.FetureDateModel;

import java.util.List;

/**
 * Name: HotelDetailsitemAdapter
 * Author: SNXJ
 * Date: 2017-11-23
 * Description:描述：
 */
public class KTVDetailsiTAbAdapter extends BaseQuickAdapter<FetureDateModel, BaseViewHolder> {
    private Context context;
    private int selectPos = 0;

    public KTVDetailsiTAbAdapter(Context context, List<FetureDateModel> data) {
        super(R.layout.ktv_tab_item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FetureDateModel item) {
        helper.setText(R.id.tab_text_1, item.getWeek());
        helper.setText(R.id.tab_text_2, item.getMouth_day());
        if (selectPos == helper.getAdapterPosition()) {
            helper.setTextColor(R.id.tab_text_1, Color.parseColor("#F29E19"));
            helper.setTextColor(R.id.tab_text_2, Color.parseColor("#F29E19"));
        } else {
            helper.setTextColor(R.id.tab_text_1, Color.parseColor("#FF929292"));
            helper.setTextColor(R.id.tab_text_2, Color.parseColor("#FF929292"));
        }
    }

    public void setSelectPos(int selectPos) {
        this.selectPos = selectPos;
    }
}
