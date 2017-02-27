package com.zssfw.oschina.ui.pager.found.bean;

import java.util.List;

/**
 * Created by Routee on 2017/2/27.
 */

public class ShakeBean {

    private OschinaBean oschina;

    public OschinaBean getOschina() {
        return oschina;
    }

    public void setOschina(OschinaBean oschina) {
        this.oschina = oschina;
    }

    public static class OschinaBean {
        private List<String> id;
        private List<String> pubDate;
        private List<String> author;
        private List<String> detail;
        private List<String> title;
        private List<String> authorid;
        private List<String> image;
        private List<String> commentCount;
        private List<String> url;
        private List<String> randomtype;

        public List<String> getId() {
            return id;
        }

        public void setId(List<String> id) {
            this.id = id;
        }

        public List<String> getPubDate() {
            return pubDate;
        }

        public void setPubDate(List<String> pubDate) {
            this.pubDate = pubDate;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public List<String> getDetail() {
            return detail;
        }

        public void setDetail(List<String> detail) {
            this.detail = detail;
        }

        public List<String> getTitle() {
            return title;
        }

        public void setTitle(List<String> title) {
            this.title = title;
        }

        public List<String> getAuthorid() {
            return authorid;
        }

        public void setAuthorid(List<String> authorid) {
            this.authorid = authorid;
        }

        public List<String> getImage() {
            return image;
        }

        public void setImage(List<String> image) {
            this.image = image;
        }

        public List<String> getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(List<String> commentCount) {
            this.commentCount = commentCount;
        }

        public List<String> getUrl() {
            return url;
        }

        public void setUrl(List<String> url) {
            this.url = url;
        }

        public List<String> getRandomtype() {
            return randomtype;
        }

        public void setRandomtype(List<String> randomtype) {
            this.randomtype = randomtype;
        }
    }
}
