package com.zssfw.oschina.ui.pager.found.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class MyWebView extends WebView {
    private OnScrollListener mOnScrollListener;

    private int lastScrollY;

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:

                lastScrollY = this.getScrollY();

            case MotionEvent.ACTION_MOVE:

                if (Math.abs(lastScrollY - this.getScrollY()) > 10) {
                    boolean show = true;
                    if (lastScrollY > this.getScrollY())//向上拉
                    {
                        show = true;
                    } else//向下拉
                    {
                        show = false;
                    }
                    if (mOnScrollListener != null) {
                        mOnScrollListener.showOrHide(show);
                    }
                    lastScrollY = this.getScrollY();
                }


            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onTouchEvent(ev);
    }

    public void setmOnScrollListener(OnScrollListener mOnScrollListener) {
        this.mOnScrollListener = mOnScrollListener;
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollListener != null) {
            mOnScrollListener.onScrolled(l, t, oldl, oldt);
        }

    }

    public interface OnScrollListener {


        void showOrHide(boolean show);

        void onScrolled(int l, int t, int oldl, int oldt);

    }
}