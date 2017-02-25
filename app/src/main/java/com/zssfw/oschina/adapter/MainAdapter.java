package com.zssfw.oschina.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.ui.pager.BasePager;

import java.util.List;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${TODO}
 */


public class MainAdapter extends BasePagerAdapter<BasePager> {
    public MainAdapter(List<BasePager> pagerList) {
        super(pagerList);
    }

    @Override
    public View initView(ViewGroup container, int position) {
        return mList.get(position).getView();
    }


}
