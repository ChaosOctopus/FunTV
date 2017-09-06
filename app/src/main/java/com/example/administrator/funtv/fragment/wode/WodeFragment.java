package com.example.administrator.funtv.fragment.wode;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.GuanzhuActivity;
import com.example.administrator.funtv.activity.HistoryActivity;
import com.example.administrator.funtv.activity.LoginActivity;
import com.example.administrator.funtv.base.BaseFragment;
import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class WodeFragment extends BaseFragment {


    @BindView(R.id.iv_mine_fragment)
    ImageView ivMineFragment;
    @BindView(R.id.text_dianji_myfragment)
    TextView textDianjiMyfragment;
    @BindView(R.id.linear_center_mine)
    LinearLayout linearCenterMine;
    @BindView(R.id.linear2_mine)
    LinearLayout linear2Mine;
    @BindView(R.id.linear3_mine)
    LinearLayout linear3Mine;
    //用户名字
    private String username;
    //是否登录
    private boolean isLogin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_wode, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    private void initData() {

        //我的关注
        linear2Mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLogin){
                    Intent intent = new Intent(getActivity(), GuanzhuActivity.class);
                    startActivity(intent);
                }else{
                    ToastUtils.showTost(getActivity(),"请先登录");
                }

            }
        });
        //观看历史
        linear3Mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {

    }

    @Override
    public void onResume() {
        super.onResume();
        username=PreferencesUtil.getString(getActivity(), KeyConfig.KEY_USERNAME, null);
        isLogin=PreferencesUtil.getBoolean(getActivity(),KeyConfig.KEY_ISLOGIN,false);
        if (isLogin){
            textDianjiMyfragment.setText(username);
        }else{
            textDianjiMyfragment.setText("点击登录");
        }

        Log.e("TAG", "onResume: "+username );
    }

    @OnClick(R.id.iv_mine_fragment)
    public void onClick() {
        isLogin=PreferencesUtil.getBoolean(getActivity(),KeyConfig.KEY_ISLOGIN,false);
        if(isLogin){
            initDailog();

        }else{
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }

    }
    //退出登录
    private void initDailog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("确认退出登陆吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                textDianjiMyfragment.setText("点击登录");
                //退出环信登陆
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EMClient.getInstance().logout(true);
                    }
                }).start();
                PreferencesUtil.writeBoolean(getActivity(),KeyConfig.KEY_ISLOGIN,false);
                ToastUtils.showTost(getActivity(),"已退出登录");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
