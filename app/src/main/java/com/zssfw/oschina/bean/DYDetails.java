package com.zssfw.oschina.bean;

import java.util.List;

/**
 * @创建者 administrator
 * @创建时间 2017/2/27 11:09
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/27$
 * @更新描述 ${TODO}
 */

public class DYDetails {

    /**
     * code : 1
     * message : SUCCESS
     * notice : {"fans":0,"letter":0,"like":0,"mention":0,"review":0}
     * result : {"appClient":4,"author":{"id":3229380,"name":"李狗蛋儿_","portrait":"http://static.oschina.net/uploads/user/1614/3229380_50.jpg?t=1484654494000","relation":0},"commentCount":2,"content":"有一次做噩梦,梦见一个女鬼坐在我身上使劲掐我脖子,于是我使劲一翻身,硬是把噩梦做成了春梦 [抠鼻]","href":"https://my.oschina.net/u/3229380/tweet/12266579","id":12266579,"images":[{"h":550,"href":"http://static.oschina.net/uploads/space/2017/0227/110334_TVDR_3229380.png","name":"110334_TVDR_3229380","thumb":"http://static.oschina.net/uploads/space/2017/0227/110334_TVDR_3229380_thumb.png","type":"png","w":440}],"likeCount":7,"liked":false,"pubDate":"2017-02-27 11:03:35","statistics":{"comment":2,"favCount":0,"like":7,"transmit":0,"view":0}}
     * time : 2017-02-27 11:06:32
     */

    private int code;
    private String message;
    /**
     * fans : 0
     * letter : 0
     * like : 0
     * mention : 0
     * review : 0
     */

    private NoticeBean notice;
    /**
     * appClient : 4
     * author : {"id":3229380,"name":"李狗蛋儿_","portrait":"http://static.oschina.net/uploads/user/1614/3229380_50.jpg?t=1484654494000","relation":0}
     * commentCount : 2
     * content : 有一次做噩梦,梦见一个女鬼坐在我身上使劲掐我脖子,于是我使劲一翻身,硬是把噩梦做成了春梦 [抠鼻]
     * href : https://my.oschina.net/u/3229380/tweet/12266579
     * id : 12266579
     * images : [{"h":550,"href":"http://static.oschina.net/uploads/space/2017/0227/110334_TVDR_3229380.png","name":"110334_TVDR_3229380","thumb":"http://static.oschina.net/uploads/space/2017/0227/110334_TVDR_3229380_thumb.png","type":"png","w":440}]
     * likeCount : 7
     * liked : false
     * pubDate : 2017-02-27 11:03:35
     * statistics : {"comment":2,"favCount":0,"like":7,"transmit":0,"view":0}
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

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
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

    public static class NoticeBean {
        private int fans;
        private int letter;
        private int like;
        private int mention;
        private int review;

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public int getLetter() {
            return letter;
        }

        public void setLetter(int letter) {
            this.letter = letter;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getMention() {
            return mention;
        }

        public void setMention(int mention) {
            this.mention = mention;
        }

        public int getReview() {
            return review;
        }

        public void setReview(int review) {
            this.review = review;
        }
    }

    public static class ResultBean {
        private int appClient;
        /**
         * id : 3229380
         * name : 李狗蛋儿_
         * portrait : http://static.oschina.net/uploads/user/1614/3229380_50.jpg?t=1484654494000
         * relation : 0
         */

        private AuthorBean author;
        private int     commentCount;
        private String  content;
        private String  href;
        private int     id;
        private int     likeCount;
        private boolean liked;
        private String  pubDate;
        /**
         * comment : 2
         * favCount : 0
         * like : 7
         * transmit : 0
         * view : 0
         */

        private StatisticsBean   statistics;
        /**
         * h : 550
         * href : http://static.oschina.net/uploads/space/2017/0227/110334_TVDR_3229380.png
         * name : 110334_TVDR_3229380
         * thumb : http://static.oschina.net/uploads/space/2017/0227/110334_TVDR_3229380_thumb.png
         * type : png
         * w : 440
         */

        private List<ImagesBean> images;

        public int getAppClient() {
            return appClient;
        }

        public void setAppClient(int appClient) {
            this.appClient = appClient;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public StatisticsBean getStatistics() {
            return statistics;
        }

        public void setStatistics(StatisticsBean statistics) {
            this.statistics = statistics;
        }

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public static class AuthorBean {
            private int    id;
            private String name;
            private String portrait;
            private int    relation;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
                this.portrait = portrait;
            }

            public int getRelation() {
                return relation;
            }

            public void setRelation(int relation) {
                this.relation = relation;
            }
        }

        public static class StatisticsBean {
            private int comment;
            private int favCount;
            private int like;
            private int transmit;
            private int view;

            public int getComment() {
                return comment;
            }

            public void setComment(int comment) {
                this.comment = comment;
            }

            public int getFavCount() {
                return favCount;
            }

            public void setFavCount(int favCount) {
                this.favCount = favCount;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public int getTransmit() {
                return transmit;
            }

            public void setTransmit(int transmit) {
                this.transmit = transmit;
            }

            public int getView() {
                return view;
            }

            public void setView(int view) {
                this.view = view;
            }
        }

        public static class ImagesBean {
            private int    h;
            private String href;
            private String name;
            private String thumb;
            private String type;
            private int    w;

            public int getH() {
                return h;
            }

            public void setH(int h) {
                this.h = h;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getW() {
                return w;
            }

            public void setW(int w) {
                this.w = w;
            }
        }
    }
}
