package com.zssfw.oschina.ui.pager.found;

import android.content.Intent;
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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zxing.android.CaptureActivity;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class FoundPager extends BaseFragment {
    @Bind(R.id.ll_found_ossoftware)
    LinearLayout mLlFoundOssoftware;
    @Bind(R.id.ll_found_offlineact)
    LinearLayout mLlFoundOfflineact;
    @Bind(R.id.ll_found_finduser)
    LinearLayout mLlFoundFinduser;
    @Bind(R.id.ll_found_nearfriend)
    LinearLayout mLlFoundNearfriend;
    @Bind(R.id.ll_found_scan)
    LinearLayout mLlFoundScan;
    @Bind(R.id.ll_found_shake)
    LinearLayout mLlFoundShake;

    @Override
    public View createView() {
        View view = View.inflate(MyApplication.mContent, R.layout.page_found, null);
        ButterKnife.bind(FoundPager.this, view);
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


    @OnClick({R.id.ll_found_ossoftware, R.id.ll_found_offlineact, R.id.ll_found_finduser, R.id.ll_found_nearfriend, R.id.ll_found_scan, R.id.ll_found_shake})
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
                Toast.makeText(MyApplication.mContent, "搜索好友", Toast.LENGTH_SHORT).show();
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
}
