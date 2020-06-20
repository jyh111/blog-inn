package com.example.blog.blImpl;

import com.example.blog.bl.BlogFolderService;
import com.example.blog.data.BlogFolderMapper;
import com.example.blog.data.BlogMapper;
import com.example.blog.po.Blog;
import com.example.blog.po.BlogFolder;
import com.example.blog.vo.BlogInfoVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogFolderServiceImpl implements BlogFolderService {

    @Autowired
    BlogFolderMapper blogFolderMapper;

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<BlogFolder> getBlogFoldersByUserId(int userId) {
        return blogFolderMapper.getBlogFoldersByUserId(userId);
    }

    @Override
    public List<Blog> getBlogsByFolder(int writerId, String classification) {
        return blogMapper.getBlogsByFolder(writerId, classification);
    }

    @Override
    public ResponseVO putBlogFolder(int userId, String folder_name) {
        try {
            blogFolderMapper.putBlogFolder(userId,folder_name);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("新建文件夹失败");
        }
        return ResponseVO.buildSuccess("新建文件夹成功");
    }

    @Override
    public ResponseVO deleteBlogFolder(int userId, String folder_name) {
        try {
            blogFolderMapper.deleteBlogFolder(userId,folder_name);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("删除文件夹失败");
        }
        return ResponseVO.buildSuccess("删除文件夹成功");
    }
}
