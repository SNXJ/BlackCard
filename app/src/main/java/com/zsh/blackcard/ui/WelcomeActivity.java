package com.zsh.blackcard.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.view.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/14.
 */

public class WelcomeActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private Banner banner;
    //引导页图片集合
    private List<Integer> listImage = new ArrayList<>();
    private ImageView img_one, img_two, img_three, img_four;

    @BindView(R.id.welcome_register_btn)
    Button welcome_now_btn;
    @BindView(R.id.welcome_login_btn)
    Button welcome_login_btn;

    @OnClick({R.id.welcome_register_btn, R.id.welcome_login_btn})
    public void btnOnClick(View view) {
        switch (view.getId()) {
            //在线申请
            case R.id.welcome_register_btn:
                ActivityUtils.startActivity(this,RegisterActivity.class);
                break;
            //会籍登录
            case R.id.welcome_login_btn:
                ActivityUtils.startActivity(this, LoginActivity.class);
                break;
        }
    }


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        initView();
        initOnClick();
        initDate();
    }

    private void initDate() {
        listImage.add(R.mipmap.guide_image_1);
        listImage.add(R.mipmap.guide_image_2);
        listImage.add(R.mipmap.guide_image_3);
        listImage.add(R.mipmap.guide_image_4);
        banner.setImageLoader(new MyImageLoader());
        banner.setImages(listImage);
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //使用自定义动画
        banner.setPageTransformer(false,new ZoomOutPageTransformer());
        banner.start();
    }

    private void initOnClick() {
        banner.setOnPageChangeListener(this);
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.welcome_banner);
        img_one = (ImageView) findViewById(R.id.img_one);
        img_two = (ImageView) findViewById(R.id.img_two);
        img_three = (ImageView) findViewById(R.id.img_three);
        img_four = (ImageView) findViewById(R.id.img_four);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        clear();
        switch (position) {
            case 0:
                img_one.setImageResource(R.mipmap.circle_true);
                break;
            case 1:
                img_two.setImageResource(R.mipmap.circle_true);
                break;
            case 2:
                img_three.setImageResource(R.mipmap.circle_true);
                break;
            case 3:
                img_four.setImageResource(R.mipmap.circle_true);
                break;
        }
    }

    private void clear() {
        img_one.setImageResource(R.mipmap.circle_false);
        img_two.setImageResource(R.mipmap.circle_false);
        img_three.setImageResource(R.mipmap.circle_false);
        img_four.setImageResource(R.mipmap.circle_false);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setImageResource((Integer) path);
        }
    }
}