package com.zsh.blackcard.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.WelcomeModel;
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

    //引导页图片集合
    private List<String> listImage = new ArrayList<>();

    @BindView(R.id.welcome_register_btn)
    Button welcome_now_btn;
    @BindView(R.id.welcome_login_btn)
    Button welcome_login_btn;
    @BindView(R.id.welcome_banner)
    Banner welcome_banner;
    @BindView(R.id.img_one)
    ImageView img_one;
    @BindView(R.id.img_two)
    ImageView img_two;
    @BindView(R.id.img_three)
    ImageView img_three;
    @BindView(R.id.img_four)
    ImageView img_four;

    @OnClick({R.id.welcome_register_btn, R.id.welcome_login_btn})
    public void btnOnClick(View view) {
        switch (view.getId()) {
            //在线申请
            case R.id.welcome_register_btn:
                ActivityUtils.startActivity(this, RegisterActivity.class);

                break;
            //会籍登录
            case R.id.welcome_login_btn:
                ActivityUtils.startActivity(this, LoginActivity.class);
                finish();
                break;
        }
    }


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //获取欢迎引导页轮播图片
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postWelcome(DataManager.getMd5Str("BOOTPAGELIST")), new ResultListener<WelcomeModel>() {
            @Override
            public void responseSuccess(WelcomeModel obj) {
                //循环遍历图片添加进集合
                for (int i = 0; i < obj.getPd().size(); i++) {
                    listImage.add(obj.getPd().get(i).getSHOWIMG());
                }
                welcome_banner.setImageLoader(new MyImageLoader());
                welcome_banner.setImages(listImage);
                welcome_banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
                //使用自定义动画
                welcome_banner.setPageTransformer(false, new ZoomOutPageTransformer());
                welcome_banner.start();
                welcome_banner.setOnPageChangeListener(WelcomeActivity.this);
            }

            @Override
            public void onCompleted() {

            }
        });


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
            Glide.with(context).load(path).into(imageView);
        }
    }
}
