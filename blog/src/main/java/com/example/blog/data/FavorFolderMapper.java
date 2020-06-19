package com.example.blog.data;

import com.example.blog.po.FavorFolder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FavorFolderMapper {

    List<FavorFolder> getFavorFoldersByUserId(@Param("userId") int userId);

    void putFavorFolder(@Param("userId") int userId, @Param("folder_name") String folder_name);

    void deleteFavorFolder(@Param("userId") int userId,@Param("folder_name") String folder_name);

}
