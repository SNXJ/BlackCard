package com.zsh.blackcard.custom;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ItemClickListener;

/**
 * Name: PopGiftSelect
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:描述：
 */
public class PopGiftSelect extends PopupWindow {
    private View parentView;
    private LinearLayout ll_1314;

    public PopGiftSelect(Context paramActivity, final ItemClickListener listener) {
        super(paramActivity);
        //窗口布局
        parentView = LayoutInflater.from(paramActivity).inflate(R.layout.live_gifts_num_select_layout, null);
        parentView.findViewById(R.id.ll_1314).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.itemClick(1314);
            }
        });
        parentView.findViewById(R.id.ll_520).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(520);

            }
        });
        parentView.findViewById(R.id.ll_188).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(188);
            }
        });
        parentView.findViewById(R.id.ll_66).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(66);
            }
        });
        parentView.findViewById(R.id.ll_30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(30);
            }
        });
        parentView.findViewById(R.id.ll_other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(00);
            }
        });
        parentView.findViewById(R.id.ll_10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(10);
            }
        });
        parentView.findViewById(R.id.ll_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClick(01);
            }
        });

        setContentView(parentView);
        setPopConfig();


    }

    private int popupWidth;
    private int popupHeight;

    private void setPopConfig() {
//        this.setContentView(mDataView);//设置要显示的视图
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        this.setBackgroundDrawable(dw);
        this.setOutsideTouchable(true);// 设置外部触摸会关闭窗口

        //获取自身的长宽高
        parentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupHeight = parentView.getMeasuredHeight();
        popupWidth = parentView.getMeasuredWidth();
    }

    /**
     * 设置显示在v上方(以v的左边距为开始位置)
     *
     * @param v
     */
    public void showUp(View v) {
        //获取需要在其上方显示的控件的位置信息
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        //在控件上方显示
        showAtLocation(v, Gravity.NO_GRAVITY, (location[0]) - popupWidth / 2, location[1] - popupHeight);
    }

    /**
     * 设置显示在v上方（以v的中心位置为开始位置）
     *
     * @param v
     */
    public void showUp2(View v) {
        //获取需要在其上方显示的控件的位置信息
        int[] location = new int[2];
        v.getLocationOnScreen(location);


        //在控件上方显示
        showAtLocation(v, Gravity.NO_GRAVITY, (location[0] + v.getWidth() / 2) - popupWidth / 2, 95);
    }
}


