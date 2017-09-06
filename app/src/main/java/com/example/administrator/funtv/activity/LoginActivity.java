package com.example.administrator.funtv.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.funtv.R;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.base.BaseApplication;
import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.db.UserDao;
import com.example.administrator.funtv.entity.User;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;
    private Context content=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_back, R.id.login_register, R.id.login_username, R.id.login_password, R.id.login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.login_register:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_username:
                break;
            case R.id.login_password:
                break;
            case R.id.login_btn:
                if(loginUsername.getText().toString().isEmpty()){
                    ToastUtils.showTost(this,"账号不能为空");
                    return;
                }else if(loginPassword.getText().toString().isEmpty()){
                    ToastUtils.showTost(this,"密码不能为空");
                    return;
                }

                String username = loginUsername.getText().toString();
                //bmob根据用户名查询密码并登录
                BmobQuery<User> bmobQuery = new BmobQuery<>();
                bmobQuery.addWhereEqualTo("name",username);
                bmobQuery.findObjects(new FindListener<User>() {
                    @Override
                    public void done(List<User> list, BmobException e) {
                        if(list.size()!=0){
                            String psw = list.get(0).getPsw();
                            if(psw.equals(loginPassword.getText().toString())){
                                ToastUtils.showTost(content,"登陆成功");
                                //将用户信息存储到SharePreference
                                PreferencesUtil.writeString(content, KeyConfig.KEY_USERNAME,loginUsername.getText().toString());
                                PreferencesUtil.writeBoolean(content,KeyConfig.KEY_ISLOGIN,true);
                                //登录成功后，一并登录环信账号
//                                new Thread(new Runnable() {
//                                    @Override
//                                    public void run() {
//
//                                    }
//                                }).start();
                                EMClient.getInstance().login(loginUsername.getText().toString(), "123", new EMCallBack() {
                                    @Override
                                    public void onSuccess() {
                                        EMClient.getInstance().groupManager().loadAllGroups();
                                        EMClient.getInstance().chatManager().loadAllConversations();
                                        Log.e("main", "登录聊天服务器成功！");
                                    }

                                    @Override
                                    public void onError(int i, String s) {
                                        Log.e("main", "登录聊天服务器失败！");
                                    }

                                    @Override
                                    public void onProgress(int i, String s) {
                                    }
                                });
                                finish();
                            }else{
                                ToastUtils.showTost(content,"您输入的密码错误");
                            }

                        }else{
                            ToastUtils.showTost(content,"该账号未注册");
                        }

                    }
                });
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }
}
