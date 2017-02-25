package com.zssfw.oschina.ui.pager.mine;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zssfw.oschina.R;
import com.zssfw.oschina.bean.OschinaBean;
import com.zssfw.oschina.manager.XmlCacheManager;
import com.zssfw.oschina.ui.pager.plus.BaseFragment;
import com.zssfw.oschina.util.Constant;
import com.zssfw.oschina.util.SPUtil;
import com.zssfw.oschina.util.Util;

/**
 * Created by leoo on 2017-2-24.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private EditText mEtUsername;
    private EditText mEtPsw;
    private Button mLogin;
    public  String mMessage;
    public boolean isLogin = false;
    private SharedPreferences mSp;

    @Override
    public View createView() {
        View view = View.inflate(getContext(), R.layout.fragment_login, null);
        mEtUsername = (EditText) view.findViewById(R.id.et_login_username);
        mEtPsw = (EditText) view.findViewById(R.id.et_login_psw);
        mLogin = (Button) view.findViewById(R.id.bt_login);
        mLogin.setOnClickListener(this);
        mSp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        String name = SPUtil.getUsername();
        String word = SPUtil.getPwd();
        mEtPsw.setText(word);
        mEtUsername.setText(name);
        return view;
    }

    @Override
    public Object getData() {
        return "";
    }

    @Override
    public void refresh() {

    }

    @Override
    public void onClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                login();
            }
        }).start();

    }
    public void login() {
        String username = mEtUsername.getText().toString().trim();
        String psw = mEtPsw.getText().toString().trim();
        SPUtil.saveUser(username,psw);
        if (TextUtils.isEmpty(username)||TextUtils.isEmpty(psw)) {
            Util.runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(),"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }
            });

        }

        OschinaBean oschinaBean = XmlCacheManager.getInstance().getXmlBean(Constant.LOGIN, username, psw, OschinaBean.class);
        mMessage = oschinaBean.getResult().getErrorMessage();
        Util.runOnUIThread(new Runnable() {
            @Override
            public void run() {

                if (TextUtils.equals(mMessage,"登录成功")) {
                    isLogin = true;
                    SPUtil.saveState(isLogin);
                    getActivity().finish();
                }else{
                    isLogin = false;
                    SPUtil.saveState(isLogin);
                    Toast.makeText(getContext(), mMessage,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }





}
