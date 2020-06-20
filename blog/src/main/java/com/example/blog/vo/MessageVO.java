package com.example.blog.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageVO {
    private UserDisplayVO sender;
    private UserDisplayVO recipient;
    private Integer commentId;
    private Integer messageId;
}
