package com.example.administrator.funtv.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bodhixu on 2017/2/14.
 *
 * 首页数据结构
 */

public class ShouyeBean implements Serializable{

    private List<RoomBean> room;
    private List<?> ad;

    public List<RoomBean> getRoom() {
        return room;
    }

    public void setRoom(List<RoomBean> room) {
        this.room = room;
    }

    public List<?> getAd() {
        return ad;
    }

    public void setAd(List<?> ad) {
        this.ad = ad;
    }

    public static class RoomBean implements Serializable{
        /**
         * id : 0
         * name : 精彩推荐
         * is_default : 1
         * icon :
         * slug :
         * category_more :
         * type : 1
         * screen : 0
         * list : [{"beauty_cover":"","no":2244235,"first_play_at":"1970-01-01 08:00:00","category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/2244235-1487120822-313.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/2244235.mp4?t=1487120700","title":"国服第一戏命师丶烬  50玫瑰狗粮给房管","recommend_image":"","is_shield":false,"nick":"全丶民TV孤月","uid":2244235,"view":"10043","category_id":1,"stream":"http://flv.quanmin.tv/live/2244235.flv","slug":"","love_cover":"","level":0,"like":0,"video_quality":null,"weight":0,"starlight":101772,"check":true,"avatar":"http://image.quanmin.tv/avatar/cd9c2e3e42fcebedc7ab7987035fc471?imageView2/2/w/300/","follow":25882,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-02-15 08:15:15","last_thumb":"2244235-1487067123-917.jpg","landscape":1,"category_slug":"lol","anniversary":0,"play_status":true,"status":2,"coin":101772,"link":"http://www.quanmin.tv/2244235"},{"beauty_cover":"","no":8038470,"first_play_at":"1970-01-01 08:00:00","category_name":"全民星秀","thumb":"http://snap.quanmin.tv/8038470-1487120873-157.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/8038470.mp4?t=1487120700","title":"早上好，我是小美","recommend_image":"http://bj.bcebos.com/mas-service/14850660298051ff6d10859c7b134296b3c2dd8ebfe55","is_shield":false,"nick":"Lv丶小美","uid":8038470,"view":"9792","category_id":4,"stream":"http://flv.quanmin.tv/live/8038470.flv","slug":"","love_cover":"","level":0,"like":0,"video_quality":null,"weight":0,"starlight":543637,"check":true,"avatar":"http://a.img.shouyintv.cn/D02Z102-normal","follow":5863,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"外太空","app_shuffling_image":"http://bj.bcebos.com/mas-service/148506603451295f3b38fe50a6aa13049da34ed6ff46a","create_at":"2017-02-15 08:53:42","last_thumb":"8038470-1487119554-598.jpg","landscape":1,"category_slug":"beauty","anniversary":0,"play_status":true,"status":2,"coin":543637,"link":"http://www.quanmin.tv/8038470"},{"beauty_cover":"","no":13576214,"first_play_at":"1970-01-01 08:00:00","category_name":"全民星秀","thumb":"http://snap.quanmin.tv/1872286068-1487120823-624.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/1872286068.mp4?t=1487120700","title":"新人主播献才艺","recommend_image":"","is_shield":false,"nick":"橘子味的Mao－","uid":1872286068,"view":"1814","category_id":4,"stream":"http://flv.quanmin.tv/live/1872286068.flv","slug":null,"love_cover":"","level":0,"like":0,"video_quality":null,"weight":0,"starlight":57518,"check":true,"avatar":"http://a.img.shouyintv.cn/vaXd102-normal","follow":7179,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"外太空","create_at":"2017-02-15 08:52:18","last_thumb":"1872286068-1486699263-192.jpg","landscape":1,"category_slug":"beauty","anniversary":0,"play_status":true,"status":2,"coin":57518,"link":"http://www.quanmin.tv/13576214"},{"beauty_cover":"","no":3299219,"first_play_at":"1970-01-01 08:00:00","category_name":"单机主机","thumb":"http://snap.quanmin.tv/3299219-1487120822-760.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/3299219.mp4?t=1487120700","title":"【卷哥】卷姐走了。又剩卷哥一个人了。~","recommend_image":"","is_shield":false,"nick":"丶大花卷儿丶","uid":3299219,"view":"6076","category_id":5,"stream":"http://flv.quanmin.tv/live/3299219_L3.flv","slug":"zaazgg","love_cover":"","level":0,"like":0,"video_quality":"234","weight":0,"starlight":2114,"check":true,"avatar":"http://image.quanmin.tv/avatar/98cd8c8f1cd5c1b51dd812b4a2858524?imageView2/2/w/300/","follow":206,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-02-15 08:11:04","last_thumb":"3299219-1487107622-685.jpg","landscape":1,"category_slug":"tvgame","anniversary":0,"play_status":true,"status":2,"coin":2114,"link":"http://www.quanmin.tv/v/zaazgg"},{"beauty_cover":"","no":3093842,"first_play_at":"1970-01-01 08:00:00","category_name":"炉石传说","thumb":"http://snap.quanmin.tv/3093842-1487120823-74.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/3093842.mp4?t=1487120700","title":"认真严肃的清水 搞笑我是认真的","recommend_image":"","is_shield":false,"nick":"全民TV丶清水","uid":3093842,"view":"1531","category_id":3,"stream":"http://flv.quanmin.tv/live/3093842.flv","slug":"","love_cover":"","level":0,"like":0,"video_quality":"","weight":0,"starlight":4945,"check":true,"avatar":"http://image.quanmin.tv/avatar/a4f17a5f4302d1ff65523db2df771856png?imageView2/2/w/300/","follow":432,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-02-15 06:59:07","last_thumb":"3093842-1486956663-771.jpg","landscape":1,"category_slug":"heartstone","anniversary":0,"play_status":true,"status":2,"coin":4945,"link":"http://www.quanmin.tv/3093842"},{"beauty_cover":"","no":2904536,"first_play_at":"1970-01-01 08:00:00","category_name":"全民户外","thumb":"http://snap.quanmin.tv/2904536-1487120822-697.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/2904536.mp4?t=1487120700","title":"带兄弟们看猴戏","recommend_image":"","is_shield":false,"nick":"家养小猴","uid":2904536,"view":"4920","category_id":13,"stream":"http://flv.quanmin.tv/live/2904536.flv","slug":"","love_cover":"","level":0,"like":0,"video_quality":"","weight":0,"starlight":0,"check":true,"avatar":"http://image.quanmin.tv/avatar/926a6311a7bc8ec677ccd50526cc2bffjpg?imageView2/2/w/300/","follow":30453,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-02-15 08:52:08","last_thumb":"2904536-1487039642-949.jpg","landscape":1,"category_slug":"huwai","anniversary":0,"play_status":true,"status":2,"coin":0,"link":"http://www.quanmin.tv/2904536"}]
         */

        private int id;
        private String name;
        private int is_default;
        private String icon;
        private String slug;
        private String category_more;
        private int type;
        private int screen;
        private List<ListBean> list;

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

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getCategory_more() {
            return category_more;
        }

        public void setCategory_more(String category_more) {
            this.category_more = category_more;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getScreen() {
            return screen;
        }

        public void setScreen(int screen) {
            this.screen = screen;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * beauty_cover :
             * no : 2244235
             * first_play_at : 1970-01-01 08:00:00
             * category_name : 英雄联盟
             * thumb : http://snap.quanmin.tv/2244235-1487120822-313.jpg?imageView2/2/w/390/
             * last_play_at : 1970-01-01 08:00:00
             * screen : 0
             * video : http://thumb.quanmin.tv/2244235.mp4?t=1487120700
             * title : 国服第一戏命师丶烬  50玫瑰狗粮给房管
             * recommend_image :
             * is_shield : false
             * nick : 全丶民TV孤月
             * uid : 2244235
             * view : 10043
             * category_id : 1
             * stream : http://flv.quanmin.tv/live/2244235.flv
             * slug :
             * love_cover :
             * level : 0
             * like : 0
             * video_quality : null
             * weight : 0
             * starlight : 101772
             * check : true
             * avatar : http://image.quanmin.tv/avatar/cd9c2e3e42fcebedc7ab7987035fc471?imageView2/2/w/300/
             * follow : 25882
             * play_count : 0
             * play_true : 0
             * fans : 0
             * max_view : 0
             * default_image :
             * last_end_at : 1970-01-01 08:00:00
             * position :
             * create_at : 2017-02-15 08:15:15
             * last_thumb : 2244235-1487067123-917.jpg
             * landscape : 1
             * category_slug : lol
             * anniversary : 0
             * play_status : true
             * status : 2
             * coin : 101772
             * link : http://www.quanmin.tv/2244235
             * app_shuffling_image : http://bj.bcebos.com/mas-service/148506603451295f3b38fe50a6aa13049da34ed6ff46a
             */

            private String beauty_cover;
            private int no;
            private String first_play_at;
            private String category_name;
            private String thumb;
            private String last_play_at;
            private int screen;
            private String video;
            private String title;
            private String recommend_image;
            private boolean is_shield;
            private String nick;
            private int uid;
            private String view;
            private int category_id;
            private String stream;
            private String slug;
            private String love_cover;
            private int level;
            private int like;
            private Object video_quality;
            private int weight;
            private int starlight;
            private boolean check;
            private String avatar;
            private int follow;
            private int play_count;
            private int play_true;
            private int fans;
            private int max_view;
            private String default_image;
            private String last_end_at;
            private String position;
            private String create_at;
            private String last_thumb;
            private int landscape;
            private String category_slug;
            private int anniversary;
            private boolean play_status;
            private int status;
            private int coin;
            private String link;
            private String app_shuffling_image;

            public String getBeauty_cover() {
                return beauty_cover;
            }

            public void setBeauty_cover(String beauty_cover) {
                this.beauty_cover = beauty_cover;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public String getFirst_play_at() {
                return first_play_at;
            }

            public void setFirst_play_at(String first_play_at) {
                this.first_play_at = first_play_at;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getLast_play_at() {
                return last_play_at;
            }

            public void setLast_play_at(String last_play_at) {
                this.last_play_at = last_play_at;
            }

            public int getScreen() {
                return screen;
            }

            public void setScreen(int screen) {
                this.screen = screen;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getRecommend_image() {
                return recommend_image;
            }

            public void setRecommend_image(String recommend_image) {
                this.recommend_image = recommend_image;
            }

            public boolean isIs_shield() {
                return is_shield;
            }

            public void setIs_shield(boolean is_shield) {
                this.is_shield = is_shield;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getView() {
                return view;
            }

            public void setView(String view) {
                this.view = view;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getStream() {
                return stream;
            }

            public void setStream(String stream) {
                this.stream = stream;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getLove_cover() {
                return love_cover;
            }

            public void setLove_cover(String love_cover) {
                this.love_cover = love_cover;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public Object getVideo_quality() {
                return video_quality;
            }

            public void setVideo_quality(Object video_quality) {
                this.video_quality = video_quality;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public int getStarlight() {
                return starlight;
            }

            public void setStarlight(int starlight) {
                this.starlight = starlight;
            }

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getPlay_count() {
                return play_count;
            }

            public void setPlay_count(int play_count) {
                this.play_count = play_count;
            }

            public int getPlay_true() {
                return play_true;
            }

            public void setPlay_true(int play_true) {
                this.play_true = play_true;
            }

            public int getFans() {
                return fans;
            }

            public void setFans(int fans) {
                this.fans = fans;
            }

            public int getMax_view() {
                return max_view;
            }

            public void setMax_view(int max_view) {
                this.max_view = max_view;
            }

            public String getDefault_image() {
                return default_image;
            }

            public void setDefault_image(String default_image) {
                this.default_image = default_image;
            }

            public String getLast_end_at() {
                return last_end_at;
            }

            public void setLast_end_at(String last_end_at) {
                this.last_end_at = last_end_at;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getCreate_at() {
                return create_at;
            }

            public void setCreate_at(String create_at) {
                this.create_at = create_at;
            }

            public String getLast_thumb() {
                return last_thumb;
            }

            public void setLast_thumb(String last_thumb) {
                this.last_thumb = last_thumb;
            }

            public int getLandscape() {
                return landscape;
            }

            public void setLandscape(int landscape) {
                this.landscape = landscape;
            }

            public String getCategory_slug() {
                return category_slug;
            }

            public void setCategory_slug(String category_slug) {
                this.category_slug = category_slug;
            }

            public int getAnniversary() {
                return anniversary;
            }

            public void setAnniversary(int anniversary) {
                this.anniversary = anniversary;
            }

            public boolean isPlay_status() {
                return play_status;
            }

            public void setPlay_status(boolean play_status) {
                this.play_status = play_status;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCoin() {
                return coin;
            }

            public void setCoin(int coin) {
                this.coin = coin;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getApp_shuffling_image() {
                return app_shuffling_image;
            }

            public void setApp_shuffling_image(String app_shuffling_image) {
                this.app_shuffling_image = app_shuffling_image;
            }
        }
    }
}
