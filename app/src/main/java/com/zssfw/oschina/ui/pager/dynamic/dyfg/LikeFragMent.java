package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.google.gson.Gson;
import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.LikeBean;
import com.zssfw.oschina.ui.widget.DyRecycleView;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.DensityUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.zssfw.oschina.MyApplication.mContent;

/**
 * @创建者 administrator
 * @创建时间 2017/2/27 14:52
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/27$
 * @更新描述 ${TODO}
 */

public class LikeFragMent extends DYdetailListFragment {
    private LikeBean mLikeBean;
    private DyRecycleView mRecyclerView;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    initView();
                break;
            }
        }
    };
    private RelativeLayout mRl_trans;
    private int mMeasuredHeight;
    private ViewTreeObserver mViewTreeObserver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.likeview, null);
        mRl_trans = (RelativeLayout) view.findViewById(R.id.rl_trans);
        mRecyclerView = (DyRecycleView) view.findViewById(R.id.recycler_like);
        mRl_trans.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

               mMeasuredHeight= mRl_trans.getHeight();
            }
        });

        return view;
    }
    int start = 0;
    int moveState = 0;
    int height;
    int up = 0;
    int down =0;
    int iscomple = 0;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        moveState = 3;
                        break;
                    case MotionEvent.ACTION_DOWN:
                        moveState = 1;
                        break;
                    case MotionEvent.ACTION_HOVER_MOVE:
                        moveState = 2;
                        break;
                }
                return false;
            }
        });
        height = (int) DensityUtil.dip2px(getActivity(),48);
        System.out.println("sssssssssss"+height);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                int lastVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                if (layoutManager.findFirstVisibleItemPosition() == 0) {
                    ViewCompat.animate(mRl_trans).translationY(0).start();
                } else {
                    ViewCompat.animate(mRl_trans).translationYBy((mMeasuredHeight)).start();
                }
            }


        });
        initData();
    }
    private void startAnimation(int i, int height) {
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(i, height);
        System.out.println("current value :"+i+"--->"+height);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                System.out.println("move to :"+animatedValue);
                mRl_trans.setTranslationY(animatedValue);
            }
        });

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                iscomple =1;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                iscomple = 0;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }
    private void initData() {
        String uri = "http://www.oschina.net/action/apiv2/tweet_likes?sourceId="+Constant.ITEM_FRAG;

        OkHttpClient okHttpClient = new OkHttpClient();
        Request requset = new Request.Builder().url(uri).build();
        okHttpClient.newCall(requset).enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    Gson gson = new Gson();
                    mLikeBean = gson.fromJson(string, LikeBean.class);
                    mHandler.sendEmptyMessage(1);
                }
            }
        });
    }

    private void initView() {
        final List<LikeBean.ResultBean.ItemsBean> items = mLikeBean.getResult().getItems();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.like_item, null);
                LikeViewHolder likeViewHolder = new LikeViewHolder(view);
                return likeViewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                final LikeViewHolder viewHolder = (LikeViewHolder) holder;
                viewHolder.mTvLike.setText(items.get(position).getAuthor().getName());
                Glide.with(mContent).load(Uri.parse(items.get(position).getAuthor().getPortrait())).asBitmap().centerCrop().into(new BitmapImageViewTarget(viewHolder.mImageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContent.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        viewHolder.mImageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
                viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), WebActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return items.size();
            }

        });

    }
    class LikeViewHolder extends RecyclerView.ViewHolder {

        public  TextView mTvLike;
        public  ImageView mImageView;

        public LikeViewHolder(View itemView) {
            super(itemView);
            mTvLike = (TextView) itemView.findViewById(R.id.like_name);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_like);
        }
    }
}
