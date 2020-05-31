package com.example.blog.controller;

import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.UserForm;
import com.example.blog.vo.UserVO;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm userForm) {
        /*User user = accountService.login(userForm);
        if (user == null) {
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
        */
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/register")
    public ResponseVO registerAccount(@RequestBody UserVO userVO) {
        //return accountService.registerAccount(userVO);
        return null;
    }

    @GetMapping("/{id}/getUserInfo")
    public ResponseVO getUserInfo(@PathVariable int id){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/{id}/userInfo/update")
    public ResponseVO updateUserInfo(@PathVariable int id){
        return ResponseVO.buildFailure("");
    }
}
