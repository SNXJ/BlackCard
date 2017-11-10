package com.zsh.blackcard.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by kkkkk on 2017/11/10.
 */

/**
 * 我的页面 钱包中心的自定义圆形
 */
public class WalletTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint mPaint;

    public WalletTextView(Context context) {
        super(context);
    }

    public WalletTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WalletTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        //设置画笔宽度
        mPaint.setStrokeWidth(8);
        //设置画笔颜色
        mPaint.setColor(getPaint().getColor());
        //设置画笔的样式，空心
        mPaint.setStyle(Paint.Style.STROKE);
        //抗锯齿
        mPaint.setAntiAlias(true);
        //设置半径
        int r = getMeasuredWidth() > getMeasuredHeight() ? getMeasuredWidth() : getMeasuredHeight();
        rectF.set(getPaddingLeft(),getPaddingTop(),r-getPaddingRight(),r-getPaddingBottom());
        canvas.drawArc(rectF,0,360,false,mPaint);
    }
}
