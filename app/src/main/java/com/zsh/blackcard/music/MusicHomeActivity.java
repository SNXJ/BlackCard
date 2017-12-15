package com.zsh.blackcard.music;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.music.fragment.MusicDjFragment;
import com.zsh.blackcard.music.fragment.MusicLibraryFragment;
import com.zsh.blackcard.music.fragment.MusicRankingFragment;
import com.zsh.blackcard.music.fragment.MusicSingerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: MusicHomeActivity
 * Author: SNXJ
 * Date: 2017-12-13
 * Description:音乐入口
 */
public class MusicHomeActivity extends BaseActivity {
    String type;
    @BindView(R.id.title_tv)
    TextView titleTv;

    private String title = "歌手";

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void initUI() {
        setContentView(R.layout.music_home_activity);
        ButterKnife.bind(this);
        type = getIntent().getStringExtra("data");
        initData();
    }

    private void initData() {
        if (null == savedInstanceState) {
            switch (type) {
                case "0":
                    fragment = new MusicSingerFragment();
                    title = "歌手";
                    break;
                case "1":
                    title = "排行榜";
                    fragment = new MusicRankingFragment();
                    break;
                case "2":
                    title = "曲库";
                    fragment = new MusicLibraryFragment();
                    break;
                case "3":
                    title = "电台";
                    fragment = new MusicDjFragment();
                    break;
                default:
                    fragment = new MusicSingerFragment();
                    break;
            }
            titleTv.setText(title);
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_container, fragment);
            fragmentTransaction.commit();
        }
    }


    @OnClick({R.id.title_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }

}
