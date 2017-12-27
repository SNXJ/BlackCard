package com.zsh.blackcard.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.CommodityDetailCommentAdapter;
import com.zsh.blackcard.adapter.CommodityDetailImgRecyclerAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CommodityDetailModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;

/**
 * Created by kkkkk on 2017/11/17.
 * 商品详情页面（手表）
 */

public class CommodityDetailBannerActivity extends BaseActivity implements NestedScrollView.OnScrollChangeListener {

    @BindView(R.id.commodity_detail_banner_scrollview)
    NestedScrollView commodity_detail_banner_scrollview;

    @BindView(R.id.commodity_detail_banner_rg)
    RadioGroup commodity_detail_banner_rg;

    @BindView(R.id.commodity_detail_banner_left_rb)
    RadioButton commodity_detail_banner_left_rb;
    @BindView(R.id.commodity_detail_banner_center_rb)
    RadioButton commodity_detail_banner_center_rb;
    @BindView(R.id.commodity_detail_banner_right_rb)
    RadioButton commodity_detail_banner_right_rb;
    @BindView(R.id.commodity_detail_banner)
    Banner commodity_detail_banner;
    @BindView(R.id.commodity_detail_table)
    TableLayout commodity_detail_table;
    @BindView(R.id.commodity_detail_comment_recycler)
    RecyclerView commodity_detail_comment_recycler;
    @BindView(R.id.commodity_detail_recycler)
    RecyclerView commodity_detail_recycler;
    private CommodityDetailCommentAdapter commodityDetailCommentAdapter;
    private CommodityDetailImgRecyclerAdapter commodityDetailImgRecyclerAdapter;

    @BindView(R.id.commodity_detail_type_tv)
    TextView commodity_detail_type_tv;
    @BindView(R.id.commodity_detail_price_tv)
    TextView commodity_detail_price_tv;

    int rgHeight;
    int commodity_detail_banner_height;
    int shop_height, detail_height, comment_height, detail_bottom_height;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    commodity_detail_banner_scrollview.smoothScrollTo(0, 0);
                    break;
                case 1:
                    commodity_detail_banner_scrollview.smoothScrollTo(0, detail_height);
                    break;
                case 2:
                    commodity_detail_banner_scrollview.smoothScrollTo(0, comment_height);
                    break;
            }
            return false;
        }
    });

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_commodity_detail_banner);
        ButterKnife.bind(this);
        final Gson gson = new Gson();
        //请求数据
        initData(gson);
    }

    private void initData(final Gson gson) {
        commodity_detail_comment_recycler.setNestedScrollingEnabled(false);
        commodity_detail_recycler.setNestedScrollingEnabled(false);
        //请求数据
        DataManager.getInstance(this).RequestHttp(NetApi.commodityDteail(DataManager.getMd5Str("SHIPDT"), "388354150699630592"), new ResultListener<ResponseBody>() {
            @Override
            public void responseSuccess(ResponseBody obj) {
                try {
                    String string = obj.string();
                    //先把str转换为bean类
                    CommodityDetailModel commodityDetailModel = gson.fromJson(string, CommodityDetailModel.class);
                    //添加banner图片轮播
                    commodity_detail_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                    commodity_detail_banner.setIndicatorGravity(BannerConfig.CENTER);
                    commodity_detail_banner.setImageLoader(new MyImageLoader());
                    commodity_detail_banner.setImages(commodityDetailModel.getPd().getPRODUCTIMG());
                    commodity_detail_banner.isAutoPlay(false);
                    commodity_detail_banner.start();
                    commodity_detail_banner_scrollview.setOnScrollChangeListener(CommodityDetailBannerActivity.this);
                    //设置标题
                    commodity_detail_type_tv.setText(commodityDetailModel.getPd().getPROTITLE());
                    //设置价钱
                    commodity_detail_price_tv.setText("￥" + commodityDetailModel.getPd().getPROPRICE());
                    commodity_detail_banner_right_rb.setText("评论("+commodityDetailModel.getPd().getEVALUATECOUNT()+")");
                    commodityDetailImgRecyclerAdapter = new CommodityDetailImgRecyclerAdapter(R.layout.activity_commodity_detail_img_recycler, commodityDetailModel.getDetail());
                    commodity_detail_recycler.setLayoutManager(new LinearLayoutManager(CommodityDetailBannerActivity.this));
                    commodity_detail_recycler.setAdapter(commodityDetailImgRecyclerAdapter);

                    //把图片详情转换
                    JSONObject jsonObject = new JSONObject(string);
                    JSONObject proproperty = jsonObject.getJSONObject("pd");
                    //把jsonStr转换为Map
                    Map mapDetail = JSON.parseObject(proproperty.getJSONObject("PROPROPERTY").toString());
                    //遍历所有key和value
                    for (Object objTable : mapDetail.keySet()) {
                        View view = LayoutInflater.from(CommodityDetailBannerActivity.this).inflate(R.layout.activity_commodity_detail_item, null);
                        TextView left_tv = (TextView) view.findViewById(R.id.activity_commodity_detail_item_left_tv);
                        TextView right_tv = (TextView) view.findViewById(R.id.activity_commodity_detail_item_right_tv);
                        left_tv.setText(objTable.toString());
                        right_tv.setText(mapDetail.get(objTable).toString());
                        commodity_detail_table.addView(view);
                    }
                    //加载评论区域
                    commodityDetailCommentAdapter = new CommodityDetailCommentAdapter(R.layout.activity_commodity_detail_comment_item, commodityDetailModel.getEvaList());
                    commodity_detail_comment_recycler.setLayoutManager(new LinearLayoutManager(CommodityDetailBannerActivity.this));
                    commodity_detail_comment_recycler.setAdapter(commodityDetailCommentAdapter);
                    //计算滑动距离
                    initDistance();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private void initDistance() {
        //获取commodity_detail_banner_rg高度
        rgHeight = commodity_detail_banner_rg.getHeight();
        //获取banner与title的差高度
        commodity_detail_banner_height = commodity_detail_banner.getHeight() - rgHeight;
        //测量动态变化后的tableLayout高度
        int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        commodity_detail_table.measure(height, 0);
        commodity_detail_recycler.measure(height, 0);
        //获取整个商品区的底部距离顶端的距离
        shop_height = commodity_detail_table.getTop() + commodity_detail_table.getMeasuredHeight() - rgHeight;

        //获取商品详情距离顶部的距离
        detail_bottom_height = commodity_detail_recycler.getTop() + commodity_detail_table.getMeasuredHeight() + commodity_detail_recycler.getMeasuredHeight() - rgHeight;
        //详情区的顶部坐标
        detail_height = commodity_detail_recycler.getTop() + commodity_detail_table.getMeasuredHeight() - rgHeight;
        //获取商品评论距离顶部的距离
        comment_height = commodity_detail_comment_recycler.getTop() + commodity_detail_table.getMeasuredHeight() + commodity_detail_recycler.getMeasuredHeight() - rgHeight;
    }

    public class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(path).into(imageView);
        }
    }

    //商品，详情，评论点击。此处针对RadioButton点击采用OnClick监听。实现多次点击同一按钮依然可以响应事件。
    @OnClick({R.id.commodity_detail_banner_left_rb, R.id.commodity_detail_banner_center_rb, R.id.commodity_detail_banner_right_rb, R.id.blackwb_back})
    public void radioButtonOnClick(View view) {
        switch (view.getId()) {
            case R.id.commodity_detail_banner_left_rb:
                commodity_detail_banner_left_rb.setChecked(true);
                commodity_detail_banner_left_rb.setTextColor(Color.parseColor("#FFF29E19"));
                commodity_detail_banner_center_rb.setTextColor(Color.parseColor("#FF929292"));
                commodity_detail_banner_right_rb.setTextColor(Color.parseColor("#FF929292"));
                handler.sendEmptyMessage(0);
                break;
            case R.id.commodity_detail_banner_center_rb:
                commodity_detail_banner_center_rb.setChecked(true);
                commodity_detail_banner_left_rb.setTextColor(Color.parseColor("#FF929292"));
                commodity_detail_banner_center_rb.setTextColor(Color.parseColor("#FFF29E19"));
                commodity_detail_banner_right_rb.setTextColor(Color.parseColor("#FF929292"));
                handler.sendEmptyMessage(1);
                break;
            case R.id.commodity_detail_banner_right_rb:
                commodity_detail_banner_right_rb.setChecked(true);
                commodity_detail_banner_left_rb.setTextColor(Color.parseColor("#FF929292"));
                commodity_detail_banner_center_rb.setTextColor(Color.parseColor("#FF929292"));
                commodity_detail_banner_right_rb.setTextColor(Color.parseColor("#FFF29E19"));
                handler.sendEmptyMessage(2);
                break;
            case R.id.blackwb_back:
                finish();
                break;

        }
    }

    //滑动监听
    @Override
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY <= 0) {
            commodity_detail_banner_rg.setBackgroundColor(Color.argb(0, 0, 0, 0));
            commodity_detail_banner_left_rb.setTextColor(Color.argb(0, 0, 0, 0));
            commodity_detail_banner_center_rb.setTextColor(Color.argb(0, 0, 0, 0));
            commodity_detail_banner_right_rb.setTextColor(Color.argb(0, 0, 0, 0));
        } else if (scrollY > 0 && scrollY <= commodity_detail_banner_height) {
            //此判断语句用来控制title的渐变
            //根据commodity_detail_banner_rg高度和移动距离  计算占比
            float scale = (float) scrollY / commodity_detail_banner_height;
            float alpha = (255 * scale);
            commodity_detail_banner_rg.setBackgroundColor(Color.argb((int) alpha, 12, 12, 12));
            commodity_detail_banner_left_rb.setTextColor(Color.argb((int) alpha, 242, 158, 25));
            commodity_detail_banner_center_rb.setTextColor(Color.argb((int) alpha, 146, 146, 146));
            commodity_detail_banner_right_rb.setTextColor(Color.argb((int) alpha, 146, 146, 146));
            System.out.println("在头部");
        } else if (scrollY > commodity_detail_banner_height && scrollY <= shop_height) {
            commodity_detail_banner_rg.setBackgroundColor(Color.argb(255, 12, 12, 12));
            commodity_detail_banner_left_rb.setTextColor(Color.argb(255, 242, 158, 25));
            commodity_detail_banner_center_rb.setTextColor(Color.argb(255, 146, 146, 146));
            commodity_detail_banner_right_rb.setTextColor(Color.argb(255, 146, 146, 146));
            System.out.println("在商品区");
        } else if (scrollY > shop_height && scrollY <= detail_bottom_height) {
            commodity_detail_banner_rg.setBackgroundColor(Color.argb(255, 12, 12, 12));
            commodity_detail_banner_left_rb.setTextColor(Color.argb(255, 146, 146, 146));
            commodity_detail_banner_center_rb.setTextColor(Color.argb(255, 242, 158, 25));
            commodity_detail_banner_right_rb.setTextColor(Color.argb(255, 146, 146, 146));
            System.out.println("详情区了");
        } else {
            commodity_detail_banner_rg.setBackgroundColor(Color.argb(255, 12, 12, 12));
            commodity_detail_banner_left_rb.setTextColor(Color.argb(255, 146, 146, 146));
            commodity_detail_banner_center_rb.setTextColor(Color.argb(255, 146, 146, 146));
            commodity_detail_banner_right_rb.setTextColor(Color.argb(255, 242, 158, 25));
        }
    }
}
