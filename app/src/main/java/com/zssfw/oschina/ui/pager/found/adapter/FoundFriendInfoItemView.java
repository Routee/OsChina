package com.zssfw.oschina.ui.pager.found.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.found.bean.UserInfoItemBean;
import com.zssfw.oschina.ui.pager.found.widget.CircleImageView;

/**
 * Created by Routee on 2017/3/1.
 */
public class FoundFriendInfoItemView extends RecyclerView.ViewHolder {
    private CircleImageView mIvAvatar;
    private TextView        mTvName;
    private TextView        mTvSpanTopic;
    private TextView        mTvDsc;
    private TextView        mTvTime;
    private TextView        mTvComments;

    public FoundFriendInfoItemView(View itemView) {
        super(itemView);
        mIvAvatar = (CircleImageView) itemView.findViewById(R.id.iv_avatar);
        mTvName = (TextView) itemView.findViewById(R.id.tv_name);
        mTvSpanTopic = (TextView) itemView.findViewById(R.id.tv_span_topic);
        mTvDsc = (TextView) itemView.findViewById(R.id.tv_dsc);
        mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
        mTvComments = (TextView) itemView.findViewById(R.id.tv_comments);
    }

    public void setView(UserInfoItemBean bean) {
        Glide.with(MyApplication.mContent).load(bean.getResult().getAuthorPortrait()).into(mIvAvatar);
        mTvName.setText(bean.getResult().getAuthor());
        String typeHead = "";
        String typeFoot = "";
        switch (bean.getCode()) {
            case 1:
                typeHead = "发表了新话题:";
                typeFoot = "发表评论";
                break;
            case 2:
                typeHead = "回答了问题:";
                typeFoot = "";
                break;
            case 3:
                typeHead = "在新闻";
                typeFoot = "发表评论";
                break;
            default:
                break;
        }
        String title = bean.getResult().getTitle();
        String text = typeHead + title + typeFoot;
        SpannableString spannableString = new SpannableString(text);
        URLSpan urlSpan = new URLSpan(bean.getResult().getHref());
        spannableString.setSpan(urlSpan, typeHead.length(), typeHead.length() + title.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvSpanTopic.setText(spannableString);
        String body = bean.getResult().getBody();
//        SpannableString dscSpannable = new SpannableString(body);
        Spanned spanned = Html.fromHtml(body);

        mTvDsc.setText(spanned);
        mTvTime.setText(bean.getResult().getPubDate().split(" ")[0]);
        mTvComments.setText(bean.getResult().getCommentCount() + "");
    }
}
