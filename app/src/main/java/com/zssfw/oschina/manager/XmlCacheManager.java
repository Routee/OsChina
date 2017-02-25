package com.zssfw.oschina.manager;

import android.text.TextUtils;

import com.zssfw.oschina.util.XmlUtil;

/**
 * Created by leoo on 2017-2-23.
 */

public class XmlCacheManager {
    private static XmlCacheManager mXmlCacheManager = new XmlCacheManager();

    private XmlCacheManager() {

    }

    public static XmlCacheManager getInstance() {
        return mXmlCacheManager;
    }

    public <T> T getXmlBean(String url, String username,String psw,Class<T> clss) {
        //1. 请求数据
        String content = HttpManager.getInstance().dataPost(url,username,psw);
        if (TextUtils.isEmpty(content)) {
            //空的
            //3.去本地获取数据
            content = CacheManager.getInstance().getCacheData(url);
        } else {
            //说明有
            //4.去本地保存数据
            CacheManager.getInstance().saveCacheData(url,content);
        }
        if (TextUtils.isEmpty(content)) {
            //如果为空,直接返回null
            return null;
        } else {
            //有数据,我们就返回解析后的对象
            return (T) XmlUtil.getInstance().xmlToBean(content,clss);

        }



    }


}
