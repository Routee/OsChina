package com.zssfw.oschina.adapter;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.squareup.picasso.Picasso;
import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.HotBean;
import com.zssfw.oschina.bean.ImagerBean;
import com.zssfw.oschina.util.TextUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 administrator
 * @创建时间 2017/2/23 17:18
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/23$
 * @更新描述 ${TODO}
 */

public abstract class DynnamicAdapterBase extends RecyclerView.Adapter {
    private Context mContent;
    private int     size;

    int[] ID = new int[]{
            R.id.tv_name,
            R.id.tv_desc,
            R.id.tv_time,
            R.id.tv_dot,
            R.id.tv_comment,
            R.id.tv_shard,
            R.id.iv_head_pic
    };

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
    public int getItemCount() {
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View         mView;
        private TextView     mTextView;
        private ImageView    mImageView;
        private TextView     mTv_desc;
        private TextView     mTv_time;
        private TextView     mTv_dot;
        private TextView     mTv_comment;
        private TextView     mTv_shard;
        private ImageView    mIv_head_pic;
        private LinearLayout mLl_iv1;
        private LinearLayout mLl_iv2;
        private LinearLayout mLl_iv3;
        private ImageView    mIv_dy_item1;
        private ImageView    mIv_dy_item2;
        private ImageView    mIv_dy_item3;
        private ImageView    mIv_dy_item4;
        private ImageView    mIv_dy_item5;
        private ImageView    mIv_dy_item6;
        private ImageView    mIv_dy_item7;
        private ImageView    mIv_dy_item8;
        private ImageView    mIv_dy_item9;
        ArrayList<String> mImageList = new ArrayList<>();
        private ImageView mImageView1;
        private  GridView mIv_gridView;
        private  ArrayAdapter<ImageView> mGridAdapter;
        private  MyGlidviewAdapter mMyGlidviewAdapter;
        private  ImagerBean mImagerBean;
        private final TextUtil mTextUtil;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mImagerBean = new ImagerBean();
            mTextUtil = new TextUtil(this);
            mTextView = (TextView) mView.findViewById(R.id.tv_name);
            mTv_desc = (TextView) mView.findViewById(R.id.tv_desc);
            mTv_time = (TextView) mView.findViewById(R.id.tv_time);
            mTv_dot = (TextView) mView.findViewById(R.id.tv_dot);
            mTv_comment = (TextView) mView.findViewById(R.id.tv_comment);
            mTv_shard = (TextView) mView.findViewById(R.id.tv_shard);
            mIv_head_pic = (ImageView) mView.findViewById(R.id.iv_head_pic);

            mIv_gridView = (GridView) mView.findViewById(R.id.iv_gridView);

            mMyGlidviewAdapter = new MyGlidviewAdapter(mImageList);
            mIv_gridView.setAdapter(mMyGlidviewAdapter);

           /* mLl_iv1 = (LinearLayout) mView.findViewById(R.id.ll_iv1);
            mLl_iv2 = (LinearLayout) mView.findViewById(R.id.ll_iv2);
            mLl_iv3 = (LinearLayout) mView.findViewById(R.id.ll_iv3);

            mIv_dy_item1 = (ImageView) mView.findViewById(R.id.iv_dy_item1);
            mIv_dy_item2 = (ImageView) mView.findViewById(R.id.iv_dy_item2);
            mIv_dy_item3 = (ImageView) mView.findViewById(R.id.iv_dy_item3);
            mIv_dy_item4 = (ImageView) mView.findViewById(R.id.iv_dy_item4);
            mIv_dy_item5 = (ImageView) mView.findViewById(R.id.iv_dy_item5);
            mIv_dy_item6 = (ImageView) mView.findViewById(R.id.iv_dy_item6);
            mIv_dy_item7 = (ImageView) mView.findViewById(R.id.iv_dy_item7);
            mIv_dy_item8 = (ImageView) mView.findViewById(R.id.iv_dy_item8);
            mIv_dy_item9 = (ImageView) mView.findViewById(R.id.iv_dy_item9);

            mImageList.add(mIv_dy_item1);
            mImageList.add(mIv_dy_item2);
            mImageList.add(mIv_dy_item3);
            mImageList.add(mIv_dy_item4);
            mImageList.add(mIv_dy_item5);
            mImageList.add(mIv_dy_item6);
            mImageList.add(mIv_dy_item7);
            mImageList.add(mIv_dy_item8);
            mImageList.add(mIv_dy_item9);*/
        }

        public void setTextS(final HotBean.ResultBean.ItemsBean mItems) {


            mTextView.setText(mItems.getAuthor().getName());
          //  mTv_desc.setText(mItems.getContent());
            mTextUtil.getTextSpannableString(mItems.getContent());
            mTv_time.setText(mItems.getPubDate());
            mTv_dot.setText(mItems.getStatistics().getFavCount() + "");
            mTv_comment.setText(mItems.getStatistics().getLike() + "");
            mTv_shard.setText(mItems.getStatistics().getTransmit() + "");
           /* Picasso.with(mContent.getApplicationContext())
                    .load("http://static.oschina.net/uploads/user/1445/2890405_50.jpeg?t=1487840113000")
                    .transform(new CircleTransform())
                    .into(mImageView);*/
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
        }

        public ImageView setImageviews(HotBean.ResultBean.ItemsBean mItems) {
        /*    mLl_iv1.removeAllViews();
            mLl_iv2.removeAllViews();
            mLl_iv3.removeAllViews();*/

            List<HotBean.ResultBean.ItemsBean.ImagesBean> images = mItems.getImages();
            if (images != null && mImagerBean.getImageList.size() == 0) {
                for (int i = 0; i < images.size(); i++) {
                    mImagerBean.getImageList.add(images.get(i).getThumb());
                    mImageList.clear();
                    mImageList.addAll( mImagerBean.getImageList);
                    mMyGlidviewAdapter.notifyDataSetChanged();
                    //                    mImageList.get(i) = mImageList.get(i);
                    //                    int w = images.get(i).getW();
                    //                    int h = images.get(i).getH();
                    //                    if (w > 80) {
                    //                        w = 90;
                    //                    }
                    //                    if (h > 120) {
                    //                        h = 120;
                    //                    }
                    //                    final int num = i;
                    //                    ImageView imageView = new ImageView(mContent);
                    //                    Picasso.with(mContent)
                    //                            .load(Uri.parse(images.get(i).getThumb())).resize(120,120).centerCrop()
                    //                            .placeholder(R.mipmap.loding)
                    //                            .error(R.mipmap.loding_error).into(imageView);
                    //                    mImageList.add(imageView);
                    //                    mGridAdapter.notifyDataSetChanged();
                    //                    LinearLayout parent = (LinearLayout) mImageList.get(num).getParent();
                    //                    parent.removeView(mImageList.get(num));
                   /* if (num < 3) {
                        mLl_iv1.addView(mImageList.get(num));
                    }
                    if (3 <= num && num < 6) {
                        mLl_iv2.addView(mImageList.get(num));
                    }
                    if (num >= 6) {
                        mLl_iv3.addView(mImageList.get(num));
                    }*/
                }
            } else {
                mImageList.clear();
                mImageList.addAll( mImagerBean.getImageList);
                mMyGlidviewAdapter.notifyDataSetChanged();
            }

            return mImageView;
        }
        public  void setDYtext(SpannableString msp) {
/*
            SpannableString spannableString = new SpannableString("http://www.baidu.com");
            URLSpan url = new URLSpan("http://www.baidu.com");
            spannableString.setSpan(url,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
*/


            mTv_desc.setText(msp);
            mTv_desc.setClickable(true);
            mTv_desc.setMovementMethod(LinkMovementMethod.getInstance());
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
           /* ImageView imageView = new ImageView(mContent);
            Picasso.with(mContent)
                    .load(Uri.parse(mImageList.get(position))).resize(120, 120).centerCrop()
                    .placeholder(R.mipmap.loding)
                    .error(R.mipmap.loding_error).into(imageView);*/
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


}
