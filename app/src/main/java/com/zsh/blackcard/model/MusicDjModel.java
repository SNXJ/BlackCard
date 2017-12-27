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
     * pd : {"result":{"channellist":[{"thumb":"http://47.104.16.215:8088/musicimgs/categorylistimgs/music_image_42@2x.png","name":"SuperCool","cate_name":"yuzhong","cate_sname":"语种频道","ch_name":"public_yuzhong_oumei","PRECOUNTOUT":1,"value":8,"channelid":"33"}]}}
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
        /**
         * result : {"channellist":[{"thumb":"http://47.104.16.215:8088/musicimgs/categorylistimgs/music_image_42@2x.png","name":"SuperCool","cate_name":"yuzhong","cate_sname":"语种频道","ch_name":"public_yuzhong_oumei","PRECOUNTOUT":1,"value":8,"channelid":"33"}]}
         */

        private ResultBean result;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public static class ResultBean {
            private List<ChannellistBean> channellist;

            public List<ChannellistBean> getChannellist() {
                return channellist;
            }

            public void setChannellist(List<ChannellistBean> channellist) {
                this.channellist = channellist;
            }

            public static class ChannellistBean {
                /**
                 * thumb : http://47.104.16.215:8088/musicimgs/categorylistimgs/music_image_42@2x.png
                 * name : SuperCool
                 * cate_name : yuzhong
                 * cate_sname : 语种频道
                 * ch_name : public_yuzhong_oumei
                 * PRECOUNTOUT : 1
                 * value : 8
                 * channelid : 33
                 */

                private String thumb;
                private String name;
                private String cate_name;
                private String cate_sname;
                private String ch_name;
                private int PRECOUNTOUT;
                private int value;
                private String channelid;

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

                public String getCh_name() {
                    return ch_name;
                }

                public void setCh_name(String ch_name) {
                    this.ch_name = ch_name;
                }

                public int getPRECOUNTOUT() {
                    return PRECOUNTOUT;
                }

                public void setPRECOUNTOUT(int PRECOUNTOUT) {
                    this.PRECOUNTOUT = PRECOUNTOUT;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getChannelid() {
                    return channelid;
                }

                public void setChannelid(String channelid) {
                    this.channelid = channelid;
                }
            }
        }
    }
}
