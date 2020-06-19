package com.example.blog.bl;

import com.example.blog.po.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> getBlogsByQuery(String query);

    Blog getBlogByBlogId(int blogId);

}
