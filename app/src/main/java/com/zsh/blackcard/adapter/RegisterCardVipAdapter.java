package com.zsh.blackcard.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.model.RegisterChangeNumberModel;
import com.zsh.blackcard.ui.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class RegisterCardVipAdapter extends RecyclerView.Adapter<RegisterCardVipAdapter.MyViewHolder> {

    private Context context;
    private List<Boolean> isCheck = new ArrayList<>();
    private List<RegisterChangeNumberModel.PdBean> pd;

    private RegisterVipOnItemClick registerVipOnItemClick;

    public void setRegisterVipOnItemClick(RegisterVipOnItemClick registerVipOnItemClick) {
        this.registerVipOnItemClick = registerVipOnItemClick;
    }

    public interface RegisterVipOnItemClick {
        void vipOnItemClick(int position);
    }

    public RegisterCardVipAdapter(RegisterActivity registerActivity, List<RegisterChangeNumberModel.PdBean> pd) {
        this.context = registerActivity;
        this.pd = pd;
        //初始化默认所有item未被选择
        for (int i = 0; i < pd.size(); i++) {
            isCheck.add(false);
        }
    }

    public void initSelect() {
        for (int i = 0; i < pd.size(); i++) {
            isCheck.set(i, false);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.register_card_manual_recycler_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.register_card_tv.setText(pd.get(position).getCARDNUM());

        //根据状态给item设置背景色
        if (isCheck.get(position)) {
            holder.register_card_tv.setBackgroundResource(R.drawable.group_9);
            holder.register_card_tv.setTextColor(Color.parseColor("#FFF29E19"));
        } else {
            holder.register_card_tv.setTextColor(Color.parseColor("#FF929292"));
            holder.register_card_tv.setBackgroundResource(R.drawable.group_10);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < pd.size(); i++) {
                    isCheck.set(i, false);
                }

                isCheck.set(position, true);

                notifyDataSetChanged();

                //设置监听回调
                if (registerVipOnItemClick != null) {
                    registerVipOnItemClick.vipOnItemClick(position);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return pd.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.register_card_tv)
        TextView register_card_tv;

        private View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            view = itemView;
        }
    }

    //供外部点击item获取当前选择卡号
    public String getItemData(int position){
        return  pd.get(position).getCARDNUM();
    }

    //清空数据，并且刷新
    public void clearAndRefresh(List<RegisterChangeNumberModel.PdBean> pd) {
        for (int i = 0; i < pd.size(); i++) {
            isCheck.set(i, false);
        }

        this.pd.clear();
        this.pd.addAll(pd);
        notifyDataSetChanged();
    }
}
