package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeTypeMoreAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomePrivilegeModel;
import com.zsh.blackcard.ui.GolfActivity;
import com.zsh.blackcard.untils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: HomeMoreActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:描述：
 */
public class HomeMoreActivity extends BaseActivity {


    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.home_more_recycler)
    RecyclerView homeMoreRecycler;
    private HomeTypeMoreAdapter homeTypeMoreAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.home_more_activity);
        ButterKnife.bind(this);
        initData();
    }


    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }

    private void initData() {
        DataManager.getInstance(HomeMoreActivity.this).RequestHttp(NetApi.getInstance(HomeMoreActivity.this).postHomePrivilege(DataManager.getMd5Str("PRIVILIST")), new ResultListener<HomePrivilegeModel>() {
            @Override
            public void responseSuccess(HomePrivilegeModel obj) {
                homeTypeMoreAdapter = new HomeTypeMoreAdapter(R.layout.home_type_recycler_item, obj.getPd());
                homeMoreRecycler.setLayoutManager(new GridLayoutManager(HomeMoreActivity.this, 4));
                homeMoreRecycler.setNestedScrollingEnabled(false);
                homeMoreRecycler.setAdapter(homeTypeMoreAdapter);
                homeTypeMoreAdapter.setOnItemClickListener(new HomeTypeOnItemClick());
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    /**
     * 所有权限列表的点击事件
     */
    class HomeTypeOnItemClick implements BaseQuickAdapter.OnItemClickListener {

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            String privilege_id = ((HomePrivilegeModel.PdBean) adapter.getData().get(position)).getPRIVILEGE_ID();
            switch (position) {
                //美食
                case 0:
                    ActivityUtils.startActivityForIntData(HomeMoreActivity.this, HomeFoodHotelActivity.class, 0);
                    break;
                //酒店
                case 1:
                    ActivityUtils.startActivityForIntData(HomeMoreActivity.this, HomeFoodHotelActivity.class, 1);
                    // ActivityUtils.startActivity(HomeMoreActivity.this, HomeHotelActivity.class);
                    break;
                //火车票
                case 2:
                    ActivityUtils.startActivity(HomeMoreActivity.this, HomeTrainActivity.class);
                    break;
                //机票
                case 3:
                    ActivityUtils.startActivity(HomeMoreActivity.this, HomePlaneActivity.class);
                    break;
                //马术
                case 4://TODO
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomeEquestrianActivity.class, privilege_id);
                    break;
                //游艇
                case 5:
                    ActivityUtils.startActivity(HomeMoreActivity.this, HomeCruiseShipActivity.class);
                    break;
                //豪车
                case 6:
                    ActivityUtils.startActivity(HomeMoreActivity.this, HomeCarDetailActivity.class);
                    break;
                case 7://直升机
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case 8:// "高尔夫汇"
                    startActivity(new Intent(HomeMoreActivity.this, GolfActivity.class));
                    break;
                case 9://, "私人订制",
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case 10:// "品牌杂志",
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case 11:// "健康养生",
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case 12://"高端品鉴",
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case 13:// "定制理财"
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
            }
        }
    }
}


