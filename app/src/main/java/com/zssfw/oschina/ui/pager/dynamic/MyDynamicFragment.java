package com.zssfw.oschina.ui.pager.dynamic;

import android.view.View;
import android.widget.TextView;

import com.zssfw.oschina.ui.pager.plus.BaseFragment;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class MyDynamicFragment extends BaseFragment {

    @Override
    public View createView() {
        TextView tv = new TextView(getContext());
        tv.setText("MyDynamicFragment");

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
