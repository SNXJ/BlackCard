package com.zsh.blackcard.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Name: HomeGloryMusicModel
 * Author: SNXJ
 * Date: 2017-11-30
 * Description:描述：
 */
public class HomeGloryMusicModel {


    /**
     * result : 01
     * pd : [{"MUSICIMAGE":"http://47.104.16.215:8088/musicimgs/musichomeimgs/17c5ef457f2a45dab8f2cac7a73b214a.png","MUSIC_ID":"385504537256919040","MUSICTYPE":"歌手"},{"MUSICIMAGE":"http://47.104.16.215:8088/musicimgs/musichomeimgs/faf76c5b232d44ba897ec1a097197952.png","MUSIC_ID":"385504602604175360","MUSICTYPE":"排行榜"},{"MUSICIMAGE":"http://47.104.16.215:8088/musicimgs/musichomeimgs/f1eb2cadbd4247659897d9fe3552de23.png","MUSIC_ID":"385504653091012608","MUSICTYPE":"曲库"},{"MUSICIMAGE":"http://47.104.16.215:8088/musicimgs/musichomeimgs/7bb5a1c7a4e54b35a8d27d7914dea4fb.png","MUSIC_ID":"385504688956506112","MUSICTYPE":"电台"}]
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
         * MUSICIMAGE : http://47.104.16.215:8088/musicimgs/musichomeimgs/17c5ef457f2a45dab8f2cac7a73b214a.png
         * MUSIC_ID : 385504537256919040
         * MUSICTYPE : 歌手
         */
        public static final int LEFT = 1;
        public static final int CENTER = 2;
        public static final int RIGHT = 3;
        private int itemType;

        private String MUSICIMAGE;
        private String MUSIC_ID;
        private String MUSICTYPE;

        public String getMUSICIMAGE() {
            return MUSICIMAGE;
        }

        public void setMUSICIMAGE(String MUSICIMAGE) {
            this.MUSICIMAGE = MUSICIMAGE;
        }

        public String getMUSIC_ID() {
            return MUSIC_ID;
        }

        public void setMUSIC_ID(String MUSIC_ID) {
            this.MUSIC_ID = MUSIC_ID;
        }

        public String getMUSICTYPE() {
            return MUSICTYPE;
        }

        public void setMUSICTYPE(String MUSICTYPE) {
            this.MUSICTYPE = MUSICTYPE;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }
    }
}
