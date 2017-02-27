package com.zssfw.oschina.ui.act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zssfw.oschina.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebActivity extends AppCompatActivity {

    @Bind(R.id.webView)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        final String href = getIntent().getExtras().getString("href");
       mWebView.loadUrl(href);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);



    }
}
