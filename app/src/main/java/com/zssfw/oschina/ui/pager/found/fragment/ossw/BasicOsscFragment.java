package com.zssfw.oschina.ui.pager.found.fragment.ossw;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.act.FoundShowActivity;
import com.zssfw.oschina.ui.pager.found.SwpipeListViewOnScrollListener;
import com.zssfw.oschina.ui.pager.found.adapter.OsswListAdapter;
import com.zssfw.oschina.ui.pager.found.bean.DomesticBean;
import com.zssfw.oschina.ui.pager.found.fragment.SoftWareDetailsFragment;
import com.zssfw.oschina.ui.pager.found.manager.XmlCacheTool;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Routee on 2017/2/24.
 */

public abstract class BasicOsscFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2, SwipeRefreshLayout.OnRefreshListener {

    private List<DomesticBean.OschinaBean.SoftwaresBean.SoftwareBean> mShowItems = new ArrayList<>();
    private int                                                       page       = 0;
    private SwipeRefreshLayout    mSrl;
    private PullToRefreshListView mPtrl;
    private OsswListAdapter       mAdapter;
    private ListView              mLv;
    private              int state = 0;
    private static final int NONE  = 0;
    private static final int DOWN  = 1;
    private static final int UP    = 2;


    @Override
    public View createView() {
        setUrl();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_found_osswview, null);
        mSrl = (SwipeRefreshLayout) view.findViewById(R.id.srl_found_ossw);
        mSrl.setOnRefreshListener(this);
        mPtrl = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
        mPtrl.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        SwpipeListViewOnScrollListener scrollListener = new SwpipeListViewOnScrollListener(mSrl);
        mPtrl.setOnScrollListener(scrollListener);
        mPtrl.setOnRefreshListener(this);
        mAdapter = new OsswListAdapter(mShowItems, R.layout.item_found_ossw, new OsswListAdapter.AdapterListener<DomesticBean.OschinaBean.SoftwaresBean.SoftwareBean>() {
            @Override
            public void bindView(OsswListAdapter.FinalViewHolder holder, DomesticBean.OschinaBean.SoftwaresBean.SoftwareBean bean) {
                TextView title = (TextView) holder.mView.findViewById(R.id.tv_ossw_title);
                TextView dsc = (TextView) holder.mView.findViewById(R.id.tv_ossw_dsc);
                title.setText(bean.getName().get(0));
                dsc.setText(bean.getDescription().get(0));
            }
        });
        mLv = mPtrl.getRefreshableView();
        mLv.setAdapter(mAdapter);
        mLv.setOnItemClickListener(new mOnItemClickListener());
        return view;
    }

    String headUrl = "";
    String footUrl = "";

    public abstract void setUrl();

    int currentPage = 0;

    @Override
    public Object getData() {
        currentPage = page++;
        DomesticBean domesticBean = XmlCacheTool.getInstance().getCacheBean(headUrl + currentPage + footUrl, DomesticBean.class);
        mShowItems.addAll(domesticBean.getOschina().getSoftwares().get(0).getSoftware());
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
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
    }

    //上拉刷新监听事件
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        if (state != NONE) {
            mPtrl.onRefreshComplete();
            return;
        }
        System.out.println(page);
        state = UP;
        mSelectPage.showPage();
        mPtrl.onRefreshComplete();
        state = NONE;
    }

    //下拉刷新监听事件
    @Override
    public void onRefresh() {
        if (state != NONE) {
            mSrl.setRefreshing(false);
            return;
        }
        mShowItems.clear();
        System.out.println(page);
        page = 0;
        state = DOWN;
        mSelectPage.showPage();
        mSrl.setRefreshing(false);
        state = NONE;
    }

    private class mOnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String url = mShowItems.get(position - 1).getUrl().get(0);
            Intent intent = new Intent(getContext(), FoundShowActivity.class);
            intent.putExtra(Constant.FOUNDTITLE, "软件详情");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Constant.FOUNDFRAGMENT, SoftWareDetailsFragment.class);
            intent.putExtra(Constant.SOFTWARENAME, url);
            startActivity(intent);
        }
    }
}
