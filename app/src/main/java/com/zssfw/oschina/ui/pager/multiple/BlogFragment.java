package com.zssfw.oschina.ui.pager.multiple;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.FinalListAdapter;
import com.zssfw.oschina.bean.BlogBean;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.show.BlogDetailsFragment;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.DensityUtil;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.util.Constant.BLOG;
import static com.zssfw.oschina.util.Constant.HOST;
import static com.zssfw.oschina.util.Constant.MESSAGE;
import static com.zssfw.oschina.util.Constant.MULTIPLE_BLOG_TITLE;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${博客页  二级标签}
 */

public class BlogFragment extends BaseFragment implements Runnable, View.OnClickListener {

    private LinearLayout mTabLayout;
    private List<BlogBean.ResultBean.ItemsBean> blogItems = new ArrayList<>();
    private ListView                                        mListView;
    private FinalListAdapter<BlogBean.ResultBean.ItemsBean> mAdapter;
    private SwipeRefreshLayout                              mSwipeRefreshLayout;
    private int pager = 3;
    private String mNextPageToken="";

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_secondary, null);
        //        mTabLayout = (LinearLayout) view.findViewById(R.id.layout_third_title);
        mTabLayout = new LinearLayout(getContext());
        mTabLayout.setGravity(Gravity.CENTER);

        mSwipeRefreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.swiperefresh));

        addTab();
        mListView = (ListView) view.findViewById(R.id.secondary_listview);
        mListView.addHeaderView(mTabLayout);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int lastVisiblePosition = mListView.getLastVisiblePosition();
                if (lastVisiblePosition == mAdapter.getCount()) {
                    System.out.println(lastVisiblePosition + "----" + mAdapter.getCount());
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            getBlogData(false);
                        }
                    }.start();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        return view;
    }


    @Override
    public Object getData() {
        System.out.println("博客刷新");
        haveData = false;
        mNextPageToken = "";
        getBlogData(true);
        return haveData ? "" : null;
    }

    private void getBlogData(boolean isClear) {
        if (isClear) {
            blogItems.clear();
        }
        BlogBean blogBean = JsonCacheManager.getInstance().getCacheBean(HOST + BLOG + pager+"&pageToken="+mNextPageToken, BlogBean.class);
        if (blogBean != null && TextUtils.equals(blogBean.getMessage(), MESSAGE)) {
            mNextPageToken = blogBean.getResult().getNextPageToken();
            //            blogItems.add(blogBean.getResult().getItems().get(0));
            blogItems.addAll(blogBean.getResult().getItems());
            Util.runOnUIThread(this);
            haveData = true;
        }
    }

    @Override
    public void refresh() {
    }

    private void addTab() {
        int padding = DensityUtil.dip2px(getContext(), 6);
        int margin = DensityUtil.dip2px(getContext(), 10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(margin, margin / 2, margin, margin / 2);
        for (int i = 0; i < MULTIPLE_BLOG_TITLE.length; i++) {
            TextView tv = new TextView(getContext());
            tv.setText(MULTIPLE_BLOG_TITLE[i]);
            tv.setTextColor(getResources().getColor(R.color.text_gray));
            tv.setTag(MULTIPLE_BLOG_TITLE.length - i);//第一个 tag3
            tv.setPadding(padding, padding, padding, padding);
            tv.setBackgroundResource(R.drawable.selector_tab_bg);
            tv.setLayoutParams(layoutParams);
            mTabLayout.addView(tv);
            tv.setOnClickListener(this);
            if (i == 0) {
                tv.setSelected(true);
                tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                tv.setSelected(false);
                tv.setTextColor(getResources().getColor(R.color.text_gray));
            }
        }

    }

    @Override
    public void run() {
        if (mAdapter == null) {
            mAdapter = new FinalListAdapter<BlogBean.ResultBean.ItemsBean>(blogItems, R.layout.item_blog, new FinalListAdapter.OnFinalListAdapterListener<BlogBean.ResultBean.ItemsBean>() {

                @Override
                public void bindView(FinalListAdapter.FinalListViewHolder holder, BlogBean.ResultBean.ItemsBean item) {
                    StringBuilder title = new StringBuilder(item.getTitle());
                    SpannableString ss;
                    if (item.isRecommend()) {
                        title.insert(0, " 原   荐  ");
                        ss = new SpannableString(title.toString());
                        ss.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        ss.setSpan(new RelativeSizeSpan(0.7f), 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        ss.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        ss.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.colorAccent)), 4, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    } else {
                        if (item.isOriginal()) {
                            title.insert(0, " 原  ");
                            ss = new SpannableString(title.toString());
                            ss.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            ss.setSpan(new RelativeSizeSpan(0.7f), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            ss.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.colorPrimary)), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        } else {
                            ss = new SpannableString(title.toString());
                        }
                    }

                    TextView tv_title = (TextView) holder.getView(R.id.tv_title);
                    tv_title.setText(ss);
                    holder.setText(R.id.tv_body, item.getBody());
                    holder.setText(R.id.tv_author, item.getAuthor());
                    holder.setText(R.id.tv_date, Util.parseTime(item.getPubDate()));
                    holder.setText(R.id.tv_view, item.getViewCount() + "");
                    holder.setText(R.id.tv_comment, item.getCommentCount() + "");
                }
            }){
                @Override
                public void onItemClick(int position) {
                    super.onItemClick(position);
                    //直接打开网址
                    BlogBean.ResultBean.ItemsBean itemsBean = blogItems.get(position);
                    startShowActivity2("博客详情",itemsBean.getCommentCount(),itemsBean.getHref(), BlogDetailsFragment.class);
                }
            };
            mListView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override//标签点击事件
    public void onClick(View v) {
        final int tag = (int) v.getTag();
        for (int i = 0; i < mTabLayout.getChildCount(); i++) {
            TextView tv = (TextView) mTabLayout.getChildAt(i);
            if (i + tag == mTabLayout.getChildCount()) {
                tv.setSelected(true);
                tv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                tv.setSelected(false);
                tv.setTextColor(getResources().getColor(R.color.text_gray));
            }
        }
        new Thread() {
            @Override
            public void run() {
                super.run();
                pager = tag;
                mNextPageToken = "";
                getBlogData(true);
            }
        }.start();

        System.out.println("点击了" + tag);
    }
}

