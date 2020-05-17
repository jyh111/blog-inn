package com.example.blog.po;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class User {
    private int userID;
    private String username;
    private String userimg;
    private String pwd;
    private String self_introduction;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }
}
