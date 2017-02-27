package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.zssfw.oschina.bean.ShardBean;
import com.zssfw.oschina.interfaces.Basetype;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @创建者 administrator
 * @创建时间 2017/2/26 19:34
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/26$
 * @更新描述 ${TODO}
 */

public class UtilData {
    private ShardBean mShardBean;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (mResquertData != null) {
                        mResquertData.OnResquertData(mShardBean);
                    }
                break;
            }
            super.handleMessage(msg);
        }
    };
    private ResquertData mResquertData;

    public void requestGet(String uri) {
        OkHttpClient okHttpClient = new OkHttpClient();
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
                    if (mResquertData != null) {
                        mResquertData.OnResquertData(mShardBean);
                    }
                }
                mHandler.sendEmptyMessage(1);
                System.out.println();

            }
        });
    }

    interface ResquertData {
        void OnResquertData(Basetype basetype);
    }
    public void setResquertData(ResquertData listenner) {
        this.mResquertData = listenner;
    }
}
