package com.example.administrator.funtv.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.entity.ShouyeBean;
import com.example.administrator.funtv.entity.TuijianBean;
import com.example.administrator.funtv.util.MyUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13 0013.
 */

public class TuijianAdapter extends BaseSectionQuickAdapter<TuijianBean,BaseViewHolder> {
    private Context context;
    public TuijianAdapter(List<TuijianBean> data, Context context) {
        super(R.layout.item_tuijian_main, R.layout.item_tuijian_header, data);
        this.context = context;
    }
    //设置头布局
    @Override
    protected void convertHead(BaseViewHolder helper, TuijianBean item) {
        helper.setText(R.id.header_tv,item.header);
    }
    //设置item内容
    @Override
    protected void convert(BaseViewHolder helper, TuijianBean item) {
        ShouyeBean.RoomBean.ListBean t = item.t;
        helper.setText(R.id.nick_tv,t.getNick());
        helper.setText(R.id.title_tv,t.getTitle());
        int follow = t.getFollow();
        String fans = MyUtils.getFans(follow);
        helper.setText(R.id.fans_tv,fans);
        ImageView roomIv = helper.getView(R.id.thumb_iv);
        Glide.with(context).load(item.t.getThumb()).placeholder(R.mipmap.live_default).into(roomIv);

    }
}
