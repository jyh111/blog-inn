package com.example.blog.blImpl;

import com.example.blog.bl.FavorService;
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

    /*
    返回收藏的文章列表
     */
    @Override
    public List<BlogInfoVO> getFavorsByUserId(int userId) {
        List<Favor> favors=favorMapper.getFavorsByUserId(userId);
        List<BlogInfoVO> blogInfoVOS=new ArrayList<>();
        return null;
    }

    @Override
    public ResponseVO putFavor(FavorVO favorVO) {
        Favor favor=new Favor();
        BeanUtils.copyProperties(favorVO,favor);
        try {
            favorMapper.putFavor(favor);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure(PUT_FAVOR_FAILURE);
        }
        return ResponseVO.buildSuccess(PUT_FAVOR_SUCCESS);
    }
}
