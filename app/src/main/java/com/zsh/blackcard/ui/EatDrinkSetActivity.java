package com.zsh.blackcard.ui;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.luck.picture.lib.entity.LocalMedia;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HjReleaseModel;
import com.zsh.blackcard.utils.UIUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;

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
    @BindView(R.id.hj_eat_set_detail_tv)
    TextView hj_eat_set_detail_tv;
    //活动所属类型
    @BindView(R.id.hj_eat_set_sort_tv)
    TextView hj_eat_set_sort_tv;
    //发布活动标题
    @BindView(R.id.activity_eat_drink_set_title_tv)
    TextView activity_eat_drink_set_title_tv;

    private Map<String, String> map = new HashMap<>();
    private List<MultipartBody.Part> pary;
    private boolean isOk = false;
    private List<LocalMedia> localMedia = new ArrayList<>();
    private List<String> search = new ArrayList<>();
    private List<String> searchId = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_eat_drink_set);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        String title = getIntent().getStringExtra("title");
        activity_eat_drink_set_title_tv.setText(title);
        search = (List<String>) getIntent().getSerializableExtra("listOne");
        searchId = (List<String>) getIntent().getSerializableExtra("listTwo");
        map.put("FKEY", DataManager.getMd5Str("DETAILADD"));
        map.put("CONVERGE_ID", data);
        map.put("HONOURUSER_ID", "d6a3779de8204dfd9359403f54f7d27c");
        map.put("CONVERGETITLE", "");
        map.put("CONVERGEDET", "");
        map.put("CONVERGETYPE", "");
        map.put("AGEMAX", "");
        map.put("AGEMIN", "");
        map.put("CONVERGESEX", "");
        map.put("CONVERGEPER", "");
        map.put("PRICEMAX", "");
        map.put("PRICEMIN", "");
        map.put("ENDTIME", "");
        map.put("STARTTIME", "");
        map.put("CONVERGESORT_ID", "");
    }

    @OnClick({R.id.blackwb_back, R.id.hj_eat_set_startTime_relative, R.id.hj_eat_set_endTime_relative, R.id.hj_eat_set_price_relative, R.id.hj_eat_set_type_relative, R.id.hj_eat_set_people_relative, R.id.hj_eat_set_sex_relative, R.id.hj_eat_set_year_relative, R.id.hj_eat_set_detail_relative, R.id.hj_eat_set_release_btn, R.id.hj_eat_set_sort_relative})
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
                Intent intent = new Intent(this, EatDrinkSetDetailActivity.class);
                intent.putExtra("list", (Serializable) localMedia);
                startActivityForResult(intent, 0);
                break;
            //活动所属类型
            case R.id.hj_eat_set_sort_relative:
                showSort(hj_eat_set_sort_tv);
                break;
            //发布
            case R.id.hj_eat_set_release_btn:
                releaseBtn();
                break;
        }
    }

    /**
     * Activity回调
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0 && resultCode == 0) {
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");
            localMedia = (List<LocalMedia>) data.getSerializableExtra("list");
            if (title.trim().equals("") && content.trim().equals("")) {
                hj_eat_set_detail_tv.setText("标题或内容未编辑");
            }else{
                hj_eat_set_detail_tv.setText("已编辑");
            }
            map.put("CONVERGEDET", content);
            map.put("CONVERGETITLE", title);
        }
    }

    /**
     * 提交校验发布信息不能有空值
     */
    private void releaseBtn() {
        //校验是否包含未选项
        for (Object object : map.keySet()) {
            if (map.get(object).equals("")) {
                isOk = false;
                break;
            }
            isOk = true;
        }

        //校验结果
        if (isOk) {
            if (pary == null) {
                pary = new ArrayList<>();
            } else {
                pary.clear();
            }

            DataManager.getInstance(this).RequestHttp(NetApi.postHjRelease(map, pary, localMedia), new ResultListener<HjReleaseModel>() {
                @Override
                public void responseSuccess(HjReleaseModel obj) {
                    UIUtils.showToast("发布成功");
                    finish();
                }

                @Override
                public void onCompleted() {

                }
            });
        } else {
            UIUtils.showToast("请编辑全部聚会内容");
        }
    }

    /**
     * 活动类型选择器
     *
     * @param hj_eat_set_sort_tv
     */
    private void showSort(final TextView hj_eat_set_sort_tv) {

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                hj_eat_set_sort_tv.setText(search.get(options1));
                map.put("CONVERGESORT_ID", searchId.get(options1));
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(search, null, null);
        pvOptions.show();
    }


    /**
     * 年龄选择器
     *
     * @param hj_eat_set_year_tv
     */
    private void showYear(final TextView hj_eat_set_year_tv) {
        final List<String> listMin = new ArrayList<>();
        final List<String> listMax = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listMin.add(String.valueOf(i));
            listMax.add(String.valueOf(i));
        }

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                hj_eat_set_year_tv.setText(listMin.get(options1) + "—" + listMax.get(option2));
                map.put("AGEMIN", listMin.get(options1));
                map.put("AGEMAX", listMax.get(option2));
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .build();
        pvOptions.setNPicker(listMin, listMax, null);
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
        listSex.add("不限");

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                hj_eat_set_sex_tv.setText(listSex.get(options1));
                if (listSex.get(options1).equals("女")) {
                    map.put("CONVERGESEX", "0");
                } else if (listSex.get(options1).equals("男")) {
                    map.put("CONVERGESEX", "1");
                } else {
                    map.put("CONVERGESEX", "2");
                }
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
                map.put("CONVERGEPER", hj_eat_set_people_tv.getText().toString());
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
     * @param hj_eat_set_type_tv
     */
    private void showType(final TextView hj_eat_set_type_tv) {
        final List<String> listType = new ArrayList<>();
        listType.add("AA");
        listType.add("我请客");

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {

                hj_eat_set_type_tv.setText(listType.get(options1));
                map.put("CONVERGETYPE", hj_eat_set_type_tv.getText().toString());
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
     * @param hj_eat_set_price_tv
     */
    private void showPrice(final TextView hj_eat_set_price_tv) {

        final List<String> minList = new ArrayList<>();
        final List<String> maxList = new ArrayList<>();
        for (int i = 0; i < 1000; i += 10) {
            minList.add(String.valueOf(i));
            maxList.add(String.valueOf(i));
        }

        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                String min = minList.get(options1);
                String max = maxList.get(option2);
                hj_eat_set_price_tv.setText(min + "—" + max);
                map.put("PRICEMIN", min);
                map.put("PRICEMAX", max);
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
                map.put("ENDTIME", hj_eat_set_endTime_tv.getText().toString());
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
                hj_eat_set_startTime_tv.setText(getTime(date));
                map.put("STARTTIME", hj_eat_set_startTime_tv.getText().toString());
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
