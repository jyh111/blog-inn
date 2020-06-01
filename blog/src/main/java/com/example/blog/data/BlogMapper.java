package com.example.blog.data;


import com.example.blog.po.Blog;
import com.example.blog.vo.BlogVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    List<Blog> getBlogsByQuery();

}
