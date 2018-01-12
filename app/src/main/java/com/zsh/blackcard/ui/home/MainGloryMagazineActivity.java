package com.zsh.blackcard.ui.home;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.MagazineDesinerAdapter;
import com.zsh.blackcard.adapter.MagazineListAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.MyImageLoader;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MainGloryMagazineModel;
import com.zsh.blackcard.utils.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: MainGloryMagazineActivity
 * Author: Shing
 * Date: 2018/1/10 下午1:57
 * Description: 杂志首页
 */

public class MainGloryMagazineActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.designer_join)
    RelativeLayout designerJoin;
    @BindView(R.id.designer_recyclerView)
    RecyclerView designerRecyclerView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<String> bannerList = new ArrayList<>();
    private List<Integer> asd = new ArrayList<>();
    private List<Integer> menu_id = new ArrayList<>();
    private MagazineDesinerAdapter magazineDesinerAdapter;

    private MagazineListAdapter magazineListAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.main_glory_magazine_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //请求网络
        initHttp();
    }

    //请求网络
    private void initHttp() {
        showLoading(this);

        DataManager.getInstance(this).RequestHttp(NetApi.postMainGloryMagazine(DataManager.getMd5Str("LISTSUBMENU"), "213"), new ResultListener<MainGloryMagazineModel>() {
            @Override
            public void responseSuccess(MainGloryMagazineModel obj) {
                if (obj.getResult().equals("01")) {
                    //遍历TabLayout数量
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        TabLayout.Tab tab = tabLayout.newTab();
                        tab.setText(obj.getPd().get(i).getMENU_NAME());
                        tabLayout.addTab(tab);
                        menu_id.add(obj.getPd().get(i).getMENU_ID());
                    }
                    //添加tab点击事件
                    tabLayout.addOnTabSelectedListener(MainGloryMagazineActivity.this);
                    //遍历banner广告数量
                    for (int i = 0; i < obj.getAds().size(); i++) {
                        bannerList.add(obj.getAds().get(i).getSHOWIMG());
                    }
                    //加载banner
                    BannerUtils.bannerNoImg(banner, bannerList, 3000);
                    //加载设计师列表(此处为假数据)
                    asd.add(R.mipmap.magazine_image_66);
                    asd.add(R.mipmap.magazine_image_67);
                    asd.add(R.mipmap.magazine_image_68);
                    asd.add(R.mipmap.magazine_image_69);
                    asd.add(R.mipmap.magazine_image_66);
                    asd.add(R.mipmap.magazine_image_67);
                    asd.add(R.mipmap.magazine_image_68);
                    asd.add(R.mipmap.magazine_image_69);

                    magazineDesinerAdapter = new MagazineDesinerAdapter(R.layout.magazine_desiner_item, asd);
                    designerRecyclerView.setLayoutManager(new LinearLayoutManager(MainGloryMagazineActivity.this, LinearLayoutManager.HORIZONTAL, false));
                    designerRecyclerView.setAdapter(magazineDesinerAdapter);
                    //加载杂志列表
                    magazineListAdapter = new MagazineListAdapter(R.layout.magazine_magazine_item, obj.getMagazines());
                    recyclerView.setLayoutManager(new GridLayoutManager(MainGloryMagazineActivity.this, 2));
                    recyclerView.setAdapter(magazineListAdapter);
                }
            }

            @Override
            public void onCompleted() {
                dialogDismiss();
            }
        });
    }

    @OnClick({R.id.title_back, R.id.designer_join})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.designer_join:
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //TODO tab.getPosition();
        initHttpOther(menu_id.get(tab.getPosition()));
    }

    //请求其他Tab
    private void initHttpOther(Integer integer) {
        showLoading(this);

        DataManager.getInstance(this).RequestHttp(NetApi.postMainGloryMagazine(DataManager.getMd5Str("LISTSUBMENU"), String.valueOf(integer)), new ResultListener<MainGloryMagazineModel>() {
            @Override
            public void responseSuccess(MainGloryMagazineModel obj) {
                if (obj.getResult().equals("01")) {
                    //加载杂志列表
                    magazineListAdapter.getData().clear();
                    magazineListAdapter.getData().addAll(obj.getMagazines());
                    magazineListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCompleted() {
                dialogDismiss();
            }
        });
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
