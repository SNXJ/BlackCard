package com.zsh.blackcard.untils;

import com.zsh.blackcard.model.FetureDateModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Name: MyCalendar
 * Author: SNXJ
 * Date: 2017-11-23
 * Description: 时间间隔
 */
public class MyCalendar {

    public static int getNowYear() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR);
    }

    public static int getNowMonth() {
        Calendar now = Calendar.getInstance();
        return (now.get(Calendar.MONTH) + 1);

    }

    /**
     * 是否是今天之前
     *
     * @param date
     * @return
     */
    public static boolean todayBefore(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(new Date());

        int i = -1;
        try {
            i = getDateSpace(dateNowStr, date);
        } catch (Exception e) {

        }
        LogUtils.i("++++++++iii++++++++++", "++++++++++iiiii+++++++++++" + i);
        if (i < 0) {
            return true;
        } else {
            return false;
        }


    }

    /**
     * 获取未来天数的  日期与对应的星期
     *
     * @param intervals
     * @return
     */

    public static ArrayList<FetureDateModel> getFetureDate_week(int intervals) {
        ArrayList<FetureDateModel> fetureDaysList = new ArrayList<>();
        for (int i = 0; i < intervals; i++) {
            fetureDaysList.add(getFetureDate(i));
        }
        return fetureDaysList;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取过去或者未来 任意天内的日期数组
     *
     * @param intervals intervals天内
     * @return 日期数组
     */
//    public static ArrayList<FetureDateModel> test(int intervals) {
//        // ArrayList<FetureDateModel> pastDaysList = new ArrayList<>();
//        ArrayList<FetureDateModel> fetureDaysList = new ArrayList<>();
//        for (int i = 0; i < intervals; i++) {
//            //  pastDaysList.add(getPastDate(i));
//            fetureDaysList.add(getFetureDate(i));
//        }
//        return fetureDaysList;
//    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();

        //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        String result = format.format(today);
        String week = getWeekOfDate(today);
        //  LogUtils.i(null, result + "++++++++++++++++++" + week);
        return result;
    }

    /**
     * 获取未来 第 past 天的日期
     *
     * @param past
     * @return
     */
    public static FetureDateModel getFetureDate(int past) {
        String week;
        FetureDateModel date = new FetureDateModel();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        String result = format.format(today);
        if (past == 0) {
            week = "今天";
        } else {
            week = getWeekOfDate(today);
        }
        date.setMouth_day(result);
        date.setWeek(week);
        // LogUtils.i(null, result + "++++++++++++++++++" + week);
        return date;
    }

    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }

    public static int getDateSpace(String date1, String date2)
            throws ParseException {
        if (null == date1) {
            return 0;
        }
        if (null == date2) {
            return 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int result = 0;
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();

        calst.setTime(sdf.parse(date1));
        caled.setTime(sdf.parse(date2));

        //设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
        if (days < 0) {
            return -1;
        }
        return days;
    }

    public static final int daysBetween(Date early, Date late) {

        java.util.Calendar calst = java.util.Calendar.getInstance();
        java.util.Calendar caled = java.util.Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calst.set(java.util.Calendar.MINUTE, 0);
        calst.set(java.util.Calendar.SECOND, 0);
        caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
        caled.set(java.util.Calendar.MINUTE, 0);
        caled.set(java.util.Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;

        return days;
    }
}
