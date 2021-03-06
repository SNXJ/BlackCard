package com.zsh.blackcard.ui.my;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 上传身份证页面
 */
public class MySettedBusinessPhotoActivity extends BaseActivity {

    //身份证正面
    @BindView(R.id.id_positive)
    ImageView id_positive;
    //身份证反面
    @BindView(R.id.id_opposite)
    ImageView id_opposite;

    private ArrayList<String> listPath = null;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted_business_photo);
        ButterKnife.bind(this);
        listPath = getIntent().getStringArrayListExtra("listPath");
        if (!listPath.isEmpty()) {
            if (listPath.size() == 1) {
                Glide.with(this).load(listPath.get(0)).into(id_positive);
            } else {
                Glide.with(this).load(listPath.get(0)).into(id_positive);
                Glide.with(this).load(listPath.get(1)).into(id_opposite);
            }
        }else{
            listPath.add("");
            listPath.add("");
        }
    }

    @OnClick({R.id.blackwb_back, R.id.id_positive, R.id.id_opposite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.blackwb_back:
                Intent intent = new Intent();
                intent.putStringArrayListExtra("listPath", listPath);
                setResult(0, intent);
                finish();
                break;
            //正面
            case R.id.id_positive:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)
                        .isCamera(true)
                        .compress(true)
                        .forResult(1);
                break;
            //反面
            case R.id.id_opposite:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)
                        .isCamera(true)
                        .compress(true)
                        .forResult(2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    // 图片选择结果回调
                    List<LocalMedia> selectListOne = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    if(!listPath.isEmpty()){
                        listPath.remove(0);
                    }
                    listPath.add(0, selectListOne.get(0).getCompressPath());
                    Glide.with(MySettedBusinessPhotoActivity.this).load(selectListOne.get(0).getCompressPath()).into(id_positive);
                    break;
                case 2:
                    List<LocalMedia> selectListTwo = PictureSelector.obtainMultipleResult(data);
                    if(!listPath.isEmpty()){
                        listPath.remove(1);
                    }
                    listPath.add(1, selectListTwo.get(0).getCompressPath());
                    Glide.with(MySettedBusinessPhotoActivity.this).load(selectListTwo.get(0).getCompressPath()).into(id_opposite);
                    break;
            }
        }
    }

    //屏蔽普通的返回关闭按钮
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
