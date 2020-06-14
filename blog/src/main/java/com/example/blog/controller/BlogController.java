package com.example.blog.controller;

import com.example.blog.bl.BlogService;
import com.example.blog.bl.CommentService;
import com.example.blog.po.Blog;
import com.example.blog.vo.BlogInfoVO;
import com.example.blog.vo.BlogVO;
import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.SearchRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/blogs")
public class BlogController {

    private static final String QUERY_FAILED = "";

    @Autowired
    BlogService blogService;

    @Autowired
    CommentService commentService;

    @GetMapping("/{blogId}/detail")
    public ResponseVO getBlogByBlogId(@PathVariable Integer blogId){
        Blog blog=blogService.getBlogByBlogId(blogId);
        return ResponseVO.buildSuccess(blog);
    }

    @PostMapping("/query")
    public ResponseVO getBlogsByQuery(@RequestBody SearchRecordVO searchRecordVO){
        List<Blog> blogs=blogService.getBlogsByQuery(searchRecordVO.getQuery());
        if(blogs.isEmpty()){
            return ResponseVO.buildFailure(QUERY_FAILED);
        }
        List<BlogInfoVO> blogInfos=new ArrayList<>(blogs.size());
        for(int i=0;i<blogs.size();++i){
            BlogInfoVO blogInfoVO=new BlogInfoVO();
            Blog blog=blogs.get(i);
            blogInfoVO.setBlogId(blog.getBlogId());
            blogInfoVO.setTitle(blog.getTitle());
            blogInfos.add(blogInfoVO);
        }
        return ResponseVO.buildSuccess(blogInfos);
    }

    @PostMapping("/patchBlogContent")
    public ResponseVO patchBlogContent(@RequestParam Integer blogID,@RequestParam String content){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/putBlog")
    public ResponseVO putBlog(@RequestBody BlogVO blogVO){
        return ResponseVO.buildFailure("");
    }

    @GetMapping("/{blogID}/delete")
    public ResponseVO deleteBlogByID(@PathVariable Integer blogID){
        return ResponseVO.buildFailure("");
    }

    @GetMapping("/viewBlogs/{blogID}")
    public ResponseVO patchBlogPageview(@PathVariable Integer blogID){
        return ResponseVO.buildFailure("");
    }

    @PostMapping("/patchBlogClassification")
    public ResponseVO patchBlogClassification(@RequestParam String classification,@RequestParam Integer blogID){
        return ResponseVO.buildFailure("");
    }
}
