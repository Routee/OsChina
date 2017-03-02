package com.zssfw.oschina.bean;

/**
 * Created by Administrator on 2017/3/1.
 */

public class ReportCommentBean {

    /**
     * code : 1
     * message : SUCCESS
     * result : {"appClient":0,"author":"android_自由","authorId":231738,"authorPortrait":"https://www.oschina.net/img/portrait.gif","best":false,"content":"<div class='detail'>好东西<\/div>","id":294912114,"pubDate":"2016-09-23 00:09:30","vote":0,"voteState":0}
     * time : 2016-09-23 00:09:30
     */

    private int code;
    private String message;
    /**
     * appClient : 0
     * author : android_自由
     * authorId : 231738
     * authorPortrait : https://www.oschina.net/img/portrait.gif
     * best : false
     * content : <div class='detail'>好东西</div>
     * id : 294912114
     * pubDate : 2016-09-23 00:09:30
     * vote : 0
     * voteState : 0
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
        private int     appClient;
        private String  author;
        private int     authorId;
        private String  authorPortrait;
        private boolean best;
        private String  content;
        private int     id;
        private String  pubDate;
        private int     vote;
        private int     voteState;

        public int getAppClient() {
            return appClient;
        }

        public void setAppClient(int appClient) {
            this.appClient = appClient;
        }

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

        public boolean isBest() {
            return best;
        }

        public void setBest(boolean best) {
            this.best = best;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public int getVote() {
            return vote;
        }

        public void setVote(int vote) {
            this.vote = vote;
        }

        public int getVoteState() {
            return voteState;
        }

        public void setVoteState(int voteState) {
            this.voteState = voteState;
        }
    }
}
