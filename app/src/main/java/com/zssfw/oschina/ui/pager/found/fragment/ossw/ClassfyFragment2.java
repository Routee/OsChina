package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.found.bean.Classify2Bean;
import com.zssfw.oschina.ui.pager.found.manager.XmlCacheTool;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Uris;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Routee on 2017/2/24.
 */

public class ClassfyFragment2 extends BaseFragment implements AdapterView.OnItemClickListener {
    private String mUrl;
    private List<Classify2Bean.OschinaBean.SoftwareTypesBean.SoftwareTypeBean> mShowItems = new ArrayList<>();
    private ListView    mLv;
    private BaseAdapter mAdapter;
    private View mView = null;

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        Bundle arguments = getArguments();
        mUrl = arguments.getString("URL");
        mView = LayoutInflater.from(getContext()).inflate(R.layout.view_found_osswview_classify1, null);
        mLv = (ListView) mView.findViewById(R.id.lv_found_ossw_classify);
        mLv.setOnItemClickListener(this);
        mAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mShowItems == null ? 0 : mShowItems.size();
            }

            @Override
            public Object getItem(int position) {
                return mShowItems.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder = null;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(parent.getContext(), R.layout.item_found_ossw_classify, null);
                    holder.tv = (TextView) convertView.findViewById(R.id.tv_title);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.tv.setText(mShowItems.get(position).getName().get(0));
                return convertView;
            }

            class ViewHolder {
                TextView tv;
            }
        };
        mLv.setAdapter(mAdapter);
        return mView;
    }

    @Override
    public Object getData() {
        Classify2Bean bean = XmlCacheTool.getInstance().getCacheBean(Uris.FOUND_OSSW_CLASSIFY2 + mUrl, Classify2Bean.class);
        mShowItems = bean.getOschina().getSoftwareTypes().get(0).getSoftwareType();
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
        return mShowItems;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ClassfyFragment3 classfyFragment = new ClassfyFragment3();
        Bundle bundle = new Bundle();
        bundle.putSerializable("URL2", mShowItems.get(position).getTag().get(0));
        classfyFragment.setArguments(bundle);
        FragmentTransaction manager = getFragmentManager().beginTransaction();
        manager.add(R.id.fl_found_ossw, classfyFragment);
        manager.addToBackStack(null);
        manager.commit();
    }
}
