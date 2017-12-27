package com.zsh.blackcard.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.MyPowerModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/15.
 */

public class MyPowerRecyclerAdapter extends BaseQuickAdapter<MyPowerModel.PdBean, BaseViewHolder> {
    public MyPowerRecyclerAdapter(int layoutResId, @Nullable List<MyPowerModel.PdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPowerModel.PdBean item) {
        switch (helper.getLayoutPosition()) {
            case 0:
                ((TextView) helper.getView(R.id.my_power_item_score_tv)).setTextColor(Color.parseColor("#FFD48B32"));
                ((TextView) helper.getView(R.id.my_power_item_score_name_tv)).setTextColor(Color.parseColor("#FFD48B32"));
                break;
            case 1:
                ((TextView) helper.getView(R.id.my_power_item_score_tv)).setTextColor(Color.parseColor("#FF4B70C5"));
                ((TextView) helper.getView(R.id.my_power_item_score_name_tv)).setTextColor(Color.parseColor("#FF4B70C5"));
                break;
            case 2:
                ((TextView) helper.getView(R.id.my_power_item_score_tv)).setTextColor(Color.parseColor("#FFE34C4C"));
                ((TextView) helper.getView(R.id.my_power_item_score_name_tv)).setTextColor(Color.parseColor("#FFE34C4C"));
                break;
            case 3:
                ((TextView) helper.getView(R.id.my_power_item_score_tv)).setTextColor(Color.parseColor("#FFEBE758"));
                ((TextView) helper.getView(R.id.my_power_item_score_name_tv)).setTextColor(Color.parseColor("#FFEBE758"));
                break;
            case 4:
                ((TextView) helper.getView(R.id.my_power_item_score_tv)).setTextColor(Color.parseColor("#FF69E2D3"));
                ((TextView) helper.getView(R.id.my_power_item_score_name_tv)).setTextColor(Color.parseColor("#FF69E2D3"));
                break;
        }
        helper.setText(R.id.my_power_item_score_tv,String.valueOf(item.getSCORE()));
        helper.setText(R.id.my_power_item_score_name_tv,item.getNAME());
    }
}
