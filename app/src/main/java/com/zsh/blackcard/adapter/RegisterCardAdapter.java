package com.zsh.blackcard.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.RegisterActivity;
import com.zsh.blackcard.ui.VipCenterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/10.
 */

public class RegisterCardAdapter extends RecyclerView.Adapter<RegisterCardAdapter.MyViewHolder> {

    private Context context;
    private List<Boolean> isCheck = new ArrayList<>();

    public void setRegisterCardOnItemClick(RegisterCardOnItemClick registerCardOnItemClick) {
        this.registerCardOnItemClick = registerCardOnItemClick;
    }

    private RegisterCardOnItemClick registerCardOnItemClick;


    public interface RegisterCardOnItemClick {
        void cardOnItemClick(int position);
    }

    public RegisterCardAdapter(RegisterActivity registerActivity) {
        this.context = registerActivity;
        //初始化默认所有item未被选择
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                isCheck.add(true);
            } else {
                isCheck.add(false);
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.register_card_recycler_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        switch (position) {
            case 0:
                holder.register_card_tv.setText("荣耀黑卡");
                break;
            case 1:
                holder.register_card_tv.setText("名人联名卡");
                break;
            case 2:
                holder.register_card_tv.setText("12星座卡");
                break;
            case 3:
                holder.register_card_tv.setText("周易五行卡");
                break;
        }

        //根据状态给item设置背景色
        if (isCheck.get(position)) {
            holder.register_card_tv.setBackgroundResource(R.mipmap.border_11);
            holder.register_card_tv.setTextColor(Color.parseColor("#FFF29E19"));
        } else {
            holder.register_card_tv.setTextColor(Color.parseColor("#FF929292"));
            holder.register_card_tv.setBackgroundResource(R.mipmap.border_12);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //设置监听回调
                if (registerCardOnItemClick != null) {
                    registerCardOnItemClick.cardOnItemClick(position);
                }

                //此处先回调，在更新
                for (int i = 0; i < 4; i++) {
                    isCheck.set(i, false);
                }

                isCheck.set(position, true);

                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
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

    public boolean getSelectStatus(int position) {
        return isCheck.get(position);
    }
}
