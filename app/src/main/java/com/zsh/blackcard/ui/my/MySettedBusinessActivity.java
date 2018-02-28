package com.zsh.blackcard.ui.my;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.WelBussAdapter;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.model.JsonBean;
import com.zsh.blackcard.ui.home.HomeFoodHotelActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.GetJsonUtils;
import com.zsh.blackcard.utils.UIUtils;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 所有商家入驻的页面。
 */
public class MySettedBusinessActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    @BindView(R.id.name_et)
    EditText nameEt;
    @BindView(R.id.address_et)
    TextView addressEt;
    @BindView(R.id.detail_et)
    EditText detailEt;
    @BindView(R.id.phone_et)
    EditText phoneEt;
    @BindView(R.id.activity_eat_drink_set_title_tv)
    TextView activity_eat_drink_set_title_tv;
    @BindView(R.id.name_tv)
    TextView name_tv;
    @BindView(R.id.address_tv)
    TextView address_tv;
    @BindView(R.id.phone_tv)
    TextView phone_tv;
    @BindView(R.id.type_et)
    TextView typeEt;
    @BindView(R.id.relative_type)
    RelativeLayout relativeType;

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private List<View> viewList = new ArrayList<>();
    private WelBussAdapter welBussAdapter;
    private String type_id = null;
    private String province = null;
    private String city = null;
    private String county = null;
    private String data;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted_business);
        ButterKnife.bind(this);

        ActivityUtils.addActivity(this);

        data = getIntent().getStringExtra("data");
        type_id = getIntent().getStringExtra("title");
        if (data.equals("1")) {
            initText("门店");
            //检测是否需要弹出引导页(目前为每次都弹出)
            initWelCome("门店");
        } else {
            if (data.equals("3")) {
                relativeType.setVisibility(View.VISIBLE);
            } else {
                relativeType.setVisibility(View.GONE);
            }
            initText("企业");
            //检测是否需要弹出引导页(目前为每次都弹出)
            initWelCome("企业");
        }
        //初始化页面数据
        initData();
    }

    private void initText(String text) {
        activity_eat_drink_set_title_tv.setText(text + "入驻");
        name_tv.setText(text + "名称");
        address_tv.setText(text + "地址");
        phone_tv.setText(text + "电话");
    }

    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;
    private Button btn_next;
    private ImageView img_clear;
    private ViewPager viewPager;
    //初始化ViewPager下标为0
    private int index = 0;
    private Dialog dialog;

    //检测是否需要弹出引导页
    private void initWelCome(String text) {
        View view = LayoutInflater.from(this).inflate(R.layout.welcome_buss_viewpager, null);
        //实例化三个圆点
        tv_one = view.findViewById(R.id.tv_one);
        tv_two = view.findViewById(R.id.tv_two);
        tv_three = view.findViewById(R.id.tv_three);
        btn_next = view.findViewById(R.id.btn_next);
        img_clear = view.findViewById(R.id.img_clear);
        viewPager = view.findViewById(R.id.wel_buss_pager);
        View viewOne = LayoutInflater.from(this).inflate(R.layout.wel_buss_one, null);
        View viewTwo = LayoutInflater.from(this).inflate(R.layout.wel_buss_two, null);
        View viewThree = LayoutInflater.from(this).inflate(R.layout.wel_buss_three, null);
        TextView tv_titles = viewOne.findViewById(R.id.tv_titles);
        TextView tv_ones = viewOne.findViewById(R.id.tv_ones);
        TextView tv_twos = viewOne.findViewById(R.id.tv_twos);
        TextView tv_threes = viewOne.findViewById(R.id.tv_threes);
        tv_titles.setText(text + "入驻");
        tv_ones.setText("1、填写" + text + "名称");
        tv_twos.setText("2、填写" + text + "详细地址");
        tv_threes.setText("3、填写" + text + "电话");
        viewList.add(viewOne);
        viewList.add(viewTwo);
        viewList.add(viewThree);
        welBussAdapter = new WelBussAdapter(viewList);
        viewPager.setAdapter(welBussAdapter);
        viewPager.addOnPageChangeListener(this);
        btn_next.setOnClickListener(this);
        img_clear.setOnClickListener(this);
        dialog = PublicDialog.showDialogViews(view, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                if (index == 0) {
                    viewPager.setCurrentItem(1);
                } else if (index == 1) {
                    viewPager.setCurrentItem(2);
                } else {
                    dialog.dismiss();
                }
                break;
            case R.id.img_clear:
                dialog.dismiss();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //滑动监听
    @Override
    public void onPageSelected(int position) {
        //清空其他未选中tv
        clearTvBg();
        switch (position) {
            case 0:
                tv_one.setBackgroundResource(R.drawable.wel_buss_true);
                btn_next.setText("下一步");
                break;
            case 1:
                tv_two.setBackgroundResource(R.drawable.wel_buss_true);
                btn_next.setText("下一步");
                break;
            case 2:
                tv_three.setBackgroundResource(R.drawable.wel_buss_true);
                btn_next.setText("我知道了");
                break;
        }
        index = position;
    }

    //清空所有tv为未选中状态
    private void clearTvBg() {
        tv_one.setBackgroundResource(R.drawable.wel_buss_false);
        tv_two.setBackgroundResource(R.drawable.wel_buss_false);
        tv_three.setBackgroundResource(R.drawable.wel_buss_false);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private void initData() {
        //开启子线程解析json省市区文件
        new Thread() {
            @Override
            public void run() {
                initJsonData();
            }
        }.start();
    }

    //开始解析json文件
    private void initJsonData() {
        String jsonStr = new GetJsonUtils().getJson(this, "province.json");
        ArrayList<JsonBean> jsonBean = parseData(jsonStr);//用Gson 转成实体
        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
    }

    private ArrayList<JsonBean> parseData(String jsonStr) {
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(jsonStr);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @OnClick({R.id.blackwb_back, R.id.relative_two, R.id.submit_btn, R.id.relative_type})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.relative_two:
                hideInputSoft();
                showAddress();
                break;
            case R.id.submit_btn:
                submit();
                break;
            case R.id.relative_type:
                selectType();
                break;
        }
    }

    private void selectType() {
        final List<String> list = new ArrayList<>();
        list.add("KTV");
        list.add("酒吧");
        list.add("夜店");
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                typeEt.setText(list.get(options1));
                type_id = list.get(options1);

            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .setContentTextSize(16)
                .setLineSpacingMultiplier(2f)
                .build();
        pvOptions.setNPicker(list, null, null);
        pvOptions.show();
    }

    //地址选择器
    private void showAddress() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                addressEt.setText(options1Items.get(options1).getPickerViewText() + options2Items.get(options1).get(option2) + options3Items.get(options1).get(option2).get(options3));
                province = options1Items.get(options1).getPickerViewText();
                city = options2Items.get(options1).get(option2);
                county = options3Items.get(options1).get(option2).get(options3);
            }
        })
                .setSubmitColor(Color.GRAY)
                .setCancelColor(Color.GRAY)
                .setTitleBgColor(Color.WHITE)
                .setDividerColor(Color.WHITE)
                .setContentTextSize(14)
                .build();
        pvOptions.setPicker(options1Items, options2Items, options3Items);
        pvOptions.show();
    }

    //提交
    private void submit() {
        if (!TextUtils.isEmpty(nameEt.getText().toString().trim()) && !TextUtils.isEmpty(addressEt.getText().toString().trim()) && !TextUtils.isEmpty(detailEt.getText().toString().trim()) && !TextUtils.isEmpty(phoneEt.getText().toString().trim())) {
            ActivityUtils.startActivityShopInto(this, MySettedBusinessSubmitActivity.class, nameEt.getText().toString().trim(), province, city, county, detailEt.getText().toString().trim(), phoneEt.getText().toString().trim(), type_id);
        } else {
            UIUtils.showToast("请完善全部信息");
        }
    }


}
