package com.zsh.blackcard.model;

/**
 * Name: MusicSongDetailsModel
 * Author: SNXJ
 * Date: 2017-12-09
 * Description:描述：
 */
public class MusicSongDetailsModel {
    /**
     * result : 01
     * pd : {"error_code":22000,"bitrate":{"show_link":"http://zhangmenshiting.baidu.com/data2/music/42421112/42421112.mp3?xcode=4945410d15cb2b5c0c0d8753917afb85","free":1,"song_file_id":42421112,"file_size":2375734,"file_extension":"mp3","file_duration":296,"file_bitrate":64,"file_link":"http://yinyueshiting.baidu.com/data2/music/42421112/42421112.mp3?xcode=4945410d15cb2b5c0c0d8753917afb85","hash":"f2afc6f2bfbaef43f08a468d1be46987f2a929e7"},"songinfo":{"album_no":"5","piao_id":"0","resource_type_ext":"0","is_first_publish":0,"korean_bb_song":"0","toneid":"0","title":"Every Time I Close My Eyes","pic_huge":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_1000,h_1000","relate_status":"0","pic_big":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_150,h_150","song_source":"web","all_rate":"24,64,128,192,256,320,flac","song_id":"7997313","havehigh":2,"lrclink":{"lrcContent":"[ti:Everytime I Close My Eyes]\n[ar:Kenny G&Babyface&Mariah Carey]\n[al:The Day]\n\n[00:00.00]Babyface--Everytime I Close My Eyes\n[00:05.00]Saxophone:Kenny G\n[00:10.00]Background Vocal Arrangement:Mariah Carey\n[00:16.00]Girl, it's been a long, long time comin'\n[00:30.00]But I, I know that it's been worth the wait\n[00:43.00]It feels like springtime in winter\n[00:52.00]It feels like Christmas in June\n[00:59.00]It feels like heaven has opened up\n[01:06.00]its gates for me and you\n[01:10.00]And every time I close my eyes\n[01:14.00]I thank the lord that I've got you\n[01:20.00]And you've got me too\n[01:24.00]And every time I think of it\n[01:27.00]I pinch myself 'cause I don't believe it's true\n[01:34.00]That someone like you loves me too, yeah\n[01:50.00]Girl, I think that you're truly somethin'\n[01:59.00]Yes, you are, and you're every bit of a dream come true\n[02:14.00]With you baby, it never rains and it's no wonder\n[02:26.00]The sun always shines when I'm near you\n[02:33.00]It's just a blessing that I have found somebody like you\n[02:44.00]And every time I close my eyes\n[02:47.00]I thank the lord that I've got you\n[02:53.00]And you've got me too\n[02:57.00]And every time I think of it\n[03:00.00]I pinch myself 'cause I don't believe it's true\n[03:07.00]That someone like you loves me too, yeah\n[03:14.00]To think of all the nights I've cried myself to sleep\n[03:20.00]You really oughta know how much you mean to me\n[03:25.00]It's only right that you be in my life\n[03:30.00]Right here with me, oh baby, baby\n[03:59.00]And every time I close my eyes\n[04:04.00]I thank the lord that I've got you\n[04:11.00]And you've got me too\n[04:14.00]And every time I think of it\n[04:18.00]I pinch myself 'cause I don't believe it's true\n[04:24.00]That someone like you loves me too, yeah","title":"Every Time I Close My Eyes"},"pic_premium":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_500,h_500","special_type":0,"si_proxycompany":"深圳腾讯计算机系统有限公司索尼音乐","pic_radio":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_300,h_300","charge":0,"has_mv_mobile":0,"learn":0,"author":"Babyface,Kenny G,Mariah Carey,Shelia E.","all_artist_id":"630,315640,823,7997312","resource_type":"0","has_mv":0,"bitrate_fee":"{\"0\":\"129|-1\",\"1\":\"-1|-1\"}","pic_small":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_90,h_90","all_artist_ting_uid":"104684,176903,3944,232640279","artist_id":"630","play_type":0,"album_id":"7997093","copy_type":"0","ting_uid":"104684","album_title":"A Collection Of His Greatest Hits"}}
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
         * error_code : 22000
         * bitrate : {"show_link":"http://zhangmenshiting.baidu.com/data2/music/42421112/42421112.mp3?xcode=4945410d15cb2b5c0c0d8753917afb85","free":1,"song_file_id":42421112,"file_size":2375734,"file_extension":"mp3","file_duration":296,"file_bitrate":64,"file_link":"http://yinyueshiting.baidu.com/data2/music/42421112/42421112.mp3?xcode=4945410d15cb2b5c0c0d8753917afb85","hash":"f2afc6f2bfbaef43f08a468d1be46987f2a929e7"}
         * songinfo : {"album_no":"5","piao_id":"0","resource_type_ext":"0","is_first_publish":0,"korean_bb_song":"0","toneid":"0","title":"Every Time I Close My Eyes","pic_huge":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_1000,h_1000","relate_status":"0","pic_big":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_150,h_150","song_source":"web","all_rate":"24,64,128,192,256,320,flac","song_id":"7997313","havehigh":2,"lrclink":{"lrcContent":"[ti:Everytime I Close My Eyes]\n[ar:Kenny G&Babyface&Mariah Carey]\n[al:The Day]\n\n[00:00.00]Babyface--Everytime I Close My Eyes\n[00:05.00]Saxophone:Kenny G\n[00:10.00]Background Vocal Arrangement:Mariah Carey\n[00:16.00]Girl, it's been a long, long time comin'\n[00:30.00]But I, I know that it's been worth the wait\n[00:43.00]It feels like springtime in winter\n[00:52.00]It feels like Christmas in June\n[00:59.00]It feels like heaven has opened up\n[01:06.00]its gates for me and you\n[01:10.00]And every time I close my eyes\n[01:14.00]I thank the lord that I've got you\n[01:20.00]And you've got me too\n[01:24.00]And every time I think of it\n[01:27.00]I pinch myself 'cause I don't believe it's true\n[01:34.00]That someone like you loves me too, yeah\n[01:50.00]Girl, I think that you're truly somethin'\n[01:59.00]Yes, you are, and you're every bit of a dream come true\n[02:14.00]With you baby, it never rains and it's no wonder\n[02:26.00]The sun always shines when I'm near you\n[02:33.00]It's just a blessing that I have found somebody like you\n[02:44.00]And every time I close my eyes\n[02:47.00]I thank the lord that I've got you\n[02:53.00]And you've got me too\n[02:57.00]And every time I think of it\n[03:00.00]I pinch myself 'cause I don't believe it's true\n[03:07.00]That someone like you loves me too, yeah\n[03:14.00]To think of all the nights I've cried myself to sleep\n[03:20.00]You really oughta know how much you mean to me\n[03:25.00]It's only right that you be in my life\n[03:30.00]Right here with me, oh baby, baby\n[03:59.00]And every time I close my eyes\n[04:04.00]I thank the lord that I've got you\n[04:11.00]And you've got me too\n[04:14.00]And every time I think of it\n[04:18.00]I pinch myself 'cause I don't believe it's true\n[04:24.00]That someone like you loves me too, yeah","title":"Every Time I Close My Eyes"},"pic_premium":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_500,h_500","special_type":0,"si_proxycompany":"深圳腾讯计算机系统有限公司索尼音乐","pic_radio":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_300,h_300","charge":0,"has_mv_mobile":0,"learn":0,"author":"Babyface,Kenny G,Mariah Carey,Shelia E.","all_artist_id":"630,315640,823,7997312","resource_type":"0","has_mv":0,"bitrate_fee":"{\"0\":\"129|-1\",\"1\":\"-1|-1\"}","pic_small":"http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_90,h_90","all_artist_ting_uid":"104684,176903,3944,232640279","artist_id":"630","play_type":0,"album_id":"7997093","copy_type":"0","ting_uid":"104684","album_title":"A Collection Of His Greatest Hits"}
         */

        private int error_code;
        private BitrateBean bitrate;
        private SonginfoBean songinfo;

        public int getError_code() {
            return error_code;
        }

        public void setError_code(int error_code) {
            this.error_code = error_code;
        }

        public BitrateBean getBitrate() {
            return bitrate;
        }

        public void setBitrate(BitrateBean bitrate) {
            this.bitrate = bitrate;
        }

        public SonginfoBean getSonginfo() {
            return songinfo;
        }

        public void setSonginfo(SonginfoBean songinfo) {
            this.songinfo = songinfo;
        }

        public static class BitrateBean {
            /**
             * show_link : http://zhangmenshiting.baidu.com/data2/music/42421112/42421112.mp3?xcode=4945410d15cb2b5c0c0d8753917afb85
             * free : 1
             * song_file_id : 42421112
             * file_size : 2375734
             * file_extension : mp3
             * file_duration : 296
             * file_bitrate : 64
             * file_link : http://yinyueshiting.baidu.com/data2/music/42421112/42421112.mp3?xcode=4945410d15cb2b5c0c0d8753917afb85
             * hash : f2afc6f2bfbaef43f08a468d1be46987f2a929e7
             */

            private String show_link;
            private int free;
            private int song_file_id;
            private int file_size;
            private String file_extension;
            private int file_duration;
            private int file_bitrate;
            private String file_link;
            private String hash;

            public String getShow_link() {
                return show_link;
            }

            public void setShow_link(String show_link) {
                this.show_link = show_link;
            }

            public int getFree() {
                return free;
            }

            public void setFree(int free) {
                this.free = free;
            }

            public int getSong_file_id() {
                return song_file_id;
            }

            public void setSong_file_id(int song_file_id) {
                this.song_file_id = song_file_id;
            }

            public int getFile_size() {
                return file_size;
            }

            public void setFile_size(int file_size) {
                this.file_size = file_size;
            }

            public String getFile_extension() {
                return file_extension;
            }

            public void setFile_extension(String file_extension) {
                this.file_extension = file_extension;
            }

            public int getFile_duration() {
                return file_duration;
            }

            public void setFile_duration(int file_duration) {
                this.file_duration = file_duration;
            }

            public int getFile_bitrate() {
                return file_bitrate;
            }

            public void setFile_bitrate(int file_bitrate) {
                this.file_bitrate = file_bitrate;
            }

            public String getFile_link() {
                return file_link;
            }

            public void setFile_link(String file_link) {
                this.file_link = file_link;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }
        }

        public static class SonginfoBean {
            /**
             * album_no : 5
             * piao_id : 0
             * resource_type_ext : 0
             * is_first_publish : 0
             * korean_bb_song : 0
             * toneid : 0
             * title : Every Time I Close My Eyes
             * pic_huge : http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_1000,h_1000
             * relate_status : 0
             * pic_big : http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_150,h_150
             * song_source : web
             * all_rate : 24,64,128,192,256,320,flac
             * song_id : 7997313
             * havehigh : 2
             * lrclink : {"lrcContent":"[ti:Everytime I Close My Eyes]\n[ar:Kenny G&Babyface&Mariah Carey]\n[al:The Day]\n\n[00:00.00]Babyface--Everytime I Close My Eyes\n[00:05.00]Saxophone:Kenny G\n[00:10.00]Background Vocal Arrangement:Mariah Carey\n[00:16.00]Girl, it's been a long, long time comin'\n[00:30.00]But I, I know that it's been worth the wait\n[00:43.00]It feels like springtime in winter\n[00:52.00]It feels like Christmas in June\n[00:59.00]It feels like heaven has opened up\n[01:06.00]its gates for me and you\n[01:10.00]And every time I close my eyes\n[01:14.00]I thank the lord that I've got you\n[01:20.00]And you've got me too\n[01:24.00]And every time I think of it\n[01:27.00]I pinch myself 'cause I don't believe it's true\n[01:34.00]That someone like you loves me too, yeah\n[01:50.00]Girl, I think that you're truly somethin'\n[01:59.00]Yes, you are, and you're every bit of a dream come true\n[02:14.00]With you baby, it never rains and it's no wonder\n[02:26.00]The sun always shines when I'm near you\n[02:33.00]It's just a blessing that I have found somebody like you\n[02:44.00]And every time I close my eyes\n[02:47.00]I thank the lord that I've got you\n[02:53.00]And you've got me too\n[02:57.00]And every time I think of it\n[03:00.00]I pinch myself 'cause I don't believe it's true\n[03:07.00]That someone like you loves me too, yeah\n[03:14.00]To think of all the nights I've cried myself to sleep\n[03:20.00]You really oughta know how much you mean to me\n[03:25.00]It's only right that you be in my life\n[03:30.00]Right here with me, oh baby, baby\n[03:59.00]And every time I close my eyes\n[04:04.00]I thank the lord that I've got you\n[04:11.00]And you've got me too\n[04:14.00]And every time I think of it\n[04:18.00]I pinch myself 'cause I don't believe it's true\n[04:24.00]That someone like you loves me too, yeah","title":"Every Time I Close My Eyes"}
             * pic_premium : http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_500,h_500
             * special_type : 0
             * si_proxycompany : 深圳腾讯计算机系统有限公司索尼音乐
             * pic_radio : http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_300,h_300
             * charge : 0
             * has_mv_mobile : 0
             * learn : 0
             * author : Babyface,Kenny G,Mariah Carey,Shelia E.
             * all_artist_id : 630,315640,823,7997312
             * resource_type : 0
             * has_mv : 0
             * bitrate_fee : {"0":"129|-1","1":"-1|-1"}
             * pic_small : http://qukufile2.qianqian.com/data2/pic/c9e740ba532a428bf6235ad4400c5fc4/552854167/552854167.jpg@s_1,w_90,h_90
             * all_artist_ting_uid : 104684,176903,3944,232640279
             * artist_id : 630
             * play_type : 0
             * album_id : 7997093
             * copy_type : 0
             * ting_uid : 104684
             * album_title : A Collection Of His Greatest Hits
             */

            private String album_no;
            private String piao_id;
            private String resource_type_ext;
            private int is_first_publish;
            private String korean_bb_song;
            private String toneid;
            private String title;
            private String pic_huge;
            private String relate_status;
            private String pic_big;
            private String song_source;
            private String all_rate;
            private String song_id;
            private int havehigh;
            private LrclinkBean lrclink;
            private String pic_premium;
            private int special_type;
            private String si_proxycompany;
            private String pic_radio;
            private int charge;
            private int has_mv_mobile;
            private int learn;
            private String author;
            private String all_artist_id;
            private String resource_type;
            private int has_mv;
            private String bitrate_fee;
            private String pic_small;
            private String all_artist_ting_uid;
            private String artist_id;
            private int play_type;
            private String album_id;
            private String copy_type;
            private String ting_uid;
            private String album_title;

            public String getAlbum_no() {
                return album_no;
            }

            public void setAlbum_no(String album_no) {
                this.album_no = album_no;
            }

            public String getPiao_id() {
                return piao_id;
            }

            public void setPiao_id(String piao_id) {
                this.piao_id = piao_id;
            }

            public String getResource_type_ext() {
                return resource_type_ext;
            }

            public void setResource_type_ext(String resource_type_ext) {
                this.resource_type_ext = resource_type_ext;
            }

            public int getIs_first_publish() {
                return is_first_publish;
            }

            public void setIs_first_publish(int is_first_publish) {
                this.is_first_publish = is_first_publish;
            }

            public String getKorean_bb_song() {
                return korean_bb_song;
            }

            public void setKorean_bb_song(String korean_bb_song) {
                this.korean_bb_song = korean_bb_song;
            }

            public String getToneid() {
                return toneid;
            }

            public void setToneid(String toneid) {
                this.toneid = toneid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPic_huge() {
                return pic_huge;
            }

            public void setPic_huge(String pic_huge) {
                this.pic_huge = pic_huge;
            }

            public String getRelate_status() {
                return relate_status;
            }

            public void setRelate_status(String relate_status) {
                this.relate_status = relate_status;
            }

            public String getPic_big() {
                return pic_big;
            }

            public void setPic_big(String pic_big) {
                this.pic_big = pic_big;
            }

            public String getSong_source() {
                return song_source;
            }

            public void setSong_source(String song_source) {
                this.song_source = song_source;
            }

            public String getAll_rate() {
                return all_rate;
            }

            public void setAll_rate(String all_rate) {
                this.all_rate = all_rate;
            }

            public String getSong_id() {
                return song_id;
            }

            public void setSong_id(String song_id) {
                this.song_id = song_id;
            }

            public int getHavehigh() {
                return havehigh;
            }

            public void setHavehigh(int havehigh) {
                this.havehigh = havehigh;
            }

            public LrclinkBean getLrclink() {
                return lrclink;
            }

            public void setLrclink(LrclinkBean lrclink) {
                this.lrclink = lrclink;
            }

            public String getPic_premium() {
                return pic_premium;
            }

            public void setPic_premium(String pic_premium) {
                this.pic_premium = pic_premium;
            }

            public int getSpecial_type() {
                return special_type;
            }

            public void setSpecial_type(int special_type) {
                this.special_type = special_type;
            }

            public String getSi_proxycompany() {
                return si_proxycompany;
            }

            public void setSi_proxycompany(String si_proxycompany) {
                this.si_proxycompany = si_proxycompany;
            }

            public String getPic_radio() {
                return pic_radio;
            }

            public void setPic_radio(String pic_radio) {
                this.pic_radio = pic_radio;
            }

            public int getCharge() {
                return charge;
            }

            public void setCharge(int charge) {
                this.charge = charge;
            }

            public int getHas_mv_mobile() {
                return has_mv_mobile;
            }

            public void setHas_mv_mobile(int has_mv_mobile) {
                this.has_mv_mobile = has_mv_mobile;
            }

            public int getLearn() {
                return learn;
            }

            public void setLearn(int learn) {
                this.learn = learn;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
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

            public int getHas_mv() {
                return has_mv;
            }

            public void setHas_mv(int has_mv) {
                this.has_mv = has_mv;
            }

            public String getBitrate_fee() {
                return bitrate_fee;
            }

            public void setBitrate_fee(String bitrate_fee) {
                this.bitrate_fee = bitrate_fee;
            }

            public String getPic_small() {
                return pic_small;
            }

            public void setPic_small(String pic_small) {
                this.pic_small = pic_small;
            }

            public String getAll_artist_ting_uid() {
                return all_artist_ting_uid;
            }

            public void setAll_artist_ting_uid(String all_artist_ting_uid) {
                this.all_artist_ting_uid = all_artist_ting_uid;
            }

            public String getArtist_id() {
                return artist_id;
            }

            public void setArtist_id(String artist_id) {
                this.artist_id = artist_id;
            }

            public int getPlay_type() {
                return play_type;
            }

            public void setPlay_type(int play_type) {
                this.play_type = play_type;
            }

            public String getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(String album_id) {
                this.album_id = album_id;
            }

            public String getCopy_type() {
                return copy_type;
            }

            public void setCopy_type(String copy_type) {
                this.copy_type = copy_type;
            }

            public String getTing_uid() {
                return ting_uid;
            }

            public void setTing_uid(String ting_uid) {
                this.ting_uid = ting_uid;
            }

            public String getAlbum_title() {
                return album_title;
            }

            public void setAlbum_title(String album_title) {
                this.album_title = album_title;
            }

            public static class LrclinkBean {
                /**
                 * lrcContent : [ti:Everytime I Close My Eyes]
                 * [ar:Kenny G&Babyface&Mariah Carey]
                 * [al:The Day]
                 * <p>
                 * [00:00.00]Babyface--Everytime I Close My Eyes
                 * [00:05.00]Saxophone:Kenny G
                 * [00:10.00]Background Vocal Arrangement:Mariah Carey
                 * [00:16.00]Girl, it's been a long, long time comin'
                 * [00:30.00]But I, I know that it's been worth the wait
                 * [00:43.00]It feels like springtime in winter
                 * [00:52.00]It feels like Christmas in June
                 * [00:59.00]It feels like heaven has opened up
                 * [01:06.00]its gates for me and you
                 * [01:10.00]And every time I close my eyes
                 * [01:14.00]I thank the lord that I've got you
                 * [01:20.00]And you've got me too
                 * [01:24.00]And every time I think of it
                 * [01:27.00]I pinch myself 'cause I don't believe it's true
                 * [01:34.00]That someone like you loves me too, yeah
                 * [01:50.00]Girl, I think that you're truly somethin'
                 * [01:59.00]Yes, you are, and you're every bit of a dream come true
                 * [02:14.00]With you baby, it never rains and it's no wonder
                 * [02:26.00]The sun always shines when I'm near you
                 * [02:33.00]It's just a blessing that I have found somebody like you
                 * [02:44.00]And every time I close my eyes
                 * [02:47.00]I thank the lord that I've got you
                 * [02:53.00]And you've got me too
                 * [02:57.00]And every time I think of it
                 * [03:00.00]I pinch myself 'cause I don't believe it's true
                 * [03:07.00]That someone like you loves me too, yeah
                 * [03:14.00]To think of all the nights I've cried myself to sleep
                 * [03:20.00]You really oughta know how much you mean to me
                 * [03:25.00]It's only right that you be in my life
                 * [03:30.00]Right here with me, oh baby, baby
                 * [03:59.00]And every time I close my eyes
                 * [04:04.00]I thank the lord that I've got you
                 * [04:11.00]And you've got me too
                 * [04:14.00]And every time I think of it
                 * [04:18.00]I pinch myself 'cause I don't believe it's true
                 * [04:24.00]That someone like you loves me too, yeah
                 * title : Every Time I Close My Eyes
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
    }
}
