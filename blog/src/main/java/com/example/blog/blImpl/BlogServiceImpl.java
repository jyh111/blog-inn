package com.example.blog.blImpl;

import com.example.blog.bl.BlogService;
import com.example.blog.data.BlogMapper;
import com.example.blog.po.Blog;
import com.example.blog.vo.BlogVO;
import com.example.blog.vo.ResponseVO;
import com.example.blog.vo.SearchRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private final static String PATCH_BLOG_SUCCESS="更新文章成功";
    private final static String PATCH_BLOG_FAILURE="更新文章失败";
    private final static String PUT_BLOG_FAILURE="添加文章失败";
    private final static String PUT_BLOG_SUCCESS="添加文章成功";
    private final static String DELETE_BLOG_SUCCESS="删除文章成功";
    private final static String DELETE_BLOG_FAILURE="删除文章失败";
    private final static String PATCH_PAGE_VIEW_SUCCESS="增加浏览量成功";
    private final static String PATCH_PAGE_VIEW_FAILURE="增加浏览量失败";
    private final static String PATCH_CLASSIFICATION_SUCCESS="添加标签成功";
    private final static String PATCH_CLASSIFICATION_FAILURE="添加标签失败";

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> getBlogsByQuery(String query) {
        return blogMapper.getBlogsByQuery(query);
    }

    @Override
    public Blog getBlogByBlogId(int blogId) {
        return blogMapper.getBlogByBlogId(blogId);
    }

    @Override
    public ResponseVO patchBlogContent(String content, String title, int blogId) {
        try {
            blogMapper.patchBlogContent(content, title, blogId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(PATCH_BLOG_FAILURE);
        }
        return ResponseVO.buildSuccess(PATCH_BLOG_SUCCESS);
    }

    @Override
    public ResponseVO putBlog(BlogVO blogVO) {
        try {
            Blog blog=new Blog();
            //blog.setBlogId(blogVO.getBlogId());尚无blogId
            blog.setWriterId(blogVO.getWriterId());
            //写文章的时候尚无分类，如果前端需要在写文章的时候增加分类功能，也可以自便，如果不想，则传入""
            blog.setClassification(blogVO.getClassification());
            //写文章的时候浏览量前端直接传0
            blog.setPage_view(0);
            blog.setContent(blogVO.getContent());
            blog.setTitle(blogVO.getTitle());
            blogMapper.putBlog(blog);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(PUT_BLOG_FAILURE);
        }
        return ResponseVO.buildSuccess(PUT_BLOG_SUCCESS);
    }

    @Override
    public ResponseVO deleteBlogByID(int blogID) {
        try {
            blogMapper.deleteBlogByID(blogID);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(DELETE_BLOG_FAILURE);
        }
        return ResponseVO.buildSuccess(DELETE_BLOG_SUCCESS);
    }

    @Override
    public ResponseVO patchBlogPageview(int blogID) {
        try {
            blogMapper.patchBlogPageview(blogID);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(PATCH_PAGE_VIEW_FAILURE);
        }
        return ResponseVO.buildSuccess(PATCH_PAGE_VIEW_SUCCESS);
    }

    @Override
    public ResponseVO patchBlogClassification(String classification, int blogID) {
        try {
            blogMapper.patchBlogClassification(classification,blogID);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(PATCH_CLASSIFICATION_FAILURE);
        }
        return ResponseVO.buildSuccess(PATCH_CLASSIFICATION_SUCCESS);
    }


}
