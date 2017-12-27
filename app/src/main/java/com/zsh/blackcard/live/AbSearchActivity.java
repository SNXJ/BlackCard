package com.zsh.blackcard.live;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.AbSearchAdapter;

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
public class AbSearchActivity extends BaseActivity {
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.history_recycle)
    RecyclerView historyRecycle;
    @BindView(R.id.hot_recycle)
    RecyclerView hotRecycle;
    private AbSearchAdapter adapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.ab_search_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        list.add("周杰伦");

        adapter = new AbSearchAdapter(list);
        historyRecycle.setLayoutManager(new GridLayoutManager(this, 3));
        historyRecycle.setAdapter(adapter);
        list.add("林俊杰");
        list.add("陈奕迅");
        list.add("陈粒");
        AbSearchAdapter adapter2 = new AbSearchAdapter(list);
        hotRecycle.setLayoutManager(new GridLayoutManager(this, 3));
        hotRecycle.setAdapter(adapter2);
    }

    @OnClick(R.id.tv_cancel)
    public void onClick() {
        finish();
    }
}
