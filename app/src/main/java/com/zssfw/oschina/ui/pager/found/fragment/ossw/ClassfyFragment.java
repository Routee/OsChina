package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.found.bean.Classify1Bean;
import com.zssfw.oschina.ui.pager.found.manager.XmlCacheTool;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Uris;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Routee on 2017/2/24.
 */

public class ClassfyFragment extends BaseFragment {
    private static final int                                                                FIRST         = 0;
    private static final int                                                                SECOND        = 1;
    private static final int                                                                THIRD         = 2;
    private              int                                                                mCurrentLevel = FIRST;
    private              List<Classify1Bean.OschinaBean.SoftwareTypesBean.SoftwareTypeBean> mShowItems    = new ArrayList<>();
    private ListView    mLv;
    private BaseAdapter mAdapter;


    @Override
    public View createView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_found_osswview_classify1, null);
        mLv = (ListView) view.findViewById(R.id.lv_found_ossw_classify);
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
        return view;
    }

    @Override
    public Object getData() {
        Classify1Bean bean = XmlCacheTool.getInstance().getCacheBean(Uris.FOUND_OSSW_CLASSIFY1, Classify1Bean.class);
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
}
