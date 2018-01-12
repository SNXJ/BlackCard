package com.zsh.blackcard.custom;

import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.shing.topdialoglibrary.BottomTopDialogFragment;
import com.zsh.blackcard.R;


/**
 * Name: NewTopDialog
 * Author: Shing
 * Date: 2018/1/10 下午8:51
 * Description: ..
 */

public class NewTopDialog extends BottomTopDialogFragment {

    View belowView ;
    @Override
    public void bindContent(ViewGroup viewGroup) {
        viewGroup.findViewById(R.id.ll_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();


            }
        });

    }

    @Override
    public int getContentLayoutId() {
        return R.layout.news_send_dialog;
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
