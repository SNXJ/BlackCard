package com.zsh.blackcard.custom;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Name: AbSpacesItemDecoration
 * Author: Shing
 * Date: 2018/2/2 上午10:09
 * Description: ..
 */

public class AbSpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public AbSpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        //注释这两行是为了上下间距相同
//        if(parent.getChildAdapterPosition(view)==0){
        outRect.top = space;
//        }
    }
}
