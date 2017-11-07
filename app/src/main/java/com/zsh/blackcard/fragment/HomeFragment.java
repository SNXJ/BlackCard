package com.zsh.blackcard.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.GlorySeverAdapter;
import com.zsh.blackcard.adapter.HeadNewsAdapter;
import com.zsh.blackcard.adapter.JournalAdapter;
import com.zsh.blackcard.ui.CarActivity;
import com.zsh.blackcard.ui.CruiseShipActivity;
import com.zsh.blackcard.ui.EquestrianActivity;


/**
 * Created by admin on 2017/10/11.
 */

public class HomeFragment extends BaseFragment {
    private GridView headnewsgv;
    private GridView homejournalgv;
    private GridView homeservegv;
    private TextView homecar_tv;
    private TextView homeequestrain_tv;
    private TextView homecruiseship_tv;
    private ImageView homecar_img;
    private ImageView homeequestrain_img;
    private ImageView homecruiseship_img;
    private View view;
    private AnimationDrawable animationDrawable;
    private TextSwitcher tv_notice;
    private String[] mAdvertisements;
    private final int HOME_AD_RESULT = 1;
    private int mSwitcherCount = 0;

    private String[] titles=new String[]{
            "2.4.6.8娱乐吧","逸林游艇","麦乐迪KTV"
    };

    private Integer[] images={
            R.mipmap.home_image_1,
            R.mipmap.home_image_2,
            R.mipmap.home_image_3
    };
    private Integer[] images1={
            R.mipmap.home_image_5,
            R.mipmap.home_image_6,
            R.mipmap.home_image_7
    };
    private Integer[] images2={
            R.mipmap.home_image_9,
            R.mipmap.home_image_10,
            R.mipmap.home_image_11
    };

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                // 广告
                case HOME_AD_RESULT:
                    tv_notice.setText(mAdvertisements[mSwitcherCount % mAdvertisements.length]);
                    mSwitcherCount++;
                    mHandler.sendEmptyMessageDelayed(HOME_AD_RESULT, 3000);
                    break;
            }

        }
    };



    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.homefragment, null);
        homefindID();
        homeOnClick();
        HeadNewsAdapter pictureAdapter=new HeadNewsAdapter(titles, images, getActivity());
        GlorySeverAdapter pictureAdapter1=new GlorySeverAdapter(images1, getActivity());
        JournalAdapter pictureAdapter2=new JournalAdapter(images2,getActivity());
        headnewsgv.setAdapter(pictureAdapter);
        homeservegv.setAdapter(pictureAdapter1);
        homejournalgv.setAdapter(pictureAdapter2);
        return view;
    }

    private void homeOnClick() {
        homecar_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homecarintent = new Intent(getActivity(),CarActivity.class);
                startActivity(homecarintent);
            }
        });
        homeequestrain_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeequestrainintent = new Intent(getActivity(), EquestrianActivity.class);
                startActivity(homeequestrainintent);
            }
        });
        homecruiseship_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homecruiseshipintent = new Intent(getActivity(), CruiseShipActivity.class);
                startActivity(homecruiseshipintent);
            }
        });
        homecar_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homecarintent2 = new Intent(getActivity(),CarActivity.class);
                startActivity(homecarintent2);
            }
        });
        homeequestrain_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeequestrainintent2 = new Intent(getActivity(), EquestrianActivity.class);
                startActivity(homeequestrainintent2);
            }
        });
        homecruiseship_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homecruiseshipintent2 = new Intent(getActivity(), CruiseShipActivity.class);
                startActivity(homecruiseshipintent2);
            }
        });
    }


    private void homefindID() {
        tv_notice = (TextSwitcher) view.findViewById(R.id.tv_notice);
        headnewsgv = (GridView) view.findViewById(R.id.homeheadnews_gv);
        homejournalgv = (GridView) view.findViewById(R.id.homejournal_gv);
        homeservegv = (GridView) view.findViewById(R.id.homeserve_gv);
        homecar_tv = (TextView) view.findViewById(R.id.home_car_tv);
        homeequestrain_tv = (TextView) view.findViewById(R.id.home_equestrain_tv);
        homecruiseship_tv = (TextView) view.findViewById(R.id.home_cruiseship_tv);
        homecar_img = (ImageView) view.findViewById(R.id.home_car_img);
        homecruiseship_img = (ImageView) view.findViewById(R.id.home_equestrain_img);
        homeequestrain_img = (ImageView) view.findViewById(R.id.home_cruiseship_img);

        tv_notice.setFactory(new ViewSwitcher.ViewFactory() {
            // 这里用来创建内部的视图，这里创建TextView，用来显示文字
            public View makeView() {
                TextView tv = new TextView(getActivity().getApplicationContext());
                // 设置文字的显示单位以及文字的大小
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources()
                        .getDimension(R.dimen.font_size));
                tv.setTextColor(getResources().getColor(R.color.sbtext
                ));
                return tv;
            }
        });

        tv_notice.setInAnimation(getActivity().getApplicationContext(),
                R.anim.enter_bottom);
        tv_notice.setOutAnimation(getActivity().getApplicationContext(), R.anim.leave_top);
        mAdvertisements = new String[]{"荣耀黑卡app全新上线,期待您的光临", "荣耀黑卡app全新上线,期待您的光临"};
        mHandler.sendEmptyMessage(HOME_AD_RESULT);
    }

}