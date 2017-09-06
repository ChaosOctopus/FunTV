package com.example.administrator.funtv.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.base.utils.BitmapCircleTransformation;
import com.example.administrator.funtv.entity.ZhiboBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class TixingAdapter extends BaseQuickAdapter<ZhiboBean.DataBeanX,BaseViewHolder> {
    private Context context;
    public TixingAdapter(List<ZhiboBean.DataBeanX> data,Context context) {
        super(R.layout.item_tixing, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhiboBean.DataBeanX item) {
        helper.setText(R.id.tv_title_tixing,item.getNick());
        helper.setText(R.id.tv_content_tingxing,item.getTitle());
        ImageView iv = helper.getView(R.id.iv_icon_tixing);
        Glide.with(context).load(item.getAvatar()).transform(new BitmapCircleTransformation(context)).placeholder(R.mipmap.live_default).into(iv);

    }
}
