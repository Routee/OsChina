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

public class RecommendFragment extends BaseFragment {
    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

public class RecommendFragment extends BasicOsscFragment {
    @Override
    public void setUrl() {
        headUrl = Uris.FOUND_OSSW_RECOMMEND1;
        footUrl = Uris.FOUND_OSSW_RECOMMEND2;
    }
}
