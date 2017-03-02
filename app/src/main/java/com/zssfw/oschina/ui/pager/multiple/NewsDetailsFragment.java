package com.zssfw.oschina.ui.pager.multiple;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.FinalListAdapter;
import com.zssfw.oschina.bean.NewsCommentBean;
import com.zssfw.oschina.bean.NewsDetailsBean;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.ui.act.CommentDialog;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.ui.widget.MyListView;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.zssfw.oschina.util.Constant.BUNDLE_MSG_ID;
import static com.zssfw.oschina.util.Constant.HOST;
import static com.zssfw.oschina.util.Constant.MESSAGE;
import static com.zssfw.oschina.util.Constant.NEWS_COMMENT;
import static com.zssfw.oschina.util.Constant.NEWS_DETAILS;

/**
 * Created by Administrator on 2017/2/24.
 */


public class NewsDetailsFragment extends BaseFragment implements View.OnKeyListener {

    @Bind(R.id.textView_comment)
    TextView   mTextViewComment;
    @Bind(R.id.listview_comment)
    MyListView mListviewComment;
    @Bind(R.id.et_comment)
    EditText   mEtComment;
    private List<NewsDetailsBean.ResultBean.AboutsBean> aboutsBeen  = new ArrayList<>();
    private List<NewsCommentBean.ResultBean.ItemsBean>  commentItem = new ArrayList<>();
    private NewsDetailsBean mDetailsBean;
    private TextView        mTv_title;
    private TextView        mTv_time;
    private WebView         mWebview;
    private LinearLayout    mSoft_layout;
    private ListView        mListview_soft;
    private ListView        mListview_recomend;
    private NewsCommentBean mNewsCommentBean;
    private TextView mTv_comment;
    private int mId1;


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

        ButterKnife.bind(this, view);
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
        //        int type=bundle.getInt(BUNDLE_MSG_TYPE);
        mDetailsBean = JsonCacheManager.getInstance().getCacheBean(HOST + NEWS_DETAILS + id, NewsDetailsBean.class);

        mNewsCommentBean = JsonCacheManager.getInstance()
                .getCacheBean(HOST + NEWS_COMMENT + id + "&type=6", NewsCommentBean.class);
        //        "/action/apiv2/comment?parts=refer,reply&sourceId=77953&type=6"

        if (mDetailsBean.getMessage().equalsIgnoreCase(MESSAGE)) {
            aboutsBeen.addAll(mDetailsBean.getResult().getAbouts());
            commentItem.addAll(mNewsCommentBean.getResult().getItems());
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
            NewsCommentBean.ResultBean mNewsCommentBeanResult = mNewsCommentBean.getResult();

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
                    startShowActivity("资讯详情", aboutList.get(position).getCommentCount(), aboutList.get(position).getId(), NewsDetailsFragment.class);
                    System.out.println("跳转");
                }
            };
            mListview_recomend.setAdapter(recommendAdapter);

            //热门评论
            final List<NewsCommentBean.ResultBean.ItemsBean> commentList = mNewsCommentBeanResult.getItems();
            FinalListAdapter<NewsCommentBean.ResultBean.ItemsBean> itemsBeanFinalListAdapter = new
                    FinalListAdapter<NewsCommentBean.ResultBean.ItemsBean>(commentList, R.layout.news_comment_item, new FinalListAdapter.OnFinalListAdapterListener<NewsCommentBean.ResultBean.ItemsBean>() {
                @Override
                public void bindView(FinalListAdapter.FinalListViewHolder holder, final NewsCommentBean.ResultBean.ItemsBean item) {

                    holder.setText(R.id.comment_tv_name, item.getAuthor());
                    holder.setText(R.id.comment_tv_desc, item.getContent());
                    holder.setText(R.id.comment_tv_time, Util.parseTime(item.getPubDate()));
                    mTv_comment = (TextView) holder.getView(R.id.comment_tv_comment);

                    mTextViewComment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Dialog dialog =new CommentDialog(NewsDetailsFragment.this,mId1);
                            dialog.show();
                        }
                    });

                    mEtComment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //回复文章
                            int id = mDetailsBean.getResult().getId();
                            System.out.println("id11===="+id);
                            Dialog dialog =new CommentDialog(NewsDetailsFragment.this,id);
                            dialog.show();
                        }
                    });

                    final ImageView holderView = (ImageView) holder.getView(R.id.comment_iv_head_pic);
                    Glide.with(getContext()).load(item.getAuthorPortrait()).asBitmap().centerCrop().into(new BitmapImageViewTarget(holderView) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(getContext().getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            holderView.setImageDrawable(circularBitmapDrawable);
                        }
                    });
                }


            }){
                        @Override
                        public void onItemClick(final int position) {
                            super.onItemClick(position);
//                            mTv_comment.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
//                                    //回复个人
//                                    int id1 = commentList.get(position).getId();
//
//
//
//                                    System.out.println("id===="+id1);
//
//                                    //                            Dialog dialog =new CommentDialog(NewsDetailsFragment.this, android.R.attr.id);
//                                    //                            dialog.show();
//                                }
//                            });

                            mId1 = commentList.get(position).getId();
                            Dialog dialog =new CommentDialog(NewsDetailsFragment.this,mId1);
                            dialog.show();
                            System.out.println("id===="+ mId1);
                        }
                    };
            mListviewComment.setAdapter(itemsBeanFinalListAdapter);

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

