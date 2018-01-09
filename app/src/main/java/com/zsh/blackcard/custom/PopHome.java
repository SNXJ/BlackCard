package com.zsh.blackcard.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ItemClickListener;
import com.zsh.blackcard.utils.BitmapUtils;
import com.zsh.blackcard.utils.FastBlur;

/**
 * Name: PopHome
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:描述：
 */
public class PopHome extends PopupWindow {
    private View mainView;
    private RelativeLayout rl_sao, rl_msg, rl_sys_msg, rl_vip;

    public PopHome(Context paramActivity, final ItemClickListener listener) {
        super(paramActivity);
        //窗口布局
        mainView = LayoutInflater.from(paramActivity).inflate(R.layout.home_pop, null);
        //分享布局
        rl_sao = ((RelativeLayout) mainView.findViewById(R.id.rl_sao));
        //复制布局
        rl_msg = (RelativeLayout) mainView.findViewById(R.id.rl_msg);
        rl_sys_msg = (RelativeLayout) mainView.findViewById(R.id.rl_sys_msg);
        rl_vip = (RelativeLayout) mainView.findViewById(R.id.rl_vip);
        rl_sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(0);
            }
        });
        rl_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(1);
            }
        });
        rl_sys_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(2);
            }
        });
        rl_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(3);
            }
        });
        setContentView(mainView);
        //设置宽度
        setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        //设置高度
        setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        //设置显示隐藏动画
        setAnimationStyle(R.style.home_pop_anim);
        //设置背景透明
//        setBackgroundDrawable(new ColorDrawable(80));

    }
}
