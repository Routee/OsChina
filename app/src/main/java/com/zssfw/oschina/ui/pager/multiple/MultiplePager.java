package com.zssfw.oschina.ui.pager.multiple;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.MultipleAdapter;
import com.zssfw.oschina.bean.FragmentBean;
import com.zssfw.oschina.ui.act.MainActivity;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${综合页 一级标签}
 */

public class MultiplePager extends BaseFragment {


    private MainActivity mMainActivity;
    private List<FragmentBean> mMultiplePagerlist = new ArrayList<>();
    private MultipleAdapter mMultipleAdapter;
    private TabLayout       mTablayout;
    private ViewPager       mStairViewpager;


    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_stair, null);
        mTablayout = (TabLayout) view.findViewById(R.id.tablayout);
        mStairViewpager = (ViewPager) view.findViewById(R.id.stair_viewpager);
        return view;
    }

    @Override
    public Object getData() {
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        });
        return "";
    }


    public void initData() {
        if (mMultiplePagerlist == null)
            mMultiplePagerlist = new ArrayList<>();

        mMultiplePagerlist.clear();
        NewsFragment newsFragment = new NewsFragment();
        BlogFragment blogFragment = new BlogFragment();
        AskFragment askFragment = new AskFragment();
        ActivityFragment activityFragment = new ActivityFragment();
        mMultiplePagerlist.add(new FragmentBean(newsFragment, Constant.MULTIPLE_TITLE[0]));
        mMultiplePagerlist.add(new FragmentBean(blogFragment, Constant.MULTIPLE_TITLE[1]));
        mMultiplePagerlist.add(new FragmentBean(askFragment, Constant.MULTIPLE_TITLE[2]));
        mMultiplePagerlist.add(new FragmentBean(activityFragment, Constant.MULTIPLE_TITLE[3]));

        mMultipleAdapter = new MultipleAdapter(((MainActivity) getContext()).getSupportFragmentManager(), mMultiplePagerlist);
        mStairViewpager.setAdapter(mMultipleAdapter);
        mTablayout.setupWithViewPager(mStairViewpager);
    }

    @Override
    public void refresh() {

    }


}
