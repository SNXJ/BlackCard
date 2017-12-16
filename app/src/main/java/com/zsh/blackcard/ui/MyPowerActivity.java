package com.zsh.blackcard.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MyPowerRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.MyValueFormatter;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MyPowerImageModel;
import com.zsh.blackcard.model.MyPowerModel;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.view.WalletTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/13.
 */

public class MyPowerActivity extends BaseActivity {

    @BindView(R.id.my_power_one_tv)
    WalletTextView my_power_one_tv;
    @BindView(R.id.my_power_one_one_tv)
    TextView my_power_one_one_tv;

    @BindView(R.id.my_power_two_tv)
    WalletTextView my_power_two_tv;
    @BindView(R.id.my_power_two_one_tv)
    TextView my_power_two_one_tv;
    @BindView(R.id.my_power_two_two_tv)
    TextView my_power_two_two_tv;

    @BindView(R.id.my_power_three_tv)
    WalletTextView my_power_three_tv;
    @BindView(R.id.my_power_three_one_tv)
    TextView my_power_three_one_tv;
    @BindView(R.id.my_power_three_two_tv)
    TextView my_power_three_two_tv;
    @BindView(R.id.my_power_three_three_tv)
    TextView my_power_three_three_tv;
    @BindView(R.id.my_power_three_four_tv)
    TextView my_power_three_four_tv;
    @BindView(R.id.my_power_three_five_tv)
    TextView my_power_three_five_tv;

    @BindView(R.id.my_power_four_tv)
    WalletTextView my_power_four_tv;
    @BindView(R.id.my_power_four_one_tv)
    TextView my_power_four_one_tv;
    @BindView(R.id.my_power_four_two_tv)
    TextView my_power_four_two_tv;
    @BindView(R.id.my_power_four_three_tv)
    TextView my_power_four_three_tv;
    @BindView(R.id.my_power_four_four_tv)
    TextView my_power_four_four_tv;
    @BindView(R.id.my_power_four_five_tv)
    TextView my_power_four_five_tv;

    @BindView(R.id.my_power_five_tv)
    WalletTextView my_power_five_tv;
    @BindView(R.id.my_power_five_one_tv)
    TextView my_power_five_one_tv;
    @BindView(R.id.my_power_five_two_tv)
    TextView my_power_five_two_tv;
    @BindView(R.id.my_power_five_three_tv)
    TextView my_power_five_three_tv;

    @BindView(R.id.my_power_recycler)
    RecyclerView my_power_recycler;

    @BindView(R.id.my_power_lineChart)
    LineChart my_power_lineChart;

    private MyPowerRecyclerAdapter myPowerRecyclerAdapter;
    private List<Entry> entryList = new ArrayList<>();
    private String[] ayyayXStr = new String[12];

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_power);
        ButterKnife.bind(this);
        //请求所有分值接口
        initDate();
        //请求能量曲线图接口
        initLineChart();
    }

    private void initLineChart() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postPowerImage(DataManager.getMd5Str("ENERGYVALUEMONTH"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<MyPowerImageModel>() {
            @Override
            public void responseSuccess(MyPowerImageModel obj) {
                if (obj.getResult().equals("01")) {

                    for (int i = 0; i < obj.getPd().size(); i++) {
                        entryList.add(i, new Entry(i, obj.getPd().get(i).getENERGYVALUE()));
                        ayyayXStr[i] = obj.getPd().get(i).getMonths();
                    }

                    LineDataSet dataSet = new LineDataSet(entryList, "分值");
                    //设置线条下部为填充
                    dataSet.setDrawFilled(true);
                    //设置线条下部面积为渐变色
                    dataSet.setFillDrawable(getResources().getDrawable(R.drawable.power_gradient_bg));
                    //不绘制折现点
                    dataSet.setDrawCircles(false);
                    //不在点上绘制文字
                    dataSet.setDrawValues(false);
                    //设置折线为圆滑
                    dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                    //设置折线的颜色
                    dataSet.setColor(Color.parseColor("#54A7B6"));
                    //设置折线的点的颜色
//                    dataSet.setCircleColor(Color.parseColor("#FFFFFF"));
                    //设置折线点值的颜色
//                    dataSet.setValueTextColor(Color.parseColor("#FFFFFFFF"));
                    LineData lineData = new LineData(dataSet);

                    MyValueFormatter myValueFormatter = new MyValueFormatter(ayyayXStr);

                    XAxis xAxis = my_power_lineChart.getXAxis();
                    xAxis.setLabelCount(12, true);
                    xAxis.setValueFormatter((IAxisValueFormatter) myValueFormatter);
                    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // 设置X轴的位置在下方
                    //设置虚线的长度和线与线之间的距离
                    xAxis.setGridLineWidth(1f);
                    xAxis.enableGridDashedLine(15f, 10f, 0);
                    //X轴所对应的竖线不绘制
//                    xAxis.setDrawGridLines(false);
                    //X轴最后一行不绘制横线
                    xAxis.setDrawAxisLine(false);
                    //设置X轴数值颜色
                    xAxis.setTextColor(Color.parseColor("#FFFFFF"));

                    YAxis yAxis = my_power_lineChart.getAxisLeft();
                    //设置Y轴左侧数值颜色
                    yAxis.setTextColor(Color.parseColor("#FFFFFF"));
                    yAxis.setDrawAxisLine(false);
                    yAxis.enableGridDashedLine(15f, 10f, 15);

                    YAxis yAxisRight = my_power_lineChart.getAxisRight();
                    //不绘制Y轴右侧的数值
                    yAxisRight.setDrawLabels(false);
                    yAxisRight.setDrawAxisLine(false);
                    yAxisRight.enableGridDashedLine(15f, 10f, 0);

                    my_power_lineChart.setData(lineData);
                    //不绘制图表右下角描述文字
                    my_power_lineChart.setDescription(null);
                    //禁止所有手势
                    my_power_lineChart.setTouchEnabled(false);
                    my_power_lineChart.invalidate();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDate() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postMyPower(DataManager.getMd5Str("ENERGYLIST"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<MyPowerModel>() {
            @Override
            public void responseSuccess(MyPowerModel obj) {
                if (obj.getResult().equals("01")) {

                    myPowerRecyclerAdapter = new MyPowerRecyclerAdapter(R.layout.my_power_recycler_item, obj.getPd());
                    my_power_recycler.setLayoutManager(new LinearLayoutManager(MyPowerActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    my_power_recycler.setAdapter(myPowerRecyclerAdapter);

                    my_power_one_tv.setText(obj.getPd().get(0).getSCORE() + "\n" + obj.getPd().get(0).getNAME());
                    my_power_one_one_tv.setText(obj.getPd().get(0).getCompList().get(0).getNAME() + " " + obj.getPd().get(0).getCompList().get(0).getSCORE());

                    my_power_two_tv.setText(obj.getPd().get(1).getSCORE() + "\n" + obj.getPd().get(1).getNAME());
                    my_power_two_one_tv.setText(obj.getPd().get(1).getCompList().get(0).getNAME() + " " + obj.getPd().get(1).getCompList().get(0).getSCORE());
                    my_power_two_two_tv.setText(obj.getPd().get(1).getCompList().get(1).getNAME() + " " + obj.getPd().get(1).getCompList().get(1).getSCORE());

                    my_power_three_tv.setText(obj.getPd().get(2).getSCORE() + "\n" + obj.getPd().get(2).getNAME());
                    my_power_three_one_tv.setText(obj.getPd().get(2).getCompList().get(0).getNAME() + " " + obj.getPd().get(2).getCompList().get(0).getSCORE());
                    my_power_three_two_tv.setText(obj.getPd().get(2).getCompList().get(1).getNAME() + " " + obj.getPd().get(2).getCompList().get(1).getSCORE());
                    my_power_three_three_tv.setText(obj.getPd().get(2).getCompList().get(2).getNAME() + " " + obj.getPd().get(2).getCompList().get(2).getSCORE());
                    my_power_three_four_tv.setText(obj.getPd().get(2).getCompList().get(3).getNAME() + " " + obj.getPd().get(2).getCompList().get(3).getSCORE());
                    my_power_three_five_tv.setText(obj.getPd().get(2).getCompList().get(4).getNAME() + " " + obj.getPd().get(2).getCompList().get(4).getSCORE());

                    my_power_four_tv.setText(obj.getPd().get(3).getSCORE() + "\n" + obj.getPd().get(3).getNAME());
                    my_power_four_one_tv.setText(obj.getPd().get(3).getCompList().get(0).getNAME() + " " + obj.getPd().get(3).getCompList().get(0).getSCORE());
                    my_power_four_two_tv.setText(obj.getPd().get(3).getCompList().get(1).getNAME() + " " + obj.getPd().get(3).getCompList().get(1).getSCORE());
                    my_power_four_three_tv.setText(obj.getPd().get(3).getCompList().get(2).getNAME() + " " + obj.getPd().get(3).getCompList().get(2).getSCORE());
                    my_power_four_four_tv.setText(obj.getPd().get(3).getCompList().get(3).getNAME() + " " + obj.getPd().get(3).getCompList().get(3).getSCORE());
                    my_power_four_five_tv.setText(obj.getPd().get(3).getCompList().get(4).getNAME() + " " + obj.getPd().get(3).getCompList().get(4).getSCORE());

                    my_power_five_tv.setText(obj.getPd().get(4).getSCORE() + "\n" + obj.getPd().get(4).getNAME());
                    my_power_five_one_tv.setText(obj.getPd().get(4).getCompList().get(0).getNAME() + " " + obj.getPd().get(4).getCompList().get(0).getSCORE());
                    my_power_five_two_tv.setText(obj.getPd().get(4).getCompList().get(1).getNAME() + " " + obj.getPd().get(4).getCompList().get(1).getSCORE());
                    my_power_five_three_tv.setText(obj.getPd().get(4).getCompList().get(2).getNAME() + " " + obj.getPd().get(4).getCompList().get(2).getSCORE());
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick({R.id.blackwb_back, R.id.my_power_exchange_tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.my_power_exchange_tv:
                ActivityUtils.startActivity(this, ExChangeActivity.class);
                break;
        }
    }
}
