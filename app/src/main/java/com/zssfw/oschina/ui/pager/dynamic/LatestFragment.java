package com.zssfw.oschina.ui.pager.dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.R;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${最新动弹  二级标签}
 */

public class LatestFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fg_dy, null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HotFragment hotFragment2 = new HotFragment(2);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, hotFragment2).commit();
    }
}
