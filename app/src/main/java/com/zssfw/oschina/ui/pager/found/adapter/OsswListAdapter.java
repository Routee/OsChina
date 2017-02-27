package com.zssfw.oschina.ui.pager.found.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class OsswListAdapter<T> extends BaseAdapter {
    private List<T> mShowItems = new ArrayList<>();
    private int mLayoutId;
    private AdapterListener mAdapterListener;

    /**
     *
     * @param showItems     要传入的List集合,要显示的数据
     * @param layoutId      ViewHolder布局文件
     * @param adapterListener       实现接口回调
     */
    public OsswListAdapter(List<T> showItems,int layoutId,AdapterListener adapterListener) {
        mShowItems = showItems;
        mLayoutId = layoutId;
        mAdapterListener = adapterListener;
    }

    @Override
    public int getCount() {
        return mShowItems==null?0:mShowItems.size();
    }

    @Override
    public T getItem(int position) {
        return mShowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FinalViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), mLayoutId, null);
            holder = new FinalViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (FinalViewHolder) convertView.getTag();
        }
        bindView(holder, mShowItems.get(position));
        return convertView;
    }

    private void bindView(FinalViewHolder holder, T s) {
        //        holder.tv.setText(s);
        //谁用谁来绑定数据
        mAdapterListener.bindView(holder, s);
    }

    //定义接口
    public interface AdapterListener<T> {
        void bindView(FinalViewHolder holder, T s);
    }

    public static class FinalViewHolder{
        public View mView;
        public FinalViewHolder(View view) {
            mView = view;
        }

        //根据Id自动查找控件的类
        //        HashMap<Integer, View> mViewHashMap = new HashMap<>();//性能不够高
        public SparseArray<View> mViewHashMap = new SparseArray<>();   //性能要高于HashMap
        public View getViewById(int id) {
            View view = mViewHashMap.get(id);
            if (view == null) {
                view = mView.findViewById(id);
                mViewHashMap.put(id, view);
            }
            return view;
        }
    }
}