package com.zssfw.oschina.bean;

import java.util.List;

/**
 * Created by SJJ on 2017/2/21.
 * 描述 ${TODO}
 */

public class NewsBodyBean {

    /**
     * code : 1
     * message : success
     * result : {"items":[{"author":"淡漠悠然","body":"Apache RocketMQ 4.0.0 (INCUBATING) 发布了。 更新内容： Bug [ROCKETMQ-2] - 代理测试失败，显示\u201c地址已在使用\u201d [ROCKETMQ-5] - 无法在UtilAll...","commentCount":2,"href":"https://www.oschina.net/news/82146/apache-rocketmq-4-0-0","id":82146,"pubDate":"2017-02-21 18:53:05","recommend":true,"title":"Apache RocketMQ 4.0.0 (INCUBATING) 发布","type":6,"viewCount":45},{"author":"贤心","body":"似乎已经太久没有更新的样子（差不多两个月吧），时间就这样悄悄偷走了我们往日的热情、磨灭了一丝丝执念。但总有人仍然深爱着她对么（怎么听着怪怪...","commentCount":18,"href":"https://www.oschina.net/news/82144/layui-1-0-8","id":82144,"pubDate":"2017-02-21 16:00:55","recommend":true,"title":"layui 1.0.8 发布，传统模块化前端 UI 框架","type":6,"viewCount":624},{"author":"88250","body":"这个版本主要是改进了评论模版机制，让大家更方便皮肤制作，并发布了一款新皮肤：9IPHP。 Solo 是一款一个命令就能搭建好的 Java 开源博客系统，并...","commentCount":28,"href":"https://www.oschina.net/news/82143/solo-1-9-0","id":82143,"pubDate":"2017-02-21 15:42:17","recommend":true,"title":"Java 开源博客 Solo 1.9.0 发布 - 新皮肤","type":6,"viewCount":972},{"author":"葛俊","body":"MyBatisCodeHelper 1.3 发布了。MyBatisCodeHelper 是一款 Intellij 下的插件，通过 java 对象来生成建表 sql，mybatis curd 代码， 提供 mybatis ...","commentCount":3,"href":"https://www.oschina.net/news/82140/mybatiscodehelper-1-3","id":82140,"pubDate":"2017-02-21 14:56:52","recommend":true,"title":"MyBatisCodeHelper 1.3 发布","type":6,"viewCount":573},{"author":"局长","body":"卡巴斯基今天跳出老本行，发布了名为 Kaspersky OS 的操作系统，主要使用对象为网络设备、工业控制系统和物联网设备。 据卡巴斯基 CEO Eugene Kas...","commentCount":15,"href":"https://www.oschina.net/news/82138/kaspersky-os-first-released","id":82138,"pubDate":"2017-02-21 14:21:09","recommend":true,"title":"卡巴斯基首款操作系统Kaspersky OS发布 兼容 x86/ARM","type":6,"viewCount":1701},{"author":"lyunweb","body":"一、简介 lyadmin是一套轻量级通用后台，采用Bootstrap3制作，自带权限管理，模块化开发。 二、更新 修复安装sql及公共函数问题 新增docs 更新REA...","commentCount":0,"href":"https://www.oschina.net/news/82137/lyadmin-1-1-1","id":82137,"pubDate":"2017-02-21 12:15:37","recommend":false,"title":"lyadmin 1.1.1 正式版发布，开源通用后台","type":6,"viewCount":1207},{"author":"局长","body":"在每年的 I/O 大会上，谷歌通常会发布新系统和新产品。 就在去年的 I/O 大会，谷歌发布了新一代安卓 7.0 牛轧糖系统。但这一最新系统的装机率却长时...","commentCount":40,"href":"https://www.oschina.net/news/82136/android-8-0-at-hand-may-be-called-the-oreo","id":82136,"pubDate":"2017-02-21 11:46:01","recommend":false,"title":"安卓 8.0 系统就要到来 代号或是奥利奥？","type":6,"viewCount":2331},{"author":"局长","body":"Docker v17.03.0-ce-rc1 发布了，其 GitHub 主页显示将于 2017-03-01 发布 17.03.0-ce。本次更新内容如下： Client Fix panic in docker stats --...","commentCount":8,"href":"https://www.oschina.net/news/82135/docker-17-03-0-ce-rc1","id":82135,"pubDate":"2017-02-21 11:22:03","recommend":false,"title":"Docker v17.03.0-ce-rc1 发布，应用容器引擎","type":6,"viewCount":679},{"author":"淡漠悠然","body":"Jackson 2.8.7 发布了。Jackson 是一个 Java 用来处理 JSON 格式数据的类库。 主要更新内容： #349: CharsToNameCanonicalizer performance bottl...","commentCount":3,"href":"https://www.oschina.net/news/82132/jackson-2-8-7","id":82132,"pubDate":"2017-02-21 10:11:39","recommend":false,"title":"Jackson 2.8.7 发布，高性能 JSON 处理","type":6,"viewCount":1198},{"author":"Liuzh_533","body":"MyBatis 通用 Mapper 极其方便的使用MyBatis单表的增删改查，支持单表操作，不支持通用的多表联合查询。通用 Mapper 可以极大的方便开发人员。可以...","commentCount":6,"href":"https://www.oschina.net/news/82131/mybatis-mapper-starter-3-4-0","id":82131,"pubDate":"2017-02-21 09:51:42","recommend":false,"title":"Mybatis 通用 Mapper 3.4.0 发布","type":6,"viewCount":1416},{"author":"淡漠悠然","body":"Hibernate 5.2.8 发布了。 Hibernate 是一种 Java 语言下的对象关系映射解决方案。 它是使用 GNU 宽通用公共许可证发行的自由、开源的软件。它为面...","commentCount":7,"href":"https://www.oschina.net/news/82130/hibernate-5-2-8","id":82130,"pubDate":"2017-02-21 09:43:16","recommend":false,"title":"Hibernate 5.2.8 发布，数据持久层框架","type":6,"viewCount":762},{"author":"局长","body":"Percona Monitoring and Management 1.1.1 发布了，这是 PMM 1.1 系列中的第一个 GA 版本，重点是为 PMM 服务器提供备用部署选项。 文档中安装 Pe...","commentCount":0,"href":"https://www.oschina.net/news/82129/percona-monitoring-and-management-1-1-1-now-available","id":82129,"pubDate":"2017-02-21 08:38:48","recommend":false,"title":"Percona Monitoring and Management 1.1.1 发布","type":6,"viewCount":597},{"author":"达尔文","body":"2月25日-26日，源创会将率先奔赴至厦门和福州，依旧秉持着开放、自由、分享的开源精神，给各位 OSCer 奉上精彩的演讲主题。同时，【圆桌讨论】和【...","commentCount":1,"href":"https://www.oschina.net/news/81873/2017-february-yuanchuanghui","id":82128,"pubDate":"2017-02-21 08:28:55","recommend":false,"title":"25-26 日厦门福州源创会，报名倒计时 4 天","type":0,"viewCount":48},{"author":"达尔文","body":"JavaScript 框架和库可以说是开源项目中最庞大也是最累的类目了，目前在github 上这一类的项目是最多的，并且几乎每隔一段时间就会出现一个新的项目...","commentCount":15,"href":"https://my.oschina.net/editorial-story/blog/842340","id":842340,"pubDate":"2017-02-21 08:28:48","recommend":false,"title":"前端必备，十大热门的 JavaScript 框架和库","type":3,"viewCount":3938},{"author":"达尔文","body":"这篇文在主要是介绍，如何在 Controller 的方法里面，让校验注解 ( @NotNull @Email @Size...等)，对基本类型的数据生效（基本类型 Integer,Str...","commentCount":19,"href":"https://my.oschina.net/diamondfsd/blog/840504","id":840504,"pubDate":"2017-02-21 08:28:32","recommend":false,"title":"每日一博 | Spring MVC 通过切面实现注解式数据校验","type":3,"viewCount":2741},{"author":"局长","body":"Percona Toolkit 3.0.1 发布了，这是 3.0 系列中的首个 GA 版本，重点是填充 MongoDB 工具： pt-mongodb-summary pt-mongodb-query-digest 更新如下...","commentCount":0,"href":"https://www.oschina.net/news/82125/percona-toolkit-3-0-1-now-available","id":82125,"pubDate":"2017-02-21 08:22:03","recommend":false,"title":"Percona Toolkit 3.0.1 发布，MySQL 管理工具包","type":6,"viewCount":723},{"author":"局长","body":"Percona Server for MongoDB 3.4.2-1.2 发布了，它是 3.4 系列中的第一个 GA 版本。 更新如下： 修复了审核日志消息格式以与上游 MongoDB 相符合：...","commentCount":0,"href":"https://www.oschina.net/news/82124/percona-server-for-mongodb-3-4-2-1-2-now-available","id":82124,"pubDate":"2017-02-21 08:15:18","recommend":false,"title":"Percona Server for MongoDB 3.4.2-1.2 发布","type":6,"viewCount":345},{"author":"达尔文","body":"我喜欢在 Ubuntu 上使用 KDE Connect 和应用程序的 indicator applet 连接。这是将 Android 手机连接到 Linux 桌面的最简单的方法。...","commentCount":8,"href":"https://www.oschina.net/translate/easy-way-connect-android-to-ubuntu-pc","id":10003749,"pubDate":"2017-02-21 08:05:24","recommend":false,"title":"翻译 | 我喜欢在 Ubuntu 上使用 KDE Connect 的6个理由","type":4,"viewCount":1595},{"author":"局长","body":"Black Lab Linux 8.1 发布了，新版本基于 Ubuntu 16.04 LTS，并带来了 LibreOffice 5.3，Mozilla Thunderbird 45.7 和 Chromium 56。 在此版本中，...","commentCount":0,"href":"https://www.oschina.net/news/82122/black-lab-linux-8-1-out-now","id":82122,"pubDate":"2017-02-21 08:04:38","recommend":false,"title":"Black Lab Linux 8.1，基于 Ubuntu 16.04 LTS","type":6,"viewCount":630},{"author":"达尔文","body":"公司男同事在注孤生的证据墙上又添一笔：带了三个鸡腿，四个美女问他要，他为了以示公平，自己把三个鸡腿都吃了。  ","commentCount":41,"href":"https://my.oschina.net/xxiaobian/blog/842503","id":842503,"pubDate":"2017-02-21 08:01:13","recommend":false,"title":"OSChina 周二乱弹 \u2014\u2014 巴叔别怕，我来保护你。","type":3,"viewCount":3134}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":75486}
     * time : 2017-02-21 20:06:51
     */

    private int code;
    private String message;
    /**
     * items : [{"author":"淡漠悠然","body":"Apache RocketMQ 4.0.0 (INCUBATING) 发布了。 更新内容： Bug [ROCKETMQ-2] - 代理测试失败，显示\u201c地址已在使用\u201d [ROCKETMQ-5] - 无法在UtilAll...","commentCount":2,"href":"https://www.oschina.net/news/82146/apache-rocketmq-4-0-0","id":82146,"pubDate":"2017-02-21 18:53:05","recommend":true,"title":"Apache RocketMQ 4.0.0 (INCUBATING) 发布","type":6,"viewCount":45},{"author":"贤心","body":"似乎已经太久没有更新的样子（差不多两个月吧），时间就这样悄悄偷走了我们往日的热情、磨灭了一丝丝执念。但总有人仍然深爱着她对么（怎么听着怪怪...","commentCount":18,"href":"https://www.oschina.net/news/82144/layui-1-0-8","id":82144,"pubDate":"2017-02-21 16:00:55","recommend":true,"title":"layui 1.0.8 发布，传统模块化前端 UI 框架","type":6,"viewCount":624},{"author":"88250","body":"这个版本主要是改进了评论模版机制，让大家更方便皮肤制作，并发布了一款新皮肤：9IPHP。 Solo 是一款一个命令就能搭建好的 Java 开源博客系统，并...","commentCount":28,"href":"https://www.oschina.net/news/82143/solo-1-9-0","id":82143,"pubDate":"2017-02-21 15:42:17","recommend":true,"title":"Java 开源博客 Solo 1.9.0 发布 - 新皮肤","type":6,"viewCount":972},{"author":"葛俊","body":"MyBatisCodeHelper 1.3 发布了。MyBatisCodeHelper 是一款 Intellij 下的插件，通过 java 对象来生成建表 sql，mybatis curd 代码， 提供 mybatis ...","commentCount":3,"href":"https://www.oschina.net/news/82140/mybatiscodehelper-1-3","id":82140,"pubDate":"2017-02-21 14:56:52","recommend":true,"title":"MyBatisCodeHelper 1.3 发布","type":6,"viewCount":573},{"author":"局长","body":"卡巴斯基今天跳出老本行，发布了名为 Kaspersky OS 的操作系统，主要使用对象为网络设备、工业控制系统和物联网设备。 据卡巴斯基 CEO Eugene Kas...","commentCount":15,"href":"https://www.oschina.net/news/82138/kaspersky-os-first-released","id":82138,"pubDate":"2017-02-21 14:21:09","recommend":true,"title":"卡巴斯基首款操作系统Kaspersky OS发布 兼容 x86/ARM","type":6,"viewCount":1701},{"author":"lyunweb","body":"一、简介 lyadmin是一套轻量级通用后台，采用Bootstrap3制作，自带权限管理，模块化开发。 二、更新 修复安装sql及公共函数问题 新增docs 更新REA...","commentCount":0,"href":"https://www.oschina.net/news/82137/lyadmin-1-1-1","id":82137,"pubDate":"2017-02-21 12:15:37","recommend":false,"title":"lyadmin 1.1.1 正式版发布，开源通用后台","type":6,"viewCount":1207},{"author":"局长","body":"在每年的 I/O 大会上，谷歌通常会发布新系统和新产品。 就在去年的 I/O 大会，谷歌发布了新一代安卓 7.0 牛轧糖系统。但这一最新系统的装机率却长时...","commentCount":40,"href":"https://www.oschina.net/news/82136/android-8-0-at-hand-may-be-called-the-oreo","id":82136,"pubDate":"2017-02-21 11:46:01","recommend":false,"title":"安卓 8.0 系统就要到来 代号或是奥利奥？","type":6,"viewCount":2331},{"author":"局长","body":"Docker v17.03.0-ce-rc1 发布了，其 GitHub 主页显示将于 2017-03-01 发布 17.03.0-ce。本次更新内容如下： Client Fix panic in docker stats --...","commentCount":8,"href":"https://www.oschina.net/news/82135/docker-17-03-0-ce-rc1","id":82135,"pubDate":"2017-02-21 11:22:03","recommend":false,"title":"Docker v17.03.0-ce-rc1 发布，应用容器引擎","type":6,"viewCount":679},{"author":"淡漠悠然","body":"Jackson 2.8.7 发布了。Jackson 是一个 Java 用来处理 JSON 格式数据的类库。 主要更新内容： #349: CharsToNameCanonicalizer performance bottl...","commentCount":3,"href":"https://www.oschina.net/news/82132/jackson-2-8-7","id":82132,"pubDate":"2017-02-21 10:11:39","recommend":false,"title":"Jackson 2.8.7 发布，高性能 JSON 处理","type":6,"viewCount":1198},{"author":"Liuzh_533","body":"MyBatis 通用 Mapper 极其方便的使用MyBatis单表的增删改查，支持单表操作，不支持通用的多表联合查询。通用 Mapper 可以极大的方便开发人员。可以...","commentCount":6,"href":"https://www.oschina.net/news/82131/mybatis-mapper-starter-3-4-0","id":82131,"pubDate":"2017-02-21 09:51:42","recommend":false,"title":"Mybatis 通用 Mapper 3.4.0 发布","type":6,"viewCount":1416},{"author":"淡漠悠然","body":"Hibernate 5.2.8 发布了。 Hibernate 是一种 Java 语言下的对象关系映射解决方案。 它是使用 GNU 宽通用公共许可证发行的自由、开源的软件。它为面...","commentCount":7,"href":"https://www.oschina.net/news/82130/hibernate-5-2-8","id":82130,"pubDate":"2017-02-21 09:43:16","recommend":false,"title":"Hibernate 5.2.8 发布，数据持久层框架","type":6,"viewCount":762},{"author":"局长","body":"Percona Monitoring and Management 1.1.1 发布了，这是 PMM 1.1 系列中的第一个 GA 版本，重点是为 PMM 服务器提供备用部署选项。 文档中安装 Pe...","commentCount":0,"href":"https://www.oschina.net/news/82129/percona-monitoring-and-management-1-1-1-now-available","id":82129,"pubDate":"2017-02-21 08:38:48","recommend":false,"title":"Percona Monitoring and Management 1.1.1 发布","type":6,"viewCount":597},{"author":"达尔文","body":"2月25日-26日，源创会将率先奔赴至厦门和福州，依旧秉持着开放、自由、分享的开源精神，给各位 OSCer 奉上精彩的演讲主题。同时，【圆桌讨论】和【...","commentCount":1,"href":"https://www.oschina.net/news/81873/2017-february-yuanchuanghui","id":82128,"pubDate":"2017-02-21 08:28:55","recommend":false,"title":"25-26 日厦门福州源创会，报名倒计时 4 天","type":0,"viewCount":48},{"author":"达尔文","body":"JavaScript 框架和库可以说是开源项目中最庞大也是最累的类目了，目前在github 上这一类的项目是最多的，并且几乎每隔一段时间就会出现一个新的项目...","commentCount":15,"href":"https://my.oschina.net/editorial-story/blog/842340","id":842340,"pubDate":"2017-02-21 08:28:48","recommend":false,"title":"前端必备，十大热门的 JavaScript 框架和库","type":3,"viewCount":3938},{"author":"达尔文","body":"这篇文在主要是介绍，如何在 Controller 的方法里面，让校验注解 ( @NotNull @Email @Size...等)，对基本类型的数据生效（基本类型 Integer,Str...","commentCount":19,"href":"https://my.oschina.net/diamondfsd/blog/840504","id":840504,"pubDate":"2017-02-21 08:28:32","recommend":false,"title":"每日一博 | Spring MVC 通过切面实现注解式数据校验","type":3,"viewCount":2741},{"author":"局长","body":"Percona Toolkit 3.0.1 发布了，这是 3.0 系列中的首个 GA 版本，重点是填充 MongoDB 工具： pt-mongodb-summary pt-mongodb-query-digest 更新如下...","commentCount":0,"href":"https://www.oschina.net/news/82125/percona-toolkit-3-0-1-now-available","id":82125,"pubDate":"2017-02-21 08:22:03","recommend":false,"title":"Percona Toolkit 3.0.1 发布，MySQL 管理工具包","type":6,"viewCount":723},{"author":"局长","body":"Percona Server for MongoDB 3.4.2-1.2 发布了，它是 3.4 系列中的第一个 GA 版本。 更新如下： 修复了审核日志消息格式以与上游 MongoDB 相符合：...","commentCount":0,"href":"https://www.oschina.net/news/82124/percona-server-for-mongodb-3-4-2-1-2-now-available","id":82124,"pubDate":"2017-02-21 08:15:18","recommend":false,"title":"Percona Server for MongoDB 3.4.2-1.2 发布","type":6,"viewCount":345},{"author":"达尔文","body":"我喜欢在 Ubuntu 上使用 KDE Connect 和应用程序的 indicator applet 连接。这是将 Android 手机连接到 Linux 桌面的最简单的方法。...","commentCount":8,"href":"https://www.oschina.net/translate/easy-way-connect-android-to-ubuntu-pc","id":10003749,"pubDate":"2017-02-21 08:05:24","recommend":false,"title":"翻译 | 我喜欢在 Ubuntu 上使用 KDE Connect 的6个理由","type":4,"viewCount":1595},{"author":"局长","body":"Black Lab Linux 8.1 发布了，新版本基于 Ubuntu 16.04 LTS，并带来了 LibreOffice 5.3，Mozilla Thunderbird 45.7 和 Chromium 56。 在此版本中，...","commentCount":0,"href":"https://www.oschina.net/news/82122/black-lab-linux-8-1-out-now","id":82122,"pubDate":"2017-02-21 08:04:38","recommend":false,"title":"Black Lab Linux 8.1，基于 Ubuntu 16.04 LTS","type":6,"viewCount":630},{"author":"达尔文","body":"公司男同事在注孤生的证据墙上又添一笔：带了三个鸡腿，四个美女问他要，他为了以示公平，自己把三个鸡腿都吃了。  ","commentCount":41,"href":"https://my.oschina.net/xxiaobian/blog/842503","id":842503,"pubDate":"2017-02-21 08:01:13","recommend":false,"title":"OSChina 周二乱弹 \u2014\u2014 巴叔别怕，我来保护你。","type":3,"viewCount":3134}]
     * nextPageToken : DBA816934CD0AA59
     * prevPageToken : 0997C855C600E421
     * requestCount : 20
     * responseCount : 20
     * totalResults : 75486
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
        private String nextPageToken;
        private String prevPageToken;
        private int    requestCount;
        private int    responseCount;
        private int    totalResults;
        /**
         * author : 淡漠悠然
         * body : Apache RocketMQ 4.0.0 (INCUBATING) 发布了。 更新内容： Bug [ROCKETMQ-2] - 代理测试失败，显示“地址已在使用” [ROCKETMQ-5] - 无法在UtilAll...
         * commentCount : 2
         * href : https://www.oschina.net/news/82146/apache-rocketmq-4-0-0
         * id : 82146
         * pubDate : 2017-02-21 18:53:05
         * recommend : true
         * title : Apache RocketMQ 4.0.0 (INCUBATING) 发布
         * type : 6
         * viewCount : 45
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
            private String  author;
            private String  body;
            private int     commentCount;
            private String  href;
            private int     id;
            private String  pubDate;
            private boolean recommend;
            private String  title;
            private int     type;
            private int     viewCount;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
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

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }
        }
    }
}
