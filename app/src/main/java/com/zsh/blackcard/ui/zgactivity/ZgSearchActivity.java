package com.zsh.blackcard.ui.zgactivity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgSearchRecommendAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HomeSearchHotModel;
import com.zsh.blackcard.model.ZgSearchModel;
import com.zsh.blackcard.ui.HjSearchActivity;
import com.zsh.blackcard.ui.zgactivity.ZgSearchResultActivity;
import com.zsh.blackcard.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.lankton.flowlayout.FlowLayout;

/**
 * Created by kkkkk on 2017/11/27.
 * 尊购模糊查询页面
 */

public class ZgSearchActivity extends BaseActivity implements TextView.OnEditorActionListener {

    @BindView(R.id.zg_search_et)
    EditText zg_search_et;

    @BindView(R.id.zg_search_hot_flow)
    FlowLayout zg_search_hot_flow;

    @BindView(R.id.zg_search_recommend_recycler)
    RecyclerView zg_search_recommend_recycler;

    private ZgSearchRecommendAdapter zgSearchRecommendAdapter;
    private List<String> listHot = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_search);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.postHomeSearchHot(DataManager.getMd5Str("SERRCHLIST"), "2"), new ResultListener<HomeSearchHotModel>() {
            @Override
            public void responseSuccess(HomeSearchHotModel obj) {
                if (obj.getResult().equals("01")) {
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        listHot.add(obj.getPd().get(i).getNAME());
                    }

                    for (int i = 0; i < listHot.size(); i++) {
                        int ranHeight = dip2px(ZgSearchActivity.this, 24);
                        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ranHeight);
                        lp.setMargins(dip2px(ZgSearchActivity.this, 10), 0, dip2px(ZgSearchActivity.this, 10), 0);
                        TextView tv = new TextView(ZgSearchActivity.this);
                        tv.setPadding(dip2px(ZgSearchActivity.this, 10), 0, dip2px(ZgSearchActivity.this, 10), 0);
                        tv.setTextColor(Color.parseColor("#FF929292"));
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                        tv.setText(listHot.get(i));
                        tv.setGravity(Gravity.CENTER_VERTICAL);
                        tv.setLines(1);
                        tv.setBackgroundResource(R.drawable.shape_register_super_center_false);
                        zg_search_hot_flow.addView(tv, lp);
                    }
                    //压缩，呈现最佳距离计算
                    zg_search_hot_flow.relayoutToCompress();

                    //加载推荐下方的图片
                    zgSearchRecommendAdapter = new ZgSearchRecommendAdapter(R.layout.zg_search_recommend_recycler_item, obj.getShowimgs());
                    zg_search_recommend_recycler.setLayoutManager(new GridLayoutManager(ZgSearchActivity.this, 2));
                    zg_search_recommend_recycler.setAdapter(zgSearchRecommendAdapter);
                    zg_search_et.setOnEditorActionListener(ZgSearchActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
//        hideInputSoft();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (actionId) {
            case EditorInfo.IME_ACTION_DONE:
                //查询数据
                initSearch();
                break;
        }
        return false;
    }

    private void initSearch() {
        ActivityUtils.startActivityForData(this, ZgSearchResultActivity.class,zg_search_et.getText().toString().trim());
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
