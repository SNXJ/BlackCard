package com.zsh.blackcard.model;

/**
 * Name: MusicLrcModel
 * Author: SNXJ
 * Date: 2017-12-11
 * Description:描述：
 */
public class MusicLrcModel {


    private String result;
    private PdBean pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PdBean getPd() {
        return pd;
    }

    public void setPd(PdBean pd) {
        this.pd = pd;
    }

    public static class PdBean {
        /**
         * lrcContent : 专辑名称：一整片天空
         专辑编号：RD1781


         10. 多美好
         MYIC10615010

         词曲 易桀齐

         你要不要 和我到处去流浪
         噢要不要 和我好好爱一趟
         我要和你分享 噢那些成真的梦想
         到时你也在身旁 多美好

         怎么可能忘得掉
         你发自内心的笑
         好久没这样心跳
         想大声叫
         如果你也意识到
         就让我送你回家
         这样好不好？

         口袋的钱不重要
         我愿意为你花掉
         你要有什么烦恼 我第一时间到
         如果你少了安全感
         不说可能不知道 我吃苦也耐劳

         你要不要 和我到处去流浪
         你要不要 和我好好爱一趟
         我要和你分享 噢那些成真的梦想
         到时你也在身旁 多美好

         希望你可以明了
         我这点非分之想
         因为你是我想要的那种模样
         如果你也感觉到
         赶快说给我知道
         我们来拍张照

         你要不要 和我到处去流浪
         你要不要 和我好好爱一趟
         我要和你分享 噢那些成真的梦想
         到时你也在身旁 多美好


         OP:Universal Music Publishing Ltd., Taiwan
         * title : 多美好
         */

        private String lrcContent;
        private String title;

        public String getLrcContent() {
            return lrcContent;
        }

        public void setLrcContent(String lrcContent) {
            this.lrcContent = lrcContent;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
