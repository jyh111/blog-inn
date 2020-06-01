package com.example.blog.blImpl;

import com.example.blog.bl.CommentService;
import com.example.blog.data.CommentMapper;
import com.example.blog.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

}
