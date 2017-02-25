package com.zssfw.oschina.util;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zssfw.oschina.bean.HotBean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @创建者 administrator
 * @创建时间 2017/2/24 19:36
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/24$
 * @更新描述 ${TODO}
 */

public class DyGetData {
    private Context                                 mContext;
    private ArrayList<HotBean.ResultBean.ItemsBean> mItems;
    private HotBean                                 mHotBean;
    private NetDataListenner                        mNetDataListenner;

    public void getData(final Context context, String url, final boolean top) {
        this.mContext = context;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.toString());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    String message = response.body().string();
                    Gson gson = new Gson();
                    mHotBean = gson.fromJson(message, HotBean.class);
                    if (top) {
                        if (mItems != null && mItems.size() != 0) {
                            List<HotBean.ResultBean.ItemsBean> items = mHotBean.getResult().getItems();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                            String pubDate = items.get(0).getPubDate();
                            Date reflesh = null;
                            Date oldData = null;
                            try {
                                reflesh = simpleDateFormat.parse(pubDate);
                                String pubDate1 = mItems.get(0).getPubDate();
                                oldData = simpleDateFormat.parse(pubDate1);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            long oldtime = oldData.getTime();
                            long refleshTime = reflesh.getTime();
                            if (oldtime < refleshTime) {
                                for (int i = 0; i < items.size(); i++) {
                                    String ttime = items.get(i).getPubDate();
                                    Date Ltime = null;
                                    try {
                                        Ltime = simpleDateFormat.parse(ttime);
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    long Ltimetime = Ltime.getTime();
                                    if (Ltimetime > oldtime) {
                                        mItems.add(0, items.get(i));
                                        if (mItems.size() > 50) {
                                            mItems.remove(mItems.size() - 1);
                                        }
                                    }
                                }
                            }
                        } else {
                            mItems = (ArrayList<HotBean.ResultBean.ItemsBean>) mHotBean.getResult().getItems();
                        }
                        if (mNetDataListenner != null) {
                            mNetDataListenner.onNetData(mItems, mHotBean);
                        }
                    } else {
                        if (mNetDataListenner != null) {
                            mNetDataListenner.onNetData(mItems, mHotBean);
                        }
                    }
                    //// TODO: 2017/2/24 上啦没有数据
                    SpUtils.saveList(mContext, mItems);
                  //  mHandler.sendEmptyMessage(1);
                } else {
                    Util.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(mContext, "网络访问异常", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

  public interface NetDataListenner {
        void onNetData(ArrayList<HotBean.ResultBean.ItemsBean> items, HotBean mHotBean);
    }

    public void setNetDataListenner(NetDataListenner netDataListenner) {
        this.mNetDataListenner = netDataListenner;
    }

}
