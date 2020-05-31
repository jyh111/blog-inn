package com.example.blog.vo;

import java.util.ArrayList;

public class BlogVO {
    private Integer blogID;
    private Integer writerID;
    private ArrayList<CommentVO> comment_list;
    private Boolean inFavor;
    private int page_view;
    private String content;

    public Boolean getInFavor() {
        return inFavor;
    }

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    private String classification = "";

    public Integer getWriterID() {
        return writerID;
    }

    public void setWriterID(Integer writerID) {
        this.writerID = writerID;
    }

    public ArrayList<CommentVO> getComment_list() {
        return comment_list;
    }

    public void setComment_list(ArrayList<CommentVO> comment_list) {
        this.comment_list = comment_list;
    }

    public void setInFavor(boolean inFavor) {
        this.inFavor = inFavor;
    }

    public int getPage_view() {
        return page_view;
    }

    public void setPage_view(int page_view) {
        this.page_view = page_view;
    }
}
