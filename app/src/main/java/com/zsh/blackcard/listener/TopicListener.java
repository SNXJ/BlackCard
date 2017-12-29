package com.zsh.blackcard.listener;

import com.zsh.blackcard.model.TopicListModel;

/**
 * Name: TopicListener
 * Author: SNXJ
 * Date: 2017-11-14
 * Description:描述：
 */
public interface TopicListener {
    void dateListener(TopicListModel.PdBean  data);
}
