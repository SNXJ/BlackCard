package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgSearchAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgSearchModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/27.
 * 尊购模糊查询页面
 */

public class ZgSearchActivity extends BaseActivity implements TextView.OnEditorActionListener {

    @BindView(R.id.zg_search_recycler)
    RecyclerView zg_search_recycler;

    private ZgSearchAdapter zgSearchAdapter;

    @BindView(R.id.zg_search_et)
    EditText zg_search_et;

    private List<ZgSearchModel.PdBean> pdBeanList = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_search);
        ButterKnife.bind(this);
        //给键盘确定添加监听
        zg_search_et.setOnEditorActionListener(this);
    }

    @OnClick(R.id.title_back)
    public void onClick(){
        finish();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (actionId) {
            case EditorInfo.IME_ACTION_DONE:
                //查询数据
                initSearch();
                break;
        }
        return false;
    }

    private void initSearch() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postZgSearch(DataManager.getMd5Str("SHIPDIMQ"), "d6a3779de8204dfd9359403f54f7d27c", zg_search_et.getText().toString().trim()), new ResultListener<ZgSearchModel>() {
            @Override
            public void responseSuccess(ZgSearchModel obj) {
                if (zgSearchAdapter == null) {
                    if (!obj.getResult().equals("01")) {
                        zgSearchAdapter = new ZgSearchAdapter(R.layout.zg_search_item, pdBeanList);
                    } else {
                        pdBeanList.addAll(obj.getPd());
                        zgSearchAdapter = new ZgSearchAdapter(R.layout.zg_search_item, pdBeanList);
                    }
                    zg_search_recycler.setLayoutManager(new LinearLayoutManager(ZgSearchActivity.this));
                    zg_search_recycler.setAdapter(zgSearchAdapter);
                    zgSearchAdapter.setEmptyView(R.layout.zg_search_empty, zg_search_recycler);
                } else {
                    pdBeanList.clear();
                    if (obj.getResult().equals("01")) {
                        pdBeanList.addAll(obj.getPd());
                    }
                    zgSearchAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
