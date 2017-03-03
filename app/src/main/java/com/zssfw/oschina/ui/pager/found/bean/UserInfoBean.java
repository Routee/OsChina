package com.zssfw.oschina.ui.pager.found.bean;

import java.util.List;

/**
 * Created by Routee on 2017/2/28.
 * 搜索用户界面搜索结果中单个条目详细信息
 */

public class UserInfoBean {

    private OschinaBean oschina;

    public OschinaBean getOschina() {
        return oschina;
    }

    public void setOschina(OschinaBean oschina) {
        this.oschina = oschina;
    }

    public static class OschinaBean {
        private List<ActiviesBean> activies;
        private List<UserBean>     user;
        private List<String>       pagesize;

        public List<ActiviesBean> getActivies() {
            return activies;
        }

        public void setActivies(List<ActiviesBean> activies) {
            this.activies = activies;
        }

        public List<UserBean> getUser() {
            return user;
        }

        public void setUser(List<UserBean> user) {
            this.user = user;
        }

        public List<String> getPagesize() {
            return pagesize;
        }

        public void setPagesize(List<String> pagesize) {
            this.pagesize = pagesize;
        }

        public static class ActiviesBean {
            private List<ActiveBean> active;

            public List<ActiveBean> getActive() {
                return active;
            }

            public void setActive(List<ActiveBean> active) {
                this.active = active;
            }

            public static class ActiveBean {
                private List<String> objectcatalog;
                private List<String> appclient;
                private List<String> authorid;
                private List<String> objectID;
                private List<String> id;
                private List<String> catalog;
                private List<String> objecttype;
                private List<String> pubDate;
                private List<String> portrait;
                private List<String> message;
                private List<String> commentCount;
                private List<String> objecttitle;
                private List<String> author;

                public List<String> getObjectcatalog() {
                    return objectcatalog;
                }

                public void setObjectcatalog(List<String> objectcatalog) {
                    this.objectcatalog = objectcatalog;
                }

                public List<String> getAppclient() {
                    return appclient;
                }

                public void setAppclient(List<String> appclient) {
                    this.appclient = appclient;
                }

                public List<String> getAuthorid() {
                    return authorid;
                }

                public void setAuthorid(List<String> authorid) {
                    this.authorid = authorid;
                }

                public List<String> getObjectID() {
                    return objectID;
                }

                public void setObjectID(List<String> objectID) {
                    this.objectID = objectID;
                }

                public List<String> getId() {
                    return id;
                }

                public void setId(List<String> id) {
                    this.id = id;
                }

                public List<String> getCatalog() {
                    return catalog;
                }

                public void setCatalog(List<String> catalog) {
                    this.catalog = catalog;
                }

                public List<String> getObjecttype() {
                    return objecttype;
                }

                public void setObjecttype(List<String> objecttype) {
                    this.objecttype = objecttype;
                }

                public List<String> getPubDate() {
                    return pubDate;
                }

                public void setPubDate(List<String> pubDate) {
                    this.pubDate = pubDate;
                }

                public List<String> getPortrait() {
                    return portrait;
                }

                public void setPortrait(List<String> portrait) {
                    this.portrait = portrait;
                }

                public List<String> getMessage() {
                    return message;
                }

                public void setMessage(List<String> message) {
                    this.message = message;
                }

                public List<String> getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(List<String> commentCount) {
                    this.commentCount = commentCount;
                }

                public List<String> getObjecttitle() {
                    return objecttitle;
                }

                public void setObjecttitle(List<String> objecttitle) {
                    this.objecttitle = objecttitle;
                }

                public List<String> getAuthor() {
                    return author;
                }

                public void setAuthor(List<String> author) {
                    this.author = author;
                }
            }
        }

        public static class UserBean {
            private List<String> latestonline;
            private List<String> score;
            private List<String> fans;
            private List<String> relation;
            private List<String> followers;
            private List<String> portrait;
            private List<String> name;
            private List<String> gender;
            private List<String> uid;
            private List<String> devplatform;
            private List<String> from;
            private List<String> expertise;
            private List<String> jointime;

            public List<String> getLatestonline() {
                return latestonline;
            }

            public void setLatestonline(List<String> latestonline) {
                this.latestonline = latestonline;
            }

            public List<String> getScore() {
                return score;
            }

            public void setScore(List<String> score) {
                this.score = score;
            }

            public List<String> getFans() {
                return fans;
            }

            public void setFans(List<String> fans) {
                this.fans = fans;
            }

            public List<String> getRelation() {
                return relation;
            }

            public void setRelation(List<String> relation) {
                this.relation = relation;
            }

            public List<String> getFollowers() {
                return followers;
            }

            public void setFollowers(List<String> followers) {
                this.followers = followers;
            }

            public List<String> getPortrait() {
                return portrait;
            }

            public void setPortrait(List<String> portrait) {
                this.portrait = portrait;
            }

            public List<String> getName() {
                return name;
            }

            public void setName(List<String> name) {
                this.name = name;
            }

            public List<String> getGender() {
                return gender;
            }

            public void setGender(List<String> gender) {
                this.gender = gender;
            }

            public List<String> getUid() {
                return uid;
            }

            public void setUid(List<String> uid) {
                this.uid = uid;
            }

            public List<String> getDevplatform() {
                return devplatform;
            }

            public void setDevplatform(List<String> devplatform) {
                this.devplatform = devplatform;
            }

            public List<String> getFrom() {
                return from;
            }

            public void setFrom(List<String> from) {
                this.from = from;
            }

            public List<String> getExpertise() {
                return expertise;
            }

            public void setExpertise(List<String> expertise) {
                this.expertise = expertise;
            }

            public List<String> getJointime() {
                return jointime;
            }

            public void setJointime(List<String> jointime) {
                this.jointime = jointime;
            }
        }
    }
}
