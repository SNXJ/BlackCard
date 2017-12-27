package com.zsh.blackcard.ui.home;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.BaseApplication;
import com.zsh.blackcard.R;
import com.zsh.blackcard.api.DataManager;
import com.zsh.blackcard.api.NetApi;
import com.zsh.blackcard.custom.HomeTypeConstant;
import com.zsh.blackcard.listener.ResultListener;
import com.zsh.blackcard.model.CommentAddModel;
import com.zsh.blackcard.utils.UIUtils;
import com.zsh.blackcard.view.Star;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: CommentEditActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:描述：
 */
public class CommentEditActivity extends BaseActivity {
    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tv_submmit)
    TextView tvSubmmit;
    @BindView(R.id.star)
    Star star;
    @BindView(R.id.et_comment)
    EditText etComment;
    @BindView(R.id.cb_show)
    CheckBox rbShow;
    private String id;
    Map<String, String> map = new TreeMap<>();
    private float starNum;
    private String isShow;
    private String type;

    @Override
    protected void initUI() {
        setContentView(R.layout.comment_edit_activity);
        id = getIntent().getStringExtra("data");
        type = getIntent().getStringExtra("type");
        ButterKnife.bind(this);
        star.setStarChangeLister(new Star.OnStarChangeListener() {
            @Override
            public void onStarChange(Float mark) {
                starNum = mark;
            }
        });

    }

    private void submit() {
        switch (type) {
            case HomeTypeConstant.MORE_TYPE_HOTEL:
                map.put("FKEY", DataManager.getMd5Str("SHOTELADDEVA"));
                map.put("SORTHOTEL_ID", id);
                break;
            case HomeTypeConstant.MORE_TYPE_FOOD:
                map.put("FKEY", DataManager.getMd5Str("SFOODADDEVA"));
                map.put("SORTFOOD_ID", id);
                break;
            case HomeTypeConstant.MORE_TYPE_KTV:
                map.put("FKEY", DataManager.getMd5Str("SKTVADDEVA"));
                map.put("SORTKTV_ID", id);
                break;
            case HomeTypeConstant.MORE_TYPE_BAR:
                map.put("FKEY", DataManager.getMd5Str("ADDBAREVA"));
                map.put("SORTBAR_ID", id);
                break;
        }

        map.put("HONOURUSER_ID", BaseApplication.HONOURUSER_ID);
        map.put("EVALUATECONTENT", etComment.getText().toString());//内容
        map.put("EVALUATECOINT", String.valueOf(starNum));//星星
        map.put("ISSHOW", rbShow.isChecked() ? "1" : "0");//星星

        DataManager.getInstance(this).RequestHttp(NetApi.postAddComment(map, type), new ResultListener<CommentAddModel>() {
            @Override
            public void responseSuccess(CommentAddModel obj) {
                if ("01".equals(obj.getResult())) {
                    UIUtils.showToast("评论成功");
                    finish();
                }
            }

            @Override
            public void onCompleted() {

            }
        });
    }

    @OnClick({R.id.im_back, R.id.tv_submmit, R.id.star})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_submmit:
                submit();
                break;
            case R.id.star:
                break;
        }
    }
}
