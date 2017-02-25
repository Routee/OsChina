package com.zssfw.oschina.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.zssfw.oschina.R;

public class GlobalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        Class clazz = (Class) getIntent().getSerializableExtra(Constant.FRAGMENTNAME);
        try {
            Fragment fragment = (Fragment) clazz.newInstance();
             getSupportFragmentManager().beginTransaction().replace(R.id.fl_global_activity,fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
