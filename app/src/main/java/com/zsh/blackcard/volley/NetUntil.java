package com.zsh.blackcard.volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.zsh.blackcard.untils.LogUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author Sheng XiaoJie .
 * @Date 2016/12/2
 * @describe *
 */

public class NetUntil {
    private static Context context;
    //定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
    private static volatile NetUntil mInstance;
    private DataRequester.Method netMethod = DataRequester.Method.POST;// 默认

    private NetUntil() {
    } //私有

    public static NetUntil newInstance(Context mContext) {
        context = mContext;
        if (mInstance == null) {
            synchronized (NetUntil.class) {
               // if (mInstance == null) {
                    mInstance = new NetUntil();
              //  }
            }
        }
        return mInstance;
    }

    /**
     * POST http
     *
     * @param <T>
     * @param url
     * @param paramsMap
     * @param clz              实体类
     * @param responseListener
     */

    public <T> void doPostHttp(String url, Map<String, String> paramsMap,
                                final Class<T> clz, final ResponseListener<T> responseListener) {
        netMethod = DataRequester.Method.POST;
        requestStrHTTP(url, paramsMap, clz, responseListener);
    }

    /**
     * GET http
     *
     * @param <T>
     * @param url
     * @param paramsMap
     * @param clz              实体类
     * @param responseListener
     */
    public <T> void doGetHttp(String url, Map<String, String> paramsMap,
                               final Class<T> clz, final ResponseListener<T> responseListener) {
        netMethod = DataRequester.Method.GET;
        requestStrHTTP(url, paramsMap, clz, responseListener);
    }

    /*********************************************
     * 只对外暴漏Https StringRequest的POST和GET方法
     *****************************************************************/
    public void doPostHttpsStr(String url, Map<String, String> paramsMap, final ResponseListener<?> responseListener) {
        netMethod = DataRequester.Method.POST;
    }

    /**
     * HTTPS String请求 默认证书
     *
     * @param <T>
     * @param url
     * @param paramsMap
     * @param clz
     * @param responseListener
     */

    private <T> void requestStrHTTPS(String url, Map<String, String> paramsMap,
                                     final Class<T> clz, final ResponseListener<T> responseListener) {
        DataRequester
                .withDefaultHttps()
                .setUrl(url)
                .setBody(paramsMap)
                .setMethod(netMethod)
                .setStringResponseListener(
                        new DataRequester.StringResponseListener() {
                            @SuppressWarnings("unchecked")
                            public void onResponse(String response) {
                                resultLog(response);
                                if (null == clz) {
                                    responseListener.responSuccess((T) response);

                                } else {
                                    responseListener.responSuccess(new GsonParser<T>().gsonString(response, clz));
                                }
                            }
                        })
                .setResponseErrorListener(
                        new DataRequester.ResponseErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(
                                        context,
                                        ErrorHelper.getErrorMsg(error, context),
                                        Toast.LENGTH_SHORT).show();
                                LogUtils.i(
                                        "++++++++",
                                        "errorCode="
                                                + ErrorHelper.getErrorMsg(
                                                error, context));
                            }
                        }).requestString();
    }

    /**
     * HTTPS JSON请求 默认证书
     *
     * @param <T>
     * @param url
     * @param jsonBody
     * @param clz
     * @param responseListener
     */
    @SuppressWarnings("unused")
    private <T> void requestJsonHTTPS(String url, JSONObject jsonBody,
                                      final Class<T> clz, final ResponseListener<T> responseListener) {
        DataRequester
                .withDefaultHttps()
                .setUrl(url)
                .setBody(jsonBody)
                .setMethod(netMethod)
                .setJsonResponseListener(
                        new DataRequester.JsonResponseListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                responseListener.responSuccess(new GsonParser<T>()
                                        .gsonJson(response, clz));
                                resultLog(response.toString());

                            }
                        })
                .setResponseErrorListener(
                        new DataRequester.ResponseErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //	responseListener.resonError(error);
                                LogUtils.i(
                                        "++++++++",
                                        "errorCode="
                                                + ErrorHelper.getErrorMsg(
                                                error, context));
                            }
                        }).requestJson();
    }

    /**
     * HTTPS JSONArray请求 默认证书
     *
     * @param <T>
     * @param url
     * @param paramsMap
     * @param clz
     * @param responseListener
     */
    @SuppressWarnings("unused")
    private <T> void requestJsonArrayHTTPS(String url,
                                           Map<String, String> paramsMap, final Class<T> clz,
                                           final ResponseListener<List<T>> responseListener) {
        DataRequester
                .withDefaultHttps()
                .setUrl(url)
                .setBody(paramsMap)
                .setJsonArrayResponseListener(
                        new DataRequester.JsonArrayResponseListener() {
                            @Override
                            public void onResponse(JSONArray response) {
                                responseListener.responSuccess(new GsonParser<T>()
                                        .gsonJsonArray(response, clz));
                            }
                        })
                .setResponseErrorListener(
                        new DataRequester.ResponseErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                LogUtils.i(
                                        "+++++++++++++++++",
                                        "errorCode="
                                                + ErrorHelper.getErrorMsg(
                                                error, context));
                            }
                        }).requestJsonArray();
    }

    /**
     * http String请求
     *
     * @param <T>
     * @param url
     * @param paramsMap
     * @param clz
     * @param responseListener
     */
    @SuppressWarnings("unused")
    private <T> void requestStrHTTP(String url, Map<String, String> paramsMap,
                                    final Class<T> clz, final ResponseListener<T> responseListener) {
        DataRequester
                .withHttp()
                .setUrl(url)
                .setMethod(netMethod)
                .setBody(paramsMap)
                .setResponseErrorListener(
                        new DataRequester.ResponseErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //responseListener.resonError(error);
                                resultLog(error.toString());
                            }
                        })
                .setStringResponseListener(
                        new DataRequester.StringResponseListener() {
                            @Override
                            public void onResponse(String response) {
                                responseListener.responSuccess(new GsonParser<T>()
                                        .gsonString(response, clz));
                                resultLog(response);
                            }
                        }).requestString();
    }

    /**
     * HTTP JSON请求
     *
     * @param <T>
     * @param url
     * @param paramsMap
     * @param clz
     * @param responseListener
     */
    @SuppressWarnings("unused")
    private <T> void requestJsonHTTP(String url, Map<String, String> paramsMap,
                                     final Class<T> clz, final ResponseListener<T> responseListener) {
        DataRequester
                .withHttp()
                .setUrl(url)
                .setBody(paramsMap)
                .setResponseErrorListener(
                        new DataRequester.ResponseErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //responseListener.resonError(error);
                                resultLog(error.toString());
                            }
                        })
                .setJsonResponseListener(
                        new DataRequester.JsonResponseListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                responseListener.responSuccess(new GsonParser<T>().gsonJson(response, clz));
                                resultLog(response.toString());
                            }
                        }).requestJson();
    }

    /**
     * HTTP 获取图片
     *
     * @param iv
     * @param url
     * @param dafaultRes
     */
    public void requestImage(ImageView iv, String url, int dafaultRes) {
        DataRequester.withHttp().setUrl(url)
                .setMethod(DataRequester.Method.GET)
                // GET
                .setImageView(iv).setDafaultImage(dafaultRes)
                .setFailImage(dafaultRes).requestImage();
    }

    private void resultLog(String str) {
        LogUtils.i("++++++++", "Result=" + str);
    }

    /**
     * 是否能上网
     *
     * @param context
     * @return 是否能上网
     */
    public static boolean hasConnectedNetwork(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE); //"connectivity"
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * 获取用户ip地址
     *
     * @return
     */
 //   public static String getLocalIpAddress() {
//        try {
//
//            for (Enumeration<NetworkInterface> en = NetworkInterface
//
//                    .getNetworkInterfaces(); en.hasMoreElements();) {
//
//                NetworkInterface intf = en.nextElement();
//
//                for (Enumeration<InetAddress> ipAddr = intf.getInetAddresses(); ipAddr
//
//                        .hasMoreElements();) {
//
//                    InetAddress inetAddress = ipAddr.nextElement();
//                    // ipv4地址
//                    if (!inetAddress.isLoopbackAddress()
//                            && InetAddressUtils.isIPv4Address(inetAddress
//                            .getHostAddress())) {
//
//                        return inetAddress.getHostAddress();
//
//                    }
//
//                }
//
//            }
//
//        } catch (Exception ex) {
//
//        }
//        return "";

  //  }
}
