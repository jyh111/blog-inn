package com.example.blog.controller;

import com.example.blog.vo.CommentVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/comments")
public class CommentController {

    @PostMapping("/putComment")
    public ResponseVO putComment(@RequestBody CommentVO commentVO){
        return ResponseVO.buildFailure("");
    }

    @GetMapping("/{blogID}/getCommentByBlogID")
    public ResponseVO getCommentByBlogID(@PathVariable int blogID){
        return ResponseVO.buildFailure("");
    }

}
