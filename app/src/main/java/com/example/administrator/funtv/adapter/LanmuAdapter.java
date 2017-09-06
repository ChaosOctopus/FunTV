package com.example.administrator.funtv.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.entity.LanmuBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class LanmuAdapter extends BaseQuickAdapter<LanmuBean,BaseViewHolder> {
    private Context context;
    public LanmuAdapter(List<LanmuBean> data,Context context) {
        super(R.layout.item_lanmu, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, LanmuBean item) {
        ImageView iv = helper.getView(R.id.lanmu_iv);
//        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //glide默认拉伸方式
        Glide.with(context).load(item.getImage()).centerCrop().placeholder(R.mipmap.live_default).into(iv);
    }
}
