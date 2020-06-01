package com.example.blog.vo;

import java.util.ArrayList;

public class UserVO {
    private Integer userID;
    private String email;
    private String username;
    private String userimg;
    private String password;
    private String self_introduction;
    private ArrayList<BlogVO> blog_list;
    private ArrayList<BlogVO> favor_list;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
