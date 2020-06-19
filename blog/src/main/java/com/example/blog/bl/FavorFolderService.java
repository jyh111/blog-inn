package com.example.blog.bl;

import com.example.blog.po.FavorFolder;
import com.example.blog.vo.ResponseVO;

import java.util.List;

public interface FavorFolderService {

    List<FavorFolder> getFavorFoldersByUserId(int userId);

    ResponseVO putFavorFolder(int userId, String folder_name);

    ResponseVO deleteFavorFolder(int userId,String folder_name);

}
