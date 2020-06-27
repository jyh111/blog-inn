package com.example.blog.controller;

import com.example.blog.bl.CommentService;
import com.example.blog.bl.UserService;
import com.example.blog.po.Comment;
import com.example.blog.vo.CommentVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @PostMapping("/putComment")
    public ResponseVO putComment(@RequestBody CommentVO commentVO){
        return commentService.putComment(commentVO);
    }

    @GetMapping("/{blogId}/getCommentByBlogId")
    public ResponseVO getCommentByBlogID(@PathVariable Integer blogId){
        List<Comment> commentList=commentService.getCommentByBlogID(blogId);
        List<CommentVO> commentVOS=new ArrayList<>();
        for(Comment comment:commentList){
            CommentVO commentVO=new CommentVO();
            commentVO.setBlogId(blogId);
            commentVO.setCommentId(comment.getCommentId());
            commentVO.setContent(comment.getContent());
            commentVO.setRecipient(userService.getUserDisplay(comment.getRecipient()));
            commentVO.setReviewer(userService.getUserDisplay(comment.getReviewer()));
            commentVOS.add(commentVO);
        }
        return ResponseVO.buildSuccess(commentVOS);
    }

}
