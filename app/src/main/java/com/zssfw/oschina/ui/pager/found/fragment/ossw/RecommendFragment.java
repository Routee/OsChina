package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.view.View;
import android.widget.TextView;

import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;

/**
 * Created by Routee on 2017/2/24.
 */

public class RecommendFragment extends BaseFragment {
    @Override
    public View createView() {
        TextView tv = new TextView(MyApplication.mContent);
        tv.setText("推荐");
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
