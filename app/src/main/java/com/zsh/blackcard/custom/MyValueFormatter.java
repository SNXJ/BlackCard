package com.zsh.blackcard.custom;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by kkkkk on 2017/12/16.
 */

public class MyValueFormatter implements IAxisValueFormatter {

    private String[] mValues;

    public MyValueFormatter(String[] mValues) {
        this.mValues = mValues;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mValues[(int) value % mValues.length];
    }
}
