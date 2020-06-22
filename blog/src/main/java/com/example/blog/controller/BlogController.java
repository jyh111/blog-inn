package com.example.blog.controller;

import com.example.blog.bl.BlogService;
import com.example.blog.bl.FavorService;
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
    private static final String BLOG_NOT_EXIST = "文章不存在";

    @Autowired
    BlogService blogService;

    @Autowired
    FavorService favorService;

    // 未登录状态userId为0
    @GetMapping("/{blogId}/detail")
    public ResponseVO getBlogByBlogId(@RequestParam Integer userId,@PathVariable Integer blogId){
        Blog blog=blogService.getBlogByBlogId(blogId);
        if(blog==null){
            return ResponseVO.buildFailure(BLOG_NOT_EXIST);
        }
        BlogVO blogVO=new BlogVO();
        blogVO.setBlogId(blog.getBlogId());
        blogVO.setClassification(blog.getClassification());
        blogVO.setContent(blog.getContent());
        blogVO.setTitle(blog.getTitle());
        blogVO.setWriterId(blog.getWriterId());
        blogVO.setPage_view(blog.getPage_view());
        blogVO.setInFavor(favorService.inFavor(userId,blog.getBlogId()));
        return ResponseVO.buildSuccess(blogVO);
    }

    @PostMapping("/query")
    public ResponseVO getBlogsByQuery(@RequestBody SearchRecordVO searchRecordVO){
        List<Blog> blogs=blogService.getBlogsByQuery(searchRecordVO.getQuery());
        List<BlogInfoVO> blogInfos=new ArrayList<>();
        for(Blog blog:blogs){
            BlogInfoVO blogInfoVO=new BlogInfoVO();
            blogInfoVO.setBlogId(blog.getBlogId());
            blogInfoVO.setTitle(blog.getTitle());
            //用户处于未登录状态，则前端返回的userId为0
            int i=searchRecordVO.getUserId();
            if(i==0)blogInfoVO.setInFavor("null");
            else blogInfoVO.setInFavor(favorService.inFavor(searchRecordVO.getUserId(),blog.getBlogId()));
            blogInfos.add(blogInfoVO);
        }
        return ResponseVO.buildSuccess(blogInfos);
    }

    @GetMapping("/patchBlogContent/{blogId}")
    public ResponseVO patchBlogContent(@RequestParam String content,@RequestParam String title,@PathVariable Integer blogId){
        return blogService.patchBlogContent(content, title, blogId);
    }

    @PostMapping("/putBlog")
    public ResponseVO putBlog(@RequestBody BlogVO blogVO){
        return blogService.putBlog(blogVO);
    }

    @GetMapping("/{blogID}/delete")
    public ResponseVO deleteBlogByID(@PathVariable Integer blogID){
        return blogService.deleteBlogByID(blogID);
    }

    @GetMapping("/{blogID}/patchBlogPageviewAPI")
    public ResponseVO patchBlogPageview(@PathVariable Integer blogID){
        return blogService.patchBlogPageview(blogID);
    }

    @GetMapping("/patchBlogClassification")
    public ResponseVO patchBlogClassification(@RequestParam String classification,@RequestParam Integer blogID){
        return blogService.patchBlogClassification(classification,blogID);
    }
}
