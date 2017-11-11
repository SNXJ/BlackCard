package com.zsh.blackcard.custom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.live.LiveAnchorDetails;

/**
 * Name: PublicDialog
 * Author: SNXJ
 * Date: 2017-11-10
 * Description: 弹窗
 */
public class PublicDialog {
    public static void liveDialog(final Context mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_room_dialog, null);
        LinearLayout ll=(LinearLayout)view.findViewById(R.id.ll_dialog_go);
        // 设置style 控制默认dialog带来的边距问题
        final Dialog dialog = new Dialog(mContext, R.style.pub_loading_dialog);
        dialog.setContentView(view);
        dialog.show();
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, LiveAnchorDetails.class);
                mContext.startActivity(intent);
            }
        });

        // 设置相关位置，一定要在 show()之后
        Window window = dialog.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.setCanceledOnTouchOutside(true);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);


    }
}
