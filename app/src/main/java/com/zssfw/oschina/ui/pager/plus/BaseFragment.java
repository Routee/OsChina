package com.zssfw.oschina.ui.pager.plus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zssfw.oschina.manager.SelectPage;
import com.zssfw.oschina.ui.act.ShowActivity;
import com.zssfw.oschina.util.Constant;

import butterknife.ButterKnife;


/**
 * Created by SJJ on 2017/2/18.
 * 描述 ${二级页面基类}
 */

public abstract class BaseFragment extends Fragment {

    public SelectPage mSelectPage;
    public boolean haveData = false;
    private ProgressDialog mDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mSelectPage == null) {
            mSelectPage = new SelectPage(getContext()) {
                @Override
                protected SwipeRefreshLayout getSwipeRefresh() {
                    return getSwipeRefreshLayout();
                }

                @Override
                public Object getNetData() {
                    return getData();
                }

                @Override
                public View createSuccessView() {
                    return createView();
                }
            };
        }
        return mSelectPage;
    }

    public abstract SwipeRefreshLayout getSwipeRefreshLayout();

    public abstract View createView();

    public abstract Object getData();

    public abstract void refresh();

    public void showDialog(String msg) {
        mDialog = new ProgressDialog(getContext());
        mDialog.setMessage(msg);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    public void hideDialog() {
        mDialog.dismiss();
    }

    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param title 标题
     * @param comment 评论数 -1不显示
     * @param id 传递id
     * @param fragmentClass 要打开的Fragment
     */
    public void startShowActivity(String title, int comment,int id, Class<? extends BaseFragment> fragmentClass) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BUNDLE_MSG_TITLE,title );
        bundle.putInt(Constant.BUNDLE_MSG_COMMENT,comment);
        bundle.putInt(Constant.BUNDLE_MSG_ID,id);


        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(Constant.INTENT_CLASS,fragmentClass );
        intent.putExtra(Constant.BUNDLE, bundle);
        startActivity(intent);
    }

    public void startShowActivity2(String title, int comment,String url, Class<? extends BaseFragment> fragmentClass) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BUNDLE_MSG_TITLE,title );
        bundle.putInt(Constant.BUNDLE_MSG_COMMENT,comment);
        bundle.putString(Constant.BUNDLE_MSG_URL,url);


        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(Constant.INTENT_CLASS,fragmentClass );
        intent.putExtra(Constant.BUNDLE, bundle);
        startActivity(intent);
    }


    /**
     * @param type 根据资讯类型 判断跳转
     * @return
     */
    public void startShowActivityWithType(int type,int comment,int id, Class<? extends BaseFragment> fragmentClass) {
        String typeTitle = "资讯详情";
        switch (type) {
            case 6:
                typeTitle = "资讯详情";
                break;
            case 5:
                typeTitle = "活动详情";
                break;
            case 4:
                typeTitle = "翻译详情";
                break;
            case 3:
                typeTitle = "博客详情";
                break;
            case 2:
                typeTitle = "还没找到";
                break;
            case 1:
                typeTitle = "软件详情";
                break;
            case 0:
                // TODO: 2017/2/25 浏览器打开
                break;
            default:
                break;
        }
        startShowActivity(typeTitle, comment, id, fragmentClass);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}

