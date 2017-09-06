package com.example.administrator.funtv.fragment.zhibo;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.ZhiboBean;
import com.example.administrator.funtv.http.RetrofitUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class ZhiboModelImpl implements AppContracts.IZhiboModel {
    private IDownloadListener<ZhiboBean> iDownloadListener;
    private RetrofitUtils retrofitUtils;

    public ZhiboModelImpl(IDownloadListener<ZhiboBean> iDownloadListener) {
        this.iDownloadListener = iDownloadListener;
        retrofitUtils = RetrofitUtils.getRetrofitUtilsInstance();
    }

    @Override
    public void getData() {
        Observable<ZhiboBean> zhiboData = retrofitUtils.getZhiboData();
        zhiboData.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZhiboBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iDownloadListener.downloadFail(e.getMessage());
                    }

                    @Override
                    public void onNext(ZhiboBean zhiboBean) {
                        iDownloadListener.downloadSuccess(zhiboBean);
                    }
                });


    }
}
