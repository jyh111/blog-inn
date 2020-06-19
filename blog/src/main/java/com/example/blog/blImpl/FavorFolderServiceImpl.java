package com.example.blog.blImpl;

import com.example.blog.bl.FavorFolderService;
import com.example.blog.data.FavorFolderMapper;
import com.example.blog.po.FavorFolder;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavorFolderServiceImpl implements FavorFolderService {

    @Autowired
    FavorFolderMapper favorFolderMapper;

    @Override
    public List<FavorFolder> getFavorFoldersByUserId(int userId) {
        return favorFolderMapper.getFavorFoldersByUserId(userId);
    }

    @Override
    public ResponseVO putFavorFolder(int userId, String folder_name) {
        try {
            favorFolderMapper.putFavorFolder(userId,folder_name);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("新建收藏夹失败");
        }
        return ResponseVO.buildSuccess("新建收藏夹成功");
    }

    @Override
    public ResponseVO deleteFavorFolder(int userId, String folder_name) {
        try {
            favorFolderMapper.deleteFavorFolder(userId,folder_name);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseVO.buildFailure("删除收藏夹失败");
        }
        return ResponseVO.buildSuccess("删除收藏夹成功");
    }

}
