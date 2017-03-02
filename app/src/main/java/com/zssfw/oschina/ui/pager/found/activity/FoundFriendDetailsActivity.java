package com.zssfw.oschina.ui.pager.found.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.ui.pager.found.adapter.FoundRecyclerViewAdapter;
import com.zssfw.oschina.ui.pager.found.bean.UserInfoBean;
import com.zssfw.oschina.ui.pager.found.bean.UserInfoItemBean;
import com.zssfw.oschina.ui.pager.found.manager.XmlCacheTool;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.Uris;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.util.Uris.FOUND_FRIEND1;
import static com.zssfw.oschina.util.Uris.FOUND_FRIEND2;
import static com.zssfw.oschina.util.Uris.FOUND_FRIEND3;

public class FoundFriendDetailsActivity extends AppCompatActivity {

    private TextView                mTv;
    private Toolbar                 mToolbar;
    private CollapsingToolbarLayout mCollaToolBar;
    private List<UserInfoItemBean> mShowItems = new ArrayList<>();
    private RecyclerView mRv;
    private boolean isDown     = false;
    private String  intentName = "";
    private String  intentId   = "";
    private int     page       = 0;
    private SwipeRefreshLayout mSRL;
    private UserInfoBean mBean;
    private FoundRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取intent传递的值
        Intent intent = getIntent();
        intentName = intent.getStringExtra(Constant.FRIENDDETAILS_NAME);
        intentId = intent.getStringExtra(Constant.FRIENDDETAILS_ID);

        setContentView(R.layout.activity_found_friend_details);
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
        mCollaToolBar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollaToolBar.setTitle(intentName);
        //通过CollapsingToolbarLayout修改字体颜色
        mCollaToolBar.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollaToolBar.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FoundRecyclerViewAdapter(mShowItems);
        mRv.setAdapter(mAdapter);
        getData();
    }

    //获取联系人信息
    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = FOUND_FRIEND1 + page + FOUND_FRIEND2 + intentName + FOUND_FRIEND3 + intentId;
                mBean = XmlCacheTool.getInstance().getCacheBean(url, UserInfoBean.class);
                initItemView(mBean);
            }
        }).start();
    }

    //设置Item展示条目数据信息
    private void initItemView(UserInfoBean bean) {
        List<UserInfoBean.OschinaBean.ActiviesBean.ActiveBean> item = bean.getOschina().getActivies().get(0).getActive();
        for (int i = 0; i < item.size(); i++) {
            String id = item.get(i).getObjectID().get(0);
            String url = Uris.FOUND_FRIENDINFO_LISTITEM + id;
            UserInfoItemBean cacheBean = JsonCacheManager.getInstance().getCacheBean(url, UserInfoItemBean.class);
            mShowItems.add(cacheBean);
        }
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    //初始化标题头
    private void initTitleView(UserInfoBean bean) {
        UserInfoBean.OschinaBean.UserBean userInfo = bean.getOschina().getUser().get(0);
        //头像地址:     userInfo.getPortrait().get(0);
        //性别:       userInfo.getGender().get(0);
        //姓名:       userInfo.getName().get(0);
        //描述:       userInfo.getDevplatform().get(0);
        //积分:       userInfo.getScore().get(0);
        //关注:       userInfo.getFollowers().get(0);
        //粉丝:       userInfo.getFans().get(0);
    }
}
