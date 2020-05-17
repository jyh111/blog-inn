package com.example.blog.po;


/**
 * @Author: hou rui
 * @Date: 2020-05-16
 */
public class Blog {
    private int blogID;
    /*作者的userID*/
    private int writer;
    /*浏览量*/
    private int page_view;

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public int getWriter() {
        return writer;
    }

    public void setWriter(int writer) {
        this.writer = writer;
    }

    public int getPage_view() {
        return page_view;
    }

    public void setPage_view(int page_view) {
        this.page_view = page_view;
    }
}
