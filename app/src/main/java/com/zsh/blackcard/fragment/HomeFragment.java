package com.zsh.blackcard.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeGloryMagazineAdapter;
import com.zsh.blackcard.adapter.HomeGloryServiceAdapter;
import com.zsh.blackcard.adapter.HomeTopAdapter;
import com.zsh.blackcard.adapter.HomeTypeAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeGloryMagazineModel;
import com.zsh.blackcard.model.HomeGloryServiceModel;
import com.zsh.blackcard.model.HomeTopModel;
import com.zsh.blackcard.ui.HomePlaneActivity;
import com.zsh.blackcard.ui.MsgCenterActivity;
import com.zsh.blackcard.ui.WelcomeActivity;
import com.zsh.blackcard.ui.home.HomeCarActivity;
import com.zsh.blackcard.ui.home.HomeCruiseShipActivity;
import com.zsh.blackcard.ui.home.HomeEquestrianActivity;
import com.zsh.blackcard.ui.home.HomeFoodActivity;
import com.zsh.blackcard.ui.home.HomeHotelActivity;
import com.zsh.blackcard.ui.home.HomeKTVActivity;
import com.zsh.blackcard.ui.home.HomeMoreActivity;
import com.zsh.blackcard.ui.home.HomeTrainActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 2017/10/11.
 */

public class HomeFragment extends BaseFragment implements HomeTypeAdapter.HomeTypeOnItemClick {

    //HomeTop 头条的item点击事件
    class HomeTopOnItemClick implements BaseQuickAdapter.OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            switch (position) {
                case 0:
                    ActivityUtils.startActivity(getActivity(), MsgCenterActivity.class);
                    break;
                case 1:
                    ActivityUtils.startActivity(getActivity(), MsgCenterActivity.class);
                    break;
                case 2:
                    ActivityUtils.startActivity(getActivity(), HomeKTVActivity.class);
                    break;
                case 3:
                    ActivityUtils.startActivity(getActivity(), MsgCenterActivity.class);
                    break;
            }
        }
    }

    //通过接口向Activity
    public interface SendMainActivity {
        void goIntent();
    }

    private SendMainActivity sendMainActivity;

    //头部选择列表
    @BindView(R.id.home_type_recycler)
    RecyclerView home_type_recycler;
    //头条选择列表
    @BindView(R.id.home_top_recycler)
    RecyclerView home_top_recycler;
    //荣耀服务列表
    @BindView(R.id.home_glory_service_recycler)
    RecyclerView home_glory_service_recycler;
    //荣耀杂志列表
    @BindView(R.id.home_glory_magazine_recycler)
    RecyclerView home_glory_magazine_recycler;

    @BindView(R.id.home_top_tvs)
    TextSwitcher home_top_tvs;

    //头部列表选择适配器
    private HomeTypeAdapter homeTypeAdapter;
    //头条列表选择适配器
    private HomeTopAdapter homeTopAdapter;
    //荣耀服务列表选择适配器
    private HomeGloryServiceAdapter homeGloryServiceAdapter;
    //荣耀杂志列表适配器
    private HomeGloryMagazineAdapter homeGloryMagazineAdapter;

    private String[] top_title = new String[]{"荣耀黑卡app全新上线,期待您的光临", "荣耀黑卡尊享至尊系列"};

    private int mSwitcherCount = 0;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            home_top_tvs.setText(top_title[mSwitcherCount % top_title.length]);
            mSwitcherCount++;
            if (mSwitcherCount == 2) {
                mSwitcherCount = 0;
            }
            handler.sendEmptyMessageDelayed(1, 3000);
            return false;
        }
    });

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //实例化接口
        sendMainActivity = (SendMainActivity) getActivity();
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        //初始化类型选择列表（美食，酒店，品鉴...）
        if (homeTypeAdapter == null) {
            homeTypeAdapter = new HomeTypeAdapter(getActivity());
            home_type_recycler.setLayoutManager(new GridLayoutManager(getActivity(), 4));
            home_type_recycler.setNestedScrollingEnabled(false);
            home_type_recycler.setAdapter(homeTypeAdapter);
            homeTypeAdapter.setHomeTypeOnItemClick(this);
        }

        //初始化头条文字滚动器
        home_top_tvs.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getActivity());
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                textView.setTextColor(getResources().getColor(R.color.recharge_text));
                textView.setGravity(Gravity.CENTER_VERTICAL);
                return textView;
            }
        });

        //给滚动文字设置滚动动画
        home_top_tvs.setInAnimation(getActivity(), R.anim.enter_bottom);
        home_top_tvs.setOutAnimation(getActivity(), R.anim.leave_top);
        handler.sendEmptyMessage(1);

        //初始化头条列表
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).postHomePage(DataManager.getMd5Str("COMMEND")), new ResultListener<HomeTopModel>() {
            @Override
            public void responseSuccess(HomeTopModel obj) {
                System.out.println(obj);
                for (int i = 0; i < obj.getPd().size(); i++) {
                    if (i == 0) {
                        obj.getPd().get(i).setItemType(1);
                    } else if (i == obj.getPd().size() - 1) {
                        obj.getPd().get(i).setItemType(3);
                    } else {
                        obj.getPd().get(i).setItemType(2);
                    }
                }

                //三亚国际饭店
                if (homeTopAdapter == null) {
                    homeTopAdapter = new HomeTopAdapter(obj.getPd(), getActivity());
                    home_top_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    home_top_recycler.setAdapter(homeTopAdapter);
                    home_top_recycler.setNestedScrollingEnabled(false);
                    homeTopAdapter.setOnItemClickListener(new HomeTopOnItemClick());
                }
            }

            @Override
            public void onCompleted() {

            }
        });

        //初始化荣耀服务列表
        List<HomeGloryServiceModel> list = new ArrayList<>();
        if (homeGloryServiceAdapter == null) {
            for (int i = 0; i < 3; i++) {
                HomeGloryServiceModel homeGloryServiceModel = new HomeGloryServiceModel();
                if (i == 0) {
                    homeGloryServiceModel.setItemType(1);
                } else if (i == 2) {
                    homeGloryServiceModel.setItemType(3);
                } else {
                    homeGloryServiceModel.setItemType(2);
                }
                list.add(homeGloryServiceModel);
            }
            homeGloryServiceAdapter = new HomeGloryServiceAdapter(list);
            home_glory_service_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            home_glory_service_recycler.setAdapter(homeGloryServiceAdapter);
            home_glory_service_recycler.setNestedScrollingEnabled(false);
        }

        //初始化荣耀杂志列表
        List<HomeGloryMagazineModel> list1 = new ArrayList<>();
        if (homeGloryMagazineAdapter == null) {
            for (int i = 0; i < 4; i++) {
                HomeGloryMagazineModel homeGloryMagazineModel = new HomeGloryMagazineModel();
                if (i == 0) {
                    homeGloryMagazineModel.setItemType(1);
                } else if (i == 3) {
                    homeGloryMagazineModel.setItemType(3);
                } else {
                    homeGloryMagazineModel.setItemType(2);
                }
                list1.add(homeGloryMagazineModel);
            }
            homeGloryMagazineAdapter = new HomeGloryMagazineAdapter(list1);
            home_glory_magazine_recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            home_glory_magazine_recycler.setAdapter(homeGloryMagazineAdapter);
            home_glory_magazine_recycler.setNestedScrollingEnabled(false);
        }
    }


    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.homefragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    //普通控件的onClick事件
    @OnClick({R.id.home_play_img, R.id.go_welcome_login_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_play_img:
                if (sendMainActivity != null) {
                    sendMainActivity.goIntent();
                    System.out.println("22222");
                }
                break;
            case R.id.go_welcome_login_img:
                ActivityUtils.startActivity(getActivity(), WelcomeActivity.class);
                break;
        }
    }

    //类型选择列表监听
    @Override
    public void homeTypeOnItemClick(int position) {
        switch (position) {
            //美食
            case 0:
                ActivityUtils.startActivity(getActivity(), HomeFoodActivity.class);
                break;
            //酒店
            case 1:
                ActivityUtils.startActivity(getActivity(), HomeHotelActivity.class);
                break;
            //火车票
            case 2:
                ActivityUtils.startActivity(getActivity(), HomeTrainActivity.class);
                break;
            //机票
            case 3:
                ActivityUtils.startActivity(getActivity(), HomePlaneActivity.class);
                break;
            //马术
            case 4:
                ActivityUtils.startActivity(getActivity(), HomeEquestrianActivity.class);
                break;
            //游艇
            case 5:
                ActivityUtils.startActivity(getActivity(), HomeCruiseShipActivity.class);
                break;
            //豪车
            case 6:
                ActivityUtils.startActivity(getActivity(), HomeCarActivity.class);
                break;
            //更多
            case 7:
                ActivityUtils.startActivity(getActivity(), HomeMoreActivity.class);
                break;
        }
    }
}