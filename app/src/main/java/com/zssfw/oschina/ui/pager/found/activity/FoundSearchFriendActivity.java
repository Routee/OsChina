package com.zssfw.oschina.ui.pager.found.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.zssfw.oschina.R;
import com.zssfw.oschina.manager.HttpManager;
import com.zssfw.oschina.ui.pager.found.bean.FoundUserBean;
import com.zssfw.oschina.ui.pager.found.utils.Xml2JsonUtil;
import com.zssfw.oschina.util.GsonUtil;
import com.zssfw.oschina.util.Uris;
import com.zssfw.oschina.util.Util;

import java.util.List;


public class FoundSearchFriendActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar                                            mTb;
    private RecyclerView                                       mRv;
    private ImageView                                          mIv;
    private List<FoundUserBean.OschinaBean.UsersBean.UserBean> mShowItems;
    private RecyclerView.Adapter mAdapter;
    private Animation mAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_search_friend);
        mTb = (Toolbar) findViewById(R.id.tb_found_search);
        mRv = (RecyclerView) findViewById(R.id.rv_found_search);
        mIv = (ImageView) findViewById(R.id.iv_found_search);
        mTb.setTitle("");
        mAnim = AnimationUtils.loadAnimation(this, R.anim.refresh_rotate);
        setSupportActionBar(mTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initRecyclerView();
    }

    private void initRecyclerView() {

        mRv.setLayoutManager(new LinearLayoutManager(FoundSearchFriendActivity.this));
        mAdapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = View.inflate(FoundSearchFriendActivity.this, R.layout.item_found_search, null);
                return new UserViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder hold, int position) {
                final UserViewHolder holder = (UserViewHolder) hold;
                try {
                    Glide.with(getApplicationContext()).load(mShowItems.get(position).getPortrait().get(0)).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.mIvHead) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            holder.mIvHead.setImageDrawable(circularBitmapDrawable);
                        }
                    });
                } catch (Exception e) {
                    Glide.with(getApplicationContext()).load(R.mipmap.widget_dface).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.mIvHead) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                            circularBitmapDrawable.setCircular(true);
                            holder.mIvHead.setImageDrawable(circularBitmapDrawable);
                        }
                    });
                }
                holder.mTvName.setText(mShowItems.get(position).getName().get(0) + "");
                if (TextUtils.equals(mShowItems.get(position).getGender().get(0), "男")) {
                    holder.mIvSex.setImageResource(R.mipmap.userinfo_icon_male);
                } else {
                    holder.mIvSex.setImageResource(R.mipmap.userinfo_icon_female);
                }
                try {
                    holder.mTvDestination.setText(mShowItems.get(position).getFrom().get(0));
                } catch (Exception e) {
                    holder.mTvDestination.setText("");
                }
            }

            @Override
            public int getItemCount() {
                if (mAnim.hasStarted()) {
                    mIv.clearAnimation();
                }
                mIv.setVisibility(View.GONE);
                return mShowItems == null ? 0 : mShowItems.size();
            }

            class UserViewHolder extends RecyclerView.ViewHolder {
                public ImageView mIvHead;
                public TextView  mTvName;
                public ImageView mIvSex;
                public TextView  mTvDestination;

                public UserViewHolder(View view) {
                    super(view);
                    mIvHead = (ImageView) view.findViewById(R.id.iv_found_head);
                    mTvName = (TextView) view.findViewById(R.id.tv_found_name);
                    mIvSex = (ImageView) view.findViewById(R.id.iv_found_sex);
                    mTvDestination = (TextView) view.findViewById(R.id.tv_found_destination);
                }
            }
        };
        mRv.setAdapter(mAdapter);
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
        mIv.setVisibility(View.VISIBLE);
        mIv.startAnimation(mAnim);
        if (mShowItems != null) {
            mShowItems.clear();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                String xmlStr = HttpManager.getInstance().dataGet(Uris.FOUND_SEARCH_USER + newText);
                String json = Xml2JsonUtil.xml2JSON(xmlStr);
                if (TextUtils.isEmpty(json)) {
                    return;
                }
                FoundUserBean bean = GsonUtil.parseJsonToBean(json, FoundUserBean.class);
                try {
                    mShowItems = bean.getOschina().getUsers().get(0).getUser();
                } catch (Exception e) {

                }
                Util.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
        return true;
    }
}
