package com.zsh.blackcard.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ZgShopModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/11/22.
 * 尊购商品区适配器
 */

public class ZgShopAdapter extends BaseMultiItemQuickAdapter<ZgShopModel,BaseViewHolder>{
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ZgShopAdapter(List<ZgShopModel> data) {
        super(data);
        addItemType(ZgShopModel.LEFT, R.layout.zg_shop_left_item);
        addItemType(ZgShopModel.RIGHT, R.layout.zg_shop_right_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZgShopModel item) {
        switch (helper.getLayoutPosition()){
            case 0:
                helper.setText(R.id.zg_shop__tv,"手表专区");
                helper.setImageResource(R.id.zg_shop_img,R.mipmap.buy_image_1);
                break;
            case 1:
                helper.setText(R.id.zg_shop__tv,"包袋专区");
                helper.setImageResource(R.id.zg_shop_img,R.mipmap.buy_image_2);
                break;
            case 2:
                helper.setText(R.id.zg_shop__tv,"首饰专区");
                helper.setImageResource(R.id.zg_shop_img,R.mipmap.buy_image_3);
                break;
            case 3:
                helper.setText(R.id.zg_shop__tv,"豪车专区");
                helper.setImageResource(R.id.zg_shop_img,R.mipmap.buy_image_4);
                break;
            case 4:
                helper.setText(R.id.zg_shop__tv,"高尔夫汇");
                helper.setImageResource(R.id.zg_shop_img,R.mipmap.buy_image_5);
                break;
            case 5:
                helper.setText(R.id.zg_shop__tv,"飞机游艇");
                helper.setImageResource(R.id.zg_shop_img,R.mipmap.buy_image_6);
                break;
            case 6:
                helper.setText(R.id.zg_shop__tv,"家电数码");
                helper.setImageResource(R.id.zg_shop_img,R.mipmap.buy_image_7);
                break;

        }
    }
}
