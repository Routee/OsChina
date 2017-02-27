package com.zssfw.oschina.ui.pager.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.OschinaBean;
import com.zssfw.oschina.manager.CacheManager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.ui.widget.RoundImageView;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.GlobalActivity;
import com.zssfw.oschina.util.SPUtil;
import com.zssfw.oschina.util.Util;
import com.zssfw.oschina.util.XmlUtil;



/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class MinePager extends BaseFragment implements View.OnClickListener {
    private RoundImageView mIv_photo;
    private TextView mTv;
    private View mLogout;
    private View mFoot;
    private View mLogin;
    private TextView mTvUsername;
    private ImageView mIvSex;
    private RoundImageView mRivLogin;


    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        mLogout = view.findViewById(R.id.ll_login_false);
        mFoot = view.findViewById(R.id.ll_mine_foot);
        mLogin = view.findViewById(R.id.rl_login_true);
        mLogin.setVisibility(View.INVISIBLE);
        mFoot.setVisibility(View.INVISIBLE);
        mTvUsername = (TextView) view.findViewById(R.id.tv_username_login);
        mIvSex = (ImageView) view.findViewById(R.id.iv_ismale);
        mRivLogin = (RoundImageView) view.findViewById(R.id.iv_head_photo_login);
        mIv_photo = (RoundImageView) view.findViewById(R.id.iv_head_photo);
        mTv = (TextView) view.findViewById(R.id.tv_username);
        mIv_photo.setOnClickListener(this);
        mRivLogin.setOnClickListener(this);
        mTv.setOnClickListener(this);
        return view;
    }

    @Override
    public Object getData() {
        String content = CacheManager.getInstance().getCacheData(Constant.LOGIN);
        System.out.println(content);

        OschinaBean bean = XmlUtil.getInstance().xmlToBean(content, OschinaBean.class);

        return bean;
    }

//    @Override
    public void initData() {

    }

    @Override
    public void refresh() {


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_head_photo:
            case R.id.tv_username:
                Intent intent = new Intent(MyApplication.mContent, GlobalActivity.class);
                Bundle bundle = new Bundle();
                intent.putExtra(Constant.FRAGMENTNAME, LoginFragment.class);
                startActivity(intent);
                break;
            case R.id.iv_head_photo_login:
                Intent intent1 = new Intent(MyApplication.mContent, GlobalActivity.class);
                intent1.putExtra(Constant.FRAGMENTNAME, LogoutFragment.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        final OschinaBean data = (OschinaBean) getData();
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (SPUtil.getState()) {
                    mLogout.setVisibility(View.INVISIBLE);
                    mLogin.setVisibility(View.VISIBLE);
                    mFoot.setVisibility(View.VISIBLE);
                    mTvUsername.setText(data.getUser().getName());
                    if (data.getUser().getGender() ==2) {
                        mIvSex.setImageResource(R.mipmap.userinfo_icon_female);
                    }

                }else{
                    mLogout.setVisibility(View.VISIBLE);
                    mLogin.setVisibility(View.INVISIBLE);
                    mFoot.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
