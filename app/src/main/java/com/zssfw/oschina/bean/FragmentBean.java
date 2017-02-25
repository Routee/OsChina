package com.zssfw.oschina.bean;

import android.support.v4.app.Fragment;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${一级页面加载二级页面的适配器传入的bean}
 */

public class FragmentBean {
    private Fragment mFragment;
    private String title;

    public FragmentBean(Fragment fragment, String title) {
        mFragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
