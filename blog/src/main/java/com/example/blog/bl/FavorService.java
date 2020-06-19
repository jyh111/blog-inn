package com.example.blog.bl;

import com.example.blog.vo.BlogInfoVO;
import com.example.blog.vo.FavorVO;
import com.example.blog.vo.ResponseVO;

import java.util.List;

public interface FavorService {

    List<BlogInfoVO> getFavors(int userId,String classification);

    ResponseVO putFavor(FavorVO favorVO);

}
