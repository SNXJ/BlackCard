package com.zsh.blackcard.live;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;

import com.skyfishjy.library.RippleBackground;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.utils.MyCalendar;
import com.zsh.blackcard.view.datepickter.DPCManager;
import com.zsh.blackcard.view.datepickter.DPDecor;
import com.zsh.blackcard.view.datepickter.DPMode;
import com.zsh.blackcard.view.datepickter.DPTManager;
import com.zsh.blackcard.view.datepickter.DatePicker;
import com.zsh.blackcard.view.datepickter.MyTheme;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Name: AbMySignActivity
 * Author: SNXJ
 * Date: 2017-11-13
 * Description:描述：
 */
public class AbMySignActivity extends BaseActivity {
    private Context mContext;
    DatePicker myDatepicker;
    private DPCManager dpcManager;
    private TextView tv_sign;

    @Override
    protected void initUI() {
        dptMager = DPTManager.getInstance();
        dptMager.initCalendar(new MyTheme(this));
        setContentView(R.layout.sb_my_sign_activity);
        tv_sign = (TextView) findViewById(R.id.tv_sign);
        final RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.content);
        rippleBackground.startRippleAnimation();

        myDatepicker = (DatePicker) findViewById(R.id.my_datepicker);
        init();
        tv_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        });
    }


    DPTManager dptMager;
    List<String> tmp = new ArrayList<>();

    private void init() {
        dpcManager = DPCManager.getInstance();
        dpcManager.clearnDATE_CACHE(); //清除cache
        //自定义背景绘制示例
        tmp.add("2017-11-3"); //yyyy-M-d
        tmp.add("2017-11-6");
        tmp.add("2017-11-9");
        setDataBg();

    }

    // @Override
    public void signIn() {
        //动态更新的时候必须  清除cache
        dpcManager.clearnDATE_CACHE(); //清除cache
        //重新设置日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(new Date());
        tmp.add(dateNowStr);
        setDataBg();
    }

    private void setDataBg() {
        dpcManager.setDecorBG(tmp); //预先设置日期背景 一定要在在开始设置
        myDatepicker.setDate(MyCalendar.getNowYear(), MyCalendar.getNowMonth());

        myDatepicker.setMode(DPMode.MULTIPLE); //设置选择模式

        myDatepicker.setFestivalDisplay(false); //是否显示节日
        myDatepicker.setTodayDisplay(false); //是否高亮显示今天
        myDatepicker.setHolidayDisplay(false); //是否显示假期
        myDatepicker.setDeferredDisplay(false); //是否显示补休
        myDatepicker.setIsScroll(false); //是否允许滑动 false表示左右上下都不能滑动  单项设置上下or左右 你需要自己扩展
        myDatepicker.setIsSelChangeColor(true, getResources().getColor(R.color.main_black)); //设置选择的日期字体颜色,不然有的背景颜色和默认的字体颜色不搭

        myDatepicker.setMiddleTitle(MyCalendar.getNowYear() + "年" + MyCalendar.getNowMonth() + "月"); //左上方text

        //设置预先选中日期的背景颜色
        myDatepicker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
                paint.setColor(getResources().getColor(R.color.bg_white));
                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 4F, paint);
            }
        });
    }
}
