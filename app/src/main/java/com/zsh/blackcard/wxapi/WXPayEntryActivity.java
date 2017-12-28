package com.zsh.blackcard.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * Name: WXPayEntryActivity
 * Author: Shing
 * Date: 17/12/28 下午2:41
 * Description: ..
 */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;

    private Button gotoBtn, regBtn, launchBtn, checkBtn, scanBtn;

    // IWXAPI 是第三方app和微信通信的openapi接口
    private IWXAPI api;



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
        api.handleIntent(intent, this);
    }

    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq req) {
        switch (req.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:
//                goToGetMsg();
                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
//                goToShowMsg((ShowMessageFromWX.Req) req);
                break;
            default:
                break;
        }
    }

    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    @Override
    public void onResp(BaseResp resp) {
        int result = 0;

        Toast.makeText(this, "baseresp.getType = " + resp.getType(), Toast.LENGTH_SHORT).show();

        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
//                result = R.string.errcode_success;
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
//                result = R.string.errcode_cancel;
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
//                result = R.string.errcode_deny;
                break;
            case BaseResp.ErrCode.ERR_UNSUPPORT:
//                result = R.string.errcode_unsupported;
                break;
            default:
//                result = R.string.errcode_unknown;
                break;
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }

//
}