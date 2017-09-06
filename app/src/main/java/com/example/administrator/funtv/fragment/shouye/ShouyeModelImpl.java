package com.example.administrator.funtv.fragment.shouye;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.http.RetrofitUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/4/8 0008.
 * 首页数据层实现类
 */

public class ShouyeModelImpl implements AppContracts.IShouyeModel {
    private IDownloadListener<ShouyeBean> downloadListener;
    private RetrofitUtils retrofitUtils;

    public ShouyeModelImpl(IDownloadListener<ShouyeBean> downloadListener) {
        this.downloadListener = downloadListener;
        retrofitUtils = RetrofitUtils.getRetrofitUtilsInstance();
    }

    @Override
    public void getData() {
        //用于给首页取数据,通过接口传给P
        Observable<ShouyeBean> shouyeData = retrofitUtils.getShouyeData();
        shouyeData.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ShouyeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        downloadListener.downloadFail(e.getMessage());
                    }

                    @Override
                    public void onNext(ShouyeBean shouyeBean) {
                        downloadListener.downloadSuccess(shouyeBean);
                    }
                });

    }
}
