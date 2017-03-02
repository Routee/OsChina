package com.zssfw.oschina.ui.pager.found.bean;

import java.util.List;

/**
 * Created by Routee on 2017/3/1.
 */

public class UserInfoItemBean {

    /**
     * code : 1
     * message : SUCCESS
     * result : {"author":"astaxie","authorId":245869,"authorPortrait":"https://static.oschina.net/uploads/user/122/245869_50.jpg?t=1387597640000","body":"<p>GopherChina&nbsp;是中国的最权威和最实力干货的Go大会，我们致力于为中国广大的Gopher提供最好的大会，我们本着非盈利目的来举办大会，前面两届大会在上海和北京都获得了非常好的口碑，今年我们大会将在四月份举办大会。举办Gopher大会，主要是汇集Gopher的广大开发者，聚集一批大规模应用Go的示范企业给大家分享，呈现一场cool的盛会。<\/p> \n<p>这是2015年Go作者之一Robert参会之后写的博客：<a href=\"https://blog.golang.org/gopherchina\" rel=\"nofollow\">https://blog.golang.org/gopherchina<\/a><\/p> \n<p>第一届我们的大会参会人数是500人，去年在北京差不多达到了1000人的规模，&nbsp;今年我们组织了1500人的场地，面向的受众也是越来越多，同时我们也邀请了Go team的同学过来分享。<\/p> \n<p>我们的传统是每年必须有T恤，必须有，而且是限量版，只有参会的人才有，买不到。<\/p> \n<p>&nbsp;<\/p> \n<p>报名地址：http://www.bagevent.com/event/357764<\/p> \n<p>&nbsp;<\/p>","commentCount":0,"favorite":false,"href":"https://www.oschina.net/event/2219227","id":2219227,"pubDate":"2017-02-09 19:49:22","tags":[],"title":"第三届GopherChina上海大会","viewCount":6}
     * time : 2017-03-01 10:36:29
     */

    private int code;
    private String message;
    /**
     * author : astaxie
     * authorId : 245869
     * authorPortrait : https://static.oschina.net/uploads/user/122/245869_50.jpg?t=1387597640000
     * body : <p>GopherChina&nbsp;是中国的最权威和最实力干货的Go大会，我们致力于为中国广大的Gopher提供最好的大会，我们本着非盈利目的来举办大会，前面两届大会在上海和北京都获得了非常好的口碑，今年我们大会将在四月份举办大会。举办Gopher大会，主要是汇集Gopher的广大开发者，聚集一批大规模应用Go的示范企业给大家分享，呈现一场cool的盛会。</p>
     <p>这是2015年Go作者之一Robert参会之后写的博客：<a href="https://blog.golang.org/gopherchina" rel="nofollow">https://blog.golang.org/gopherchina</a></p>
     <p>第一届我们的大会参会人数是500人，去年在北京差不多达到了1000人的规模，&nbsp;今年我们组织了1500人的场地，面向的受众也是越来越多，同时我们也邀请了Go team的同学过来分享。</p>
     <p>我们的传统是每年必须有T恤，必须有，而且是限量版，只有参会的人才有，买不到。</p>
     <p>&nbsp;</p>
     <p>报名地址：http://www.bagevent.com/event/357764</p>
     <p>&nbsp;</p>
     * commentCount : 0
     * favorite : false
     * href : https://www.oschina.net/event/2219227
     * id : 2219227
     * pubDate : 2017-02-09 19:49:22
     * tags : []
     * title : 第三届GopherChina上海大会
     * viewCount : 6
     */

    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static class ResultBean {
        private String  author;
        private int     authorId;
        private String  authorPortrait;
        private String  body;
        private int     commentCount;
        private boolean favorite;
        private String  href;
        private int     id;
        private String  pubDate;
        private String  title;
        private int     viewCount;
        private List<?> tags;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getAuthorId() {
            return authorId;
        }

        public void setAuthorId(int authorId) {
            this.authorId = authorId;
        }

        public String getAuthorPortrait() {
            return authorPortrait;
        }

        public void setAuthorPortrait(String authorPortrait) {
            this.authorPortrait = authorPortrait;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public boolean isFavorite() {
            return favorite;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }
    }
}
