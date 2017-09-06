package com.example.administrator.funtv.entity;

/**
 * 存储发送的信息和谁发的
 */

public class ChatBean {

    private String username ;
    private String content;

    public ChatBean(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ChatBean{" +
                "username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
