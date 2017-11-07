package com.zsh.blackcard.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.BlackcoffeecurrencyActivity;


/**
 * Created by admin on 2017/10/11.
 */

public class MyFragment extends BaseFragment {
    private View view;
    private TextView blackmoney_tv;

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.myfragment, null);
        myfindID();
        myOnClick();
        return view;
    }

    private void myOnClick() {
        blackmoney_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myblackmoneyintent = new Intent(getActivity(), BlackcoffeecurrencyActivity.class);
                startActivity(myblackmoneyintent);
            }
        });
    }

    private void myfindID() {
        blackmoney_tv = (TextView) view.findViewById(R.id.my_blackmoney_tv);
    }
}
