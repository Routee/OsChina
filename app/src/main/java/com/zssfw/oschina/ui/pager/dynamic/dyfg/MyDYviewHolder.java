package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.zssfw.oschina.R;

/**
 * @创建者 administrator
 * @创建时间 2017/2/26 18:58
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/26$
 * @更新描述 ${TODO}
 */

public class MyDYviewHolder extends RecyclerView.ViewHolder {

    public  ImageView mIvHeadPic;
    public  TextView mTvName;
    public  TextView mTvDesc;
    public  GridView mIvGridView;
    public  TextView mTvTime;
    public  TextView mTvDot;
    public  TextView mTvComment;
    public  TextView mTvShard;

    public MyDYviewHolder(View itemView) {
        super(itemView);
        mIvHeadPic = (ImageView) itemView.findViewById(R.id.iv_head_pic);
        mTvName = (TextView) itemView.findViewById(R.id.tv_name);
        mTvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
        mIvGridView = (GridView) itemView.findViewById(R.id.iv_gridView);
        mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
        mTvDot = (TextView) itemView.findViewById(R.id.tv_dot);
        mTvComment = (TextView) itemView.findViewById(R.id.tv_comment);
        mTvShard = (TextView) itemView.findViewById(R.id.tv_shard);
    }
}
