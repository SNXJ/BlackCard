package com.zsh.blackcard.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.RegisterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/10.
 * 星座卡适配器
 */

public class RegisterCardConstellationAdapter extends RecyclerView.Adapter<RegisterCardConstellationAdapter.MyViewHolder> {

    private Context context;
    private List<Boolean> isCheck = new ArrayList<>();

    private RegisterConstellationOnItemClick registerConstellationOnItemClick;

    public RegisterCardConstellationAdapter(RegisterActivity registerActivity) {
        this.context = registerActivity;
        for (int i = 0; i < 12; i++) {
            isCheck.add(false);
        }
    }

    public void setRegisterConstellationOnItemClick(RegisterConstellationOnItemClick registerConstellationOnItemClick) {
        this.registerConstellationOnItemClick = registerConstellationOnItemClick;
    }

    public interface RegisterConstellationOnItemClick {
        void constellationOnItemClick(int position);
    }

    public void initSelect() {
        for (int i = 0; i < 12; i++) {
            isCheck.set(i, false);
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
                holder.register_card_tv.setText("白羊座");
                break;
            case 1:
                holder.register_card_tv.setText("金牛座");
                break;
            case 2:
                holder.register_card_tv.setText("双子座");
                break;
            case 3:
                holder.register_card_tv.setText("巨蟹座");
                break;
            case 4:
                holder.register_card_tv.setText("狮子座");
                break;
            case 5:
                holder.register_card_tv.setText("处女座");
                break;
            case 6:
                holder.register_card_tv.setText("天秤座");
                break;
            case 7:
                holder.register_card_tv.setText("天蝎座");
                break;
            case 8:
                holder.register_card_tv.setText("射手座");
                break;
            case 9:
                holder.register_card_tv.setText("摩蝎座");
                break;
            case 10:
                holder.register_card_tv.setText("水瓶座");
                break;
            case 11:
                holder.register_card_tv.setText("双鱼座");
                break;
        }

        //根据状态给item设置背景色
        if (isCheck.get(position)) {
            holder.register_card_tv.setTextColor(Color.parseColor("#FFF29E19"));
            holder.register_card_tv.setBackgroundResource(R.drawable.register_drawable);
        } else {
//            holder.register_card_tv.setTextColor(Color.parseColor("#FF929292"));
            holder.register_card_tv.setBackgroundResource(R.drawable.register_drawable_f);
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //设置监听回调
                if (registerConstellationOnItemClick != null) {
                    registerConstellationOnItemClick.constellationOnItemClick(position);
                }

                for (int i = 0; i < 12; i++) {
                    isCheck.set(i, false);
                }

                isCheck.set(position, true);

                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return 12;
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
