package com.zssfw.oschina.ui.pager.dynamic;

import android.view.View;
import android.widget.ListView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.FinalListAdapter;
import com.zssfw.oschina.bean.DynamicBean;
import com.zssfw.oschina.manager.JsonCacheManager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.util.Constant.DYNAMIC_LATEST;
import static com.zssfw.oschina.util.Constant.HOST;
import static com.zssfw.oschina.util.Constant.MESSAGE;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${最新动弹  二级标签}
 */

public class LatestFragment extends BaseFragment implements Runnable {


    private ListView mListView;
    private List<DynamicBean.ResultBean.ItemsBean> dynamicItems = new ArrayList<>();
    private FinalListAdapter<DynamicBean.ResultBean.ItemsBean> mAdapter;

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_secondary, null);
        mListView = ((ListView) view.findViewById(R.id.secondary_listview));

        return view;
    }

    @Override
    public Object getData() {
        DynamicBean dynamicBean = JsonCacheManager.getInstance().getCacheBean(HOST + DYNAMIC_LATEST, DynamicBean.class);
        if (dynamicBean != null && MESSAGE.equalsIgnoreCase(dynamicBean.getMessage())) {
            dynamicItems.addAll(dynamicBean.getResult().getItems());

            Util.runOnUIThread(this);
            return dynamicBean;
        }

        return "";
    }

    public void refresh() {
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void run() {
        mAdapter = new FinalListAdapter<>(dynamicItems, R.layout.item_dynamic,
                new FinalListAdapter.OnFinalListAdapterListener<DynamicBean.ResultBean.ItemsBean>() {
                    @Override
                    public void bindView(FinalListAdapter.FinalListViewHolder holder, DynamicBean.ResultBean.ItemsBean item) {
                        holder.setText(R.id.tv_title, item.getAuthor().getName());
                        holder.setText(R.id.tv_body, item.getContent());
                        holder.setText(R.id.tv_date, item.getPubDate());
                        holder.setText(R.id.tv_comment, item.getCommentCount() + "");
                    }
                });
        mListView.setAdapter(mAdapter);
    }
}
