package com.zssfw.oschina.util;

import com.thoughtworks.xstream.XStream;
import com.zssfw.oschina.bean.OschinaBean;

/**
 * Created by leoo on 2017-2-24.
 */

public class XmlUtil {
    private static XmlUtil mXmlUtil = new XmlUtil();
    private XmlUtil(){}
    public static XmlUtil getInstance(){
        return mXmlUtil;
    }
    public <T> T xmlToBean(String content,Class<T> clazz){
        XStream stream = new XStream();
        stream.alias("result",OschinaBean.ResultBean.class);
        stream.alias("user", OschinaBean.UserBean.class);
        stream.alias("notice", OschinaBean.NoticeBean.class);
        stream.alias("oschina",clazz );
        return (T) stream.fromXML(content);
    }
}
