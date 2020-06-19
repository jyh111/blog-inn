package com.example.blog.controller;

import com.example.blog.bl.BlogFolderService;
import com.example.blog.vo.BlogFolderVO;
import com.example.blog.vo.FavorFolderVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogFolders")
public class BlogFolderController {

    @Autowired
    BlogFolderService blogFolderService;

    @GetMapping("/{userId}/getBlogFolders")
    public ResponseVO getBlogFoldersByUserId(@PathVariable Integer userId){
        return ResponseVO.buildSuccess(blogFolderService.getBlogFoldersByUserId(userId));
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
