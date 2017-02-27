package com.zssfw.oschina.ui.pager.found.fragment;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.manager.HttpManager;
import com.zssfw.oschina.ui.act.FoundShowActivity;
import com.zssfw.oschina.ui.pager.found.bean.ShakeBean;
import com.zssfw.oschina.ui.pager.found.utils.Xml2JsonUtil;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.GsonUtil;
import com.zssfw.oschina.util.Uris;
import com.zssfw.oschina.util.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.SENSOR_SERVICE;
import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by Routee on 2017/2/23.
 */

public class ShakeFragment extends BaseFragment implements SensorEventListener {

    private static final int START_SHAKE = 0;
    private static final int AGAIN_SHAKE = 1;
    private static final int END_SHAKE   = 2;
    @Bind(R.id.iv_found_shake)
    ImageView    mIv;
    @Bind(R.id.iv_found_shake_head)
    ImageView    mIvFoundShakeHead;
    @Bind(R.id.tv_found_shake_title)
    TextView     mTvFoundShakeTitle;
    @Bind(R.id.tv_found_shake_dsc)
    TextView     mTvFoundShakeDsc;
    @Bind(R.id.tv_found_shake_author)
    TextView     mTvFoundShakeAuthor;
    @Bind(R.id.tv_found_shake_time)
    TextView     mTvFoundShakeTime;
    @Bind(R.id.tv_found_shake_comments)
    TextView     mTvFoundShakeComments;
    @Bind(R.id.ll_found_shake)
    LinearLayout mLlFoundShake;
    private SensorManager mSensorManager;
    private Sensor        mAccelerometerSensor;
    private Vibrator      mVibrator;
    private boolean isShake = false;
    private SoundPool mSoundPool;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case START_SHAKE:
                    //This method requires the caller to hold the permission VIBRATE.
                    mVibrator.vibrate(300);
                    //发出提示音
                    mSoundPool.play(mShakeSound, 1, 1, 0, 0, 1);
                    startAnimation();//参数含义: (不是回来) 也就是说两张图片分散开的动画
                    break;
                case AGAIN_SHAKE:
                    mVibrator.vibrate(300);
                    break;
                case END_SHAKE:
                    //整体效果结束, 将震动设置为false
                    isShake = false;
                    // 展示上下两种图片回来的效果
                    showItems();
                    break;
            }
        }
    };
    private int mShakeSound;
    private String mSoftware;

    private void startAnimation() {
        RotateAnimation rAnim = new RotateAnimation(-10, 20, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rAnim.setDuration(200);
        rAnim.setRepeatCount(4);
        TranslateAnimation tAnim = new TranslateAnimation(-100, 100, -5, 5);
        tAnim.setDuration(200);
        tAnim.setRepeatCount(4);
        AnimationSet animSet = new AnimationSet(true);
        animSet.addAnimation(rAnim);
        animSet.addAnimation(tAnim);
        mIv.startAnimation(animSet);
    }

    private void showItems() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String json = getJsonBean();
                Util.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        if (TextUtils.isEmpty(json)) {
                            Toast.makeText(getContext(), "宝宝累了,宝宝不要摇了", Toast.LENGTH_SHORT).show();
                        } else {
                            ShakeBean bean = GsonUtil.parseJsonToBean(json, ShakeBean.class);
                            showResult(bean);
                        }
                    }
                });
            }
        }).start();


    }

    private void showResult(ShakeBean bean) {
        mLlFoundShake.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load(bean.getOschina().getImage().get(0)).into(mIvFoundShakeHead);
        //获取mSoftware名称,后期启动activty要用
        mSoftware = bean.getOschina().getUrl().get(0);
        mTvFoundShakeTitle.setText(bean.getOschina().getTitle().get(0));
        mTvFoundShakeDsc.setText(bean.getOschina().getDetail().get(0));
        mTvFoundShakeAuthor.setText(bean.getOschina().getAuthor().get(0));
        mTvFoundShakeTime.setText(bean.getOschina().getPubDate().get(0));
        mTvFoundShakeComments.setText(bean.getOschina().getCommentCount().get(0));
    }

    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        View view = View.inflate(MyApplication.mContent, R.layout.view_shake, null);
        ButterKnife.bind(ShakeFragment.this, view);
        mLlFoundShake.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mSoundPool = new SoundPool(5, 0, 5);
        mShakeSound = mSoundPool.load(MyApplication.mContent, R.raw.shake_sound, 1);
        mVibrator = (Vibrator) MyApplication.mContent.getSystemService(VIBRATOR_SERVICE);
        mSensorManager = ((SensorManager) MyApplication.mContent.getSystemService(SENSOR_SERVICE));
        if (mSensorManager != null) {
            //获取加速度传感器
            mAccelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (mAccelerometerSensor != null) {
                mSensorManager.registerListener(this, mAccelerometerSensor, SensorManager.SENSOR_DELAY_UI);
            }
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onPause() {
        if (mSensorManager != null) {
            mSensorManager.unregisterListener(this);
        }
        super.onPause();
    }

    @Override
    public Object getData() {
        return "";
    }

    @Override
    public void refresh() {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int type = event.sensor.getType();

        if (type == Sensor.TYPE_ACCELEROMETER) {
            //获取三个方向值
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            if ((Math.abs(x) > 17 || Math.abs(y) > 17 || Math
                    .abs(z) > 17) && !isShake) {
                isShake = true;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {

                            //开始震动 发出提示音 展示动画效果
                            mHandler.obtainMessage(START_SHAKE).sendToTarget();
                            Thread.sleep(500);
                            //再来一次震动提示
                            mHandler.obtainMessage(AGAIN_SHAKE).sendToTarget();
                            Thread.sleep(500);
                            mHandler.obtainMessage(END_SHAKE).sendToTarget();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public String getJsonBean() {
        String xml = HttpManager.getInstance().dataGet(Uris.FOUND_OSSW_SHAKE);
        if (TextUtils.isEmpty(xml)) {
            return "";
        }
        String json = Xml2JsonUtil.xml2JSON(xml);
        //        Log.d("aaaaaa", json);
        return json;
    }


    @OnClick(R.id.ll_found_shake)
    public void onClick() {
        Intent intent = new Intent(getContext(), FoundShowActivity.class);
        intent.putExtra(Constant.FOUNDTITLE, "软件详情");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(Constant.FOUNDFRAGMENT, SoftWareDetailsFragment.class);
        intent.putExtra(Constant.SOFTWARENAME, mSoftware);
        startActivity(intent);
    }
}
