package com.zsh.blackcard.ui.zgactivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CategoryLeftAdapter;
import com.zsh.blackcard.adapter.CategoryRightAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CategoryLeftModel;
import com.zsh.blackcard.model.CategoryRightModel;
import com.zsh.blackcard.utils.UIUtils;
import com.zsh.blackcard.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: GoodsCategory
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:商品分类列表：
 */
public class GoodsCategoryActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    //商品分类左边列表
    @BindView(R.id.goods_category_recycler_left)
    RecyclerView goods_category_recycler_left;
    //商品分类右边列表
    @BindView(R.id.goods_category_recycler_right)
    RecyclerView goods_category_recycler_right;
    //商品分类左边列表适配器
    private CategoryLeftAdapter categoryLeftAdapter;
    //商品分类右边列表适配器
    private CategoryRightAdapter categoryRightAdapter;

    private List<CategoryRightModel.PdBean> pdBeanList = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.goods_category_avtivity);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick({R.id.back_img,R.id.search_one_rb,R.id.search_two_rb,R.id.search_three_br})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.search_one_rb:
                UIUtils.showToast("点击了1");
                break;
            case R.id.search_two_rb:
                UIUtils.showToast("点击了2");
                break;
            case R.id.search_three_br:
                UIUtils.showToast("点击了3");
                break;
            case R.id.back_img:
                finish();
                break;
        }
    }

    private void initData() {
        goods_category_recycler_right.setNestedScrollingEnabled(false);
        //商品分类左边列表
        DataManager.getInstance(this).RequestHttp(NetApi.postCategoryLeft(DataManager.getMd5Str("SHIPBR")), new ResultListener<CategoryLeftModel>() {
            @Override
            public void responseSuccess(CategoryLeftModel obj) {
                categoryLeftAdapter = new CategoryLeftAdapter(R.layout.category_left_item, obj.getPd());
                goods_category_recycler_left.setLayoutManager(new LinearLayoutManager(GoodsCategoryActivity.this));
                goods_category_recycler_left.addItemDecoration(new SpacesItemDecoration(GoodsCategoryActivity.this, SpacesItemDecoration.VERTICAL_LIST));
                goods_category_recycler_left.setAdapter(categoryLeftAdapter);
                categoryLeftAdapter.setOnItemClickListener(GoodsCategoryActivity.this);
                //如果左边列表加载成功，则默认加载列表中的第一个子列表
                initRecyclerRight(obj.getPd().get(0).getBRAND_ID());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    //加载右边列表的适配器
    private void initRecyclerRight(String brand_id) {
        DataManager.getInstance(this).RequestHttp(NetApi.postCategoryRight(DataManager.getMd5Str("SHIPBRIC"), brand_id,""), new ResultListener<CategoryRightModel>() {
            @Override
            public void responseSuccess(CategoryRightModel obj) {
                if(pdBeanList != null){
                    pdBeanList.clear();
                }
                pdBeanList.addAll(obj.getPd());
                //如果适配器为空则创建新适配器，如果不为空则刷新。
                if (categoryRightAdapter != null) {
                    categoryRightAdapter.notifyDataSetChanged();
                } else {
                    categoryRightAdapter = new CategoryRightAdapter(R.layout.category_right_item_new, pdBeanList);
                    goods_category_recycler_right.setLayoutManager(new LinearLayoutManager(GoodsCategoryActivity.this));
                    goods_category_recycler_right.setAdapter(categoryRightAdapter);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        //每次点击其他item，刷新列表。
        categoryLeftAdapter.selectState(position);
        categoryLeftAdapter.notifyDataSetChanged();
        //加载右边列表
        initRecyclerRight(((CategoryLeftModel.PdBean) adapter.getData().get(position)).getBRAND_ID());
    }
}
