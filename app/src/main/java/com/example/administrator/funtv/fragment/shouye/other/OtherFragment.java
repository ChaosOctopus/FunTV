package com.example.administrator.funtv.fragment.shouye.other;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.PlayActivity;
import com.example.administrator.funtv.adapter.OtherAdapter;
import com.example.administrator.funtv.base.BaseFragment;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.entity.OtherBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 其他频道
 */
public class OtherFragment extends BaseFragment implements AppContracts.IOtherView {
    @BindView(R.id.other_rv)
    RecyclerView otherRv;
    @BindView(R.id.refreshlayout)
    SwipeRefreshLayout refreshlayout;
    private boolean isLoading;
    private OtherPresenterImpl otherPresenter;
    private String category;
    private OtherAdapter otheradapter;
    private List<OtherBean.DataBean> otherDatas;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_other, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView() {

        otheradapter = new OtherAdapter(otherDatas, getActivity());
        otherRv.setAdapter(otheradapter);
        otherRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        otherRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                String uid = otherDatas.get(position).getUid();
                String stream = otherDatas.get(position).getStream();
                String avatar = otherDatas.get(position).getAvatar();
                String title = otherDatas.get(position).getTitle();
                String nick = otherDatas.get(position).getNick();
                Intent intent = new Intent(getActivity(), PlayActivity.class);
                intent.putExtra(KeyConfig.KEY_ADDRESS_STEAM,stream);
                intent.putExtra(KeyConfig.KEY_ICON,avatar);
                intent.putExtra(KeyConfig.KEY_NICK,nick);
                intent.putExtra(KeyConfig.KEY_TITLE,title);
                intent.putExtra(KeyConfig.KEY_UID,uid);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        otherPresenter = new OtherPresenterImpl(this);
        otherDatas = new ArrayList<>();
        category = getArguments().getString(KeyConfig.KEY_OTHER_CATEGORY);
        refreshlayout.setColorSchemeResources(R.color.main);
        refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                otherPresenter.getData(category);
            }
        });
    }


    //实现懒加载,当fragment可见和不可见的时候都会触发一次
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isLoading) {
            isLoading = true; //取数据成功只去一次数据

            otherPresenter.getData(category);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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
        otheradapter.notifyDataSetChanged();

        //刷新状态恢复
        refreshlayout.setRefreshing(false);

    }

    @Override
    public void loadFail(String error) {

    }
}
