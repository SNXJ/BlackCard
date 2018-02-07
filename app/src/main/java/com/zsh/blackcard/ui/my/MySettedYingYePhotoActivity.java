package com.zsh.blackcard.ui.my;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 营业执照上传
 */
public class MySettedYingYePhotoActivity extends BaseActivity {

    @BindView(R.id.img_one)
    ImageView img_one;

    private String strPath = null;

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_my_setted_ying_ye_photo);
        ButterKnife.bind(this);
        strPath = getIntent().getStringExtra("strPath");
        if (!TextUtils.isEmpty(strPath)) {
            Glide.with(this).load(strPath).into(img_one);
        }
    }

    @OnClick({R.id.img_one, R.id.blackwb_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_one:
                PictureSelector.create(this)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)
                        .isCamera(true)
                        .compress(true)
                        .forResult(1);
                break;
            case R.id.blackwb_back:
                Intent intent = new Intent();
                intent.putExtra("strPath", strPath);
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
                    strPath = selectListOne.get(0).getCompressPath();
                    Glide.with(MySettedYingYePhotoActivity.this).load(selectListOne.get(0).getCompressPath()).into(img_one);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
