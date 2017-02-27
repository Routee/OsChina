package com.zssfw.oschina.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.dynamic.DynamicPager;
import com.zssfw.oschina.ui.pager.found.FoundPager;
import com.zssfw.oschina.ui.pager.mine.MinePager;
import com.zssfw.oschina.ui.pager.multiple.MultiplePager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.ui.pager.plus.PlusPager;
import com.zssfw.oschina.util.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @Bind(R.id.framelayout)
    FrameLayout         mFramelayout;
    @Bind(R.id.title)
    TextView            mTitle;

    private String[]       button     = {"综合", "动弹", "发现", "我的"};
    private List<Fragment> mPagerList = new ArrayList<>();
    private MultiplePager mMultiplePager;
    private DynamicPager  mDynamicPager;
    //    private MainAdapter   mMainAdapter;
    private PlusPager     mPlusPager;
    private FoundPager    mFoundPager;
    private MinePager     mMinePager;
    private int mLastPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        initPager();
        initButton();


    }

    private void initButton() {
        BottomNavigationItem navigationItem0 = new BottomNavigationItem(R.mipmap.multiple_selected, button[0]);
        BottomNavigationItem navigationItem1 = new BottomNavigationItem(R.mipmap.dynamic_selected, button[1]);
        BottomNavigationItem navigationItem4 = new BottomNavigationItem(R.mipmap.plus, null);
        BottomNavigationItem navigationItem2 = new BottomNavigationItem(R.mipmap.found_selected, button[2]);
        BottomNavigationItem navigationItem3 = new BottomNavigationItem(R.mipmap.mine_selected, button[3]);

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                if (position != 2) {
                    mTitle.setText(button[position]);
                    BaseFragment fragment = (BaseFragment) mPagerList.get(position);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, fragment);
                    fragmentTransaction.show(fragment).commit();
                    mLastPosition = position;
                } else {
                    startTanActivity("弹一弹", -1, -1, PlusPager.class);
                    mBottomNavigationBar.selectTab(mLastPosition);
                }
            }

            @Override
            public void onTabUnselected(int position) {
//                BaseFragment fragment = (BaseFragment) mPagerList.get(position);
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.hide(fragment).commit();

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        mBottomNavigationBar.addItem(navigationItem0)
                .addItem(navigationItem1)
                .addItem(navigationItem4)
                .addItem(navigationItem2)
                .addItem(navigationItem3)
                .setActiveColor(R.color.colorPrimary)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();

    }

    private void initPager() {
        mMultiplePager = new MultiplePager();
        mDynamicPager = new DynamicPager();
        mPlusPager = new PlusPager();
        mFoundPager = new FoundPager();
        mMinePager = new MinePager();

        mPagerList.add(mMultiplePager);
        mPagerList.add(mDynamicPager);
        mPagerList.add(mPlusPager);
        mPagerList.add(mFoundPager);
        mPagerList.add(mMinePager);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, mMultiplePager).show(mMultiplePager)
                .commit();

    }
    public void startTanActivity(String title, int comment,int id, Class<? extends BaseFragment> fragmentClass) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BUNDLE_MSG_TITLE,title );
        bundle.putInt(Constant.BUNDLE_MSG_COMMENT,comment);
        bundle.putInt(Constant.BUNDLE_MSG_ID,id);


        Intent intent = new Intent(MainActivity.this, TanActivity.class);
        intent.putExtra(Constant.INTENT_CLASS,fragmentClass );
        intent.putExtra(Constant.BUNDLE, bundle);
        startActivity(intent);
    }

}
