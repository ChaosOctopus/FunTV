package com.example.administrator.funtv.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Administrator on 2017/4/13 0013.
 */

public class TuijianBean extends SectionEntity<ShouyeBean.RoomBean.ListBean> {
    public TuijianBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public TuijianBean(ShouyeBean.RoomBean.ListBean listBean) {
        super(listBean);
    }
}
