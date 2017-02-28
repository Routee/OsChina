package com.zssfw.oschina.ui.pager.found.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.found.bean.UserInfoBean;
import com.zssfw.oschina.ui.pager.found.manager.XmlCacheTool;
import com.zssfw.oschina.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class FoundFriendDetailsActivity extends AppCompatActivity {

    private TextView                mTv;
    private Toolbar                 mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private List<String> mShowItems = new ArrayList<>();
    private ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_friend_details);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mLv = (ListView) findViewById(R.id.lv_friendinfo);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
        for (int i = 0; i < 30; i++) {
            mShowItems.add("条目" + i);
        }
        mLv.setAdapter(new ArrayAdapter<String>(FoundFriendDetailsActivity.this, android.R.layout.simple_list_item_1, mShowItems));
        getData();

    }

    private void getData() {
        Intent intent = getIntent();
        final String s = intent.getStringExtra(Constant.FRIENDDETAILS);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final UserInfoBean bean = XmlCacheTool.getInstance().getCacheBean(s, UserInfoBean.class);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initView(bean);
                    }
                }).start();
            }
        }).start();
    }

    private void initView(UserInfoBean bean) {

    }
}
