package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.HomeMoreAdapter;
import com.zsh.blackcard.model.HomeNewModel;
import com.zsh.blackcard.ui.GolfActivity;


import java.util.ArrayList;
import java.util.List;

/**
 * Name: HomeMoreActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:描述：
 */
public class HomeMoreActivity extends BaseActivity {

    private ImageView title_back;
    private TextView title_tv;
    private GridView gv_more;

    List<HomeNewModel> list = new ArrayList<>();
    private String[] titles = new String[]{
            "美食", "酒店", "火车票", "机票", "马术", "游艇", "豪车", "飞机", "高尔夫汇", "私人订制", "品牌杂志", "健康养生", "高端品鉴", "定制理财"
    };

    private Integer[] images = {
            R.mipmap.home_food,
            R.mipmap.home_hotel,
            R.mipmap.home_train,
            R.mipmap.home_plane,
            R.mipmap.home_horse,
            R.mipmap.home_ship,
            R.mipmap.home_car,
            R.mipmap.home_helicopter,
            R.mipmap.home_golf,
            R.mipmap.home_diamond,
            R.mipmap.home_magazine,
            R.mipmap.home_healthy,
            R.mipmap.home_judge,
            R.mipmap.home_investment,

    };

    private void bindViews() {
        title_back = (ImageView) findViewById(R.id.title_back);
        title_tv = (TextView) findViewById(R.id.title_tv);
        gv_more = (GridView) findViewById(R.id.gv_more);
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    protected void initUI() {
        setContentView(R.layout.home_more_activity);
        bindViews();
        initGV();
    }

    private void initGV() {
        for (int i = 0; i < titles.length; i++) {
            HomeNewModel pic = new HomeNewModel();
            pic.setImageId(images[i]);
            pic.setTitle(titles[i]);
            list.add(pic);
        }

        HomeMoreAdapter homeMore = new HomeMoreAdapter(this, list);
        gv_more.setAdapter(homeMore);
        gv_more.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemClick(position);
            }
        });
    }

    private void itemClick(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, HomeFoodHotelActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, HomeHotelActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, HomeTrainActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, HomePlaneActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, HomeEquestrianActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, HomeCruiseShipActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, HomeCarActivity.class));
                break;
            case 7://直升机
                startActivity(new Intent(this, HomeEquestrianActivity.class));
                break;
            case 8:// "高尔夫汇"
                startActivity(new Intent(this, GolfActivity.class));
                break;
            case 9://, "私人订制",
                startActivity(new Intent(this, HomeEquestrianActivity.class));
                break;
            case 10:// "品牌杂志",
                startActivity(new Intent(this, HomeEquestrianActivity.class));
                break;
            case 11:// "健康养生",
                startActivity(new Intent(this, HomeEquestrianActivity.class));
                break;
            case 12://"高端品鉴",
                startActivity(new Intent(this, HomeEquestrianActivity.class));
                break;
            case 13:// "定制理财"
                startActivity(new Intent(this, HomeEquestrianActivity.class));
                break;
        }

    }


}
