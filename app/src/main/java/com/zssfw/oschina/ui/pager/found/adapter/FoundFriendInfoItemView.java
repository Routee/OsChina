package com.zssfw.oschina.ui.pager.found.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.found.bean.UserInfoBean;
import com.zssfw.oschina.ui.pager.found.widget.CircleImageView;

/**
 * Created by Routee on 2017/3/1.
 */
public class FoundFriendInfoItemView extends RecyclerView.ViewHolder {
    private       CircleImageView mIvAvatar;
    private       TextView        mTvName;
    private       TextView        mTvSpanTopic;
    private       TextView        mTvDsc;
    private       TextView        mTvTime;
    private       TextView        mTvComments;
    private       int             type;
    private final TextView        mTvNone;

    public FoundFriendInfoItemView(View itemView, int foot) {
        super(itemView);
        type = foot;
        mIvAvatar = (CircleImageView) itemView.findViewById(R.id.iv_avatar);
        mTvName = (TextView) itemView.findViewById(R.id.tv_name);
        mTvSpanTopic = (TextView) itemView.findViewById(R.id.tv_span_topic);
        mTvDsc = (TextView) itemView.findViewById(R.id.tv_dsc);
        mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
        mTvComments = (TextView) itemView.findViewById(R.id.tv_comments);
        mTvNone = (TextView) itemView.findViewById(R.id.tv_none);
    }

    public void setView(UserInfoBean.OschinaBean.ActiviesBean.ActiveBean bean) {
        if (type == FoundRecyclerViewAdapter.FOOT) {
            mIvAvatar.setVisibility(View.GONE);
            mTvName.setVisibility(View.GONE);
            mTvSpanTopic.setVisibility(View.GONE);
            mTvTime.setVisibility(View.GONE);
            mTvDsc.setVisibility(View.GONE);
            mTvComments.setVisibility(View.GONE);
            mTvNone.setVisibility(View.VISIBLE);
            mTvNone.setText("没有更多数据了");
            return;
        }
        try {
            Glide.with(MyApplication.mContent).load(bean.getPortrait().get(0)).into(mIvAvatar);
        } catch (Exception e) {
            Glide.with(MyApplication.mContent).load(R.mipmap.widget_dface).into(mIvAvatar);
        }
        mTvName.setText(bean.getAuthor().get(0));
        String typeHead = "";
        String typeFoot = "";
        switch (Integer.parseInt(bean.getObjecttype().get(0))) {
            case 16:
                typeHead = "在新闻:";
                typeFoot = "发表评论";
                break;
            case 17:
                typeHead = "回答了问题:";
                typeFoot = "";
                break;
            case 2:
                typeHead = "发表了新话题:";
                typeFoot = "";
                break;
            case 4:
                typeHead = "发表了一篇新闻";
                typeFoot = "";
                break;
            default:
                typeHead = "在话题:";
                typeFoot = "中,如是说:";
                break;

        }
        try {
            String title = bean.getObjecttitle().get(0);
            String text = typeHead + title + typeFoot;
            SpannableString spannableString = new SpannableString(text);
            spannableString.setSpan(new AbsoluteSizeSpan(20, true), typeHead.length(), typeHead.length() + title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0E5986")), typeHead.length(), typeHead.length() + title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mTvSpanTopic.setText(spannableString);
        } catch (Exception e) {
            mTvSpanTopic.setVisibility(View.GONE);
        }
        if (bean.getCatalog().get(0).equals("0")) {
            mTvDsc.setText("加入了开源中国...");
        } else {
            SpannableString string = new SpannableString(bean.getMessage().get(0));
            mTvDsc.setText(string);
        }
        mTvTime.setText(bean.getPubDate().get(0).split(" ")[0]);
        mTvComments.setText(bean.getCommentCount().get(0) + "");
    }
}
