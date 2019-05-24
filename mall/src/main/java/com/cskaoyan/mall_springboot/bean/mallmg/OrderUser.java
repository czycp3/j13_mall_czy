package com.cskaoyan.mall_springboot.bean.mallmg;

public class OrderUser {
    private String nickname;
    private String avatar;

    public OrderUser() {
    }

    public OrderUser(String nickname, String avatar) {
        this.nickname = nickname;
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
