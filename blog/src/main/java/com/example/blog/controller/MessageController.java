package com.example.blog.controller;

import com.example.blog.bl.MessageService;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/{userID}/getMessages")
    public ResponseVO getMessageByUserID(@PathVariable Integer userID){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/addMessage")
    public ResponseVO addMessage(){
        return null;
    }
}
