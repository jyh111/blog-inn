package com.example.blog.data;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.blog.po.User;

@Mapper
@Repository
public interface UserMapper {

    /*
     *根据用户名查询用户
     */
    public User queryUserByUserName(String username);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Integer userRegister(User user);

    /**
     * 根据邮箱查询用户
     * @param userEmail
     * @return
     */
    User queryUserByEmail(String email);

    /**
     * 根据ID查询用户
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
