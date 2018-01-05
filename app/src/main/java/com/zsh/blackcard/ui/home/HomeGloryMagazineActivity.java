package com.zsh.blackcard.ui.home;

import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeGloryMagazineActivity extends BaseActivity {

    @BindView(R.id.head_img)
    ImageView head_img;
    @BindView(R.id.rl_top_bg)
    ImageView rl_top_bg;
    @BindView(R.id.img_one)
    ImageView img_one;
    @BindView(R.id.img_two)
    ImageView img_two;
    @BindView(R.id.img_three)
    ImageView img_three;
    @BindView(R.id.img_four)
    ImageView img_four;
    @BindView(R.id.title_tip_tv)
    TextView title_tip_tv;
    @BindView(R.id.content_tv)
    TextView content_tv;

//    @SuppressLint("HandlerLeak")
//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case 1:
//                    Bitmap bitmap = (Bitmap) msg.obj;
//                    rl_top_bg.setImageBitmap(new FastBlur().fastblur(bitmap, 50, rl_top_bg));
//                    head_img.setImageBitmap(bitmap);
//                    break;
//            }
//        }
//    };


    @OnClick(R.id.im_back)
    public void onClick(){
        finish();
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.activity_home_glory_magazine);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        String data = getIntent().getStringExtra("data");
        //获取外部传递过来的图片网址，暂时无用
//        String title = getIntent().getStringExtra("title");
        switch (data){
            case "0":
                head_img.setImageResource(R.mipmap.books_image_1);
                rl_top_bg.setImageResource(R.mipmap.books_image_2);
                img_one.setImageResource(R.mipmap.books_image_3);
                img_two.setImageResource(R.mipmap.books_image_4);
                img_three.setImageResource(R.mipmap.books_image_5);
                img_four.setImageResource(R.mipmap.books_image_6);
                title_tip_tv.setText("《时尚芭莎》：精辟的流行趋势报道");
                content_tv.setText("《时尚芭莎》是一本服务于中国精英女性阶层的时尚杂志，传播来自时装、美和女性力量。她不仅提供新的时尚资讯；精辟的流行趋势报道；受关注的任务专访和女性话题");
                break;
            case "1":
                head_img.setImageResource(R.mipmap.books_image_7);
                rl_top_bg.setImageResource(R.mipmap.books_image_8);
                img_one.setImageResource(R.mipmap.books_image_9);
                img_two.setImageResource(R.mipmap.books_image_10);
                img_three.setImageResource(R.mipmap.books_image_11);
                img_four.setImageResource(R.mipmap.books_image_12);
                title_tip_tv.setText("《国家地理》美国地理学会官方杂志");
                content_tv.setText("《国家地理》封面上的亮黄色边框以及月桂纹图样已经成为象征，杂志内容为高质量的关于社会、历史、世界各地的风土人情的文章；其印刷和图片之质量标准也为人们所称道");
                break;
            case "2":
                head_img.setImageResource(R.mipmap.books_image_13);
                rl_top_bg.setImageResource(R.mipmap.books_image_14);
                img_one.setImageResource(R.mipmap.books_image_15);
                img_two.setImageResource(R.mipmap.books_image_16);
                img_three.setImageResource(R.mipmap.books_image_17);
                img_four.setImageResource(R.mipmap.books_image_18);
                title_tip_tv.setText("《时代》：充分了解世界大事");
                content_tv.setText("《时代》追溯孤立事件的来龙去脉，介绍外国国家，讲它们的版图与俄勒冈或蒙大拿一样大小，援引它们的政治情况，帮助读者克服拼读名称方面的困难，以及使用报纸从未用过的图表等");
                break;
            case "3":
                head_img.setImageResource(R.mipmap.books_image_1);
                rl_top_bg.setImageResource(R.mipmap.books_image_2);
                img_one.setImageResource(R.mipmap.books_image_3);
                img_two.setImageResource(R.mipmap.books_image_4);
                img_three.setImageResource(R.mipmap.books_image_5);
                img_four.setImageResource(R.mipmap.books_image_6);
                title_tip_tv.setText("《时尚芭莎》：精辟的流行趋势报道");
                content_tv.setText("《时尚芭莎》是一本服务于中国精英女性阶层的时尚杂志，传播来自时装、美和女性力量。她不仅提供新的时尚资讯；精辟的流行趋势报道；受关注的任务专访和女性话题");
                break;
            case "4":
                head_img.setImageResource(R.mipmap.books_image_7);
                rl_top_bg.setImageResource(R.mipmap.books_image_8);
                img_one.setImageResource(R.mipmap.books_image_9);
                img_two.setImageResource(R.mipmap.books_image_10);
                img_three.setImageResource(R.mipmap.books_image_11);
                img_four.setImageResource(R.mipmap.books_image_12);
                title_tip_tv.setText("《国家地理》美国地理学会官方杂志");
                content_tv.setText("《国家地理》封面上的亮黄色边框以及月桂纹图样已经成为象征，杂志内容为高质量的关于社会、历史、世界各地的风土人情的文章；其印刷和图片之质量标准也为人们所称道");
                break;
        }
//请求网络加载头像图片
//        Glide.with(this).load(title).into(head_img);
//请求网络图片加载蒙版效果
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                BitmapUtils.getbitmapByUrl(title, new BitmapListener() {
//                    @Override
//                    public void bitmapListener(Bitmap bitmap) {
//                        final Message msg = Message.obtain();
//                        if (null == bitmap) {
//                            msg.what = 0;
//                            msg.obj = null;
//                        } else {
//                            msg.what = 1;
//                            msg.obj = bitmap;
//                        }
//                        handler.sendMessage(msg);
//                    }
//                });
//            }
//        }).start();

    }
}
