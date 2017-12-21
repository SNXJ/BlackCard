package com.zsh.blackcard.ui.home;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomePrivilegeModel;

/**
 * 马术
 */
public class HomeEquestrianActivity extends BaseActivity {

    private String privilege_id;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_equestrian);

        privilege_id = getIntent().getStringExtra("data");
        initData();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.privilegePart(DataManager.getMd5Str("PRIVIDET"), privilege_id), new ResultListener<HomePrivilegeModel>() {
            @Override
            public void responseSuccess(HomePrivilegeModel obj) {
//                homeTypeAdapter = new HomeTypeMoreAdapter(R.layout.home_type_recycler_item, obj.getPd());
//                home_type_recycler.setLayoutManager(new GridLayoutManager(getActivity(), 4));
//                home_type_recycler.setNestedScrollingEnabled(false);
//                home_type_recycler.setAdapter(homeTypeAdapter);
//                homeTypeAdapter.setOnItemClickListener(new HomeFragment.HomeTypeOnItemClick());
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
