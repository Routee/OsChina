package com.zssfw.oschina.ui.pager.found.manager;

import android.text.TextUtils;

import com.zssfw.oschina.manager.CacheManager;
import com.zssfw.oschina.manager.HttpManager;
import com.zssfw.oschina.ui.pager.found.utils.Xml2JsonUtil;
import com.zssfw.oschina.util.GsonUtil;

/**
 * 作者: old样
 * 描述:json缓存框架
 * 上海传智播客android黑马程序员
 */

public class XmlCacheTool {
    private XmlCacheTool() {

    }

    private static XmlCacheTool sDownManager = new XmlCacheTool();

    public static XmlCacheTool getInstance() {
        return sDownManager;
    }


    //用户传入地址与对象的class返回对应的对象
    public<T> T getCacheBean(String url, Class<T> clss) {
        //1. 请求数据
        String content = HttpManager.getInstance().dataGet(url);
        //2. 判断数据
        if (TextUtils.isEmpty(content)) {
            //空的
            //3.去本地获取数据
            content = CacheManager.getInstance().getCacheData(url);
        } else {
            //说明有
            //4.去本地保存数据
            CacheManager.getInstance().saveCacheData(url,content);
        }

        //打印当前的数据是否存在
        //System.out.println(content.length());

        //5. 解析数据返回
        if (TextUtils.isEmpty(content)) {
            //如果为空,直接返回null
            return null;
        } else {
            //有数据,我们就返回解析后的对象
            String json = Xml2JsonUtil.xml2JSON(content);
            return GsonUtil.parseJsonToBean(json, clss);
        }

    }

}
