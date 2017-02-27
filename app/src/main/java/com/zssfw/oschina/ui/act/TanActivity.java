package com.zssfw.oschina.ui.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zssfw.oschina.R;
import com.zssfw.oschina.util.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TanActivity extends AppCompatActivity {

    @Bind(R.id.back)
    ImageView   mBack;
    @Bind(R.id.title)
    TextView    mTv_title;
    @Bind(R.id.send)
    TextView    mSend;
    @Bind(R.id.framelayout)
    FrameLayout mFramelayout;

    private String mTitle;
    private int    mShowComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tan);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        try {
            Class serializable = (Class) getIntent().getSerializableExtra(Constant.INTENT_CLASS);
            Fragment fragment = (Fragment) serializable.newInstance();

            Bundle bundleExtra = getIntent().getBundleExtra(Constant.BUNDLE);
            mTitle = bundleExtra.getString(Constant.BUNDLE_MSG_TITLE);
//            mShowComment = bundleExtra.getInt(Constant.BUNDLE_MSG_COMMENT, -1);
            fragment.setArguments(bundleExtra);

            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();

        } catch (Exception e) {
            //// TODO: 2017/2/23
        } finally {

        }
        if (!TextUtils.isEmpty(mTitle)) {
            mTv_title.setText(mTitle);
        }
//        if (mShowComment != -1) {
//            mTvComment.setText(mShowComment + "");
//            mTvComment.setVisibility(View.VISIBLE);
//        }
    }


    @OnClick({R.id.back, R.id.send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.send:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
