package com.example.administrator.funtv.entity;

import java.util.List;

/**
 * Created by acer on 2016/11/23.
 */

public class SearchBean {


    /**
     * code : 200
     * data : {"items":[{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/3275281-1479893162-147.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/0127339a47c71373bdab3bf104d3d7c2png?imageView2/2/w/300/","title":"用EZ上白金的话，给自己奖励一个电玩勇者","is_shield":false,"nick":"uzigege","uid":3275281,"view":"105","category_id":1,"slug":"","category_slug":"lol","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/6815515-1479893161-736.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"福建第一EZ，手速流精准Q","is_shield":false,"nick":"天然丶王者AD","uid":6815515,"view":"97","category_id":1,"slug":"","category_slug":"lol","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/8558145-1478428503-687.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/3fa416c2943f9baf8ee445ebbf514a92jpg?imageView2/2/w/300/","title":"Ez秀的直播间","is_shield":false,"nick":"Ez秀","uid":8558145,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"","screen":0,"avatar":"http://image.quanmin.tv/avatar/af2b0873d55de687e18516d2565cabcdgif?imageView2/2/w/300/","title":"全民丶ez的直播间","is_shield":false,"nick":"全民丶ez","uid":319172,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"颜值控","thumb":"http://image.quanmin.tv/love/e7185a99cd082bb71be3474a81793a87jpg?imageView2/2/w/500/","screen":1,"avatar":"http://wx.qlogo.cn/mmopen/hdVDiah7G7ADDiaxPeXOeBaE1cvtmpV7IguVDLZZ8lX2H2JxBSqrBpiaFWrgZUIbbYetZAEOUO9JHNCNUkze1HIt4sgFJjiaO6aZ/0","title":"Ez灬淋可爱1的直播间","is_shield":false,"nick":"Ez灬淋可爱1","uid":8882111,"view":"0","category_id":29,"slug":"","category_slug":"love","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/274259-1459581723-765.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/946088892006094ebbbde9f75a54a8dfjpg?imageView2/2/w/300/","title":"EZ专场：电一大师或者暗影岛黑色王者排位","is_shield":false,"nick":"我的EZ会发光","uid":274259,"view":"0","category_id":1,"slug":"wanghuanfen520","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/1592024-1479367302-283.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/aebbdce44adbe1f80ba106d55881cbdfJPG?imageView2/2/w/300/","title":"玩玩天使可以电十一起开车！！！！！","is_shield":false,"nick":"Ez_栋少","uid":1592024,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/611449-1454001843-726.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/8a94b2dfb72e4d9639d6864ce01a832dJPG?imageView2/2/w/300/","title":"全民最逗逼直播\u2014\u2014不服来战！！","is_shield":false,"nick":"寒冰爱ez","uid":611449,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/41987-1472456944-185.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/92e15f1f6da73850e917fbe2c213d8b0png?imageView2/2/w/300/","title":"白银  烬无视套路 就是干","is_shield":false,"nick":"我的ez不太会","uid":41987,"view":"0","category_id":1,"slug":"asd123","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/6569795-1474563962-4.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://q.qlogo.cn/qqapp/101333140/DD6CAE925513954DA688C9F7F0B29939/100","title":"青铜界亚索爸爸","is_shield":false,"nick":"茂名第一EZ","uid":6569795,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false}],"total":46,"pageNb":5}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * items : [{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/3275281-1479893162-147.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/0127339a47c71373bdab3bf104d3d7c2png?imageView2/2/w/300/","title":"用EZ上白金的话，给自己奖励一个电玩勇者","is_shield":false,"nick":"uzigege","uid":3275281,"view":"105","category_id":1,"slug":"","category_slug":"lol","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/6815515-1479893161-736.jpg?imageView2/2/w/390/","screen":0,"avatar":"","title":"福建第一EZ，手速流精准Q","is_shield":false,"nick":"天然丶王者AD","uid":6815515,"view":"97","category_id":1,"slug":"","category_slug":"lol","play_status":true},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/8558145-1478428503-687.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/3fa416c2943f9baf8ee445ebbf514a92jpg?imageView2/2/w/300/","title":"Ez秀的直播间","is_shield":false,"nick":"Ez秀","uid":8558145,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"","screen":0,"avatar":"http://image.quanmin.tv/avatar/af2b0873d55de687e18516d2565cabcdgif?imageView2/2/w/300/","title":"全民丶ez的直播间","is_shield":false,"nick":"全民丶ez","uid":319172,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"颜值控","thumb":"http://image.quanmin.tv/love/e7185a99cd082bb71be3474a81793a87jpg?imageView2/2/w/500/","screen":1,"avatar":"http://wx.qlogo.cn/mmopen/hdVDiah7G7ADDiaxPeXOeBaE1cvtmpV7IguVDLZZ8lX2H2JxBSqrBpiaFWrgZUIbbYetZAEOUO9JHNCNUkze1HIt4sgFJjiaO6aZ/0","title":"Ez灬淋可爱1的直播间","is_shield":false,"nick":"Ez灬淋可爱1","uid":8882111,"view":"0","category_id":29,"slug":"","category_slug":"love","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/274259-1459581723-765.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/946088892006094ebbbde9f75a54a8dfjpg?imageView2/2/w/300/","title":"EZ专场：电一大师或者暗影岛黑色王者排位","is_shield":false,"nick":"我的EZ会发光","uid":274259,"view":"0","category_id":1,"slug":"wanghuanfen520","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/1592024-1479367302-283.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/aebbdce44adbe1f80ba106d55881cbdfJPG?imageView2/2/w/300/","title":"玩玩天使可以电十一起开车！！！！！","is_shield":false,"nick":"Ez_栋少","uid":1592024,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/611449-1454001843-726.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/8a94b2dfb72e4d9639d6864ce01a832dJPG?imageView2/2/w/300/","title":"全民最逗逼直播\u2014\u2014不服来战！！","is_shield":false,"nick":"寒冰爱ez","uid":611449,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/41987-1472456944-185.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/92e15f1f6da73850e917fbe2c213d8b0png?imageView2/2/w/300/","title":"白银  烬无视套路 就是干","is_shield":false,"nick":"我的ez不太会","uid":41987,"view":"0","category_id":1,"slug":"asd123","category_slug":"lol","play_status":false},{"category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/6569795-1474563962-4.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://q.qlogo.cn/qqapp/101333140/DD6CAE925513954DA688C9F7F0B29939/100","title":"青铜界亚索爸爸","is_shield":false,"nick":"茂名第一EZ","uid":6569795,"view":"0","category_id":1,"slug":"","category_slug":"lol","play_status":false}]
         * total : 46
         * pageNb : 5
         */

        private int total;
        private int pageNb;
        private List<ItemsBean> items;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNb() {
            return pageNb;
        }

        public void setPageNb(int pageNb) {
            this.pageNb = pageNb;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * category_name : 英雄联盟
             * thumb : http://snap.quanmin.tv/3275281-1479893162-147.jpg?imageView2/2/w/390/
             * screen : 0
             * avatar : http://image.quanmin.tv/avatar/0127339a47c71373bdab3bf104d3d7c2png?imageView2/2/w/300/
             * title : 用EZ上白金的话，给自己奖励一个电玩勇者
             * is_shield : false
             * nick : uzigege
             * uid : 3275281
             * view : 105
             * category_id : 1
             * slug :
             * category_slug : lol
             * play_status : true
             */

            private String category_name;
            private String thumb;
            private int screen;
            private String avatar;
            private String title;
            private boolean is_shield;
            private String nick;
            private int uid;
            private String view;
            private int category_id;
            private String slug;
            private String category_slug;
            private boolean play_status;

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

            public int getScreen() {
                return screen;
            }

            public void setScreen(int screen) {
                this.screen = screen;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getCategory_slug() {
                return category_slug;
            }

            public void setCategory_slug(String category_slug) {
                this.category_slug = category_slug;
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
