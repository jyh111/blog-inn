package com.example.blog.bl;

import com.example.blog.po.Comment;
import com.example.blog.vo.CommentVO;
import com.example.blog.vo.ResponseVO;

import java.util.List;

public interface CommentService {

    ResponseVO putComment(CommentVO commentVO);

    List<Comment> getCommentByBlogID(int blogId);

}
