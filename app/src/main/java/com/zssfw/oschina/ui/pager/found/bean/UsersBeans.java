package com.zssfw.oschina.ui.pager.found.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Routee on 2017/2/25.
 */

/*<user>
<name>
<![CDATA[AndrewFan]]>
</name>
<uid>273658</uid>
<portrait>https://static.oschina.net/uploads/user/136/273658_100.jpg</portrait>
<gender>
<![CDATA[男]]>
</gender>
<from>
<![CDATA[江苏 南京]]>
</from>
</user>*/
    @XStreamAlias("user")
public class UsersBeans {
    @XStreamAlias("name")
    private String name;
    @XStreamAlias("uid")
    private String uid;
    @XStreamAlias("portrait")
    private String portrait;
    @XStreamAlias("gender")
    private String gender;
    @XStreamAlias("from")
    private String from;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
