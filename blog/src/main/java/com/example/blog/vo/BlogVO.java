package com.example.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogVO {
    private Integer blogId;
    private Integer writerId;
    //""表示没有收藏，"default"表示收藏后没有手动添加别的分类，"自定义类别"表示收藏后添加到了自定义的收藏夹里
    private String inFavor="";
    private Integer page_view;
    private String content;
    private String title;
    private String classification;

    /*public Integer getBlogId() {
        return blogId;
    }
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
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
    public Integer getWriterId() {
        return writerId;
    }
    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public void setInFavor(boolean inFavor) {
        this.inFavor = inFavor;
    }

    public int getPage_view() {
        return page_view;
    }
    public void setPage_view(Integer page_view) {
        this.page_view = page_view;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getInFavor() {
        return inFavor;
    }
    public void setInFavor(Boolean inFavor) {
        this.inFavor = inFavor;
    }*/
}
