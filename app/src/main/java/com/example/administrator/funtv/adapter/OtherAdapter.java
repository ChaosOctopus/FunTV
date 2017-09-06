package com.example.administrator.funtv.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.entity.OtherBean;
import com.example.administrator.funtv.util.MyUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class OtherAdapter extends BaseQuickAdapter<OtherBean.DataBean ,BaseViewHolder> {
    private Context context;
    public OtherAdapter(List<OtherBean.DataBean> data,Context context) {
        super(R.layout.item_tuijian_main, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, OtherBean.DataBean item) {
        helper.setText(R.id.nick_tv,item.getNick());
        helper.setText(R.id.title_tv,item.getTitle());
        helper.setText(R.id.fans_tv, MyUtils.getFans(item.getFollow()));
        ImageView iv = helper.getView(R.id.thumb_iv);
        Glide.with(context).load(item.getThumb()).placeholder(R.mipmap.live_default).into(iv);
    }
}
