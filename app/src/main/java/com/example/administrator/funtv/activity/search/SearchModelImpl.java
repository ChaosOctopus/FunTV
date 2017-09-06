package com.example.administrator.funtv.activity.search;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.SearchBean;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.http.RetrofitUtils;
import com.google.gson.JsonObject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/5 0005.
 */

public class SearchModelImpl implements AppContracts.ISearchModel {
    private IDownloadListener<SearchBean> downloadListener;
    private RetrofitUtils retrofitUtils;

    public SearchModelImpl(IDownloadListener<SearchBean> downloadListener) {
        this.downloadListener = downloadListener;
        retrofitUtils=RetrofitUtils.getRetrofitUtilsInstance();
    }

    @Override
    public void getData(JsonObject jsonObject) {
        Observable<SearchBean> searchBean = retrofitUtils.getSearchData(jsonObject);
        searchBean.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        downloadListener.downloadFail(e.getMessage());
                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        downloadListener.downloadSuccess(searchBean);
                    }
                });

    }


    @Override
    public void getData() {

    }
}
