package com.zsh.blackcard.fragment.live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.LiveAnchorMoreModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Name: LiveRankAnchorFragment
 * Author: SNXJ
 * Date: 2017-11-10
 * Description:  主播微博：
 */
public class LiveAnchorMoreFragment extends BaseFragment {
    //    @BindView(R.id.id_stickynavlayout_innerscrollview)
//    NestedScrollView recyclerView;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_birth)
    TextView tvBirth;
    @BindView(R.id.tv_sign)
    TextView tvSign;
    @BindView(R.id.tv_rank)
    TextView tvRank;


    public static final String anchor_id = "anchor_id";
    private String id = "";

    public static LiveAnchorMoreFragment newInstance(String id) {
        LiveAnchorMoreFragment fragment = new LiveAnchorMoreFragment();
        Bundle bundle = new Bundle();
        bundle.putString(anchor_id, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initDate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            id = getArguments().getString(anchor_id);
        }

        DataManager.getInstance(getActivity()).RequestHttp(NetApi.getLiveAncherMore(DataManager.getMd5Str("DOWNDATA"), id), new ResultListener<LiveAnchorMoreModel>() {
            @Override
            public void responseSuccess(LiveAnchorMoreModel obj) {
                if ("01".equals(obj.getResult())) {
                    tvName.setText(obj.getPd().getNICKNAME());
                    tvSex.setText(obj.getPd().getSEX());
                    tvBirth.setText(obj.getPd().getBIRTHDAY());
                    tvSign.setText(obj.getPd().getSIGNNAME());
//                    tvRank.setText(obj.getPd().getSEX());//等级 没有
                }

            }

            @Override
            public void onCompleted() {

            }
        });

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.live_anchor_more_fragment, null);
        ButterKnife.bind(getActivity());

        return view;
    }


}
