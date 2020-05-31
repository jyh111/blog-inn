package com.example.blog.po;


public class Blog {
    private Integer blogID;
    /*作者的userID*/
    private Integer writerID;
    /*浏览量*/
    private Integer page_view;

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public int getWriterID() {
        return writerID;
    }

    public void setWriterID(int writerID) {
        this.writerID = writerID;
    }

    public int getPage_view() {
        return page_view;
    }

    public void setPage_view(int page_view) {
        this.page_view = page_view;
    }
}
