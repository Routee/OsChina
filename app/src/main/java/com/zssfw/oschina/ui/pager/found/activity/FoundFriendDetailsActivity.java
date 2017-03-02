package com.zssfw.oschina.ui.pager.found.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.found.adapter.FoundRecyclerViewAdapter;
import com.zssfw.oschina.ui.pager.found.bean.UserInfoBean;
import com.zssfw.oschina.ui.pager.found.manager.XmlCacheTool;
import com.zssfw.oschina.ui.pager.found.widget.CircleImageView;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.util.Uris.FOUND_FRIEND1;
import static com.zssfw.oschina.util.Uris.FOUND_FRIEND2;
import static com.zssfw.oschina.util.Uris.FOUND_FRIEND3;

public class FoundFriendDetailsActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Toolbar                 mToolbar;
    private CollapsingToolbarLayout mCollaToolBar;
    private List<UserInfoBean.OschinaBean.ActiviesBean.ActiveBean> mShowItems = new ArrayList<>();
    private RecyclerView mRv;
    private boolean isDown     = false;
    private String  intentName = "";
    private String  intentId   = "";
    private int     page       = 0;
    private SwipeRefreshLayout       mSRL;
    private UserInfoBean             mBean;
    private FoundRecyclerViewAdapter mAdapter;
    private LinearLayout             mLlTbCollapsed;
    private CircleImageView          mIvTbAvandar;
    private TextView                 mTvTbTitle;
    private AppBarLayout             mAppBar;
    private int                      height;
    private CircleImageView          mIvAvatar;
    private ImageView                mIvSex;
    private TextView                 mTvTitle;
    private TextView                 mTvDsc;
    private TextView                 mTvScore;
    private TextView                 mTvFollowers;
    private TextView                 mTvFans;
    private boolean canLoadMore = true;
    private boolean canRefresh = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取intent传递的值
        Intent intent = getIntent();
        intentName = intent.getStringExtra(Constant.FRIENDDETAILS_NAME);
        intentId = intent.getStringExtra(Constant.FRIENDDETAILS_ID);

        setContentView(R.layout.activity_found_friend_details);
        mCollaToolBar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mAppBar = (AppBarLayout) findViewById(R.id.appbar);

        mAppBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mAppBar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height = mAppBar.getHeight();
            }
        });


        mLlTbCollapsed = (LinearLayout) findViewById(R.id.ll_tb_collapsed);
        mIvTbAvandar = (CircleImageView) findViewById(R.id.iv_tb_avandar);
        mTvTbTitle = (TextView) findViewById(R.id.tv_tb_title);


        mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset > (-(height - mToolbar.getHeight()) * 0.8)) {
                    mLlTbCollapsed.setVisibility(View.GONE);
                } else {
                    mLlTbCollapsed.setVisibility(View.VISIBLE);
                }
            }
        });

        mSRL = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);


        mRv = (RecyclerView) findViewById(R.id.lv_friendinfo);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        mCollaToolBar.setTitle(" ");

        //通过CollapsingToolbarLayout修改字体颜色
        //        mCollaToolBar.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        //        mCollaToolBar.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色

        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FoundRecyclerViewAdapter(mShowItems);
        mRv.setAdapter(mAdapter);
        //添加下拉刷新监听
        addRecyclerViewPullDownListener();
        getData();
        mSRL.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE);
        mSRL.setOnRefreshListener(this);
    }



    //获取联系人信息
    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = FOUND_FRIEND1 + page + FOUND_FRIEND2 + intentName + FOUND_FRIEND3 + intentId;
                mBean = XmlCacheTool.getInstance().getCacheBean(url, UserInfoBean.class);
                initTitleView(mBean);
                initItemView(mBean);
            }
        }).start();
    }

    //设置Item展示条目数据信息
    private void initItemView(UserInfoBean bean) {
        if (!canLoadMore) {
            return;
        }
        try {
            mShowItems.addAll(bean.getOschina().getActivies().get(0).getActive());
        } catch (Exception e) {
            mShowItems.add(null);
        }
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    //初始化标题头
    private void initTitleView(final UserInfoBean bean) {
        mIvAvatar = (CircleImageView) findViewById(R.id.iv_avatar_title);
        mIvSex = (ImageView) findViewById(R.id.iv_sex_title);
        mTvTitle = (TextView) findViewById(R.id.tv_title_title);
        mTvDsc = (TextView) findViewById(R.id.tv_dsc_title);
        mTvScore = (TextView) findViewById(R.id.tv_score_title);
        mTvFollowers = (TextView) findViewById(R.id.tv_followers_title);
        mTvFans = (TextView) findViewById(R.id.tv_fans_title);
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Glide.with(MyApplication.mContent).load(bean.getOschina().getUser().get(0).getPortrait().get(0)).into(mIvTbAvandar);
                } catch (Exception e) {
                    Glide.with(MyApplication.mContent).load(R.mipmap.widget_dface).into(mIvTbAvandar);
                }
                mTvTbTitle.setText(intentName);
                try {
                    Glide.with(MyApplication.mContent).load(bean.getOschina().getUser().get(0).getPortrait().get(0)).into(mIvAvatar);
                } catch (Exception e) {
                    Glide.with(MyApplication.mContent).load(R.mipmap.widget_dface).into(mIvAvatar);
                }
                if (bean.getOschina().getUser().get(0).getGender().get(0).equals("男")) {
                    mIvSex.setImageResource(R.mipmap.userinfo_icon_male);
                } else {
                    mIvSex.setImageResource(R.mipmap.userinfo_icon_female);
                }
                mTvTitle.setText(intentName);
                if (!bean.getOschina().getUser().get(0).getDevplatform().get(0).equals("<无>")) {
                    mTvDsc.setText(bean.getOschina().getUser().get(0).getDevplatform().get(0));
                }
                mTvScore.setText("积分 " + bean.getOschina().getUser().get(0).getScore().get(0));
                mTvFollowers.setText("关注 " + bean.getOschina().getUser().get(0).getFollowers().get(0));
                mTvFans.setText("粉丝 " + bean.getOschina().getUser().get(0).getFans().get(0));
            }
        });
    }

    @Override
    public void onRefresh() {
        page = 0;
        refreshData();
    }

    private void refreshData() {
        /*if (!canRefresh) {
            Toast.makeText(this, "没有动态了哦,亲", Toast.LENGTH_SHORT).show();
            mSRL.setRefreshing(false);
            return;
        }*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = FOUND_FRIEND1 + page + FOUND_FRIEND2 + intentName + FOUND_FRIEND3 + intentId;
                mBean = XmlCacheTool.getInstance().getCacheBean(url, UserInfoBean.class);
                mShowItems.clear();
                try {
                    mShowItems.addAll(mBean.getOschina().getActivies().get(0).getActive());
                } catch (Exception e) {
                    mShowItems.add(null);
                }
                /*if (mShowItems.size() < 20) {
                    canRefresh = false;
                }*/
                Util.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                        mSRL.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private boolean isLoading = false;

    //添加RecyclerView加载更多监听,判断是否加载更多
    private void addRecyclerViewPullDownListener() {
        if (!canLoadMore) {
            return;
        }
        final RecyclerView.LayoutManager lineLayoutManager = mRv.getLayoutManager();
        if (!(lineLayoutManager instanceof LinearLayoutManager)) {
            return;
        }
        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = lineLayoutManager.getItemCount();
                int lastVisibleItemPosition = ((LinearLayoutManager) lineLayoutManager).findLastVisibleItemPosition();
//                Log.d("aaaaaaaaaaa", "lastVisibleItemPosition==" + lastVisibleItemPosition + "\t\ttotalItemCount=" + totalItemCount + "\t\tmShowItems.size = " + mShowItems.size());
                if (!isLoading && totalItemCount <= lastVisibleItemPosition + 1) {
                    //此时是刷新状态
                    isLoading = true;
                    //loadMore
                    loadMore();
                }
            }
        });
    }


    //加载更多
    private void loadMore() {
        if (!canLoadMore) {
            return;
        }
        final int newPage = ++page;
        final int preSize = mShowItems.size();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = FOUND_FRIEND1 + newPage + FOUND_FRIEND2 + intentName + FOUND_FRIEND3 + intentId;
                mBean = XmlCacheTool.getInstance().getCacheBean(url, UserInfoBean.class);
                try {
                    mShowItems.addAll(mBean.getOschina().getActivies().get(0).getActive());
                } catch (Exception e) {
                    canLoadMore = false;
                }
                if (preSize == mShowItems.size()) {
                    if (mShowItems.size() > 1) {
                        mShowItems.add(null);
                    }
                }
                Util.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                        if (mShowItems.get(mShowItems.size() - 1) == null) {
                            isLoading = true;
                        }
                        isLoading = false;
                    }
                });
            }
        }).start();
    }
}
