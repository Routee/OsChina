package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;

import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;

/**
 * Created by Routee on 2017/2/24.
 */

public class ClassfyFragment extends BaseFragment {
    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        TextView tv = new TextView(MyApplication.mContent);
        tv.setText("分类");
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
