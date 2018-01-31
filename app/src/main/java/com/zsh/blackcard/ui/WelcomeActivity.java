package com.zsh.blackcard.ui;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.shing.scalelibrary.CenterSnapHelper;
import com.shing.scalelibrary.ScaleLayoutManager;
import com.shing.scalelibrary.ViewPagerLayoutManager;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.WelcomeAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.WelcomeModel;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.DisplayUtil;
import com.zsh.blackcard.utils.ShareUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kkkkk on 2017/11/14.
 */

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    //引导页图片集合
    private List<String> listImage = new ArrayList<>();

    @BindView(R.id.welcome_register_btn)
    Button welcome_now_btn;
    @BindView(R.id.welcome_login_btn)
    Button welcome_login_btn;

    @BindView(R.id.radio_group)
    RadioGroup radio_group;


    @OnClick({R.id.welcome_register_btn, R.id.welcome_login_btn})
    public void btnOnClick(View view) {
        switch (view.getId()) {
            //在线申请
            case R.id.welcome_register_btn:
                ActivityUtils.startActivity(this, RegisterActivity.class);
//                ShareUtil.deauShare();
//            PublicDialog.ShareDialog(WelcomeActivity.this);
                break;
            //会籍登录
            case R.id.welcome_login_btn:
                ActivityUtils.startActivity(this, LoginActivity.class);
                break;
        }
    }


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        //把当前Activity添加到管理栈
        ActivityUtils.addActivity(this);
        initData();
        ShareUtil.initShare(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ShareUtil.onUmActivityResult(requestCode, resultCode, data);
    }

    private void initData() {
        //获取欢迎引导页轮播图片
        DataManager.getInstance(this).RequestHttp(NetApi.postWelcome(DataManager.getMd5Str("BOOTPAGELIST")), new ResultListener<WelcomeModel>() {
            @Override
            public void responseSuccess(WelcomeModel obj) {
                if (null != obj && "01".equals(obj.getResult())) {
                    mList = obj.getPd();

                    scaleLayoutManager = new ScaleLayoutManager(WelcomeActivity.this, DisplayUtil.dip2px(WelcomeActivity.this, 10));
                    mRecyclerView.setAdapter(new WelcomeAdapter(mList));
                    mRecyclerView.setLayoutManager(scaleLayoutManager);
                    initLayoutManger();
                    initdot();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    List<WelcomeModel.PdBean> mList = new ArrayList<>();
    private ScaleLayoutManager scaleLayoutManager;

    private void initLayoutManger() {

//        scaleLayoutManager.setMaxVisibleItemCount(1);
        scaleLayoutManager.setItemSpace(100);
        scaleLayoutManager.setCenterScale(1.2f);
//        scaleLayoutManager.setMoveSpeed(1.0f);//速率
        scaleLayoutManager.setOrientation(ViewPagerLayoutManager.HORIZONTAL);
//        scaleLayoutManager.setMaxAlpha(1.0f);//透明度
//        scaleLayoutManager.setMinAlpha(1.0f);
        scaleLayoutManager.setReverseLayout(false);//翻转
        scaleLayoutManager.setInfinite(false);//无限轮播
        CenterSnapHelper centerSnapHelper = new CenterSnapHelper();
        centerSnapHelper.attachToRecyclerView(mRecyclerView);//是否居中  null不控制//需要在setLayoutManager（）之后设置

        scaleLayoutManager.setOnPageChangeListener(new ViewPagerLayoutManager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                radio_group.check(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initdot() {
        for (int i = 0; i < mList.size(); i++) {
            RadioButton rb = new RadioButton(this);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = DisplayUtil.dip2px(this, 0);
            rb.setWidth(DisplayUtil.dip2px(this, 5));
            rb.setHeight(DisplayUtil.dip2px(this, 5));
            rb.setButtonDrawable(null);
            rb.setBackgroundResource(R.drawable.welcoome_rb_selector);
            rb.setChecked(i == 0 ? true : false);
            rb.setId(i);
            radio_group.addView(rb, params);
        }
    }

}
