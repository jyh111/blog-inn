package com.example.blog.data;


import com.example.blog.po.Comment;
import com.example.blog.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    int putComment(Comment comment);

    List<Comment> getCommentByBlogID(int blogId);

}
