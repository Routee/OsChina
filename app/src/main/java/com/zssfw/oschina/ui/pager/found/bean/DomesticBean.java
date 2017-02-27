package com.zssfw.oschina.ui.pager.found.bean;

import java.util.List;

/**
 * Created by Routee on 2017/2/26.
 */

public class DomesticBean {

    private OschinaBean oschina;

    public OschinaBean getOschina() {
        return oschina;
    }

    public void setOschina(OschinaBean oschina) {
        this.oschina = oschina;
    }

    public static class OschinaBean {
        private List<SoftwaresBean> softwares;
        private List<String>        pagesize;
        private List<String>        softwarecount;

        public List<SoftwaresBean> getSoftwares() {
            return softwares;
        }

        public void setSoftwares(List<SoftwaresBean> softwares) {
            this.softwares = softwares;
        }

        public List<String> getPagesize() {
            return pagesize;
        }

        public void setPagesize(List<String> pagesize) {
            this.pagesize = pagesize;
        }

        public List<String> getSoftwarecount() {
            return softwarecount;
        }

        public void setSoftwarecount(List<String> softwarecount) {
            this.softwarecount = softwarecount;
        }

        public static class SoftwaresBean {
            private List<SoftwareBean> software;

            public List<SoftwareBean> getSoftware() {
                return software;
            }

            public void setSoftware(List<SoftwareBean> software) {
                this.software = software;
            }

            public static class SoftwareBean {
                private List<String> id;
                private List<String> url;
                private List<String> description;
                private List<String> name;

                public List<String> getId() {
                    return id;
                }

                public void setId(List<String> id) {
                    this.id = id;
                }

                public List<String> getUrl() {
                    return url;
                }

                public void setUrl(List<String> url) {
                    this.url = url;
                }

                public List<String> getDescription() {
                    return description;
                }

                public void setDescription(List<String> description) {
                    this.description = description;
                }

                public List<String> getName() {
                    return name;
                }

                public void setName(List<String> name) {
                    this.name = name;
                }
            }
        }
    }
}
