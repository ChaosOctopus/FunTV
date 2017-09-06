package com.example.administrator.funtv.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.adapter.ChatAdapter;
import com.example.administrator.funtv.base.BaseActivity;
import com.example.administrator.funtv.base.utils.BitmapCircleTransformation;
import com.example.administrator.funtv.base.utils.DensityUtil;
import com.example.administrator.funtv.base.utils.PreferencesUtil;
import com.example.administrator.funtv.base.utils.ToastUtils;
import com.example.administrator.funtv.config.KeyConfig;
import com.example.administrator.funtv.config.UrlConfigs;
import com.example.administrator.funtv.entity.ChatBean;
import com.example.administrator.funtv.entity.User;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class PlayActivity extends BaseActivity {
    @BindView(R.id.video_view)
    VideoView videoView;
    @BindView(R.id.loading_iv)
    ImageView loadingIv;
    @BindView(R.id.iv_landscape_back)
    ImageView ivLandscapeBack;
    @BindView(R.id.tv_landscape_title)
    TextView tvLandscapeTitle;
    @BindView(R.id.iv_landscape_heart)
    ImageView ivLandscapeHeart;
    @BindView(R.id.tv_landscape_qxd)
    TextView tvLandscapeQxd;
    @BindView(R.id.tv_landscape_gift)
    TextView tvLandscapeGift;
    @BindView(R.id.rl_landscape_top)
    RelativeLayout rlLandscapeTop;
    @BindView(R.id.iv_landscape_pause)
    ImageView ivLandscapePause;
    @BindView(R.id.iv_landscape_refresh)
    ImageView ivLandscapeRefresh;
    @BindView(R.id.iv_landscape_commenting)
    ImageView ivLandscapeCommenting;
    @BindView(R.id.iv_landscape_hot)
    ImageView ivLandscapeHot;
    @BindView(R.id.et_landscape)
    EditText etLandscape;
    @BindView(R.id.iv_landscape_send)
    ImageView ivLandscapeSend;
    @BindView(R.id.rl_landscape_bottom)
    RelativeLayout rlLandscapeBottom;
    @BindView(R.id.play_new_rl)
    RelativeLayout playNewRl;
    @BindView(R.id.iv_model_back)
    ImageView ivModelBack;
    @BindView(R.id.iv_model_pause)
    ImageView ivModelPause;
    @BindView(R.id.iv_model_screen)
    ImageView ivModelScreen;
    @BindView(R.id.play_rl)
    RelativeLayout playRl;
    @BindView(R.id.iv_play_icon)
    ImageView ivPlayIcon;
    @BindView(R.id.tv_play_name)
    TextView tvPlayName;
    @BindView(R.id.tv_play_content)
    TextView tvPlayContent;
    @BindView(R.id.iv_play_guanzhu)
    ImageView ivPlayGuanzhu;
    @BindView(R.id.tv_play_guanzhu)
    TextView tvPlayGuanzhu;
    @BindView(R.id.ll_play)
    LinearLayout llPlay;
    @BindView(R.id.activity_play)
    LinearLayout activityPlay;
    @BindView(R.id.play_chat_rv)
    RecyclerView playChatRv;
    @BindView(R.id.chat_edit)
    EditText chatEdit;
    @BindView(R.id.chat_iv)
    ImageView chatIv;
    @BindView(R.id.edit_ll)
    LinearLayout editLl;
    @BindView(R.id.danmu_view)
    DanmakuView danmuView;
    private Context context = this;
    private String steam;//流地址
    private String icon;//头像
    private String nick;//昵称
    private String title;//房间题目
    private String uid;
    private Animation loadingAnimation;
    private MediaController mMediaController;
    private boolean isHint = true; //横屏状态栏控制开关
    private boolean isLogin;//判断是否登录过
    private boolean isGuanzhu = true;//判断是否关注
    private boolean isTixing = true;//判断是否提醒
    private TextView tv_bq, tv_gq, tv_cq;//定义三种清晰度
    private PopupWindow pw_qxd;
    private String username;//登录的用户名
    private List<String> guanzhu_list = new ArrayList<>();
    private List<String> cencel_list = new ArrayList<>();


    //休眠时间
    public static final int SLEEP_TIME = 3000;
    private long strat_time;
    //弹幕相关
    private boolean showDanmaku=true;
    private DanmakuContext danmakuContext;
    private String s;
    private IDanmakuView mDanmakuView;
    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };
    //即时聊天相关
    private ChatAdapter chatAdapter;
    private List<ChatBean> chatList = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private EMMessageListener msgListener;
    private EMMessage message;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    chatAdapter.notifyDataSetChanged();
                    chatEdit.setText("");
                    break;
                case 1:
                    String s = msg.obj.toString();
                    addDanmaku(s,false);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        initData();
        initView();
        initChat();
        initOtherChat();
        initHistory();//处理历史记录


    }

//    private void initGuanzhuShou() {
//        BmobQuery<User> user = new BmobQuery<>();
//        user.addWhereEqualTo("name", username);
//        user.findObjects(new FindListener<User>() {
//            @Override
//            public void done(List<User> list, BmobException e) {
//                String like_room = list.get(0).getLike_room();
//                if (e == null) {
//                    if (like_room != null) {
//                        Collections.addAll(guanzhu_list, like_room.split("#"));
//                        if (guanzhu_list.contains(uid)) {
//                            ivPlayGuanzhu.setImageResource(R.mipmap.btn_focus_selected);
//                            tvPlayGuanzhu.setText("已关注");
//                            isGuanzhu = false;
//                        } else {
//                            ivPlayGuanzhu.setImageResource(R.mipmap.btn_focus_normal);
//                            tvPlayGuanzhu.setText("关 注");
//                            isGuanzhu = true;
//                        }
//                    }
//                } else {
//                    return;
//                }
//
//            }
//        });
//    }

    //处理关注
    private void initGuanzhu() {

        BmobQuery<User> user = new BmobQuery<>();
        user.addWhereEqualTo("name", username);
        user.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null) {
                    StringBuffer buffer = new StringBuffer();
                    if (TextUtils.isEmpty(list.get(0).getLike_room())) {
                        buffer.append(uid);
                        list.get(0).setLike_room(buffer.toString());
                        list.get(0).update(new UpdateListener() {
                            @Override
                            public void done(BmobException e) {

                            }
                        });

                    } else {
                        String like_room = list.get(0).getLike_room();
                        buffer.append(like_room);
                        buffer.append("#");
                        buffer.append(uid);
                        list.get(0).setLike_room(buffer.toString());
                        list.get(0).update(new UpdateListener() {
                            @Override
                            public void done(BmobException e) {

                            }
                        });
                    }
                    ivPlayGuanzhu.setImageResource(R.mipmap.btn_focus_selected);
                    tvPlayGuanzhu.setText("已关注");
                    isGuanzhu = false;

                } else {
                    ToastUtils.showTost(context, "您还未登录哦~");
                }
            }
        });
    }

    //处理观看历史
    private void initHistory() {
        String history = PreferencesUtil.getString(this, KeyConfig.KEY_HISTORY, "");
        Log.e("TAG12345", "initHistory: " + history);
        StringBuffer buffer = new StringBuffer();
        //首次运行
        if (TextUtils.isEmpty(history)) {

            buffer.append(uid);
            PreferencesUtil.writeString(this, KeyConfig.KEY_HISTORY, buffer.toString());
        } else {
            //非首次运行
            buffer.append(history);
            buffer.append("#");
            buffer.append(uid);
            PreferencesUtil.writeString(this, KeyConfig.KEY_HISTORY, buffer.toString());
        }

    }

    private void initChat() {

        chatAdapter = new ChatAdapter(chatList, context);
        playChatRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        playChatRv.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();

    }


    @Override
    protected void onPause() {
        super.onPause();
        if (videoView.isPlaying()) {
            videoView.pause();
        }
        if (danmuView != null && danmuView.isPrepared()) {
            danmuView.pause();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!videoView.isPlaying()) {
            videoView.resume();
        }
        isLogin = PreferencesUtil.getBoolean(this, KeyConfig.KEY_ISLOGIN, false);
        username = PreferencesUtil.getString(this, KeyConfig.KEY_USERNAME, "");
        //同一群组其他人的消息
        initOtherChat();
        if (danmuView != null && danmuView.isPrepared() && danmuView.isPaused()) {
            danmuView.resume();
        }
        //监听edit输入，当有输入的时候手动去掉状态栏
//        initGuanzhuShou();

    }

    @Override
    protected void onStop() {
        super.onStop();
        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
    }

    //加入聊天组
    private void initSameGroup() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().groupManager().joinGroup("17882954137601");
                    Log.e("TAG", "加入群组成功");
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    Log.e("TAG", "加入群组失败");
                }
            }
        }).start();


    }

    //收到其他用户发来的消息
    private void initOtherChat() {
        //TODO 群组消息接收不到
        EMClient.getInstance().chatManager().addMessageListener(msgListener);
        msgListener = new EMMessageListener() {

            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                //收到消息
                Log.e("TAG12344", "收到消息 ");
                for (int i = 0; i < messages.size(); i++) {
                    EMMessage message = messages.get(i);
                    String from = message.getFrom();
                    if (message.getType() == EMMessage.Type.TXT) {
                        EMTextMessageBody body = (EMTextMessageBody) message.getBody();
                        ChatBean bean = new ChatBean(message.getUserName(), body.getMessage());
                        chatList.add(bean);
                        handler.sendEmptyMessage(0);
                        Message msg = new Message();
                        msg.what=1;
                        msg.obj=body.getMessage();
                        handler.sendMessage(msg);
                    }
                }
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {
                //收到透传消息
            }

            @Override
            public void onMessageRead(List<EMMessage> messages) {
                //收到已读回执
            }

            @Override
            public void onMessageDelivered(List<EMMessage> message) {
                //收到已送达回执
            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {
                //消息状态变动
            }
        };

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
        //退出聊天室
        leaveGroup();
        //注销监听
        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
        chatList.clear();
        showDanmaku = false;
        if (danmuView!= null) {
            danmuView.release();
            danmuView = null;
        }
    }

    private void leaveGroup() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().groupManager().leaveGroup("17882954137601");//需异步处理
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void initView() {
        //设置标题
        tvLandscapeTitle.setText(title);
        //设置头像
        Glide.with(this).load(icon).transform(new BitmapCircleTransformation(this)).into(ivPlayIcon);
        //设置昵称
        tvPlayName.setText(nick);
        //设置题目
        tvPlayContent.setText(title);
        //初始化载入动画
        loadingAnimation = AnimationUtils.loadAnimation(this, R.anim.zairu);
        //设置匀速旋转，在xml文件中设置会出现卡顿
        LinearInterpolator interpolator = new LinearInterpolator();
        loadingAnimation.setInterpolator(interpolator);
        loadingIv.startAnimation(loadingAnimation);

        //判断vitamio是否初始化成功
        if (!Vitamio.isInitialized(this)) {
            return;
        }
        videoView.setVideoURI(Uri.parse(steam));
        videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        videoView.setBufferSize(1024);
        videoView.requestFocus();
        mMediaController = new MediaController(this);
        mMediaController.show(5000);
        mMediaController.setVisibility(View.INVISIBLE);
        videoView.setMediaController(mMediaController);
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START://缓冲开始的时候
                        loadingIv.startAnimation(loadingAnimation);
                        Log.e("TAG66666", "onInfo: 666666666666");
                        loadingIv.setVisibility(View.VISIBLE);
                        mp.pause();
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END://缓冲结束的时候
                        loadingIv.setVisibility(View.GONE);
                        Log.e("TAG55555", "onInfo: 555555555");
                        loadingIv.clearAnimation();
                        mp.start();
                        break;
                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                        break;
                }
                return true;
            }
        });
        danmuView.enableDanmakuDrawingCache(true);
        danmuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                showDanmaku = true;
                danmuView.start();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });
        danmakuContext = DanmakuContext.create();
        danmuView.prepare(parser, danmakuContext);

    }


    private void initData() {
        Intent intent = getIntent();
        steam = intent.getStringExtra(KeyConfig.KEY_ADDRESS_STEAM);
        icon = intent.getStringExtra(KeyConfig.KEY_ICON);
        nick = intent.getStringExtra(KeyConfig.KEY_NICK);
        title = intent.getStringExtra(KeyConfig.KEY_TITLE);
        uid = intent.getStringExtra(KeyConfig.KEY_UID);
        //加入同一群组
        initSameGroup();

    }
    private void addDanmaku(String content, boolean withBorder) {
        BaseDanmaku danmaku = danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        danmaku.text = content;
        danmaku.padding = 5;
        danmaku.textColor = Color.WHITE;
        danmaku.textSize=25f * (parser.getDisplayer().getDensity() - 0.6f);
        danmaku.setTime(danmuView.getCurrentTime());
        if (withBorder) {
            danmaku.borderColor = Color.GREEN;
        }
        danmuView.addDanmaku(danmaku);
    }


    @OnClick({R.id.iv_landscape_back, R.id.iv_landscape_heart, R.id.tv_landscape_qxd, R.id.tv_landscape_gift, R.id.iv_landscape_pause, R.id.iv_landscape_refresh, R.id.iv_landscape_commenting, R.id.iv_landscape_hot, R.id.iv_landscape_send, R.id.iv_model_back, R.id.iv_model_pause, R.id.iv_model_screen, R.id.iv_play_guanzhu, R.id.chat_iv})
    public void onClick(View view) {
        switch (view.getId()) {
            //将横屏切换为竖屏
            case R.id.iv_landscape_back:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                break;
            case R.id.iv_landscape_heart:
                break;
            //切换清晰度
            case R.id.tv_landscape_qxd:
                View inflate = LayoutInflater.from(context).inflate(R.layout.item_qxd, null);
                tv_bq = (TextView) inflate.findViewById(R.id.tv_bq);
                tv_gq = (TextView) inflate.findViewById(R.id.tv_gq);
                tv_cq = (TextView) inflate.findViewById(R.id.tv_cq);
                tv_bq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvLandscapeQxd.setText("标清");
                        tv_bq.setTextColor(Color.RED);
                        tv_gq.setTextColor(Color.GRAY);
                        tv_cq.setTextColor(Color.GRAY);
                        String format = String.format(UrlConfigs.PLAY_URL_BQ, steam);
                        videoView.setVideoPath(format);
                        videoView.start();
                        pw_qxd.dismiss();
                    }
                });
                tv_gq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvLandscapeQxd.setText("高清");
                        tv_bq.setTextColor(Color.GRAY);
                        tv_gq.setTextColor(Color.RED);
                        tv_cq.setTextColor(Color.GRAY);
                        String format = String.format(UrlConfigs.PLAY_URL_GQ, steam);
                        videoView.setVideoPath(format);
                        videoView.start();
                        pw_qxd.dismiss();
                    }
                });
                tv_cq.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvLandscapeQxd.setText("超清");
                        tv_bq.setTextColor(Color.GRAY);
                        tv_gq.setTextColor(Color.GRAY);
                        tv_cq.setTextColor(Color.RED);
                        videoView.setVideoPath(steam);
                        videoView.start();
                        pw_qxd.dismiss();
                    }
                });

                pw_qxd = new PopupWindow(inflate,
                        ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT, true);
                pw_qxd.setTouchable(true);
                pw_qxd.showAsDropDown(view);
                break;
            case R.id.tv_landscape_gift:
                break;
            //横屏暂停按钮
            case R.id.iv_landscape_pause:
                if (videoView.isPlaying()) {
                    videoView.pause();
                    ivLandscapePause.setImageResource(R.mipmap.play_unpressed);
                } else {
                    videoView.start();
                    ivLandscapePause.setImageResource(R.mipmap.pause_unpressed);
                }
                break;
            case R.id.iv_landscape_refresh:
                if (videoView.isPlaying()) {
                    videoView.pause();
                    videoView.setVideoURI(Uri.parse(steam));
                    videoView.start();
                }
                break;
            case R.id.iv_landscape_commenting:
                if (showDanmaku){
                    ivLandscapeCommenting.setImageResource(R.mipmap.fullscreen_close_commenting_unpressed);
                    danmuView.clear();
                    danmuView.pause();
                    ToastUtils.showTost(context,"弹幕已关闭");
                    showDanmaku=false;
                }else{
                    ivLandscapeCommenting.setImageResource(R.mipmap.commenting_unpressed);
                    danmuView.start();
                    ToastUtils.showTost(context,"弹幕已开启");
                    showDanmaku=true;
                }
                break;
            case R.id.iv_landscape_hot:
                break;
            //横屏发送
            case R.id.iv_landscape_send:
                if (isLogin) {
                    //如果登陆了
                    if (!etLandscape.getText().toString().isEmpty()) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
                                message = EMMessage.createTxtSendMessage(etLandscape.getText().toString(), "17882954137601");
                                //设置为群聊
                                message.setChatType(EMMessage.ChatType.GroupChat);
                                EMClient.getInstance().chatManager().sendMessage(message);
                                message.setMessageStatusCallback(new EMCallBack() {
                                    @Override
                                    public void onSuccess() {
                                        String username = PreferencesUtil.getString(context, KeyConfig.KEY_USERNAME, null);
                                        ChatBean bean = new ChatBean(username, etLandscape.getEditableText().toString());
                                        chatList.add(bean);
                                        handler.sendEmptyMessage(0);
                                        Log.e("TAGGGGGG", "onSuccess: " + bean.getUsername());
                                        addDanmaku(etLandscape.getText().toString(),true);

                                    }

                                    @Override
                                    public void onError(int i, String s) {
                                        Log.e("TAG", "onError: " + s);
                                    }

                                    @Override
                                    public void onProgress(int i, String s) {
                                        Log.e("TAG", "onProgress: " + s);
                                    }
                                });

                            }
                        }).start();
                    }

                } else {
                    //如果未登录跳转到登录界面
                    Intent intent = new Intent(PlayActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            //竖屏时候的返回按钮
            case R.id.iv_model_back:
                finish();
                break;
            //竖屏时候的暂停按钮
            case R.id.iv_model_pause:
                if (videoView.isPlaying()) {
                    videoView.pause();
                    ivModelPause.setImageResource(R.mipmap.btn_live_play);
                } else {
                    videoView.start();
                    ivModelPause.setImageResource(R.mipmap.btn_live_pause);
                }
                break;
            //竖屏时候的全屏按钮，将屏幕切换到横屏
            case R.id.iv_model_screen:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case R.id.iv_play_guanzhu:
                if (isLogin == true) {
                    if (isGuanzhu) {
                        ivPlayGuanzhu.setImageResource(R.mipmap.btn_focus_selected);
                        tvPlayGuanzhu.setText("已关注");
                        ToastUtils.showTost(context, "关注成功");
                        initGuanzhu();//处理关注
//                        initGuanzhuShou();//处理关注按钮
                        isGuanzhu = false;
                    } else {
                        ivPlayGuanzhu.setImageResource(R.mipmap.btn_focus_normal);
                        tvPlayGuanzhu.setText("关 注");
                        ToastUtils.showTost(context, "已取消关注");
                        initQuxiaoChuanzhu();//取消关注
//                        initGuanzhuShou();//处理关注按钮
                        isGuanzhu = true;
                    }

                } else {
                    ToastUtils.showTost(context, "登录后才可以关注~");
                }

                break;

            case R.id.chat_iv:

                if (isLogin) {
                    //如果登陆了
                    if (!chatEdit.getText().toString().isEmpty()) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
                                message = EMMessage.createTxtSendMessage(chatEdit.getText().toString(), "17882954137601");
                                //设置为群聊
                                message.setChatType(EMMessage.ChatType.GroupChat);
                                EMClient.getInstance().chatManager().sendMessage(message);
                                message.setMessageStatusCallback(new EMCallBack() {
                                    @Override
                                    public void onSuccess() {
                                        String username = PreferencesUtil.getString(context, KeyConfig.KEY_USERNAME, null);
                                        ChatBean bean = new ChatBean(username, chatEdit.getEditableText().toString());
                                        chatList.add(bean);
                                        handler.sendEmptyMessage(0);
                                        Log.e("TAGGGGGG", "onSuccess: " + bean.getUsername());
                                        addDanmaku(chatEdit.getText().toString(),true);

                                    }

                                    @Override
                                    public void onError(int i, String s) {
                                        Log.e("TAG", "onError: " + s);
                                    }

                                    @Override
                                    public void onProgress(int i, String s) {
                                        Log.e("TAG", "onProgress: " + s);
                                    }
                                });

                            }
                        }).start();
                    }

                } else {
                    //如果未登录跳转到登录界面
                    Intent intent = new Intent(PlayActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

                break;
        }
    }

    private void initQuxiaoChuanzhu() {
        BmobQuery<User> user = new BmobQuery<>();
        user.addWhereEqualTo("name", username);
        user.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (e == null) {
                    String like_room = list.get(0).getLike_room();
                    Collections.addAll(cencel_list, like_room.split("#"));
                    if (cencel_list.contains(uid)) {
                        cencel_list.remove(uid);
                    }
                    StringBuffer buffer = new StringBuffer();
                    for (int i = 0; i < cencel_list.size(); i++) {
                        buffer.append(cencel_list.get(i));

                        if (i != cencel_list.size() - 1) {
                            buffer.append("#");
                        }
                    }
                    list.get(0).setLike_room(buffer.toString());
                    list.get(0).update(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {

                        }
                    });
                    ivPlayGuanzhu.setImageResource(R.mipmap.btn_focus_normal);
                    tvPlayGuanzhu.setText("关 注");
                    isGuanzhu = false;
                } else {
                    ToastUtils.showTost(context, "您还未登录哦~");
                }
            }
        });
    }


    //屏幕横竖屏切换相关
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果屏幕状态为横屏
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            llPlay.setVisibility(View.GONE);
            ivModelBack.setVisibility(View.GONE);
            ivModelPause.setVisibility(View.GONE);
            ivModelScreen.setVisibility(View.GONE);
            rlLandscapeTop.setVisibility(View.GONE);
            rlLandscapeBottom.setVisibility(View.GONE);
            editLl.setVisibility(View.GONE);
            playChatRv.setVisibility(View.GONE);
            //动态获取屏幕宽高
            int widthPixels = getResources().getDisplayMetrics().widthPixels;
            int heightPixels = getResources().getDisplayMetrics().heightPixels;
            ViewGroup.LayoutParams layoutParams = playNewRl.getLayoutParams();
            layoutParams.height = heightPixels;
            layoutParams.width = widthPixels;
            playNewRl.setLayoutParams(layoutParams);
            videoView.setLayoutParams(layoutParams);
            //当点击屏幕的时候出现操作栏
            videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (isHint) {
                        rlLandscapeTop.setVisibility(View.VISIBLE);
                        rlLandscapeBottom.setVisibility(View.VISIBLE);
                        isHint = false;
                        strat_time = System.currentTimeMillis();
                    } else {
                        rlLandscapeTop.setVisibility(View.GONE);
                        rlLandscapeBottom.setVisibility(View.GONE);
                        isHint = true;

                    }

                    return false;
                }
            });

        }
        //屏幕状态为竖屏
        else {
            llPlay.setVisibility(View.VISIBLE);
            ivModelBack.setVisibility(View.VISIBLE);
            ivModelPause.setVisibility(View.VISIBLE);
            ivModelScreen.setVisibility(View.VISIBLE);
            editLl.setVisibility(View.VISIBLE);
            playChatRv.setVisibility(View.VISIBLE);
            rlLandscapeTop.setVisibility(View.GONE);
            rlLandscapeBottom.setVisibility(View.GONE);
            int widthPixels = getResources().getDisplayMetrics().widthPixels;
            ViewGroup.LayoutParams layoutParams = playNewRl.getLayoutParams();
            layoutParams.width = widthPixels;
            layoutParams.height = DensityUtil.dip2px(this, 200);
            playNewRl.setLayoutParams(layoutParams);
            videoView.setLayoutParams(layoutParams);
            videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    rlLandscapeTop.setVisibility(View.GONE);
                    rlLandscapeBottom.setVisibility(View.GONE);
                    return false;
                }
            });

        }
    }
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @OnClick(R.id.chat_iv)
    public void onClick() {
    }

}
