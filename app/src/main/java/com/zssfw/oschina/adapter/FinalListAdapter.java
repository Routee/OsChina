package com.zssfw.oschina.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${TODO}
 */

public class FinalListAdapter<T> extends BaseAdapter {

    private final List<T>                    mList;
    private final int                        mLayoutId;
    private       OnFinalListAdapterListener mListener;

    public FinalListAdapter(List<T> list, int layoutId, OnFinalListAdapterListener listener) {
        mList = list;
        mLayoutId = layoutId;
        mListener = listener;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        FinalListViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), mLayoutId, null);
            holder = new FinalListViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (FinalListViewHolder) convertView.getTag();
        }
        bindView(holder, mList.get(position));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(position);
            }
        });
        return convertView;
    }

    private void bindView(FinalListViewHolder holder, T item) {
        mListener.bindView(holder, item);
    }


    /**
     * @param position 条目点击事件
     */
    public void onItemClick(int position) {

    }

    public interface OnFinalListAdapterListener<T> {
        void bindView(FinalListViewHolder holder, T item);
    }

    public static class FinalListViewHolder {


        private final View mLayoutView;
        private SparseArray<View> mViewMap = new SparseArray<>();

        public FinalListViewHolder(View layoutView) {
            mLayoutView = layoutView;
        }

        public View getView(int id) {
            View view = mViewMap.get(id);
            if (view == null) {
                view = mLayoutView.findViewById(id);
                mViewMap.put(id, view);
            }
            return view;
        }

        public void setText(int id,String text) {
            ((TextView) mLayoutView.findViewById(id)).setText(text);
        }

    }

}
