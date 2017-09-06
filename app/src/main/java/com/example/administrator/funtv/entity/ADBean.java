package com.example.administrator.funtv.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 */

public class ADBean {

    private List<AndroidstartBean> androidstart;
    @SerializedName("ios-start")
    private List<IosstartBean> iosstart;
    @SerializedName("app-focus")
    private List<AppfocusBean> appfocus;
    private List<AppFocusCheckBean> appFocusCheck;
    @SerializedName("ios-focus")
    private List<IosfocusBean> iosfocus;
    @SerializedName("ipad-start")
    private List<?> ipadstart;
    @SerializedName("ios-start-test")
    private List<IosstarttestBean> iosstarttest;
    @SerializedName("ios-focus-test")
    private List<IosfocustestBean> iosfocustest;

    public List<AndroidstartBean> getAndroidstart() {
        return androidstart;
    }

    public void setAndroidstart(List<AndroidstartBean> androidstart) {
        this.androidstart = androidstart;
    }

    public List<IosstartBean> getIosstart() {
        return iosstart;
    }

    public void setIosstart(List<IosstartBean> iosstart) {
        this.iosstart = iosstart;
    }

    public List<AppfocusBean> getAppfocus() {
        return appfocus;
    }

    public void setAppfocus(List<AppfocusBean> appfocus) {
        this.appfocus = appfocus;
    }

    public List<AppFocusCheckBean> getAppFocusCheck() {
        return appFocusCheck;
    }

    public void setAppFocusCheck(List<AppFocusCheckBean> appFocusCheck) {
        this.appFocusCheck = appFocusCheck;
    }

    public List<IosfocusBean> getIosfocus() {
        return iosfocus;
    }

    public void setIosfocus(List<IosfocusBean> iosfocus) {
        this.iosfocus = iosfocus;
    }

    public List<?> getIpadstart() {
        return ipadstart;
    }

    public void setIpadstart(List<?> ipadstart) {
        this.ipadstart = ipadstart;
    }

    public List<IosstarttestBean> getIosstarttest() {
        return iosstarttest;
    }

    public void setIosstarttest(List<IosstarttestBean> iosstarttest) {
        this.iosstarttest = iosstarttest;
    }

    public List<IosfocustestBean> getIosfocustest() {
        return iosfocustest;
    }

    public void setIosfocustest(List<IosfocustestBean> iosfocustest) {
        this.iosfocustest = iosfocustest;
    }

    public static class AndroidstartBean {
        /**
         * id : 733
         * title : 2017年LPL春季赛
         * thumb : http://image.quanmin.tv/fac91cad2b69ebddfefe83768d2e9309jpg
         * link : quanmin://mobile.app/liveroom?live=44397
         * create_at : 2016-05-03 22:05:25
         * status : 1
         * fk :
         * subtitle :
         * content :
         * ext : {"type":"app","time":"3","start_time":1475791200,"end_time":1488470400}
         * slot_id : 111
         * priority : 4
         */

        private int id;
        private String title;
        private String thumb;
        private String link;
        private String create_at;
        private int status;
        private String fk;
        private String subtitle;
        private String content;
        private ExtBean ext;
        private int slot_id;
        private int priority;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFk() {
            return fk;
        }

        public void setFk(String fk) {
            this.fk = fk;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExtBean getExt() {
            return ext;
        }

        public void setExt(ExtBean ext) {
            this.ext = ext;
        }

        public int getSlot_id() {
            return slot_id;
        }

        public void setSlot_id(int slot_id) {
            this.slot_id = slot_id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public static class ExtBean {
            /**
             * type : app
             * time : 3
             * start_time : 1475791200
             * end_time : 1488470400
             */

            private String type;
            private String time;
            private int start_time;
            private int end_time;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getStart_time() {
                return start_time;
            }

            public void setStart_time(int start_time) {
                this.start_time = start_time;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }
        }
    }

    public static class IosstartBean {
        /**
         * id : 531
         * title : 2017年LPL春季赛
         * thumb : http://image.quanmin.tv/6836be2de957b56a4d6f2c4732361772jpg
         * link : quanmin://mobile.app/liveroom?live=44397
         * create_at : 2016-04-12 12:55:42
         * status : 1
         * fk :
         * subtitle :
         * content :
         * ext : {"type":"app","time":"3","start_time":1475791200,"end_time":1488470400}
         * slot_id : 112
         * priority : 0
         */

        private int id;
        private String title;
        private String thumb;
        private String link;
        private String create_at;
        private int status;
        private String fk;
        private String subtitle;
        private String content;
        private ExtBeanX ext;
        private int slot_id;
        private int priority;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFk() {
            return fk;
        }

        public void setFk(String fk) {
            this.fk = fk;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExtBeanX getExt() {
            return ext;
        }

        public void setExt(ExtBeanX ext) {
            this.ext = ext;
        }

        public int getSlot_id() {
            return slot_id;
        }

        public void setSlot_id(int slot_id) {
            this.slot_id = slot_id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public static class ExtBeanX {
            /**
             * type : app
             * time : 3
             * start_time : 1475791200
             * end_time : 1488470400
             */

            private String type;
            private String time;
            private int start_time;
            private int end_time;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getStart_time() {
                return start_time;
            }

            public void setStart_time(int start_time) {
                this.start_time = start_time;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }
        }
    }

    public static class AppfocusBean {
        /**
         * id : 618
         * title : 情人节
         * thumb : http://image.quanmin.tv/3f10d16271c227fc4fc36e7c6f501f4ajpg
         * link : www.quanmin.tv/static/v2/boot/love/love.html
         * create_at : 2016-04-29 12:43:26
         * status : 1
         * fk :
         * subtitle :
         * content :
         * ext : {"type":"ad"}
         * slot_id : 113
         * priority : 3
         * link_object : {"no":"3007930","nick":"_雪妍_","avatar":"http://image.quanmin.tv/avatar/0d6c87b878d8d0b5c007fd2d7c6eacfcjpg?imageView2/2/w/300/","follow":"184903","id":"98973","uid":"3007930","title":"【雪妍直播间】感谢柳州水友的身份证","category_id":"3","slug":"snowkiss","intro":"辣鸡村村花之天籁之音 - 雪妍，最爱吃钵钵鸡。","announcement":"上午11点到下午4点","cover":"3007930-1486972468-89.jpg","play_at":"2017-02-13 11:39:50","last_play_at":"","view":"93111","views":"0","status":"2","priv":"0","landscape":"1","position":"","weight":"0","check":"1","recommend_image":"http://image.quanmin.tv/63efd411f8d576eb0ee3512f828a0901jpg","videoQuality":"234","category_name":"炉石传说","screen":0,"start_time":"1486957190.603","source":"ws","thumb":"http://image.quanmin.tv/7df1a732fece3bcba13163d69a5021ecjpg","video":"http://thumb.quanmin.tv/3007930.mp4?t=1486972200","stream":"http://flv.quanmin.tv/live/3007930_L3.flv","app_shuffling_image":"http://image.quanmin.tv/0fdc3ceb2caa6a4b2863a2fc859c5164jpg","categoryId":"3","hidden":false,"play_status":true}
         */

        private int id;
        private String title;
        private String thumb;
        private String link;
        private String create_at;
        private int status;
        private String fk;
        private String subtitle;
        private String content;
        private ExtBeanXX ext;
        private int slot_id;
        private int priority;
        private LinkObjectBean link_object;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFk() {
            return fk;
        }

        public void setFk(String fk) {
            this.fk = fk;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExtBeanXX getExt() {
            return ext;
        }

        public void setExt(ExtBeanXX ext) {
            this.ext = ext;
        }

        public int getSlot_id() {
            return slot_id;
        }

        public void setSlot_id(int slot_id) {
            this.slot_id = slot_id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public LinkObjectBean getLink_object() {
            return link_object;
        }

        public void setLink_object(LinkObjectBean link_object) {
            this.link_object = link_object;
        }

        public static class ExtBeanXX {
            /**
             * type : ad
             */

            private String type;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class LinkObjectBean {
            /**
             * no : 3007930
             * nick : _雪妍_
             * avatar : http://image.quanmin.tv/avatar/0d6c87b878d8d0b5c007fd2d7c6eacfcjpg?imageView2/2/w/300/
             * follow : 184903
             * id : 98973
             * uid : 3007930
             * title : 【雪妍直播间】感谢柳州水友的身份证
             * category_id : 3
             * slug : snowkiss
             * intro : 辣鸡村村花之天籁之音 - 雪妍，最爱吃钵钵鸡。
             * announcement : 上午11点到下午4点
             * cover : 3007930-1486972468-89.jpg
             * play_at : 2017-02-13 11:39:50
             * last_play_at :
             * view : 93111
             * views : 0
             * status : 2
             * priv : 0
             * landscape : 1
             * position :
             * weight : 0
             * check : 1
             * recommend_image : http://image.quanmin.tv/63efd411f8d576eb0ee3512f828a0901jpg
             * videoQuality : 234
             * category_name : 炉石传说
             * screen : 0
             * start_time : 1486957190.603
             * source : ws
             * thumb : http://image.quanmin.tv/7df1a732fece3bcba13163d69a5021ecjpg
             * video : http://thumb.quanmin.tv/3007930.mp4?t=1486972200
             * stream : http://flv.quanmin.tv/live/3007930_L3.flv
             * app_shuffling_image : http://image.quanmin.tv/0fdc3ceb2caa6a4b2863a2fc859c5164jpg
             * categoryId : 3
             * hidden : false
             * play_status : true
             */

            private String no;
            private String nick;
            private String avatar;
            private String follow;
            private String id;
            private String uid;
            private String title;
            private String category_id;
            private String slug;
            private String intro;
            private String announcement;
            private String cover;
            private String play_at;
            private String last_play_at;
            private String view;
            private String views;
            private String status;
            private String priv;
            private String landscape;
            private String position;
            private String weight;
            private String check;
            private String recommend_image;
            private String videoQuality;
            private String category_name;
            private int screen;
            private String start_time;
            private String source;
            private String thumb;
            private String video;
            private String stream;
            private String app_shuffling_image;
            private String categoryId;
            private boolean hidden;
            private boolean play_status;

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getPlay_at() {
                return play_at;
            }

            public void setPlay_at(String play_at) {
                this.play_at = play_at;
            }

            public String getLast_play_at() {
                return last_play_at;
            }

            public void setLast_play_at(String last_play_at) {
                this.last_play_at = last_play_at;
            }

            public String getView() {
                return view;
            }

            public void setView(String view) {
                this.view = view;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPriv() {
                return priv;
            }

            public void setPriv(String priv) {
                this.priv = priv;
            }

            public String getLandscape() {
                return landscape;
            }

            public void setLandscape(String landscape) {
                this.landscape = landscape;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getCheck() {
                return check;
            }

            public void setCheck(String check) {
                this.check = check;
            }

            public String getRecommend_image() {
                return recommend_image;
            }

            public void setRecommend_image(String recommend_image) {
                this.recommend_image = recommend_image;
            }

            public String getVideoQuality() {
                return videoQuality;
            }

            public void setVideoQuality(String videoQuality) {
                this.videoQuality = videoQuality;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public int getScreen() {
                return screen;
            }

            public void setScreen(int screen) {
                this.screen = screen;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getStream() {
                return stream;
            }

            public void setStream(String stream) {
                this.stream = stream;
            }

            public String getApp_shuffling_image() {
                return app_shuffling_image;
            }

            public void setApp_shuffling_image(String app_shuffling_image) {
                this.app_shuffling_image = app_shuffling_image;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public boolean isHidden() {
                return hidden;
            }

            public void setHidden(boolean hidden) {
                this.hidden = hidden;
            }

            public boolean isPlay_status() {
                return play_status;
            }

            public void setPlay_status(boolean play_status) {
                this.play_status = play_status;
            }
        }
    }

    public static class AppFocusCheckBean {
        /**
         * id : 621
         * title : 2016赛季LSPL夏季赛
         * thumb : http://image.quanmin.tv/aeee5525061499f449348654e76388bejpg
         * link :
         * create_at : 2016-04-29 16:35:02
         * status : 1
         * fk : 674228
         * subtitle :
         * content :
         * ext : {"type":"play"}
         * slot_id : 153
         * priority : 0
         * link_object : {"no":"674228","nick":"LSPL官方频道","avatar":"http://image.quanmin.tv/avatar/530d6327b39ebc3465476c750a2a7214jpg?imageView2/2/w/300/","follow":"360087","id":"14042","uid":"674228","title":"LSPL春季赛重播","category_id":"1","slug":"lspl","intro":"","announcement":"","cover":"674228-1486972443-893.jpg","play_at":"2017-02-11 23:12:12","last_play_at":"","view":"30541","views":"0","status":"2","priv":"0","landscape":"1","position":"","weight":"0","check":"1","recommend_image":"http://image.quanmin.tv/8b5b09ad48de5703910e491ead6b10a2jpg","videoQuality":"234","category_name":"英雄联盟","screen":0,"start_time":"1486971239.789","source":"ws","stream":"http://flv.quanmin.tv/live/674228_L3.flv","thumb":"http://image.quanmin.tv/aeee5525061499f449348654e76388bejpg","video":"http://thumb.quanmin.tv/674228.mp4?t=1486972200","app_shuffling_image":"http://image.quanmin.tv/0df3639786d55d5c73cb0822435aae04jpg","categoryId":"1","hidden":false,"play_status":true}
         */

        private int id;
        private String title;
        private String thumb;
        private String link;
        private String create_at;
        private int status;
        private String fk;
        private String subtitle;
        private String content;
        private ExtBeanXXX ext;
        private int slot_id;
        private int priority;
        private LinkObjectBeanX link_object;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFk() {
            return fk;
        }

        public void setFk(String fk) {
            this.fk = fk;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExtBeanXXX getExt() {
            return ext;
        }

        public void setExt(ExtBeanXXX ext) {
            this.ext = ext;
        }

        public int getSlot_id() {
            return slot_id;
        }

        public void setSlot_id(int slot_id) {
            this.slot_id = slot_id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public LinkObjectBeanX getLink_object() {
            return link_object;
        }

        public void setLink_object(LinkObjectBeanX link_object) {
            this.link_object = link_object;
        }

        public static class ExtBeanXXX {
            /**
             * type : play
             */

            private String type;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class LinkObjectBeanX {
            /**
             * no : 674228
             * nick : LSPL官方频道
             * avatar : http://image.quanmin.tv/avatar/530d6327b39ebc3465476c750a2a7214jpg?imageView2/2/w/300/
             * follow : 360087
             * id : 14042
             * uid : 674228
             * title : LSPL春季赛重播
             * category_id : 1
             * slug : lspl
             * intro :
             * announcement :
             * cover : 674228-1486972443-893.jpg
             * play_at : 2017-02-11 23:12:12
             * last_play_at :
             * view : 30541
             * views : 0
             * status : 2
             * priv : 0
             * landscape : 1
             * position :
             * weight : 0
             * check : 1
             * recommend_image : http://image.quanmin.tv/8b5b09ad48de5703910e491ead6b10a2jpg
             * videoQuality : 234
             * category_name : 英雄联盟
             * screen : 0
             * start_time : 1486971239.789
             * source : ws
             * stream : http://flv.quanmin.tv/live/674228_L3.flv
             * thumb : http://image.quanmin.tv/aeee5525061499f449348654e76388bejpg
             * video : http://thumb.quanmin.tv/674228.mp4?t=1486972200
             * app_shuffling_image : http://image.quanmin.tv/0df3639786d55d5c73cb0822435aae04jpg
             * categoryId : 1
             * hidden : false
             * play_status : true
             */

            private String no;
            private String nick;
            private String avatar;
            private String follow;
            private String id;
            private String uid;
            private String title;
            private String category_id;
            private String slug;
            private String intro;
            private String announcement;
            private String cover;
            private String play_at;
            private String last_play_at;
            private String view;
            private String views;
            private String status;
            private String priv;
            private String landscape;
            private String position;
            private String weight;
            private String check;
            private String recommend_image;
            private String videoQuality;
            private String category_name;
            private int screen;
            private String start_time;
            private String source;
            private String stream;
            private String thumb;
            private String video;
            private String app_shuffling_image;
            private String categoryId;
            private boolean hidden;
            private boolean play_status;

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getPlay_at() {
                return play_at;
            }

            public void setPlay_at(String play_at) {
                this.play_at = play_at;
            }

            public String getLast_play_at() {
                return last_play_at;
            }

            public void setLast_play_at(String last_play_at) {
                this.last_play_at = last_play_at;
            }

            public String getView() {
                return view;
            }

            public void setView(String view) {
                this.view = view;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPriv() {
                return priv;
            }

            public void setPriv(String priv) {
                this.priv = priv;
            }

            public String getLandscape() {
                return landscape;
            }

            public void setLandscape(String landscape) {
                this.landscape = landscape;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getCheck() {
                return check;
            }

            public void setCheck(String check) {
                this.check = check;
            }

            public String getRecommend_image() {
                return recommend_image;
            }

            public void setRecommend_image(String recommend_image) {
                this.recommend_image = recommend_image;
            }

            public String getVideoQuality() {
                return videoQuality;
            }

            public void setVideoQuality(String videoQuality) {
                this.videoQuality = videoQuality;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public int getScreen() {
                return screen;
            }

            public void setScreen(int screen) {
                this.screen = screen;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getStream() {
                return stream;
            }

            public void setStream(String stream) {
                this.stream = stream;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getApp_shuffling_image() {
                return app_shuffling_image;
            }

            public void setApp_shuffling_image(String app_shuffling_image) {
                this.app_shuffling_image = app_shuffling_image;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public boolean isHidden() {
                return hidden;
            }

            public void setHidden(boolean hidden) {
                this.hidden = hidden;
            }

            public boolean isPlay_status() {
                return play_status;
            }

            public void setPlay_status(boolean play_status) {
                this.play_status = play_status;
            }
        }
    }

    public static class IosfocusBean {
        /**
         * id : 1139
         * title : 情人节
         * thumb : http://image.quanmin.tv/92e3bef0bd1771cf2223d243774a3c28jpg
         * link : www.quanmin.tv/static/v2/boot/love/love.html
         * create_at : 2016-06-16 17:03:51
         * status : 1
         * fk :
         * subtitle :
         * content :
         * ext : {"type":"ad"}
         * slot_id : 165
         * priority : 5
         * link_object : {"no":"3007930","nick":"_雪妍_","avatar":"http://image.quanmin.tv/avatar/0d6c87b878d8d0b5c007fd2d7c6eacfcjpg?imageView2/2/w/300/","follow":"184903","id":"98973","uid":"3007930","title":"【雪妍直播间】感谢柳州水友的身份证","category_id":"3","slug":"snowkiss","intro":"辣鸡村村花之天籁之音 - 雪妍，最爱吃钵钵鸡。","announcement":"上午11点到下午4点","cover":"3007930-1486972468-89.jpg","play_at":"2017-02-13 11:39:50","last_play_at":"","view":"93111","views":"0","status":"2","priv":"0","landscape":"1","position":"","weight":"0","check":"1","recommend_image":"http://image.quanmin.tv/63efd411f8d576eb0ee3512f828a0901jpg","videoQuality":"234","category_name":"炉石传说","screen":0,"start_time":"1486957190.603","source":"ws","thumb":"http://image.quanmin.tv/677617ef1ff3c449da5f316bed7933c2jpg","video":"http://thumb.quanmin.tv/3007930.mp4?t=1486972200","stream":"http://flv.quanmin.tv/live/3007930_L3.flv","app_shuffling_image":"http://image.quanmin.tv/0fdc3ceb2caa6a4b2863a2fc859c5164jpg","categoryId":"3","hidden":false,"play_status":true}
         */

        private int id;
        private String title;
        private String thumb;
        private String link;
        private String create_at;
        private int status;
        private String fk;
        private String subtitle;
        private String content;
        private ExtBeanXXXX ext;
        private int slot_id;
        private int priority;
        private LinkObjectBeanXX link_object;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFk() {
            return fk;
        }

        public void setFk(String fk) {
            this.fk = fk;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExtBeanXXXX getExt() {
            return ext;
        }

        public void setExt(ExtBeanXXXX ext) {
            this.ext = ext;
        }

        public int getSlot_id() {
            return slot_id;
        }

        public void setSlot_id(int slot_id) {
            this.slot_id = slot_id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public LinkObjectBeanXX getLink_object() {
            return link_object;
        }

        public void setLink_object(LinkObjectBeanXX link_object) {
            this.link_object = link_object;
        }

        public static class ExtBeanXXXX {
            /**
             * type : ad
             */

            private String type;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class LinkObjectBeanXX {
            /**
             * no : 3007930
             * nick : _雪妍_
             * avatar : http://image.quanmin.tv/avatar/0d6c87b878d8d0b5c007fd2d7c6eacfcjpg?imageView2/2/w/300/
             * follow : 184903
             * id : 98973
             * uid : 3007930
             * title : 【雪妍直播间】感谢柳州水友的身份证
             * category_id : 3
             * slug : snowkiss
             * intro : 辣鸡村村花之天籁之音 - 雪妍，最爱吃钵钵鸡。
             * announcement : 上午11点到下午4点
             * cover : 3007930-1486972468-89.jpg
             * play_at : 2017-02-13 11:39:50
             * last_play_at :
             * view : 93111
             * views : 0
             * status : 2
             * priv : 0
             * landscape : 1
             * position :
             * weight : 0
             * check : 1
             * recommend_image : http://image.quanmin.tv/63efd411f8d576eb0ee3512f828a0901jpg
             * videoQuality : 234
             * category_name : 炉石传说
             * screen : 0
             * start_time : 1486957190.603
             * source : ws
             * thumb : http://image.quanmin.tv/677617ef1ff3c449da5f316bed7933c2jpg
             * video : http://thumb.quanmin.tv/3007930.mp4?t=1486972200
             * stream : http://flv.quanmin.tv/live/3007930_L3.flv
             * app_shuffling_image : http://image.quanmin.tv/0fdc3ceb2caa6a4b2863a2fc859c5164jpg
             * categoryId : 3
             * hidden : false
             * play_status : true
             */

            private String no;
            private String nick;
            private String avatar;
            private String follow;
            private String id;
            private String uid;
            private String title;
            private String category_id;
            private String slug;
            private String intro;
            private String announcement;
            private String cover;
            private String play_at;
            private String last_play_at;
            private String view;
            private String views;
            private String status;
            private String priv;
            private String landscape;
            private String position;
            private String weight;
            private String check;
            private String recommend_image;
            private String videoQuality;
            private String category_name;
            private int screen;
            private String start_time;
            private String source;
            private String thumb;
            private String video;
            private String stream;
            private String app_shuffling_image;
            private String categoryId;
            private boolean hidden;
            private boolean play_status;

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getPlay_at() {
                return play_at;
            }

            public void setPlay_at(String play_at) {
                this.play_at = play_at;
            }

            public String getLast_play_at() {
                return last_play_at;
            }

            public void setLast_play_at(String last_play_at) {
                this.last_play_at = last_play_at;
            }

            public String getView() {
                return view;
            }

            public void setView(String view) {
                this.view = view;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPriv() {
                return priv;
            }

            public void setPriv(String priv) {
                this.priv = priv;
            }

            public String getLandscape() {
                return landscape;
            }

            public void setLandscape(String landscape) {
                this.landscape = landscape;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getCheck() {
                return check;
            }

            public void setCheck(String check) {
                this.check = check;
            }

            public String getRecommend_image() {
                return recommend_image;
            }

            public void setRecommend_image(String recommend_image) {
                this.recommend_image = recommend_image;
            }

            public String getVideoQuality() {
                return videoQuality;
            }

            public void setVideoQuality(String videoQuality) {
                this.videoQuality = videoQuality;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public int getScreen() {
                return screen;
            }

            public void setScreen(int screen) {
                this.screen = screen;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getStream() {
                return stream;
            }

            public void setStream(String stream) {
                this.stream = stream;
            }

            public String getApp_shuffling_image() {
                return app_shuffling_image;
            }

            public void setApp_shuffling_image(String app_shuffling_image) {
                this.app_shuffling_image = app_shuffling_image;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public boolean isHidden() {
                return hidden;
            }

            public void setHidden(boolean hidden) {
                this.hidden = hidden;
            }

            public boolean isPlay_status() {
                return play_status;
            }

            public void setPlay_status(boolean play_status) {
                this.play_status = play_status;
            }
        }
    }

    public static class IosstarttestBean {
        /**
         * id : 1572
         * title : 和TA私奔到月亮
         * thumb : http://image.quanmin.tv/a082375762e8e7081237261ae4477d0bjpg
         * link : http://m.quanmin.tv/static/v2/m/boot/special/qmsd/join.html?a=123
         * create_at : 2016-09-12 18:49:40
         * status : 1
         * fk :
         * subtitle :
         * content :
         * ext : {"type":"html","time":"10","start_time":1479263065,"end_time":1480521600}
         * slot_id : 236
         * priority : 0
         */

        private int id;
        private String title;
        private String thumb;
        private String link;
        private String create_at;
        private int status;
        private String fk;
        private String subtitle;
        private String content;
        private ExtBeanXXXXX ext;
        private int slot_id;
        private int priority;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFk() {
            return fk;
        }

        public void setFk(String fk) {
            this.fk = fk;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExtBeanXXXXX getExt() {
            return ext;
        }

        public void setExt(ExtBeanXXXXX ext) {
            this.ext = ext;
        }

        public int getSlot_id() {
            return slot_id;
        }

        public void setSlot_id(int slot_id) {
            this.slot_id = slot_id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public static class ExtBeanXXXXX {
            /**
             * type : html
             * time : 10
             * start_time : 1479263065
             * end_time : 1480521600
             */

            private String type;
            private String time;
            private int start_time;
            private int end_time;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getStart_time() {
                return start_time;
            }

            public void setStart_time(int start_time) {
                this.start_time = start_time;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }
        }
    }

    public static class IosfocustestBean {
        /**
         * id : 1549
         * title : 国服第一诺克
         * thumb : http://image.quanmin.tv/289d9855d4b4d39d41c3f454bb775977jpg
         * link :
         * create_at : 2016-06-16 17:04:52
         * status : 1
         * fk : 326745
         * subtitle :
         * content :
         * ext : {"type":"play"}
         * slot_id : 237
         * priority : 2
         * link_object : {"no":"326745","nick":"浏阳河长的像猴子","avatar":"http://image.quanmin.tv/avatar/ad569547dfe896f22a7bc5b1d4ecd3d5gif?imageView2/2/w/300/","follow":"262419","id":"96539","uid":"326745","title":"百分百胜率，皇子打野。","category_id":"1","slug":"qq312118607","intro":"保持善良 宽容，不忘初心。","announcement":"直播时间，上午9点到下午3点。","cover":"326745-1486972443-351.jpg","play_at":"2017-02-13 10:50:37","last_play_at":"","view":"218543","views":"0","status":"2","priv":"0","landscape":"1","position":"","weight":"0","check":"1","recommend_image":"http://image.quanmin.tv/a31d5c90109cec5e0e0a3a267f9fc0f4jpg","videoQuality":"234","category_name":"英雄联盟","screen":0,"start_time":"1486954271.781","source":"ws","thumb":"http://image.quanmin.tv/289d9855d4b4d39d41c3f454bb775977jpg","video":"http://thumb.quanmin.tv/326745.mp4?t=1486972200","stream":"http://flv5.quanmin.tv/live/326745@quanmin_sd_720p.flv","app_shuffling_image":"http://image.quanmin.tv/3f727a8ac18a90a42d0de45926b38773jpg","categoryId":"1","hidden":false,"play_status":true}
         */

        private int id;
        private String title;
        private String thumb;
        private String link;
        private String create_at;
        private int status;
        private String fk;
        private String subtitle;
        private String content;
        private ExtBeanXXXXXX ext;
        private int slot_id;
        private int priority;
        private LinkObjectBeanXXX link_object;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFk() {
            return fk;
        }

        public void setFk(String fk) {
            this.fk = fk;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public ExtBeanXXXXXX getExt() {
            return ext;
        }

        public void setExt(ExtBeanXXXXXX ext) {
            this.ext = ext;
        }

        public int getSlot_id() {
            return slot_id;
        }

        public void setSlot_id(int slot_id) {
            this.slot_id = slot_id;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public LinkObjectBeanXXX getLink_object() {
            return link_object;
        }

        public void setLink_object(LinkObjectBeanXXX link_object) {
            this.link_object = link_object;
        }

        public static class ExtBeanXXXXXX {
            /**
             * type : play
             */

            private String type;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class LinkObjectBeanXXX {
            /**
             * no : 326745
             * nick : 浏阳河长的像猴子
             * avatar : http://image.quanmin.tv/avatar/ad569547dfe896f22a7bc5b1d4ecd3d5gif?imageView2/2/w/300/
             * follow : 262419
             * id : 96539
             * uid : 326745
             * title : 百分百胜率，皇子打野。
             * category_id : 1
             * slug : qq312118607
             * intro : 保持善良 宽容，不忘初心。
             * announcement : 直播时间，上午9点到下午3点。
             * cover : 326745-1486972443-351.jpg
             * play_at : 2017-02-13 10:50:37
             * last_play_at :
             * view : 218543
             * views : 0
             * status : 2
             * priv : 0
             * landscape : 1
             * position :
             * weight : 0
             * check : 1
             * recommend_image : http://image.quanmin.tv/a31d5c90109cec5e0e0a3a267f9fc0f4jpg
             * videoQuality : 234
             * category_name : 英雄联盟
             * screen : 0
             * start_time : 1486954271.781
             * source : ws
             * thumb : http://image.quanmin.tv/289d9855d4b4d39d41c3f454bb775977jpg
             * video : http://thumb.quanmin.tv/326745.mp4?t=1486972200
             * stream : http://flv5.quanmin.tv/live/326745@quanmin_sd_720p.flv
             * app_shuffling_image : http://image.quanmin.tv/3f727a8ac18a90a42d0de45926b38773jpg
             * categoryId : 1
             * hidden : false
             * play_status : true
             */

            private String no;
            private String nick;
            private String avatar;
            private String follow;
            private String id;
            private String uid;
            private String title;
            private String category_id;
            private String slug;
            private String intro;
            private String announcement;
            private String cover;
            private String play_at;
            private String last_play_at;
            private String view;
            private String views;
            private String status;
            private String priv;
            private String landscape;
            private String position;
            private String weight;
            private String check;
            private String recommend_image;
            private String videoQuality;
            private String category_name;
            private int screen;
            private String start_time;
            private String source;
            private String thumb;
            private String video;
            private String stream;
            private String app_shuffling_image;
            private String categoryId;
            private boolean hidden;
            private boolean play_status;

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getFollow() {
                return follow;
            }

            public void setFollow(String follow) {
                this.follow = follow;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getPlay_at() {
                return play_at;
            }

            public void setPlay_at(String play_at) {
                this.play_at = play_at;
            }

            public String getLast_play_at() {
                return last_play_at;
            }

            public void setLast_play_at(String last_play_at) {
                this.last_play_at = last_play_at;
            }

            public String getView() {
                return view;
            }

            public void setView(String view) {
                this.view = view;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPriv() {
                return priv;
            }

            public void setPriv(String priv) {
                this.priv = priv;
            }

            public String getLandscape() {
                return landscape;
            }

            public void setLandscape(String landscape) {
                this.landscape = landscape;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getCheck() {
                return check;
            }

            public void setCheck(String check) {
                this.check = check;
            }

            public String getRecommend_image() {
                return recommend_image;
            }

            public void setRecommend_image(String recommend_image) {
                this.recommend_image = recommend_image;
            }

            public String getVideoQuality() {
                return videoQuality;
            }

            public void setVideoQuality(String videoQuality) {
                this.videoQuality = videoQuality;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public int getScreen() {
                return screen;
            }

            public void setScreen(int screen) {
                this.screen = screen;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getStream() {
                return stream;
            }

            public void setStream(String stream) {
                this.stream = stream;
            }

            public String getApp_shuffling_image() {
                return app_shuffling_image;
            }

            public void setApp_shuffling_image(String app_shuffling_image) {
                this.app_shuffling_image = app_shuffling_image;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public boolean isHidden() {
                return hidden;
            }

            public void setHidden(boolean hidden) {
                this.hidden = hidden;
            }

            public boolean isPlay_status() {
                return play_status;
            }

            public void setPlay_status(boolean play_status) {
                this.play_status = play_status;
            }
        }
    }
}
