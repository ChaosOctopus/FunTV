package com.example.administrator.funtv.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.adapter.ZhiboAdapter;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.base.BaseApplication;
import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.entity.ZhiboBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends BaseActivity {

    @BindView(R.id.iv_back_history)
    ImageView ivBackHistory;
    @BindView(R.id.history_rv)
    RecyclerView historyRv;
    @BindView(R.id.activity_history)
    LinearLayout activityHistory;
    private List<ZhiboBean.DataBeanX> zhiboDatas;
    private Context context = this;
    private ZhiboAdapter zhiboAdapter;
    private ZhiboBean zhiboBean;
    private List<String> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        initHistory();
        initView();
        initData();
    }

    private void initHistory() {
        history = new ArrayList<>();
        String string = PreferencesUtil.getString(this, KeyConfig.KEY_HISTORY, "");
        Collections.addAll(history, string.split("#"));
    }

    private void initData() {
        BaseApplication baseApplication = (BaseApplication) getApplication();
        zhiboBean = baseApplication.getZhiboBean();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int size = zhiboBean.getData().size();
                for (int i = 0; i < history.size(); i++) {
                    for (int j = 0; j < size; j++) {
                        if (history.get(i).equals(zhiboBean.getData().get(j).getUid())) {
                            zhiboDatas.add(zhiboBean.getData().get(j));
                            zhiboAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }).start();

        historyRv.setAdapter(zhiboAdapter);
        historyRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        zhiboAdapter.notifyDataSetChanged();
        historyRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                String stream = zhiboBean.getData().get(position).getUid();
                String format = String.format(UrlConfigs.PlAY_URL, stream);
                String icon = zhiboBean.getData().get(position).getAvatar();
                String title = zhiboBean.getData().get(position).getTitle();
                String nick = zhiboBean.getData().get(position).getNick();
                Intent intent = new Intent(context, PlayActivity.class);
                intent.putExtra(KeyConfig.KEY_ADDRESS_STEAM,format);
                intent.putExtra(KeyConfig.KEY_ICON,icon);
                intent.putExtra(KeyConfig.KEY_NICK,nick);
                intent.putExtra(KeyConfig.KEY_TITLE,title);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        zhiboDatas = new ArrayList<>();
        zhiboAdapter = new ZhiboAdapter(zhiboDatas, context);
    }

    @OnClick(R.id.iv_back_history)
    public void onClick() {
        finish();
    }
}
