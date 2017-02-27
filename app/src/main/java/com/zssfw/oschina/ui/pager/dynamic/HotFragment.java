package com.zssfw.oschina.ui.pager.dynamic;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.DynnamicAdapterBase;
import com.zssfw.oschina.bean.HotBean;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.DyGetData;
import com.zssfw.oschina.util.SpUtils;

import java.util.ArrayList;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class HotFragment extends BaseFragment {



    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    setViewData();
                    break;
            }
        }
    };
    private HotBean mHotBean;
    private RecyclerView mRecyclerView;
    private ArrayList<HotBean.ResultBean.ItemsBean> mItems;
    private DynnamicAdapterBase mDynnamicAdapterBase;
    private PullToRefreshScrollView mPullToRefreshScrollView;
    private DyGetData mDyGetData;
    private View mView;
    private DYView mDYView;
    private String FileName = "dynamicList1";
    private int uriID;
    public HotFragment() {
    }

    public HotFragment(int uriID) {
        this.uriID = uriID;
        Constant.ONFILE_NAME = "dynamicList" + uriID;
       // FileName = FileName + uriID;
    }

    private void setViewData() {
        final ArrayList listdata = new ArrayList();
        if (mDynnamicAdapterBase == null) {
            mDynnamicAdapterBase = new DynnamicAdapterBase(getActivity(), mItems.size()) {
                @Override
                public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                    ViewHolder holder1 = (ViewHolder) holder;
                    HotBean.ResultBean.ItemsBean mdata = mItems.get(position);
                    holder1.setTextS(mdata);
                }
            };
            mRecyclerView.setAdapter(mDynnamicAdapterBase);
            mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        } else {
            mDynnamicAdapterBase.notifyDataSetChanged();
        }
        mPullToRefreshScrollView.onRefreshComplete();
    }

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        mView = View.inflate(getActivity(), R.layout.recyclerview, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view);
        mPullToRefreshScrollView = (PullToRefreshScrollView) mView.findViewById(R.id.pull_refresh_scrollview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        initPulltoRefresh();
        mDyGetData = new DyGetData();
        return mView;
    }

    private void initPulltoRefresh() {
        mPullToRefreshScrollView.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                PullToRefreshBase.Mode currentMode = mPullToRefreshScrollView.getCurrentMode();
                if (currentMode == PullToRefreshBase.Mode.PULL_FROM_START) {
                    String url = "http://www.oschina.net/action/apiv2/tweets?type="+uriID;
                    if (mItems != null) {
                        sendHander(url,true);
                    }
                } else {//http://www.oschina.net/action/apiv2/tweet?id=12257133
                    String url = "http://www.oschina.net/action/apiv2/tweets?type="+uriID+"&nextPageToken="+mHotBean.getResult().getNextPageToken();
                    if (mItems != null) {
                        sendHander(url,false);
                    }
                }
            }
        });
    }

    @Override
    public Object getData() {
        String url = "http://www.oschina.net/action/apiv2/tweets?type="+uriID;
   //     Constant.ONFILE_NAME = FileName +uriID;
//        if (uriID == 1) {
//            Constant.ONFILE_NAME = FileName = "dynamicList";
//        } else if (uriID == 2) {
//            Constant.ONFILE_NAME = FileName = "dynamicList2";
//        } else {
//            Constant.ONFILE_NAME =  FileName = "dynamicList3";
//            FileName = "dynamicList3";
//        }
        mItems = (ArrayList<HotBean.ResultBean.ItemsBean>) SpUtils.getlist(getActivity());
        if (mItems != null) {
            mHandler.sendEmptyMessage(1);
        }
        sendHander(url, true);
        return "";
    }

    public void sendHander(String url,boolean top) {
        mDyGetData.getData(getActivity(),url,top);
        mDyGetData.setNetDataListenner(new DyGetData.NetDataListenner() {
            @Override
            public void onNetData(ArrayList<HotBean.ResultBean.ItemsBean> items, HotBean hotBean) {
                mItems = items;
                if (mHotBean == null) {
                    mHotBean = hotBean;
                }
                mHandler.sendEmptyMessage(1);
            }
        });
    }
    @Override
    public void refresh() {

    }

    public interface DYView {
        String[] onDYView(View view);
    }

    public void setDYView(DYView listenner) {
        this.mDYView = listenner;
    }
}
