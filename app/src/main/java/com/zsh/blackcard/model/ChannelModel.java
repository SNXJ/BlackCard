package com.zsh.blackcard.model;

import java.io.Serializable;

/**
 * 频道实体类
 */
public class ChannelModel implements Serializable{

    private String CAIDAN_ID;
    private String NAME;

    public String getId() {
        return CAIDAN_ID;
    }

    public void setId(String id) {
        this.CAIDAN_ID = id;
    }

    public String getName() {
        return NAME;
    }

    public void setName(String name) {
        this.NAME = name;
    }
}
