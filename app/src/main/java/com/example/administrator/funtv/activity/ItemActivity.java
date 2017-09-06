package com.example.administrator.funtv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.adapter.OtherAdapter;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.entity.OtherBean;
import com.example.administrator.funtv.fragment.shouye.other.OtherPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ItemActivity extends BaseActivity implements AppContracts.IOtherView {

    @BindView(R.id.item_toolbar_back)
    ImageView itemToolbarBack;
    @BindView(R.id.item_toolbar_title)
    TextView itemToolbarTitle;
    @BindView(R.id.item_rv)
    RecyclerView itemRv;
    @BindView(R.id.item_sr)
    SwipeRefreshLayout itemSr;
    private String item_name, item_sulg;
    private OtherPresenterImpl otherPresenter;
    private List<OtherBean.DataBean> otherDatas;
    private OtherAdapter otherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        initData();
        initView();

    }

    private void initData() {
        Intent intent = getIntent();
        String slug = intent.getStringExtra(KeyConfig.KEY_SLUG);
        String name = intent.getStringExtra(KeyConfig.KEY_SLUG_NAME);
        item_name = name;
        item_sulg = slug;
        otherPresenter = new OtherPresenterImpl(this);
        otherDatas = new ArrayList<>();
        otherPresenter.getData(item_sulg);
        itemSr.setColorSchemeResources(R.color.main);
        itemSr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                otherPresenter.getData(item_sulg);
            }
        });

    }


    private void initView() {
        itemToolbarTitle.setText(item_name);
        otherAdapter = new OtherAdapter(otherDatas, this);
        itemRv.setAdapter(otherAdapter);
        itemRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        itemRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                String stream = otherDatas.get(position).getUid();
                String format = String.format(UrlConfigs.PlAY_URL, stream);
                String icon = otherDatas.get(position).getAvatar();
                String nick = otherDatas.get(position).getNick();
                String title = otherDatas.get(position).getTitle();
                Intent intent = new Intent(ItemActivity.this, PlayActivity.class);
                intent.putExtra(KeyConfig.KEY_ADDRESS_STEAM,format);
                intent.putExtra(KeyConfig.KEY_ICON,icon);
                intent.putExtra(KeyConfig.KEY_NICK,nick);
                intent.putExtra(KeyConfig.KEY_TITLE,title);
                intent.putExtra(KeyConfig.KEY_UID,stream);
                startActivity(intent);
            }
        });

    }

    @OnClick(R.id.item_toolbar_back)
    public void onClick() {
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void disLoading() {

    }

    @Override
    public void loadSuccess(OtherBean otherBean) {
        otherDatas.clear();
        otherDatas.addAll(otherBean.getData());
        otherAdapter.notifyDataSetChanged();
        itemSr.setRefreshing(false);
    }

    @Override
    public void loadFail(String error) {

    }
}
