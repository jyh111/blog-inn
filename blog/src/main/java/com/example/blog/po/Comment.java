package com.example.blog.po;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class Comment {
    private int commentID;
    private String content;
    /*评论者的userID*/
    private int commentor;
    /*被答复者的userID*/
    private int replied_user;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentor() {
        return commentor;
    }

    public void setCommentor(int commentor) {
        this.commentor = commentor;
    }

    public int getReplied_user() {
        return replied_user;
    }

    public void setReplied_user(int replied_user) {
        this.replied_user = replied_user;
    }
}
