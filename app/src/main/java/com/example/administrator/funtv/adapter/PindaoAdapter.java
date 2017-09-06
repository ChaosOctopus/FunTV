package com.example.administrator.funtv.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.funtv.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11 0011.
 */

public class PindaoAdapter extends BaseItemDraggableAdapter <String,BaseViewHolder>{
    public PindaoAdapter( List<String> data) {
        super(R.layout.item_pindao, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.pindao_tv,item);
    }
}
