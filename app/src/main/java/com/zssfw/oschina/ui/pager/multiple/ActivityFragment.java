package com.zssfw.oschina.ui.pager.multiple;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;

import com.zssfw.oschina.ui.pager.plus.BaseFragment;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class ActivityFragment extends BaseFragment {

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        TextView tv = new TextView(getContext());
        tv.setText("ActivityFragment");

        return tv;
    }

    @Override
    public Object getData() {
        return "";
    }

    @Override
    public void refresh() {

    }
}
