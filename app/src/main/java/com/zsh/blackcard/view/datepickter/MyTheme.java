package com.zsh.blackcard.view.datepickter;


import android.content.Context;

import com.zsh.blackcard.R;

/**
 * Name: MyTheme
 * Author: SNXJ
 * Date: 2017-11-13
 * Description:描述：
 */
public class MyTheme extends DPTheme {
    private Context context;

    public MyTheme(Context context) {

        this.context = context;
    }

    @Override
    public int colorBG() {
        return context.getResources().getColor(R.color.translucence);
    }

    @Override
    public int colorBGCircle() {
        return context.getResources().getColor(R.color.bg_org);
    }

    @Override
    public int colorTitleBG() {
        return context.getResources().getColor(R.color.translucence);
    }

    @Override
    public int colorTitle() {
        return context.getResources().getColor(R.color.ff92_text);
    }

    @Override
    public int colorToday() {
        return context.getResources().getColor(R.color.fffd_text);
    }

    @Override
    public int colorG() {
        return context.getResources().getColor(R.color.ff92_text);
    }

    @Override
    public int colorF() {
        return context.getResources().getColor(R.color.ff92_text);
    }

    @Override
    public int colorWeekend() {
        return context.getResources().getColor(R.color.ff92_text);
    }

    @Override
    public int colorHoliday() {
        return context.getResources().getColor(R.color.ff92_text);
    }
}
