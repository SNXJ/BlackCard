package com.zsh.blackcard.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.zsh.blackcard.ChangeAddressPopwindow;
import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.DateListener;
import com.zsh.blackcard.listener.ItemClickListener;
import com.zsh.blackcard.listener.SelectDateListener;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.model.HoteldetailsItemModel;
import com.zsh.blackcard.ui.BlackWeiboActivity;
import com.zsh.blackcard.ui.CommonPassengerActivity;
import com.zsh.blackcard.ui.live.LiveAnchorDetails2;
import com.zsh.blackcard.ui.live.LiveOpenActivity;
import com.zsh.blackcard.ui.live.VideoDetailsActivity;
import com.zsh.blackcard.untils.DisplayUtil;
import com.zsh.blackcard.view.datepickter.DPMode;
import com.zsh.blackcard.view.datepickter.DatePicker;
import com.zsh.blackcard.view.datepickter.DatePicker2;
import com.zsh.blackcard.wheelview.ChangeDateDialog;
import com.zsh.blackcard.wheelview.SelsectOneDialog;
import com.zsh.blackcard.wheelview.SelsectTwoDialog;

import java.util.Calendar;

/**
 * Name: PublicDialog
 * Author: SNXJ
 * Date: 2017-11-10
 * Description: 公共弹窗
 */
public class PublicDialog {
    /**
     * 酒店订单
     *
     * @param mContext
     */
    public static void hotelOrderDialog(final Activity mContext, HoteldetailsItemModel.PdBean itemData, HotelDetailModel.PdBean hotelData) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.hotel_order_pop, null);
        final Dialog dialog = showDialogView(view, mContext);


    }

    /**
     * 尚播动画弹窗
     *
     * @param mContext
     */
    public static void openLiveDialog(final Activity mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.activity_live_main, null);
        final Dialog dialog = showDialogView(view, mContext);

        RadialViewLayout radialView = (RadialViewLayout) view.findViewById(R.id.ll_pop);
        radialView.showOpenOrHide();
        radialView.setOnListener(new ItemClickListener() {
            @Override
            public void itemClick(int postion) {
                switch (postion) {
                    case 0:
                        // dialog.dismiss();
                        break;
                    case 1://开
                        break;
                    case 2:
                        mContext.startActivity(new Intent(mContext, BlackWeiboActivity.class));
                        break;
                    case 3:
                        mContext.startActivity(new Intent(mContext, LiveOpenActivity.class));
                        break;
                    case 4:
                        mContext.startActivity(new Intent(mContext, VideoDetailsActivity.class));
                        break;
                }
            }
        });

    }

    /**
     * 日历选择
     *
     * @param mContext
     */
    public static void dateDialog(final Activity mContext, final DateListener listener) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.data_dialog, null);
        final Dialog dialog = showDialogView(view, mContext);
        DatePicker2 picker = (DatePicker2) view.findViewById(R.id.my_datepicker2);
        picker.setDate(2017, 12);
        picker.setMode(DPMode.SINGLE);
        picker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                listener.dateListener(date);
            }
        });

    }


    /**
     * 乘客信息
     *
     * @param mContext
     */
    public static void ticketInfoPop(final Activity mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.ticket_pop_info, null);

        final Dialog dialog = showDialogView(view, mContext);
        view.findViewById(R.id.im_add_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                mContext.startActivity(new Intent(mContext, CommonPassengerActivity.class));
            }
        });
    }

    /**
     * 首页右上弹窗
     *
     * @param context
     * @param im
     * @param listener 点击监听
     */
    public static void homeTopPop(Context context, ImageView im, ItemClickListener listener) {
        final PopHome popWinShare = new PopHome(context, listener);
        //监听窗口的焦点事件，点击窗口外面则取消显示
        popWinShare.getContentView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    popWinShare.dismiss();
                }
            }
        });
        // }
        //设置默认获取焦点
        popWinShare.setFocusable(true);
        //以某个控件的x和y的偏移量位置开始显示窗口
        popWinShare.showAsDropDown(im, 0, DisplayUtil.dip2px(context, 6));
        //如果窗口存在，则更新
        popWinShare.update();

    }

    public static void ageDialog(final Activity mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.dialog_select_age, null);

        final Dialog dialog = showDialogView(view, mContext);
//        view.findViewById(R.id.btn_myinfo_sure).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                UIUtils.showToast("确定");
//            }
//        });
    }

    /**
     * 直播间弹窗
     *
     * @param mContext
     */
    public static void liveDialog(final Context mContext) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.live_room_dialog, null);
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_dialog_go);
        // 设置style 控制默认dialog带来的边距问题
        final Dialog dialog = new Dialog(mContext, R.style.pub_loading_dialog);
        dialog.setContentView(view);
        dialog.show();
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LiveAnchorDetails2.class);
                mContext.startActivity(intent);
            }
        });
        // 设置相关位置，一定要在 show()之后
        Window window = dialog.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.setCanceledOnTouchOutside(true);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }


    /**
     * 日期滚轮选择 并赋值TextView
     *
     * @param context
     * @param tv
     */
    @SuppressWarnings("deprecation")
    public static void selectDateDialog(Activity context, final TextView tv) {
        ChangeDateDialog mDialog = new ChangeDateDialog(context);
        // 当前时间
        Calendar c = Calendar.getInstance();
        mDialog.setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1,
                c.get(Calendar.DAY_OF_MONTH));
        Window window = mDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dailog_anim_enterorout_window_up);
        mDialog.show();
        WindowManager windowManager = context.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
        lp.width = (int) (display.getWidth()); // 设置宽度
        mDialog.getWindow().setAttributes(lp);
        mDialog.setOnDateListener(new ChangeDateDialog.OnDateListener() {
            @Override
            public void onClick(String year, String month, String day) {
                // TODO
                tv.setText(year + "-" + month + "-" + day);
            }
        });
    }


    /**
     * 单滚轮选择 赋值TextView
     *
     * @param context
     * @param defaultJsonAsset json文件  选择内容
     * @param defaultData
     * @param rb
     */
    public static void selectOneDialog(Activity context,
                                       String defaultJsonAsset, String defaultData, final RadioButton rb) {
        SelsectOneDialog mDialog = new SelsectOneDialog(context,
                defaultJsonAsset, defaultData);
        mDialog.setAddress(defaultData, "");
        setWinLP(mDialog, context);

        mDialog.setAddresskListener(new SelsectOneDialog.OnAddressCListener() {
            @Override
            public void onClick(String province, String city) {
                // TODO Auto-generated method stub
                rb.setText(province);
            }
        });
    }


    /**
     * 单滚轮选择 回调
     *
     * @param context
     * @param defaultJsonAsset
     * @param defaultData
     * @param listener
     */
    public static void showSelectOneDialog(Activity context,
                                           String defaultJsonAsset, String defaultData,
                                           final SelectDateListener listener) {
        SelsectOneDialog mDialog = new SelsectOneDialog(context,
                defaultJsonAsset, defaultData);
        mDialog.setAddress(defaultData, "");
        setWinLP(mDialog, context);

        mDialog.setAddresskListener(new SelsectOneDialog.OnAddressCListener() {
            @Override
            public void onClick(String province, String city) {
                // TODO Auto-generated method stub
                if (listener != null) {
                    listener.actionListener(province, city);
                }
            }
        });
    }

    /**
     * 双滚轮选择
     *
     * @param context
     * @param defaultJsonAsset
     * @param defaultData
     * @param listener
     */
    public static void showSelectTwoDialog(Activity context,
                                           String defaultJsonAsset, String defaultData,
                                           final SelectDateListener listener) {
        SelsectTwoDialog mDialog = new SelsectTwoDialog(context,
                defaultJsonAsset, defaultData);
        mDialog.setAddress(defaultData, "");
        setWinLP(mDialog, context);

        mDialog.setAddresskListener(new SelsectTwoDialog.OnAddressCListener() {
            @Override
            public void onClick(String province, String city) {
                if (listener != null) {
                    listener.actionListener(province, city);
                }
            }
        });
    }

    /**
     * 省市县地址滚轮心选择
     *
     * @param context
     * @param tv
     */
    public static void selectCity(Context context, final TextView tv) {
        ChangeAddressPopwindow mChangeAddressPopwindow = new ChangeAddressPopwindow(context);
        mChangeAddressPopwindow.setAddress("广东", "深圳", "福田区");


        mChangeAddressPopwindow.showAtLocation(tv, Gravity.BOTTOM, 0, 0);
        mChangeAddressPopwindow.setAddresskListener(new ChangeAddressPopwindow.OnAddressCListener() {
            @Override
            public void onClick(String province, String city, String area) {

                tv.setText(province + city + area);
            }
        });
    }

    /**
     * 把自定义布局设置到diaolog
     *
     * @param view
     * @param mContext
     * @return
     */
    public static Dialog showDialogView(View view, final Activity mContext) {
        final Dialog dialog = new Dialog(mContext, R.style.pub_loading_dialog);
        dialog.setContentView(view);
        setWinLP(dialog, mContext);
        return dialog;
    }

    /**
     * 设置dialog 属性
     *
     * @param dialog
     * @param mContext
     */
    private static void setWinLP(Dialog dialog, Activity mContext) {
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dailog_anim_enterorout_window_up);
        dialog.show();
        WindowManager windowManager = mContext.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (int) (display.getWidth()); // 设置宽度
        dialog.getWindow().setAttributes(lp);
    }
}
