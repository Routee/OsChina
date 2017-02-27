package com.zssfw.oschina.ui.pager.mine;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.OschinaBean;
import com.zssfw.oschina.manager.CacheManager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.SPUtil;
import com.zssfw.oschina.util.XmlUtil;

/**
 * Created by leoo on 2017-2-24.
 */

public class LogoutFragment extends BaseFragment implements View.OnClickListener {

    private TextView mTvUsername;
    private TextView mTvLocation;
    private Button mBt;

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.logout_fragment, null);
        mTvUsername = (TextView) view.findViewById(R.id.tv_username);
        mTvLocation = (TextView) view.findViewById(R.id.tv_location);
        mBt = (Button) view.findViewById(R.id.bt_logout);
        OschinaBean data = (OschinaBean) getData();
        mTvUsername.setText(data.getUser().getName());
        mTvLocation.setText(data.getUser().getLocation());
        mBt.setOnClickListener(this);
        return view;
    }

    @Override
    public Object getData() {
        String content = CacheManager.getInstance().getCacheData(Constant.LOGIN);

        OschinaBean bean = XmlUtil.getInstance().xmlToBean(content, OschinaBean.class);
        return bean;
    }

    @Override
    public void refresh() {

    }

    @Override
    public void onClick(View view) {
        SPUtil.saveState(false);
        getActivity().finish();
    }
}
