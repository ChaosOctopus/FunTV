package com.example.administrator.funtv.fragment.shouye;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.ShouyeBean;

/**
 * Created by Administrator on 2017/4/8 0008.
 * 用于接受V消息 通知M取数据
 *
 * M层可以new V层只能传参
 */

public class ShouyePresenterImpl implements AppContracts.IShouyePresenter,IDownloadListener<ShouyeBean> {
    private AppContracts.IShouyeView shouyeView;
    private AppContracts.IShouyeModel shouyeModel;

    public ShouyePresenterImpl(AppContracts.IShouyeView shouyeView) {
        this.shouyeView = shouyeView;
        this.shouyeModel = new ShouyeModelImpl(this);
    }

    @Override
    public void getData() {
        shouyeView.showLoading();
        shouyeModel.getData();
    }

    @Override
    public void downloadFail(String msg) {
        shouyeView.disLoading();
    }

    @Override
    public void downloadSuccess(ShouyeBean shouyeBean) {
       shouyeView.loadSuccess(shouyeBean);
    }
}
