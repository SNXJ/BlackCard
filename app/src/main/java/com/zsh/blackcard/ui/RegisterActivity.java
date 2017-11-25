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
import com.zsh.blackcard.adapter.RegisterCardConstellationAdapter;
import com.zsh.blackcard.adapter.RegisterCardDiamondAdapter;
import com.zsh.blackcard.adapter.RegisterCardGloryAdapter;
import com.zsh.blackcard.adapter.RegisterCardManualAdapter;
import com.zsh.blackcard.adapter.RegisterCardSuperFiveAdapter;
import com.zsh.blackcard.adapter.RegisterCardSuperFourAdapter;
import com.zsh.blackcard.adapter.RegisterCardSuperOneAdapter;
import com.zsh.blackcard.adapter.RegisterCardSuperThreeAdapter;
import com.zsh.blackcard.adapter.RegisterCardSuperTwoAdapter;
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

public class RegisterActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RegisterCardAdapter.RegisterCardOnItemClick, RegisterCardConstellationAdapter.RegisterConstellationOnItemClick, RegisterCardWuXingAdapter.RegisterWuXingOnItemClick, RegisterCardManualAdapter.RegisterManualOnItemClick, RegisterCardVipAdapter.RegisterVipOnItemClick, RegisterCardDiamondAdapter.RegisterDiamondOnItemClick, RegisterCardGloryAdapter.RegisterGloryOnItemClick, RegisterCardSuperOneAdapter.RegisterSuperOneOnItemClick, RegisterCardSuperTwoAdapter.RegisterSuperTwoOnItemClick, RegisterCardSuperThreeAdapter.RegisterSuperThreeOnItemClick, RegisterCardSuperFourAdapter.RegisterSuperFourOnItemClick, RegisterCardSuperFiveAdapter.RegisterSuperFiveOnItemClick {

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
    @BindView(R.id.register_super_recycler)
    RecyclerView register_super_recycler;
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
    @BindView(R.id.register_customer_left_rb)
    RadioButton register_customer_left_rb;
    @BindView(R.id.register_pay_left_rb)
    RadioButton register_pay_left_rb;
    @BindView(R.id.register_number_tip_tv)
    TextView register_number_tip_tv;
    @BindView(R.id.register_number_manual_relative)
    RelativeLayout register_number_manual_relative;
    @BindView(R.id.register_customer_left_linear)
    LinearLayout register_customer_left_linear;
    @BindView(R.id.register_customer_center_linear)
    LinearLayout register_customer_center_linear;
    @BindView(R.id.register_customer_linear)
    LinearLayout register_customer_linear;
    @BindView(R.id.register_pay_linear)
    LinearLayout register_pay_linear;
    @BindView(R.id.register_customer_right_tv)
    TextView register_customer_right_tv;
    @BindView(R.id.register_scrollView)
    ScrollView register_scrollView;

    private RegisterViewPagerAdapter registerViewPagerAdapter;
    private ViewPager viewPager;
    private int[] images = new int[]{R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1, R.mipmap.signup_image_1};
    private RegisterCardAdapter registerCardAdapter;
    //星座卡适配器
    private RegisterCardConstellationAdapter registerCardConstellationAdapter;
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
    //超级黑卡靓号300元适配器
    private RegisterCardSuperOneAdapter registerCardSuperOneAdapter;
    //超级黑卡靓号600元适配器
    private RegisterCardSuperTwoAdapter registerCardSuperTwoAdapter;
    //超级黑卡靓号1000元适配器
    private RegisterCardSuperThreeAdapter registerCardSuperThreeAdapter;
    //超级黑卡靓号5000元适配器
    private RegisterCardSuperFourAdapter registerCardSuperFourAdapter;
    //超级黑卡靓号10000元适配器
    private RegisterCardSuperFiveAdapter registerCardSuperFiveAdapter;

    //设置ViewPager下标变量
    private int currentPosition;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initDate();
    }


    private void initDate() {
        //设置默认为微信支付选项
        register_pay_left_rb.setChecked(true);
        //设置定制200元为默认选项
        register_customer_left_rb.setChecked(true);
        //设置300元超级黑卡靓号为默认选项
        register_super_one_rb.setChecked(true);
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
                .pagerMargin(-60f)
                .spaceSize(0f)
                .rotationY(0f)
                .build();

        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(2, false);

        //以下代码实现办卡选择。例如：选择星座卡，五行卡，至尊卡等。
        registerCardAdapter = new RegisterCardAdapter(this);
        register_recycler_card.setLayoutManager(new GridLayoutManager(this, 3));
        register_recycler_card.setAdapter(registerCardAdapter);
        registerCardAdapter.setRegisterCardOnItemClick(this);

        //自选号码列表
        registerCardManualAdapter = new RegisterCardManualAdapter(this);
        register_number_manual_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        register_number_manual_recycler.setAdapter(registerCardManualAdapter);
        registerCardManualAdapter.setRegisterManualOnItemClick(this);

        //贵宾号码列表
        registerCardVipAdapter = new RegisterCardVipAdapter(this);
        register_number_vip_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        register_number_vip_recycler.setAdapter(registerCardVipAdapter);
        registerCardVipAdapter.setRegisterVipOnItemClick(this);

        //金钻号码列表
        registerCardDiamondAdapter = new RegisterCardDiamondAdapter(this);
        register_number_diamond_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        register_number_diamond_recycler.setAdapter(registerCardDiamondAdapter);
        registerCardDiamondAdapter.setRegisterDiamondOnItemClick(this);

        //荣耀号码适配器
        registerCardGloryAdapter = new RegisterCardGloryAdapter(this);
        register_number_glory_recycler.setLayoutManager(new GridLayoutManager(this, 2));
        register_number_glory_recycler.setAdapter(registerCardGloryAdapter);
        registerCardGloryAdapter.setRegisterGloryOnItemClick(this);

        //设置RecyclerView在ScrollView列表中不可滑动
        register_recycler_card.setNestedScrollingEnabled(false);
        register_number_manual_recycler.setNestedScrollingEnabled(false);
        register_number_vip_recycler.setNestedScrollingEnabled(false);
        registr_recycler_card_last.setNestedScrollingEnabled(false);
        register_number_glory_recycler.setNestedScrollingEnabled(false);
        register_number_diamond_recycler.setNestedScrollingEnabled(false);
    }

    //定制号码选择控制
    @OnCheckedChanged({R.id.register_customer_left_rb, R.id.register_customer_center_rb, R.id.register_customer_right_rb})
    public void onCheckCustomer(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.register_customer_left_rb:
                if (isChecked) {
                    register_customer_left_linear.setVisibility(View.VISIBLE);
                    register_customer_center_linear.setVisibility(View.GONE);
                    register_customer_right_tv.setVisibility(View.GONE);
                }
                break;
            case R.id.register_customer_center_rb:
                if (isChecked) {
                    register_customer_left_linear.setVisibility(View.GONE);
                    register_customer_center_linear.setVisibility(View.VISIBLE);
                    register_customer_right_tv.setVisibility(View.GONE);
                }
                break;
            case R.id.register_customer_right_rb:
                if (isChecked) {
                    register_customer_left_linear.setVisibility(View.GONE);
                    register_customer_center_linear.setVisibility(View.GONE);
                    register_customer_right_tv.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    //随机和手选号码控制
    @OnCheckedChanged({R.id.register_number_left_rb, R.id.register_number_right_rb})
    public void onCheckNumber(CompoundButton buttonView, boolean isChecked) {
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

    //超级黑卡靓号选择控制
    @OnCheckedChanged({R.id.register_super_one_rb, R.id.register_super_two_rb, R.id.register_super_three_rb, R.id.register_super_four_rb, R.id.register_super_five_rb})
    public void onSuprCheckNumber(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.register_super_one_rb:
                if (isChecked) {
                    if (registerCardSuperOneAdapter == null) {
                        registerCardSuperOneAdapter = new RegisterCardSuperOneAdapter(this);
                        register_super_recycler.setLayoutManager(new GridLayoutManager(this, 2));
                        registerCardSuperOneAdapter.setRegisterSuperOneOnItemClick(this);
                    }
                    register_super_recycler.setAdapter(registerCardSuperOneAdapter);
                }
                break;
            case R.id.register_super_two_rb:
                if (isChecked) {
                    if (registerCardSuperTwoAdapter == null) {
                        registerCardSuperTwoAdapter = new RegisterCardSuperTwoAdapter(this);
                        register_super_recycler.setLayoutManager(new GridLayoutManager(this, 2));
                        registerCardSuperTwoAdapter.setRegisterSuperTwoOnItemClick(this);
                    }
                    register_super_recycler.setAdapter(registerCardSuperTwoAdapter);
                }
                break;
            case R.id.register_super_three_rb:
                if (isChecked) {
                    if (registerCardSuperThreeAdapter == null) {
                        registerCardSuperThreeAdapter = new RegisterCardSuperThreeAdapter(this);
                        register_super_recycler.setLayoutManager(new GridLayoutManager(this, 2));
                        registerCardSuperThreeAdapter.setRegisterSuperThreeOnItemClick(this);
                    }
                    register_super_recycler.setAdapter(registerCardSuperThreeAdapter);
                }
                break;
            case R.id.register_super_four_rb:
                if (isChecked) {
                    if (registerCardSuperFourAdapter == null) {
                        registerCardSuperFourAdapter = new RegisterCardSuperFourAdapter(this);
                        register_super_recycler.setLayoutManager(new GridLayoutManager(this, 2));
                        registerCardSuperFourAdapter.setRegisterSuperFourOnItemClick(this);
                    }
                    register_super_recycler.setAdapter(registerCardSuperFourAdapter);
                }
                break;
            case R.id.register_super_five_rb:
                if (isChecked) {
                    if (registerCardSuperFiveAdapter == null) {
                        registerCardSuperFiveAdapter = new RegisterCardSuperFiveAdapter(this);
                        register_super_recycler.setLayoutManager(new GridLayoutManager(this, 2));
                        registerCardSuperFiveAdapter.setRegisterSuperFiveOnItemClick(this);
                    }
                    register_super_recycler.setAdapter(registerCardSuperFiveAdapter);
                }
                break;
        }
    }

    //控制收货地址，号码选择框的关闭和开启
    @OnClick({R.id.blackwb_back, R.id.register_address_relative, R.id.register_number_relative, R.id.register_customer_relative, R.id.register_pay_relative,R.id.register_submit_btn})
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
            case R.id.register_customer_relative:
                if (register_customer_linear.getVisibility() == View.VISIBLE) {
                    register_customer_linear.setVisibility(View.GONE);
                } else {
                    register_customer_linear.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.register_pay_relative:
                if (register_pay_linear.getVisibility() == View.VISIBLE) {
                    register_pay_linear.setVisibility(View.GONE);
                } else {
                    register_pay_linear.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.register_submit_btn:

                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //轮播下方的三个白点
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

    //卡片种类选择点击事件
    @Override
    public void cardOnItemClick(int position) {
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
                //12星座卡
                if (registerCardConstellationAdapter == null) {
                    registerCardConstellationAdapter = new RegisterCardConstellationAdapter(this);
                    registr_recycler_card_last.setLayoutManager(new GridLayoutManager(this, 3));
                    registerCardConstellationAdapter.setRegisterConstellationOnItemClick(this);
                }

                registr_recycler_card_last.setAdapter(registerCardConstellationAdapter);
                registr_recycler_card_last.setVisibility(View.VISIBLE);
                break;
            case 5:
                //周易五行卡
                if (registerCardWuXingAdapter == null) {
                    registerCardWuXingAdapter = new RegisterCardWuXingAdapter(this);
                    registr_recycler_card_last.setLayoutManager(new GridLayoutManager(this, 3));
                    registerCardWuXingAdapter.setRegisterWuXingOnItemClick(this);
                }
                registr_recycler_card_last.setAdapter(registerCardWuXingAdapter);
                //确保办卡类型的唯一性，清空其他列表的选项。例如：第一次选择了五行卡中的金卡，那么下次点击星座卡的白羊卡时，清掉之前选择的金卡。
                registr_recycler_card_last.setVisibility(View.VISIBLE);
                break;
        }
    }

    //星座卡点击事件
    @Override
    public void constellationOnItemClick(int position) {
        //确保办卡类型的唯一性，清空其他列表的选项。例如：第一次选择了五行卡中的金卡，那么下次点击星座卡的白羊卡时，清掉之前选择的金卡。
        if (registerCardWuXingAdapter != null) {
            registerCardWuXingAdapter.initSelect();
            registerCardWuXingAdapter.notifyDataSetChanged();
        }
    }

    //五行卡点击事件
    @Override
    public void wuXingOnItemClick(int position) {
        if (registerCardConstellationAdapter != null) {
            registerCardConstellationAdapter.initSelect();
            registerCardConstellationAdapter.notifyDataSetChanged();
        }
    }

    //自选号码点击事件
    @Override
    public void manualOnItemClick(int position) {
        //设置贵宾选择事件为未选中
        registerCardVipAdapter.initSelect();
        registerCardVipAdapter.notifyDataSetChanged();
        //设置金钻选择事件为未选中
        registerCardDiamondAdapter.initSelect();
        registerCardDiamondAdapter.notifyDataSetChanged();
        //设置荣耀选择事件为未选中
        registerCardGloryAdapter.initSelect();
        registerCardGloryAdapter.notifyDataSetChanged();
        //设置超级黑卡所有项为未选中
        superRecyclerViewSelect();
    }

    //贵宾号码点击事件
    @Override
    public void vipOnItemClick(int position) {
        //设置贵宾选择事件为未选中
        registerCardManualAdapter.initSelect();
        registerCardManualAdapter.notifyDataSetChanged();
        //设置金钻选择事件为未选中
        registerCardDiamondAdapter.initSelect();
        registerCardDiamondAdapter.notifyDataSetChanged();
        //设置荣耀选择事件为未选中
        registerCardGloryAdapter.initSelect();
        registerCardGloryAdapter.notifyDataSetChanged();
        //设置超级黑卡所有项为未选中
        superRecyclerViewSelect();
    }

    //金钻号码点击事件
    @Override
    public void diamondOnItemClick(int position) {
        //设置贵宾选择事件为未选中
        registerCardManualAdapter.initSelect();
        registerCardManualAdapter.notifyDataSetChanged();
        //设置金钻选择事件为未选中
        registerCardVipAdapter.initSelect();
        registerCardVipAdapter.notifyDataSetChanged();
        //设置荣耀选择事件为未选中
        registerCardGloryAdapter.initSelect();
        registerCardGloryAdapter.notifyDataSetChanged();
        //设置超级黑卡所有项为未选中
        superRecyclerViewSelect();
    }

    //荣耀号码点击事件
    @Override
    public void gloryOnItemClick(int position) {
        //设置贵宾选择事件为未选中
        registerCardManualAdapter.initSelect();
        registerCardManualAdapter.notifyDataSetChanged();
        //设置金钻选择事件为未选中
        registerCardVipAdapter.initSelect();
        registerCardVipAdapter.notifyDataSetChanged();
        //设置荣耀选择事件为未选中
        registerCardDiamondAdapter.initSelect();
        registerCardDiamondAdapter.notifyDataSetChanged();
        //设置超级黑卡所有项为未选中
        superRecyclerViewSelect();
    }

    //超级黑卡300元点击事件
    @Override
    public void superOneOnItemClick(int position) {
        //设置除超级黑卡所有项为未选中
        superExceptRecyclerView();
        if (registerCardSuperTwoAdapter != null) {
            registerCardSuperTwoAdapter.initSelect();
            registerCardSuperTwoAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperThreeAdapter != null) {
            registerCardSuperThreeAdapter.initSelect();
            registerCardSuperThreeAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFourAdapter != null) {
            registerCardSuperFourAdapter.initSelect();
            registerCardSuperFourAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFiveAdapter != null) {
            registerCardSuperFiveAdapter.initSelect();
            registerCardSuperFiveAdapter.notifyDataSetChanged();
        }
    }

    //超级黑卡600元点击事件
    @Override
    public void superTwoOnItemClick(int position) {
        //设置除超级黑卡所有项为未选中
        superExceptRecyclerView();
        registerCardSuperOneAdapter.initSelect();
        registerCardSuperOneAdapter.notifyDataSetChanged();
        if (registerCardSuperThreeAdapter != null) {
            registerCardSuperThreeAdapter.initSelect();
            registerCardSuperThreeAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFourAdapter != null) {
            registerCardSuperFourAdapter.initSelect();
            registerCardSuperFourAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFiveAdapter != null) {
            registerCardSuperFiveAdapter.initSelect();
            registerCardSuperFiveAdapter.notifyDataSetChanged();
        }
    }

    //超级黑卡1000元点击事件
    @Override
    public void superThreeOnItemClick(int position) {
        //设置除超级黑卡所有项为未选中
        superExceptRecyclerView();
        registerCardSuperOneAdapter.initSelect();
        registerCardSuperOneAdapter.notifyDataSetChanged();
        if (registerCardSuperTwoAdapter != null) {
            registerCardSuperTwoAdapter.initSelect();
            registerCardSuperTwoAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFourAdapter != null) {
            registerCardSuperFourAdapter.initSelect();
            registerCardSuperFourAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFiveAdapter != null) {
            registerCardSuperFiveAdapter.initSelect();
            registerCardSuperFiveAdapter.notifyDataSetChanged();
        }
    }

    //超级黑卡5000元点击事件
    @Override
    public void superFourOnItemClick(int position) {
        //设置除超级黑卡所有项为未选中
        superExceptRecyclerView();
        registerCardSuperOneAdapter.initSelect();
        registerCardSuperOneAdapter.notifyDataSetChanged();
        if (registerCardSuperTwoAdapter != null) {
            registerCardSuperTwoAdapter.initSelect();
            registerCardSuperTwoAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperThreeAdapter != null) {
            registerCardSuperThreeAdapter.initSelect();
            registerCardSuperThreeAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFiveAdapter != null) {
            registerCardSuperFiveAdapter.initSelect();
            registerCardSuperFiveAdapter.notifyDataSetChanged();
        }
    }

    //超级黑卡10000元点击事件
    @Override
    public void superFiveOnItemClick(int position) {
        //设置除超级黑卡所有项为未选中
        superExceptRecyclerView();
        registerCardSuperOneAdapter.initSelect();
        registerCardSuperOneAdapter.notifyDataSetChanged();
        if (registerCardSuperTwoAdapter != null) {
            registerCardSuperTwoAdapter.initSelect();
            registerCardSuperTwoAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperThreeAdapter != null) {
            registerCardSuperThreeAdapter.initSelect();
            registerCardSuperThreeAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFourAdapter != null) {
            registerCardSuperFourAdapter.initSelect();
            registerCardSuperFourAdapter.notifyDataSetChanged();
        }
    }

    //设置超级黑卡所有项为未选中
    public void superRecyclerViewSelect() {
        //设置超级黑卡所有项为未选中
        registerCardSuperOneAdapter.initSelect();
        registerCardSuperOneAdapter.notifyDataSetChanged();
        if (registerCardSuperTwoAdapter != null) {
            registerCardSuperTwoAdapter.initSelect();
            registerCardSuperTwoAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperThreeAdapter != null) {
            registerCardSuperThreeAdapter.initSelect();
            registerCardSuperThreeAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFourAdapter != null) {
            registerCardSuperFourAdapter.initSelect();
            registerCardSuperFourAdapter.notifyDataSetChanged();
        }

        if (registerCardSuperFiveAdapter != null) {
            registerCardSuperFiveAdapter.initSelect();
            registerCardSuperFiveAdapter.notifyDataSetChanged();
        }
    }

    //设置除超级黑卡所有项为未选中
    public void superExceptRecyclerView() {
        //设置贵宾选择事件为未选中
        registerCardManualAdapter.initSelect();
        registerCardManualAdapter.notifyDataSetChanged();
        //设置金钻选择事件为未选中
        registerCardVipAdapter.initSelect();
        registerCardVipAdapter.notifyDataSetChanged();
        //设置荣耀选择事件为未选中
        registerCardDiamondAdapter.initSelect();
        registerCardDiamondAdapter.notifyDataSetChanged();
        //设置荣耀选择事件为未选中
        registerCardGloryAdapter.initSelect();
        registerCardGloryAdapter.notifyDataSetChanged();
    }


}
