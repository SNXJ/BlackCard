package com.zsh.blackcard.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeJournalAdapter;
import com.zsh.blackcard.adapter.HomeNewAdapter;
import com.zsh.blackcard.adapter.HomeSeverAdapter;
import com.zsh.blackcard.listener.ItemClickListener;
import com.zsh.blackcard.listener.RecyclerViewItemOnClick;
import com.zsh.blackcard.ui.CarActivity;
import com.zsh.blackcard.ui.CruiseShipActivity;
import com.zsh.blackcard.ui.EquestrianActivity;
import com.zsh.blackcard.ui.LoginActivity;
import com.zsh.blackcard.ui.MsgCenterActivity;
import com.zsh.blackcard.ui.MsgSysCenterActivity;
import com.zsh.blackcard.ui.PlaneActivity;
import com.zsh.blackcard.ui.TrianActivity;
import com.zsh.blackcard.ui.home.HomeFoodActivity;
import com.zsh.blackcard.ui.home.HomeHotelActivity;
import com.zsh.blackcard.ui.home.HomeKTVActivity;
import com.zsh.blackcard.ui.home.HomeMoreActivity;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.view.selectcity.SelectCityActivity;


/**
 * Created by admin on 2017/10/11.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ImageView go_welcome_login_img;

    private RecyclerView headnewsgv;
    private RecyclerView homejournalgv;
    private RecyclerView homeservegv;

    private TextView ckmiddle_tv;
    private TextView homecar_tv;
    private TextView homeequestrain_tv;//马术
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

    private String[] titles = new String[]{
            "2.4.6.8娱乐吧", "逸林游艇", "麦乐迪KTV", "逸林游艇"
    };

    private Integer[] images = {
            R.mipmap.home_image_1,
            R.mipmap.home_image_2,
            R.mipmap.home_image_3,
            R.mipmap.home_image_2
    };
    private Integer[] images1 = {
            R.mipmap.home_image_5,
            R.mipmap.home_image_6,
            R.mipmap.home_image_7
    };
    private Integer[] images2 = {
            R.mipmap.home_image_9,
            R.mipmap.home_image_10,
            R.mipmap.home_image_11,
            R.mipmap.home_image_12
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
        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        HomeNewAdapter newAdapter = new HomeNewAdapter(titles, images, getActivity());
        headnewsgv.setLayoutManager(layoutManager);
        newAdapter.setOnItemClick(newslistener);
        headnewsgv.setAdapter(newAdapter);

        HomeSeverAdapter serverAdapter = new HomeSeverAdapter(images1, getActivity());

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        homeservegv.setLayoutManager(layoutManager2);
        homeservegv.setAdapter(serverAdapter);

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        HomeJournalAdapter journalAdapter = new HomeJournalAdapter(images2, getActivity());
        homejournalgv.setLayoutManager(layoutManager3);
        homejournalgv.setAdapter(journalAdapter);


    }

    RecyclerViewItemOnClick newslistener = new RecyclerViewItemOnClick() {
        @Override
        public void itemOnClick(int position) {

            startActivity(new Intent(getActivity(), HomeKTVActivity.class));
        }
    };


    private TextView flmiddle_tv;//酒店
    private TextView tv_home_trian;//
    private TextView tv_home_plane;//
    private TextView home_more_tv;//

    private ImageView im_home_food;//
    private ImageView im_home_hotel;//
    private ImageView im__home_trian;//
    private ImageView im_home_more;//
    private ImageView im_home_plane;//
    private RadioButton rb_city_home;//

    private void homefindID() {
        rb_city_home = (RadioButton) view.findViewById(R.id.rb_city_home);

        tv_notice = (TextSwitcher) view.findViewById(R.id.tv_notice);
        headnewsgv = (RecyclerView) view.findViewById(R.id.homeheadnews_gv);
        homejournalgv = (RecyclerView) view.findViewById(R.id.homejournal_gv);
        homeservegv = (RecyclerView) view.findViewById(R.id.homeserve_gv);

        homecar_tv = (TextView) view.findViewById(R.id.home_car_tv);
        flmiddle_tv = (TextView) view.findViewById(R.id.flmiddle_tv);
        tv_home_trian = (TextView) view.findViewById(R.id.tv_home_trian);
        tv_home_plane = (TextView) view.findViewById(R.id.tv_home_plane);
        home_more_tv = (TextView) view.findViewById(R.id.tv_home_more);
        ckmiddle_tv = (TextView) view.findViewById(R.id.ckmiddle_tv);
        homeequestrain_tv = (TextView) view.findViewById(R.id.home_equestrain_tv);
        homecruiseship_tv = (TextView) view.findViewById(R.id.home_cruiseship_tv);

        homecar_img = (ImageView) view.findViewById(R.id.home_car_img);
        homecruiseship_img = (ImageView) view.findViewById(R.id.home_equestrain_img);
        homeequestrain_img = (ImageView) view.findViewById(R.id.home_cruiseship_img);
        im_home_food = (ImageView) view.findViewById(R.id.im_home_food);
        im_home_hotel = (ImageView) view.findViewById(R.id.im_home_hotel);
        im__home_trian = (ImageView) view.findViewById(R.id.im__home_trian);
        im_home_more = (ImageView) view.findViewById(R.id.im_home_more);
        im_home_plane = (ImageView) view.findViewById(R.id.im_home_plane);
        go_welcome_login_img = (ImageView) view.findViewById(R.id.go_welcome_login_img);


        homecar_img.setOnClickListener(this);
        homecruiseship_img.setOnClickListener(this);
        homeequestrain_img.setOnClickListener(this);
        im_home_food.setOnClickListener(this);
        im_home_hotel.setOnClickListener(this);
        im__home_trian.setOnClickListener(this);
        im_home_more.setOnClickListener(this);
        im_home_plane.setOnClickListener(this);
        go_welcome_login_img.setOnClickListener(this);

        ckmiddle_tv.setOnClickListener(this);
        flmiddle_tv.setOnClickListener(this);
        tv_home_trian.setOnClickListener(this);
        homecar_tv.setOnClickListener(this);
        tv_home_plane.setOnClickListener(this);
        homeequestrain_tv.setOnClickListener(this);
        homecruiseship_tv.setOnClickListener(this);
        home_more_tv.setOnClickListener(this);
        rb_city_home.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ckmiddle_tv://吃喝
            case R.id.im_home_food:
                //  Intent intent = new Intent(getActivity(), EatDrinkActivity.class);
                Intent intent = new Intent(getActivity(), HomeFoodActivity.class);
                startActivity(intent);
                break;
            case R.id.flmiddle_tv://酒店
            case R.id.im_home_hotel:
                startActivity(new Intent(getActivity(), HomeHotelActivity.class));
                break;
            case R.id.tv_home_trian:
            case R.id.im__home_trian:
                startActivity(new Intent(getActivity(), TrianActivity.class));
                break;
            case R.id.tv_home_plane://机票
            case R.id.im_home_plane:
                startActivity(new Intent(getActivity(), PlaneActivity.class));
                break;
            case R.id.home_equestrain_tv://马术
            case R.id.home_equestrain_img:
                startActivity(new Intent(getActivity(), EquestrianActivity.class));
                break;
            case R.id.home_cruiseship_tv://游艇
            case R.id.home_cruiseship_img://游艇
                startActivity(new Intent(getActivity(), CruiseShipActivity.class));
                break;
            case R.id.home_car_tv://豪车
            case R.id.home_car_img://豪车
                Intent homecarintent = new Intent(getActivity(), CarActivity.class);
                startActivity(homecarintent);
                break;
            case R.id.tv_home_more://更多
            case R.id.im_home_more://更多
                Intent homemoreintent = new Intent(getActivity(), HomeMoreActivity.class);
                startActivity(homemoreintent);
                break;
            case R.id.rb_city_home://更多
                startActivity(new Intent(getActivity(), SelectCityActivity.class));
                break;
            case R.id.go_welcome_login_img:
                // ActivityUtils.startActivity(getActivity(), LiveAnchorDetails2.class);
                ActivityUtils.startActivity(getActivity(), LoginActivity.class);
                // ActivityUtils.startActivity(getActivity(), VideoIngActivity.class);
                // PublicDialog.homeTopPop(getActivity(), go_welcome_login_img, popListenter);

                break;
        }
    }


    ItemClickListener popListenter = new ItemClickListener() {
        @Override
        public void itemClick(int postion) {
            switch (postion) {
                case 0:
                    startActivity(new Intent(getActivity(), MsgCenterActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(getActivity(), MsgCenterActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(getActivity(), MsgSysCenterActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(getActivity(), MsgCenterActivity.class));
                    break;
            }
        }
    };
}