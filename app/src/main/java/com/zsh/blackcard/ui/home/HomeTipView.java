package com.zsh.blackcard.ui.home;

import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.shing.topdialoglibrary.BottomTopDialogFragment;
import com.zsh.blackcard.R;

/**
 * Created by ZCY on 2018/1/11.
 * 首页右上角Dialog弹窗
 */

public class HomeTipView extends BottomTopDialogFragment {

    View belowView ;

    private OnHomeTipItemClick onHomeTipItemClick;

    public void setOnHomeTipItemClick(OnHomeTipItemClick onHomeTipItemClick) {
        this.onHomeTipItemClick = onHomeTipItemClick;
    }

    public interface OnHomeTipItemClick{
        void homeTipItemClick(int position);
    }

    @Override
    public void bindContent(ViewGroup viewGroup) {
        viewGroup.findViewById(R.id.rl_sao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onHomeTipItemClick != null){
                    onHomeTipItemClick.homeTipItemClick(0);
                }
            }
        });

        viewGroup.findViewById(R.id.rl_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onHomeTipItemClick != null){
                    onHomeTipItemClick.homeTipItemClick(1);
                }
            }
        });

        viewGroup.findViewById(R.id.rl_sys_msg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onHomeTipItemClick != null){
                    onHomeTipItemClick.homeTipItemClick(2);
                }
            }
        });

        viewGroup.findViewById(R.id.rl_vip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onHomeTipItemClick != null){
                    onHomeTipItemClick.homeTipItemClick(3);
                }
            }
        });

    }

    @Override
    public int getContentLayoutId() {
        return R.layout.home_pop;
    }

    @Override
    public int getGravity() {
        return Gravity.TOP;
    }

    @Override
    protected void contentShow() {
        bottomTopView.showBelow(belowView);
    }

    public void show(FragmentManager manager, String tag, View belowView) {
        this.belowView = belowView;
        show(manager, tag);
    }
}
