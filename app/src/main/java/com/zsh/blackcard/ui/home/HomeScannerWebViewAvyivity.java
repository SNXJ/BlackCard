package com.zsh.blackcard.ui.home;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: HomeScannerWebViewAvyivity
 * Author: SNXJ
 * Date: 2017-12-05
 * Description:描述：
 */
public class HomeScannerWebViewAvyivity extends BaseActivity {

    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.scanner_web_view)
    WebView scannerWebView;
    @BindView(R.id.tv_text)
    TextView tvText;
    String str;

    @Override
    protected void initUI() {
        setContentView(R.layout.home_pop_scanner_webview);
        ButterKnife.bind(this);
        str = getIntent().getStringExtra("data");
        if (str.startsWith("http") || str.startsWith("www.")) {
            tvText.setVisibility(View.GONE);
            scannerWebView.setVisibility(View.VISIBLE);
            initWebview();
        } else {
            scannerWebView.setVisibility(View.GONE);
            tvText.setVisibility(View.VISIBLE);
            tvText.setText(str);
        }

    }

    private void initWebview() {
        scannerWebView.loadUrl(str);
        scannerWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @OnClick(R.id.im_back)
    public void onClick() {
        finish();
    }

}
