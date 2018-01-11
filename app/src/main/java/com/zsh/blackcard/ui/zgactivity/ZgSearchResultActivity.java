package com.zsh.blackcard.ui.zgactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
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
import com.zsh.blackcard.view.SpacesItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZgSearchResultActivity extends BaseActivity implements TextView.OnEditorActionListener {

    @BindView(R.id.zg_search_result_recycler)
    RecyclerView zg_search_result_recycler;
    @BindView(R.id.zg_search_et)
    EditText zg_search_et;

    private ZgSearchAdapter zgSearchAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_search_result);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        zg_search_et.setText(data);
        zg_search_result_recycler.setLayoutManager(new LinearLayoutManager(this));
        zg_search_result_recycler.addItemDecoration(new SpacesItemDecoration(this, SpacesItemDecoration.VERTICAL_LIST));
//        //给键盘确定添加监听
        zg_search_et.setOnEditorActionListener(this);
        //查询数据
        initSearch();
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
        DataManager.getInstance(this).RequestHttp(NetApi.postZgSearch(DataManager.getMd5Str("SHIPDIMQ"), "d6a3779de8204dfd9359403f54f7d27c", zg_search_et.getText().toString().trim()), new ResultListener<ZgSearchModel>() {
            @Override
            public void responseSuccess(ZgSearchModel obj) {
                if (obj.getResult().equals("01")) {
                    if (zgSearchAdapter == null) {
                        zgSearchAdapter = new ZgSearchAdapter(R.layout.zg_search_item, obj.getPd());
                        zg_search_result_recycler.setAdapter(zgSearchAdapter);
                        zg_search_result_recycler.addItemDecoration(new SpacesItemDecoration(ZgSearchResultActivity.this,SpacesItemDecoration.VERTICAL_LIST));
                        zgSearchAdapter.setEmptyView(R.layout.zg_search_empty, zg_search_result_recycler);
                    } else {
                        zgSearchAdapter.getData().clear();
                        zgSearchAdapter.getData().addAll(obj.getPd());
                        zgSearchAdapter.notifyDataSetChanged();
                    }
                } else {
                    if (zgSearchAdapter == null) {
                        zgSearchAdapter = new ZgSearchAdapter(R.layout.zg_search_item,obj.getPd());
                        zg_search_result_recycler.setAdapter(zgSearchAdapter);
                        zgSearchAdapter.setEmptyView(R.layout.zg_search_empty, zg_search_result_recycler);
                    } else {
                        zgSearchAdapter.getData().clear();
                        zgSearchAdapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
