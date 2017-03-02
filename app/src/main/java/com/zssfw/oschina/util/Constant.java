package com.zssfw.oschina.util;

import com.zssfw.oschina.R;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${TODO}
 */

public class Constant {
    public static final String MESSAGE = "success";


    public static final String[] MULTIPLE_TITLE = {"资讯", "博客", "问答", "活动"};
    public static final String[] MULTIPLE_BLOG_TITLE = {"最新推荐", "本周热门", "最新博客"};

    public static final String HOST = "http://www.oschina.net";
    public static final String NEWS_HEAD = "/action/apiv2/banner?catalog=1";
    public static final String NEWS_BODY = "/action/apiv2/news?pageToken=";

    public static final String BLOG3 = "/action/apiv2/blog?catalog=3";
    public static final String BLOG = "/action/apiv2/blog?catalog=";

    public static final String[] DYNAMIC_TITLE = {"最新动弹", "热门动弹", "我的动弹"};
    public static final String DYNAMIC_LATEST = "/action/apiv2/tweets?type=1";
    public static final String LOGIN =HOST+ "/action/api/login_validate";
    public static final String FRAGMENTNAME = "fragment";
    public static final String SP_USERNAME = "username";
    public static final String SP_PWD = "password";

    public static final String[]  OSSW_TAB_TITLE  = {"分类", "推荐", "最新", "热门", "国产"};
    public static final String    FOUNDTITLE      = "FOUNDTITLE";
    public static final String    FOUNDFRAGMENT   = "FOUNDFRAGMENT";
    public static final int       SCANREQUESTCODE = 40;
    public static final String WIDTHPIXELS        = "widthpixels";
    public static final int EMOJI_LIE             = 7;
    public static final String FRIENDDETAILS_NAME      = "FOUND_FRIEND_DETAILS_NAME";
    public static final String FRIENDDETAILS_ID      = "FOUND_FRIEND_DETAILS_ID";
    public static  int widthpixels                = 0;
    public static String ONFILE_NAME              = "dynamicList1";
    public static int    ITEM_FRAG1               = -1;
    public static final String SOFTWARENAME       = "http://www.oschina.net/action/apiv2/software?ident=";
    public static       int       DYSHARD         = 3;
    public static       int       DYCOMMENT       = 2;
    public static       String    DYACTIVITY      ="dyactivity" ;
    public static       String    FILE_NAME1      = "dynamicList";
    public static       String    ITEM_FRAG       = null;
    //intent
    public static final String BUNDLE_MSG_TITLE   = "bundle_msg_title";
    public static final String BUNDLE_MSG_COMMENT = "bundle_msg_comment";
    public static final String BUNDLE_MSG_ID = "bundle_msg_id";
    public static final String BUNDLE_MSG_URL = "bundle_msg_url";
    public static final String BUNDLE             = "bundle";
    public static final String INTENT_CLASS       = "intent_class";

    //----资讯

    public static final String   NEWS_DETAILS   = "/action/apiv2/news?id=";

    public static int[] EMOJI  = new int[]{
            R.mipmap.smiley_0,
            R.mipmap.smiley_1,
            R.mipmap.smiley_2,
            R.mipmap.smiley_3,
            R.mipmap.smiley_4,
            R.mipmap.smiley_5,
            R.mipmap.smiley_6,
            R.mipmap.smiley_7,
            R.mipmap.smiley_8,
            R.mipmap.smiley_9,
            R.mipmap.smiley_10,
            R.mipmap.smiley_11,
            R.mipmap.smiley_12,
            R.mipmap.smiley_13,
            R.mipmap.smiley_14,
            R.mipmap.smiley_15,
            R.mipmap.smiley_16,
            R.mipmap.smiley_17,
            R.mipmap.smiley_18,
            R.mipmap.smiley_19,
            R.mipmap.smiley_20,
            R.mipmap.smiley_21,
            R.mipmap.smiley_22,
            R.mipmap.smiley_23,
            R.mipmap.smiley_24,
            R.mipmap.smiley_25,
            R.mipmap.smiley_26,
            R.mipmap.smiley_27,
            R.mipmap.smiley_28,
            R.mipmap.smiley_29,
            R.mipmap.smiley_30,
            R.mipmap.smiley_31,
            R.mipmap.smiley_32,
            R.mipmap.smiley_33,
            R.mipmap.smiley_34,
            R.mipmap.smiley_35,
            R.mipmap.smiley_36,
            R.mipmap.smiley_37,
            R.mipmap.smiley_38,
            R.mipmap.smiley_39,
            R.mipmap.smiley_40,
            R.mipmap.smiley_41,
            R.mipmap.smiley_42,
            R.mipmap.smiley_43,
            R.mipmap.smiley_44,
            R.mipmap.smiley_45,
            R.mipmap.smiley_46,
            R.mipmap.smiley_47,
            R.mipmap.smiley_48,
            R.mipmap.smiley_49,
            R.mipmap.smiley_50,
            R.mipmap.smiley_51,
            R.mipmap.smiley_52,
            R.mipmap.smiley_53,
            R.mipmap.smiley_54,
            R.mipmap.smiley_55,
            R.mipmap.smiley_56,
            R.mipmap.smiley_57,
            R.mipmap.smiley_58,
            R.mipmap.smiley_59,
            R.mipmap.smiley_60,
            R.mipmap.smiley_61,
            R.mipmap.smiley_62,
            R.mipmap.smiley_63,
            R.mipmap.smiley_64,
            R.mipmap.smiley_65,
            R.mipmap.smiley_66,
            R.mipmap.smiley_67,
            R.mipmap.smiley_68,
            R.mipmap.smiley_69,
            R.mipmap.smiley_70,
            R.mipmap.smiley_71,
            R.mipmap.smiley_72,
            R.mipmap.smiley_73,
            R.mipmap.smiley_74,
            R.mipmap.smiley_75,
            R.mipmap.smiley_76,
            R.mipmap.smiley_77,
            R.mipmap.smiley_78,
            R.mipmap.smiley_79,
            R.mipmap.smiley_80,
            R.mipmap.smiley_81,
            R.mipmap.smiley_82,
            R.mipmap.smiley_83,
            R.mipmap.smiley_84,
            R.mipmap.smiley_85,
            R.mipmap.smiley_86,
            R.mipmap.smiley_87,
            R.mipmap.smiley_88,
            R.mipmap.smiley_89,
            R.mipmap.smiley_90,
            R.mipmap.smiley_91,
            R.mipmap.smiley_92,
            R.mipmap.smiley_93,
            R.mipmap.smiley_94,
            R.mipmap.smiley_95,
            R.mipmap.smiley_96,
            R.mipmap.smiley_97,
            R.mipmap.smiley_98,
            R.mipmap.smiley_99,
            R.mipmap.smiley_100,
            R.mipmap.smiley_101,
            R.mipmap.smiley_102,
            R.mipmap.smiley_103,
            R.mipmap.smiley_104
    };

}
