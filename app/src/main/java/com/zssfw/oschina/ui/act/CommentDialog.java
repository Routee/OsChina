package com.zssfw.oschina.ui.act;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zssfw.oschina.R;
import com.zssfw.oschina.ui.pager.multiple.NewsDetailsFragment;
import com.zssfw.oschina.util.SPUtil;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/1.
 */

public class CommentDialog extends Dialog implements SwipeRefreshLayout.OnRefreshListener {

    private final NewsDetailsFragment mContext;
    private Button mBt;
    private EditText mEditText;
    private String mCookie = "";
    private int mId;

//    public CommentDialog(Context context) {
//        super(context, R.style.report_comment_dialog);
//        Window window = getWindow();
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
//        attributes.gravity = Gravity.BOTTOM;
//        window.setAttributes(attributes);
//    }

    public CommentDialog(NewsDetailsFragment context, int id) {

        super(context.getContext(), R.style.report_comment_dialog);
        this.mContext=context;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.gravity = Gravity.BOTTOM;
        window.setAttributes(attributes);

        this.mId=id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_comment);
        mBt = (Button) findViewById(R.id.comment_send);
        mEditText = (EditText) findViewById(R.id.comment_report);

        final String etText = mEditText.getText().toString().toString();
        //先获取cookie
        final String username = SPUtil.getUsername();
        final String pwd = SPUtil.getPwd();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

                    RequestBody body = new FormBody.Builder().add("keep_login", "1")
                            .add("username", username+"")
                            .add("pwd", pwd+"").build();
                    Request request = new Request.Builder().url("http://www.oschina.net/action/api/login_validate").post(body).build();
                    Response response = okHttpClient.newCall(request).execute();
                    System.out.println(response.body().string());

                    String cookie = response.header("Set-cookie");

                    //oscid=p1fAZCnmuKbYnz0aOgYo%2B9ewXIBo3b17A0t2AC892SFsY%2FMN%2BIA9H04MbI8BA6XmF8oHtHn3LmB9IuO07LrR9%2FgxoGJTEZfdnMh%2BV7TcKmY39Ott0RgwariNIqup50qAJ8QQ%2BTjV1296%2FiqdXbiv7ZWbqQfs2LMfDbW%2FEHiulZA%3D
                    String[] splits = cookie.split(";");
                    for (int i = 0; i < splits.length; i++) {
                        if (splits[i].startsWith("oscid=")) {
                            System.out.println("cookie:" + splits[i]);
                            mCookie = splits[i];
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }).start();
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String etText = mEditText.getText().toString().toString();



                if (mCookie == "") {
                    Toast.makeText(getContext(), mId+"", Toast.LENGTH_SHORT).show();
                } else {
                    if (etText.isEmpty()) {
                        Toast.makeText(getContext(), "亲,回复是空的", Toast.LENGTH_SHORT).show();
                    } else {

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                                    RequestBody body = new FormBody.Builder()
                                            .add("content", etText)
                                            .add("sourceId", mId + "")
                                            .add("type", "6")
                                            .build();
                                    Request request = new Request.Builder().addHeader("cookie", mCookie).post(body)
                                            .url("http://www.oschina.net/action/apiv2/comment_pub").build();
                                    Response res = okHttpClient.newCall(request).execute();
                                    System.out.println(res.body().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }).start();


                        dismiss();

                        onRefresh();

                    }
                }
               }

//        }
        });

    }


    @Override
    public void onRefresh() {
        showComment();
    }

    private void showComment() {
        mContext.getData();

    }
}
