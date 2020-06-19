package com.example.blog.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageVO {
    private UserVO sender;
    private UserVO recipient;
    private Integer commentId;
    private Integer messageId;
}
