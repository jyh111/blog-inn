package com.example.blog.blImpl;

import com.example.blog.bl.UserService;
import com.example.blog.po.User;
import com.example.blog.data.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Integer userRegister(User user) {
        return userMapper.userRegister(user);
    }

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    @Override
    public User queryUserById(Integer userID) {
        return userMapper.queryUserById(userID);
    }

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Override
    public User queryUserByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }

    /**
     * 根据邮箱查询用户
     * @param userEmail
     * @return
     */
    @Override
    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }
    /**
     * 根据ID更新用户信息
     * @param user
     * @return
     */
    @Override
    public Integer updateUserInfo(User user) {
        return userMapper.updateUserInfo(user);
    }
}

