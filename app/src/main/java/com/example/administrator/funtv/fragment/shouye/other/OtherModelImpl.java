package com.example.administrator.funtv.fragment.shouye.other;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.OtherBean;
import com.example.administrator.funtv.http.RetrofitUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class OtherModelImpl implements AppContracts.IOtherModel {
    private IDownloadListener<OtherBean> downloadListener;
    private RetrofitUtils retrofitUtils;

    public OtherModelImpl(IDownloadListener<OtherBean> downloadListener) {
        this.downloadListener = downloadListener;
        retrofitUtils = RetrofitUtils.getRetrofitUtilsInstance();
    }

    @Override
    public void getData() {

    }

    @Override
    public void getData(String category) {
        Observable<OtherBean> otherData = retrofitUtils.getOtherData(category);
        otherData.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<OtherBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        downloadListener.downloadFail(e.getMessage());
                    }

                    @Override
                    public void onNext(OtherBean otherBean) {
                        downloadListener.downloadSuccess(otherBean);
                    }
                });

    }
}
