package com.zsh.blackcard.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.AddressManageModel;
import com.zsh.blackcard.untils.UIUtils;

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

    @Override
    protected void initUI() {
        setContentView(R.layout.address_edit_activity);
        ButterKnife.bind(this);
        initData = (AddressManageModel.PdBean) getIntent().getSerializableExtra("Serializable");
        if (null != initData) {
            initAdderss(initData);
        }
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
                PublicDialog.selectCity(AddressEditActivity.this, tvAddress);
                //   takeOnClick();
                break;
        }
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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).addressAdd(map), new ResultListener<ResultModel>() {
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
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).addressEdit(map), new ResultListener<ResultModel>() {
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

    private void takeOnClick() {

//        llAddress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(AddressEditActivity.this);
//                mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");
//                mChangeAddressPopwindow.showAtLocation(llAddress, Gravity.BOTTOM, 0, 0);
//                mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
//                    @Override
//                    public void onClick(String province, String city, String area) {
//                        // TODO Auto-generated method stub
//                        Toast.makeText(AddressEditActivity.this,
//                                province + "-" + city + "-" + area,
//                                Toast.LENGTH_LONG).show();
//                        tvAddress.setText(province + city + area);
//                    }
//                });
//            }
//        });
    }


}