package com.zsh.blackcard.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.AddressManageModel;
import com.zsh.blackcard.model.JsonBean;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.GetJsonUtils;
import com.zsh.blackcard.utils.UIUtils;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 编辑添加地址
 */
public class AddressEditActivity extends BaseActivity {


    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_tel)
    EditText etTel;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.et_addres_detail)
    EditText etAddresDetail;
    private AddressManageModel.PdBean initData;

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.address_edit_activity);
        ButterKnife.bind(this);
        initData = (AddressManageModel.PdBean) getIntent().getSerializableExtra("Serializable");
        if (null != initData) {
            initAdderss(initData);
        }
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

    @OnClick({R.id.im_back, R.id.tv_save, R.id.ll_address})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_save:
                getDataPutMap();
                break;
            case R.id.ll_address:
                //   takeOnClick();
                //显示城市选择器
                showAddress();
                break;
        }
    }

    /**
     * 加载日期选择器
     */
    private void showAddress() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                tvAddress.setText(options1Items.get(options1).getPickerViewText() + options2Items.get(options1).get(option2) + options3Items.get(options1).get(option2).get(options3));
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

    private void initAdderss(AddressManageModel.PdBean initData) {
        etName.setText(initData.getCONSIGNEE());
        etTel.setText(initData.getADRPHONE());
        tvAddress.setText(initData.getPROVINCE());
        etAddresDetail.setText(initData.getADDRESS());
    }

    Map<String, String> map = new TreeMap<>();

    private void getDataPutMap() {
        String name = etName.getText().toString();
        String tel = etTel.getText().toString();
        String address = tvAddress.getText().toString();
        String adr_detail = etAddresDetail.getText().toString();

        map.put("FKEY", DataManager.getMd5Str("SHIPADR"));
        map.put("HONOURUSER_ID", "d6a3779de8204dfd9359403f54f7d27c");
        map.put("CONSIGNEE", name);
        map.put("ADRPHONE", tel);
        map.put("PROVINCE", address);
        map.put("ADDRESS", adr_detail);
        if (null != initData) {
            map.put("ADDRESS_ID", initData.getADDRESS_ID());
            editData();
        } else {
            saveData();
        }

    }

    private void saveData() {
        DataManager.getInstance(this).RequestHttp(NetApi.addressAdd(map), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    UIUtils.showToast("保存成功");
                    finish();
                } else {
                    UIUtils.showToast("保存失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void editData() {
        DataManager.getInstance(this).RequestHttp(NetApi.addressEdit(map), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    UIUtils.showToast("保存成功");
                    finish();
                } else {
                    UIUtils.showToast("保存失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}