package com.example.administrator.funtv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.entity.ADBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

/**
 * Created by Administrator on 2017/4/13 0013.
 * 广告轮播适配器
 */

public class AdAdapter extends LoopPagerAdapter {
    private ADBean adBean;
    private Context context;
    public AdAdapter(RollPagerView viewPager,ADBean adBean,Context context) {
        super(viewPager);
        this.adBean = adBean;
        this.context = context;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(context);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Glide.with(context).load(adBean.getAppFocusCheck().get(position).getThumb()).placeholder(R.mipmap.live_default).into(view);
        return view;
    }

    @Override
    public int getRealCount() {
        return adBean.getAppFocusCheck().size();
    }
}
