package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.SelectTopicAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.listener.TopicListener;
import com.zsh.blackcard.model.TopicListModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: SelectTopicActivity
 * Author: Shing
 * Date: 17/12/26 上午10:50
 * Description: 选择话题
 */

public class SelectTopicActivity extends BaseActivity implements TextWatcher {
    @BindView(R.id.et_topic)
    EditText etTopic;
    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    SelectTopicAdapter adapter;
    List<TopicListModel.PdBean> list = new ArrayList<>();
    List<TopicListModel.PdBean> listAll = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.select_topic_activity);
        ButterKnife.bind(this);
        getTopicData("");
//        initData();
    }

    private void getTopicData(final String str) {
        showLoading(this);
        DataManager.getInstance(this).RequestHttp(NetApi.getTopicList(DataManager.getMd5Str("TOPICLIST"), str), new ResultListener<TopicListModel>() {
            @Override
            public void responseSuccess(TopicListModel obj) {
                if ("01".equals(obj.getResult())) {
                    list.clear();
                    list = obj.getPd();
                    if ("".equals(str)) {
                        listAll.addAll(list);
                    }

                    initData(list);
                } else {
                    setSelfTopic();
                }

            }

            @Override
            public void onCompleted() {
                dialogDismiss();
            }
        });
    }

    private void initData(final List<TopicListModel.PdBean> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelectTopicAdapter(list);
        recyclerView.setAdapter(adapter);
        etTopic.addTextChangedListener(this);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (null != listener) {
                    listener.dateListener(list.get(position));
                }
                finish();

            }
        });

    }

    static TopicListener listener;

    public static void setListener(TopicListener strListener) {
        listener = strListener;
    }

    @OnClick(R.id.tv_cancle)
    public void onViewClicked() {
        String tv = tvCancle.getText().toString().trim();
        if ("搜索".equals(tv)) {

            getTopicData(etTopic.getText().toString().trim());
//            setSelfTopic();
        } else {
            finish();
        }

    }

    private void setSelfTopic() {

        list.clear();
        TopicListModel.PdBean temp = new TopicListModel.PdBean();
        temp.setTITLE(etTopic.getText().toString().trim());
        temp.setDESCRIPTION("新话题");

        list.add(temp);
//        adapter.notifyDataSetChanged();
        initData(list);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    String str;

    @Override
    public void afterTextChanged(Editable editable) {
        if (null != editable && !"".equals(editable.toString())) {
            tvCancle.setText("搜索");
            str = editable.toString();
        } else {
            tvCancle.setText("取消");

            if (null != listAll) {

                initData(listAll);

            }
        }

    }
}
