package com.zssfw.oschina.ui.pager.found.fragment;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.ui.pager.found.bean.SoftWareBean;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.Util;

/**
 * Created by Routee on 2017/2/27.
 */

/*
        if(mWebView.getContentHeight()*mWebView.getScale()-(mWebView.getHeight()+mWebView.getScrollY())==0){
            //判断WebView已经处于底部
        }
 */

public class SoftWareDetailsFragment extends BaseFragment implements View.OnTouchListener {

    private String  mName;
    private WebView mWebView;
    boolean isBlog = false;
    private String       mNewUrl;
    private LinearLayout mLinearLayout;
    private TextView     mTvComment;
    private TextView     mTvCollect;
    private TextView     mTvShare;
    private GestureDetector mDetector;
    private ValueAnimator mVAnim;
    private int mHeight;

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        Bundle arguments = getArguments();
        String url = arguments.getString(Constant.SOFTWARENAME);
        String info = url.substring(url.lastIndexOf("/") - 4);
        if (info.startsWith("blog")) {
            mName = url;
            isBlog = true;
        } else {
            mName = info.substring(5);
        }
        View view = LayoutInflater.from(getContext()).inflate(R.layout.found_software_view, null);
        mWebView = (WebView) view.findViewById(R.id.wv_found_software);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.ll_bottom);
        mHeight = mLinearLayout.getHeight();
        mTvComment = (TextView) view.findViewById(R.id.tv_comment);
        mTvCollect = (TextView) view.findViewById(R.id.tv_collect);
        mTvShare = (TextView) view.findViewById(R.id.tv_share);
        mDetector = new GestureDetector(new GestureListener());
        mWebView.setOnTouchListener(this);
        if (!isBlog) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final SoftWareBean bean = JsonCacheManager.getInstance().getCacheBean(Constant.SOFTWARENAME + mName, SoftWareBean.class);
                    mNewUrl = bean.getResult().getHref();
                    Util.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            mWebView.loadUrl(mNewUrl);
                            mTvComment.setText("评论(" + bean.getResult().getCommentCount() + ")");
                            if (bean.getResult().isFavorite()) {
                                mTvCollect.setText("已收藏");
                                mTvCollect.setTextColor(Color.parseColor("#EA9320"));
                                Drawable drawable = getResources().getDrawable(R.mipmap.collected);
                                /// 这一步必须要做,否则不会显示.
                                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                                mTvCollect.setCompoundDrawables(drawable, null, null, null);
                            } else {
                                mTvCollect.setText("收藏");
                            }
                        }
                    });
                }
            }).start();
        } else {
            mWebView.loadUrl(url);
        }
        return view;
    }

    //显示底部布局
    private void showBottom() {
        /*mVAnim = ValueAnimator.ofInt(mHeight, 0).setDuration(800);
        mVAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                mLinearLayout.setPadding(0,currentValue,0,0);
            }
        });
        mVAnim.start();*/
        showToast("显示bottom");
    }

    //隐藏底部布局
    private void hideBottom() {
        /*mVAnim = ValueAnimator.ofInt(0, mHeight).setDuration(800);
        mVAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                mLinearLayout.setPadding(0,currentValue,0,0);
            }
        });
        mVAnim.start();*/
        showToast("隐藏bottom");
    }


    @Override
    public Object getData() {

        return "";
    }

    @Override
    public void refresh() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mDetector.onTouchEvent(event);
    }

    private class GestureListener implements GestureDetector.OnGestureListener {
        //手指下滑
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        //按下一小段事件但是没有滑动
        @Override
        public void onShowPress(MotionEvent e) {

        }

        //轻触
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        //滑动
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            //像下滑动
            if (distanceY > 0) {
                // TODO: 2017/2/27  隐藏mLineLayout
                hideBottom();
                return true;
            } else {
                showBottom();
                return true;
            }
        }

        //长按
        @Override
        public void onLongPress(MotionEvent e) {

        }

        //飞一样的滑动
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }


}
