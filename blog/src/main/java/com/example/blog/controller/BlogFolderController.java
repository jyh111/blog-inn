package com.example.blog.controller;

import com.example.blog.bl.BlogFolderService;
import com.example.blog.bl.FavorService;
import com.example.blog.po.Blog;
import com.example.blog.vo.BlogFolderVO;
import com.example.blog.vo.BlogInfoVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blogFolders")
public class BlogFolderController {

    @Autowired
    BlogFolderService blogFolderService;

    @Autowired
    FavorService favorService;

    @GetMapping("/{userId}/getBlogFolders")
    public ResponseVO getBlogFoldersByUserId(@PathVariable Integer userId){
        return ResponseVO.buildSuccess(blogFolderService.getBlogFoldersByUserId(userId));
    }

    @GetMapping("/getBlogsByFolder")
    public ResponseVO getBlogsByFolder(@RequestParam Integer userId, @RequestParam String classification, @RequestParam Integer writerId){
        List<Blog> blogList=blogFolderService.getBlogsByFolder(writerId,classification);
        List<BlogInfoVO> blogInfoVOS=new ArrayList<>();
        for(Blog blog:blogList){
            BlogInfoVO blogInfoVO=new BlogInfoVO();
            blogInfoVO.setBlogId(blog.getBlogId());
            blogInfoVO.setTitle(blog.getTitle());
            blogInfoVO.setIsInFavor(favorService.inFavor(userId,blog.getBlogId()));
            blogInfoVOS.add(blogInfoVO);
        }
        return ResponseVO.buildSuccess(blogInfoVOS);
    }

    @PostMapping("/{userId}/putBlogFolder")
    public ResponseVO putBlogFolder(@RequestBody BlogFolderVO blogFolderVO, @PathVariable Integer userId){
        return blogFolderService.putBlogFolder(userId,blogFolderVO.getFolder_name());
    }

    @GetMapping("/{userId}/deleteBlogFolder")
    public ResponseVO deleteBlogFolder(@RequestParam String folder_name,@PathVariable Integer userId){
        return blogFolderService.deleteBlogFolder(userId,folder_name);
    }

}
