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
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomePrivilegeModel;
import com.zsh.blackcard.ui.zgactivity.PersonalActivity;
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
        DataManager.getInstance(HomeMoreActivity.this).RequestHttp(NetApi.postHomePrivilege(DataManager.getMd5Str("PRIVILIST")), new ResultListener<HomePrivilegeModel>() {
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
            String type = ((HomePrivilegeModel.PdBean) adapter.getData().get(position)).getPRIVILEGETYPE();
            switch (type) {
                //美食
                case HomeTypeConstant.MORE_TYPE_FOOD:
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomeFoodHotelActivity.class, HomeTypeConstant.MORE_TYPE_FOOD);
                    break;
                //酒店
                case HomeTypeConstant.MORE_TYPE_HOTEL:
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomeFoodHotelActivity.class, HomeTypeConstant.MORE_TYPE_HOTEL);
                    break;
                case HomeTypeConstant.MORE_TYPE_BAR:
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomeFoodHotelActivity.class, HomeTypeConstant.MORE_TYPE_BAR);
                    break;
                //KTV
                case HomeTypeConstant.MORE_TYPE_KTV:
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomeFoodHotelActivity.class, HomeTypeConstant.MORE_TYPE_KTV);
                    break;
                //火车票
                case HomeTypeConstant.MORE_TYPE_TRIAN:
                    ActivityUtils.startActivity(HomeMoreActivity.this, HomeTrainActivity.class);
                    break;
                //机票
                case HomeTypeConstant.MORE_TYPE_PLAN:
                    ActivityUtils.startActivity(HomeMoreActivity.this, HomePlaneActivity.class);
                    break;
                //马术
                case HomeTypeConstant.MORE_TYPE_HORSE:
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomePublicRecyclerActivity.class, HomeTypeConstant.MORE_TYPE_HORSE);
                    break;
                //游艇
                case HomeTypeConstant.MORE_TYPE_YACHT:
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomePublicRecyclerActivity.class, HomeTypeConstant.MORE_TYPE_YACHT);
                    break;
                //豪车
                case HomeTypeConstant.MORE_TYPE_CAR:
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomePublicRecyclerActivity.class, HomeTypeConstant.MORE_TYPE_CAR);
                    break;
                case HomeTypeConstant.MORE_TYPE_COPTER://飞机
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomePublicDetailActivity.class, HomeTypeConstant.MORE_TYPE_COPTER);
                    break;
                case HomeTypeConstant.MORE_TYPE_GOLF:// "高尔夫汇"
                    ActivityUtils.startActivityForData(HomeMoreActivity.this, HomePublicRecyclerActivity.class, HomeTypeConstant.MORE_TYPE_GOLF);
                    break;
                case HomeTypeConstant.MORE_TYPE_PERSON://, "私人订制",
                    startActivity(new Intent(HomeMoreActivity.this, PersonalActivity.class));
                    break;
                case HomeTypeConstant.MORE_TYPE_MAGAZINE:// "品牌杂志",
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case HomeTypeConstant.MORE_TYPE_HEATH:// "健康养生",
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case HomeTypeConstant.MORE_TYPE_HIGH://"高端品鉴",
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
                case HomeTypeConstant.MORE_TYPE_FINANCE:// "定制理财"
                    startActivity(new Intent(HomeMoreActivity.this, HomeEquestrianActivity.class));
                    break;
            }
        }
    }
}


