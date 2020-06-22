package com.example.blog.data;


import com.example.blog.po.Blog;
import com.example.blog.vo.BlogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    List<Blog> getBlogsByFolder(@Param("writerId") int writerId,@Param("classification") String classification);

    List<Blog> getBlogsByQuery(@Param("title") String title);

    Blog getBlogByBlogId(@Param("blogId") int blogId);

    void patchBlogContent(@Param("content") String content,@Param("title") String title,@Param("blogId") Integer blogId);

    int putBlog(Blog blog);

    void deleteBlogByID(@Param("blogId") int blogID);

    void patchBlogPageview(@Param("blogId") int blogID);

    void patchBlogClassification(@Param("classification") String classification,@Param("blogId") int blogID);
}
