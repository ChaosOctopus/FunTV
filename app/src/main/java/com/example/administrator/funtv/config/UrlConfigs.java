package com.example.administrator.funtv.config;

/**
 * Created by Administrator on 2017/4/5 0005.
 * URL常量类
 */

public class UrlConfigs {
    //base url
    public static final String BASE_URL="http://www.quanmin.tv/";
    //PlayURL
    public static final String PlAY_URL="http://flv.quanmin.tv/live/%s.flv";
    //标清
    public static final String PLAY_URL_BQ="http://flv.quanmin.tv/live/%s_L3.flv";
    //高清
    public static final String PLAY_URL_GQ="http://flv.quanmin.tv/live/%s_L4.flv";
    //Version
    public static final String BASE_VERSION="?11212054v=2.2.4&os=1&ver=4";
    //广告
    public static final String PATH_AD = "json/page/app-data/info.json"+BASE_VERSION;
    //首页
    public static final String PATH_SHOUYE =  "json/app/index/recommend/list-android.json" + BASE_VERSION;

    //其他
    public static final String PATH_OTHER = "json/categories/{category}/list.json"+BASE_VERSION;

    //直播
    public static final String PATH_ZHIBO="json/play/list.json"+BASE_VERSION;

    //栏目 http://www.quanmin.tv/json/categories/list.json?11212119&v=2.2.4&os=1&ver=4
    public static final String PATH_LANMU="json/categories/list.json"+BASE_VERSION;

    //搜索
    public static final String SEARCH_URL ="site/search?p=1&refer=search&device=AknYJ6H1svk5AhUoGvUAuBZRAkPW56PHz_AMlFX7FGHN&ch=baiduzhushou&uid=-1&rid=-1&rcat=-\n" +
            "1&net=0&screen=2&sw=720&sh=1280";
}
