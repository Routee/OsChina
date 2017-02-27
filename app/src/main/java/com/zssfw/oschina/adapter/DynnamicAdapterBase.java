package com.zssfw.oschina.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.squareup.picasso.Picasso;
import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.HotBean;
import com.zssfw.oschina.bean.ImagerBean;
import com.zssfw.oschina.ui.act.DYActivity;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.TextUtil;

import java.util.ArrayList;
import java.util.List;

import static com.zssfw.oschina.R.id.tv_name;

/**
 * @创建者 administrator
 * @创建时间 2017/2/23 17:18
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/23$
 * @更新描述 ${TODO}
 */

public class DynnamicAdapterBase extends RecyclerView.Adapter {
    private Context mContent;
    private int     size;

    int[] ID = new int[]{
            tv_name,
            R.id.tv_desc,
            R.id.tv_time,
            R.id.tv_dot,
            R.id.tv_comment,
            R.id.tv_shard,
            R.id.iv_head_pic
    };
    private DYView mDYView;

    public DynnamicAdapterBase(Context context) {
        this.mContent = context;
        this.size = 1;
    }

    public DynnamicAdapterBase(Context context, int size) {
        this.mContent = context;
        this.size = size;
    }

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContent).inflate(R.layout.dynamic_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public  ViewHolder getinstenser(View view) {
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private int clickID;
        private int mId;
        private View      mView;
        private TextView  mTv_name;
        private ImageView mImageView;
        private TextView  mTv_desc;
        private TextView  mTv_time;
        private TextView  mTv_dot;
        private TextView  mTv_comment;
        private TextView  mTv_shard;
        private ImageView mIv_head_pic;
        ArrayList<String> mImageList = new ArrayList<>();
        private       ImageView               mImageView1;
        private       GridView                mIv_gridView;
        private       ArrayAdapter<ImageView> mGridAdapter;
        private       MyGlidviewAdapter       mMyGlidviewAdapter;
        private       ImagerBean              mImagerBean;
        private       TextUtil                mTextUtil;



        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            if (mView == null) {
                mView = View.inflate(mContent.getApplicationContext(), R.layout.dynamic_item, null);
            }
            mImagerBean = new ImagerBean();
            mTextUtil = new TextUtil(this);
            mTv_name = (TextView) mView.findViewById(tv_name);
            mTv_desc = (TextView) mView.findViewById(R.id.tv_desc);
            mTv_time = (TextView) mView.findViewById(R.id.tv_time);
            mTv_dot = (TextView) mView.findViewById(R.id.tv_dot);
            mTv_comment = (TextView) mView.findViewById(R.id.tv_comment);
            mTv_shard = (TextView) mView.findViewById(R.id.tv_shard);
            mIv_head_pic = (ImageView) mView.findViewById(R.id.iv_head_pic);

            mIv_gridView = (GridView) mView.findViewById(R.id.iv_gridView);

            mMyGlidviewAdapter = new MyGlidviewAdapter(mImageList);
            mIv_gridView.setAdapter(mMyGlidviewAdapter);



        }

        public void setTextS(HotBean.ResultBean.ItemsBean mItems, int id) {
            clickID = id;
            mTv_comment.setEnabled(false);
            mTv_shard.setEnabled(false);

            setTextS(mItems);
        }
        public void setTextS( HotBean.ResultBean.ItemsBean mItems) {
            clickID = getItemCount();
            mId = mItems.getId();
            mTv_dot.setOnClickListener(this);
            mTv_comment.setOnClickListener(this);
            mTv_shard.setOnClickListener(this);
            mIv_head_pic.setOnClickListener(this);

            mTv_name.setText(mItems.getAuthor().getName());
            mTextUtil.getTextSpannableString(mItems.getContent());
            mTv_time.setText(mItems.getPubDate());
            mTv_dot.setText(mItems.getStatistics().getLike() + "");
            mTv_comment.setText(mItems.getStatistics().getComment() + "");
            mTv_shard.setText(mItems.getStatistics().getTransmit() + "");
            Glide.with(mContent).load(Uri.parse(mItems.getAuthor().getPortrait())).asBitmap().centerCrop().into(new BitmapImageViewTarget(mIv_head_pic) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(mContent.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    mIv_head_pic.setImageDrawable(circularBitmapDrawable);

                }
            });
            final HotBean.ResultBean.ItemsBean cdmItems = mItems;
            setImageviews(cdmItems);
            if (mDYView != null) {
                mDYView.onDYView(mView);
            }

        }

        public ImageView setImageviews(HotBean.ResultBean.ItemsBean mItems) {
            List<HotBean.ResultBean.ItemsBean.ImagesBean> images = mItems.getImages();
            if (images != null && mImagerBean.getImageList.size() == 0) {
                for (int i = 0; i < images.size(); i++) {
                    mImagerBean.getImageList.add(images.get(i).getThumb());
                    mImageList.clear();
                    mImageList.addAll(mImagerBean.getImageList);
                    mMyGlidviewAdapter.notifyDataSetChanged();
                }
            } else {
                   mImageList.clear();
                   mImageList.addAll(mImagerBean.getImageList);
                   mMyGlidviewAdapter.notifyDataSetChanged();
            }
            return mImageView;
        }

        public void setDYtext(SpannableString msp) {
            mTv_desc.setText(msp);
            mTv_desc.setClickable(true);
            mTv_desc.setMovementMethod(LinkMovementMethod.getInstance());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_dot:
                   //startAC(Constant.DYSHARD);
                    break;
                case R.id.tv_comment:
                    startAC(Constant.DYCOMMENT);
                    break;
                case R.id.tv_shard:
                    startAC(Constant.DYSHARD);
                    break;
                case R.id.iv_head_pic:
                    break;
            }
        }
        private void startAC(int id) {
            Constant.ITEM_FRAG1 = clickID;
            Constant.ITEM_FRAG = Integer.toString(mId);
            Intent intent = new Intent(mContent, DYActivity.class);
            intent.putExtra(Constant.DYACTIVITY, id);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContent.startActivity(intent);
        }
    }



    class MyGlidviewAdapter extends BaseAdapter {
        private final ArrayList<String> mImageList;

        public MyGlidviewAdapter(ArrayList<String> imageList) {
            this.mImageList = imageList;
        }

        @Override
        public int getCount() {
            return mImageList.size();
        }

        @Override
        public String getItem(int position) {
            return mImageList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = new ImageView(parent.getContext());
            }
            ImageView imageView = (ImageView) convertView;
            Picasso.with(mContent)
            .load(Uri.parse(mImageList.get(position)))
            .resize(120, 120)
            .centerCrop()
            .placeholder(R.mipmap.loding)
            .error(R.mipmap.loding_error).into(imageView);
            return convertView;
        }
    }

    interface DYView {
        void onDYView(View view);
    }

    public void setDYView(DYView listenner) {
        this.mDYView = listenner;
    }

}
