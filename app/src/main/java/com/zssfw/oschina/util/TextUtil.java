package com.zssfw.oschina.util;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;

import com.zssfw.oschina.adapter.DynnamicAdapterBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @创建者 administrator
 * @创建时间 2017/2/24 21:45
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/24$
 * @更新描述 ${TODO}
 */

public class TextUtil {
    private static Object net;
    private String sms;
    private SetText mSetText;
    DynnamicAdapterBase.ViewHolder mViewHolder;


    public TextUtil(DynnamicAdapterBase.ViewHolder viewHolder) {
        this.mViewHolder = viewHolder;
    }

    public void getTextSpannableString(String body) {
        this.sms = body;
        hanzi();
       // SpannableString msp = new SpannableString(body);
        //网络
        //getNet();
       /// msp.setSpan(new URLSpan("http://www.baidu.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    private void hanzi() {

        String[] by = new String[2000];
        for (int i = 0; i < sms.length(); i++) {
          //  if (i != bytes.length) {
                String substring = sms.substring(i, i + 1);
                by[i] = substring;
         //   }
        }
        String[] http = new String[50];
        StringBuilder httpstr = new StringBuilder();
        StringBuilder str = new StringBuilder();


        int t = 1;
        int[][] num = new int[20][2];
//        String[] strContent = new String[10];
//        StringBuilder sbContent = new StringBuilder();
//        int numContent = 0;
        int len = 0;
        int strt = 0;
        boolean ishanzi = true;
        for (int i = 0; i < sms.length(); i++) {
            //byte转string
           // String s = Byte.toString(bytes[i]);
            String s = by[i];
            System.out.println(s);
            if (!"<".equals(s)&&ishanzi == true) {
                str.append(s);
              //  sbContent.append(s);
            } else {
                ishanzi = false;
                httpstr.append(s);
                if ("<".equals(s)) {
                    ishanzi = false;
                    if (t == 2) {
                        num[len][strt] = i;
                        strt++;
                        System.out.println("#" + i);
                        if (strt == 2) {
                            strt = 0;
                            len++;
                        }
                        t++;
                    } else if (t >2){
                        t++;
                    }
                }
                if (">".equals(s)) {
                    ishanzi = true;
                    if (t == 1) {
//                        strContent[numContent]= sbContent.toString();
//                        sbContent.setLength(0);
//                        numContent++;

                        num[len][strt] = i;
                        strt++;
                        System.out.println("#"+i);
                        if (strt == 2) {
                            strt = 0;
                            len++;
                        }
                        t++;
                    } else if (t == 4) {
                        t = 1;
                    }
                }
            }
        }
        System.out.println("--------------------");
        System.out.println(sms);
        System.out.println(sms.length());
        System.out.println(str.toString());
        System.out.println(len);
        System.out.println("--------------------");
        String strc = str.toString();
        getNet(len,strc,num);
    }

    public void getNet(int len, String strc, int[][] num) {
       // <a href=    'https://www.oschina.net/p/dmnovel'    class=   'project'  target=   '_blank'  title=  '小说发布网站DMNovel  '>#DMNovel#</a>
        int httplen = 0;
        int starthttp = 0;
        System.out.println(sms);
        SpannableString msp = new SpannableString(strc);
        Pattern pattern =  Pattern.compile("<a(.*?)</a>");
        Matcher matcher = pattern.matcher(sms);
        if (matcher.find()) {
            String group = matcher.group();
            String[] split = group.split("'");
//            if (split.length == 0 || split == null) {
//
//                split = group.split(""");
//            }
            //byte[] bytes = split[split.length - 1].getBytes();
            split[split.length - 1]=split[split.length - 1].substring(1,split[split.length - 1].length()-4);

           // byte[] bytes1 = sms.getBytes();
           // bytes.
            String[] split1 = sms.split("<");
            System.out.println("2222222222222222222222222222222");
            System.out.println(split1[0]);
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
            }
            System.out.println("2222222222222222222222222222222");

                if (split!= null&&split.length > 1) {
              //  URLSpan url = new URLSpan("http://www.baidu.com");
              //  msp.setSpan(new URLSpan(split[1]), num[httplen][0],num[httplen][1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    int start = split1[0].length() - 1;
                    if (start < 0) {
                        start = 0;
                    }
                    msp.setSpan(new URLSpan(split[1]), start,  split1[0].length()+split[split.length - 1].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
               // msp.setSpan(url, strContent.length-1,split[split.length - 1].length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                httplen++;
            }

        }

        mViewHolder.setDYtext(msp);
    }

    public interface SetText {
        void onSetText(SpannableString msp);
    }

    public void setSetText(SetText listrean) {
        this.mSetText = listrean;
    }
}
