package com.zssfw.oschina.ui.pager.multiple;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.FinalListAdapter;
import com.zssfw.oschina.bean.BlogBean;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.DensityUtil;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.util.Constant.BLOG3;
import static com.zssfw.oschina.util.Constant.HOST;
import static com.zssfw.oschina.util.Constant.MESSAGE;
import static com.zssfw.oschina.util.Constant.MULTIPLE_BLOG_TITLE;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${博客页  二级标签}
 */

public class BlogFragment extends BaseFragment implements Runnable {

    private LinearLayout mTabLayout;
    private List<BlogBean.ResultBean.ItemsBean> blogItems = new ArrayList<>();
    private ListView                                        mListView;
    private FinalListAdapter<BlogBean.ResultBean.ItemsBean> mAdapter;

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_secondary, null);
        mTabLayout = (LinearLayout) view.findViewById(R.id.layout_third_title);
        addTab();
        mListView = (ListView) view.findViewById(R.id.secondary_listview);


        return view;
    }


    @Override
    public Object getData() {
        BlogBean blogBean = JsonCacheManager.getInstance().getCacheBean(HOST + BLOG3, BlogBean.class);
        if (blogBean != null && TextUtils.equals(blogBean.getMessage(), MESSAGE)) {
            blogItems.addAll(blogBean.getResult().getItems());
            Util.runOnUIThread(this);
            return blogBean;
        }
        return null;
    }

    @Override
    public void refresh() {
//        mListView.setAdapter(mAdapter);
    }

    private void addTab() {
        int padding = DensityUtil.dip2px(getContext(), 6);
        int margin = DensityUtil.dip2px(getContext(), 10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(margin, margin, margin, margin);
        for (int i = 0; i < MULTIPLE_BLOG_TITLE.length; i++) {
            TextView tv = new TextView(getContext());
            tv.setText(MULTIPLE_BLOG_TITLE[i]);
            tv.setTag(MULTIPLE_BLOG_TITLE.length - i);
            tv.setPadding(padding, padding, padding, padding);
            tv.setBackgroundColor(getResources().getColor(R.color.gray));
            tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            tv.setLayoutParams(layoutParams);
            mTabLayout.addView(tv);
        }
    }

    @Override
    public void run() {
        mAdapter = new FinalListAdapter<>(blogItems, R.layout.item_news, new FinalListAdapter.OnFinalListAdapterListener<BlogBean.ResultBean.ItemsBean>() {

            @Override
            public void bindView(FinalListAdapter.FinalListViewHolder holder, BlogBean.ResultBean.ItemsBean item) {
                holder.setText(R.id.tv_title, item.getTitle());
                holder.setText(R.id.tv_body, item.getBody());
                holder.setText(R.id.tv_date, item.getPubDate());
                holder.setText(R.id.tv_comment, item.getCommentCount() + "");
            }
        });

        mListView.setAdapter(mAdapter);
    }
}
