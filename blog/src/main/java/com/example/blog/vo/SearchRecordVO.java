package com.example.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRecordVO {

    private Integer userId;

    private String query;

    /*public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }*/
}