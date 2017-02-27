package com.zssfw.oschina.util;

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
    public static final String SOFTWARENAME       = "http://www.oschina.net/action/apiv2/software?ident=";
    public static String ONFILE_NAME              = "dynamicList1";
    public static int    ITEM_FRAG1               = -1;
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



}
