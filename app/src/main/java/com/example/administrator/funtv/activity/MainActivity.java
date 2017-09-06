package com.example.administrator.funtv.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.base.BaseFragment;
import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.fragment.lanmu.LanmuFragment;
import com.example.administrator.funtv.fragment.shouye.ShouyeFragment;
import com.example.administrator.funtv.fragment.wode.WodeFragment;
import com.example.administrator.funtv.fragment.zhibo.ZhiboFragment;
import com.hyphenate.chat.EMClient;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private List<BaseFragment>  list_fragment;
    private Context context=this;

    @BindView(R.id.main_tab_group)
    RadioGroup mainTabGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
        list_fragment = new ArrayList<>();
        list_fragment.add(new ShouyeFragment());
        list_fragment.add(new ZhiboFragment());
        list_fragment.add(new LanmuFragment());
        list_fragment.add(new WodeFragment());
        for(int i=0;i<list_fragment.size();i++){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_layout,list_fragment.get(i),"BaseFragment"+i)
                    .show(list_fragment.get(0))
                    .hide(list_fragment.get(i))
                    .commit();
        }



    }

    private void initView() {
        mainTabGroup.check(R.id.btn_shouye);//默认选择项
        mainTabGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for(int j =0;j<list_fragment.size();j++){
                    getSupportFragmentManager().beginTransaction()
                            .hide(list_fragment.get(j))
                            .commit();
                }
                switch (i){
                    case R.id.btn_shouye:
                        getSupportFragmentManager().beginTransaction()
                                .show(list_fragment.get(0))
                                .commit();
                        break;
                    case  R.id.btn_zhibo:
                        getSupportFragmentManager().beginTransaction()
                                .show(list_fragment.get(1))
                                .commit();
                        break;
                    case R.id.btn_guanzhu:
                        getSupportFragmentManager().beginTransaction()
                                .show(list_fragment.get(2))
                                .commit();
                        break;
                    case R.id.btn_wode:
                        getSupportFragmentManager().beginTransaction()
                                .show(list_fragment.get(3))
                                .commit();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferencesUtil.writeBoolean(this,KeyConfig.KEY_ISLOGIN,false);
    }
}
