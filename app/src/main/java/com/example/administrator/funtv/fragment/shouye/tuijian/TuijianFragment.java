package com.example.administrator.funtv.fragment.shouye.tuijian;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.PlayActivity;
import com.example.administrator.funtv.adapter.AdAdapter;
import com.example.administrator.funtv.adapter.TuijianAdapter;
import com.example.administrator.funtv.base.BaseApplication;
import com.example.administrator.funtv.base.BaseFragment;
import com.example.administrator.funtv.base.utils.DensityUtil;
import com.example.administrator.funtv.base.utils.SizeUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.entity.ADBean;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.entity.TuijianBean;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 推荐页
 */
public class TuijianFragment extends BaseFragment {
    private TuijianAdapter tuijianadapter;
    @BindView(R.id.tuijian_rv)
    RecyclerView tuijianRv;
    private ShouyeBean shouyeBean;
    private List<TuijianBean> tuijianBean;

    //广告轮播View
    private RollPagerView adVp;
    private AdAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tuijian, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adVp.isPlaying()){
            adVp.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(adVp.isPlaying()){
            adVp.pause();
        }
    }

    private void initView() {
        tuijianadapter = new TuijianAdapter(tuijianBean,getActivity());
        tuijianRv.setAdapter(tuijianadapter);
        tuijianRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //广告条轮播
        adVp = new RollPagerView(getActivity());
        adVp.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(getActivity(),200)));
        adVp.setPlayDelay(3000);
        ADBean adbean = ((BaseApplication)getActivity().getApplication()).getAdBean();
        adapter = new AdAdapter(adVp,adbean,getActivity());
        adVp.setAdapter(adapter);
        tuijianadapter.addHeaderView(adVp);

        //添加item点击事件
        tuijianRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                int uid = tuijianBean.get(position).t.getUid();
                String stream = tuijianBean.get(position).t.getStream();
                String icon = tuijianBean.get(position).t.getAvatar();
                String nick = tuijianBean.get(position).t.getNick();
                String title = tuijianBean.get(position).t.getTitle();
                Intent intent = new Intent(getActivity(), PlayActivity.class);
                intent.putExtra(KeyConfig.KEY_ADDRESS_STEAM,stream);
                intent.putExtra(KeyConfig.KEY_ICON,icon);
                intent.putExtra(KeyConfig.KEY_NICK,nick);
                intent.putExtra(KeyConfig.KEY_TITLE,title);
                intent.putExtra(KeyConfig.KEY_UID,uid+"");
                startActivity(intent);
            }
        });
    }

    private void initData() {
        Bundle bundle = getArguments();
        shouyeBean = (ShouyeBean) bundle.getSerializable(KeyConfig.KEY_TUIJIAN_DATA);
        tuijianBean = new ArrayList<>();
        initTuijianBean();
    }
    private void initTuijianBean(){
        //获得所有频道
        List<ShouyeBean.RoomBean> pindaos = shouyeBean.getRoom();
        //只取前八个频道作为展示
        for(int i=0;i<8;i++){
            ShouyeBean.RoomBean pindao  = pindaos.get(i);
            //先放头布局
            TuijianBean tuijianHeader = new TuijianBean(true,pindao.getName());
            tuijianBean.add(tuijianHeader);
            //房间数据
            for(ShouyeBean.RoomBean.ListBean room:pindao.getList()){
                TuijianBean tuijianRoom = new TuijianBean(room);
                tuijianBean.add(tuijianRoom);
            }
        }
    }

}
