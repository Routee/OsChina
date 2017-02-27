package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.google.gson.Gson;
import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.DYDetails;
import com.zssfw.oschina.bean.DYdetaisTableVP;
import com.zssfw.oschina.util.Constant;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.zssfw.oschina.MyApplication.mContent;

/**
 * @创建者 administrator
 * @创建时间 2017/2/25 13:46
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/25$
 * @更新描述 ${TODO}
 */

public class CommentFragMent extends DYBaseFragMent implements View.OnClickListener {

    @Bind(R.id.ll_dy_title)
    LinearLayout mLlDyTitle;
    @Bind(R.id.iv_head_pic)
    ImageView    mIvHeadPic;
    @Bind(R.id.tv_name)
    TextView     mTvName;
    @Bind(R.id.tv_desc)
    TextView     mTvDesc;
    @Bind(R.id.iv_gridView)
    GridView     mIvGridView;
    @Bind(R.id.tv_time)
    TextView     mTvTime;
    @Bind(R.id.tv_dot)
    TextView     mTvDot;
    @Bind(R.id.tv_comment)
    TextView     mTvComment;
    @Bind(R.id.tv_shard)
    TextView     mTvShard;
    @Bind(R.id.tv_click)
    TextView     mTvClick;
    @Bind(R.id.fl_comment)
    FrameLayout  mFlComment;
    @Bind(R.id.dy_desc)
    LinearLayout mDyDesc;
    private DYDetails mDyDetails;
    private View      mView;
    private ViewPager mViewpaget;
    private TabLayout mTabLayout;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    initTitle();
                    break;
            }
        }
    };

    @Override
    protected void setUIData() {
         String uri = "http://www.oschina.net/action/apiv2/tweet?id="+ Constant.ITEM_FRAG;
        //String uri = "http://www.oschina.net/action/apiv2/tweet?id=12266579";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(uri).build();
        okHttpClient.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String str = response.body().string();
                    Gson gson = new Gson();
                    mDyDetails = gson.fromJson(str, DYDetails.class);
                    mHandler.sendEmptyMessage(1);
                    Constant.ITEM_FRAG1 = mDyDetails.getResult().getId();
                }
            }
        });
    }


    @Override
    public View setView(LayoutInflater inflater) {
        mView = View.inflate(getActivity(), R.layout.dy_desc, null);
        ButterKnife.bind(this, mView);
        return mView;
    }

    private void initTitle() {
        initDetaiView();
        addViewPagerTab();
    }


    private void addViewPagerTab() {
        ArrayList<DYdetaisTableVP> list = new ArrayList();
        for (int i = 0; i < 2; i++) {
            DYdetaisTableVP dYdetaisTableVP = new DYdetaisTableVP();
            dYdetaisTableVP.mFragment = new DYdetailListFragment();
            dYdetaisTableVP.mTitle = "赞（12）";
            list.add(dYdetaisTableVP);
        }
        DYtbViewpage dYtbViewpage = new DYtbViewpage(list);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fl_comment, dYtbViewpage).commit();
    }


    @Override
    public void onClick(View v) {

    }

    private void initDetaiView() {
        mTvName.setText(mDyDetails.getResult().getAuthor().getName());
        mTvDesc.setText(mDyDetails.getResult().getContent());
        mTvTime.setText(mDyDetails.getResult().getPubDate());
        mTvDot.setText(mDyDetails.getResult().getStatistics().getLike() + "");
        mTvComment.setText(mDyDetails.getResult().getStatistics().getComment() + "");
        mTvShard.setText(mDyDetails.getResult().getStatistics().getTransmit() + "");
        Glide.with(mContent).load(Uri.parse(mDyDetails.getResult().getAuthor().getPortrait())).asBitmap().centerCrop().into(new BitmapImageViewTarget(mIvHeadPic) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContent.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                mIvHeadPic.setImageDrawable(circularBitmapDrawable);

            }
        });
    }

}
