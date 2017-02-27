package com.zssfw.oschina.bean;

import java.util.List;

/**
 * @创建者 administrator
 * @创建时间 2017/2/27 15:10
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/27$
 * @更新描述 ${TODO}
 */

public class LikeBean {

    /**
     * code : 1
     * message : SUCCESS
     * notice : {"fans":0,"letter":0,"like":0,"mention":0,"review":0}
     * result : {"items":[{"author":{"id":3275448,"name":"Sharon_mx","portrait":"http://static.oschina.net/uploads/user/1637/3275448_50.jpg?t=1487210871000","relation":0},"pubDate":"2017-02-27 10:25:08"},{"author":{"id":2607540,"name":"守望者翱翔","portrait":"http://static.oschina.net/uploads/user/1303/2607540_50.jpg?t=1452214129000","relation":0},"pubDate":"2017-02-27 00:21:30"},{"author":{"id":2689427,"name":"LuangJ_OSC","portrait":"http://static.oschina.net/uploads/user/1344/2689427_50.jpg?t=1484029839000","relation":0},"pubDate":"2017-02-26 16:52:55"},{"author":{"id":3297360,"name":"yjl123456","portrait":"http://www.oschina.net/img/portrait.gif","relation":0},"pubDate":"2017-02-26 13:48:42"},{"author":{"id":2609174,"name":"落落酱","portrait":"http://static.oschina.net/uploads/user/1304/2609174_50.jpg?t=1486332631000","relation":0},"pubDate":"2017-02-26 07:58:35"},{"author":{"id":2346522,"name":"sslyd","portrait":"http://static.oschina.net/uploads/user/1173/2346522_50.jpg?t=1448173118000","relation":0},"pubDate":"2017-02-26 07:12:14"},{"author":{"id":2301248,"name":"tuzhao","portrait":"http://static.oschina.net/uploads/user/1150/2301248_50.png?t=1451981816000","relation":0},"pubDate":"2017-02-26 00:13:04"},{"author":{"id":2535749,"name":"小渔顽","portrait":"http://static.oschina.net/uploads/user/1267/2535749_50.jpg?t=1486303240000","relation":0},"pubDate":"2017-02-25 12:38:26"},{"author":{"id":3041628,"name":"亚麻仔","portrait":"http://static.oschina.net/uploads/user/1520/3041628_50.jpg?t=1479119959000","relation":0},"pubDate":"2017-02-25 10:46:00"},{"author":{"id":1000238,"name":"降龙罗汉","portrait":"http://static.oschina.net/uploads/user/500/1000238_50.jpg?t=1407921413000","relation":0},"pubDate":"2017-02-25 08:21:01"},{"author":{"id":1428332,"name":"小小编辑","portrait":"http://static.oschina.net/uploads/user/714/1428332_50.jpg?t=1400110163000","relation":0},"pubDate":"2017-02-24 22:31:42"},{"author":{"id":2321633,"name":"马晓倩osc","portrait":"http://static.oschina.net/uploads/user/1160/2321633_50.jpg?t=1425351601000","relation":0},"pubDate":"2017-02-24 17:02:06"},{"author":{"id":1028150,"name":"成熟的毛毛虫","portrait":"http://static.oschina.net/uploads/user/514/1028150_50.jpeg?t=1475119864000","relation":0},"pubDate":"2017-02-24 16:56:34"},{"author":{"id":2340783,"name":"巴拉迪维","portrait":"http://static.oschina.net/uploads/user/1170/2340783_50.jpg?t=1484367495000","relation":0},"pubDate":"2017-02-24 16:56:31"},{"author":{"id":2765296,"name":"2973901695","portrait":"http://static.oschina.net/uploads/user/1382/2765296_50.jpg?t=1486863567000","relation":0},"pubDate":"2017-02-24 16:43:24"}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":15,"totalResults":15}
     * time : 2017-02-27 14:46:53
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
     * items : [{"author":{"id":3275448,"name":"Sharon_mx","portrait":"http://static.oschina.net/uploads/user/1637/3275448_50.jpg?t=1487210871000","relation":0},"pubDate":"2017-02-27 10:25:08"},{"author":{"id":2607540,"name":"守望者翱翔","portrait":"http://static.oschina.net/uploads/user/1303/2607540_50.jpg?t=1452214129000","relation":0},"pubDate":"2017-02-27 00:21:30"},{"author":{"id":2689427,"name":"LuangJ_OSC","portrait":"http://static.oschina.net/uploads/user/1344/2689427_50.jpg?t=1484029839000","relation":0},"pubDate":"2017-02-26 16:52:55"},{"author":{"id":3297360,"name":"yjl123456","portrait":"http://www.oschina.net/img/portrait.gif","relation":0},"pubDate":"2017-02-26 13:48:42"},{"author":{"id":2609174,"name":"落落酱","portrait":"http://static.oschina.net/uploads/user/1304/2609174_50.jpg?t=1486332631000","relation":0},"pubDate":"2017-02-26 07:58:35"},{"author":{"id":2346522,"name":"sslyd","portrait":"http://static.oschina.net/uploads/user/1173/2346522_50.jpg?t=1448173118000","relation":0},"pubDate":"2017-02-26 07:12:14"},{"author":{"id":2301248,"name":"tuzhao","portrait":"http://static.oschina.net/uploads/user/1150/2301248_50.png?t=1451981816000","relation":0},"pubDate":"2017-02-26 00:13:04"},{"author":{"id":2535749,"name":"小渔顽","portrait":"http://static.oschina.net/uploads/user/1267/2535749_50.jpg?t=1486303240000","relation":0},"pubDate":"2017-02-25 12:38:26"},{"author":{"id":3041628,"name":"亚麻仔","portrait":"http://static.oschina.net/uploads/user/1520/3041628_50.jpg?t=1479119959000","relation":0},"pubDate":"2017-02-25 10:46:00"},{"author":{"id":1000238,"name":"降龙罗汉","portrait":"http://static.oschina.net/uploads/user/500/1000238_50.jpg?t=1407921413000","relation":0},"pubDate":"2017-02-25 08:21:01"},{"author":{"id":1428332,"name":"小小编辑","portrait":"http://static.oschina.net/uploads/user/714/1428332_50.jpg?t=1400110163000","relation":0},"pubDate":"2017-02-24 22:31:42"},{"author":{"id":2321633,"name":"马晓倩osc","portrait":"http://static.oschina.net/uploads/user/1160/2321633_50.jpg?t=1425351601000","relation":0},"pubDate":"2017-02-24 17:02:06"},{"author":{"id":1028150,"name":"成熟的毛毛虫","portrait":"http://static.oschina.net/uploads/user/514/1028150_50.jpeg?t=1475119864000","relation":0},"pubDate":"2017-02-24 16:56:34"},{"author":{"id":2340783,"name":"巴拉迪维","portrait":"http://static.oschina.net/uploads/user/1170/2340783_50.jpg?t=1484367495000","relation":0},"pubDate":"2017-02-24 16:56:31"},{"author":{"id":2765296,"name":"2973901695","portrait":"http://static.oschina.net/uploads/user/1382/2765296_50.jpg?t=1486863567000","relation":0},"pubDate":"2017-02-24 16:43:24"}]
     * nextPageToken : DBA816934CD0AA59
     * prevPageToken : 0997C855C600E421
     * requestCount : 20
     * responseCount : 15
     * totalResults : 15
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
        private String nextPageToken;
        private String prevPageToken;
        private int    requestCount;
        private int    responseCount;
        private int    totalResults;
        /**
         * author : {"id":3275448,"name":"Sharon_mx","portrait":"http://static.oschina.net/uploads/user/1637/3275448_50.jpg?t=1487210871000","relation":0}
         * pubDate : 2017-02-27 10:25:08
         */

        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * id : 3275448
             * name : Sharon_mx
             * portrait : http://static.oschina.net/uploads/user/1637/3275448_50.jpg?t=1487210871000
             * relation : 0
             */

            private AuthorBean author;
            private String pubDate;

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
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
        }
    }
}
