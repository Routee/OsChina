package com.zssfw.oschina.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${TODO}
 */

public abstract class BasePagerAdapter<T> extends PagerAdapter {


    public final List<T> mList;

    public BasePagerAdapter(List<T> pagerList) {
        mList = pagerList;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = initView(container, position);
        container.addView(view);
        return view;
    }

    public abstract View initView(ViewGroup container, int position) ;

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
