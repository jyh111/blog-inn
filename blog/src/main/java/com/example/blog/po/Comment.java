package com.example.blog.po;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class Comment {
    private int commentID;
    private String content;
    /*评论者的userID*/
    private int reviewer;
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

    public int getReviewer() {
        return reviewer;
    }

    public void setReviewer(int reviewer) {
        this.reviewer = reviewer;
    }

    public int getReplied_user() {
        return replied_user;
    }

    public void setReplied_user(int replied_user) {
        this.replied_user = replied_user;
    }
}
