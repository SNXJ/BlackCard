package com.zsh.blackcard.custom;

import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.LiveGiftAdapter;
import com.zsh.blackcard.adapter.MyPageAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ItemClickListener;
import com.zsh.blackcard.listener.MoreDateListener;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.GiftTempModel;
import com.zsh.blackcard.model.LiveRoomDialogModel;
import com.zsh.blackcard.utils.DisplayUtil;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Name: LiveGiftsDialog
 * Author: Shing
 * Date: 2018/1/31 下午4:16
 * Description: 礼物dialog
 */

public class LiveGiftsDialog extends DialogFragment implements View.OnClickListener {

    public static String anchor_id;
    private GiftTempModel selectGift;

    public static LiveGiftsDialog newInstance(String id) {
        anchor_id = id;
        LiveGiftsDialog liveGiftsDialog = new LiveGiftsDialog();
        return liveGiftsDialog;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.dailog_anim_enterorout_window_up;
        getDialog().setCanceledOnTouchOutside(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_FRAME, R.style.pub_loading_dialog);
    }

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        view = inflater.inflate(R.layout.live_gifts_dialog_layout, container);

        initView(view);
        intNormalData();
        return view;
    }

    private String[] gifts_name;
    private String[] gifts_money;
    private int[] gifts_resourceIds;
    List<GiftTempModel> giftsList1;
    List<GiftTempModel> giftsList2;

    private void intNormalData() {
        initData(R.array.gifts_name_normal, R.array.gifts_money_normal, R.array.gifts_image_normal);
        initViewPage();
    }

    private void intLightData() {
        initData(R.array.gifts_name_light, R.array.gifts_money_light, R.array.gifts_image_light);
        initViewPage();
    }

    private void intLuxuryData() {
        initData(R.array.gifts_name_luxury, R.array.gifts_money_luxury, R.array.gifts_image_luxury);
        initViewPage();
    }


    private void initData(int name, int money, int img) {
        gifts_name = getResources().getStringArray(name);
        gifts_money = getResources().getStringArray(money);
        TypedArray typedArray = getResources().obtainTypedArray(img);
        gifts_resourceIds = new int[typedArray.length()];

        for (int i = 0; i < typedArray.length(); i++) {
            gifts_resourceIds[i] = typedArray.getResourceId(i, 0);
        }

        giftsList1 = new ArrayList<>();
        giftsList2 = new ArrayList<>();
        for (int i = 0; i < gifts_resourceIds.length; i++) {
            GiftTempModel gift = new GiftTempModel();
            gift.setName(gifts_name[i]);
            gift.setMoney(gifts_money[i]);
            gift.setImage(gifts_resourceIds[i]);
            if (i < 10) {
                giftsList1.add(gift);
            } else {
                giftsList2.add(gift);
            }
        }

    }


    List<View> recycleViews;


    private void initViewPage() {

        viewPager.removeAllViews();

        recycleViews = new ArrayList<>();
        recycleViews.add(setRV(giftsList1));

        if (null != giftsList2 & giftsList2.size() > 0) {
            recycleViews.add(setRV(giftsList2));
        }
        initdot();
        viewPager.setAdapter(new MyPageAdapter(recycleViews));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rgGiftsDot.check(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private RecyclerView setRV(List<GiftTempModel> giftsList) {
        LayoutInflater inflater = getActivity().getLayoutInflater();

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.live_gifts_dialog_recycle, null);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        final LiveGiftAdapter liveGiftAdapter = new LiveGiftAdapter(giftsList);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(liveGiftAdapter);
        selectGift = giftsList.get(0);
        liveGiftAdapter.setSelect(0);
        liveGiftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                selectGift = (GiftTempModel) adapter.getData().get(position);
                LogUtils.i("++++++++++++++++", "+++++++recycle++++++++" + position);
                liveGiftAdapter.setSelect(position);

            }
        });

        return recyclerView;

    }


    private void initdot() {
        if (null != rgGiftsDot) {
            rgGiftsDot.removeAllViews();
        }
        for (int i = 0; i < recycleViews.size(); i++) {
            RadioButton rb = new RadioButton(getActivity());
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = DisplayUtil.dip2px(getActivity(), 0);
            rb.setWidth(DisplayUtil.dip2px(getActivity(), 5));
            rb.setHeight(DisplayUtil.dip2px(getActivity(), 5));
            rb.setButtonDrawable(null);
            rb.setBackgroundResource(R.drawable.welcoome_rb_selector);
            rb.setChecked(i == 0 ? true : false);
            rb.setId(i);
            rgGiftsDot.addView(rb, params);
        }
    }

    @Override
    public void onResume() {
        getDialog().getWindow().setGravity(Gravity.BOTTOM);
        super.onResume();

        DisplayMetrics dpMetrics = new DisplayMetrics();
        getActivity().getWindow().getWindowManager().getDefaultDisplay().getMetrics(dpMetrics);
        WindowManager.LayoutParams p = getDialog().getWindow().getAttributes();

        p.width = dpMetrics.widthPixels;
        p.height = dpMetrics.heightPixels / 2;
        getDialog().getWindow().setAttributes(p);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }


    private void initView(View view) {
        rbGiftNormal = view.findViewById(R.id.rb_gift_normal);
        rbGiftLuxury = view.findViewById(R.id.rb_gift_luxury);
        rbGiftLight = view.findViewById(R.id.rb_gift_light);
        viewPager = view.findViewById(R.id.gifts_container);//gifts_container


        vtGiftsRecharge = view.findViewById(R.id.vt_gifts_recharge);
        rgGiftsDot = view.findViewById(R.id.rg_gifts_dot);
        tvGiftsNum = view.findViewById(R.id.tv_gifts_num);
        rlGiftsNum = view.findViewById(R.id.rl_gifts_num);
        tvGiftsSend = view.findViewById(R.id.tv_gifts_send);

        rbGiftNormal.setOnClickListener(this);
        rbGiftLuxury.setOnClickListener(this);
        rbGiftLight.setOnClickListener(this);
        vtGiftsRecharge.setOnClickListener(this);
        rlGiftsNum.setOnClickListener(this);
        tvGiftsSend.setOnClickListener(this);


    }


    private RadioButton rbGiftNormal;

    private RadioButton rbGiftLuxury;
    private RadioButton rbGiftLight;

//    private FrameLayout gifts_container;

    private ViewPager viewPager;

    private TextView vtGiftsRecharge;

    private RadioGroup rgGiftsDot;

    private TextView tvGiftsNum;

    private RelativeLayout rlGiftsNum;

    private TextView tvGiftsSend;


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_gift_normal:
                intNormalData();

                break;
            case R.id.rb_gift_luxury://豪华
                intLuxuryData();
                break;
            case R.id.rb_gift_light://轻奢
                intLightData();
                break;
            case R.id.vt_gifts_recharge:

                UIUtils.showToast("充值");
                break;
            case R.id.rl_gifts_num:

                PopGiftSelect pop = new PopGiftSelect(getActivity(), listener);
                pop.showUp2(rlGiftsNum);
                break;
            case R.id.tv_gifts_send:
                UIUtils.showToast("send");
                break;
            case R.id.tv_send:

                break;
        }
    }

    private MoreDateListener dataListenter;

    public void setNumEditListenter(MoreDateListener mDataListenter) {

        dataListenter = mDataListenter;

    }

    ItemClickListener listener = new ItemClickListener() {
        @Override
        public void itemClick(int num) {

            tvGiftsNum.setText(num + "");


            switch (num) {
                case 1314:
                    break;
                case 520:
                    break;
                case 188:
                    break;
                case 66:
                    break;
                case 30:
                    break;
                case 10:
                    break;
                case 01:
                    break;
                case 00:
                    if (null != dataListenter) {
                        dataListenter.dateListener(tvGiftsNum);
                    }

                    break;

            }


            int price = Integer.valueOf(selectGift.getMoney());
            sendGift(num * price);
        }
    };


    private void sendGift(int money) {

        DataManager.getInstance(getActivity()).RequestHttp(NetApi.sendLiveGift(DataManager.getMd5Str("GIFT"), BaseApplication.getHonouruserId(), anchor_id, money + ""), new ResultListener<LiveRoomDialogModel>() {
            @Override
            public void responseSuccess(LiveRoomDialogModel obj) {
                if ("01".equals(obj.getResult())) {
                    UIUtils.showToast("成功");

                } else if ("07".equals(obj.getResult())) {
                    UIUtils.showToast("余额不足");
                }

            }

            @Override
            public void onCompleted() {

            }
        });

    }

}
