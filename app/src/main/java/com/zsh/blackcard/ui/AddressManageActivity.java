package com.zsh.blackcard.ui;

import android.location.Address;
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
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 收获地址管理
 */

public class AddressManageActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.btn_add)
    Button btnAdd;

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
        DataManager.getInstance(this).RequestHttp(NetApi.postAddressManage(DataManager.getMd5Str("SHIPADR"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<AddressManageModel>() {
            @Override
            public void responseSuccess(AddressManageModel obj) {
                if (obj.getResult().equals("01")) {
                    if (adapter == null) {
                        adapter = new AddressManageAdapter(obj.getPd());
                        recyclerView.setLayoutManager(new LinearLayoutManager(AddressManageActivity.this));
                        recyclerView.setAdapter(adapter);
                        adapter.setOnItemChildClickListener(AddressManageActivity.this);
                    } else {
                        adapter.getData().clear();
                        adapter.getData().addAll(obj.getPd());
                        adapter.initBoolean(obj.getPd().size());
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void delData(String id, final int position) {
        DataManager.getInstance(this).RequestHttp(NetApi.delAddress(DataManager.getMd5Str("SHIPADR"), id), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if ("01".equals(obj.getResult())) {
                    UIUtils.showToast("删除成功");
                    if (null != adapter) {
                        adapter.getData().remove(position);
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

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.cb_set:
                if (((CheckBox) view).isChecked()) {
                    this.adapter.initSelect(position, true);
                } else {
                    this.adapter.initSelect(position, false);
                }
                this.adapter.notifyDataSetChanged();
                break;
            case R.id.rb_edit:
                ActivityUtils.startActivityForSerializable(AddressManageActivity.this, AddressEditActivity.class, ((AddressManageAdapter) adapter).getData().get(position));
                break;
            case R.id.rb_del:
                delData(((AddressManageAdapter) adapter).getData().get(position).getADDRESS_ID(), position);
                break;
        }
    }
}