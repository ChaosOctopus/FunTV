package com.example.administrator.funtv.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.funtv.R;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.base.BaseApplication;
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.db.UserDao;
import com.example.administrator.funtv.entity.User;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_back)
    ImageView registerBack;
    @BindView(R.id.register_username)
    EditText registerUsername;
    @BindView(R.id.register_password)
    EditText registerPassword;
    @BindView(R.id.register_password_again)
    EditText registerPasswordAgain;
    @BindView(R.id.register_btn)
    Button registerBtn;
    @BindView(R.id.activity_register)
    LinearLayout activityRegister;
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {

    }

    private void initData() {

    }

    @OnClick({R.id.register_back, R.id.register_username, R.id.register_password, R.id.register_password_again, R.id.register_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_back:
                finish();
                break;
            case R.id.register_username:
                break;
            case R.id.register_password:
                break;
            case R.id.register_password_again:
                break;
            case R.id.register_btn:
                if(registerUsername.getText().toString().isEmpty()){
                    ToastUtils.showTost(this,"用户名不能为空");
                    return;
                }else if (registerPassword.getText().toString().isEmpty()){
                    ToastUtils.showTost(this,"密码不能为空");
                    return;
                }else if(registerPasswordAgain.getText().toString().isEmpty()){
                    ToastUtils.showTost(this,"确认密码不能为空");
                    return;
                }else if(!registerPassword.getText().toString().equals(registerPasswordAgain.getText().toString())){
                    ToastUtils.showTost(this,"密码不一致");
                    return;
                }
                //bmob根据用户名查询账号是否被注册，注册账号，并且保存在greenDao
                BmobQuery<User> bmobQuery = new BmobQuery<>();
                bmobQuery.addWhereEqualTo("name",registerUsername.getText().toString());
                bmobQuery.findObjects(new FindListener<User>() {
                    @Override
                    public void done(List<User> list, BmobException e) {
                        //未注册过 ，可以注册的账号
                        if(list.size()==0){
                            //现将信息保存在GreenDao数据库
                            UserDao userDao = BaseApplication.instances.getDaoSession().getUserDao();
                            User user = new User(null,registerUsername.getText().toString(),registerPassword.getText().toString(),null);
                            userDao.insert(user);
                            //将用户保存在bmob上
                            user.save(new SaveListener<String>() {
                                @Override
                                public void done(String s, BmobException e) {

                                }
                            });
                            //开启异步任务，在账号注册成功时，一并注册环信账号
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        EMClient.getInstance().createAccount(registerUsername.getText().toString(), "123");
                                    } catch (HyphenateException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }).start();
                            ToastUtils.showTost(context,"注册成功");
                            finish();

                        }else{
                            ToastUtils.showTost(context,"此账号已被注册过");
                        }
                    }
                });

                break;
        }
    }
}
