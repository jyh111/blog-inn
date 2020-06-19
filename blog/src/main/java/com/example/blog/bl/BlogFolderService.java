package com.example.blog.bl;

import com.example.blog.po.BlogFolder;
import com.example.blog.vo.ResponseVO;

import java.util.List;

public interface BlogFolderService {

    List<BlogFolder> getBlogFoldersByUserId(int userId);

    ResponseVO putBlogFolder(int userId, String folder_name);

    ResponseVO deleteBlogFolder(int userId,String folder_name);

}