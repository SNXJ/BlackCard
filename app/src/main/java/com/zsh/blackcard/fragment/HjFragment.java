package com.zsh.blackcard.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.EatDrinkActivity;


/**
 * 汇聚页面
 */

public class HjFragment extends BaseFragment {

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    LinearLayout hj_eat_drink;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.hjfragment, null);
        hj_eat_drink = (LinearLayout) view.findViewById(R.id.hj_eat_drink);
        hj_eat_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EatDrinkActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
