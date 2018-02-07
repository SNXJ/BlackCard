package com.zsh.blackcard.ui.my;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.UIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;

public class MySettedBusinessSubmitActivity extends BaseActivity {

    @BindView(R.id.name_tv)
    TextView name_tv;
    @BindView(R.id.address_tv)
    TextView address_tv;
    //经营者姓名
    @BindView(R.id.name_et)
    EditText name_et;
    //身份证号
    @BindView(R.id.id_code_et)
    EditText id_code_et;
    //注册号
    @BindView(R.id.register_et)
    EditText register_et;
    //执照名称
    @BindView(R.id.license_name_et)
    EditText license_name_et;
    //法人名称
    @BindView(R.id.people_name_et)
    EditText people_name_et;
    //经营者手机号
    @BindView(R.id.people_phone_et)
    EditText people_phone_et;
    //本人身份证照片   提示
    @BindView(R.id.id_et)
    TextView id_et;
    //请上传实体店铺照片 提示
    @BindView(R.id.shop_phone_et)
    TextView shop_phone_et;
    //请上传营业执照 提示
    @BindView(R.id.shop_license_et)
    TextView shop_license_et;

    private Map<String, String> map = new HashMap<>();
    //身份证的List集合，图片路径
    private ArrayList<String> idList = new ArrayList<>();
    //店铺图片的List集合，图片路径
    private ArrayList<String> shopList = new ArrayList<>();
    //营业执照图片路径
    private String strPath = null;
    private List<MultipartBody.Part> partList = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted_business_submit);
        ButterKnife.bind(this);
        //获取上个界面传递的值
        ActivityUtils.addActivity(this);
        initGetIntent();
    }

    //获取上个界面传递的值
    private void initGetIntent() {
        String shopName = getIntent().getStringExtra("name");
        String province = getIntent().getStringExtra("province");
        String city = getIntent().getStringExtra("city");
        String county = getIntent().getStringExtra("county");
        String address_detail = getIntent().getStringExtra("address_detail");
        String phone = getIntent().getStringExtra("phone");
        String typeId = getIntent().getStringExtra("typeId");
        name_tv.setText(shopName);
        address_tv.setText(address_detail);


//        DataManager.getInstanceCustom(this).RequestHttp(NetApi.postLanLat("x44CZgW2VKxstNTFqe6zTYpgU5BbXr6r", address_detail, BaseApplication.CITY), new ResultListener<ShopIntoLngLatModel>() {
//            @Override
//            public void responseSuccess(ShopIntoLngLatModel obj) {
//                System.out.println("==========");
//                System.out.println(obj.getResult().getLocation().getLat()+"========"+obj.getResult().getLocation().getLng());
//                System.out.println("==========");
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//        });


        map.put("FKEY", DataManager.getMd5Str("APPBUSINESSIN"));
        map.put("HONOURUSER_ID", BaseApplication.getHonouruserId());
        map.put("CATEGORY_ID", typeId);
        map.put("APPLYFOR_NAME", shopName);
        map.put("APPLYFOR_PROVINCE", province);
        map.put("APPLYFOR_CITY", city);
        map.put("APPLY_COUNTY", county);
        map.put("APPLYFOR_ADDRESS", address_detail);
        map.put("APPLYFOR_TEL", phone);
        map.put("APPLYFOR_LONGITUDE","116.485376");
        map.put("APPLYFOR_LATITUDE","39.894886");
    }

    @OnClick({R.id.relative_one, R.id.relative_four, R.id.relative_five, R.id.submit_btn,R.id.blackwb_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relative_one:
                Intent intentOne = new Intent(this, MySettedBusinessPhotoActivity.class);
                intentOne.putStringArrayListExtra("listPath", idList);
                startActivityForResult(intentOne, 1);
//                ActivityUtils.startActivity(this, MySettedBusinessPhotoActivity.class);
                break;
            case R.id.relative_four:
                Intent intentTwo = new Intent(this, MySettedShopPhotoActivity.class);
                intentTwo.putStringArrayListExtra("listPath", shopList);
                startActivityForResult(intentTwo, 2);
                break;
            case R.id.relative_five:
                Intent intentThree = new Intent(this, MySettedYingYePhotoActivity.class);
                intentThree.putExtra("strPath", strPath);
                startActivityForResult(intentThree, 3);
                break;
            //提交审核
            case R.id.submit_btn:
                submit();
                break;
            case R.id.blackwb_back:
                finish();
                break;
        }
    }

    //提交审核
    private void submit() {
        if (idList.size() == 2 && !TextUtils.isEmpty(name_et.getText().toString().trim()) && !TextUtils.isEmpty(id_code_et.getText().toString().trim()) && !TextUtils.isEmpty(register_et.getText().toString().trim())
                && !TextUtils.isEmpty(license_name_et.getText().toString().trim()) && !TextUtils.isEmpty(people_name_et.getText().toString().trim()) && !TextUtils.isEmpty(people_phone_et.getText().toString().trim())) {
            map.put("APPLY_OPERRATE", name_et.getText().toString().trim());
            map.put("APPLYFOR_IDCARD", id_code_et.getText().toString().trim());
            map.put("APPLYFOR_CHARTERNUM", register_et.getText().toString().trim());
            map.put("APPLYFOR_CHARTERNAME", license_name_et.getText().toString().trim());
            map.put("APPLYFOR_LEGALPERSON", people_name_et.getText().toString().trim());
            map.put("APPLYFOR_PHONE", people_phone_et.getText().toString().trim());

            showLoading(this);

            DataManager.getInstance(this).RequestHttp(NetApi.postShopInto(map, partList, idList, shopList, strPath), new ResultListener<ResultModel>() {
                @Override
                public void responseSuccess(ResultModel obj) {
                    if(obj.getResult().equals("01")){
                        dialogDismiss();
                        UIUtils.showToast("提交成功，请等候7个工作日");
                        ActivityUtils.finishActivity();
                    }
                }

                @Override
                public void onCompleted() {

                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0 && requestCode == 1) {
            idList.clear();
            ArrayList<String> listPath = data.getStringArrayListExtra("listPath");
            if (listPath.size() == 0) {
                id_et.setText("本人身份证照片");
            } else if (listPath.size() == 1) {
                id_et.setText("待完善");
            } else {
                id_et.setText("已完成");
            }
            idList.addAll(listPath);
        } else if (resultCode == 0 && requestCode == 2) {
            shopList.clear();
            ArrayList<String> listPath = data.getStringArrayListExtra("listPath");
            if (listPath.size() == 0) {
                shop_phone_et.setText("请上传实体店铺照片");
            } else if (listPath.size() == 3) {
                shop_phone_et.setText("已完成");
            } else {
                shop_phone_et.setText("待完善");
            }
            shopList.addAll(listPath);
        } else if (resultCode == 0 && requestCode == 3) {
            strPath = data.getStringExtra("strPath");
            if (TextUtils.isEmpty(strPath)) {
                shop_license_et.setText("请上传营业执照");
            } else {
                shop_license_et.setText("已完成");
            }
        }
    }
}
