package com.example.blog.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private Integer commentId;
    /*发信人的userID*/
    private Integer sender;
    /*收信人的userID*/
    private Integer recipient;
}
