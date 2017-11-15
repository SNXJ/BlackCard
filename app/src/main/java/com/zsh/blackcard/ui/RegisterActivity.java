package com.zsh.blackcard.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.RegisterCardAdapter;
import com.zsh.blackcard.adapter.RegisterCardDiamondAdapter;
import com.zsh.blackcard.adapter.RegisterCardGloryAdapter;
import com.zsh.blackcard.adapter.RegisterCardManualAdapter;
import com.zsh.blackcard.adapter.RegisterCardTranslateAdapter;
import com.zsh.blackcard.adapter.RegisterCardVipAdapter;
import com.zsh.blackcard.adapter.RegisterCardWuXingAdapter;
import com.zsh.blackcard.adapter.RegisterViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * Created by kkkkk on 2017/11/14.
 */

public class RegisterActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RegisterCardAdapter.RegisterOnItemClick {

    @BindView(R.id.pager_container)
    PagerContainer pager_container;
    @BindView(R.id.select_one_img)
    ImageView select_one_img;
    @BindView(R.id.select_two_img)
    ImageView select_two_img;
    @BindView(R.id.select_three_img)
    ImageView select_three_img;
    @BindView(R.id.register_recycler_card)
    RecyclerView register_recycler_card;
    @BindView(R.id.registr_recycler_card_last)
    RecyclerView registr_recycler_card_last;
    @BindView(R.id.register_number_manual_recycler)
    RecyclerView register_number_manual_recycler;
    @BindView(R.id.register_number_vip_recycler)
    RecyclerView register_number_vip_recycler;
    @BindView(R.id.register_number_diamond_recycler)
    RecyclerView register_number_diamond_recycler;
    @BindView(R.id.register_number_glory_recycler)
    RecyclerView register_number_glory_recycler;
    @BindView(R.id.register_address_linear)
    LinearLayout register_address_linear;
    @BindView(R.id.register_number_linear)
    LinearLayout register_number_linear;
    @BindView(R.id.register_number_left_rb)
    RadioButton register_number_left_rb;
    @BindView(R.id.register_number_right_rb)
    RadioButton register_number_right_rb;
    @BindView(R.id.register_super_one_rb)
    RadioButton register_super_one_rb;
    @BindView(R.id.register_number_tip_tv)
    TextView register_number_tip_tv;
    @BindView(R.id.register_number_manual_relative)
    RelativeLayout register_number_manual_relative;
    @BindView(R.id.register_scrollView)
    ScrollView register_scrollView;

    private RegisterViewPagerAdapter registerViewPagerAdapter;
    private ViewPager viewPager;
    private int[] images = new int[]{R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1};
    private RegisterCardAdapter registerCardAdapter;
    //星座卡适配器
    private RegisterCardTranslateAdapter registerCardTranslateAdapter;
    //周易五行卡适配器
    private RegisterCardWuXingAdapter registerCardWuXingAdapter;
    //自选号码适配器
    private RegisterCardManualAdapter registerCardManualAdapter;
    //贵宾号码适配器
    private RegisterCardVipAdapter registerCardVipAdapter;
    //金钻号码适配器
    private RegisterCardDiamondAdapter registerCardDiamondAdapter;
    //荣耀号码适配器
    private RegisterCardGloryAdapter registerCardGloryAdapter;

    //设置ViewPager下标变量
    private int currentPosition;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initDate();
    }

    @OnCheckedChanged({R.id.register_number_left_rb, R.id.register_number_right_rb})
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.register_number_left_rb:
                if (isChecked) {
                    register_number_tip_tv.setVisibility(View.VISIBLE);
                    register_number_manual_relative.setVisibility(View.GONE);
                }
                break;
            case R.id.register_number_right_rb:
                if (isChecked) {
                    register_number_tip_tv.setVisibility(View.GONE);
                    register_number_manual_relative.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @OnClick({R.id.blackwb_back, R.id.register_address_relative, R.id.register_number_relative})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                finish();
                break;
            case R.id.register_address_relative:
                if (register_address_linear.getVisibility() == View.VISIBLE) {
                    register_address_linear.setVisibility(View.GONE);
                } else {
                    register_address_linear.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.register_number_relative:
                if (register_number_linear.getVisibility() == View.VISIBLE) {
                    register_number_linear.setVisibility(View.GONE);
                } else {
                    register_number_linear.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    private void initDate() {
        //设置随机号码提示为默认显示
        register_number_tip_tv.setVisibility(View.VISIBLE);
        //设置RadioButton默认为随机选择号码
        register_number_left_rb.setChecked(true);
        //以下代码块是完成头部卡片轮播
        viewPager = pager_container.getViewPager();
        registerViewPagerAdapter = new RegisterViewPagerAdapter(this, images);
        viewPager.setAdapter(registerViewPagerAdapter);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(5);

        new CoverFlow.Builder()
                .with(viewPager)
                .scale(0.3f)
                .pagerMargin(-40f)
                .spaceSize(0f)
                .rotationY(0f)
                .build();

        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(2, false);

        //以下代码实现办卡选择。
        registerCardAdapter = new RegisterCardAdapter(this);
        register_recycler_card.setLayoutManager(new GridLayoutManager(this, 3));
        register_recycler_card.setAdapter(registerCardAdapter);
        register_recycler_card.setNestedScrollingEnabled(false);
        registerCardAdapter.setRegisterOnItemClick(this);

        //以下为自选号码列表
        registerCardManualAdapter = new RegisterCardManualAdapter(this);
        register_number_manual_recycler.setLayoutManager(new GridLayoutManager(this,2));
        register_number_manual_recycler.setAdapter(registerCardManualAdapter);
        register_number_manual_recycler.setNestedScrollingEnabled(false);

        //贵宾号码列表
        registerCardVipAdapter = new RegisterCardVipAdapter(this);
        register_number_vip_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        register_number_vip_recycler.setAdapter(registerCardVipAdapter);
        register_number_vip_recycler.setNestedScrollingEnabled(false);

        //金钻号码适配器
        registerCardDiamondAdapter = new RegisterCardDiamondAdapter(this);
        register_number_diamond_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        register_number_diamond_recycler.setAdapter(registerCardDiamondAdapter);
        register_number_diamond_recycler.setNestedScrollingEnabled(false);

        //荣耀号码适配器
        registerCardGloryAdapter = new RegisterCardGloryAdapter(this);
        register_number_glory_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        register_number_glory_recycler.setAdapter(registerCardGloryAdapter);
        register_number_glory_recycler.setNestedScrollingEnabled(false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
        clear();
        switch (position) {
            case 1:
                select_three_img.setBackgroundResource(R.color.bg_white);
                break;
            case 2:
                select_one_img.setBackgroundResource(R.color.bg_white);
                break;
            case 3:
                select_two_img.setBackgroundResource(R.color.bg_white);
                break;
            case 4:
                select_three_img.setBackgroundResource(R.color.bg_white);
                break;
            case 5:
                select_one_img.setBackgroundResource(R.color.bg_white);
                break;
        }
    }

    private void clear() {
        select_one_img.setBackgroundResource(R.color.et_hint);
        select_two_img.setBackgroundResource(R.color.et_hint);
        select_three_img.setBackgroundResource(R.color.et_hint);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state != ViewPager.SCROLL_STATE_IDLE) {
            return;
        }
        //根据动画是否停止，优化滑动视觉效果。
        if (currentPosition < 2) {
            currentPosition = 4;
            viewPager.setCurrentItem(currentPosition, false);
        } else if (currentPosition > 4) {
            viewPager.setCurrentItem(2, false);
        }
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                registr_recycler_card_last.setVisibility(View.GONE);
                break;
            case 1:
                registr_recycler_card_last.setVisibility(View.GONE);
                break;
            case 2:
                registr_recycler_card_last.setVisibility(View.GONE);
                break;
            case 3:
                registr_recycler_card_last.setVisibility(View.GONE);
                break;
            case 4:
                //选择五行卡、12星座卡
                if (registerCardTranslateAdapter == null) {
                    registerCardTranslateAdapter = new RegisterCardTranslateAdapter(this);
                    registr_recycler_card_last.setLayoutManager(new GridLayoutManager(this, 3));
                }
                registr_recycler_card_last.setAdapter(registerCardTranslateAdapter);
                registr_recycler_card_last.setVisibility(View.VISIBLE);
                break;
            case 5:
                //周易五行卡
                if (registerCardWuXingAdapter == null) {
                    registerCardWuXingAdapter = new RegisterCardWuXingAdapter(this);
                    registr_recycler_card_last.setLayoutManager(new GridLayoutManager(this, 3));
                }
                registr_recycler_card_last.setAdapter(registerCardWuXingAdapter);
                registr_recycler_card_last.setVisibility(View.VISIBLE);
                break;
        }
        registr_recycler_card_last.setNestedScrollingEnabled(false);
    }
}
