package com.example.blog.blImpl;

import com.example.blog.bl.FavorService;
import com.example.blog.data.BlogMapper;
import com.example.blog.data.FavorMapper;
import com.example.blog.po.Blog;
import com.example.blog.po.Favor;
import com.example.blog.vo.BlogInfoVO;
import com.example.blog.vo.FavorVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavorServiceImpl implements FavorService {

    private final static String PUT_FAVOR_FAILURE="收藏失败";
    private final static String PUT_FAVOR_SUCCESS="收藏成功";

    @Autowired
    FavorMapper favorMapper;

    @Autowired
    BlogMapper blogMapper;

    /*
    返回收藏的文章列表
     */
    @Override
    public List<BlogInfoVO> getFavors(int userId,String classification) {
        List<Integer> blogIdList=favorMapper.getFavors(userId, classification);
        List<BlogInfoVO> blogInfoVOS=new ArrayList<>();
        for(int i:blogIdList){
            Blog blog=blogMapper.getBlogByBlogId(i);
            BlogInfoVO blogInfoVO=new BlogInfoVO();
            blogInfoVO.setBlogId(blog.getBlogId());
            blogInfoVO.setTitle(blog.getTitle());
            blogInfoVO.setIsInFavor(classification);
            blogInfoVOS.add(blogInfoVO);
        }
        return blogInfoVOS;
    }

    @Override
    public ResponseVO putFavor(FavorVO favorVO) {
        Favor favor=new Favor();
        BeanUtils.copyProperties(favorVO,favor);
        if(favor.getClassification().equals("null")){
            favorMapper.annulFavor(favor.getUserId(),favor.getBlogId());
            return ResponseVO.buildSuccess(true);
        }
        try {
            favorMapper.putFavor(favor);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(PUT_FAVOR_FAILURE);
        }
        return ResponseVO.buildSuccess(PUT_FAVOR_SUCCESS);
    }

    // String为"null"表示未被收藏，为""表示在默认收藏夹。
    @Override
    public String inFavor(int userId, int blogId) {
        String ans=favorMapper.inFavor(userId, blogId);
        if(ans==null){
            ans="null";
        }
        return ans;
    }

}
