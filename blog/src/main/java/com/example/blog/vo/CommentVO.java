package com.example.blog.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentVO {
    private Integer commentId;
    private Integer blogId;
    private String content;
    private Integer reviewer;
    private Integer recipient;
}
