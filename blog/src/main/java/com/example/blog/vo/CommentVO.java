package com.example.blog.vo;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class CommentVO {
    private String content;
    private UserInfoVO reviewer;
    private UserInfoVO recipient;
    private Integer commentID;

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfoVO getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserInfoVO reviewer) {
        this.reviewer = reviewer;
    }

    public UserInfoVO getRecipient() {
        return recipient;
    }

    public void setRecipient(UserInfoVO recipient) {
        this.recipient = recipient;
    }
}
