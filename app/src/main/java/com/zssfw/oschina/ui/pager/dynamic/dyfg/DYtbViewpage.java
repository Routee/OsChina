package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.DYdetaisTableVP;

import java.util.ArrayList;

/**
 * @创建者 administrator
 * @创建时间 2017/2/27 12:11
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/27$
 * @更新描述 ${TODO}
 */

public class DYtbViewpage extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArrayList<DYdetaisTableVP> mListData;
    public DYtbViewpage(ArrayList<DYdetaisTableVP> listData) {
        this.mListData = listData;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.dy_tb_vp, null);
        init(view);
        return view;
    }

    private void init(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout_dy);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager_dy);
        TbViewPAdapter tbViewPAdapter = new TbViewPAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(tbViewPAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }



    private class TbViewPAdapter extends FragmentPagerAdapter {

        public TbViewPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mListData.get(position).mFragment;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mListData.get(position).mTitle;
        }
    }

}
