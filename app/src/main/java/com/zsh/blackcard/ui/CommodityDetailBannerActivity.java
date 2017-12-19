package com.zsh.blackcard.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MyTestMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/17.
 * 商品详情页面（手表）
 */

public class CommodityDetailBannerActivity extends BaseActivity implements NestedScrollView.OnScrollChangeListener {

    private List<Integer> listImage = new ArrayList<>();

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
    @BindView(R.id.commodity_detail_one_img)
    ImageView commodity_detail_one_img;
    @BindView(R.id.commodity_detail_comment_relative)
    RelativeLayout commodity_detail_comment_relative;
    @BindView(R.id.commodity_detail_three_img)
    ImageView commodity_detail_three_img;

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

    //计算滑动距离
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //获取commodity_detail_banner_rg高度
        rgHeight = commodity_detail_banner_rg.getHeight();
        //获取banner与title的差高度
        commodity_detail_banner_height = commodity_detail_banner.getHeight() - rgHeight;
        //获取整个商品区的底部距离顶端的距离
        shop_height = commodity_detail_table.getBottom() - rgHeight;
        //获取商品详情距离顶部的距离
        detail_bottom_height = commodity_detail_three_img.getBottom() - rgHeight;
        detail_height = commodity_detail_one_img.getTop() - rgHeight;
        //获取商品评论距离顶部的距离
        comment_height = commodity_detail_comment_relative.getTop() - rgHeight;
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_commodity_detail_banner);
        ButterKnife.bind(this);

        //请求数据
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).ppp(DataManager.getMd5Str("SHIPDT"), "388354150699630592"), new ResultListener<String>() {
            @Override
            public void responseSuccess(String obj) {

            }

            @Override
            public void onCompleted() {

            }
        });

        listImage.add(R.mipmap.shopping_image_1);
        listImage.add(R.mipmap.shopping_image_1);
        listImage.add(R.mipmap.shopping_image_1);

        commodity_detail_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        commodity_detail_banner.setIndicatorGravity(BannerConfig.CENTER);
        commodity_detail_banner.setImageLoader(new MyImageLoader());
        commodity_detail_banner.setImages(listImage);
        commodity_detail_banner.isAutoPlay(false);
        commodity_detail_banner.start();
        commodity_detail_banner_scrollview.setOnScrollChangeListener(this);
    }

    public class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource((Integer) path);
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
