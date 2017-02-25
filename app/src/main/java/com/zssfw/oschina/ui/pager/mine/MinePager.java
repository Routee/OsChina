package com.zssfw.oschina.ui.pager.mine;

import android.view.View;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class MinePager extends BaseFragment {
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView tv = new TextView(getContext());
//        tv.setText("MinePager");
//
//        return tv;
//    }

    @Override
    public View createView() {
        View tv = View.inflate(getActivity(), R.layout.fragment_login, null);
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
