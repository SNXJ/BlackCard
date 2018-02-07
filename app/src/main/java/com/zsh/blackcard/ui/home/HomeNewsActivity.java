package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.NewTopDialog;
import com.zsh.blackcard.fragment.ZgFindFragment;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ChannelModel;
import com.zsh.blackcard.model.NewsChannelModel;
import com.zsh.blackcard.ui.NewChannelActivity;
import com.zsh.blackcard.utils.ActivityUtils;
import com.zsh.blackcard.utils.LogUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;

/**
 * Name: HomeNewsActivity
 * Author: SNXJ
 * Date: 2017-11-12
 * Description:描述：
 */
public class HomeNewsActivity extends BaseActivity implements TabLayout.OnTabSelectedListener, NewTopDialog.OnSelectSend {

    @BindView(R.id.my_order_other_tabLayout)
    TabLayout my_order_other_tabLayout;
    private final static int REQUESTCODE = 0x00; // 返回的结果码

    private List<String> titleList = new ArrayList<>();
    private List<String> titList = new ArrayList<>();
    private List<Fragment> fragmentList;
    private Fragment fragmentReplace;
    private FragmentManager fragmentManager;

    private List<ChannelModel> channelDatas = new ArrayList<>();

    @Override
    protected void initUI() {
        setContentView(R.layout.home_news_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        fragmentManager = getSupportFragmentManager();
        //初始化title请求
        DataManager.getInstance(this).RequestHttp(NetApi.postZgFindTiele(DataManager.getMd5Str("CAIDAN")), new ResultListener<NewsChannelModel>() {
            @Override
            public void responseSuccess(NewsChannelModel obj) {
                if (obj.getResult().equals("01")) {
                    fragmentList = new ArrayList<>();
                    for (int i = 0; i < obj.getPd().size(); i++) {
                        my_order_other_tabLayout.addTab(my_order_other_tabLayout.newTab().setText(obj.getPd().get(i).getName()));
                        //相对应的列表id集合
                        titleList.add(obj.getPd().get(i).getId());
                        titList.add(obj.getPd().get(i).getName());

                        ChannelModel channelModel = new ChannelModel();
                        channelModel.setId(obj.getPd().get(i).getId());
                        channelModel.setName(obj.getPd().get(i).getName());
                        channelDatas.add(channelModel);

                        fragmentList.add(fragmentReplace);
                    }
                    ZgFindFragment zgFindFragment = new ZgFindFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", obj.getPd().get(0).getId());
                    zgFindFragment.setArguments(bundle);
                    fragmentList.add(0, zgFindFragment);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.discover_container, fragmentList.get(0));
                    fragmentTransaction.commit();
                    fragmentReplace = zgFindFragment;
                    my_order_other_tabLayout.addOnTabSelectedListener(HomeNewsActivity.this);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    private NewTopDialog topDialog;

    @Override
    protected void onResume() {
        super.onResume();
        if (topDialog != null) {
            topDialog.dismiss();
        }
    }

    @OnClick({R.id.title_back, R.id.my_tip_send_tv, R.id.im_more_channel})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.im_more_channel:

                Intent intent = new Intent(HomeNewsActivity.this, NewChannelActivity.class);

                intent.putExtra("listData", (Serializable) channelDatas);

                startActivityForResult(intent, REQUESTCODE);


//                ActivityUtils.startActivityForDataList(HomeNewsActivity.this, NewChannelActivity.class, channelDatas);
                break;
            //点击发布头条
            case R.id.my_tip_send_tv:
//                PublicDialog.sendNewsDialog(this);
                if (topDialog == null) {
                    topDialog = new NewTopDialog();
                }
                topDialog.show(getSupportFragmentManager(), "Show", view);
                topDialog.setOnSelectSend(HomeNewsActivity.this);
                break;
        }
    }

    //点击发布文字，图片，视频监听。0为文字，1为图片，2为视频
    @Override
    public void selectSend(int position) {
        switch (position) {
            case 0:
                ActivityUtils.startActivityForDataLists(this, HomeNewsSendActivity.class, "1", titList, titleList);
                break;
            case 1:
                ActivityUtils.startActivityForDataLists(this, HomeNewsSendActivity.class, "2", titList, titleList);
                break;
            case 2:
                ActivityUtils.startActivityForDataLists(this, HomeNewsSendActivity.class, "3", titList, titleList);
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //TODO

//        setFragment(tab.getPosition(), titleList.get(tab.getPosition()));

    }

    private void setFragment(int position, String id) {
        if (null == fragmentList) {
            return;
        }
        if (fragmentList.get(position) == null) {
            ZgFindFragment zgFindFragment = new ZgFindFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            zgFindFragment.setArguments(bundle);
            fragmentList.add(position, zgFindFragment);
            replace(fragmentList.get(position));
        } else {
            replace(fragmentList.get(position));
        }
    }

    private void replace(Fragment fragment) {
        FragmentTransaction
                fragmentTransaction = fragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            fragmentTransaction.hide(fragmentReplace).show(fragment).commit();
        } else {
            fragmentTransaction.hide(fragmentReplace).add(R.id.discover_container, fragment).commit();
        }
        fragmentReplace = fragment;
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 2) {
            if (requestCode == REQUESTCODE) {
                int position = data.getIntExtra("position", 0);
                channelDatas = (List<ChannelModel>) data.getSerializableExtra("listData");

                my_order_other_tabLayout.removeAllTabs();
                fragmentList = new ArrayList<>();
                for (int i = 0; i < channelDatas.size(); i++) {
                    my_order_other_tabLayout.addTab(my_order_other_tabLayout.newTab().setText(channelDatas.get(i).getName()));
                    fragmentList.add(fragmentReplace);
                }
                LogUtils.i("++++++++Result+++++", position + "+++++++++++++" + channelDatas.size());
                if (position != -1) {
//                    setFragment(position, channelDatas.get(position).getId());
                    position = 0;
                }
                my_order_other_tabLayout.getTabAt(position).select();
                ZgFindFragment zgFindFragment = new ZgFindFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id", channelDatas.get(position).getId());
                zgFindFragment.setArguments(bundle);
                fragmentList.add(position, zgFindFragment);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.discover_container, fragmentList.get(position));
                fragmentTransaction.commit();
                fragmentReplace = zgFindFragment;

            }
        }
    }


}
