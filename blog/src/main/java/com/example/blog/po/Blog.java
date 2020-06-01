package com.example.blog.po;


public class Blog {
    private Integer blogID;
    /*作者的userID*/
    private Integer writerID;
    /*浏览量*/
    private Integer page_view;

    private String classification;

    private String content;

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }

    public Integer getWriterID() {
        return writerID;
    }

    public void setWriterID(Integer writerID) {
        this.writerID = writerID;
    }

    public Integer getPage_view() {
        return page_view;
    }

    public void setPage_view(Integer page_view) {
        this.page_view = page_view;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
