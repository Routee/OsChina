package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @创建者 administrator
 * @创建时间 2017/2/25 13:42
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/25$
 * @更新描述 ${TODO}
 */

public abstract class DYBaseFragMent extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return setView(inflater);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUIData();
    }

    protected abstract void setUIData();

    public abstract View setView(LayoutInflater inflater);
}
