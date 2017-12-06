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
     * pd : [{"PAGEVIEWS":1100,"TITLE":"精选","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/381bf1ef262c416fbb274bc0a1853f04.mp4","imageList":[{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/f6a97c9f0dee46d3b49f6759e18eb06f.png","PAGEVIEWS":999,"CONTENT":"gadfads"},{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/bc75fecc85554459ab4554172fe931f3.png","PAGEVIEWS":123,"CONTENT":"what fuck"}],"DISCOVERVIDEO_ID":"387644507509751808"},{"PAGEVIEWS":1200,"TITLE":"精选2","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/4ab3a86d37924412ae2c663888834f5c.mp4","imageList":[],"DISCOVERVIDEO_ID":"387662491246657536"},{"TITLE":"RNG","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/b39b2aa31e2b4d32a4cb048304bdbc99.mp4","imageList":[{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/b77dcbd23540464eaff4c0319e3143f6.jpg","CONTENT":"纳尔扎扎"},{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/043df76989704ff2886c5e3db4387370.png","CONTENT":"提姆队长"}],"DISCOVERVIDEO_ID":"387978745178226688"},{"TITLE":"WE","SHOWVIDEO":"http://47.104.16.215:8088/discover/video/a485bd798a124e2bbd5531abdd5e15cf.mp4","imageList":[{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/75dd12e23a4d4fd08a4f43e386014527.jpg","CONTENT":"瑞文"},{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/8329c33cca9e477f8103fd1b456d9671.jpg","CONTENT":"亚索"}],"DISCOVERVIDEO_ID":"387979063140024320"}]
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
         * PAGEVIEWS : 1100
         * TITLE : 精选
         * SHOWVIDEO : http://47.104.16.215:8088/discover/video/381bf1ef262c416fbb274bc0a1853f04.mp4
         * imageList : [{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/f6a97c9f0dee46d3b49f6759e18eb06f.png","PAGEVIEWS":999,"CONTENT":"gadfads"},{"SHOWIMAGE":"http://47.104.16.215:8088/discover/showimgs/bc75fecc85554459ab4554172fe931f3.png","PAGEVIEWS":123,"CONTENT":"what fuck"}]
         * DISCOVERVIDEO_ID : 387644507509751808
         */

        private int PAGEVIEWS;
        private String TITLE;
        private String SHOWVIDEO;
        private String DISCOVERVIDEO_ID;
        private List<ImageListBean> imageList;

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

        public String getDISCOVERVIDEO_ID() {
            return DISCOVERVIDEO_ID;
        }

        public void setDISCOVERVIDEO_ID(String DISCOVERVIDEO_ID) {
            this.DISCOVERVIDEO_ID = DISCOVERVIDEO_ID;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
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

        public static class ImageListBean {
            /**
             * SHOWIMAGE : http://47.104.16.215:8088/discover/showimgs/f6a97c9f0dee46d3b49f6759e18eb06f.png
             * PAGEVIEWS : 999
             * CONTENT : gadfads
             */

            private String SHOWIMAGE;
            private int PAGEVIEWS;
            private String CONTENT;

            public String getSHOWIMAGE() {
                return SHOWIMAGE;
            }

            public void setSHOWIMAGE(String SHOWIMAGE) {
                this.SHOWIMAGE = SHOWIMAGE;
            }

            public int getPAGEVIEWS() {
                return PAGEVIEWS;
            }

            public void setPAGEVIEWS(int PAGEVIEWS) {
                this.PAGEVIEWS = PAGEVIEWS;
            }

            public String getCONTENT() {
                return CONTENT;
            }

            public void setCONTENT(String CONTENT) {
                this.CONTENT = CONTENT;
            }
        }
    }
}
