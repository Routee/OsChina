package com.zssfw.oschina.ui.pager.found.mine;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.zssfw.oschina.MyApplication;
import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.OschinaBean;
import com.zssfw.oschina.manager.CacheManager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.ui.widget.RoundImageView;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.GlobalActivity;
import com.zssfw.oschina.util.SPUtil;
import com.zssfw.oschina.util.Util;
import com.zssfw.oschina.util.XmlUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by SJJ on 2017/2/22.
 * 描述 ${TODO}
 */

public class MinePager extends BaseFragment implements View.OnClickListener {
    private RoundImageView mIv_photo;
    private TextView       mTv;
    private View           mLogout;
    private View           mFoot;
    private View           mLogin;
    private TextView       mTvUsername;
    private ImageView      mIvSex;
    private RoundImageView mRivLogin;
    private ImageView      mQrCode;
    private OschinaBean    mData;


    @Override
    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }

    @Override
    public View createView() {
        View view = View.inflate(getActivity(), R.layout.fragment_mine, null);
        mLogout = view.findViewById(R.id.ll_login_false);
        mFoot = view.findViewById(R.id.ll_mine_foot);
        mLogin = view.findViewById(R.id.rl_login_true);
        mLogin.setVisibility(View.INVISIBLE);
        mFoot.setVisibility(View.INVISIBLE);
        mTvUsername = (TextView) view.findViewById(R.id.tv_username_login);
        mQrCode = (ImageView) view.findViewById(R.id.iv_qrcode);
        mIvSex = (ImageView) view.findViewById(R.id.iv_ismale);
        mRivLogin = (RoundImageView) view.findViewById(R.id.iv_head_photo_login);
        mIv_photo = (RoundImageView) view.findViewById(R.id.iv_head_photo);
        mTv = (TextView) view.findViewById(R.id.tv_username);

        mIv_photo.setOnClickListener(this);
        mRivLogin.setOnClickListener(this);
        mTv.setOnClickListener(this);
        mQrCode.setOnClickListener(this);
        return view;
    }

    @Override
    public Object getData() {

        return "";
    }

    //    @Override
    public void initData() {

    }

    @Override
    public void refresh() {


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_head_photo:
            case R.id.tv_username:
                Intent intent = new Intent(MyApplication.mContent, GlobalActivity.class);
                //  Bundle bundle = new Bundle();
                intent.putExtra(Constant.FRAGMENTNAME, LoginFragment.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.iv_head_photo_login:
                Intent intent1 = new Intent(MyApplication.mContent, GlobalActivity.class);
                intent1.putExtra(Constant.FRAGMENTNAME, LogoutFragment.class);
                startActivityForResult(intent1, 2);
                break;
            case R.id.iv_qrcode:
                View view1 = View.inflate(getContext(), R.layout.layout_qrcode, null);
                ImageView iv = (ImageView) view1.findViewById(R.id.qrcode_iv);
                iv.setImageBitmap(initBitmap(SPUtil.getUsername(), Util.getDimens(R.dimen.dp200), Util.getDimens(R.dimen.dp200)));
                Dialog dialog = new Dialog(getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(view1);
                dialog.show();
                break;
        }
    }

    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            String content = CacheManager.getInstance().getCacheData(Constant.LOGIN);
            System.out.println(content + "9999999999999999999");
            OschinaBean bean = XmlUtil.getInstance().xmlToBean(content, OschinaBean.class);
            mData = bean;
        }


        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (SPUtil.getState()) {
                    mLogout.setVisibility(View.INVISIBLE);
                    mLogin.setVisibility(View.VISIBLE);
                    mFoot.setVisibility(View.VISIBLE);
                    mTvUsername.setText(mData.getUser().getName());
                    System.out.println("性别" + mData.getUser().getGender());
                    if (mData.getUser().getGender() == 2) {
                        mIvSex.setImageResource(R.mipmap.userinfo_icon_female);
                    } else {
                        mIvSex.setImageResource(R.mipmap.userinfo_icon_male);
                    }

                } else {
                    mLogout.setVisibility(View.VISIBLE);
                    mLogin.setVisibility(View.INVISIBLE);
                    mFoot.setVisibility(View.INVISIBLE);
                }
            }
        });
    }





  /*  @Override
    public void onResume() {
        super.onResume();
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (SPUtil.getState()) {
                    mLogout.setVisibility(View.INVISIBLE);
                    mLogin.setVisibility(View.VISIBLE);
                    mFoot.setVisibility(View.VISIBLE);
                    mTvUsername.setText(mData.getUser().getName());
                    System.out.println("性别"+mData.getUser().getGender());
                    if (mData.getUser().getGender() ==2) {
                        mIvSex.setImageResource(R.mipmap.userinfo_icon_female);
                    }else{
                        mIvSex.setImageResource(R.mipmap.userinfo_icon_male);
                    }

                }else{
                    mLogout.setVisibility(View.VISIBLE);
                    mLogin.setVisibility(View.INVISIBLE);
                    mFoot.setVisibility(View.INVISIBLE);
                }
            }
        });
    }*/

    public Bitmap initBitmap(String content, int width, int height){
        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType,String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        BitMatrix encode = null;
        try {
            encode = writer.encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            int[] pixels = new int[width*height];
            for(int i = 0; i <height; i++){
                for(int j = 0; j<width; j++){
                    if(encode.get(j,i)){
                        pixels[i*width+j] =0x00000000;
                    }else{
                        pixels[i*width+j] =0xffffffff;
                    }
                }
            }
            return Bitmap.createBitmap(pixels,0, width, width, height, Bitmap.Config.RGB_565);

        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }

    }

}
