package com.example.blog.po;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Favor {
    private Integer userId;
    private Integer blogId;
    private String classification;

    /*public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }*/
}
