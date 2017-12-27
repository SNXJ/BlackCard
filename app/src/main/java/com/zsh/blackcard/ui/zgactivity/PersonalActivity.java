package com.zsh.blackcard.ui.zgactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgPersonalTailorAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgPersonalTailorModel;
import com.zsh.blackcard.ui.ZgPersonalTailorDetailActivity;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: PersonalActivity
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:描述：
 */
public class PersonalActivity extends BaseActivity {

    @BindView(R.id.zg_drawer_personal_recycler)
    RecyclerView zg_drawer_personal_recycler;

    private ZgPersonalTailorAdapter zgPersonalTailorAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.personal_activity);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.title_back)
    public void onClick(){
        finish();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postZgPersonalTailorModel(DataManager.getMd5Str("PERSONAL")), new ResultListener<ZgPersonalTailorModel>() {
            @Override
            public void responseSuccess(ZgPersonalTailorModel obj) {
                zgPersonalTailorAdapter = new ZgPersonalTailorAdapter(R.layout.zg_drawer_personal_recycler_item,obj.getPd());
                zg_drawer_personal_recycler.setLayoutManager(new LinearLayoutManager(PersonalActivity.this));
                zg_drawer_personal_recycler.setAdapter(zgPersonalTailorAdapter);
                zgPersonalTailorAdapter.setOnItemChildClickListener(new ZgPersonalTailorOnItemClick());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private class ZgPersonalTailorOnItemClick implements BaseQuickAdapter.OnItemChildClickListener{


        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            ActivityUtils.startActivityForData(PersonalActivity.this, ZgPersonalTailorDetailActivity.class,((ZgPersonalTailorModel.PdBean)adapter.getData().get(position)).getPERSONAL_ID());
        }
    }
}
