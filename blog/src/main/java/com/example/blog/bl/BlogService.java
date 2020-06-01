package com.example.blog.bl;

import com.example.blog.po.Blog;
import com.example.blog.vo.SearchRecordVO;

import java.util.List;

public interface BlogService {

    List<Blog> getBlogsByQuery(SearchRecordVO searchRecordVO);

}
