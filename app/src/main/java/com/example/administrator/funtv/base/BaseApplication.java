package com.example.administrator.funtv.base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.funtv.db.DaoMaster;
import com.example.administrator.funtv.db.DaoSession;
import com.example.administrator.funtv.entity.ADBean;
import com.example.administrator.funtv.entity.ZhiboBean;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

/**
 * Created by Administrator on 2017/4/5 0005.
 * 自定义Application
 * 1、初始化操作
 * 2、存储一些全局变量
 *
 * 说一下对Context的理解
 *
 */

public class BaseApplication extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static BaseApplication instances;
    private ADBean adBean;
    private ZhiboBean zhiboBean;

    public ADBean getAdBean() {
        return adBean;
    }

    public void setAdBean(ADBean adBean) {
        this.adBean = adBean;
    }
    public  ZhiboBean getZhiboBean(){
        return zhiboBean;
    }
    public  void setZhiboBean(ZhiboBean zhiboBean){
        this.zhiboBean=zhiboBean;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instances=this;
        setDatabase();
        EMOptions options = new EMOptions();
    // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
    //初始化
        EMClient.getInstance().init(this, options);
    //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);
    }
    //初始化GreenDao数据库
    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "user-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public static BaseApplication getInstances(){
        return instances;
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }


}
