package com.zssfw.oschina.ui.pager.found.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.MultipleAdapter;
import com.zssfw.oschina.bean.FragmentBean;
import com.zssfw.oschina.ui.act.FoundShowActivity;
import com.zssfw.oschina.ui.pager.found.fragment.ossw.ClassfyFragment;
import com.zssfw.oschina.ui.pager.found.fragment.ossw.DomesticFragment;
import com.zssfw.oschina.ui.pager.found.fragment.ossw.HotFragment;
import com.zssfw.oschina.ui.pager.found.fragment.ossw.LatestFragment;
import com.zssfw.oschina.ui.pager.found.fragment.ossw.RecommendFragment;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Routee on 2017/2/23.
 */

public class OSSoftwareFragment extends BaseFragment {
    @Bind(R.id.tl_found_ossoftware)
    TabLayout mTabLayout;
    @Bind(R.id.vp_found_ossoftware)
    ViewPager mViewPager;

    private List<FragmentBean> mFoundOSSList = new ArrayList<>();
    private MultipleAdapter mAdapter;

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.view_ossoftware, null);
        ButterKnife.bind(this, view);
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

    private void initData() {
        if (mFoundOSSList != null) {
            mFoundOSSList.clear();
        }
        ClassfyFragment classfyFragment = new ClassfyFragment();
        RecommendFragment recommendFragment = new RecommendFragment();
        LatestFragment latestFragment = new LatestFragment();
        HotFragment hotFragment = new HotFragment();
        DomesticFragment domesticFragment = new DomesticFragment();
        mFoundOSSList.add(new FragmentBean(classfyFragment, Constant.OSSW_TAB_TITLE[0]));
        mFoundOSSList.add(new FragmentBean(recommendFragment, Constant.OSSW_TAB_TITLE[1]));
        mFoundOSSList.add(new FragmentBean(latestFragment, Constant.OSSW_TAB_TITLE[2]));
        mFoundOSSList.add(new FragmentBean(hotFragment, Constant.OSSW_TAB_TITLE[3]));
        mFoundOSSList.add(new FragmentBean(domesticFragment, Constant.OSSW_TAB_TITLE[4]));
        mAdapter = new MultipleAdapter(((FoundShowActivity) getContext()).getSupportFragmentManager(), mFoundOSSList);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void refresh() {

    }
}
