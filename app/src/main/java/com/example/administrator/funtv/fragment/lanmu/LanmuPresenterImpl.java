package com.example.administrator.funtv.fragment.lanmu;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.LanmuBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class LanmuPresenterImpl implements AppContracts.ILanmuPresenter,IDownloadListener<List<LanmuBean>> {
    private AppContracts.ILamuModel iLanmuModel;
    private AppContracts.ILanmuView iLanmuView;

    public LanmuPresenterImpl( AppContracts.ILanmuView iLanmuView) {
        this.iLanmuView = iLanmuView;
        iLanmuModel = new LanmuModelImpl(this);
    }

    @Override
    public void getData() {
        iLanmuView.showLoading();
        iLanmuModel.getData();
    }

    @Override
    public void downloadFail(String msg) {
        iLanmuView.disLoading();
    }

    @Override
    public void downloadSuccess(List<LanmuBean> lanmuBeen) {
        iLanmuView.loadSuccess(lanmuBeen);
    }


}
