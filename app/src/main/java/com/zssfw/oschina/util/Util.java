package com.zssfw.oschina.util;

import com.zssfw.oschina.MyApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SJJ on 2017/2/15.
 * 描述 ${TODO}
 */

public class Util {
    private static SimpleDateFormat sdf;
    //这个是在主线程去更新ui,在没有上下文的环境,
    public static void runOnUIThread(Runnable runnable)
    {
        MyApplication.mHandler.post(runnable);
    }
    public static String parseTime(String time) {
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        Date nowDate = new Date();

        String now = sdf.format(nowDate);
        long timeLong = 0;
        try {
            timeLong = sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();

        }

        if (getDay(now).equals(getDay(time))) {
            if (getHour(now).equals(getHour(time))) {
                long mmDif = nowDate.getTime() - timeLong;
                long mDif = mmDif / 1000 / 60;
                return mDif + "分钟前";
            } else {
                int i = Integer.parseInt(getHour(now)) - Integer.parseInt(getHour(time));
                return i + "小时前";
            }
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);

            for (int i = 1; i < 32; i++) {
                calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
                if (getDay(sdf.format(calendar.getTime())).equals(getDay(time))) {
                    switch (i) {
                        case 1:
                            return "昨天";
                        case 2:
                            return "前天";
                        case 31:
                            return "一个月前";
                        default:
                            return i + "天前";
                    }
                }

            }

        }
        return "异次元时间";
    }

    private static String getHour(String date) {
        return date.substring(11, 13);
    }

    private static String getDay(String date) {
        return date.substring(8, 10);
    }

    public static boolean isToday(String pubDate) {
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        Date nowDate = new Date();
        String now = sdf.format(nowDate);
        return getDay(now).equals(getDay(pubDate));
    }

}
