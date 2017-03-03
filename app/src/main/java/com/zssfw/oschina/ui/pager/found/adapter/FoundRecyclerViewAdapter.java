package com.zssfw.oschina.ui.pager.found.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.found.bean.UserInfoBean;

import java.util.List;

/**
 * Created by Routee on 2017/3/1.
 */

public class FoundRecyclerViewAdapter extends RecyclerView.Adapter<FoundFriendInfoItemView> {

    public static final int FOOT = 1;
    public static final int BODY = 0;
    private List<UserInfoBean.OschinaBean.ActiviesBean.ActiveBean> mShowItems;

    public FoundRecyclerViewAdapter(List<UserInfoBean.OschinaBean.ActiviesBean.ActiveBean> showItems) {
        mShowItems = showItems;
    }

    @Override
    public FoundFriendInfoItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case FOOT:
                view = LayoutInflater.from(MyApplication.mContent).inflate(R.layout.item_found_friend_info, null);
                return new FoundFriendInfoItemView(view, FOOT);
            case BODY:
                view = LayoutInflater.from(MyApplication.mContent).inflate(R.layout.item_found_friend_info, null);
                return new FoundFriendInfoItemView(view, BODY);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(FoundFriendInfoItemView holder, int position) {
        holder.setView(mShowItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mShowItems == null ? 0 : mShowItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mShowItems.get(position) == null) {
            return FOOT;
        }
        return BODY;
    }


}
