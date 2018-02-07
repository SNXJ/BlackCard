package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.ChannelAdapter;
import com.zsh.blackcard.model.ChannelModel;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.view.draghelper.ItemDragHelperCallback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: NewChannelActivity
 * Author: Shing
 * Date: 2018/2/7 下午4:04
 * Description: ..
 */

public class NewChannelActivity extends BaseActivity {
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.im_close)
    ImageView imClose;
    @BindView(R.id.recyclerView)
    RecyclerView mRecy;

    @Override
    protected void initUI() {
        setContentView(R.layout.news_channel_activity);
        ButterKnife.bind(this);
        initData();
    }

    List<ChannelModel> items = new ArrayList<>();

    private void initData() {


        items = (List<ChannelModel>) getIntent().getSerializableExtra("listData");

        if (null == items) {

            LogUtils.i("+++++++++++", "+++++++++null++++++");
            return;
        }


//        for (int i = 0; i < 18; i++) {
//            ChannelModel entity = new ChannelModel();
//            entity.setName("频道" + i);
//            items.add(entity);
//        }
        final List<ChannelModel> otherItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ChannelModel entity = new ChannelModel();
            entity.setName("其他" + i);
            otherItems.add(entity);
        }

        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecy);

        final ChannelAdapter adapter = new ChannelAdapter(this, helper, items, otherItems);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == ChannelAdapter.TYPE_MY || viewType == ChannelAdapter.TYPE_OTHER ? 1 : 4;
            }
        });
        mRecy.setAdapter(adapter);

        adapter.setOnMyChannelItemClickListener(new ChannelAdapter.OnMyChannelItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                setData(position);
                Toast.makeText(NewChannelActivity.this, items.get(position).getName() + "+++++++" + items.size(), Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }


    @OnClick(R.id.im_close)
    public void onViewClicked() {
        setData(-1);
        finish();


    }

    private void setData(int postion) {
        Intent intent = new Intent();
        intent.putExtra("position", postion);
        intent.putExtra("listData", (Serializable) items);
        setResult(2, intent);
    }

}
