package com.zsh.blackcard.ui.zgactivity.zgmyindentfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.CustomDrawerLayout;
import com.zsh.blackcard.fragment.ZgFragment;


/**
 * Created by admin on 2017/10/29.
 */

public class SlidingFragment extends BaseFragment {
    private View view;
    private ListView listView;
    private CustomDrawerLayout drawerLayout;


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
        drawerLayout = (CustomDrawerLayout) view.findViewById(R.id.drawer_layout);
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.drawerlayout_frame, new ZgFragment());
        fragmentTransaction.commit();
    }

    private void initDate() {
//        final List<String> list = new ArrayList<String>();
//        list.add("商品类别");
//        list.add("腾讯");
//        list.add("新浪");
//        list.add("搜狐");
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
//        listView.setAdapter(adapter);
        drawerLayout.openDrawer(Gravity.LEFT);//侧滑打开  不设置则不会默认打开
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

}
