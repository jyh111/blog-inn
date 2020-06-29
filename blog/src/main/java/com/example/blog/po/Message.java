package com.example.blog.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private Integer messageId;
    /*发信人的userID*/
    private Integer sender;
    /*收信人的userID*/
    private Integer recipient;

    private Integer blogId;
    private String content;

}
