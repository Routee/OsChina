package com.zssfw.oschina.bean;



/**
 * Created by leoo on 2017-2-24.
 */


    public  class OschinaBean {
    @Override
    public String toString() {
        return "OschinaBean{" +
                "result=" + result +
                ", user=" + user +
                ", notice=" + notice +
                '}';
    }

    /**
         * errorMessage : 登录成功
         * errorCode : 1
         */

        private ResultBean result;
        /**
         * uid : 231738
         * score : 0
         * followers : 0
         * gender : 1
         * name : android_自由
         * location : 浙江 杭州
         * portrait :
         * favoritecount : 2
         * fans : 0
         */

        private UserBean   user;
        /**
         * newLikeCount : 0
         * reviewCount : 0
         * newFansCount : 0
         * msgCount : 0
         * atmeCount : 0
         */

        private NoticeBean notice;

        public ResultBean getResult() {
            return result;
        }

        public void setResult(ResultBean result) {
            this.result = result;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public NoticeBean getNotice() {
            return notice;
        }

        public void setNotice(NoticeBean notice) {
            this.notice = notice;
        }

        public static class ResultBean {
            private String errorMessage;
            private int    errorCode;

            public String getErrorMessage() {
                return errorMessage;
            }

            public void setErrorMessage(String errorMessage) {
                this.errorMessage = errorMessage;
            }

            public int getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(int errorCode) {
                this.errorCode = errorCode;
            }
        }

        public static class UserBean {
            private int    uid;
            private int    score;
            private int    followers;
            private int    gender;
            private String name;
            private String location;
            private String portrait;
            private int    favoritecount;
            private int    fans;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getFollowers() {
                return followers;
            }

            public void setFollowers(int followers) {
                this.followers = followers;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
                this.portrait = portrait;
            }

            public int getFavoritecount() {
                return favoritecount;
            }

            public void setFavoritecount(int favoritecount) {
                this.favoritecount = favoritecount;
            }

            public int getFans() {
                return fans;
            }

            public void setFans(int fans) {
                this.fans = fans;
            }
        }

        public static class NoticeBean {
            private int newLikeCount;
            private int reviewCount;
            private int newFansCount;
            private int msgCount;
            private int atmeCount;

            public int getNewLikeCount() {
                return newLikeCount;
            }

            public void setNewLikeCount(int newLikeCount) {
                this.newLikeCount = newLikeCount;
            }

            public int getReviewCount() {
                return reviewCount;
            }

            public void setReviewCount(int reviewCount) {
                this.reviewCount = reviewCount;
            }

            public int getNewFansCount() {
                return newFansCount;
            }

            public void setNewFansCount(int newFansCount) {
                this.newFansCount = newFansCount;
            }

            public int getMsgCount() {
                return msgCount;
            }

            public void setMsgCount(int msgCount) {
                this.msgCount = msgCount;
            }

            public int getAtmeCount() {
                return atmeCount;
            }

            public void setAtmeCount(int atmeCount) {
                this.atmeCount = atmeCount;
            }
        }
    }

