package com.example.administrator.funtv.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.funtv.R;
import com.example.administrator.funtv.entity.ChatBean;

import java.util.List;

public class ChatAdapter extends BaseQuickAdapter<ChatBean,BaseViewHolder> {
    private Context context;
    public ChatAdapter(List<ChatBean> chatBeen, Context context) {
        super(R.layout.layout_list_chat, chatBeen);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatBean item) {
        TextView tv_name = helper.getView(R.id.tv_name_chat);
        TextView tv_content = helper.getView(R.id.tv_content_chat);
        tv_name.setText(item.getUsername());
        tv_content.setText(item.getContent());

    }
}
