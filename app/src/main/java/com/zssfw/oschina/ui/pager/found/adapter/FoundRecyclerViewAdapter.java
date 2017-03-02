package com.zssfw.oschina.ui.pager.found.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;

import java.util.List;

/**
 * Created by Routee on 2017/3/1.
 */

public class FoundRecyclerViewAdapter<UserInfoItemBean> extends RecyclerView.Adapter<FoundFriendInfoItemView> {

    private List<com.zssfw.oschina.ui.pager.found.bean.UserInfoItemBean> mShowItems;

    public FoundRecyclerViewAdapter(List<com.zssfw.oschina.ui.pager.found.bean.UserInfoItemBean> showItems) {
        mShowItems = showItems;
    }

    @Override
    public FoundFriendInfoItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApplication.mContent).inflate(R.layout.item_found_friend_info, null);
        return new FoundFriendInfoItemView(view);
    }

    @Override
    public void onBindViewHolder(FoundFriendInfoItemView holder, int position) {

        holder.setView(mShowItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }
}
