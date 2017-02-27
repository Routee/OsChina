package com.zssfw.oschina.manager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.zssfw.oschina.R;
import com.zssfw.oschina.util.Util;

import java.util.List;

/**
 * Created by SJJ on 2017/2/15.
 * 描述 ${根据网络状况切换显示的二级界面}
 */

public abstract class SelectPage extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener {

    private View               mLoadingView;
    private View               mErrorView;
    private View               mSuccessView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Button             mBt_reInit;

    public SelectPage(Context context) {
        this(context, null);
    }

    public SelectPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (mLoadingView == null)
            mLoadingView = View.inflate(getContext(), R.layout.page_loading_view, null);

        if (mErrorView == null) {
            mErrorView = View.inflate(getContext(), R.layout.page_error_view, null);
            mBt_reInit = (Button) mErrorView.findViewById(R.id.re_init);
            mBt_reInit.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPage();
                }
            });
        }

        if (mSuccessView == null) {
            mSuccessView = createSuccessView();
            if (mSuccessView == null) {
                throw new RuntimeException("不要返回空,来个界面");
            }
        }

        if (mSwipeRefreshLayout==null) {
            mSwipeRefreshLayout = getSwipeRefresh();
            if (mSwipeRefreshLayout != null && !(mSwipeRefreshLayout instanceof SwipeRefreshLayout)) {
                throw new RuntimeException("要刷新就返回个  SwipeRefreshLayout ,不然返回null");
            }
        }
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.YELLOW,Color.BLUE);
            mSwipeRefreshLayout.setOnRefreshListener(this);
        }
        addView(mErrorView);
        addView(mSuccessView);
        addView(mLoadingView);

        changePage(mCurrentState);

        showPage();
    }

    protected abstract SwipeRefreshLayout getSwipeRefresh();

    public void showPage() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                final Object data = getNetData();//获取网络数据,线程
                Util.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mCurrentState = checkData(data);//检查是否有数据
                        changePage(mCurrentState);//根据数据显示
                        if (mSwipeRefreshLayout != null) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                });
            }
        }).start();


    }

    private LOADINGSTATE checkData(Object data) {
        //空 错误
        //集合 0  错误
        //集合 >0 成功
        //对象 成功
        if (data == null) {
            return LOADINGSTATE.ERROR;
        } else {
            if (data instanceof List) {
                List list = (List) data;
                if (list.size() == 0) {
                    return LOADINGSTATE.ERROR;
                } else {
                    //                    for (Object o : ((List) data)) {
                    //                        if (o != null) {
                    //                            return LOADINGSTATE.SUCCESS;
                    //                        }
                    //                    }
                    return LOADINGSTATE.SUCCESS;
                }
            } else {
                return LOADINGSTATE.SUCCESS;
            }
        }

    }

    public abstract Object getNetData();

    @Override//下拉刷新
    public void onRefresh() {
        showPage();
    }


    public enum LOADINGSTATE {
        LOADING,//加载
        ERROR,//失败
        SUCCESS//成功
    }

    //默认加载中
    private LOADINGSTATE mCurrentState = LOADINGSTATE.LOADING;

    private void changePage(LOADINGSTATE currentState) {
        mLoadingView.setVisibility(currentState == LOADINGSTATE.LOADING ? VISIBLE : INVISIBLE);
        mErrorView.setVisibility(currentState == LOADINGSTATE.ERROR ? VISIBLE : INVISIBLE);
        mSuccessView.setVisibility(currentState == LOADINGSTATE.SUCCESS ? VISIBLE : INVISIBLE);
    }


    public abstract View createSuccessView();
}
