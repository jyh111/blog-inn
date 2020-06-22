package com.example.blog.bl;

import com.example.blog.po.Blog;
import com.example.blog.vo.BlogVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BlogService {

    List<Blog> getBlogsByQuery(String query);

    Blog getBlogByBlogId(int blogId);

    ResponseVO patchBlogContent(String content,String title,int blogId);

    ResponseVO putBlog(BlogVO blogVO);

    ResponseVO deleteBlogByID(int blogID);

    ResponseVO patchBlogPageview(int blogID);

    ResponseVO patchBlogClassification(String classification,int blogID);

}
