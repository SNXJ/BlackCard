package com.zsh.blackcard.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zsh.blackcard.R;
import com.zsh.blackcard.custom.GlideCircleTransform;
import com.zsh.blackcard.model.MyCircleModel;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/8.
 * 圈子中心适配器
 */

public class CircleCenterRecyclerAdapter extends BaseQuickAdapter<MyCircleModel.PdBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public CircleCenterRecyclerAdapter(List<MyCircleModel.PdBean> data) {
        super(R.layout.activity_circle_center_recycler_yes_item, data);
//        addItemType(MyCircleModel.PdBean.YES, R.layout.activity_circle_center_recycler_yes_item);
//        addItemType(MyCircleModel.PdBean.NO, R.layout.activity_circle_center_recycler_no_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCircleModel.PdBean item) {
//        switch (item.getItemType()) {
//            case MyCircleModel.PdBean.YES:
        helper.setText(R.id.circle_center_item_title, item.getCONTENT());
        helper.setText(R.id.circle_center_item_time, item.getPUBLISHTIME());
        helper.setText(R.id.circle_center_item_yeah_tv, item.getAGREECOUNT() + "赞");
        helper.setText(R.id.circle_center_item_comment_tv, item.getCOMMENTCOUNT() + "评论");//im_portrait
        Glide.with(mContext).load(item.getPORTRAIT()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(mContext))).into((ImageView) helper.getView(R.id.im_portrait));
        if ("0".equals(item.getSTATUS())) {
            helper.getView(R.id.circle_center_item_yeah_img).setBackgroundResource(R.mipmap.blog_icon_1);
        } else {
            //TODO 已点赞
            helper.getView(R.id.circle_center_item_yeah_img).setBackgroundResource(R.mipmap.blog_icon_2);
        }
        List<String> imgList = item.getSHOWIMAGES();
        if (null != imgList && imgList.size() > 0) {
            helper.getView(R.id.circle_center_item_image_linear).setVisibility(View.VISIBLE);
            for (int i = 0; i < imgList.size(); i++) {
                switch (i) {
                    case 0:
                        Glide.with(mContext).load(imgList.get(i)).into((ImageView) helper.getView(R.id.circle_center_item_one_img));
                        break;
                    case 1:
                        Glide.with(mContext).load(imgList.get(i)).into((ImageView) helper.getView(R.id.circle_center_item_two_img));
                        break;
                    case 2:
                        Glide.with(mContext).load(imgList.get(i)).into((ImageView) helper.getView(R.id.circle_center_item_three_img));
                        break;
                    case 3:
                        Glide.with(mContext).load(imgList.get(i)).into((ImageView) helper.getView(R.id.circle_center_item_four_img));
                        break;
                }
            }
        } else {

            helper.getView(R.id.circle_center_item_image_linear).setVisibility(View.GONE);

        }

//                String[] split = item.getSHOWIMAGES().split(",");

//                break;
//            case MyCircleModel.PdBean.NO:
//                helper.setText(R.id.circle_center_item_title, item.getCONTENT());
//                helper.setText(R.id.circle_center_item_time, item.getPUBLISHTIME());
//                helper.setText(R.id.circle_center_item_yeah_tv, item.getDotAgreeCount()+"赞");
//                helper.setText(R.id.circle_center_item_comment_tv, item.getCommentCount() + "评论");
//                break;
//        }
        helper.addOnClickListener(R.id.circle_center_item_yeah_img);
        helper.addOnClickListener(R.id.circle_center_item_comment_img);
    }
}
