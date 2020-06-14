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

    void updateUserInfo(int id,String email, String username, String userImg, String password, String self_introduction);

}
