package com.example.blog.po;


public class Message {
    private Integer commentID;
    /*发信人的userID*/
    private Integer sender;
    /*收信人的userID*/
    private Integer recipient;

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getRecipient() {
        return recipient;
    }

    public void setRecipient(Integer recipient) {
        this.recipient = recipient;
    }
}
