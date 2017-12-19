package com.zsh.blackcard.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.ChooseImageDialog;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.MyDisBlackPowerModel;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.ui.BlackCurrencyActivity;
import com.zsh.blackcard.ui.CircleCenterActivity;
import com.zsh.blackcard.ui.CusCenterChatActivity;
import com.zsh.blackcard.ui.DiscountCouponActivity;
import com.zsh.blackcard.ui.HouseCenterActivity;
import com.zsh.blackcard.ui.HuoDongActivity;
import com.zsh.blackcard.ui.MyFriendActivity;
import com.zsh.blackcard.ui.MyPowerActivity;
import com.zsh.blackcard.ui.MySettingActivity;
import com.zsh.blackcard.ui.OrderCenterActivity;
import com.zsh.blackcard.ui.VipCenterActivity;
import com.zsh.blackcard.ui.WalletCenterActivity;
import com.zsh.blackcard.ui.zgactivity.GameCenterActivity;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.MPermissionUtils;
import com.zsh.blackcard.untils.PhotoUntils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 2017/10/11.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.im_avatar)
    ImageView imAvatar;
    @BindView(R.id.my_nick_name_tv)
    TextView my_nick_name_tv;
    @BindView(R.id.my_dis_count_tv)
    TextView my_dis_count_tv;
    @BindView(R.id.my_black_count_tv)
    TextView my_black_count_tv;
    @BindView(R.id.my_power_count_tv)
    TextView my_power_count_tv;

    @Override
    public void initDate(Bundle savedInstanceState) {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).postDisBlackPower(DataManager.getMd5Str("MYCOUBLACKENERGY"), "d6a3779de8204dfd9359403f54f7d27c"), new ResultListener<MyDisBlackPowerModel>() {
            @Override
            public void responseSuccess(MyDisBlackPowerModel obj) {
                if(obj.getResult().equals("01")){
                    my_nick_name_tv.setText(obj.getMy().getNICKNAME());
                    my_dis_count_tv.setText(String.valueOf(obj.getMy().getCOUPON()));
                    my_black_count_tv.setText(String.valueOf(obj.getMy().getBLACKCOIN()));
                    my_power_count_tv.setText(String.valueOf(obj.getMy().getENERGY()));
                    Glide.with(getActivity()).load(obj.getMy().getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(getActivity()))).into(imAvatar);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.myfragment, null);
        //初始化ButterKnife
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.my_vip_center_relative, R.id.my_house_center_relative, R.id.my_circle_center_relative, R.id.my_huodong_center_relative, R.id.my_shop_center_relative, R.id.my_customer_center_relative, R.id.my_wallet_center_relative, R.id.my_game_center_relative, R.id.my_order_center_relative, R.id.my_setting_center_relative, R.id.my_friend_linear, R.id.my_black_linear, R.id.my_power_linear})
    public void onClick(View view) {
        switch (view.getId()) {
            //会员中心
            case R.id.my_vip_center_relative:
                ActivityUtils.startActivity(getActivity(), VipCenterActivity.class);
                break;
            case R.id.my_house_center_relative:
                ActivityUtils.startActivity(getActivity(), HouseCenterActivity.class);
                break;
            //圈子中心
            case R.id.my_circle_center_relative:
                ActivityUtils.startActivity(getActivity(), CircleCenterActivity.class);
                break;
            //活动中心
            case R.id.my_huodong_center_relative:
                ActivityUtils.startActivity(getActivity(), HuoDongActivity.class);
                break;
            case R.id.my_shop_center_relative:
//                ActivityUtils.startActivity(getActivity(), );
                break;
            case R.id.my_customer_center_relative:
                ActivityUtils.startActivity(getActivity(), CusCenterChatActivity.class);
                break;
            case R.id.my_wallet_center_relative:
                ActivityUtils.startActivity(getActivity(), WalletCenterActivity.class);
                break;
            case R.id.my_game_center_relative:
                ActivityUtils.startActivity(getActivity(), GameCenterActivity.class);
                break;
            //订单中心
            case R.id.my_order_center_relative:
                ActivityUtils.startActivity(getActivity(), OrderCenterActivity.class);
                break;
            case R.id.my_setting_center_relative:
                ActivityUtils.startActivity(getActivity(), MySettingActivity.class);
                break;
            case R.id.my_friend_linear:
                ActivityUtils.startActivity(getActivity(), DiscountCouponActivity.class);
                break;
            case R.id.my_black_linear:
                ActivityUtils.startActivity(getActivity(), BlackCurrencyActivity.class);
                break;
            case R.id.my_power_linear:
                ActivityUtils.startActivity(getActivity(), MyPowerActivity.class);
                break;
        }
    }

    @OnClick(R.id.im_avatar)
    public void onClick() {
        requestPermissions();
    }

    private void requestPermissions() {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        MPermissionUtils.requestPermissionsResult(this, 1, PERMISSIONS_STORAGE
                , new MPermissionUtils.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        ChooseImageDialog.chooseImage(getActivity(), MyFragment.this);
                    }

                    @Override
                    public void onPermissionDenied() {
                        MPermissionUtils.showTipsDialog(getActivity());
                    }
                });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
        switch (requestCode) {
            case PhotoUntils.GET_IMAGE_FROM_PHONE://相册
                //如果没有选择图片，则不进行裁剪
                if (!selectList.isEmpty()) {
                    upAvatar(selectList.get(0).getPath());
                }
                break;
            case PhotoUntils.GET_IMAGE_BY_CAMERA://照相机
                //如果打开相机没有拍照，则不进行裁剪
                if (!selectList.isEmpty()) {
                    upAvatar(selectList.get(0).getPath());
                }
                break;
        }
    }

    private void upAvatar(final String imgPath) {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).upHeadIMG(DataManager.getMd5Str("UPPORT"), BaseApplication.HONOURUSER_ID, imgPath), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                Glide.with(MyFragment.this).
                        load(imgPath).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(getActivity())))
                        .into(imAvatar);
                System.out.println("上传成功");
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
