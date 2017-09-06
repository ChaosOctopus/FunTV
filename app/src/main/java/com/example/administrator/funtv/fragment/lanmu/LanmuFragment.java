package com.example.administrator.funtv.fragment.lanmu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.ItemActivity;
import com.example.administrator.funtv.adapter.LanmuAdapter;
import com.example.administrator.funtv.base.BaseFragment;
import com.example.administrator.funtv.base.utils.LogUtils;
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.entity.LanmuBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanmuFragment extends BaseFragment implements AppContracts.ILanmuView {

    @BindView(R.id.rv_lanmu)
    RecyclerView rvLanmu;
    private LanmuPresenterImpl lanmuPresenter;
    private List<LanmuBean> lanmuDatas;
    private LanmuAdapter lanmuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lanmu, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    private void initView() {
        rvLanmu.setAdapter(lanmuAdapter);
        rvLanmu.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        rvLanmu.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                String slug = lanmuDatas.get(position).getSlug();
                String name = lanmuDatas.get(position).getName();
                Intent intent = new Intent(getActivity(), ItemActivity.class);
                intent.putExtra(KeyConfig.KEY_SLUG,slug);
                intent.putExtra(KeyConfig.KEY_SLUG_NAME,name);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        lanmuPresenter = new LanmuPresenterImpl(this);
        lanmuPresenter.getData();
        lanmuDatas = new ArrayList<>();
        lanmuAdapter = new LanmuAdapter(lanmuDatas,getActivity());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void disLoading() {

    }

    @Override
    public void loadSuccess(List<LanmuBean> lanmuBeen) {
        lanmuDatas.clear();
        lanmuDatas.addAll(lanmuBeen);
        lanmuAdapter.notifyDataSetChanged();
    }


    @Override
    public void loadFail(String error) {

    }
}
