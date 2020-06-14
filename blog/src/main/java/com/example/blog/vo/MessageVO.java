package com.example.blog.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageVO {
    private UserVO sender;
    private UserVO recipient;
    private Integer commentId;
    private Integer messageId;

    /*public UserInfoVO getSender() {
        return sender;
    }

    public void setSender(UserInfoVO sender) {
        this.sender = sender;
    }

    public UserInfoVO getRecipient() {
        return recipient;
    }

    public void setRecipient(UserInfoVO recipient) {
        this.recipient = recipient;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }*/
}
