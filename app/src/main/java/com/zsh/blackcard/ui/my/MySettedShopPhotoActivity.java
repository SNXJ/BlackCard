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
 * 店铺照片页面
 */
public class MySettedShopPhotoActivity extends BaseActivity {

    //第一张图片
    @BindView(R.id.id_one)
    ImageView id_one;
    //第二章图片
    @BindView(R.id.id_two)
    ImageView id_two;
    //第三章图片
    @BindView(R.id.id_three)
    ImageView id_three;

    private ArrayList<String> listPath = null;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted_shop_photo);
        ButterKnife.bind(this);
        listPath = getIntent().getStringArrayListExtra("listPath");
        if (!listPath.isEmpty()) {
            if (listPath.size() == 1) {
                Glide.with(this).load(listPath.get(0)).into(id_one);
            } else if (listPath.size() == 2) {
                Glide.with(this).load(listPath.get(0)).into(id_one);
                Glide.with(this).load(listPath.get(1)).into(id_two);
            } else {
                Glide.with(this).load(listPath.get(0)).into(id_one);
                Glide.with(this).load(listPath.get(1)).into(id_two);
                Glide.with(this).load(listPath.get(2)).into(id_three);
            }
        }else{
            listPath.add("");
            listPath.add("");
            listPath.add("");
        }
    }

    @OnClick({R.id.id_one, R.id.id_two, R.id.id_three, R.id.blackwb_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_one:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)
                        .isCamera(true)
                        .compress(true)
                        .forResult(1);
                break;
            case R.id.id_two:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)
                        .isCamera(true)
                        .compress(true)
                        .forResult(2);
                break;
            case R.id.id_three:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)
                        .isCamera(true)
                        .compress(true)
                        .forResult(3);
                break;
            case R.id.blackwb_back:
                Intent intent = new Intent();
                intent.putStringArrayListExtra("listPath", listPath);
                setResult(0, intent);
                finish();
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
                    if (!listPath.isEmpty()) {
                        listPath.remove(0);
                    }
                    listPath.add(0, selectListOne.get(0).getCompressPath());
                    Glide.with(MySettedShopPhotoActivity.this).load(selectListOne.get(0).getCompressPath()).into(id_one);
                    break;
                case 2:
                    List<LocalMedia> selectListTwo = PictureSelector.obtainMultipleResult(data);
                    if (!listPath.isEmpty()) {
                        listPath.remove(1);
                    }
                    listPath.add(1, selectListTwo.get(0).getCompressPath());
                    Glide.with(MySettedShopPhotoActivity.this).load(selectListTwo.get(0).getCompressPath()).into(id_two);
                    break;
                case 3:
                    List<LocalMedia> selectListThree = PictureSelector.obtainMultipleResult(data);
                    if (!listPath.isEmpty()) {
                        listPath.remove(2);
                    }
                    listPath.add(2, selectListThree.get(0).getCompressPath());
                    Glide.with(MySettedShopPhotoActivity.this).load(selectListThree.get(0).getCompressPath()).into(id_three);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
