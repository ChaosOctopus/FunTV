package com.example.administrator.funtv.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.base.utils.BitmapCircleTransformation;
import com.example.administrator.funtv.entity.SearchBean;
import com.example.administrator.funtv.util.NumberChangeUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 */

public class SearchAdapter extends BaseQuickAdapter<SearchBean.DataBean.ItemsBean,BaseViewHolder> {
    private Context context;
    private int position1;
    public SearchAdapter(List<SearchBean.DataBean.ItemsBean> data,Context context) {
        super(R.layout.layout_item_live, data);
        this.context=context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, SearchBean.DataBean.ItemsBean item) {
        TextView tv_title = helper.getView(R.id.tv_item_title);
        tv_title.setText(item.getNick());
        TextView tv_content = helper.getView(R.id.tv_item_content);
        tv_content.setText(item.getTitle());
        String view = item.getView();
        String numchange = NumberChangeUtils.numchange(view);
//        TextView tv_view = helper.getView(R.id.iv_item_cover);
//        tv_view.setText(numchange);
        String avatar = item.getAvatar();
        String thumb = item.getThumb();
        ImageView iv_head = helper.getView(R.id.iv_item_head);
        ImageView iv_cover = helper.getView(R.id.iv_item_cover);
        Glide.with(context).load(avatar).asBitmap().placeholder(R.mipmap.live_default).transform(new BitmapCircleTransformation(context)).into(iv_head);
        Glide.with(context).load(thumb).asBitmap().placeholder(R.mipmap.live_default).into(iv_cover);
        TextView tv_right = helper.getView(R.id.tv_item_right);
        if(item.isPlay_status()){
            tv_right.setVisibility(View.VISIBLE);
        }
    }
}
