package com.zssfw.oschina.ui.pager.found.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.manager.XmlCacheManager;
import com.zssfw.oschina.ui.pager.found.bean.FoundUserBean;


public class FoundSearchFriendActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar mTb;
    private RecyclerView mRv;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_search_friend);
        mTb = (Toolbar) findViewById(R.id.tb_found_search);
        mRv = (RecyclerView) findViewById(R.id.rv_found_search);
        mIv = (ImageView) findViewById(R.id.iv_found_search);
        mTb.setTitle("");
        setSupportActionBar(mTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    //添加Menu,并设置为SearchView
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_friend_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_add_friend);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("输入用户名名称");
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(final String newText) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                FoundUserBean bean = XmlCacheManager.getInstance().getBean("http://www.oschina.net/action/api/find_user?name=" + newText, FoundUserBean.class);
                String name = bean.getUserBean().get(0).getName();
                System.out.println(name);
            }
        }).start();
        return true;
    }
}
