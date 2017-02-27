package com.zssfw.oschina.ui.pager.multiple;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.FinalListAdapter;
import com.zssfw.oschina.bean.NewsDetailsBean;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.util.Constant.BUNDLE_MSG_ID;
import static com.zssfw.oschina.util.Constant.HOST;
import static com.zssfw.oschina.util.Constant.MESSAGE;
import static com.zssfw.oschina.util.Constant.NEWS_DETAILS;

/**
 * Created by Administrator on 2017/2/24.
 */


public class NewsDetailsFragment extends BaseFragment implements View.OnKeyListener {

    private List<NewsDetailsBean.ResultBean.AboutsBean> aboutsBeen = new ArrayList<>();
    private NewsDetailsBean mDetailsBean;
    private TextView        mTv_title;
    private TextView        mTv_time;
    private WebView         mWebview;
    private LinearLayout    mSoft_layout;
    private ListView        mListview_soft;
    private ListView        mListview_recomend;


    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_newsdetails, null);
        mTv_title = (TextView) view.findViewById(R.id.tv_title);
        mTv_time = (TextView) view.findViewById(R.id.tv_time);
        mWebview = (WebView) view.findViewById(R.id.webview);
        mSoft_layout = (LinearLayout) view.findViewById(R.id.layout_software);
        mListview_soft = (ListView) view.findViewById(R.id.listview_soft);
        mListview_recomend = (ListView) view.findViewById(R.id.listview_recomend);


        WebViewClient client = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };
        mWebview.setWebViewClient(client);
        mWebview.setOnKeyListener(this);
        WebSettings settings = mWebview.getSettings();
        //        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //        mWebview.setBackgroundColor(Color.parseColor("#333333"));
        return view;
    }

    @Override
    public Object getData() {
        Bundle bundle = getArguments();
        int id = bundle.getInt(BUNDLE_MSG_ID);
        mDetailsBean = JsonCacheManager.getInstance().getCacheBean(HOST + NEWS_DETAILS + id, NewsDetailsBean.class);
        if (mDetailsBean.getMessage().equalsIgnoreCase(MESSAGE)) {
            aboutsBeen.addAll(mDetailsBean.getResult().getAbouts());
            Util.runOnUIThread(mDetailsRunnable);
            SystemClock.sleep(1000);
            return mDetailsBean;
        }
        return null;
    }

    //详情 推荐  设置
    private Runnable mDetailsRunnable = new Runnable() {
        @Override
        public void run() {
            NewsDetailsBean.ResultBean resultBean = mDetailsBean.getResult();
            mTv_title.setText(resultBean.getTitle());
            mTv_time.setText(mDetailsBean.getTime());
            mWebview.loadData(resultBean.getBody(), "text/html;charset=UTF-8", null);

            //相关软件
            NewsDetailsBean.ResultBean.SoftwareBean software = resultBean.getSoftware();
            if (software != null) {
                List<NewsDetailsBean.ResultBean.SoftwareBean> softwareList = new ArrayList<>();
                softwareList.add(software);
                mListview_soft.setAdapter(new FinalListAdapter<NewsDetailsBean.ResultBean.SoftwareBean>(softwareList,
                        R.layout.item_recomend_list, new FinalListAdapter.OnFinalListAdapterListener<NewsDetailsBean.ResultBean.SoftwareBean>() {
                    @Override
                    public void bindView(FinalListAdapter.FinalListViewHolder holder, NewsDetailsBean.ResultBean.SoftwareBean item) {
                        holder.setText(R.id.recomend_title, item.getName());
                        View view = holder.getView(R.id.about_null_layout);
                        view.setVisibility(View.GONE);
                    }
                }
                ));
            } else {
                mSoft_layout.setVisibility(View.GONE);
            }

            //相关推荐
            final List<NewsDetailsBean.ResultBean.AboutsBean> aboutList = resultBean.getAbouts();
            FinalListAdapter<NewsDetailsBean.ResultBean.AboutsBean> recommendAdapter = new FinalListAdapter<NewsDetailsBean.ResultBean.AboutsBean>(aboutList,
                    R.layout.item_recomend_list, new FinalListAdapter.OnFinalListAdapterListener<NewsDetailsBean.ResultBean.AboutsBean>() {
                @Override
                public void bindView(FinalListAdapter.FinalListViewHolder holder, NewsDetailsBean.ResultBean.AboutsBean item) {
                    holder.setText(R.id.recomend_title, item.getTitle());
                    holder.setText(R.id.tv_comment, item.getCommentCount() + "");

                }

            }) {
                @Override
                public void onItemClick(int position) {
                    super.onItemClick(position);
                    startShowActivity("资讯详情",aboutList.get(position).getCommentCount(),aboutList.get(position).getId(), NewsDetailsFragment.class);
                    System.out.println("跳转");
                }
            };
            mListview_recomend.setAdapter(recommendAdapter);

        }
    };

    @Override
    public void refresh() {

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
                mWebview.goBack();
                return true;
            }
        }
        return false;
    }
}

