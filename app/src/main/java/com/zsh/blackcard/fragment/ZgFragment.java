package com.zsh.blackcard.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.listener.ZGSlidingListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/10/20.
 */

public class ZgFragment extends BaseFragment {
    private ViewPager zgvp;
    private List<ImageView> imageList;
    public LinearLayout lldot;
    public View view;
    private ImageView zgmyimg;
    private ZGSlidingListener zGSlidingListener;

    int src[] = {R.mipmap.but_banner_1, R.mipmap.toghter_image_1, R.mipmap.toghter_image_2};

    public void sendStatus(ZGSlidingListener zglistener) {
        this.zGSlidingListener = zglistener;
    }

    @Override
    public void initDate(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.zgfragment, null);
        zgfindId();
        zgvp.setAdapter(new MyAdapter(getActivity(), src));

        //初始话
        initDot();
        zgvp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                for (int i = 0; i < imageList.size(); i++) {
                    if (i == position) {
                        imageList.get(i).setImageResource(R.drawable.select_zheng);
                    } else {
                        imageList.get(i).setImageResource(R.drawable.select_fan);
                    }
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });
        return view;
    }

    private void zgfindId() {
        zgvp = (ViewPager) view.findViewById(R.id.zg_vp);
        lldot = (LinearLayout) view.findViewById(R.id.ll_dot);
        zgmyimg = (ImageView) view.findViewById(R.id.zg_myleftimg);

        zgmyimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent zgmyintent = new Intent(getActivity(), ZgMyActivity.class);
//                startActivity(zgmyintent);
                zGSlidingListener.onMeauClick();

            }
        });

    }

    private void initDot() {
        imageList = new ArrayList<>();
        for (int i = 0; i < src.length; i++) {
            ImageView image = new ImageView(getActivity().getApplicationContext());
            if (i == 0) {
                image.setImageResource(R.drawable.select_zheng);
            } else {
                image.setImageResource(R.drawable.select_fan);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip2px(getActivity(), 5), dip2px(getActivity(), 5));
            params.setMargins(dip2px(getActivity(), 5), 0, dip2px(getActivity(), 5), 0);
            lldot.addView(image, params);
            imageList.add(image);
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    class MyAdapter extends PagerAdapter {
        private int[] src;
        private Context context;

        public MyAdapter(Context context, int[] src) {
            // TODO Auto-generated constructor stub
            this.context = context;
            this.src = src;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return src.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            ImageView view = new ImageView(context);
            view.setImageResource(src[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View) object);
        }
    }

}
