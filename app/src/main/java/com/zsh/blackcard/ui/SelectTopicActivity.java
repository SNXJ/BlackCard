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
import com.zsh.blackcard.listener.DateListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: SelectTopicActivity
 * Author: Shing
 * Date: 17/12/26 上午10:50
 * Description: ..
 */

public class SelectTopicActivity extends BaseActivity implements TextWatcher {
    @BindView(R.id.et_topic)
    EditText etTopic;
    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    SelectTopicAdapter adapter;
    List<String> list = new ArrayList<>();
    @Override
    protected void initUI() {
        setContentView(R.layout.select_topic_activity);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        list.add("#新年快乐哈哈#");
        list.add("#新年快乐哈哈#");
        list.add("#新年快乐哈哈#");
        list.add("#新年快乐哈哈#");
        list.add("#新年快乐哈哈#");


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SelectTopicAdapter(list);
        recyclerView.setAdapter(adapter);
        etTopic.addTextChangedListener(this);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(null!=listener){
                    listener.dateListener(list.get(position));
                }
                finish();

            }
        });

    }
   static DateListener listener;
public static void setListener(DateListener strListener){
    listener=strListener;
}
    @OnClick(R.id.tv_cancle)
    public void onViewClicked() {
       String tv= tvCancle.getText().toString().trim();
       if("搜索".equals(tv)){
            setSelfTopic();
       }else{
           finish();
       }

    }

    private void setSelfTopic() {

        list.clear();
        list.add("#"+etTopic.getText().toString().trim()+"#");
        adapter.notifyDataSetChanged();

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
        if (null != editable &&  !"".equals(editable.toString())) {
            tvCancle.setText("搜索");
            str = editable.toString();
        } else {
            tvCancle.setText("取消");
        }

    }
}
