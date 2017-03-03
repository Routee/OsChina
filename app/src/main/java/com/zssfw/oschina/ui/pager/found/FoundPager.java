package com.zssfw.oschina.ui.pager.found;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.act.FoundShowActivity;
import com.zssfw.oschina.ui.pager.found.activity.FoundSearchFriendActivity;
import com.zssfw.oschina.ui.pager.found.fragment.OSSoftwareFragment;
import com.zssfw.oschina.ui.pager.found.fragment.ShakeFragment;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;

import zxing.android.CaptureActivity;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class FoundPager extends BaseFragment implements View.OnClickListener {
    private LinearLayout mLlFoundOssoftware;
    private LinearLayout mLlFoundOfflineact;
    private LinearLayout mLlFoundFinduser;
    private LinearLayout mLlFoundNearfriend;
    private LinearLayout mLlFoundScan;
    private LinearLayout mLlFoundShake;

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        View view = View.inflate(MyApplication.mContent, R.layout.page_found, null);
        mLlFoundOssoftware = (LinearLayout) view.findViewById(R.id.ll_found_ossoftware);
        mLlFoundOfflineact = (LinearLayout) view.findViewById(R.id.ll_found_offlineact);
        mLlFoundFinduser = (LinearLayout) view.findViewById(R.id.ll_found_finduser);
        mLlFoundNearfriend = (LinearLayout) view.findViewById(R.id.ll_found_nearfriend);
        mLlFoundScan = (LinearLayout) view.findViewById(R.id.ll_found_scan);
        mLlFoundShake = (LinearLayout) view.findViewById(R.id.ll_found_shake);
        mLlFoundOssoftware.setOnClickListener(this);
        mLlFoundOfflineact.setOnClickListener(this);
        mLlFoundFinduser.setOnClickListener(this);
        mLlFoundNearfriend.setOnClickListener(this);
        mLlFoundScan.setOnClickListener(this);
        mLlFoundShake.setOnClickListener(this);
        return view;
    }

    @Override
    public Object getData() {
        return "";
    }

    //    @Override
    public void initData() {

    }

    @Override
    public void refresh() {

    }


    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.ll_found_ossoftware:
                intent = new Intent(MyApplication.mContent, FoundShowActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Constant.FOUNDTITLE, "开源软件");
                intent.putExtra(Constant.FOUNDFRAGMENT, OSSoftwareFragment.class);
                startActivity(intent);
                break;
            case R.id.ll_found_offlineact:
                Toast.makeText(MyApplication.mContent, "线下活动", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_found_finduser:
                intent = new Intent(MyApplication.mContent, FoundSearchFriendActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.ll_found_nearfriend:
                Toast.makeText(MyApplication.mContent, "附近程序员", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_found_scan:
                intent = new Intent(MyApplication.mContent, CaptureActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent, Constant.SCANREQUESTCODE);
                break;
            case R.id.ll_found_shake:
                intent = new Intent(MyApplication.mContent, FoundShowActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(Constant.FOUNDTITLE, "摇一摇");
                intent.putExtra(Constant.FOUNDFRAGMENT, ShakeFragment.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
