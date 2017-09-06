package com.example.administrator.funtv.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.config.KeyConfig;
import com.hyphenate.chat.EMClient;

/**
 * Created by Administrator on 2017/4/5 0005.
 */

public class BaseActivity extends AppCompatActivity {

    public void openActivity(Class targetClass, Bundle bundle){
        Intent intent = new Intent(this,targetClass);
        if(bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    public void openActivity(Class targetClass){
        openActivity(targetClass,null);
    }
    public void openActivityAndClose(Class targetClass,Bundle bundle){
        openActivity(targetClass,bundle);
        finish();
    }
    public void openActivityAndClose(Class targetClass){
        openActivity(targetClass);
        finish();
    }
    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        //退出登录
//        PreferencesUtil.writeBoolean(this, KeyConfig.KEY_ISLOGIN,false);
//        PreferencesUtil.writeString(this,KeyConfig.KEY_USERNAME,"点击登录");
//        //退出环信登陆
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                EMClient.getInstance().logout(true);
//            }
//        }).start();
        System.gc();
    }



}
