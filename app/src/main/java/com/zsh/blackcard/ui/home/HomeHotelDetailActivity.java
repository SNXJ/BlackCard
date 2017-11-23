package com.zsh.blackcard.ui.home;


import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HotelDetailsitemAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.DateListener;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.HotelDetailModel;
import com.zsh.blackcard.model.HoteldetailsItemModel;
import com.zsh.blackcard.ui.OrderPayActivity;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.MyCalendar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeHotelDetailActivity extends BaseActivity {

    @BindView(R.id.hotel_name)
    TextView hotelName;
    @BindView(R.id.tv_describe)
    TextView tvDescribe;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_wifi)
    LinearLayout llWifi;
    @BindView(R.id.ll_pay)
    LinearLayout llPay;
    @BindView(R.id.ll_swim)
    LinearLayout llSwim;
    @BindView(R.id.ll_fit)
    LinearLayout llFit;
    @BindView(R.id.ll_food)
    LinearLayout llFood;
    @BindView(R.id.ll_park)
    LinearLayout llPark;
    @BindView(R.id.tv_tel)
    TextView tvTel;
    @BindView(R.id.bt_score)
    Button btScore;
    @BindView(R.id.tv_comment)
    TextView tvComment;
    @BindView(R.id.im_food_next)
    ImageView imFoodNext;
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.rl_comment)
    RelativeLayout rlComment;
    @BindView(R.id.tv_check_in)
    TextView tvCheckIn;
    @BindView(R.id.tv_check_out)
    TextView tvCheckOut;
    @BindView(R.id.tv_totle)
    TextView tvTotle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.top_banner)
    Banner topBanner;
    private String id;


    final List<HoteldetailsItemModel> dataList = new ArrayList<>();
    private HotelDetailsitemAdapter adapter;
    private HotelDetailModel.PdBean hotelData;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_hotel_detail);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("data");
        initData();
        initRV();
    }

    private void initRV() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHotelDetailList(DataManager.getMd5Str("HOTELDETAIL"), id), new ResultListener<HoteldetailsItemModel>() {
            @Override
            public void responseSuccess(HoteldetailsItemModel obj) {

                List<HoteldetailsItemModel.PdBean> dataList = obj.getPd();
                setRVData(dataList);
            }

            @Override
            public void onCompleted() {

            }
        });

    }

    private void setRVData(final List<HoteldetailsItemModel.PdBean> dataList) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new HotelDetailsitemAdapter(this, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // PublicDialog.hotelOrderDialog(HomeHotelDetailActivity.this, dataList.get(position), hotelData);
                hotelOrderDialog(dataList.get(position));
            }
        });
    }


    public void hotelOrderDialog(final HoteldetailsItemModel.PdBean item) {
        if (null == hotelData) {
            return;
        }
        View view = LayoutInflater.from(HomeHotelDetailActivity.this).inflate(
                R.layout.hotel_order_pop, null);
        final Dialog dialog = PublicDialog.showDialogView(view, HomeHotelDetailActivity.this);
        Button bt_order = (Button) view.findViewById(R.id.bt_order);

        TextView tv_score = (TextView) view.findViewById(R.id.tv_score);
        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        LinearLayout ll_wifi = (LinearLayout) view.findViewById(R.id.ll_wifi);
        LinearLayout ll_park = (LinearLayout) view.findViewById(R.id.ll_park);
        LinearLayout ll_pay = (LinearLayout) view.findViewById(R.id.ll_pay);
        LinearLayout ll_fit = (LinearLayout) view.findViewById(R.id.ll_fit);
        LinearLayout ll_food = (LinearLayout) view.findViewById(R.id.ll_food);
        LinearLayout ll_swim = (LinearLayout) view.findViewById(R.id.ll_swim);
        ImageView im_dialog = (ImageView) view.findViewById(R.id.im_dialog);
        ImageView im_reduce = (ImageView) view.findViewById(R.id.im_reduce);
        ImageView im_plus = (ImageView) view.findViewById(R.id.im_plus);
        final TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
        TextView tv_info = (TextView) view.findViewById(R.id.tv_info);
        TextView tv_time = (TextView) view.findViewById(R.id.tv_time);
        TextView tv_des = (TextView) view.findViewById(R.id.tv_des);
        TextView tv_money = (TextView) view.findViewById(R.id.tv_money);
        final EditText et_name = (EditText) view.findViewById(R.id.et_name);
        final EditText et_tel_num = (EditText) view.findViewById(R.id.et_tel_num);
        final EditText et_other = (EditText) view.findViewById(R.id.et_other);

        showOrHint(hotelData.getSHOPSERVFOOD(), ll_food);
        showOrHint(hotelData.getSHOPSERVFITNESS(), ll_fit);
        showOrHint(hotelData.getSHOPSERVPARK(), ll_park);
        showOrHint(hotelData.getSHOPSERVPAY(), ll_pay);
        showOrHint(hotelData.getSHOPSERVSWIN(), ll_swim);
        showOrHint(hotelData.getSHOPSERVWIFI(), ll_wifi);
        tv_name.setText(hotelData.getHOTELNAMES());
        tv_score.setText(String.valueOf(hotelData.getHOTELEVALUATE()));

        tv_info.setText(item.getHOTELDETNAME());
        //TODO 自己算
        tv_time.setText(dataIn + "入住," + dataOut + "离开，" + tvTotle.getText());
        tv_des.setText(item.getHOTELDETBEDTYPE());
        tv_money.setText("￥" + item.getHOTELDETPRICE() + "");
        item.setMyDES(dataIn + "入住," + dataOut + "离开，" + tvTotle.getText());

        Glide.with(this).load(item.getHOTELDETIMGS()).into(im_dialog);

        im_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(tv_count.getText() + "");
                if (res > 98) {
                    return;
                } else {
                    tv_count.setText((res + 1) + "");
                }
            }
        });
        im_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = Integer.parseInt(tv_count.getText() + "");
                if (res < 1) {
                    return;
                } else {
                    tv_count.setText((res - 1) + "");
                }
            }
        });
        bt_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != dialog) {
                    dialog.dismiss();
                }
                tv_count.getText();
                et_name.getText();
                et_tel_num.getText();
                et_other.getText();
                ActivityUtils.startActivityForSerializable(HomeHotelDetailActivity.this, OrderPayActivity.class, item);
                // UIUtils.showToast("数量" + tv_count.getText());
            }
        });
    }

    private void setData(HotelDetailModel.PdBean hotelData) {
        hotelName.setText(hotelData.getHOTELNAMES());
        tvScore.setText(String.valueOf(hotelData.getHOTELEVALUATE()));
        tvTel.setText(hotelData.getHOTELPHONE());
        tvAddress.setText(hotelData.getHOTELADDRESS());
        btScore.setText(String.valueOf(hotelData.getHOTELEVALUATE()));
        tvComment.setText(hotelData.getHOTELEVACOUNT() + "条评论");
        initBanner();
        showOrHint(hotelData.getSHOPSERVFOOD(), llFood);
        showOrHint(hotelData.getSHOPSERVFITNESS(), llFit);
        showOrHint(hotelData.getSHOPSERVPARK(), llPark);
        showOrHint(hotelData.getSHOPSERVPAY(), llPay);
        showOrHint(hotelData.getSHOPSERVSWIN(), llSwim);
        showOrHint(hotelData.getSHOPSERVWIFI(), llWifi);

    }

    //初始化banner轮播区
    private void initBanner() {
        topBanner.setImages(hotelData.getHOTELDETAILSIMGS());
        topBanner.setImageLoader(new MyImageLoader());
        topBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        topBanner.isAutoPlay(false);
        topBanner.setIndicatorGravity(BannerConfig.RIGHT);
        topBanner.start();
    }

    //banner加载图片类
    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    private void showOrHint(int i, LinearLayout ll) {
        if (i == 1) {
            ll.setVisibility(View.VISIBLE);
        } else {
            ll.setVisibility(View.GONE);
        }
    }

    private void initData() {
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postHotelDetail(DataManager.getMd5Str("HOTELSYN"), id), new ResultListener<HotelDetailModel>() {
            @Override
            public void responseSuccess(HotelDetailModel obj) {
                hotelData = obj.getPd();
                setData(hotelData);
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    private String dataIn = null;
    private String dataOut = null;

    @OnClick({R.id.rl_comment, R.id.ll_check_out, R.id.ll_check_in, R.id.im_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_comment:
                ActivityUtils.startActivityForData(HomeHotelDetailActivity.this, CommentActivity.class, id);
                break;
            case R.id.ll_check_in:
                PublicDialog.dateDialog(HomeHotelDetailActivity.this, new DateListener() {
                    @Override
                    public void dateListener(String data) {
                        dataIn = data;
                        try {
                            tvTotle.setText("共" + MyCalendar.getDateSpace(dataIn, dataOut) + "天");
                        } catch (Exception e) {

                        }
                        tvCheckIn.setText(data.substring(5));
                    }
                });
                //TODO
                break;
            case R.id.ll_check_out:
                PublicDialog.dateDialog(HomeHotelDetailActivity.this, new DateListener() {
                    @Override
                    public void dateListener(String data) {
                        dataOut = data;
                        try {
                            tvTotle.setText("共" + MyCalendar.getDateSpace(dataIn, dataOut) + "天");

                        } catch (Exception e) {

                        }
                        tvCheckOut.setText(data.substring(5));
                    }
                });
                //TODO
                break;
            case R.id.im_back:
                finish();
                break;
        }
    }
}
