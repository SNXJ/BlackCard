package com.zsh.blackcard.model;

import java.io.Serializable;
import java.util.List;

/**
 * Name: MusicRecommendModel
 * Author: SNXJ
 * Date: 2017-12-07
 * Description:描述：
 */
public class MusicRecommendModel implements Serializable {
    /**
     * result : 01
     * pd : {"result":{"list":[{"artist_id":"1665","all_artist_id":"1665","all_artist_ting_uid":"2611","language":"国语","publishtime":"2017-11-15","album_no":"1","toneid":"0","all_rate":"64,128,256,320,flac","pic_small":"http://musicdata.baidu.com/data2/pic/824e2ead1f083eba4d9ef79416973217/566307538/566307538.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/824e2ead1f083eba4d9ef79416973217/566307538/566307538.jpg@s_1,w_150,h_150","hot":"42125","has_mv_mobile":0,"versions":"","bitrate_fee":"{\"0\":\"0|0\",\"1\":\"0|0\"}","del_status":"0","info":"","has_filmtv":"0","biaoshi":"lossless","file_duration":"261","song_id":"566307540","title":"嗜睡症","ting_uid":"2611","author":"刘惜君","album_id":"566307536","album_title":"嗜睡症","is_first_publish":0,"havehigh":2,"charge":0,"has_mv":0,"learn":0,"song_source":"web","piao_id":"0","korean_bb_song":"0","resource_type_ext":"0","mv_provider":"0000000000"}]}}
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

    public static class PdBean implements Serializable {
        /**
         * result : {"list":[{"artist_id":"1665","all_artist_id":"1665","all_artist_ting_uid":"2611","language":"国语","publishtime":"2017-11-15","album_no":"1","toneid":"0","all_rate":"64,128,256,320,flac","pic_small":"http://musicdata.baidu.com/data2/pic/824e2ead1f083eba4d9ef79416973217/566307538/566307538.jpg@s_1,w_90,h_90","pic_big":"http://musicdata.baidu.com/data2/pic/824e2ead1f083eba4d9ef79416973217/566307538/566307538.jpg@s_1,w_150,h_150","hot":"42125","has_mv_mobile":0,"versions":"","bitrate_fee":"{\"0\":\"0|0\",\"1\":\"0|0\"}","del_status":"0","info":"","has_filmtv":"0","biaoshi":"lossless","file_duration":"261","song_id":"566307540","title":"嗜睡症","ting_uid":"2611","author":"刘惜君","album_id":"566307536","album_title":"嗜睡症","is_first_publish":0,"havehigh":2,"charge":0,"has_mv":0,"learn":0,"song_source":"web","piao_id":"0","korean_bb_song":"0","resource_type_ext":"0","mv_provider":"0000000000"}]}
         */

        private ResultBean result;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public static class ResultBean implements Serializable {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean implements Serializable {
                /**
                 * artist_id : 1665
                 * all_artist_id : 1665
                 * all_artist_ting_uid : 2611
                 * language : 国语
                 * publishtime : 2017-11-15
                 * album_no : 1
                 * toneid : 0
                 * all_rate : 64,128,256,320,flac
                 * pic_small : http://musicdata.baidu.com/data2/pic/824e2ead1f083eba4d9ef79416973217/566307538/566307538.jpg@s_1,w_90,h_90
                 * pic_big : http://musicdata.baidu.com/data2/pic/824e2ead1f083eba4d9ef79416973217/566307538/566307538.jpg@s_1,w_150,h_150
                 * hot : 42125
                 * has_mv_mobile : 0.0
                 * versions :
                 * bitrate_fee : {"0":"0|0","1":"0|0"}
                 * del_status : 0
                 * info :
                 * has_filmtv : 0
                 * biaoshi : lossless
                 * file_duration : 261
                 * song_id : 566307540
                 * title : 嗜睡症
                 * ting_uid : 2611
                 * author : 刘惜君
                 * album_id : 566307536
                 * album_title : 嗜睡症
                 * is_first_publish : 0.0
                 * havehigh : 2.0
                 * charge : 0.0
                 * has_mv : 0.0
                 * learn : 0.0
                 * song_source : web
                 * piao_id : 0
                 * korean_bb_song : 0
                 * resource_type_ext : 0
                 * mv_provider : 0000000000
                 */

                private String artist_id;
                private String all_artist_id;
                private String all_artist_ting_uid;
                private String language;
                private String publishtime;
                private String album_no;
                private String toneid;
                private String all_rate;
                private String pic_small;
                private String pic_big;
                private String hot;
                private double has_mv_mobile;
                private String versions;
                private String bitrate_fee;
                private String del_status;
                private String info;
                private String has_filmtv;
                private String biaoshi;
                private String file_duration;
                private String song_id;
                private String title;
                private String ting_uid;
                private String author;
                private String album_id;
                private String album_title;
                private double is_first_publish;
                private double havehigh;
                private double charge;
                private double has_mv;
                private double learn;
                private String song_source;
                private String piao_id;
                private String korean_bb_song;
                private String resource_type_ext;
                private String mv_provider;

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

                public String getAll_artist_ting_uid() {
                    return all_artist_ting_uid;
                }

                public void setAll_artist_ting_uid(String all_artist_ting_uid) {
                    this.all_artist_ting_uid = all_artist_ting_uid;
                }

                public String getLanguage() {
                    return language;
                }

                public void setLanguage(String language) {
                    this.language = language;
                }

                public String getPublishtime() {
                    return publishtime;
                }

                public void setPublishtime(String publishtime) {
                    this.publishtime = publishtime;
                }

                public String getAlbum_no() {
                    return album_no;
                }

                public void setAlbum_no(String album_no) {
                    this.album_no = album_no;
                }

                public String getToneid() {
                    return toneid;
                }

                public void setToneid(String toneid) {
                    this.toneid = toneid;
                }

                public String getAll_rate() {
                    return all_rate;
                }

                public void setAll_rate(String all_rate) {
                    this.all_rate = all_rate;
                }

                public String getPic_small() {
                    return pic_small;
                }

                public void setPic_small(String pic_small) {
                    this.pic_small = pic_small;
                }

                public String getPic_big() {
                    return pic_big;
                }

                public void setPic_big(String pic_big) {
                    this.pic_big = pic_big;
                }

                public String getHot() {
                    return hot;
                }

                public void setHot(String hot) {
                    this.hot = hot;
                }

                public double getHas_mv_mobile() {
                    return has_mv_mobile;
                }

                public void setHas_mv_mobile(double has_mv_mobile) {
                    this.has_mv_mobile = has_mv_mobile;
                }

                public String getVersions() {
                    return versions;
                }

                public void setVersions(String versions) {
                    this.versions = versions;
                }

                public String getBitrate_fee() {
                    return bitrate_fee;
                }

                public void setBitrate_fee(String bitrate_fee) {
                    this.bitrate_fee = bitrate_fee;
                }

                public String getDel_status() {
                    return del_status;
                }

                public void setDel_status(String del_status) {
                    this.del_status = del_status;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getHas_filmtv() {
                    return has_filmtv;
                }

                public void setHas_filmtv(String has_filmtv) {
                    this.has_filmtv = has_filmtv;
                }

                public String getBiaoshi() {
                    return biaoshi;
                }

                public void setBiaoshi(String biaoshi) {
                    this.biaoshi = biaoshi;
                }

                public String getFile_duration() {
                    return file_duration;
                }

                public void setFile_duration(String file_duration) {
                    this.file_duration = file_duration;
                }

                public String getSong_id() {
                    return song_id;
                }

                public void setSong_id(String song_id) {
                    this.song_id = song_id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTing_uid() {
                    return ting_uid;
                }

                public void setTing_uid(String ting_uid) {
                    this.ting_uid = ting_uid;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getAlbum_id() {
                    return album_id;
                }

                public void setAlbum_id(String album_id) {
                    this.album_id = album_id;
                }

                public String getAlbum_title() {
                    return album_title;
                }

                public void setAlbum_title(String album_title) {
                    this.album_title = album_title;
                }

                public double getIs_first_publish() {
                    return is_first_publish;
                }

                public void setIs_first_publish(double is_first_publish) {
                    this.is_first_publish = is_first_publish;
                }

                public double getHavehigh() {
                    return havehigh;
                }

                public void setHavehigh(double havehigh) {
                    this.havehigh = havehigh;
                }

                public double getCharge() {
                    return charge;
                }

                public void setCharge(double charge) {
                    this.charge = charge;
                }

                public double getHas_mv() {
                    return has_mv;
                }

                public void setHas_mv(double has_mv) {
                    this.has_mv = has_mv;
                }

                public double getLearn() {
                    return learn;
                }

                public void setLearn(double learn) {
                    this.learn = learn;
                }

                public String getSong_source() {
                    return song_source;
                }

                public void setSong_source(String song_source) {
                    this.song_source = song_source;
                }

                public String getPiao_id() {
                    return piao_id;
                }

                public void setPiao_id(String piao_id) {
                    this.piao_id = piao_id;
                }

                public String getKorean_bb_song() {
                    return korean_bb_song;
                }

                public void setKorean_bb_song(String korean_bb_song) {
                    this.korean_bb_song = korean_bb_song;
                }

                public String getResource_type_ext() {
                    return resource_type_ext;
                }

                public void setResource_type_ext(String resource_type_ext) {
                    this.resource_type_ext = resource_type_ext;
                }

                public String getMv_provider() {
                    return mv_provider;
                }

                public void setMv_provider(String mv_provider) {
                    this.mv_provider = mv_provider;
                }
            }
        }
    }
}
