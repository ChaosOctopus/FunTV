package com.example.administrator.funtv.http;

import com.example.administrator.funtv.apiservice.ApiService;
import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.entity.ADBean;
import com.example.administrator.funtv.entity.LanmuBean;
import com.example.administrator.funtv.entity.OtherBean;
import com.example.administrator.funtv.entity.SearchBean;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.entity.ZhiboBean;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Administrator on 2017/4/5 0005.
 */

public class RetrofitUtils {

    public static  RetrofitUtils retrofitUtils;
    public static Retrofit retrofit;
    public  static ApiService apiService;

    //构造方法私有化
    private RetrofitUtils(){
        newRetrofitInstance();
    }

    //工具类的单例模式
    public static  RetrofitUtils getRetrofitUtilsInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }
    //获得一个Retrofit单例
    public static Retrofit newRetrofitInstance(){
        if (retrofit==null){
            synchronized (RetrofitUtils.class){
                if(retrofit==null){
                    //retrofit的实例化
                    retrofit = new Retrofit.Builder()
                            .baseUrl(UrlConfigs.BASE_URL)
                            .client(OkHttpUtils.newOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                    apiService = retrofit.create(ApiService.class);

                }
            }

        }
        return retrofit;
    }
    //获得广告的数据
    public Observable<ADBean> getAdData(){
        return apiService.getAdData();
    }
    //获得首页数据
    public Observable<ShouyeBean> getShouyeData(){ return apiService.getShouyeData();}
    //获得其他数据
    public Observable<OtherBean> getOtherData(String category){
        return apiService.getOtherData(category);
    }
    //获得直播数据
    public  Observable<ZhiboBean> getZhiboData(){
        return apiService.getZhiboData();
    }

    //获得栏目数据
    public  Observable<List<LanmuBean>> getLanmuData(){
        return apiService.getLanmuData();
    }
    //获得搜索数据
    public Observable<SearchBean> getSearchData(JsonObject jsonObject){
        return apiService.getSearchReponse(jsonObject);
    }

}
