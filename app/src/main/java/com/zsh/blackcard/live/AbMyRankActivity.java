package com.zsh.blackcard.live;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.PublicFragmentAdapter;
import com.zsh.blackcard.fragment.live.LiveRankAnchorFragment;
import com.zsh.blackcard.fragment.live.LiveRankUserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: AbMyRankActivity
 * Author: SNXJ
 * Date: 2017-11-10
 * Description:  等級（用户等级 和 主播等级）
 */
public class AbMyRankActivity extends BaseActivity {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.top_tab)
    TabLayout topTab;
    @BindView(R.id.viewPage)
    ViewPager viewPage;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] title = {"用户等级", "主播等级"};


    @Override
    protected void initUI() {

        setContentView(R.layout.ab_my_rank_activity);
        ButterKnife.bind(this);

        initDate();
    }

    public void initDate() {
        fragments.add(new LiveRankUserFragment());
        fragments.add(new LiveRankAnchorFragment());

        PublicFragmentAdapter adapter = new PublicFragmentAdapter(getSupportFragmentManager(), fragments, title);
        viewPage.setOffscreenPageLimit(2);
        viewPage.setAdapter(adapter);
        topTab.setupWithViewPager(viewPage);
    }

    @OnClick(R.id.title_back)
    public void onViewClicked() {
        finish();
    }


}

