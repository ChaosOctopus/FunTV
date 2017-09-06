package com.example.administrator.funtv.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/5/31 0031.
 */
@Entity
public class User extends BmobObject{
    @Id
    private Long id;
    private String name;
    private String psw;
    private String like_room;
    @Transient
    private int tempUsageCount;


    public String getLike_room() {
        return this.like_room;
    }
    public void setLike_room(String like_room) {
        this.like_room = like_room;
    }
    public String getPsw() {
        return this.psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1832465867)
    public User(Long id, String name, String psw, String like_room) {
        this.id = id;
        this.name = name;
        this.psw = psw;
        this.like_room = like_room;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}
