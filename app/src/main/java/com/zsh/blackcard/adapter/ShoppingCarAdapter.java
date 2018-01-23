package com.zsh.blackcard.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.model.ShoppingCarModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkkkk on 2017/11/25.
 * 购物车列表适配器
 */

public class ShoppingCarAdapter extends BaseQuickAdapter<ShoppingCarModel.PdBean, BaseViewHolder> {

    private List<Boolean> booleanList = new ArrayList<>();

    public ShoppingCarAdapter(int layoutResId, @Nullable List<ShoppingCarModel.PdBean> data) {
        super(layoutResId, data);
        for (int i = 0; i < data.size(); i++) {
            booleanList.add(false);
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingCarModel.PdBean item) {
        helper.setText(R.id.shopping_car_title_tv, item.getPROTITLE());
        helper.setText(R.id.shopping_car_price_tv, "￥" + item.getPROPRICE());
        helper.setText(R.id.shopping_car_number_et, String.valueOf(item.getPRODUCTCOUNT()));
        Glide.with(mContext).load(item.getPROSHOWIMG()).into((ImageView) helper.getView(R.id.shopping_car_icon_img));
        //侧滑删除绑定点击
        helper.addOnClickListener(R.id.shopping_car_item_right_delete);
        //这是整个行布局的id绑定点击
        helper.addOnClickListener(R.id.shopping_car_item_relative);
        helper.addOnClickListener(R.id.shopping_car_item_cb);
        ((CheckBox) helper.getView(R.id.shopping_car_item_cb)).setChecked(booleanList.get(helper.getLayoutPosition()));
    }

    //把列表的所有选择框设置为全选状态
    public void yesSelect() {
        for (int i = 0; i < booleanList.size(); i++) {
            booleanList.set(i, true);
        }
    }

    //把列表的所有选择框设置为未选状态
    public void noSelect() {
        for (int i = 0; i < booleanList.size(); i++) {
            booleanList.set(i, false);
        }
    }

    //根据全部选中或未选中设置下面的全选按钮状态
    public boolean initSelect(boolean b, int position){
        booleanList.set(position,b);
        for (int i = 0; i < booleanList.size(); i++) {
            if(b != booleanList.get(i)){
                return false;
            }
        }
        return true;
    }

    //总结按钮，如果一个都未选中，则无法结算
    public boolean numBtn(){
        for (int i = 0; i < booleanList.size(); i++) {
            if(booleanList.get(i) == true){
                return true;
            }
        }
        return false;
    }
}
