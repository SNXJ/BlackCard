package com.zsh.blackcard.ui.my;

import android.view.View;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.utils.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 入驻商家页面
 */
public class MySettedActivity extends BaseActivity {

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.blackwb_back, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.ten, R.id.elven, R.id.twelve, R.id.zg_shop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //美食商家入驻
            case R.id.one:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "1", "美食商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "1", "401078506970152960");
                break;
            //酒店商家入驻
            case R.id.two:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "1", "酒店商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "1", "401108895226920960");
                break;
            //马术商家入驻
            case R.id.three:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "马术商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "401109385855631360");
                break;
            //游艇商家入驻
            case R.id.four:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "游艇商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "401109432701812736");
                break;
            //豪车商家入驻
            case R.id.five:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "豪车商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "401109479271170048");
                break;
            //高尔夫商家入驻
            case R.id.six:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "高尔夫商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "401109525706309632");
                break;
            //飞机商家入驻
            case R.id.seven:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "飞机商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "401109557247475712");
                break;
            //高端品鉴商家入驻
            case R.id.eight:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "高端品鉴商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "401109652105854976");
                break;
            //娱乐商家入驻
            case R.id.nine:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "3", "娱乐商家");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "3", "401109772532711424");
                break;
            //金融机构入驻
            case R.id.ten:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "尊购商品");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "401109813271986176");
                break;
            //自媒体入驻
            case R.id.elven:
                ActivityUtils.startActivityForData(this, MySettedZiMeiTiActivity.class, "2", "金融机构");
//                ActivityUtils.startActivityForData(this, MySettedZiMeiTiActivity.class, "2", "402831901301145600");
                break;
            //音乐入驻
            case R.id.twelve:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "自媒体");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "402831970356166656");
                break;
            //尊购商品入驻
            case R.id.zg_shop:
                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "音乐");
//                ActivityUtils.startActivityForData(this, MySettedBusinessActivity.class, "2", "402831746686517248");
                break;
            //后退按钮
            case R.id.blackwb_back:
                finish();
                break;
        }
    }
}
