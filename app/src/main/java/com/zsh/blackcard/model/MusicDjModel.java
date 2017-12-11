package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: MusicDjModel
 * Author: SNXJ
 * Date: 2017-12-08
 * Description:描述：
 */
public class MusicDjModel {


    /**
     * result : 01
     * pd : {"result":[{"title":"公共频道","cid":1,"channellist":[{"name":"漫步春天","channelid":"62","thumb":"http://a.hiphotos.baidu.com/ting/pic/item/838ba61ea8d3fd1fb4912e42354e251f95ca5f2a.jpg","ch_name":"public_tuijian_spring","value":1000000,"cate_name":"tuijian","cate_sname":"推荐频道"},{"name":"秋日私语","channelid":"63","thumb":"http://c.hiphotos.baidu.com/ting/pic/item/b3119313b07eca80b93485cf932397dda14483e1.jpg","ch_name":"public_tuijian_autumn","value":1000000,"cate_name":"tuijian","cate_sname":"推荐频道"}]}]}
     */

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
        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * title : 公共频道
             * cid : 1.0
             * channellist : [{"name":"漫步春天","channelid":"62","thumb":"http://a.hiphotos.baidu.com/ting/pic/item/838ba61ea8d3fd1fb4912e42354e251f95ca5f2a.jpg","ch_name":"public_tuijian_spring","value":1000000,"cate_name":"tuijian","cate_sname":"推荐频道"},{"name":"秋日私语","channelid":"63","thumb":"http://c.hiphotos.baidu.com/ting/pic/item/b3119313b07eca80b93485cf932397dda14483e1.jpg","ch_name":"public_tuijian_autumn","value":1000000,"cate_name":"tuijian","cate_sname":"推荐频道"}]
             */

            private String title;
            private double cid;
            private List<ChannellistBean> channellist;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getCid() {
                return cid;
            }

            public void setCid(double cid) {
                this.cid = cid;
            }

            public List<ChannellistBean> getChannellist() {
                return channellist;
            }

            public void setChannellist(List<ChannellistBean> channellist) {
                this.channellist = channellist;
            }

            public static class ChannellistBean {
                /**
                 * name : 漫步春天
                 * channelid : 62
                 * thumb : http://a.hiphotos.baidu.com/ting/pic/item/838ba61ea8d3fd1fb4912e42354e251f95ca5f2a.jpg
                 * ch_name : public_tuijian_spring
                 * value : 1000000.0
                 * cate_name : tuijian
                 * cate_sname : 推荐频道
                 */

                private String name;
                private String channelid;
                private String thumb;
                private String ch_name;
                private double value;
                private String cate_name;
                private String cate_sname;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getChannelid() {
                    return channelid;
                }

                public void setChannelid(String channelid) {
                    this.channelid = channelid;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getCh_name() {
                    return ch_name;
                }

                public void setCh_name(String ch_name) {
                    this.ch_name = ch_name;
                }

                public double getValue() {
                    return value;
                }

                public void setValue(double value) {
                    this.value = value;
                }

                public String getCate_name() {
                    return cate_name;
                }

                public void setCate_name(String cate_name) {
                    this.cate_name = cate_name;
                }

                public String getCate_sname() {
                    return cate_sname;
                }

                public void setCate_sname(String cate_sname) {
                    this.cate_sname = cate_sname;
                }
            }
        }
    }
}
