package com.zsh.blackcard.custom;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.R;
import com.zsh.blackcard.aliLive.fragment.LiveGiftNormalFragment;
import com.zsh.blackcard.utils.LogUtils;
import com.zsh.blackcard.utils.UIUtils;


/**
 * Name: LiveGiftsDialog
 * Author: Shing
 * Date: 2018/1/31 下午4:16
 * Description: ..
 */

public class LiveGiftsDialog extends DialogFragment implements View.OnClickListener {


    public static LiveGiftsDialog newInstance() {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.live_gifts_dialog_layout, container);

//        initView(view);
//        initViewPage();
        return view;
    }


    private Fragment frg_normal, frg_prop, frg_replace;
    private FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private void initViewPage() {
//        fragments.add(new LiveGiftNormalFragment());
//        fragments.add(new LiveGiftNormalFragment());
//
//        PublicFragmentAdapter adapter = new PublicFragmentAdapter(getFragmentManager(), fragments, null);
//        viewPager.setOffscreenPageLimit(2);
//        viewPager.setAdapter(adapter);
        fragmentManager = getFragmentManager();

        frg_normal = new LiveGiftNormalFragment();
        frg_prop = new LiveGiftNormalFragment();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.gifts_container, frg_normal);
        fragmentTransaction.commit();
        frg_replace = frg_normal;


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
        rbGiftProp = view.findViewById(R.id.rb_gift_prop);
//        viewPager = view.findViewById(R.id.viewPager);//gifts_container
        gifts_container = view.findViewById(R.id.gifts_container);
        vtGiftsRecharge = view.findViewById(R.id.vt_gifts_recharge);
        rgGiftsDot = view.findViewById(R.id.rg_gifts_dot);
        tvGiftsNum = view.findViewById(R.id.tv_gifts_num);
        rlGiftsNum = view.findViewById(R.id.rl_gifts_num);
        tvGiftsSend = view.findViewById(R.id.tv_gifts_send);

        rbGiftNormal.setOnClickListener(this);
        rbGiftProp.setOnClickListener(this);
        vtGiftsRecharge.setOnClickListener(this);
        rlGiftsNum.setOnClickListener(this);
        tvGiftsSend.setOnClickListener(this);

    }


    private RadioButton rbGiftNormal;

    private RadioButton rbGiftProp;

    private FrameLayout gifts_container;

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

                replaceFragment(frg_normal);


                break;
            case R.id.rb_gift_prop:
                replaceFragment(frg_prop);
                break;
            case R.id.vt_gifts_recharge:
                LogUtils.i("", "+++++++充值++++++");
                UIUtils.showToast("充值");
                break;
            case R.id.rl_gifts_num:
                break;
            case R.id.tv_gifts_send:
                UIUtils.showToast("send");
                break;
        }
    }

    //封装隐藏和显示布局方法
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction
                fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.hide(frg_replace).show(fragment).commit();
        } else {
            fragmentTransaction.hide(frg_replace).add(R.id.gifts_container, fragment).commit();
        }
        frg_replace = fragment;
    }

}
