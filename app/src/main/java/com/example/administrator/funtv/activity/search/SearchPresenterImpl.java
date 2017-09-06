package com.example.administrator.funtv.activity.search;

import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.SearchBean;
import com.google.gson.JsonObject;

/**
 * Created by Administrator on 2017/6/5 0005.
 */

public class SearchPresenterImpl implements AppContracts.ISearchPresenter,IDownloadListener<SearchBean> {
    private AppContracts.ISearchView searchView;
    private AppContracts.ISearchModel searchModel;

    public SearchPresenterImpl(AppContracts.ISearchView searchView) {
        this.searchView = searchView;
        this.searchModel = new SearchModelImpl(this);
    }


    @Override
    public void getData(JsonObject jsonObject) {
        searchModel.getData(jsonObject);
        searchView.showLoading();
    }

    @Override
    public void getData() {

    }

    @Override
    public void downloadFail(String msg) {
        searchView.disLoading();
    }

    @Override
    public void downloadSuccess(SearchBean searchBean) {
        searchView.loadSuccess(searchBean);
    }
}
