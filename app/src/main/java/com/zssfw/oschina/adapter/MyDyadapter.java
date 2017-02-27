package com.zssfw.oschina.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.ShardBean;
import com.zssfw.oschina.interfaces.Basetype;
import com.zssfw.oschina.interfaces.Bodytype;
import com.zssfw.oschina.interfaces.Footstyp;
import com.zssfw.oschina.interfaces.Headtype;
import com.zssfw.oschina.ui.pager.dynamic.dyfg.MyDYviewHolder;

import java.util.ArrayList;

import static com.zssfw.oschina.MyApplication.mContent;

/**
 * @创建者 administrator
 * @创建时间 2017/2/26 18:38
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/26$
 * @更新描述 ${TODO}
 */

public class MyDyadapter extends RecyclerView.Adapter {

    private final Context             mContext;
    private final ArrayList<Basetype> mListData;
    private View mView;
    private MyDYviewHolder mMyDYviewHolder;

    public MyDyadapter(Context context, ArrayList<Basetype> listData) {
        this.mContext = context;
        this.mListData = listData;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mMyDYviewHolder = null;
        switch (viewType) {
            case HEADSTYP:
                TextView textView = new TextView(mContext);
                textView.setText("xx");
                mMyDYviewHolder = new MyDYviewHolder(textView);
                break;
            case BODYSTYP:
                mView = LayoutInflater.from(mContext).inflate(R.layout.dynamic_item, null);
                mMyDYviewHolder = new MyDYviewHolder(mView);
                break;
            case FOOTSTYP:
                TextView textView1 = new TextView(mContext);
                textView1.setText("    ");
                mMyDYviewHolder = new MyDYviewHolder(textView1);
                break;
        }

        return mMyDYviewHolder;
    }

    //public abstract RecyclerView.ViewHolder onsetView();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case HEADSTYP:
                break;
            case BODYSTYP:
                onBindView(position,holder);
                break;
            case FOOTSTYP:
                break;
        }
    }

    public void onBindView(int position, final RecyclerView.ViewHolder viewholder) {
        final MyDYviewHolder holder = (MyDYviewHolder) viewholder;
        ShardBean basetype = (ShardBean) mListData.get(position);
        holder.mTvName.setText(basetype.getResult().getItems().get(position).getAuthor().getName());
        holder.mTvDesc.setText(basetype.getResult().getItems().get(position).getContent());
        holder.mTvTime.setText(basetype.getResult().getItems().get(position).getPubDate());
        holder.mTvDot.setText(basetype.getResult().getItems().get(position).getStatistics().getLike()+"");
        holder.mTvComment.setText(basetype.getResult().getItems().get(position).getStatistics().getComment()+"");
        holder.mTvShard.setText(basetype.getResult().getItems().get(position).getStatistics().getTransmit()+"");
        Glide.with(mContent).load(Uri.parse(basetype.getResult().getItems().get(position).getAuthor().getPortrait())).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.mIvHeadPic) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContent.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.mIvHeadPic.setImageDrawable(circularBitmapDrawable);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    private static final int FOOTSTYP = 1;
    private static final int HEADSTYP = 2;
    private static final int BODYSTYP = 3;

    @Override
    public int getItemViewType(int position) {
        if (mListData.get(position) instanceof Headtype) {
            return HEADSTYP;
        }
        if (mListData.get(position) instanceof Bodytype) {
            return BODYSTYP;
        }
        if (mListData.get(position) instanceof Footstyp) {
            return FOOTSTYP;
        }
        return BODYSTYP;
    }

}
