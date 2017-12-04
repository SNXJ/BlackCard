package com.zsh.blackcard.model;

import java.util.List;

/**
 * Name: LiveInfoListModel
 * Author: SNXJ
 * Date: 2017-12-04
 * Description:描述：
 */
public class LiveInfoListModel {

    /**
     * code : 0
     * data : {"room_list":[{"room_id":"#m-71994488-240","room_name":"windows-room-71994488","anchor_id_name":"71994488","anchor_nick_name":"windows-71994488","stream_info":[]},{"room_id":"ms_16980002935086","room_name":"Hello-iPhone_iPhone6.2_10.3.3-886532319","anchor_id_name":"922448878","anchor_nick_name":"iPhone_iPhone7.2_10.3.3-922448878","stream_info":[{"stream_id":"s-922448878-1512378239"}]},{"room_id":"#m-1512366611683","room_name":"Hello-Android_PRA-AL00-1512366611683","anchor_id_name":"1512366611683","anchor_nick_name":"Android_PRA-AL00-1512366611683","stream_info":[]},{"room_id":"#s-1512355104991","room_name":"Hello-Android_vivo X9i-1512355104991","anchor_id_name":"1512355104991","anchor_nick_name":"Android_vivo X9i-1512355104991","stream_info":[{"stream_id":"ms_16980002935086"}]},{"room_id":"9999","room_name":"即构课堂 (9999)","anchor_id_name":"719","anchor_nick_name":"yoer_windows_debug","stream_info":[]}]}
     * message : success
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<RoomListBean> room_list;

        public List<RoomListBean> getRoom_list() {
            return room_list;
        }

        public void setRoom_list(List<RoomListBean> room_list) {
            this.room_list = room_list;
        }

        public class StreamInfo {
            public String stream_id;
        }

        public static class RoomListBean {
            /**
             * room_id : #m-71994488-240
             * room_name : windows-room-71994488
             * anchor_id_name : 71994488
             * anchor_nick_name : windows-71994488
             * stream_info : []
             */

            public String room_id;
            public String room_name;
            public String anchor_id_name;
            public String anchor_nick_name;
            public List<StreamInfo> stream_info;

            public String getRoom_id() {
                return room_id;
            }

            public void setRoom_id(String room_id) {
                this.room_id = room_id;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getAnchor_id_name() {
                return anchor_id_name;
            }

            public void setAnchor_id_name(String anchor_id_name) {
                this.anchor_id_name = anchor_id_name;
            }

            public String getAnchor_nick_name() {
                return anchor_nick_name;
            }

            public void setAnchor_nick_name(String anchor_nick_name) {
                this.anchor_nick_name = anchor_nick_name;
            }

            public List<StreamInfo> getStream_info() {
                return stream_info;
            }

            public void setStream_info(List<StreamInfo> stream_info) {
                this.stream_info = stream_info;
            }
        }
    }
}
