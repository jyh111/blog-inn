package com.example.blog.controller;

import com.example.blog.bl.UserService;
import com.example.blog.po.User;
import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.UserDisplayVO;
import com.example.blog.vo.UserForm;
import com.example.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/api/user")
public class UserController {

    private final static String ACCOUNT_INFO_ERROR = "用户名或密码错误";
    private final static String ACCOUNT_NOT_EXIST = "该用户不存在";

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm userForm) {
        User user = userService.login(userForm);
        if (user == null) {
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
    }

    @PostMapping("/register")
    public ResponseVO registerAccount(@RequestBody UserVO userVO) {
        return userService.registerAccount(userVO);
    }

    @GetMapping("/{id}/getUserInfo")
    public ResponseVO getUserInfo(@PathVariable Integer id){
        User user = userService.getUserInfo(id);
        if(user==null){
            return ResponseVO.buildFailure(ACCOUNT_NOT_EXIST);
        }
        return ResponseVO.buildSuccess(user);
    }

    @PostMapping("/{userId}/userInfo/update")
    public ResponseVO updateUserInfo(@RequestBody UserVO userVO,@PathVariable Integer userId){
        return userService.updateUserInfo(userId,userVO.getEmail(),userVO.getUsername(),userVO.getUserImg(),userVO.getPassword(),userVO.getSelf_introduction());
    }

    @GetMapping("/{id}/getUserDisplay")
    public ResponseVO getUserDisplay(@PathVariable Integer id){
        System.out.println(id);
        UserDisplayVO userDisplay = userService.getUserDisplay(id);
        if(userDisplay==null){
            return ResponseVO.buildFailure(ACCOUNT_NOT_EXIST);
        }
        return ResponseVO.buildSuccess(userDisplay);
    }

}
