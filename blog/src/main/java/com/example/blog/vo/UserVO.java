package com.example.blog.vo;

import java.util.ArrayList;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class UserVO {
    private int userID;
    private String username;
    private String userimg;
    private String password;
    private String self_introduction;
    private ArrayList<BlogVO> blog_list;
    private ArrayList<BlogVO> favor_list;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSelf_introduction() {
        return self_introduction;
    }

    public void setSelf_introduction(String self_introduction) {
        this.self_introduction = self_introduction;
    }

    public ArrayList<BlogVO> getBlog_list() {
        return blog_list;
    }

    public void setBlog_list(ArrayList<BlogVO> blog_list) {
        this.blog_list = blog_list;
    }

    public ArrayList<BlogVO> getFavor_list() {
        return favor_list;
    }

    public void setFavor_list(ArrayList<BlogVO> favor_list) {
        this.favor_list = favor_list;
    }
}
