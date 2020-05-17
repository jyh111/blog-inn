package com.example.blog.po;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class Message {
    private int commentID;
    /*发信人的userID*/
    private int messager;
    /*收信人的userID*/
    private int replied_user;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getMessager() {
        return messager;
    }

    public void setMessager(int messager) {
        this.messager = messager;
    }

    public int getReplied_user() {
        return replied_user;
    }

    public void setReplied_user(int replied_user) {
        this.replied_user = replied_user;
    }
}
