package com.zssfw.oschina.util;

import com.zssfw.oschina.MyApplication;

/**
 * Created by SJJ on 2017/2/15.
 * 描述 ${TODO}
 */

public class Util {
    //这个是在主线程去更新ui,在没有上下文的环境,
    public static void runOnUIThread(Runnable runnable)
    {
        MyApplication.mHandler.post(runnable);
    }


}
