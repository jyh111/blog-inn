package com.example.blog.blImpl;

import com.example.blog.bl.UserService;
import com.example.blog.data.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

}
