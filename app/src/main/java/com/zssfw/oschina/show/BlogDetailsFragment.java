package com.zssfw.oschina.show;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.Util;


/**
 * Created by SJJ on 2017/2/26.
 * 描述 ${TODO}
 */

public class BlogDetailsFragment extends BaseFragment implements View.OnKeyListener {

    private WebView     mWebView;
    private ProgressBar mProgressBar;

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_blogdetails, null);
        mProgressBar = ((ProgressBar) view.findViewById(R.id.pb));
        mWebView = (WebView) view.findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    //                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
        mWebView.setOnKeyListener(this);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptEnabled(true);
        return view;
    }

    @Override
    public Object getData() {
        Bundle bundle = getArguments();
        final String url = bundle.getString(Constant.BUNDLE_MSG_URL, null);
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mWebView.loadUrl(url);
            }
        });

        return url;
    }

    @Override
    public void refresh() {

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
        }
        return false;
    }
}
