package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by Routee on 2017/3/3.
 */

public class ClassfyFragment3 extends BasicOsscFragment {
    @Override
    public void setUrl() {
        Bundle arguments = getArguments();
        String tag = arguments.getString("URL2");
        headUrl = "http://www.oschina.net/action/api/softwaretag_list?pageIndex=";
        footUrl = "&searchTag=" + tag + "&pageSize=20";
    }

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
}
