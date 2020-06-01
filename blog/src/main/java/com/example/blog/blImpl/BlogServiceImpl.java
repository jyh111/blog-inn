package com.example.blog.blImpl;

import com.example.blog.bl.BlogService;
import com.example.blog.data.BlogMapper;
import com.example.blog.po.Blog;
import com.example.blog.vo.SearchRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> getBlogsByQuery(SearchRecordVO searchRecordVO) {
        return null;
    }
}
