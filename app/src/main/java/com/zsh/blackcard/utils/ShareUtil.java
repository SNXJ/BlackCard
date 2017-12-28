package com.zsh.blackcard.utils;

/**
 * @author SXJ
 * @date 2016-9-18 上午10:13:13
 * @description Umeng分享
 */
public class ShareUtil {
//    private static String shareTitle;
//    private static String descContent;
//    private static String lineLink;
//    private static UMShareListener umShareListener;
//    private static Context context;
//    private static ShareResultListener shareResultListener;
//
//    public static void initShare(Context thisContext) {
//        context = thisContext;
//        Config.isloadUrl = true;// 回流统计
//        initListener();
//        Config.dialog = PublicLoadingUtils.createLoadingDialog(context,
//                "分享跳转中...");
//    }
//
//    /**
//     * UM分享activity的onActivityResult调用
//     *
//     * @param requestCode
//     * @param resultCode
//     * @param data
//     */
//    public static void onUmActivityResult(int requestCode, int resultCode,
//                                          Intent data) {
//        UMShareAPI.get(context).onActivityResult(requestCode, resultCode, data);
//    }
//
////	***********************以上两个方法必须调用  方可调用以下分享*******************************
//
//    /**
//     * 分享发单
//     *
//     * @param billId
//     * @param shareSuccesListener
//     */
//    public static void shareSellBill(String billId,
//                                     ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
////		shareTitle = context.getResources()
////				.getString(R.string.share_sell_title);
//        descContent = context.getResources().getString(
//                R.string.share_sell_content);
//        shareTitle = context.getResources().getString(
//                R.string.share_sell_content);
//        lineLink = NetApi.BILL_SHARE + "billid=" + billId;
//        toshare();
//    }
//
//    /**
//     * umeng分享买单
//     */
//    public static void shareBuyBill(String billId,
//                                    ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
//        //shareTitle = context.getResources().getString(R.string.share_buy_title);
//        descContent = context.getResources().getString(
//                R.string.share_buy_content);
//        shareTitle = context.getResources().getString(
//                R.string.share_buy_content);
//        lineLink = NetApi.BILL_SHARE + "billid=" + billId;
//        toshare();
//    }
//
//    /**
//     * umeng分享买单
//     */
//    public static void shareTimerBuy(String billId,
//                                     ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
//        descContent = context.getResources().getString(
//                R.string.share_timer_buy);
//        shareTitle = context.getResources().getString(
//                R.string.share_timer_buy);
//        lineLink = NetApi.BILL_SHARE + "billid=" + billId;
//        toshare();
//    }
//
//    /**
//     * 学历贷分享
//     */
//    public static void shareLoanEducation(String phone,
//                                          ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
//        //shareTitle = context.getResources().getString(R.string.share_buy_title);
//        descContent = context.getResources().getString(
//                R.string.share_loan_education_title);
//        shareTitle = context.getResources().getString(
//                R.string.share_loan_education_title);
//        lineLink = NetApi.LOAN_EDUCATION + "s=" + phone;
//        toshare();
//    }
//
//    /**
//     * 提现分享
//     *
//     * @param billId
//     * @param shareSuccesListener
//     */
//    public static void shareWithdraw(String money,
//                                     ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
////		shareTitle = context.getResources().getString(
////				R.string.share_withdraw_title);
//        String content = context.getResources().getString(
//                R.string.share_withdraw_content);
//        shareTitle = String.format(content, money);
//        descContent = String.format(content, money);
//        lineLink = NetApi.ACCOUNT_WITHDRAW;
//        toshare();
//    }
//
//    /**
//     * 邀请注册分享
//     *
//     * @param ImageUrl URL
//     */
//    public static void shareInvite(String ImageUrl) {
////		shareTitle = context.getResources().getString(
////				R.string.share_invite_title);
//        descContent = context.getResources().getString(
//                R.string.share_invite_content);
//        shareTitle = context.getResources().getString(
//                R.string.share_invite_content);
//        lineLink = ImageUrl;
//        toshare();
//
//    }
//
//    /**
//     * 公共分享
//     *
//     * @param billId
//     * @param shareSuccesListener
//     */
//    public static void sharePublic(String billId,
//                                   ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
//        shareTitle = context.getResources().getString(
//                R.string.share_public_title);
//        descContent = context.getResources().getString(
//                R.string.share_public_content);
//        lineLink = NetApi.SERVER_URL;
//        toshare();
//    }
//
//    /**
//     * 分享朋友圈 成功 回调处理
//     *
//     * @param shareSuccesListener
//     */
//    public static void setShareResultListener(
//            ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
//    }
//
//    private static void toshare() {
//        UMImage image = new UMImage(context, BitmapFactory.decodeResource(
//                context.getResources(), R.drawable.logo_text));
//        final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]{
//                SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,};
//        new ShareAction((Activity) context).setDisplayList(displaylist)
//                .withTitle(descContent)
//                .withText("www.qiandaowei.com")
//                .withTargetUrl(lineLink).withMedia(image)
//                .setListenerList(umShareListener).open();
//    }
//
//    /**
//     * uMeng回调
//     */
//    private static void initListener() {
//        umShareListener = new UMShareListener() {
//            @Override
//            public void onResult(SHARE_MEDIA platform) {
//                Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
//                if ("WEIXIN_CIRCLE".equals(platform.toString())) {
//                    if (null != shareResultListener) {
//                        shareResultListener.ShareResult();
//                    }
//                }
//            }
//
//            @Override
//            public void onError(SHARE_MEDIA platform, Throwable t) {
//                Toast.makeText(context, "分享失败", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancel(SHARE_MEDIA platform) {
//                Toast.makeText(context, "分享取消", Toast.LENGTH_SHORT).show();
//            }
//        };
//    }
//
//    /**
//     * umeng分享整点抢单
//     */
//    public static void shareTimmerLootBill(String url,
//                                           ShareResultListener shareSuccesListener) {
//        shareResultListener = shareSuccesListener;
//        //shareTitle = context.getResources().getString(R.string.share_buy_title);
//        descContent = context.getResources().getString(
//                R.string.share_timmer_loot_bill);
//        shareTitle = context.getResources().getString(
//                R.string.share_timmer_loot_bill);
//        lineLink = url;
//        toshare();
//    }
}
