package com.example.blog.po;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Blog {
    private Integer blogId;
    /*作者的userID*/
    private Integer writerId;
    /*浏览量*/
    private Integer page_view;

    private String classification;

    private String content;

    private String title;
}
