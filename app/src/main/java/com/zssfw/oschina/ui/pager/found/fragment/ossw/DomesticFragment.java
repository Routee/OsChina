package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.support.v4.widget.SwipeRefreshLayout;

import com.zssfw.oschina.util.Uris;

/**
 * Created by Routee on 2017/2/24.
 */



    public class DomesticFragment extends BasicOsscFragment {

    @Override
    public void setUrl() {
        headUrl = Uris.FOUND_OSSW_DOMESTIC1;
        footUrl = Uris.FOUND_OSSW_DOMESTIC2;
    }

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
}

