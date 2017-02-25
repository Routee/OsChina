package com.zssfw.oschina.ui.pager.plus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.manager.SelectPage;


/**
 * Created by SJJ on 2017/2/18.
 * 描述 ${二级页面基类}
 */

public abstract class BaseFragment extends Fragment {

    public SelectPage mSelectPage;
    public boolean haveData = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mSelectPage == null) {
            mSelectPage = new SelectPage(getContext()) {
                @Override
                protected Object getNetData() {
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

    public abstract View createView();

    public abstract Object getData();

    public abstract void refresh();



    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
