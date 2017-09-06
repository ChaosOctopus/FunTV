package com.example.administrator.funtv.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
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
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.entity.User;
import com.example.administrator.funtv.entity.ZhiboBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class GuanzhuActivity extends BaseActivity {

    @BindView(R.id.iv_back_gaunzhu)
    ImageView ivBackGaunzhu;
    @BindView(R.id.guanzhu_rv)
    RecyclerView guanzhuRv;
    @BindView(R.id.activity_guanzhu)
    LinearLayout activityGuanzhu;
    private List<ZhiboBean.DataBeanX> zhiboDatas;
    private Context context = this;
    private String uid="1743331";
    private ZhiboAdapter zhiboAdapter;
    private ZhiboBean bean;
    private List<String> likeRoom;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0 :
                    List<User> obj = (List<User>)msg.obj;
                    if(!TextUtils.isEmpty(obj.get(0).getLike_room())){
                    String like_room = obj.get(0).getLike_room();
                    Collections.addAll(likeRoom, like_room.split("#"));
                    int size = bean.getData().size();
                    for (int i = 0; i < likeRoom.size(); i++) {
                        for (int j = 0; j < size; j++) {
                            if (likeRoom.get(i).equals(bean.getData().get(j).getUid())) {
                                zhiboDatas.add(bean.getData().get(j));
                                zhiboAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                }else{
                        zhiboDatas.clear();
                        zhiboAdapter.notifyDataSetChanged();
                    ToastUtils.showTost(context,"您还没有关注，请快关注吧~");
                }
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guanzhu);
        ButterKnife.bind(this);
        initGuanzhuData();
        initView();
        initData();
        initGuanzhu();
    }

    private void initGuanzhuData() {
        likeRoom = new ArrayList<>();
        String username = PreferencesUtil.getString(this, KeyConfig.KEY_USERNAME, "");
        BmobQuery<User> user = new BmobQuery<>();
        user.addWhereEqualTo("name",username);
        user.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if(e==null){
                    Message message = handler.obtainMessage();
                    message.what=0;
                    message.obj=list;
                    handler.sendMessage(message);
                }else{
                    ToastUtils.showTost(context,"您还未登录哦");
                }

            }
        });
    }

    private void initGuanzhu() {
        Log.e("TAG1111111", "initGuanzhu: "+likeRoom.size()+"");

//        zhiboAdapter.notifyDataSetChanged();
        guanzhuRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                String stream = bean.getData().get(position).getUid();
                String format = String.format(UrlConfigs.PlAY_URL, stream);
                String icon = bean.getData().get(position).getAvatar();
                String title = bean.getData().get(position).getTitle();
                String nick = bean.getData().get(position).getNick();
                Intent intent = new Intent(context, PlayActivity.class);
                intent.putExtra(KeyConfig.KEY_ADDRESS_STEAM,format);
                intent.putExtra(KeyConfig.KEY_ICON,icon);
                intent.putExtra(KeyConfig.KEY_NICK,nick);
                intent.putExtra(KeyConfig.KEY_TITLE,title);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        //从Application从获取ZHibobean
        BaseApplication baseApplication = (BaseApplication) getApplication();
        bean = baseApplication.getZhiboBean();
        guanzhuRv.setAdapter(zhiboAdapter);
        guanzhuRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        zhiboAdapter.notifyDataSetChanged();

    }

    private void initView() {
        zhiboDatas  = new ArrayList<>();
        zhiboAdapter = new ZhiboAdapter(zhiboDatas,this);

    }


    @OnClick(R.id.iv_back_gaunzhu)
    public void onClick() {
        finish();
    }

}
