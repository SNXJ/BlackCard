package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ShoppingCarAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ShoppingCarModel;
import com.zsh.blackcard.utils.UIUtils;
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

    private List<ShoppingCarModel.PdBean> pdBeanList = new ArrayList<>();

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
        //加载购物车列表
        DataManager.getInstance(this).RequestHttp(NetApi.postShoppingCar(DataManager.getMd5Str("SHOPPINGCART"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<ShoppingCarModel>() {
            @Override
            public void responseSuccess(ShoppingCarModel obj) {
                pdBeanList.addAll(obj.getPd());
                shoppingCarAdapter = new ShoppingCarAdapter(R.layout.activity_shopping_car_item, pdBeanList);
                shopping_car_recycler.setLayoutManager(new LinearLayoutManager(ShoppingCarActivity.this));
                shopping_car_recycler.addItemDecoration(new SpacesItemDecoration(ShoppingCarActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                shopping_car_recycler.setAdapter(shoppingCarAdapter);
                //侧滑删除会和普通的行布局点击时间发生点击事件冲突
                shoppingCarAdapter.setOnItemChildClickListener(ShoppingCarActivity.this);
                //此时把整个行布局的id绑定为子控件点击事件。
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            //侧滑点击
            case R.id.shopping_car_item_right_delete:
                pdBeanList.remove(position);
                UIUtils.showToast("删除成功");
                shoppingCarAdapter.notifyItemRemoved(position);
                shoppingCarAdapter.notifyItemRangeChanged(position, pdBeanList.size());
                UIUtils.showToast("ASDaaaaaa");
                break;
                //整个行布局的RelativeLayout点击
            case R.id.shopping_car_item_relative:
                UIUtils.showToast("222222");
                break;
                //其他子控件点击
            case R.id.shopping_car_item_cb:
                UIUtils.showToast("1111111");
                break;
        }
    }
}
