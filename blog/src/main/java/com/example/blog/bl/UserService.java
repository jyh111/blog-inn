package com.example.blog.bl;

import java.util.List;
import com.example.blog.po.User;

public interface UserService {

    /**
     * 用户注册
     * @param user
     * @return
     */
    Integer userRegister(User user);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User queryUserByUserName(String username);

    /**
     * 根据邮箱查询用户
     * @param userEmail
     * @return
     */
    User queryUserByEmail(String email);


    /**
     * 根据用户查询ID
     * @param userId
     * @return
     */
    User queryUserById(Integer userID);

    /**
     * 根据ID更新用户信息
     * @param user
     * @return
     */
    Integer updateUserInfo(User user);
}
