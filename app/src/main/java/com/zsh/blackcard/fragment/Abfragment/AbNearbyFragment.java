package com.zsh.blackcard.fragment.Abfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.PublicDialog;
import com.zsh.blackcard.listener.SbNearChangeListener;
import com.zsh.blackcard.model.SbNearChangeModel;
import com.zsh.blackcard.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 尚播的附近
 */

public class AbNearbyFragment extends BaseFragment {

    @BindView(R.id.sb_change_linear)
    RelativeLayout sb_change_linear;

    private List<ImageView> listImage = new ArrayList<>();
    private SbNearChangeModel sbNearChangeModel = new SbNearChangeModel();

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.sb_nearbyfragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.sb_change_linear)
    public void onClick() {
        PublicDialog.sbChangeDialog(getActivity(), listImage, sbNearChangeModel, new SbNearChangeListener() {
            @Override
            public void onClick(SbNearChangeModel sbNearChangeModel, Dialog dialog) {
                if (sbNearChangeModel.getType() != null && sbNearChangeModel.getSex() != null && sbNearChangeModel.getTime() != null) {
                    UIUtils.showToast("筛选成功");
                    dialog.dismiss();
                } else {
                    UIUtils.showToast("请选择筛选条件");
                }
            }
        });
    }

}
