package com.zssfw.oschina.ui.pager.found.bean;

import java.util.List;

/**
 * Created by Routee on 2017/2/27.
 */

public class Classify1Bean {

    private OschinaBean oschina;

    public OschinaBean getOschina() {
        return oschina;
    }

    public void setOschina(OschinaBean oschina) {
        this.oschina = oschina;
    }

    public static class OschinaBean {
        private List<SoftwareTypesBean> softwareTypes;
        private List<String>            softwarecount;

        public List<SoftwareTypesBean> getSoftwareTypes() {
            return softwareTypes;
        }

        public void setSoftwareTypes(List<SoftwareTypesBean> softwareTypes) {
            this.softwareTypes = softwareTypes;
        }

        public List<String> getSoftwarecount() {
            return softwarecount;
        }

        public void setSoftwarecount(List<String> softwarecount) {
            this.softwarecount = softwarecount;
        }

        public static class SoftwareTypesBean {
            private List<SoftwareTypeBean> softwareType;

            public List<SoftwareTypeBean> getSoftwareType() {
                return softwareType;
            }

            public void setSoftwareType(List<SoftwareTypeBean> softwareType) {
                this.softwareType = softwareType;
            }

            public static class SoftwareTypeBean {
                private List<String> name;
                private List<String> tag;

                public List<String> getName() {
                    return name;
                }

                public void setName(List<String> name) {
                    this.name = name;
                }

                public List<String> getTag() {
                    return tag;
                }

                public void setTag(List<String> tag) {
                    this.tag = tag;
                }
            }
        }
    }
}
