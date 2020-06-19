package com.example.blog.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer userId;
    private String email;
    private String username;
    private String userImg;
    private String password;
    private String self_introduction;
}
