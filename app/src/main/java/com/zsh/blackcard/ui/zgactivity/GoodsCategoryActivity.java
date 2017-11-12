package com.zsh.blackcard.ui.zgactivity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CategoryLeftAdapter;
import com.zsh.blackcard.ui.ShoppingDetailsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Name: GoodsCategory
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:商品分类列表：
 */
public class GoodsCategoryActivity extends BaseActivity {
    //
    private RecyclerView mLeftRvRecyclerView;
    private GridView mRightGridView;
  private List<String> categoryLeft;
  //private List<int> categoryRight;
  private CategoryLeftAdapter leftAdapter;
  private   SimpleAdapter rightAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.goods_category_avtivity);
        mLeftRvRecyclerView = (RecyclerView) findViewById(R.id.category_left_rv);
        mRightGridView = (GridView) findViewById(R.id.category_right_gv);

        initData();
        leftAdapter=new CategoryLeftAdapter(categoryLeft);


        rightAdapter= new SimpleAdapter(this,getData(img),R.layout.category_right_item,new String[]{"img"},new int[]{R.id.im_right_item});
        mLeftRvRecyclerView.setAdapter(leftAdapter);
        mRightGridView.setAdapter(rightAdapter);

        mLeftRvRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mLeftRvRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                leftAdapter.setSelectPos(i);
                leftAdapter.notifyDataSetChanged();

                dataList.clear();
                dataList=    i%2==0?getData(img):getData(img2);
                rightAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }
        });

        mRightGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // UIUtils.showToast("item="+position);
            startActivity(new Intent(GoodsCategoryActivity.this, ShoppingDetailsActivity.class));
            }
        });

    }
    private List<Map<String, Object>> dataList   = new ArrayList<Map<String, Object>>();
    private int[] img = {R.mipmap.brand_image_1,R.mipmap.brand_image_2,R.mipmap.brand_image_3,R.mipmap.brand_image_4,R.mipmap.brand_image_5,R.mipmap.brand_image_6,R.mipmap.brand_image_7,R.mipmap.brand_image_8,R.mipmap.brand_image_9,R.mipmap.brand_image_10,R.mipmap.brand_image_14,R.mipmap.brand_image_12,R.mipmap.brand_image_13 };
    private int[] img2 = {R.mipmap.brand_image_5,R.mipmap.brand_image_6,R.mipmap.brand_image_7,R.mipmap.brand_image_8,R.mipmap.brand_image_9,R.mipmap.brand_image_10,R.mipmap.brand_image_14,R.mipmap.brand_image_12,R.mipmap.brand_image_13 };
    private List<Map<String, Object>> getData(int[] img ) {
        for (int i=0; i<img.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", img[i]);
            dataList.add(map);
        }
        return dataList;
    }


    private void initData() {
        categoryLeft=new ArrayList<>();
        categoryLeft.add("名物");
        categoryLeft.add("美食");
        categoryLeft.add("艺术品");
        categoryLeft.add("包袋");
        categoryLeft.add("腕表");
        categoryLeft.add("首饰珠宝");
        categoryLeft.add("运动户外");

    }


}
