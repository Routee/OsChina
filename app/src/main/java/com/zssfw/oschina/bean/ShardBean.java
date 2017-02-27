package com.zssfw.oschina.bean;

import com.zssfw.oschina.interfaces.Bodytype;

import java.io.Serializable;
import java.util.List;

/**
 * @创建者 administrator
 * @创建时间 2017/2/25 21:13
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 2017/2/25$
 * @更新描述 ${TODO}
 */

public class ShardBean   implements Serializable,Bodytype{


    /**
     * code : 1
     * message : SUCCESS
     * notice : {"fans":0,"letter":0,"like":0,"mention":0,"review":0}
     * result : {"items":[{"appClient":3,"author":{"id":3292587,"name":"fdzx","portrait":"http://www.oschina.net/img/portrait.gif","relation":0},"commentCount":0,"content":" 学习","href":"https://my.oschina.net/u/3292587/tweet/12259975","id":12259975,"likeCount":0,"liked":false,"pubDate":"2017-02-26 13:29:56","statistics":{"comment":0,"favCount":0,"like":0,"transmit":0,"view":0}}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":1,"totalResults":1}
     * time : 2017-02-26 22:06:40
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
     * items : [{"appClient":3,"author":{"id":3292587,"name":"fdzx","portrait":"http://www.oschina.net/img/portrait.gif","relation":0},"commentCount":0,"content":" 学习","href":"https://my.oschina.net/u/3292587/tweet/12259975","id":12259975,"likeCount":0,"liked":false,"pubDate":"2017-02-26 13:29:56","statistics":{"comment":0,"favCount":0,"like":0,"transmit":0,"view":0}}]
     * nextPageToken : DBA816934CD0AA59
     * prevPageToken : 0997C855C600E421
     * requestCount : 20
     * responseCount : 1
     * totalResults : 1
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
         * appClient : 3
         * author : {"id":3292587,"name":"fdzx","portrait":"http://www.oschina.net/img/portrait.gif","relation":0}
         * commentCount : 0
         * content :  学习
         * href : https://my.oschina.net/u/3292587/tweet/12259975
         * id : 12259975
         * likeCount : 0
         * liked : false
         * pubDate : 2017-02-26 13:29:56
         * statistics : {"comment":0,"favCount":0,"like":0,"transmit":0,"view":0}
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
            private int appClient;
            /**
             * id : 3292587
             * name : fdzx
             * portrait : http://www.oschina.net/img/portrait.gif
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
             * comment : 0
             * favCount : 0
             * like : 0
             * transmit : 0
             * view : 0
             */

            private StatisticsBean statistics;

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
        }
    }
}
