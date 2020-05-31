package com.example.blog.controller;

import com.example.blog.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/message")
public class MessageController {

    @GetMapping("/{userID}/getMessages")
    public ResponseVO getMessageByUserID(@PathVariable int userID){
        return ResponseVO.buildFailure("");
    }
}
