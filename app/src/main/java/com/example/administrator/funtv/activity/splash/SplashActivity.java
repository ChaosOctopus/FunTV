package com.example.administrator.funtv.activity.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.ADActivity;
import com.example.administrator.funtv.activity.MainActivity;
import com.example.administrator.funtv.base.BaseApplication;
import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.contract.IDownloadListener;
import com.example.administrator.funtv.entity.ADBean;

import cn.bmob.v3.Bmob;

public class SplashActivity extends Activity implements IDownloadListener<ADBean>{
    private AppContracts.IADModel iadModel;
    //休眠时间
    public static final int SLEEP_TIME=2000;
    private long strat_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        creatAppIcon(this,SplashActivity.class);
        Bmob.initialize(this,"3cac75ec420337f207da326618c62a00");
        initData();
    }

    private void initData() {
        //计算起始时间
        strat_time = System.currentTimeMillis();
        iadModel = new ADModel(this);
        iadModel.getData();
    }

    /**
     * 创建桌面图标
     * 注意添加权限
     *      <uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
     * @param context
     * @param startCls
     */
    private void creatAppIcon(Context context, Class<?> startCls) {
        Intent shortcutIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
        shortcutIntent.putExtra("duplicate", false); //false不运行重复添加图标
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(context, startCls));
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(this,R.mipmap.ic_launcher));
        sendBroadcast(shortcutIntent);
    }

    @Override
    public void downloadFail(String msg) {

    }

    @Override
    public void downloadSuccess(ADBean adBean) {
       //使用Application来保存全局数据
        BaseApplication  baseApplication= (BaseApplication) getApplication();
        baseApplication.setAdBean(adBean);
        new ADTask().execute();
    }
    class ADTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            long endtime=System.currentTimeMillis();
            long runtime=endtime-strat_time;
            if(runtime<SLEEP_TIME){
                try {
                    Thread.sleep(SLEEP_TIME-runtime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(SplashActivity.this, ADActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
