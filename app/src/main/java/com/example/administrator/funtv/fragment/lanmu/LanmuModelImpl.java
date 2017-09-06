package com.example.administrator.funtv.fragment.lanmu;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.LanmuBean;
import com.example.administrator.funtv.http.RetrofitUtils;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class LanmuModelImpl implements AppContracts.ILamuModel {
    private IDownloadListener<List<LanmuBean>> iDownloadListener;
    private RetrofitUtils retrofitUtils;

    public LanmuModelImpl(IDownloadListener<List<LanmuBean>> iDownloadListener) {
        this.iDownloadListener = iDownloadListener;
        retrofitUtils = RetrofitUtils.getRetrofitUtilsInstance();
    }

    @Override
    public void getData() {
        Observable<List<LanmuBean>> lanmuData = retrofitUtils.getLanmuData();
        lanmuData.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<LanmuBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<LanmuBean> lanmuBeen) {
                        iDownloadListener.downloadSuccess(lanmuBeen);
                    }
                });
    }
}
