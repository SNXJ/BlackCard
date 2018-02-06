package com.zsh.blackcard;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.utils.MPermissionUtils;

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
//        StatusBarColorUtil.setStatusBarColor(getActivity());
        baseApplication = BaseApplication.getApplication();
        //  user = SharedPreferencesUtils.getUser(baseApplication);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = initView(inflater);
            // 初始化View注入
            ButterKnife.bind(this, view);
            initDate(savedInstanceState);
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public Dialog dialog;

    public Dialog showLoading(Context context) {
        if (null == dialog) {
            dialog = PublicDialog.loadingDialog((Activity) context);
        }

        return dialog;
    }

    public void dialogDismiss() {
        if (null != dialog) {
            dialog.dismiss();
        }
    }
}
