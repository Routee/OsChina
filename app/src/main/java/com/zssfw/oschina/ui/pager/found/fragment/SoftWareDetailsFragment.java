package com.zssfw.oschina.ui.pager.found.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.ui.pager.found.bean.SoftWareBean;
import com.zssfw.oschina.ui.pager.found.widget.MyWebView;
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

public class SoftWareDetailsFragment extends BaseFragment implements MyWebView.OnScrollListener {

    private String    mName;
    private MyWebView mWebView;
    boolean isBlog = false;
    private String       mNewUrl;
    private LinearLayout mLinearLayout;
    private TextView     mTvComment;
    private TextView     mTvCollect;
    private TextView     mTvShare;
    private boolean change = true;
    private int          mHeight;

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
        mWebView = (MyWebView) view.findViewById(R.id.wv_found_software);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.ll_bottom);
        mTvComment = (TextView) view.findViewById(R.id.tv_comment);
        mTvCollect = (TextView) view.findViewById(R.id.tv_collect);
        mTvShare = (TextView) view.findViewById(R.id.tv_share);

        //获取mLinearLayout高度信息
        mLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mHeight = mLinearLayout.getHeight();
            }
        });

        //对WebView设置监听
        mWebView.setmOnScrollListener(this);

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

    @Override
    public Object getData() {

        return "";
    }

    @Override
    public void refresh() {

    }

    @Override
    public void showOrHide(boolean show) {
        if (change != show) {

            if (!show) {
                mLinearLayout.setVisibility(View.INVISIBLE);
                initViewAnimation(mLinearLayout, false);

                //顶部显示
                //          top_bar_.setVisibility(View.VISIBLE);
                //          ConstantUtils.initViewAnimation1(top_bar_,true,true);

            } else {
                mLinearLayout.setVisibility(View.VISIBLE);
                initViewAnimation(mLinearLayout, true);

                //顶部隐藏
                //          top_bar_.setVisibility(View.INVISIBLE);
                //          ConstantUtils.initViewAnimation1(top_bar_,false,true);
            }
            change = show;
        }
    }

    @Override
    public void onScrolled(int l, int t, int oldl, int oldt) {
        //WebView的总高度
        float webViewContentHeight = mWebView.getContentHeight() * mWebView.getScale();
        //WebView的现高度
        float webViewCurrentHeight = (mWebView.getHeight() + mWebView.getScrollY());
        if ((webViewContentHeight - webViewCurrentHeight) < 10) {
            mLinearLayout.setVisibility(View.VISIBLE);
            initViewAnimation(mLinearLayout, true);
        } else {
        }
    }

    private void initViewAnimation(final LinearLayout showView, boolean isshow) {
        float[] up2down;

        float[] down2up;


        up2down = new float[]{0f, 1f};
        down2up = new float[]{1f, 0f};


        if (isshow) {
            TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                    down2up[0], Animation.RELATIVE_TO_SELF, down2up[1]);
            mShowAction.setDuration(500);
            showView.clearAnimation();
            showView.startAnimation(mShowAction);
        } else {
            TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                    0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, up2down[0], Animation.RELATIVE_TO_SELF, up2down[1]);
            mHiddenAction.setDuration(500);
            mHiddenAction.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    showView.setVisibility(View.GONE);
                    showView.invalidate();
                }
            });

            showView.clearAnimation();
            showView.startAnimation(mHiddenAction);
        }
    }
}


    
