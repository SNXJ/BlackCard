package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: MusicSingerModel
 * Author: SNXJ
 * Date: 2017-12-08
 * Description:描述：
 */
public class MusicSingerModel {

    /**
     * result : 01
     * pd : {"noFirstChar":"","artist":[{"ting_uid":"1077","name":"陈奕迅","firstchar":"C","gender":"0","area":"1","country":"香港","avatar_big":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_240","avatar_middle":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_120","avatar_small":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_48","avatar_mini":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_20","albums_total":"68","songs_total":"1076","artist_id":"87"}]}
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
         * noFirstChar :
         * artist : [{"ting_uid":"1077","name":"陈奕迅","firstchar":"C","gender":"0","area":"1","country":"香港","avatar_big":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_240","avatar_middle":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_120","avatar_small":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_48","avatar_mini":"http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_20","albums_total":"68","songs_total":"1076","artist_id":"87"}]
         */

        private String noFirstChar;
        private List<ArtistBean> artist;

        public String getNoFirstChar() {
            return noFirstChar;
        }

        public void setNoFirstChar(String noFirstChar) {
            this.noFirstChar = noFirstChar;
        }

        public List<ArtistBean> getArtist() {
            return artist;
        }

        public void setArtist(List<ArtistBean> artist) {
            this.artist = artist;
        }

        public static class ArtistBean {
            /**
             * ting_uid : 1077
             * name : 陈奕迅
             * firstchar : C
             * gender : 0
             * area : 1
             * country : 香港
             * avatar_big : http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_240
             * avatar_middle : http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_120
             * avatar_small : http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_48
             * avatar_mini : http://qukufile2.qianqian.com/data2/pic/af739e0109798366b9419230be5253ce/541222074/541222074.jpg@s_0,w_20
             * albums_total : 68
             * songs_total : 1076
             * artist_id : 87
             */

            private String ting_uid;
            private String name;
            private String firstchar;
            private String gender;
            private String area;
            private String country;
            private String avatar_big;
            private String avatar_middle;
            private String avatar_small;
            private String avatar_mini;
            private String albums_total;
            private String songs_total;
            private String artist_id;

            public String getTing_uid() {
                return ting_uid;
            }

            public void setTing_uid(String ting_uid) {
                this.ting_uid = ting_uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFirstchar() {
                return firstchar;
            }

            public void setFirstchar(String firstchar) {
                this.firstchar = firstchar;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getAvatar_big() {
                return avatar_big;
            }

            public void setAvatar_big(String avatar_big) {
                this.avatar_big = avatar_big;
            }

            public String getAvatar_middle() {
                return avatar_middle;
            }

            public void setAvatar_middle(String avatar_middle) {
                this.avatar_middle = avatar_middle;
            }

            public String getAvatar_small() {
                return avatar_small;
            }

            public void setAvatar_small(String avatar_small) {
                this.avatar_small = avatar_small;
            }

            public String getAvatar_mini() {
                return avatar_mini;
            }

            public void setAvatar_mini(String avatar_mini) {
                this.avatar_mini = avatar_mini;
            }

            public String getAlbums_total() {
                return albums_total;
            }

            public void setAlbums_total(String albums_total) {
                this.albums_total = albums_total;
            }

            public String getSongs_total() {
                return songs_total;
            }

            public void setSongs_total(String songs_total) {
                this.songs_total = songs_total;
            }

            public String getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(String artist_id) {
                this.artist_id = artist_id;
            }
        }
    }
}
