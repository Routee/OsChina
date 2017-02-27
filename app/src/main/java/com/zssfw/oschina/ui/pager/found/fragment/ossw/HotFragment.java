package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;

import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Uris;

/**
 * Created by Routee on 2017/2/24.
 */

public class HotFragment extends BasicOsscFragment {

public class HotFragment extends BaseFragment {
    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public void setUrl() {
        headUrl = Uris.FOUND_OSSW_HOT1;
        footUrl = Uris.FOUND_OSSW_HOT2;
    }
}
