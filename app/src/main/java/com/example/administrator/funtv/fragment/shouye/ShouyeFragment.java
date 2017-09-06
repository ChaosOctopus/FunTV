package com.example.administrator.funtv.fragment.shouye;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.PindaoSettingActivity;
import com.example.administrator.funtv.adapter.PindaoFragmentAdapter;
import com.example.administrator.funtv.base.BaseFragment;
import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.contract.AppContracts;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.fragment.shouye.other.OtherFragment;
import com.example.administrator.funtv.fragment.shouye.tuijian.TuijianFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends BaseFragment implements AppContracts.IShouyeView {

    @BindView(R.id.pindao_setting_btn)
    ImageView pindaoSettingBtn;
    @BindView(R.id.loading_iv)
    ImageView loadingIv;
    @BindView(R.id.fragment_vp)
    ViewPager fragmentVp;
    @BindView(R.id.pindao_tablayout)
    TabLayout pindaoTablayout;
    private ShouyePresenterImpl shouyePresenter;
    private List<String> pindao; //频道名称
    private ShouyeBean shouyebean;
    //频道设置画面的请求
    public static final int PINDAO_SETTING_CODE = 100;
    private List<BaseFragment> pindaofragment;

    private PindaoFragmentAdapter pindaoFragmentAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        ButterKnife.bind(this, view);
        initData();//初始化频道
        initView();
        shouyePresenter = new ShouyePresenterImpl(this);
        shouyePresenter.getData();

        return view;
    }

    private void initView() {
        pindaoFragmentAdapter = new PindaoFragmentAdapter(getChildFragmentManager(), pindaofragment,pindao);
        fragmentVp.setAdapter(pindaoFragmentAdapter);
        pindaoTablayout.setupWithViewPager(fragmentVp);
        //设置超频数量


    }

    private void initData() {
        pindao = new ArrayList<>();
        pindaofragment = new ArrayList<>();

    }


    @Override
    public void showLoading() {
//        loadingIv.setVisibility(View.VISIBLE);
    }

    @Override
    public void disLoading() {
//       loadingIv.setVisibility(View.GONE);
    }

    @Override
    public void loadSuccess(ShouyeBean shouyeBean) {
        this.shouyebean = shouyeBean;
        initPindao();
        initFragment();
        //刷新数据
        pindaoFragmentAdapter.notifyDataSetChanged();
        fragmentVp.setOffscreenPageLimit(pindaofragment.size()-1);
    }


    @Override
    public void loadFail(String error) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //重新加载Tab信息
        initPindao();
        //加载Fragment
        initFragment();
        //重新刷新画面
        pindaoFragmentAdapter.notifyDataSetChanged();
        fragmentVp.setOffscreenPageLimit(pindaofragment.size()-1);
    }

    //加载Fragment
    private void initFragment() {
        //不论是否是首次启动，推荐也始终保留
        if (pindaofragment.size() == 0) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(KeyConfig.KEY_TUIJIAN_DATA,shouyebean);
            TuijianFragment tuijianFragment = new TuijianFragment();
            tuijianFragment.setArguments(bundle);
            pindaofragment.add(tuijianFragment);
        }
        //清空原有数据
        int size = pindaofragment.size();
        for (int i = 1; i < size; i++) {
            pindaofragment.remove(1);
        }
        //放入Share中除了首页之外的其他fragment
        for (int i = 1; i < pindao.size(); i++) {
            OtherFragment otherFragment =new OtherFragment();
            Bundle bundle = new Bundle();
            bundle.putString(KeyConfig.KEY_OTHER_CATEGORY,shouyebean.getRoom().get(i).getSlug());
            otherFragment.setArguments(bundle);
            pindaofragment.add(otherFragment);
        }


    }

    //加载频道信息,用的SharePreference
    private void initPindao() {
        //判断是否是首次运行
        String savePindao = PreferencesUtil.getString(getActivity(), KeyConfig.KEY_PINDAO_DATA, "");
        if (TextUtils.isEmpty(savePindao)) { //为空 首次运行
            List<ShouyeBean.RoomBean> room = shouyebean.getRoom();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < 7; i++) {
                buffer.append(room.get(i).getName());
                if (i != 6) {
                    buffer.append("#");
                }
                pindao.add(room.get(i).getName());
            }
            //保存到Share
            PreferencesUtil.writeString(getActivity(), KeyConfig.KEY_PINDAO_DATA, buffer.toString());

        } else {//非首次运行，把已有的数据清空
            pindao.clear();

            //根据#号拆分字符串(split),并将拆分后的数据加入集合(Collections)
            Collections.addAll(pindao, savePindao.split("#"));

        }
    }

    @OnClick(R.id.pindao_setting_btn)
    public void onClick() {
        Intent intent = new Intent(getActivity(), PindaoSettingActivity.class);
        intent.putExtra(KeyConfig.KEY_SHOUYE_DATA, shouyebean);
        startActivityForResult(intent, PINDAO_SETTING_CODE);
    }
}
