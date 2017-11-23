package com.zsh.blackcard.ui;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.ActivityUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 吃喝玩乐,发布活动页面
 */
public class EatDrinkSetActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.blackwb_back)
    ImageView blackwb_back;
    //开始时间
    @BindView(R.id.hj_eat_set_startTime_tv)
    TextView hj_eat_set_startTime_tv;
    //结束时间
    @BindView(R.id.hj_eat_set_endTime_tv)
    TextView hj_eat_set_endTime_tv;
    //期望价格
    @BindView(R.id.hj_eat_set_price_tv)
    TextView hj_eat_set_price_tv;
    //方式
    @BindView(R.id.hj_eat_set_type_tv)
    TextView hj_eat_set_type_tv;
    //人数
    @BindView(R.id.hj_eat_set_people_tv)
    TextView hj_eat_set_people_tv;
    //性别
    @BindView(R.id.hj_eat_set_sex_tv)
    TextView hj_eat_set_sex_tv;
    //年龄
    @BindView(R.id.hj_eat_set_year_tv)
    TextView hj_eat_set_year_tv;
    //详情

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_set);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.hj_eat_set_startTime_relative, R.id.hj_eat_set_endTime_relative, R.id.hj_eat_set_price_relative, R.id.hj_eat_set_type_relative, R.id.hj_eat_set_people_relative, R.id.hj_eat_set_sex_relative, R.id.hj_eat_set_year_relative, R.id.hj_eat_set_detail_relative, R.id.hj_eat_set_release_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            //开始时间
            case R.id.hj_eat_set_startTime_relative:
                showStart(hj_eat_set_startTime_tv);
                break;
            //结束时间
            case R.id.hj_eat_set_endTime_relative:
                showEnd(hj_eat_set_endTime_tv);
                break;
            //期望价格
            case R.id.hj_eat_set_price_relative:
                showPrice(hj_eat_set_price_tv);
                break;
            //方式
            case R.id.hj_eat_set_type_relative:
                showType(hj_eat_set_type_tv);
                break;
            //人数
            case R.id.hj_eat_set_people_relative:
                showPeople(hj_eat_set_people_tv);
                break;
            //性别
            case R.id.hj_eat_set_sex_relative:
                showSex(hj_eat_set_sex_tv);
                break;
            //年龄
            case R.id.hj_eat_set_year_relative:
                showYear(hj_eat_set_year_tv);
                break;
            //详情
            case R.id.hj_eat_set_detail_relative:
                ActivityUtils.startActivity(this, EatDrinkSetDetailActivity.class);
                break;
        }
    }

    /**
     * 年龄选择器
     *
     * @param hj_eat_set_year_tv
     */
    private void showYear(final TextView hj_eat_set_year_tv) {
        final List<String> listYear = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listYear.add(String.valueOf(i));
        }

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                hj_eat_set_year_tv.setText(listYear.get(options1));
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(listYear, null, null);
        pvOptions.show();
    }

    /**
     * 性别选择器
     *
     * @param hj_eat_set_sex_tv
     */
    private void showSex(final TextView hj_eat_set_sex_tv) {
        final List<String> listSex = new ArrayList<>();
        listSex.add("男");
        listSex.add("女");

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                hj_eat_set_sex_tv.setText(listSex.get(options1));
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(listSex, null, null);
        pvOptions.show();
    }

    /**
     * 人数选择器
     *
     * @param hj_eat_set_people_tv
     */
    private void showPeople(final TextView hj_eat_set_people_tv) {
        final List<String> listPeople = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listPeople.add(String.valueOf(i));
        }

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                hj_eat_set_people_tv.setText(listPeople.get(options1));
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(listPeople, null, null);
        pvOptions.show();
    }

    /**
     * 方式选择器
     *
     * @param tv
     */
    private void showType(final TextView tv) {
        final List<String> listType = new ArrayList<>();
        listType.add("AA");
        listType.add("我请客");

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                tv.setText(listType.get(options1));
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(listType, null, null);
        pvOptions.show();
    }

    /**
     * 价格选择器
     *
     * @param tv
     */
    private void showPrice(final TextView tv) {

        final List<String> minList = new ArrayList<>();
        final List<String> maxList = new ArrayList<>();
        for (int i = 0; i < 1000; i += 10) {
            minList.add(String.valueOf(i));
            maxList.add(String.valueOf(i));
        }

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                String s = minList.get(options1);
                String s1 = maxList.get(option2);
                tv.setText(s + "—" + s1);
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(minList, maxList, null);
        pvOptions.show();
    }

    /**
     * 结束时间选择器
     *
     * @param hj_eat_set_endTime_tv
     */
    private void showEnd(final TextView hj_eat_set_endTime_tv) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DAY_OF_MONTH) + 7);
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                hj_eat_set_endTime_tv.setText(getTime(date));
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})
                .setContentSize(16)
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setRangDate(startDate, endDate)
                .setDividerColor(Color.WHITE)
                .setLabel("", "", "", "", "", "")
                .build();
        pvTime.show();
    }

    /**
     * 开始时间选择器
     *
     * @param hj_eat_set_startTime_tv
     */
    private void showStart(final TextView hj_eat_set_startTime_tv) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DAY_OF_MONTH) + 7);
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                if (TextUtils.isEmpty(hj_eat_set_endTime_tv.getText())) {
                    hj_eat_set_startTime_tv.setText(getTime(date));
                }else{

                }
            }
        })
                .setType(new boolean[]{true, true, true, false, false, false})
                .setContentSize(16)
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setRangDate(startDate, endDate)
                .setDividerColor(Color.WHITE)
                .setLabel("", "", "", "", "", "")
                .build();
        pvTime.show();
    }

    /**
     * 时间格式转换
     *
     * @param date
     * @return
     */
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
