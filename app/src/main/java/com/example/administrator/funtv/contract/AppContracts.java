package com.example.administrator.funtv.contract;

import com.example.administrator.funtv.entity.LanmuBean;
import com.example.administrator.funtv.entity.OtherBean;
import com.example.administrator.funtv.entity.SearchBean;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.entity.ZhiboBean;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5 0005.
 * 应用程序的所有接口-应用程序的协议类
 */

public interface AppContracts {
    //广告页
    interface IADModel extends IBaseModel{}
    //首页
    interface  IShouyeView extends IBaseView<ShouyeBean>{}
    interface IShouyeModel extends IBaseModel{}
    interface IShouyePresenter extends IBasePresenter{}
    //其他频道
    interface IOtherView extends IBaseView<OtherBean>{}
    interface IOtherModel extends IBaseModel{
        void getData(String category);
    }
    interface IOtherPresenter extends IBasePresenter{
        void getData(String category);
    }

    //直播页面
    interface IZhiboView extends IBaseView<ZhiboBean>{}
    interface IZhiboModel extends IBaseModel{}
    interface IZhiboPresenter extends IBasePresenter{}

    //栏目页面
    interface ILanmuView extends IBaseView<List<LanmuBean>>{}
    interface ILamuModel extends IBaseModel{}
    interface ILanmuPresenter extends IBasePresenter{}

    //搜索页面
    interface ISearchView extends IBaseView<SearchBean>{}
    interface ISearchModel extends IBaseModel{
        void getData(JsonObject jsonObject);
    }
    interface ISearchPresenter extends IBasePresenter{
        void getData(JsonObject jsonObject);
    }
}
