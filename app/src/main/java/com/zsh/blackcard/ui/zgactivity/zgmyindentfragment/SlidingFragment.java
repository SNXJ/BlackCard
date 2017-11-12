package com.zsh.blackcard.ui.zgactivity.zgmyindentfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.CustomDrawerLayout;
import com.zsh.blackcard.fragment.ZgFragment;
import com.zsh.blackcard.listener.ZGSlidingListener;
import com.zsh.blackcard.ui.LoginActivity;
import com.zsh.blackcard.untils.UIUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by admin on 2017/10/29.
 */

public class SlidingFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private ListView listView;
    private CustomDrawerLayout drawerLayout;
    private ImageView im_zg_head;
    private TextView tv_zg_head;

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.slidingfragment, null);
        initView();
        initDate();
        showDrawerLayout();
        return view;
    }

    private void initView() {
        listView = (ListView) view.findViewById(R.id.left_drawer);
        im_zg_head = (ImageView) view.findViewById(R.id.im_zg_head);
        tv_zg_head = (TextView) view.findViewById(R.id.tv_zg_head);


        drawerLayout = (CustomDrawerLayout) view.findViewById(R.id.drawer_layout);
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        ZgFragment zgFragment = new ZgFragment();
        zgFragment.sendStatus(zglistener);
        fragmentTransaction.replace(R.id.drawerlayout_frame, zgFragment);
        fragmentTransaction.commit();
        im_zg_head.setOnClickListener(this);
        tv_zg_head.setOnClickListener(this);
    }

    ZGSlidingListener zglistener = new ZGSlidingListener() {
        @Override
        public void onMeauClick() {
            showDrawerLayout();
        }
    };
    private List<String> list;

    private void initDate() {
        list = new ArrayList<String>();
        list.add("商品类别");
        list.add("发现");
        list.add("购物车");
        list.add("炫购");
        list.add("私人定制");
        //   ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.sliding_left_lv_item, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO
                leftItemClick(position);

            }
        });
        drawerLayout.openDrawer(Gravity.LEFT);//侧滑打开  不设置则不会默认打开
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    private void leftItemClick(int position) {
        switch (position) {
//            case 0:
//
//                break;

        }
        UIUtils.showToast("条目=" + list.get(position));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.im_zg_head:
                UIUtils.showToast("更换头像");
                break;
            case R.id.tv_zg_head:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
