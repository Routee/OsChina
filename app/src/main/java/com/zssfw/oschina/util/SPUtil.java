package com.zssfw.oschina.util;

import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static com.zssfw.oschina.MyApplication.mContent;

/**
 * Created by leoo on 2017-2-24.
 */

public class SPUtil {
    private static SharedPreferences sSp =mContent.getSharedPreferences("config", MODE_PRIVATE);
    public static void saveState(boolean b){
        sSp.edit().putBoolean("isLogin",b).commit();
    }
    public static boolean getState(){
        return sSp.getBoolean("isLogin",false);
    }
    public static void saveUser(String username,String pwd){
        sSp.edit().putString(Constant.SP_USERNAME,username)
                .putString(Constant.SP_PWD,pwd)
                .commit();
    }

    public static String getUsername(){
        return sSp.getString(Constant.SP_USERNAME,"");
    }
    public static String getPwd(){
        return sSp.getString(Constant.SP_PWD,"");
    }

}
