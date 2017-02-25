package com.zssfw.oschina.manager;

import android.text.TextUtils;

/**
 * Created by leoo on 2017-2-23.
 */

public class XmlCacheManager {
    private XmlCacheManager mXmlCacheManager = new XmlCacheManager();

    private XmlCacheManager() {

    }

    public XmlCacheManager getInstance() {
        return mXmlCacheManager;
    }

    public <T> T getXmlBean(String url, Class<T> clss) {
        //1. 请求数据
        String content = HttpManager.getInstance().dataPost(url);
        //2. 判断数据
        if (TextUtils.isEmpty(content)) {
            //空的
            //3.去本地获取数据
            content = CacheManager.getInstance().getCacheData(url);
        } else {
            //说明有
            //4.去本地保存数据
            CacheManager.getInstance().saveCacheData(url, content);
        }
        return null;
    }
}
