package com.example.blog.controller;

import com.example.blog.bl.CommentService;
import com.example.blog.vo.CommentVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/putComment")
    public ResponseVO putComment(@RequestBody CommentVO commentVO){
        return commentService.putComment(commentVO);
    }

    @GetMapping("/{blogId}/getCommentByBlogId")
    public ResponseVO getCommentByBlogID(@PathVariable Integer blogId){
        return ResponseVO.buildSuccess(commentService.getCommentByBlogID(blogId));
    }

}
