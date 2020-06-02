package com.example.blog.controller;

import com.example.blog.bl.UserService;
import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.UserForm;
import com.example.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.SecurityUtils;

@RestController()
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserForm userForm) {
        /*User user = accountService.login(userForm);
        if (user == null) {
            return ResponseVO.buildFailure(ACCOUNT_INFO_ERROR);
        }
        return ResponseVO.buildSuccess(user);
        */

        if (StringUtils.isBlank(userForm.getEmail())){
            return new ResponseVO.buildFailure("400,邮箱不能为空");
        }

        if (StringUtils.isBlank(userForm. getPassword())){
            return new ResponseVO.buildFailure("400,密码不能为空");
        }
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userForm.getEmail(),userForm. getPassword());
        try{
            subject.login(token);   //执行登录方法，如果没有异常，就说明OK
            return new ResponseVO.buildSuccess();
        }catch (UnknownAccountException e){
            return new ResponseVO.buildFailure("400,用户名不存在");
        }catch (IncorrectCredentialsException e){   //密码错误
            return new ResponseVO.buildFailure("400,密码错误");
        }
    }

    @PostMapping("/register")
    public ResponseVO registerAccount(@RequestBody UserVO userVO) {
        //return accountService.registerAccount(userVO);
        //验证用户名是否为空
        if (StringUtils.isBlank(userVO.getUsername())){
            return new ResponseVO.buildFailure("400,请输入用户名");
        }
        //验证密码是否为空
        if (StringUtils.isBlank(userVO.getPassword())){
            return new ResponseVO.buildFailure("400,密码不能为空");
        }
        //验证邮箱是否为空
        if (StringUtils.isBlank(userVO.getEmail())){
            return new ResponseVO.buildFailure("400,请输入邮箱");
        }
        Integer status = userService.userRegister(userVO);
        if (status >0){
            return new ResponseVO.buildSuccess("200,注册成功");
        }else {
            return new ResponseVO.buildFailure("500,注册失败，请重试");
        }
    }

    @GetMapping("/{id}/getUserInfo")
    public ResponseVO getUserInfo(@PathVariable Integer id){
        if (id== null){
            return new ResponseVO.buildFailure("400,参数错误");
        }
        User user = userService.queryUserById(userId);
        if (user==null){
            return newResponseVO.buildFailure("404,用户不存在");
        }
        return new ResponseVO.buildSuccess();
    }

    @PostMapping("/{id}/userInfo/update")
    public ResponseVO updateUserInfo(@RequestBody UserVO userVO){
        if (userVO==null){
            return new ResponseVO.buildFailure("400,参数错误");
        }
        userVO.setUserID(getCurrentUser().getUserId());
        Integer flag = userService.updateUserInfo(userVO);
        if (flag==0){
            return new ResponseVO.buildFailure("401,修改失败");
        }
        return new ResponseVO.buildSuccess("200,修改成功");
    }
    private User getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        return (User) subject.getPrincipal();
    }
}
