package com.example.blog.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentVO {
    private Integer commentId;
    private Integer blogId;
    private String content;
    private Integer reviewer;
    private Integer recipient;

    /*public Integer getCommentID() {
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

    public UserVO getReviewer() {
        return reviewer;
    }

    public void setReviewer(UserVO reviewer) {
        this.reviewer = reviewer;
    }

    public UserVO getRecipient() {
        return recipient;
    }

    public void setRecipient(UserVO recipient) {
        this.recipient = recipient;
    }*/
}
