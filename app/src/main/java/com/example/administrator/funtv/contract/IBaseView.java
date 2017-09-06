package com.example.administrator.funtv.contract;




/**
 * Created by Administrator on 2017/4/8 0008.
 * MVP
 * View协议层
 */

public interface IBaseView<T> {
    void showLoading();
    void disLoading();
    void loadSuccess(T t);
    void loadFail(String error);
}
