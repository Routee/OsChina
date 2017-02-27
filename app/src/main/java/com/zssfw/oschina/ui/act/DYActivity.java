package com.zssfw.oschina.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.dynamic.dyfg.CommentFragMent;
import com.zssfw.oschina.ui.pager.dynamic.dyfg.ShardFragMent;
import com.zssfw.oschina.util.Constant;

public class DYActivity extends AppCompatActivity {

    private FragmentTransaction mFragmentTransaction;
    private CommentFragMent mCommentFragMent;
    private ShardFragMent mShardFragMent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dy);
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        int id = intent.getIntExtra(Constant.DYACTIVITY,-1);
        switch (id) {
            case 2:
                //评论
                startDYCommentFM();
                break;
            case 3:
                //分享
                startDYShardFM();
                break;
        }

    }

    public void startDYShardFM() {
        if (mShardFragMent == null) {
            mShardFragMent = new ShardFragMent();
        }
        mFragmentTransaction.replace(R.id.fl_dy,mShardFragMent).commit();
    }
    public void startDYCommentFM() {
        if (mCommentFragMent == null) {
            mCommentFragMent = new CommentFragMent();
        }
        mFragmentTransaction.replace(R.id.fl_dy, mCommentFragMent).commit();
    }

    public void startDYheadImageFM() {

    }
}
