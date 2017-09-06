package com.example.administrator.funtv.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class LanmuBean {

    /**
     * id : 17
     * name : 王者荣耀
     * slug : wangzhe
     * first_letter : W
     * status : 0
     * prompt : 1
     * image : http://image.quanmin.tv/7c3468a1368000b3eaf02387eaea829cjpg
     * thumb : http://image.quanmin.tv/d9c1784dd407e361775650edd6bdd93apng
     * priority : 0
     * screen : 0
     */

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("slug")
    private String slug;
    @SerializedName("first_letter")
    private String firstLetter;
    @SerializedName("status")
    private int status;
    @SerializedName("prompt")
    private int prompt;
    @SerializedName("image")
    private String image;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("priority")
    private int priority;
    @SerializedName("screen")
    private int screen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrompt() {
        return prompt;
    }

    public void setPrompt(int prompt) {
        this.prompt = prompt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }
}
