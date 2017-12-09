package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: MusicDetailListModel
 * Author: SNXJ
 * Date: 2017-12-07
 * Description:描述：
 */
public class MusicDetailListModel {
    /**
     * result : 01
     * pd : {"result":{"channel":"漫步春天","ch_name":"public_tuijian_spring","songlist":[{"songid":"7280636","title":"Shining Friends","artist":"冯曦妤","thumb":"http://qukufile2.qianqian.com/data2/music/A9E9A9D6253519F8E7CDD43A137D1DC4/252450136/252450136.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"1475","all_artist_id":"1475","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"5836173","title":"红蜻蜓","artist":"By2","thumb":"http://qukufile2.qianqian.com/data2/music/16C08DE9394E78BCD0C7CC661B23D566/252588681/252588681.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"903","all_artist_id":"903","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1741270","title":"春暖花开","artist":"伊能静","thumb":"http://qukufile2.qianqian.com/data2/pic/18de117a6c5e486bf4cc6a2a3d0e519c/557296531/557296531.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"220","all_artist_id":"220","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"630071","title":"小柠檬","artist":"郁可唯","thumb":"http://qukufile2.qianqian.com/data2/pic/88348603/88348603.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"1656","all_artist_id":"1656","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1174149","title":"Knock Knock","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/7bb01baaf6530fff3ce60db9f417267a/1174028/1174028.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"7490196","title":"Four Leaf Clover","artist":"Diana Vickers","thumb":"http://qukufile2.qianqian.com/data2/music/BC94BF647DAC41481F3EAEF777C158C1/252696110/252696110.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"34079","all_artist_id":"34079","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"238861","title":"Happy Tune","artist":"李心洁","thumb":"http://qukufile2.qianqian.com/data2/pic/42815702e978e2edc30ec9dd946a8319/62482/62482.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"210","all_artist_id":"210","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"8785643","title":"Sunny Came Home","artist":"Shawn Colvin","thumb":"http://qukufile2.qianqian.com/data2/pic/88811279/88811279.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"45363","all_artist_id":"45363","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"696666","title":"有你真好","artist":"易桀齐","thumb":"http://qukufile2.qianqian.com/data2/music/EF1DF29101E3BB0C09138560E2D88D38/252201586/252201586.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"931","all_artist_id":"931","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1174400","title":"The Show","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/7bb01baaf6530fff3ce60db9f417267a/1174028/1174028.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"thumb":"","method":0,"flow":0,"havehigh":0,"charge":0,"all_rate":""}]},"error_code":22000}
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
         * result : {"channel":"漫步春天","ch_name":"public_tuijian_spring","songlist":[{"songid":"7280636","title":"Shining Friends","artist":"冯曦妤","thumb":"http://qukufile2.qianqian.com/data2/music/A9E9A9D6253519F8E7CDD43A137D1DC4/252450136/252450136.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"1475","all_artist_id":"1475","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"5836173","title":"红蜻蜓","artist":"By2","thumb":"http://qukufile2.qianqian.com/data2/music/16C08DE9394E78BCD0C7CC661B23D566/252588681/252588681.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"903","all_artist_id":"903","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1741270","title":"春暖花开","artist":"伊能静","thumb":"http://qukufile2.qianqian.com/data2/pic/18de117a6c5e486bf4cc6a2a3d0e519c/557296531/557296531.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"220","all_artist_id":"220","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"630071","title":"小柠檬","artist":"郁可唯","thumb":"http://qukufile2.qianqian.com/data2/pic/88348603/88348603.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"1656","all_artist_id":"1656","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1174149","title":"Knock Knock","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/7bb01baaf6530fff3ce60db9f417267a/1174028/1174028.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"7490196","title":"Four Leaf Clover","artist":"Diana Vickers","thumb":"http://qukufile2.qianqian.com/data2/music/BC94BF647DAC41481F3EAEF777C158C1/252696110/252696110.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"34079","all_artist_id":"34079","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"238861","title":"Happy Tune","artist":"李心洁","thumb":"http://qukufile2.qianqian.com/data2/pic/42815702e978e2edc30ec9dd946a8319/62482/62482.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"210","all_artist_id":"210","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"8785643","title":"Sunny Came Home","artist":"Shawn Colvin","thumb":"http://qukufile2.qianqian.com/data2/pic/88811279/88811279.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"45363","all_artist_id":"45363","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"696666","title":"有你真好","artist":"易桀齐","thumb":"http://qukufile2.qianqian.com/data2/music/EF1DF29101E3BB0C09138560E2D88D38/252201586/252201586.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"931","all_artist_id":"931","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1174400","title":"The Show","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/7bb01baaf6530fff3ce60db9f417267a/1174028/1174028.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"thumb":"","method":0,"flow":0,"havehigh":0,"charge":0,"all_rate":""}]}
         * error_code : 22000
         */

        private ResultBean result;
        private int error_code;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public static class ResultBean {
            /**
             * channel : 漫步春天
             * ch_name : public_tuijian_spring
             * songlist : [{"songid":"7280636","title":"Shining Friends","artist":"冯曦妤","thumb":"http://qukufile2.qianqian.com/data2/music/A9E9A9D6253519F8E7CDD43A137D1DC4/252450136/252450136.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"1475","all_artist_id":"1475","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"5836173","title":"红蜻蜓","artist":"By2","thumb":"http://qukufile2.qianqian.com/data2/music/16C08DE9394E78BCD0C7CC661B23D566/252588681/252588681.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"903","all_artist_id":"903","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1741270","title":"春暖花开","artist":"伊能静","thumb":"http://qukufile2.qianqian.com/data2/pic/18de117a6c5e486bf4cc6a2a3d0e519c/557296531/557296531.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"220","all_artist_id":"220","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"630071","title":"小柠檬","artist":"郁可唯","thumb":"http://qukufile2.qianqian.com/data2/pic/88348603/88348603.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"1656","all_artist_id":"1656","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1174149","title":"Knock Knock","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/7bb01baaf6530fff3ce60db9f417267a/1174028/1174028.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"7490196","title":"Four Leaf Clover","artist":"Diana Vickers","thumb":"http://qukufile2.qianqian.com/data2/music/BC94BF647DAC41481F3EAEF777C158C1/252696110/252696110.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"34079","all_artist_id":"34079","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320"},{"songid":"238861","title":"Happy Tune","artist":"李心洁","thumb":"http://qukufile2.qianqian.com/data2/pic/42815702e978e2edc30ec9dd946a8319/62482/62482.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"210","all_artist_id":"210","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"8785643","title":"Sunny Came Home","artist":"Shawn Colvin","thumb":"http://qukufile2.qianqian.com/data2/pic/88811279/88811279.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"45363","all_artist_id":"45363","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"songid":"696666","title":"有你真好","artist":"易桀齐","thumb":"http://qukufile2.qianqian.com/data2/music/EF1DF29101E3BB0C09138560E2D88D38/252201586/252201586.jpg@s_0,w_90","method":0,"flow":0,"artist_id":"931","all_artist_id":"931","resource_type":"0","havehigh":2,"charge":0,"all_rate":"64,128,256,320,flac"},{"songid":"1174400","title":"The Show","artist":"Lenka","thumb":"http://qukufile2.qianqian.com/data2/pic/7bb01baaf6530fff3ce60db9f417267a/1174028/1174028.jpg@s_1,w_90,h_90","method":0,"flow":0,"artist_id":"1800","all_artist_id":"1800","resource_type":"0","havehigh":2,"charge":0,"all_rate":"24,64,128,192,256,320,flac"},{"thumb":"","method":0,"flow":0,"havehigh":0,"charge":0,"all_rate":""}]
             */

            private String channel;
            private String ch_name;
            private List<SonglistBean> songlist;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getCh_name() {
                return ch_name;
            }

            public void setCh_name(String ch_name) {
                this.ch_name = ch_name;
            }

            public List<SonglistBean> getSonglist() {
                return songlist;
            }

            public void setSonglist(List<SonglistBean> songlist) {
                this.songlist = songlist;
            }

            public static class SonglistBean {
                /**
                 * songid : 7280636
                 * title : Shining Friends
                 * artist : 冯曦妤
                 * thumb : http://qukufile2.qianqian.com/data2/music/A9E9A9D6253519F8E7CDD43A137D1DC4/252450136/252450136.jpg@s_0,w_90
                 * method : 0
                 * flow : 0
                 * artist_id : 1475
                 * all_artist_id : 1475
                 * resource_type : 0
                 * havehigh : 2
                 * charge : 0
                 * all_rate : 24,64,128,192,256,320,flac
                 */

                private String songid;
                private String title;
                private String artist;
                private String thumb;
                private int method;
                private int flow;
                private String artist_id;
                private String all_artist_id;
                private String resource_type;
                private int havehigh;
                private int charge;
                private String all_rate;

                public String getSongid() {
                    return songid;
                }

                public void setSongid(String songid) {
                    this.songid = songid;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getArtist() {
                    return artist;
                }

                public void setArtist(String artist) {
                    this.artist = artist;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public int getMethod() {
                    return method;
                }

                public void setMethod(int method) {
                    this.method = method;
                }

                public int getFlow() {
                    return flow;
                }

                public void setFlow(int flow) {
                    this.flow = flow;
                }

                public String getArtist_id() {
                    return artist_id;
                }

                public void setArtist_id(String artist_id) {
                    this.artist_id = artist_id;
                }

                public String getAll_artist_id() {
                    return all_artist_id;
                }

                public void setAll_artist_id(String all_artist_id) {
                    this.all_artist_id = all_artist_id;
                }

                public String getResource_type() {
                    return resource_type;
                }

                public void setResource_type(String resource_type) {
                    this.resource_type = resource_type;
                }

                public int getHavehigh() {
                    return havehigh;
                }

                public void setHavehigh(int havehigh) {
                    this.havehigh = havehigh;
                }

                public int getCharge() {
                    return charge;
                }

                public void setCharge(int charge) {
                    this.charge = charge;
                }

                public String getAll_rate() {
                    return all_rate;
                }

                public void setAll_rate(String all_rate) {
                    this.all_rate = all_rate;
                }
            }
        }
    }
}
