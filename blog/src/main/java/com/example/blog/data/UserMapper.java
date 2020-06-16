package com.example.blog.data;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.example.blog.po.User;

@Mapper
@Repository
public interface UserMapper {

    User getAccountByEmail(@Param("email") String email);

    int registerAccount(User user);

    User getUserInfo(@Param("id") int id);

    void updateUserInfo(@Param("id") int id,@Param("email") String email, @Param("username") String username, @Param("userImg") String userImg, @Param("password") String password, @Param("self_introduction") String self_introduction);

}
