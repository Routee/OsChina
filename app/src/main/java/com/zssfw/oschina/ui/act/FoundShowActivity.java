package com.zssfw.oschina.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.zssfw.oschina.R;
import com.zssfw.oschina.util.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoundShowActivity extends AppCompatActivity {

    @Bind(R.id.tb_found_title)
    Toolbar     mTb;
    @Bind(R.id.framelayout)
    FrameLayout mFramelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String title = intent.getStringExtra(Constant.FOUNDTITLE);
        mTb.setTitle(title);
        setSupportActionBar(mTb);
        Class clazz = (Class) intent.getSerializableExtra(Constant.FOUNDFRAGMENT);
        try {
            Fragment fragment = (Fragment) clazz.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
