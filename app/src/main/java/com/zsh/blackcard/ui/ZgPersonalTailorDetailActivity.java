package com.zsh.blackcard.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.ZgPersonalDetailAdapter;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.ZgPersonalTailorDatailModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 尊购侧滑界面私人定制详情页面
 */
public class ZgPersonalTailorDetailActivity extends BaseActivity {

    @BindView(R.id.zg_personal_recycler_detail)
    RecyclerView zg_personal_recycler_detail;

    private ZgPersonalDetailAdapter zgPersonalDetailAdapter;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_personal_tailor_detail);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        DataManager.getInstance(this).RequestHttp(NetApi.getInstance(this).postZgPersonalTailorDetail(DataManager.getMd5Str("PERSONALDET"), data), new ResultListener<ZgPersonalTailorDatailModel>() {
            @Override
            public void responseSuccess(ZgPersonalTailorDatailModel obj) {
                if (obj.getResult().equals("01")) {
                    if (obj.getPd().get(0).getTITLE().contains("@")) {
                        String[] split = obj.getPd().get(0).getTITLE().split("@");
                        for (int i = 0; i < obj.getPd().size(); i++) {
                            if (i == 0) {
                                if (obj.getPd().get(i).getCONTENT().contains("@")) {
                                    obj.getPd().get(i).setCONTENT(obj.getPd().get(i).getCONTENT().replaceAll("@", "\n\n"));
                                }
                                obj.getPd().get(i).setTITLE(split[i]);
                                obj.getPd().get(i).setItemType(1);
                            } else if (i == 1) {
                                obj.getPd().get(i).setTITLE(split[i]);
                                obj.getPd().get(i).setItemType(2);
                            } else if (obj.getPd().get(i).getTITLE().equals("")) {
                                obj.getPd().get(i).setItemType(3);
                            } else if (i == obj.getPd().size() - 1 && obj.getPd().get(i).getSHOWIMG().equals("")) {
                                obj.getPd().get(i).setItemType(4);
                                if (obj.getPd().get(i).getCONTENT().contains("@")) {
                                    obj.getPd().get(i).setCONTENT(obj.getPd().get(i).getCONTENT().replaceAll("@", "\n\n"));
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < obj.getPd().size(); i++) {
                            if (i == 0) {
                                obj.getPd().get(i).setItemType(1);
                            } else if (obj.getPd().get(i).getTITLE().equals("")) {
                                obj.getPd().get(i).setItemType(3);
                            } else if (i == obj.getPd().size() - 1 && obj.getPd().get(i).getSHOWIMG().equals("")) {
                                obj.getPd().get(i).setItemType(4);
                                if (obj.getPd().get(i).getCONTENT().contains("@")) {
                                    obj.getPd().get(i).setCONTENT(obj.getPd().get(i).getCONTENT().replaceAll("@", "\n\n"));
                                }
                            }
                        }
                    }
                    zgPersonalDetailAdapter = new ZgPersonalDetailAdapter(obj.getPd());
                    zg_personal_recycler_detail.setLayoutManager(new LinearLayoutManager(ZgPersonalTailorDetailActivity.this));
                    zg_personal_recycler_detail.setAdapter(zgPersonalDetailAdapter);
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
