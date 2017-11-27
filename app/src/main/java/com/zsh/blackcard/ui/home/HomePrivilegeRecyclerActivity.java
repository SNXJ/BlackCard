package com.zsh.blackcard.ui.home;

import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kkkkk on 2017/11/27.
 */

public class HomePrivilegeRecyclerActivity extends BaseActivity {

    @BindView(R.id.home_privilege_recycler)
    RecyclerView home_privilege_recycler;

    @Override
    protected void initUI() {
        setContentView(R.layout.home_privilege_recycler);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 加载指定特权列表  列表行布局已完成  home_privilege_recycler_item
     */
    private void initData() {

    }
}
