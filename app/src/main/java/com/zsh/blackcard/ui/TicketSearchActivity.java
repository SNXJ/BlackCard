package com.zsh.blackcard.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.fragment.TicketSearchFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: TicketSearchActivity
 * Author: SNXJ
 * Date: 2017-11-16
 * Description:票务搜索结果
 */
public class TicketSearchActivity extends BaseActivity {

    private String[] title = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
    private String[] title2 = {"11-11", "11-12", "11-13", "11-14", "11-15", "11-16", "11-16"};
    @BindView(R.id.tv_exchange_01)
    TextView tvExchange01;
    @BindView(R.id.tv_exchange_02)
    TextView tvExchange02;
    @BindView(R.id.im_exchange)
    ImageView imExchange;
    @BindView(R.id.rb_jiage)
    RadioButton rbJiage;
    @BindView(R.id.rb_time)
    RadioButton rbTime;
    @BindView(R.id.rb_zhundian)
    RadioButton rbZhundian;
    @BindView(R.id.rl_tab_fb)
    RelativeLayout rlTabFb;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    //    startActivity(new Intent(TicketSearchActivity.this, TicketSeatActivity.class));
    @Override
    protected void initUI() {
        setContentView(R.layout.ticket_search_activity);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    List<Fragment> fragments = new ArrayList<>();

    private void initView() {
        for (int i = 0; i < 7; i++) {
            fragments.add(new TicketSearchFragment().newInstance(1));
        }

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(6);

        tabLayout.setupWithViewPager(viewpager);


        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.ticket_search_tab_item);//给每一个tab设置view
            if (i == 0) {
                // 设置第一个tab的TextView是被选择的样式
                tab.getCustomView().findViewById(R.id.tab_text_1).setSelected(true);//第一个tab被选中
                tab.getCustomView().findViewById(R.id.ll_tab_item).setSelected(true);//第一个tab被选中
            }
            TextView textView = (TextView) tab.getCustomView().findViewById(R.id.tab_text_1);
            TextView textView2 = (TextView) tab.getCustomView().findViewById(R.id.tab_text_2);
            textView.setText(title[i]);//设置tab上的文字
            textView2.setText(title2[i]);//设置tab上的文字
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.tab_text_1).setSelected(true);
                tab.getCustomView().findViewById(R.id.tab_text_2).setSelected(true);
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.tab_text_1).setSelected(false);
                tab.getCustomView().findViewById(R.id.tab_text_2).setSelected(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initData() {

    }


    @OnClick({R.id.rb_jiage, R.id.rb_time, R.id.rb_zhundian,})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_jiage:
                break;
            case R.id.rb_time:
                break;
            case R.id.rb_zhundian:
                break;
        }
    }


    @OnClick(R.id.im_back)
    public void onClick() {
        finish();
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        //private String[] title = {"one", "two", "three", "four"};
        private List<Fragment> fragmentList;

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
