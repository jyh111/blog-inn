package com.example.blog.controller;

import com.example.blog.bl.BlogService;
import com.example.blog.vo.BlogVO;
import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.SearchRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/{blogId}/detail")
    public ResponseVO getBlogByBlogId(@PathVariable int blogId){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/query")
    public ResponseVO getBlogsByQuery(@RequestBody SearchRecordVO searchRecordVO){
        return ResponseVO.buildSuccess(blogService.getBlogsByQuery(searchRecordVO));
    }

    @PostMapping("/patchBlogContent")
    public ResponseVO patchBlogContent(@RequestParam int blogID,@RequestParam String content){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/putBlog")
    public ResponseVO putBlog(@RequestBody BlogVO blogVO){
        return ResponseVO.buildFailure("");
    }

    @GetMapping("/{blogID}/delete")
    public ResponseVO deleteBlogByID(@PathVariable int blogID){
        return ResponseVO.buildFailure("");
    }

    @GetMapping("/viewBlogs/{blogID}")
    public ResponseVO patchBlogPageview(@PathVariable int blogID){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/patchBlogClassification")
    public ResponseVO patchBlogClassification(@RequestParam String classification,@RequestParam int blogID){
        return ResponseVO.buildFailure("");
    }
}
