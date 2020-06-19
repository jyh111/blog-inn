package com.example.blog.blImpl;

import com.example.blog.bl.CommentService;
import com.example.blog.data.CommentMapper;
import com.example.blog.po.Comment;
import com.example.blog.vo.CommentVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final static String PUT_COMMENT_FAILURE="添加评论失败";
    private final static String PUT_COMMENT_SUCCESS="添加评论成功";

    @Autowired
    CommentMapper commentMapper;

    @Override
    public ResponseVO putComment(CommentVO commentVO) {
        Comment comment=new Comment();
        comment.setBlogId(commentVO.getBlogId());
        comment.setCommentId(commentVO.getCommentId());
        comment.setContent(commentVO.getContent());
        comment.setReviewer(commentVO.getReviewer().getUserId());
        comment.setRecipient(commentVO.getRecipient().getUserId());
        try{
            commentMapper.putComment(comment);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(PUT_COMMENT_FAILURE);
        }
        return ResponseVO.buildSuccess(PUT_COMMENT_SUCCESS);
    }

    @Override
    public List<Comment> getCommentByBlogID(int blogId) {
        return commentMapper.getCommentByBlogID(blogId);
    }
}
