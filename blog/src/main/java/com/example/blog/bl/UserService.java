package com.example.blog.bl;

import com.example.blog.po.User;
import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.UserForm;
import com.example.blog.vo.UserVO;

public interface UserService {

    User login(UserForm userForm);

    ResponseVO registerAccount(UserVO userVO);

    User getUserInfo(int id);

    ResponseVO updateUserInfo(int id,String email,String username,String userImg,String password,String self_introduction);

}
