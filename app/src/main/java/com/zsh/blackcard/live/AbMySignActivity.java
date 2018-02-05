package com.zsh.blackcard.live;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyfishjy.library.RippleBackground;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.SignInDataModel;
import com.zsh.blackcard.utils.MyCalendar;
import com.zsh.blackcard.utils.UIUtils;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: AbMySignActivity
 * Author: SNXJ
 * Date: 2017-11-13
 * Description:描述：
 */
public class AbMySignActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tv_sign)
    TextView tvSign;
    @BindView(R.id.tv_sign_num)
    TextView tvSignNum;
    @BindView(R.id.content)
    RippleBackground rippleBackground;
    @BindView(R.id.my_datepicker)
    DatePicker myDatepicker;


    private DPCManager dpcManager;

    DPTManager dptMager;
    List<String> tmp = new ArrayList<>();

    @Override
    protected void initUI() {
        dptMager = DPTManager.getInstance();
        dptMager.initCalendar(new MyTheme(this));
        dpcManager = DPCManager.getInstance();
        setContentView(R.layout.sb_my_sign_activity);
        ButterKnife.bind(this);
        rippleBackground.startRippleAnimation();
        getSignData();
        initData("");

    }

    private void getSignData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getSignData(DataManager.getMd5Str("CHECKIN"), BaseApplication.getHonouruserId()), new ResultListener<SignInDataModel>() {
            @Override
            public void responseSuccess(SignInDataModel obj) {

                if ("01".equals(obj.getResult())) {
                    tvSignNum.setText("已签" + obj.getPd().getCHECK_INDAYS() + "天");
//                    if (!StringUtils.isEmpty(obj.getPd().getCHECK_DATES())) {
                    initSignData((obj.getPd().getCHECK_DATES()));
//                    }
                }

            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void sendSignIn() {
        DataManager.getInstance(this).RequestHttp(NetApi.sendSingIn(DataManager.getMd5Str("CHECKIN"), BaseApplication.getHonouruserId()), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    UIUtils.showToast("签到成功");
                    signIn();

                } else if ("08".equals(obj.getResult())) {

                    UIUtils.showToast("已签到");
                }
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void initData(String datas) {

        dpcManager.clearnDATE_CACHE(); //清除cache
        //自定义背景绘制示例
        tmp.add("2018-02-00"); //错误格式
        setDataBg();

    }

    private void initSignData(String datas) {

        dpcManager.clearnDATE_CACHE(); //清除cache

        String[] signData = datas.split(",");
        for (int i = 0; i < signData.length; i++) {
            String str = signData[i];
            if (str.startsWith("0")) {
                str = str.substring(1, 2);
            }

            tmp.add(MyCalendar.getNowYear() + "-" + MyCalendar.getNowMonth() + "-" + str);
        }

        setDataBg();

    }

    // @Override
    public void signIn() {
        //动态更新的时候必须  清除cache
        dpcManager.clearnDATE_CACHE(); //清除cache
//        重新设置日期
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
        myDatepicker.setIsScroll(false); //是否允许滑动 false表示左右上下都不能滑动  单项设置上下or左右 自己扩展
        myDatepicker.setIsSelChangeColor(true, getResources().getColor(R.color.ff92_text)); //设置选择的日期字体颜色,不然有的背景颜色和默认的字体颜色不搭

        myDatepicker.setMiddleTitle(MyCalendar.getNowYear() + "年" + MyCalendar.getNowMonth() + "月"); //上方text

//        myDatepicker.set
        //设置预先选中日期的背景颜色
        myDatepicker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
                paint.setColor(getResources().getColor(R.color.sign_bg));
                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 3F, paint);
            }
        });
    }


    @OnClick({R.id.title_back, R.id.tv_sign, R.id.content})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_sign:
                sendSignIn();
//                signIn();
                break;
            case R.id.content:
                break;
        }
    }
}
