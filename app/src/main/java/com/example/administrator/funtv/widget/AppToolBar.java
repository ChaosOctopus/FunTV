package com.example.administrator.funtv.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.funtv.R;
import com.example.administrator.funtv.activity.search.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/8 0008.
 * 组合控件
 * 1、写控件的布局
 * 2、继承布局最外层的容器
 * 3、实现构造方法
 * 4、关联布局
 * 5、自定义属性
 * a、自定义属性：attrs.xml
 * b、在布局中使用属性，生命命名控件
 * c、在代码中读取属性，给控件赋值
 */

public class AppToolBar extends RelativeLayout {
    @BindView(R.id.search_btn)
    ImageView searchBtn;
    @BindView(R.id.icon_iv)
    ImageView iconIv;
    @BindView(R.id.title_tv)
    TextView titleTv;
    private Context context;

    public AppToolBar(Context context) {
        this(context, null);
    }

    public AppToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_toolbar, this, true);
        ButterKnife.bind(this,view);//在自定义View中绑定黄油刀
        this.context=context;

        //获得自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ToolBar);
        //读取属性
        String title = typedArray.getString(R.styleable.ToolBar_title);
        int imgRes = typedArray.getResourceId(R.styleable.ToolBar_icon, -1);
        //使用属性给控件赋值
        titleTv.setText(title);
        if(imgRes!=-1){
            iconIv.setImageResource(imgRes);
        }
    }

    @OnClick({R.id.search_btn})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.search_btn:
                intent.setClass(context, SearchActivity.class);
                break;
        }
        ((Activity)context).startActivity(intent);
    }
}
