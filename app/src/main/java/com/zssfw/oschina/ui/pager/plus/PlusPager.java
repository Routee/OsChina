package com.zssfw.oschina.ui.pager.plus;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class PlusPager extends BaseFragment {
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView tv = new TextView(getContext());
//        tv.setText("PlusPager");
//
//        return tv;
//    }

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        TextView tv = new TextView(getContext());
        tv.setText("PlusPager");

        return tv;
    }

    @Override
    public Object getData() {
        return "";
    }

//    @Override
    public void initData() {

    }

    @Override
    public void refresh() {

    }

}
