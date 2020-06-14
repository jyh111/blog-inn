package com.example.blog.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private Integer commentId;
    private String content;
    /*评论者的userID*/
    private Integer reviewer;
    /*被答复者的userID*/
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

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getReplied_user() {
        return replied_user;
    }

    public void setReplied_user(Integer replied_user) {
        this.replied_user = replied_user;
    }*/
}
