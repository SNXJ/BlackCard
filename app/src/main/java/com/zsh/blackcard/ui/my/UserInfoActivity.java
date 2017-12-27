package com.zsh.blackcard.ui.my;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.JsonBean;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.SettingUserInfoModel;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.GetJsonUtils;
import com.zsh.blackcard.utils.UIUtils;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.my_setting_info_img)
    ImageView my_setting_info_img;
    @BindView(R.id.my_setting_info_nick_tv)
    TextView my_setting_info_nick_tv;
    @BindView(R.id.my_setting_info_name_tv)
    TextView my_setting_info_name_tv;
    @BindView(R.id.my_setting_info_sex_tv)
    TextView my_setting_info_sex_tv;
    @BindView(R.id.my_setting_info_birthday_tv)
    TextView my_setting_info_birthday_tv;
    @BindView(R.id.my_setting_info_cardNumber_tv)
    TextView my_setting_info_cardNumber_tv;
    @BindView(R.id.my_setting_info_address_tv)
    TextView my_setting_info_address_tv;
    @BindView(R.id.my_setting_info_autograph_tv)
    TextView my_setting_info_autograph_tv;
    @BindView(R.id.my_setting_info_id_tv)
    TextView my_setting_info_id_tv;
    @BindView(R.id.my_setting_info_phone_tv)
    TextView my_setting_info_phone_tv;
    @BindView(R.id.my_setting_info_qq_tv)
    TextView my_setting_info_qq_tv;
    @BindView(R.id.my_setting_info_weChat_tv)
    TextView my_setting_info_weChat_tv;
    @BindView(R.id.my_setting_info_sina_tv)
    TextView my_setting_info_sina_tv;
    @BindView(R.id.my_setting_info_pay_tv)
    TextView my_setting_info_pay_tv;

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Map<String, String> map = new HashMap<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        //开启子线程加载Json数据
        new Thread() {
            @Override
            public void run() {
                initJsonData();
            }
        }.start();
        //获取个人信息
        initData();
    }

    //获取个人信息
    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postSettingUserInfo(DataManager.getMd5Str("GETUSERINFO"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<SettingUserInfoModel>() {
            @Override
            public void responseSuccess(SettingUserInfoModel obj) {
                if (obj.getResult().equals("01")) {
                    Glide.with(UserInfoActivity.this).load(obj.getUser().getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(UserInfoActivity.this))).into(my_setting_info_img);
                    my_setting_info_nick_tv.setText(obj.getUser().getNICKNAME());
                    my_setting_info_name_tv.setText(obj.getUser().getREALNAME());
                    my_setting_info_sex_tv.setText(obj.getUser().getSEX());
                    my_setting_info_phone_tv.setText(obj.getUser().getPHONE());
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick({R.id.blackwb_back, R.id.my_setting_info_nick_relative,
            R.id.my_setting_info_address_relative, R.id.my_setting_info_autograph_relative,
            R.id.my_setting_info_phone_relative, R.id.my_setting_info_qq_relative, R.id.my_setting_info_weChat_relative,
            R.id.my_setting_info_sina_relative, R.id.my_setting_info_pay_relative})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            //修改昵称
            case R.id.my_setting_info_nick_relative:
                ActivityUtils.startActivityForResult(this, ChangeForResultActivity.class, "昵称", 1);
                break;
            //修改地址
            case R.id.my_setting_info_address_relative:
                showAddress(my_setting_info_address_tv);
                break;
            //修改个性签名
            case R.id.my_setting_info_autograph_relative:
                ActivityUtils.startActivityForResult(this, ChangeForResultActivity.class, "个性签名", 1);
                break;
            //修改电话
            case R.id.my_setting_info_phone_relative:
                ActivityUtils.startActivityForData(this, ChangePhoneActivity.class, my_setting_info_phone_tv.getText().toString());
                break;
            //修改QQ
            case R.id.my_setting_info_qq_relative:
                ActivityUtils.startActivityForResult(this, ChangeForResultActivity.class, "QQ号码", 1);
                break;
            //修改微信
            case R.id.my_setting_info_weChat_relative:
                ActivityUtils.startActivityForResult(this, ChangeForResultActivity.class, "微信", 1);
                break;
            //修改新浪微博
            case R.id.my_setting_info_sina_relative:
                ActivityUtils.startActivityForResult(this, ChangeForResultActivity.class, "新浪微博", 1);
                break;
            //修改支付宝
            case R.id.my_setting_info_pay_relative:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            map.clear();
            switch (resultCode) {
                case 0:

                    break;
                case 1:
                    my_setting_info_nick_tv.setText(data.getStringExtra("data"));
                    map.put("NICKNAME", data.getStringExtra("data"));
                    initChangeInfo(map);
                    break;
                case 2:
                    my_setting_info_autograph_tv.setText(data.getStringExtra("data"));
                    map.put("SIGNNAME", data.getStringExtra("data"));
                    initChangeInfo(map);
                    break;
                case 3:
                    my_setting_info_qq_tv.setText(data.getStringExtra("data"));
                    map.put("SIGNNAME", data.getStringExtra("data"));
                    initChangeInfo(map);
                    break;
                case 4:
                    my_setting_info_weChat_tv.setText(data.getStringExtra("data"));
                    initChangeInfo(map);
                    break;
                case 5:
                    my_setting_info_sina_tv.setText(data.getStringExtra("data"));
                    initChangeInfo(map);
                    break;
            }

        }
    }

    private void initChangeInfo(Map<String, String> map) {
        DataManager.getInstance(this).RequestHttp(NetApi.postUserInfoChange(DataManager.getMd5Str("UPDPERSONALINFO"), "d6a3779de8204dfd9359403f54f7d27c", map), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    UIUtils.showToast("修改成功");
                } else {
                    UIUtils.showToast("修改失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void showAddress(final TextView my_setting_info_address_tv) {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                my_setting_info_address_tv.setText(options1Items.get(options1).getPickerViewText() + options2Items.get(options1).get(option2) + options3Items.get(options1).get(option2).get(options3));
                map.clear();
                map.put("ADDRESS", my_setting_info_address_tv.getText().toString());
                initChangeInfo(map);
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

    /**
     * 时间格式转换
     *
     * @param date
     * @return
     */
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
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
}
