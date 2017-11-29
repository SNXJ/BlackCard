package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AddressManageAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.AddressManageModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收获地址管理
 */

public class AddressManageActivity extends BaseActivity {


    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.btn_add)
    Button btnAdd;

    List<AddressManageModel.PdBean> dataList = new ArrayList<>();
    private AddressManageAdapter adapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_adress_manage);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postAddressManage(DataManager.getMd5Str("SHIPADR"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<AddressManageModel>() {
            @Override
            public void responseSuccess(AddressManageModel obj) {
                dataList = obj.getPd();
                recyclerView.setLayoutManager(new LinearLayoutManager(AddressManageActivity.this));
                adapter = new AddressManageAdapter(dataList);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        switch (view.getId()) {
                            case R.id.cb_set:

                                setRbStatus(view, position);

                                break;
                            case R.id.rb_edit:
                                ActivityUtils.startActivityForSerializable(AddressManageActivity.this, AddressEditActivity.class, dataList.get(position));
                                break;
                            case R.id.rb_del:
                                delData(dataList.get(position).getADDRESS_ID(), position);
                                break;

                        }

                    }
                });
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setRbStatus(View view, int position) {

        CheckBox cb = (CheckBox) view;

//        if (cb.isChecked()) {
//            cb.setChecked(false);
//        } else {
//            cb.setChecked(true);
//        }
        //TODO 修改实体类字段状态
        adapter.notifyDataSetChanged();
    }

    private void delData(String id, final int position) {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).delAddress(DataManager.getMd5Str("SHIPADR"), id), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    UIUtils.showToast("删除成功");
                    if (null != adapter) {
                        dataList.remove(position);
                        adapter.notifyDataSetChanged();

                    }
                } else {
                    UIUtils.showToast("删除失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick({R.id.im_back, R.id.btn_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.btn_add:
                ActivityUtils.startActivity(AddressManageActivity.this, AddressEditActivity.class);
                break;
        }
    }
}
