package com.example.administrator.funtv.activity.splash;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.ADBean;
import com.example.administrator.funtv.http.RetrofitUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/4/5 0005.
 *1、处理URL
 * 2、倒入依赖
 * 3、生成JavaBean
 * 4、写APIservice 给Retorfit调用生成observable对象
 * 5、封装Retorfit工具类，实现单例模式
 * 6、retrofit对象调用apiservice，生成observable
 * 7、实现Observable实现链式操作，获得数据
 */

public class ADModel implements AppContracts.IADModel {
    private RetrofitUtils retrofitUtils;
    private IDownloadListener iDownloadListener;

    public ADModel(IDownloadListener iDownloadListener) {
        this.retrofitUtils = RetrofitUtils.getRetrofitUtilsInstance();
        this.iDownloadListener = iDownloadListener;
    }

    @Override
    public void getData() {
        //RxIava + Retrofit2.0 + OKHttp3.0 下载网络数据
        Observable<ADBean> observable = retrofitUtils.getAdData();
        observable.subscribeOn(Schedulers.newThread())//在新线程中执行请求
                  .observeOn(AndroidSchedulers.mainThread())//在UI线程中回调
                  .subscribe(new Subscriber<ADBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iDownloadListener.downloadFail(e.getMessage());
                    }

                    @Override
                    public void onNext(ADBean adBean) {
                        iDownloadListener.downloadSuccess(adBean);

                    }
                });

    }
}
