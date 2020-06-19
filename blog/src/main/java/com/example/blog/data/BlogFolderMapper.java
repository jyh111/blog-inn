package com.example.blog.data;

import com.example.blog.po.BlogFolder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogFolderMapper {
    List<BlogFolder> getBlogFoldersByUserId(@Param("userId") int userId);

    void putBlogFolder(@Param("userId") int userId, @Param("folder_name") String folder_name);

    void deleteBlogFolder(@Param("userId") int userId,@Param("folder_name") String folder_name);
}
