package com.zsh.blackcard.untils;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * 这是滚轮选择和滚轮日历选择的工具类 2015/12/11
 *
 * @author sxj
 */
public class WheelViewUntil {
    public String dividerColor = "#4a8bde";// 蓝色

    /**
     * 日历控件
     *
     * @param context  上下文
     * @param textview 需要回显的控件
     */
    @SuppressLint("NewApi")
    public static String getDate(final Context context,
                                 final TextView textview, final int yearData) {
        Time time = new Time("GMT+8");
        time.setToNow();
        int year = time.year;
        int month = time.month;
        int day = time.monthDay;

        DatePickerDialog datePicker = new DatePickerDialog(context,
                new OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        textview.setText(year + "-" + (monthOfYear + 1) + "-"
                                + dayOfMonth);
                    }
                }, year, month, day);

        setDatePickerDividerColor(datePicker.getDatePicker(),
                Color.parseColor("#ff6000"));
        datePicker.show();

        dialogTitleLineColor(datePicker, Color.parseColor("#ff6000"));
        return null;
    }

    /**
     * WhileView选择dialog控件 并可改变颜色
     *
     * @param context      上下文
     * @param PLANETS      需要选择的内容字符数组
     * @param title        标题
     * @param textview     需要回显的控件
     */
//    public static void getWheelView(Context context, String[] PLANETS,
//                                    String title, final TextView textview) {
//        View outerView = LayoutInflater.from(context).inflate(
//                R.layout.wheel_view, null);
//        WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_view_wv);
//        wv.setOffset(1);
//        wv.setItems(Arrays.asList(PLANETS));
//        wv.setSeletion(1);
//        wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//            @Override
//            public void onSelected(int selectedIndex, String item) {
//
//                textview.setText(item);
//            }
//        });
//
//        AlertDialog al = new AlertDialog.Builder(context)
//                .setTitle("请选择:" + title).setView(outerView)
//                .setPositiveButton("确定", null).show();
//        dialogTitleLineColor(al, Color.parseColor("#ff6000"));
//
//    }

    /**
     * 修改dialog的主题样式（标题与下划线）
     *
     * @param dialog 对象
     * @param color
     */
    public static final void dialogTitleLineColor(Dialog dialog, int color) {
        Context context = dialog.getContext();
        // 标题横线的颜色
        int divierId = context.getResources().getIdentifier(
                "android:id/titleDivider", null, null);
        View divider = dialog.findViewById(divierId);
        divider.setBackgroundColor(color);
        // 标题的颜色
        int divierTitleId = context.getResources().getIdentifier(
                "android:id/alertTitle", null, null);
        TextView dividerTitle = (TextView) dialog.findViewById(divierTitleId);
        dividerTitle.setTextColor(color);

        // 确定按钮的颜色
        final int button = context.getResources().getIdentifier("button1",
                "id", "android");
        Button positiveButton = (Button) dialog.findViewById(button);

        // positiveButton.setBackgroundResource(R.drawable.button_selector);
        // positiveButton.setVisibility(View.VISIBLE);
        positiveButton.setTextColor(color);

    }

    /**
     * 设置时间选择器的分割线颜色
     *
     * @param datePicker
     */
    @SuppressLint("NewApi")
    private static void setDatePickerDividerColor(DatePicker datePicker,
                                                  int color) {
        // Divider changing:

        // 获取 mSpinners
        LinearLayout llFirst = (LinearLayout) datePicker.getChildAt(0);

        // 获取 NumberPicker
        LinearLayout mSpinners = (LinearLayout) llFirst.getChildAt(0);
        for (int i = 0; i < mSpinners.getChildCount(); i++) {
            NumberPicker picker = (NumberPicker) mSpinners.getChildAt(i);

            Field[] pickerFields = NumberPicker.class.getDeclaredFields();
            for (Field pf : pickerFields) {
                if (pf.getName().equals("mSelectionDivider")) {
                    pf.setAccessible(true);
                    try {
                        pf.set(picker, new ColorDrawable(color));
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

//    /**
//     * TextView 男女选择控件
//     *
//     * @param context 上下文
//     * @param v1      选中TextView
//     * @param v2      未选中TextView
//     * @return String (男/女)
//     */
//
//    @SuppressLint("NewApi")
//    public static String selectSex(Context context, TextView v1, TextView v2) {
//        v1.setBackground(context.getResources().getDrawable(
//                R.drawable.on_button));
//        v1.setTextColor(context.getResources().getColor(R.color.bg_white));
//        v2.setBackground(context.getResources().getDrawable(
//                R.drawable.off_button));
//        v2.setTextColor(context.getResources().getColor(R.color.bg_black));
//        return (String) v1.getText();
//    }

}
