package com.zsh.blackcard.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/17.
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
    @BindView(R.id.btn_2)
    TextView btn_2;

    int rgHeight;
    int commodity_detail_banner_height;
    int top2;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    commodity_detail_banner_scrollview.smoothScrollTo(0, 0);
                    break;
                case 1:
                    commodity_detail_banner_scrollview.smoothScrollTo(0, top2);
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
        //获取需要滑动到指定view的位置距离
        top2 = btn_2.getTop() - rgHeight;
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_commodity_detail_banner);
        ButterKnife.bind(this);

        listImage.add(R.mipmap.shopping_image_1);
        listImage.add(R.mipmap.shopping_image_1);
        listImage.add(R.mipmap.shopping_image_1);

        commodity_detail_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        commodity_detail_banner.setIndicatorGravity(BannerConfig.CENTER);
        commodity_detail_banner.setImageLoader(new MyImageLoader());
        commodity_detail_banner.setImages(listImage);
        commodity_detail_banner.isAutoPlay(false);
        commodity_detail_banner.start();
        commodity_detail_banner_scrollview.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) this);
    }

    public class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource((Integer) path);
        }
    }

    //商品，详情，评论点击。此处针对RadioButton点击采用OnClick监听。实现多次点击同一按钮依然可以响应事件。
    @OnClick({R.id.commodity_detail_banner_left_rb, R.id.commodity_detail_banner_center_rb, R.id.commodity_detail_banner_right_rb})
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
        } else if (scrollY > 0 && scrollY <= rgHeight) {
            //此判断语句用来控制title的渐变
            //根据commodity_detail_banner_rg高度和移动距离  结算占比
            float scale = (float) scrollY / rgHeight;
            float alpha = (255 * scale);
            commodity_detail_banner_rg.setBackgroundColor(Color.argb((int) alpha, 20, 20, 1));
            commodity_detail_banner_left_rb.setTextColor(Color.argb((int) alpha, 242, 158, 25));
            commodity_detail_banner_center_rb.setTextColor(Color.argb((int) alpha, 146, 146, 146));
            commodity_detail_banner_right_rb.setTextColor(Color.argb((int) alpha, 146, 146, 146));
        } else if (scrollY > rgHeight && scrollY <= commodity_detail_banner_height) {
            //此判断用来控制当滑动区域在头部以下、轮播以上时，给radioButton赋值颜色
            commodity_detail_banner_rg.setBackgroundColor(Color.argb(255, 20, 20, 1));
            commodity_detail_banner_left_rb.setTextColor(Color.argb(255, 242, 158, 25));
            commodity_detail_banner_center_rb.setTextColor(Color.argb(255, 146, 146, 146));
            commodity_detail_banner_right_rb.setTextColor(Color.argb(255, 146, 146, 146));
        } else if (scrollY > commodity_detail_banner_height) {
            //此判断用来控制当滑动区域在评论的开始之处。
            commodity_detail_banner_rg.setBackgroundColor(Color.argb(255, 20, 20, 1));
            commodity_detail_banner_left_rb.setTextColor(Color.argb(255, 146, 146, 146));
            commodity_detail_banner_center_rb.setTextColor(Color.argb(255, 242, 158, 25));
            commodity_detail_banner_right_rb.setTextColor(Color.argb(255, 146, 146, 146));
        }
    }
}
