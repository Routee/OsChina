package com.zssfw.oschina.ui.pager.found.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.MyApplication;

import java.util.List;

/**
 * 尝试着用一个RecyclerView的Adapter匹配所有的RecyclerView
 * Created by Routee on 2017/2/26.
 */

public class FoundRvAdapter<T> extends RecyclerView.Adapter<FoundRvAdapter.ViewHoldor> {
    private List<T> mShowItems;
    private Integer mResId;
    private FoundRvAdapterListener mAdapterListener;

    public FoundRvAdapter(List<T> showItems,Integer resId,FoundRvAdapterListener listener) {
        mShowItems = showItems;
        mResId = resId;
        mAdapterListener = listener;
    }

    @Override
    public ViewHoldor onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(MyApplication.mContent, mResId, null);
        return new ViewHoldor(view);
    }

    @Override
    public void onBindViewHolder(ViewHoldor holder, int position) {
        bindViewHoldor(holder,mShowItems.get(position));
    }

    public void bindViewHoldor(ViewHoldor holdor,T t){
        mAdapterListener.bindView(holdor,t);
    }

    public interface FoundRvAdapterListener<T> {
        void bindView(ViewHoldor holder, T s);
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    public static class ViewHoldor extends RecyclerView.ViewHolder{
        private View mView;
        public ViewHoldor(View itemView) {
            super(itemView);
            mView = itemView;
        }
        private SparseArray<View> mViewHashMap = new SparseArray<>();   //性能要高于HashMap
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
