package com.zsh.blackcard.fragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.ChooseImageDialog;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ResultModel;
import com.zsh.blackcard.ui.BlackCurrencyActivity;
import com.zsh.blackcard.ui.CircleCenterActivity;
import com.zsh.blackcard.ui.CusCenterChatActivity;
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
import com.zsh.blackcard.untils.UIUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 2017/10/11.
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.im_avatar)
    ImageView imAvatar;
    private Uri resultUri;


    @Override
    public void initDate(Bundle savedInstanceState) {

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
            case R.id.my_vip_center_relative:
                ActivityUtils.startActivity(getActivity(), VipCenterActivity.class);
                break;
            case R.id.my_house_center_relative:
                ActivityUtils.startActivity(getActivity(), HouseCenterActivity.class);
                break;
            case R.id.my_circle_center_relative:
                ActivityUtils.startActivity(getActivity(), CircleCenterActivity.class);
                break;
            //活动中心
            case R.id.my_huodong_center_relative:
                ActivityUtils.startActivity(getActivity(), HuoDongActivity.class);
                break;
            case R.id.my_shop_center_relative:
//                ActivityUtils.startActivity(getActivity(), );
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                calendar.set(Calendar.DAY_OF_MONTH, day + 7);
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                datePickerDialog.show();
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
            case R.id.my_order_center_relative:
                ActivityUtils.startActivity(getActivity(), OrderCenterActivity.class);
                break;
            case R.id.my_setting_center_relative:
                ActivityUtils.startActivity(getActivity(), MySettingActivity.class);
                break;
            case R.id.my_friend_linear:
                ActivityUtils.startActivity(getActivity(), MyFriendActivity.class);
                break;
            case R.id.my_black_linear:
                ActivityUtils.startActivity(getActivity(), BlackCurrencyActivity.class);
                break;
            case R.id.my_power_linear:
                ActivityUtils.startActivity(getActivity(), MyPowerActivity.class);
                break;
        }
    }

    private Long getMills() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2017-12-12");
        long longDate = date.getTime();
        return longDate;
    }

    private Long getMill() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2017-12-06");
        long longDate = date.getTime();
        return longDate;
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
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
        switch (requestCode) {
            case PhotoUntils.GET_IMAGE_FROM_PHONE://相册
                PhotoUntils.cropImage(MyFragment.this, data.getData());// 裁剪图片
                break;
            case PhotoUntils.GET_IMAGE_BY_CAMERA://照相机
                PhotoUntils.cropImage(MyFragment.this, PhotoUntils.imageUriFromCamera);// 裁剪图片
                break;
            case PhotoUntils.CROP_IMAGE://裁剪后的处理
                upAvatar(PhotoUntils.getImageAbsolutePath(getActivity(), PhotoUntils.cropImageUri));
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void upAvatar(String imgPath) {
        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getInstance(getActivity()).upHeadIMG(DataManager.getMd5Str("UPPORT"), BaseApplication.HONOURUSER_ID, imgPath), new ResultListener<ResultModel>() {
            @Override
            public void responseSuccess(ResultModel obj) {
                Glide.with(MyFragment.this).
                        load(PhotoUntils.cropImageUri).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(getActivity())))
                        .into(imAvatar);
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
