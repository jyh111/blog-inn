package com.example.blog.data;


import com.example.blog.po.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    int putComment(Comment comment);

    List<Comment> getCommentByBlogID(@Param("blogId") int blogId);

}
