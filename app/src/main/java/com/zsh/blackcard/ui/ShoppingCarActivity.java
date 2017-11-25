package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ShoppingCarAdapter;
import com.zsh.blackcard.untils.UIUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购物车列表页面
 */
public class ShoppingCarActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {
    //购物车列表
    @BindView(R.id.shopping_car_recycler)
    RecyclerView shopping_car_recycler;
    //购物车列表适配器
    private ShoppingCarAdapter shoppingCarAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_shopping_car);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.shopping_back)
    public void onClick() {
        finish();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }

        shoppingCarAdapter = new ShoppingCarAdapter(R.layout.activity_shopping_car_item, list);
        shopping_car_recycler.setLayoutManager(new LinearLayoutManager(this));
        shopping_car_recycler.addItemDecoration(new SpacesItemDecoration(this, SpacesItemDecoration.VERTICAL_LIST));
        shopping_car_recycler.setAdapter(shoppingCarAdapter);
        shoppingCarAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.shopping_car_item_right_delete:
                list.remove(position);
                UIUtils.showToast("删除成功");
                shoppingCarAdapter.notifyItemRemoved(position);
                shoppingCarAdapter.notifyItemRangeChanged(position,list.size());
//                System.out.println(list.get(position)+"=====");
                break;
        }
    }
}
