package com.zssfw.oschina.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.zssfw.oschina.R;
import com.zssfw.oschina.util.Constant;

import java.util.List;

/**
 * Created by SJJ on 2017/2/26.
 * 描述 ${TODO}
 */

public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {


    private final List<? extends Object>    mList;
    private       OnItemClickListener       mListener;
    private       LinearLayout.LayoutParams mLayoutParams;

    public BaseRecyclerViewAdapter(List<? extends Object> list) {
        mList = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emoji, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        View view = holder.itemView;
        ImageView iv = (ImageView) view.findViewById(R.id.iv_emoji);
        if (mList.get(position) instanceof Integer) {
            if (mLayoutParams == null) {
                mLayoutParams = new LinearLayout.LayoutParams(Constant.widthpixels / Constant.EMOJI_LIE, Constant.widthpixels / Constant.EMOJI_LIE);
//                mLayoutParams.setMargins(20,20,20,20);
            }
            iv.setImageResource(((Integer) mList.get(position)));
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(mLayoutParams);
            int pad = Constant.widthpixels / Constant.EMOJI_LIE / Constant.EMOJI_LIE;
            iv.setPadding(pad, pad, pad, pad);
        } else if (mList.get(position) instanceof String) {
            Picasso.with(view.getContext()).load(((String) mList.get(position))).into(iv);
            iv.setPadding(0, 0, 10, 10);
        } else {
            return;
        }
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(position);
                }

            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

}
