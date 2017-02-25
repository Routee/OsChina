package com.zssfw.oschina.ui.pager.found;

import android.view.View;
import android.widget.TextView;

import com.zssfw.oschina.ui.pager.plus.BaseFragment;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class FoundPager extends BaseFragment {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView tv = new TextView(getContext());
//        tv.setText("FoundPager");
//
//        return tv;
//    }

    @Override
    public View createView() {
        TextView tv = new TextView(getContext());
        tv.setText("FoundPager");

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
