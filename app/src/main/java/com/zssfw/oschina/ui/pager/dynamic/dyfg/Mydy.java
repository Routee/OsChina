package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.MyDyadapter;
import com.zssfw.oschina.bean.ShardBean;
import com.zssfw.oschina.interfaces.Basetype;

import java.util.ArrayList;

/**
 * @创建者 administrator
 * @创建时间 2017/2/26 13:44
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/26$
 * @更新描述 ${TODO}
 */

public class Mydy extends Fragment {

    private RecyclerView mShad_recy;
    private View mView;
    private ShardBean mShardBean;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            setMyAdapter();
            super.handleMessage(msg);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.shard_recycle, null);
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#fcfcfc"),Color.parseColor("#ff0000"),Color.parseColor("#0000fc"));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                 SystemClock.sleep(2000);
                 swipeRefreshLayout.setRefreshing(false);
            }
        });
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void setMyAdapter() {
        ArrayList<Basetype> listData = new ArrayList<>();
        listData.add(mShardBean);
        mShad_recy = (RecyclerView) mView.findViewById(R.id.shad_recy);
        mShad_recy.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        MyDyadapter myDyadapter = new MyDyadapter(getActivity(),listData);
        mShad_recy.setAdapter(myDyadapter);
    }



    private void initData() {
       // uri = "http://www.oschina.net/action/apiv2/tweets?authorId=3292587";"http://www.oschina.net/action/apiv2/tweets?authorId=3292587"
        UtilData utilData = new UtilData();
        utilData.requestGet("http://www.oschina.net/action/apiv2/tweets?authorId=3292587");
        utilData.setResquertData(new UtilData.ResquertData() {
            @Override
            public void OnResquertData(Basetype basetype) {
                mShardBean = (ShardBean) basetype;
                mHandler.sendEmptyMessage(1);
            }
        });
    }

}
