package com.zssfw.oschina.ui.pager.found.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created by Routee on 2017/2/25.
 */

@XStreamAlias("oschina")
public class FoundUserBean {
    @XStreamAlias("users")
    private List<UsersBeans> userBean;

    public List<UsersBeans> getUserBean() {
        return userBean;
    }

    public void setUserBean(List<UsersBeans> userBean) {
        this.userBean = userBean;
    }
}
