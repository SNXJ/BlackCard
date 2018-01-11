package com.zsh.blackcard.live.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsh.blackcard.BaseFragment;
import com.zsh.blackcard.R;
import com.zsh.blackcard.adapter.LiveChatAdapter;
import com.zsh.blackcard.adapter.LiveViewerAdapter;
import com.zsh.blackcard.custom.KeyboardStatusDetector;
import com.zsh.blackcard.model.LiveChatModel;
import com.zsh.blackcard.utils.CharUtils;
import com.zsh.blackcard.view.GiftItemView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tyrantgit.widget.HeartLayout;


/**
 * Name: LivingRoomFragment
 * Author: Shing
 * Date: 2018/1/9 下午3:49
 * Description: ..
 */

public class LivingRoomFragment extends BaseFragment {
    @BindView(R.id.im_live_head)
    ImageView imLiveHead;
    @BindView(R.id.im_name)
    TextView imName;
    @BindView(R.id.im_num)
    TextView imNum;
    @BindView(R.id.viewer_recycler_view)
    RecyclerView viewerRecyclerView;
    @BindView(R.id.chat_recycler_view)
    RecyclerView chat_recycler_view;
    @BindView(R.id.gift_item_view)
    GiftItemView giftItemView;
    @BindView(R.id.heart_layout)
    HeartLayout heartLayout;
    @BindView(R.id.chat)
    ImageView chat;
    @BindView(R.id.im_share)
    ImageView imShare;
    @BindView(R.id.im_heart)
    ImageView imHeart;
    @BindView(R.id.im_gif)
    ImageView imGif;
    @BindView(R.id.rl_buttom)
    RelativeLayout rlButtom;
    @BindView(R.id.send_edit)
    EditText sendEdit;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.layout_send_message)
    LinearLayout layoutSendMessage;
    @BindView(R.id.rl_root)
    RelativeLayout rootView;


    private LiveViewerAdapter viewerAdapter;
    private LiveChatAdapter liveChatAdapter;


    private Random mRandom;


    List<Integer> viewList = new ArrayList<>();
    List<LiveChatModel> chatList = new ArrayList<>();


    @Override
    public void initDate(Bundle savedInstanceState) {


        LinearLayoutManager llm = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        viewerRecyclerView.setLayoutManager(llm);
        viewList.add(R.mipmap.room_image_3);
        viewList.add(R.mipmap.room_image_4);
        viewList.add(R.mipmap.room_image_5);
        viewList.add(R.mipmap.room_image_1);
        viewList.add(R.mipmap.room_image_1);
        viewList.add(R.mipmap.room_image_1);
        viewList.add(R.mipmap.room_image_1);
        viewerAdapter = new LiveViewerAdapter(viewList);
        viewerRecyclerView.setAdapter(viewerAdapter);
//聊天

        for (int i = 0; i < 3; i++) {//模拟数据
            LiveChatModel m = new LiveChatModel();

//            m.img = "http://v1.qzone.cc/avatar/201503/06/18/27/54f981200879b698.jpg%21200x200.jpg";
            m.name = CharUtils.getRandomString(8);
            m.level = (int) (Math.random() * 100 + 1);
            m.message = CharUtils.getRandomString(20);
            chatList.add(m);
        }
        chat_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        liveChatAdapter = new LiveChatAdapter(chatList);
        chat_recycler_view.setAdapter(liveChatAdapter);

        mRandom = new Random();
        handler.postDelayed(runnable, 1000);

        initKeyBoard();

    }


    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(getActivity(), R.layout.living_room_fragment, null);

        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.im_live_head, R.id.gift_item_view, R.id.chat, R.id.im_share, R.id.im_heart, R.id.im_gif, R.id.tv_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_live_head:
                break;
            case R.id.gift_item_view:
                break;
            case R.id.chat:
                layoutSendMessage.setVisibility(View.VISIBLE);
                rlButtom.setVisibility(View.GONE);
                sendEdit.requestFocus();
                InputMethodManager inputManager =
                        (InputMethodManager) sendEdit.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(sendEdit, 0);
                break;
            case R.id.im_share:
                break;
            case R.id.im_heart:
                break;
            case R.id.im_gif:

                break;
        }
    }


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (chatList != null) {
                LiveChatModel m = new LiveChatModel();
//                m.img = "http://v1.qzone.cc/avatar/201503/06/18/27/54f981200879b698.jpg%21200x200.jpg";
                m.name = CharUtils.getRandomString(8);
                m.level = (int) (Math.random() * 100 + 1);
                m.message = CharUtils.getRandomString(20);
                chatList.add(m);
                liveChatAdapter.notifyDataSetChanged();
                chat_recycler_view.scrollToPosition(liveChatAdapter.getItemCount() - 1);
//
            }
            handler.postDelayed(this, 1000);
        }
    };
    Handler heartHandler = new Handler();
    Runnable heartRunnable = new Runnable() {
        @Override
        public void run() {
            heartLayout.post(new Runnable() {
                @Override
                public void run() {
                    heartLayout.addHeart(randomColor());
                }
            });
            heartHandler.postDelayed(this, 1000);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        heartHandler.removeCallbacks(heartRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        heartHandler.postDelayed(heartRunnable, 2000);
    }

    private int randomColor() {
        return Color.rgb(mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(runnable);
    }

    /**
     * 键盘监听
     */
    private void initKeyBoard() {
        new KeyboardStatusDetector()
                .registerView(rootView)
                .setVisibilityListener(new KeyboardStatusDetector.KeyboardVisibilityListener() {
                    @Override
                    public void onVisibilityChanged(boolean keyboardVisible) {

                        if (keyboardVisible) {
                            layoutSendMessage.setVisibility(View.VISIBLE);
                            rlButtom.setVisibility(View.GONE);
                        } else {
                            layoutSendMessage.setVisibility(View.GONE);
                            rlButtom.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }

}
