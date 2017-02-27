package com.zssfw.oschina.ui.pager.dynamic.dyfg;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zssfw.oschina.bean.ShardBean;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @创建者 administrator
 * @创建时间 2017/2/25 13:48
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/25$
 * @更新描述 ${TODO}
 */

public class ShardFragMent extends DYBaseFragMent {
    @Override
    protected void setUIData() {
      //  String uri = "http://www.oschina.net/action/apiv2/tweet?id="+Constant.ITEM_FRAG;
        String uri = "http://www.oschina.net/action/apiv2/tweet?id=12266579";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(uri).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                ShardBean shardBean = gson.fromJson(string, ShardBean.class);

                //HotBean.ResultBean.ItemsBean result = (HotBean.ResultBean.ItemsBean)shardBean.getResult();
            }
        });
    }

    @Override
    public View setView(LayoutInflater inflater) {
        TextView textView = new TextView(getActivity());
        textView.setText("ShardFragMent");
        textView.setBackgroundColor(Color.YELLOW);
        return textView;
    }
}
