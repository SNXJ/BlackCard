package com.zsh.blackcard.live;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbSearchAdapter;
import com.zsh.blackcard.adapter.AbSearchHotAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.AbSearchModel;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.SharedPreferencesUtils;
import com.zsh.blackcard.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: AbSearchActivity
 * Author: SNXJ
 * Date: 2017-12-19
 * Description:描述：
 */
public class AbSearchActivity extends BaseActivity implements TextWatcher, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.et_search)
    EditText etSearch;

    @BindView(R.id.history_recycle)
    RecyclerView historyRecycle;
    @BindView(R.id.hot_recycle)
    RecyclerView hotRecycle;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.ll_hot_history)
    LinearLayout llHotHistory;
    @BindView(R.id.search_recycle)
    RecyclerView searchRecycle;
    private AbSearchHotAdapter hotAdapter;
    private AbSearchHotAdapter historyAdapter;
    private AbSearchAdapter resultAdapter;
    private String searchStr;

    private List<AbSearchModel.PdBean> historyList = new ArrayList<>();
    private List<AbSearchModel.PdBean> hotList = new ArrayList<>();
    private List<AbSearchModel.PdBean> searchList = new ArrayList<>();
    private String history_SP_Data = "History_SP_Data";

    @Override
    protected void initUI() {
        setContentView(R.layout.ab_search_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        setHistoryRecycle();
        etSearch.addTextChangedListener(this);
        getHotList();
    }


    @OnClick(R.id.tv_search)
    public void onViewClicked() {

        String tv = tvSearch.getText().toString().trim();
        if ("搜索".equals(tv)) {
            getSearchList(etSearch.getText().toString().trim());
        } else {
            finish();
        }

    }

    private void getHotList() {
        saveNotifySearchHistory();

        DataManager.getInstance(this).RequestHttp(NetApi.getAbSearchHotList(DataManager.getMd5Str("SERRCHLIST"), "4"), new ResultListener<AbSearchModel>() {
            @Override
            public void responseSuccess(AbSearchModel obj) {

                if ("01".equals(obj.getResult()) || "02".equals(obj.getResult())) {

                    hotList = obj.getPd();
                    hotAdapter = new AbSearchHotAdapter(hotList);

                    hotRecycle.setLayoutManager(new GridLayoutManager(AbSearchActivity.this, 3));
                    hotRecycle.setAdapter(hotAdapter);
                    hotAdapter.setEmptyView(R.layout.zg_search_empty, hotRecycle);
                    hotAdapter.setOnItemClickListener(AbSearchActivity.this);

                }

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void getSearchList(String sreachStr) {
        saveNotifySearchHistory();

        DataManager.getInstance(this).RequestHttp(NetApi.getAbSearchList(DataManager.getMd5Str("USERLIST"), sreachStr), new ResultListener<AbSearchModel>() {
            @Override
            public void responseSuccess(AbSearchModel obj) {

                setResultData(obj);

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void setHistoryRecycle() {
        historyList = SharedPreferencesUtils.getDataList(this, history_SP_Data, AbSearchModel.PdBean.class);
//        if (null == historyAdapter) {
        historyAdapter = new AbSearchHotAdapter(historyList);
        historyRecycle.setLayoutManager(new GridLayoutManager(this, 3));
        historyRecycle.setAdapter(historyAdapter);
        historyAdapter.setEmptyView(R.layout.zg_search_empty, historyRecycle);
        historyAdapter.setOnItemClickListener(this);

//        } else {
//            historyAdapter.notifyDataSetChanged();
//        }


    }

    private void saveNotifySearchHistory() {
        if (StringUtils.isEmpty(searchStr)) {
            return;
        }
        historyList = SharedPreferencesUtils.getDataList(this, history_SP_Data, AbSearchModel.PdBean.class);
        LogUtils.i("++++++++++", "+++++++++++++" + historyList.size());

        AbSearchModel.PdBean abSearchPd = new AbSearchModel.PdBean();

        abSearchPd.setNICKNAME(searchStr);
        abSearchPd.setHONOURUSER_ID("");
        historyList.add(abSearchPd);
        SharedPreferencesUtils.saveDataList(this, history_SP_Data, historyList);

    }


    private void setResultData(AbSearchModel obj) {

        llHotHistory.setVisibility(View.GONE);
        searchRecycle.setVisibility(View.VISIBLE);
        if ("01".equals(obj.getResult()) || "02".equals(obj.getResult())) {

            searchList = obj.getPd();
            resultAdapter = new AbSearchAdapter(searchList);

            searchRecycle.setLayoutManager(new LinearLayoutManager(this));
            searchRecycle.setAdapter(resultAdapter);
            resultAdapter.setEmptyView(R.layout.zg_search_empty, searchRecycle);
            resultAdapter.setOnItemClickListener(this);

        }

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (null != editable && !"".equals(editable.toString())) {
            tvSearch.setText("搜索");
            searchStr = editable.toString();
        } else {
            tvSearch.setText("取消");

            llHotHistory.setVisibility(View.VISIBLE);
            searchRecycle.setVisibility(View.GONE);
            setHistoryRecycle();
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
