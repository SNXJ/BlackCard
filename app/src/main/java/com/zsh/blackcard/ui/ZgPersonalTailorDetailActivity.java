package com.zsh.blackcard.ui;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgPersonalTailorDetailModel;

import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 尊购侧滑界面私人定制详情页面
 */
public class ZgPersonalTailorDetailActivity extends BaseActivity {

    @BindView(R.id.zg_personal_tailor_detail_one_img)
    ImageView zg_personal_tailor_detail_one_img;
    @BindView(R.id.zg_personal_tailor_detail_two_img)
    ImageView zg_personal_tailor_detail_two_img;
    @BindView(R.id.zg_personal_tailor_detail_three_img)
    ImageView zg_personal_tailor_detail_three_img;
    @BindView(R.id.zg_personal_tailor_detail_one_tv)
    TextView zg_personal_tailor_detail_one_tv;
    @BindView(R.id.zg_personal_tailor_detail_two_tv)
    TextView zg_personal_tailor_detail_two_tv;
    @BindView(R.id.zg_personal_tailor_detail_three_tv)
    TextView zg_personal_tailor_detail_three_tv;
    @BindView(R.id.zg_personal_tailor_detail_four_tv)
    TextView zg_personal_tailor_detail_four_tv;
    @BindView(R.id.zg_personal_tailor_detail_five_tv)
    TextView zg_personal_tailor_detail_five_tv;


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_personal_tailor_detail);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.title_back)
    public void onClick(){
        finish();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postZgPersonalTailorDetail(DataManager.getMd5Str("PERSONALDET"), data), new ResultListener<ZgPersonalTailorDetailModel>() {
            @Override
            public void responseSuccess(ZgPersonalTailorDetailModel obj) {
                Glide.with(ZgPersonalTailorDetailActivity.this).load(obj.getPd().getPERSONALDETIMGS().get(0)).into(zg_personal_tailor_detail_three_img);
                Glide.with(ZgPersonalTailorDetailActivity.this).load(obj.getPd().getPERSONALDETIMGS().get(1)).into(zg_personal_tailor_detail_two_img);
                Glide.with(ZgPersonalTailorDetailActivity.this).load(obj.getPd().getPERSONALDETIMGS().get(2)).into(zg_personal_tailor_detail_one_img);
                zg_personal_tailor_detail_five_tv.setText(obj.getPd().getDOWNINTROCONTENT());
                zg_personal_tailor_detail_four_tv.setText(obj.getPd().getUPINTROTITLE());
                zg_personal_tailor_detail_three_tv.setText(obj.getPd().getUPINTROCONTENT());
                zg_personal_tailor_detail_two_tv.setText(obj.getPd().getDOWNINTROTITLE());
                zg_personal_tailor_detail_one_tv.setText(obj.getPd().getPERSONALDETINTRO());
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
