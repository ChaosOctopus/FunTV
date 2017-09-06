package com.example.administrator.funtv.fragment.zhibo;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.ZhiboBean;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class ZhiboPresenterImpl implements AppContracts.IZhiboPresenter ,IDownloadListener<ZhiboBean>{
    private AppContracts.IZhiboModel iZhiboModel;
    private AppContracts.IZhiboView iZhiboView;

    public ZhiboPresenterImpl( AppContracts.IZhiboView iZhiboView) {
        iZhiboModel = new ZhiboModelImpl(this);
        this.iZhiboView = iZhiboView;
    }

    @Override
    public void getData() {
        iZhiboView.showLoading();
        iZhiboModel.getData();
    }

    @Override
    public void downloadFail(String msg) {
        iZhiboView.loadFail(msg);
        iZhiboView.disLoading();
    }

    @Override
    public void downloadSuccess(ZhiboBean zhiboBean) {
        iZhiboView.loadSuccess(zhiboBean);
        iZhiboView.disLoading();
    }
}
