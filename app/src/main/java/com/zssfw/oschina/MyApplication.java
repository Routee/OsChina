package com.zssfw.oschina;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${TODO}
 */

public class MyApplication extends Application {

    public static Context mContent;
    public static Handler mHandler;


    @Override
    public void onCreate() {
        super.onCreate();
        mContent = this;
        mHandler = new Handler();

    }
}
