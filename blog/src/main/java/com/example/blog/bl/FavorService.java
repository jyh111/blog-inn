package com.example.blog.bl;

import com.example.blog.vo.BlogInfoVO;
import com.example.blog.vo.FavorVO;
import com.example.blog.vo.ResponseVO;

import java.util.List;

public interface FavorService {

    List<BlogInfoVO> getFavorsByUserId(int userId);

    ResponseVO putFavor(FavorVO favorVO);

    ResponseVO putFavorFolder(int userId,String folder_name);

    ResponseVO deleteFavorFolder(int userId,String folder_name);

}
