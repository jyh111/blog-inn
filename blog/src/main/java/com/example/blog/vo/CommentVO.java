package com.example.blog.vo;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class CommentVO {
    private String content;
    private UserInfoVO commentor;
    private UserInfoVO reply_user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfoVO getCommentor() {
        return commentor;
    }

    public void setCommentor(UserInfoVO commentor) {
        this.commentor = commentor;
    }

    public UserInfoVO getReply_user() {
        return reply_user;
    }

    public void setReply_user(UserInfoVO reply_user) {
        this.reply_user = reply_user;
    }
}
