package com.example.blog.controller;

import com.example.blog.vo.BlogVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/blogs")
public class BlogController {


    @GetMapping("/{blogId}/detail")
    public ResponseVO getBlogByBlogId(@PathVariable int blogId){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/query")
    public ResponseVO getBlogsByQuery(@RequestParam String query,@RequestParam int userID){
        return ResponseVO.buildFailure("");
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
