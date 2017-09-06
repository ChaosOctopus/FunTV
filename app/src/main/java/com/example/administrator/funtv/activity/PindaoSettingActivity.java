package com.example.administrator.funtv.activity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.adapter.PindaoAdapter;
import com.example.administrator.funtv.adapter.PindaoOtherAdapter;
import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.entity.ShouyeBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PindaoSettingActivity extends AppCompatActivity {
    @BindView(R.id.back_btn)
    ImageView backBtn;
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.tishi_changyong)
    TextView tishiChangyong;
    @BindView(R.id.changyong_iv)
    RecyclerView changyongIv;
    @BindView(R.id.tishi_weiyong)
    TextView tishiWeiyong;
    @BindView(R.id.weiyong_iv)
    RecyclerView weiyongIv;
    @BindView(R.id.activity_pindao_setting)
    LinearLayout activityPindaoSetting;
    @BindView(R.id.control_btn)
    TextView controlBtn;
    private ShouyeBean shouyeBean;
    //常用频道
    private List<String> selectedPindao;
    private PindaoAdapter pindaoAdapter;


    //滑动删除的起始位置
    private String swipeStartPosition;

    //未选中的频道
    private List<String> otherPindao;
    private PindaoOtherAdapter pindaoOtherAdapter;


    //界面状态
    private boolean isEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindao_setting);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        //处理选中频道
        pindaoAdapter = new PindaoAdapter(selectedPindao);
        changyongIv.setAdapter(pindaoAdapter);
        changyongIv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        //处理未选中频道
        pindaoOtherAdapter = new PindaoOtherAdapter(otherPindao);
        weiyongIv.setAdapter(pindaoOtherAdapter);
        weiyongIv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //拖拽改变位置，滑动删除
        pindaoManager();
    }

    private void pindaoManager() {
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(pindaoAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(changyongIv);

        //开启拖拽
        pindaoAdapter.enableDragItem(itemTouchHelper, R.id.pindao_tv, true);
        pindaoAdapter.setOnItemDragListener(new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {

            }
        });

        //滑动删除
        pindaoAdapter.enableSwipeItem();
        pindaoAdapter.setOnItemSwipeListener(new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
                swipeStartPosition = selectedPindao.get(pos);
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
                if (pos == -1) {
                    otherPindao.add(swipeStartPosition);
                    pindaoOtherAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {

            }
        });
        weiyongIv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isEdit) {
                    selectedPindao.add(otherPindao.get(position));
                    otherPindao.remove(position);
                    pindaoAdapter.notifyDataSetChanged();
                    pindaoOtherAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        shouyeBean = (ShouyeBean) intent.getSerializableExtra(KeyConfig.KEY_SHOUYE_DATA);
        //获得选中频道
        selectedPindao = new ArrayList<>();
        String savePindao = PreferencesUtil.getString(this, KeyConfig.KEY_PINDAO_DATA, "");
        Collections.addAll(selectedPindao, savePindao.split("#"));
        selectedPindao.remove(0);
        //获得其他频道
        otherPindao = new ArrayList<>();
        for (ShouyeBean.RoomBean roomBean : shouyeBean.getRoom()) {
            String pindao = roomBean.getName();
            if (!savePindao.contains(pindao)) {
                otherPindao.add(pindao);
            }
        }
    }

    @OnClick({R.id.back_btn, R.id.control_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                //保存数据
                StringBuffer buffer = new StringBuffer();
                buffer.append("推荐");
                for (String pindao: selectedPindao) {
                    buffer.append("#" + pindao);
                }
                PreferencesUtil.writeString(this, KeyConfig.KEY_PINDAO_DATA, buffer.toString());
                finish();
                break;
            case R.id.control_btn:
                isEdit = !isEdit;
                if (isEdit) {//可编辑
                    controlBtn.setText("完成");
                    tishiChangyong.setVisibility(View.VISIBLE);
                    tishiWeiyong.setVisibility(View.VISIBLE);
                } else {
                    controlBtn.setText("管理");
                    tishiChangyong.setVisibility(View.GONE);
                    tishiWeiyong.setVisibility(View.GONE);
                }
                break;
        }
    }

}
