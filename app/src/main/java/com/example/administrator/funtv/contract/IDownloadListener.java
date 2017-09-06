package com.example.administrator.funtv.contract;


/**
 * Created by Administrator on 2017/4/5 0005.
 */

public interface IDownloadListener<T> {
    void downloadFail(String msg);
    void downloadSuccess(T t);
}
