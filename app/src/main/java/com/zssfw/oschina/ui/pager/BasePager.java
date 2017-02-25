package com.zssfw.oschina.ui.pager;

import android.content.Context;
import android.view.View;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${一级页面基类}
 */

public abstract class BasePager  {



        public   View    mView;
    public final Context mContext;
    public boolean isLoad = false;

    public BasePager(Context context) {
        mContext = context;
        mView = initView();
    }
    public View getView() {
        return mView;
    }

    public abstract View initView() ;

    public abstract void refresh() ;



}
