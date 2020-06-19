package com.example.blog.vo;

import lombok.Getter;
import lombok.Setter;

/**
* 用于登录
*/
@Getter
@Setter
public class UserForm {
    /**
     * 用户邮箱，不可重复
     */
    private String email;
    /**
     * 用户密码
     */
    private String password;
}
