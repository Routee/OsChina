package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zssfw.oschina.R;
import com.zssfw.oschina.adapter.MyDyadapter;
import com.zssfw.oschina.bean.ShardBean;
import com.zssfw.oschina.interfaces.Basetype;

import java.util.ArrayList;

/**
 * @创建者 administrator
 * @创建时间 2017/2/26 13:44
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/26$
 * @更新描述 ${TODO}
 */

public class Mydy extends Fragment {

    private RecyclerView mShad_recy;
    private View mView;
    private ShardBean mShardBean;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            setMyAdapter();
            super.handleMessage(msg);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = View.inflate(getActivity(), R.layout.shard_recycle, null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void setMyAdapter() {
        ArrayList<Basetype> listData = new ArrayList<>();
        listData.add(mShardBean);
        mShad_recy = (RecyclerView) mView.findViewById(R.id.shad_recy);
        mShad_recy.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        MyDyadapter myDyadapter = new MyDyadapter(getActivity(),listData);
        mShad_recy.setAdapter(myDyadapter);
    }



    private void initData() {
       // uri = "http://www.oschina.net/action/apiv2/tweets?authorId=3292587";"http://www.oschina.net/action/apiv2/tweets?authorId=3292587"
        UtilData utilData = new UtilData();
        utilData.requestGet("http://www.oschina.net/action/apiv2/tweets?authorId=3292587");
        utilData.setResquertData(new UtilData.ResquertData() {
            @Override
            public void OnResquertData(Basetype basetype) {
                mShardBean = (ShardBean) basetype;
                mHandler.sendEmptyMessage(1);
            }
        });
    }


/*
    OkHttpClient okHttpClient = new OkHttpClient();
    String uri = "http://www.oschina.net/action/apiv2/tweets?authorId=3292587";
    Request request = new Request.Builder().url(uri).build();
    okHttpClient.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                String string = response.body().string();
                Gson gson = new Gson();
                mShardBean = gson.fromJson(string, ShardBean.class);
            }
            mHandler.sendEmptyMessage(1);
            System.out.println();

        }
    });
    */


  /*  public void setText() {
        mTvName.setText(mShardBean.getResult().getAuthor().getName());
        mTvDesc.setText(mShardBean.getResult().getContent());
        mTvTime.setText(mShardBean.getResult().getPubDate());
        mTvDot.setText(mShardBean.getResult().getStatistics().getFavCount());
        mTvComment.setText(mShardBean.getResult().getStatistics().getLike());
        mTvShard.setText(mShardBean.getResult().getStatistics().getComment());
        Glide.with(mContent).load(Uri.parse(mShardBean.getResult().getAuthor().getPortrait())).asBitmap().centerCrop().into(new BitmapImageViewTarget(mIvHeadPic) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContent.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                mIvHeadPic.setImageDrawable(circularBitmapDrawable);

            }
        });
    }
*/
}
