package com.example.administrator.funtv.apiservice;

import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.entity.ADBean;
import com.example.administrator.funtv.entity.LanmuBean;
import com.example.administrator.funtv.entity.OtherBean;
import com.example.administrator.funtv.entity.SearchBean;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.entity.ZhiboBean;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2017/4/5 0005.
 */

public interface ApiService {
    //获得广告轮播图
    @GET(UrlConfigs.PATH_AD)
    Observable<ADBean> getAdData();

    //获得首页数据
    @GET(UrlConfigs.PATH_SHOUYE)
    Observable<ShouyeBean> getShouyeData();

    //其他
    @GET(UrlConfigs.PATH_OTHER)
    Observable<OtherBean> getOtherData(@Path("category") String category);

    //直播
    @GET(UrlConfigs.PATH_ZHIBO)
    Observable<ZhiboBean> getZhiboData();

    //栏目
    @GET(UrlConfigs.PATH_LANMU)
    Observable<List<LanmuBean>> getLanmuData();

    //搜索
    @POST(UrlConfigs.SEARCH_URL)
    Observable<SearchBean> getSearchReponse(@Body JsonObject jsonObject);

}
