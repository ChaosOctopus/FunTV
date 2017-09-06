package com.example.administrator.funtv.fragment.zhibo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.PlayActivity;
import com.example.administrator.funtv.adapter.OtherAdapter;
import com.example.administrator.funtv.adapter.ZhiboAdapter;
import com.example.administrator.funtv.base.BaseApplication;
import com.example.administrator.funtv.base.BaseFragment;
import com.example.administrator.funtv.base.utils.LogUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.entity.OtherBean;
import com.example.administrator.funtv.entity.ZhiboBean;
import com.example.administrator.funtv.fragment.shouye.other.OtherPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.utils.Log;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiboFragment extends BaseFragment implements AppContracts.IZhiboView {


    @BindView(R.id.zhibo_rv)
    RecyclerView zhiboRv;
    @BindView(R.id.zhibo_swiperefresh)
    SwipeRefreshLayout zhiboSwiperefresh;
    private boolean isLoading;
    private ZhiboAdapter zhiboadapter;
    private ZhiboPresenterImpl zhiboPresenter;
    private List<ZhiboBean.DataBeanX> zhiboDatas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhibo, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    private void initView() {
        zhiboadapter = new ZhiboAdapter(zhiboDatas,getActivity());
        zhiboRv.setAdapter(zhiboadapter);
        zhiboRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        zhiboRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                String stream = zhiboDatas.get(position).getUid();
                String format = String.format(UrlConfigs.PlAY_URL, stream);
                String icon = zhiboDatas.get(position).getAvatar();
                String title = zhiboDatas.get(position).getTitle();
                String nick = zhiboDatas.get(position).getNick();
                Intent intent = new Intent(getActivity(), PlayActivity.class);
                intent.putExtra(KeyConfig.KEY_ADDRESS_STEAM,format);
                intent.putExtra(KeyConfig.KEY_ICON,icon);
                intent.putExtra(KeyConfig.KEY_NICK,nick);
                intent.putExtra(KeyConfig.KEY_TITLE,title);
                intent.putExtra(KeyConfig.KEY_UID,stream);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        zhiboPresenter = new ZhiboPresenterImpl(this);
        zhiboPresenter.getData();
        zhiboDatas = new ArrayList<>();
        zhiboSwiperefresh.setColorSchemeResources(R.color.main);
        zhiboSwiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                zhiboPresenter.getData();
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void disLoading() {

    }
    //实现懒加载,当fragment可见和不可见的时候都会触发一次
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser&&!isLoading){
            isLoading = true;
            zhiboPresenter.getData();
        }
    }

    @Override
    public void loadSuccess(ZhiboBean zhiboBean) {
        BaseApplication baseApplication = (BaseApplication) getActivity().getApplication();
        baseApplication.setZhiboBean(zhiboBean);
        zhiboDatas.clear();
        zhiboDatas.addAll(zhiboBean.getData());
        zhiboadapter.notifyDataSetChanged();
        zhiboSwiperefresh.setRefreshing(false);
    }

    @Override
    public void loadFail(String error) {

    }
}
