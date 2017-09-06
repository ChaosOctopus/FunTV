package com.example.administrator.funtv.fragment.shouye.other;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.OtherBean;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class OtherPresenterImpl implements AppContracts.IOtherPresenter,IDownloadListener<OtherBean> {
    private AppContracts.IOtherModel iOtherModel;
    private AppContracts.IOtherView iOtherView;

    public OtherPresenterImpl(AppContracts.IOtherView iOtherView) {
        this.iOtherView=iOtherView;
        iOtherModel = new OtherModelImpl(this);
    }

    @Override
    public void getData() {

    }

    @Override
    public void downloadFail(String msg) {
        iOtherView.loadFail(msg);
        iOtherView.disLoading();
    }

    @Override
    public void downloadSuccess(OtherBean otherBean) {
        iOtherView.loadSuccess(otherBean);
        iOtherView.disLoading();
    }

    @Override
    public void getData(String category) {
        iOtherView.showLoading();
        iOtherModel.getData(category);
    }
}
