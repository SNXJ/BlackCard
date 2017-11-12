package com.zsh.blackcard;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.untils.StatusBarColorUntil;

import butterknife.ButterKnife;


/**
 * @author sxj
 * @ClassName BaseFragment
 */
public abstract class BaseFragment extends Fragment {
    public Context context;
    public View view;
    public BaseApplication baseApplication;
    public String rtData;
    //  public User user;

    public BaseFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        StatusBarColorUntil.setStatusBarColor(getActivity());
        baseApplication = BaseApplication.getApplication();
        //  user = SharedPreferencesUtils.getUser(baseApplication);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = initView(inflater);
        initDate(savedInstanceState);
        return view;
    }


    @Override
    public void setMenuVisibility(boolean menuVisible) {
        if (getView() != null) {
            getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }

    /*
     * 初始化数据
     */
    public abstract void initDate(Bundle savedInstanceState);

    /*
     * 初始化view
     */
    public abstract View initView(LayoutInflater inflater);
}
