package com.zssfw.oschina.ui.pager.dynamic;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.MultipleAdapter;
import com.zssfw.oschina.bean.FragmentBean;
import com.zssfw.oschina.ui.act.MainActivity;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.util.Constant.DYNAMIC_TITLE;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${动弹 一级标签}
 */

public class DynamicPager extends BaseFragment {



    private List<FragmentBean> mDynamicPagerList = new ArrayList<>();
    private MultipleAdapter mAdapter;
    private TabLayout mTablayout;
    private ViewPager mStairViewpager;


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
        if (mDynamicPagerList == null)
            mDynamicPagerList = new ArrayList<>();

        //mDynamicPagerList.clear();
        LatestFragment latestFragment = new LatestFragment();
        HotFragment hotFragment = new HotFragment();
        MyDynamicFragment myDynamicFragment = new MyDynamicFragment();
        mDynamicPagerList.add(new FragmentBean(latestFragment, DYNAMIC_TITLE[0]));
        mDynamicPagerList.add(new FragmentBean(hotFragment, DYNAMIC_TITLE[1]));
        mDynamicPagerList.add(new FragmentBean(myDynamicFragment, DYNAMIC_TITLE[2]));

        mAdapter = new MultipleAdapter(((MainActivity) getContext()).getSupportFragmentManager(), mDynamicPagerList);
        mStairViewpager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mStairViewpager);
    }

    @Override
    public void refresh() {

    }


}
