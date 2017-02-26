package com.zssfw.oschina.ui.pager.found.bean;

import java.util.List;

/**
 * Created by Routee on 2017/2/25.
 */

public class FoundUserBean {

    private OschinaBean oschina;

    public OschinaBean getOschina() {
        return oschina;
    }

    public void setOschina(OschinaBean oschina) {
        this.oschina = oschina;
    }

    public static class OschinaBean {
        private List<UsersBean> users;

        public List<UsersBean> getUsers() {
            return users;
        }

        public void setUsers(List<UsersBean> users) {
            this.users = users;
        }

        public static class UsersBean {
            private List<UserBean> user;

            public List<UserBean> getUser() {
                return user;
            }

            public void setUser(List<UserBean> user) {
                this.user = user;
            }

            public static class UserBean {
                private List<String> from;
                private List<String> gender;
                private List<String> name;
                private List<String> portrait;
                private List<String> uid;

                public List<String> getFrom() {
                    return from;
                }

                public void setFrom(List<String> from) {
                    this.from = from;
                }

                public List<String> getGender() {
                    return gender;
                }

                public void setGender(List<String> gender) {
                    this.gender = gender;
                }

                public List<String> getName() {
                    return name;
                }

                public void setName(List<String> name) {
                    this.name = name;
                }

                public List<String> getPortrait() {
                    return portrait;
                }

                public void setPortrait(List<String> portrait) {
                    this.portrait = portrait;
                }

                public List<String> getUid() {
                    return uid;
                }

                public void setUid(List<String> uid) {
                    this.uid = uid;
                }
            }
        }
    }
}
