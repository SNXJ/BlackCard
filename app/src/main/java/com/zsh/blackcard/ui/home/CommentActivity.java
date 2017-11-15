package com.zsh.blackcard.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

/**
 * Name: CommentActivity
 * Author: SNXJ
 * Date: 2017-11-15
 * Description:评论列表：
 */
public class CommentActivity extends BaseActivity {
    TextView tv_go_comment;

    @Override
    protected void initUI() {
        setContentView(R.layout.comment_activity);

        findViewById(R.id.tv_go_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommentActivity.this, CommentEditActivity.class));
            }
        });
    }
}
