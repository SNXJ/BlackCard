package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by kkkkk on 2017/12/6.
 * 尊购发现条目对应列表
 */

public class ZgFindModel {

    /**
     * result : 01
     * pd : [{"PAGEVIEWS":54646,"TITLE":"SKT","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/17aef8b54d864181964d5b11bfafd5f6.mp4","VIDEOBACKIMAGE":"http://47.104.16.215:8088/discover/videobackimg/3a620e5341b8411b9bf8630d098413fd.png","DISCOVERVIDEO_ID":"388057282547548160"},{"PAGEVIEWS":455454,"TITLE":"图片2","SHOWVIDEO":"","VIDEOBACKIMAGE":"http://47.104.16.215:8088/discover/videobackimg/f6eabf0df8a94341912884431796413d.png","DISCOVERVIDEO_ID":"388057034525769728"},{"PAGEVIEWS":4564,"TITLE":"图片1","SHOWVIDEO":"","VIDEOBACKIMAGE":"http://47.104.16.215:8088/discover/videobackimg/e56b1f717c0d49fabb54b368873f31a5.png","DISCOVERVIDEO_ID":"388056869672845312"},{"PAGEVIEWS":2222,"TITLE":"WE","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/a485bd798a124e2bbd5531abdd5e15cf.mp4","VIDEOBACKIMAGE":"http://47.104.16.215:8088/discover/videobackimg/3a02fe6116344e0e906495001109ec0b.jpg","DISCOVERVIDEO_ID":"387979063140024320"},{"PAGEVIEWS":1111,"TITLE":"RNG","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/b39b2aa31e2b4d32a4cb048304bdbc99.mp4","VIDEOBACKIMAGE":"http://47.104.16.215:8088/discover/videobackimg/e4c659458b5f498194bc6fe3b4caee99.jpg","DISCOVERVIDEO_ID":"387978745178226688"},{"PAGEVIEWS":1200,"TITLE":"精选2","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/4ab3a86d37924412ae2c663888834f5c.mp4","VIDEOBACKIMAGE":"http://47.104.16.215:8088/discover/videobackimg/c52781b49f8f4652b3bb8c4e8c57befd.png","DISCOVERVIDEO_ID":"387662491246657536"}]
     */

    private String result;
    private List<PdBean> pd;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PdBean> getPd() {
        return pd;
    }

    public void setPd(List<PdBean> pd) {
        this.pd = pd;
    }

    public static class PdBean implements MultiItemEntity {
        /**
         * PAGEVIEWS : 54646
         * TITLE : SKT
         * SHOWVIDEO : http://47.104.16.215:8088/discover/video/17aef8b54d864181964d5b11bfafd5f6.mp4
         * VIDEOBACKIMAGE : http://47.104.16.215:8088/discover/videobackimg/3a620e5341b8411b9bf8630d098413fd.png
         * DISCOVERVIDEO_ID : 388057282547548160
         */

        private int PAGEVIEWS;
        private String TITLE;
        private String SHOWVIDEO;
        private String VIDEOBACKIMAGE;
        private String DISCOVERVIDEO_ID;

        public int getPAGEVIEWS() {
            return PAGEVIEWS;
        }

        public void setPAGEVIEWS(int PAGEVIEWS) {
            this.PAGEVIEWS = PAGEVIEWS;
        }

        public String getTITLE() {
            return TITLE;
        }

        public void setTITLE(String TITLE) {
            this.TITLE = TITLE;
        }

        public String getSHOWVIDEO() {
            return SHOWVIDEO;
        }

        public void setSHOWVIDEO(String SHOWVIDEO) {
            this.SHOWVIDEO = SHOWVIDEO;
        }

        public String getVIDEOBACKIMAGE() {
            return VIDEOBACKIMAGE;
        }

        public void setVIDEOBACKIMAGE(String VIDEOBACKIMAGE) {
            this.VIDEOBACKIMAGE = VIDEOBACKIMAGE;
        }

        public String getDISCOVERVIDEO_ID() {
            return DISCOVERVIDEO_ID;
        }

        public void setDISCOVERVIDEO_ID(String DISCOVERVIDEO_ID) {
            this.DISCOVERVIDEO_ID = DISCOVERVIDEO_ID;
        }

        public static final int VIDEO = 1;
        public static final int IMAGE = 2;

        public int itemType;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
