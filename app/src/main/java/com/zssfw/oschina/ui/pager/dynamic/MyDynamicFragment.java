package com.zssfw.oschina.ui.pager.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.dynamic.dyfg.Mydy;

/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class MyDynamicFragment extends Fragment {

    private LinearLayout mLl_error_dy;
    private boolean islogin = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fg_dy_tv, null);
        mLl_error_dy = (LinearLayout) view.findViewById(R.id.ll_error_dy);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (islogin) {
            mLl_error_dy.setVisibility(View.GONE);
            initdata("http://www.oschina.net/action/apiv2/tweets?authorId=3292587");
            Mydy mydy = new Mydy();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment_tv,mydy).commit();
        } else {
            //未登录
            mLl_error_dy.setVisibility(View.VISIBLE);
        }
    }

    private void initdata(String uri) {

    }
}
