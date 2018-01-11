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
import com.zsh.blackcard.custom.MyImageLoader;

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
    private String[] tab = new String[]{"推荐", "科技", "吃喝", "心灵", "时尚", "运动", "摄影"};
    private List<Integer> bannerList = new ArrayList<>();

    private List<Integer> designerList = new ArrayList<>();
    private List<Integer> rvList = new ArrayList<>();

    private MagazineDesinerAdapter magazineDesinerAdapter;

    private MagazineListAdapter magazineListAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.main_glory_magazine_activity);
        ButterKnife.bind(this);
        inintData();
    }

    private void inintData() {

        initTab();
        initBanner();
        initDesinerRV();
        initMagazineRV();


    }

    private void initMagazineRV() {
        rvList.add(R.mipmap.magazine_image_71);
        rvList.add(R.mipmap.magazine_image_72);
        rvList.add(R.mipmap.magazine_image_73);
        rvList.add(R.mipmap.magazine_image_74);
        rvList.add(R.mipmap.magazine_image_75);
        rvList.add(R.mipmap.magazine_image_76);
        rvList.add(R.mipmap.magazine_image_77);
        rvList.add(R.mipmap.magazine_image_78);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        magazineListAdapter = new MagazineListAdapter(rvList);
        recyclerView.setAdapter(magazineListAdapter);
        magazineListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ActivityUtils.startActivity(this,HomeGloryMagazineActivity.class);
            }
        });

    }

    private void initDesinerRV() {
        designerList.add(R.mipmap.magazine_image_66);
        designerList.add(R.mipmap.magazine_image_67);
        designerList.add(R.mipmap.magazine_image_68);
        designerList.add(R.mipmap.magazine_image_69);
//        designerList.add(R.mipmap.magazine_image_70);
        designerList.add(R.mipmap.magazine_image_66);
        designerList.add(R.mipmap.magazine_image_67);
        designerList.add(R.mipmap.magazine_image_68);
        designerList.add(R.mipmap.magazine_image_69);
//        designerList.add(R.mipmap.magazine_image_70);

        designerRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        magazineDesinerAdapter = new MagazineDesinerAdapter(designerList);
//        recyclerView.addItemDecoration(new SpaceItemDecoration(30));
        designerRecyclerView.setAdapter(magazineDesinerAdapter);


    }

    private void initBanner() {

        bannerList.add(R.mipmap.magazine_banner_11);
        bannerList.add(R.mipmap.magazine_banner_11);
        bannerList.add(R.mipmap.magazine_banner_11);

        banner.setImages(bannerList);
        banner.setImageLoader(new MyImageLoader());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.start();
    }

    private void initTab() {
        for (int i = 0; i < tab.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tab[i]));
        }
        tabLayout.addOnTabSelectedListener(this);
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

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
