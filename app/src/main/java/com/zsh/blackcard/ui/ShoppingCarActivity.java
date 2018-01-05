package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ShoppingCarAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.model.ShoppingCarModel;
import com.zsh.blackcard.utils.UIUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zsh.blackcard.music.MusicDetailActivity.position;

/**
 * 购物车列表页面
 */
public class ShoppingCarActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {
    //购物车列表
    @BindView(R.id.shopping_car_recycler)
    RecyclerView shopping_car_recycler;
    @BindView(R.id.shopping_checkBox)
    CheckBox shopping_checkBox;
    @BindView(R.id.shopping_money_tv)
    TextView shopping_money_tv;
    //购物车列表适配器
    private ShoppingCarAdapter shoppingCarAdapter;

    private int money = 0;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_shopping_car);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick({R.id.shopping_back, R.id.shopping_checkBox, R.id.shopping_num_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shopping_back:
                finish();
                break;
            case R.id.shopping_checkBox:
                money = 0;
                if (shopping_checkBox.isChecked()) {
                    //设置全部checkBox为选中状态
                    shoppingCarAdapter.yesSelect();
                    //计算全部金额
                    for (int i = 0; i < shoppingCarAdapter.getData().size(); i++) {
                        money += shoppingCarAdapter.getData().get(i).getPROPRICE() * shoppingCarAdapter.getData().get(i).getPRODUCTCOUNT();
                    }

                    shopping_money_tv.setText("总计：¥" + money);
                } else {
                    shoppingCarAdapter.noSelect();
                    shopping_money_tv.setText("总计：¥" + money);
                }
                shoppingCarAdapter.notifyDataSetChanged();
                break;
            case R.id.shopping_num_btn:
                if (!shoppingCarAdapter.numBtn()) {
                    UIUtils.showToast("请最少选取一个商品");
                } else {
                    UIUtils.showToast("结算功能暂未开发");
                }
                break;
        }
    }

    private void initData() {
        showLoading(this);
        //加载购物车列表
        DataManager.getInstance(this).RequestHttp(NetApi.postShoppingCar(DataManager.getMd5Str("SHOPPINGCART"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<ShoppingCarModel>() {
            @Override
            public void responseSuccess(ShoppingCarModel obj) {
                if (obj.getResult().equals("01")) {
                    shoppingCarAdapter = new ShoppingCarAdapter(R.layout.activity_shopping_car_item, obj.getPd());
                    shopping_car_recycler.setLayoutManager(new LinearLayoutManager(ShoppingCarActivity.this));
                    shopping_car_recycler.addItemDecoration(new SpacesItemDecoration(ShoppingCarActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                    shopping_car_recycler.setAdapter(shoppingCarAdapter);
                    //侧滑删除会和普通的行布局点击时间发生点击事件冲突
                    shoppingCarAdapter.setOnItemChildClickListener(ShoppingCarActivity.this);
                    //此时把整个行布局的id绑定为子控件点击事件。
                }
            }

            @Override
            public void onCompleted() {
                dialogDismiss();
            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            //侧滑点击
            case R.id.shopping_car_item_right_delete:
                initDeleteCar(position);

                break;
            //整个行布局的RelativeLayout点击
            case R.id.shopping_car_item_relative:
                UIUtils.showToast("222222");
                break;
            //其他子控件点击
            case R.id.shopping_car_item_cb:
                if (((CheckBox) view).isChecked()) {
                    //根据返回的状态，设置cb的选择状态
                    if (shoppingCarAdapter.initSelect(true, position)) {
                        shopping_checkBox.setChecked(true);
                    } else {
                        shopping_checkBox.setChecked(false);
                    }
                    //每次点击累加选中的金额
                    money += shoppingCarAdapter.getData().get(position).getPROPRICE() * shoppingCarAdapter.getData().get(position).getPRODUCTCOUNT();
                } else {
                    shoppingCarAdapter.initSelect(false, position);
                    shopping_checkBox.setChecked(false);
                    //每次点击减去取消选中的金额
                    money -= shoppingCarAdapter.getData().get(position).getPROPRICE() * shoppingCarAdapter.getData().get(position).getPRODUCTCOUNT();
                }
                shopping_money_tv.setText("总计：¥" + money);
                break;
        }
    }

    //从购物车删除商品
    private void initDeleteCar(final int position) {
        DataManager.getInstance(this).RequestHttp(NetApi.postShoppingCarDelete(DataManager.getMd5Str("SHIPCARTDEL"), shoppingCarAdapter.getData().get(position).getPRODUCT_ID(), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                if (obj.getResult().equals("01")) {
                    shoppingCarAdapter.getData().remove(position);
                    shoppingCarAdapter.notifyItemRemoved(position);
                    shoppingCarAdapter.notifyItemRangeChanged(position, shoppingCarAdapter.getData().size());
                    UIUtils.showToast("删除商品成功");
                } else {
                    UIUtils.showToast("删除商品失败");
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
