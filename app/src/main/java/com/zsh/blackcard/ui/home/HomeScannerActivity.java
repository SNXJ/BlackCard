package com.zsh.blackcard.ui.home;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.google.zxing.Result;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.URIParsedResult;
import com.mylhyl.zxing.scanner.OnScannerCompletionListener;
import com.mylhyl.zxing.scanner.ScannerView;
import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.untils.ActivityUtils;
import com.zsh.blackcard.untils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Name: HomeScannerActivity
 * Author: SNXJ
 * Date: 2017-12-05
 * Description:描述：
 */
public class HomeScannerActivity extends BaseActivity {
    @BindView(R.id.scanner_view)
    ScannerView mScannerView;
    @BindView(R.id.im_back)
    ImageView imBack;

    @Override
    protected void onResume() {
        mScannerView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mScannerView.onPause();

        super.onPause();
    }

    @Override
    protected void initUI() {
        setContentView(R.layout.home_pop_scanner);
        ButterKnife.bind(this);
        mScannerView.setOnScannerCompletionListener(listenter);
    }

    OnScannerCompletionListener listenter = new OnScannerCompletionListener() {
        @Override
        public void OnScannerCompletion(Result rawResult, ParsedResult parsedResult, Bitmap barcode) {
            Result rawResulttemp = rawResult;
            ParsedResultType type = parsedResult.getType();
            switch (type) {
                case ADDRESSBOOK:
                    AddressBookParsedResult addressBook = (AddressBookParsedResult) parsedResult;
                    UIUtils.showToast(addressBook.getNames().toString());
                    break;
                case URI:
                    URIParsedResult uriParsedResult = (URIParsedResult) parsedResult;
                    ActivityUtils.startActivityForData(HomeScannerActivity.this, HomeScannerWebViewAvyivity.class, uriParsedResult.getURI());
                    break;
                case TEXT:
                    UIUtils.showToast(rawResult.getText());
                    ActivityUtils.startActivityForData(HomeScannerActivity.this, HomeScannerWebViewAvyivity.class, rawResult.getText());
                    break;
            }
        }
    };

    @OnClick(R.id.im_back)
    public void onClick() {
        finish();
    }
}
