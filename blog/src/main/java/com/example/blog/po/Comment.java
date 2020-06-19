package com.example.blog.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private Integer commentId;
    private Integer blogId;
    private String content;
    /*评论者的userID*/
    private Integer reviewer;
    /*被答复者的userID*/
    private Integer recipient;
}
