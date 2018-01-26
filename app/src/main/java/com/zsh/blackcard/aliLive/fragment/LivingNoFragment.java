package com.zsh.blackcard.aliLive.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ItemClickListener;
import com.zsh.blackcard.utils.StringUtils;
import com.zsh.blackcard.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Name: LivingNoFragment
 * Author: Shing
 * Date: 2018/1/9 下午3:49
 * Description: ..
 */

public class LivingNoFragment extends BaseFragment {
    @BindView(R.id.im_close)
    ImageView imClose;
    @BindView(R.id.im_location)
    ImageView imLocation;
    @BindView(R.id.im_switch)
    ImageView imSwitch;
    @BindView(R.id.et_edit_title)
    EditText etEditTitle;
    @BindView(R.id.ll_beautiful)
    LinearLayout llBeautiful;
    @BindView(R.id.btn_open)
    Button btnOpen;
    @BindView(R.id.tv_xieyi)
    TextView tvXieyi;
    @BindView(R.id.main_content)
    FrameLayout mainContent;
    @BindView(R.id.rl_content)
    RelativeLayout rl_content;

    public static ItemClickListener itemClickListener;

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.living_no_fragment, null);
        //初始化ButterKnife
        ButterKnife.bind(this, view);
        return view;
    }

    public static void setItemClickListener(ItemClickListener listener) {
        itemClickListener = listener;


    }

    @OnClick({R.id.im_close, R.id.im_location, R.id.im_switch, R.id.ll_beautiful, R.id.btn_open, R.id.tv_xieyi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_close:
                if (null != itemClickListener) {
                    itemClickListener.itemClick(0);
                }

                break;
            case R.id.im_location:
                if (null != itemClickListener) {
                    itemClickListener.itemClick(1);
                }
                break;
            case R.id.im_switch:
                if (null != itemClickListener) {
                    itemClickListener.itemClick(2);
                }
                break;
            case R.id.ll_beautiful:
                if (null != itemClickListener) {
                    itemClickListener.itemClick(3);
                }
                break;
            case R.id.btn_open:
                String titile = etEditTitle.getText().toString().trim();

                if (StringUtils.isEmpty(titile)) {

                    UIUtils.showToast("为您的直播填一个标题吧");
                    return;
                }

                if (null != itemClickListener) {
//                    rl_content.setVisibility(View.GONE);
                    itemClickListener.itemClick(4);

                }
                break;
            case R.id.tv_xieyi:
                break;
        }
    }


}
