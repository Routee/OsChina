package com.zssfw.oschina.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @创建者 administrator
 * @创建时间 2017/2/24 17:37
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/24$
 * @更新描述 ${TODO}
 */

public class SpUtils {


    public static <T> void saveList(Context context, ArrayList<T> list) {
        File file = new File(Environment.getExternalStorageDirectory(), File.separator + context.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        File dir = new File(file, "dynamicList");
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(dir));
                objectOutputStream.writeObject(list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Object getlist(Context context) {
        File file = new File(Environment.getExternalStorageDirectory(), File.separator + context.getPackageName());
        File dir = new File(file, "dynamicList");
        if (file == null) {
            return null;
        }
        ObjectInputStream objectInputStream = null;
        Object obj = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(dir));
            obj = objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
