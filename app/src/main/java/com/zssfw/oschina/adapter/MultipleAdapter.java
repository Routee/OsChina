package com.zssfw.oschina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zssfw.oschina.bean.FragmentBean;

import java.util.List;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${TODO}
 */

public class MultipleAdapter extends FragmentStatePagerAdapter {

    private final List<FragmentBean> mPagerList;

    public MultipleAdapter(FragmentManager fm, List<FragmentBean> pagerList) {
        super(fm);
        mPagerList = pagerList;
    }

    @Override
    public Fragment getItem(int position) {
        return mPagerList.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mPagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerList.get(position).getTitle();
    }

}
