package com.example.blog.blImpl;

import com.example.blog.bl.UserService;
import com.example.blog.po.User;
import com.example.blog.data.UserMapper;
import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.UserDisplayVO;
import com.example.blog.vo.UserForm;
import com.example.blog.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String REGISTER_SUCCESS = "注册成功";
    private final static String UPDATE_ERROR = "修改失败";

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserForm userForm) {
        System.out.println(userForm.getEmail());
        System.out.println(userForm.getPassword());
        User user = userMapper.getAccountByEmail(userForm.getEmail());
        if (null == user || !user.getPassword().equals(userForm.getPassword())) {
            return null;
        }
        return user;
    }

    @Override
    public ResponseVO registerAccount(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO,user);
        try {
            userMapper.registerAccount(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        return ResponseVO.buildSuccess(REGISTER_SUCCESS);
    }

    @Override
    public User getUserInfo(int id) {
        return userMapper.getUserInfo(id);
    }

    @Override
    public ResponseVO updateUserInfo(int id,String email, String username, String userImg, String password, String self_introduction) {
        try {
            userMapper.updateUserInfo(id,email,username,userImg,password,self_introduction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(UPDATE_ERROR);
        }
        return ResponseVO.buildSuccess(true);
    }

    @Override
    public UserDisplayVO getUserDisplay(int id){
        User user = userMapper.getUserInfo(id);
        if(user==null){
            return null;
        }
        UserDisplayVO userDisplay = new UserDisplayVO();
        userDisplay.setUserId(user.getUserId());
        userDisplay.setUserImg(user.getUserImg());
        userDisplay.setUsername(user.getUsername());
        return userDisplay;
    }


}

