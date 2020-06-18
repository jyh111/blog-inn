package com.example.blog.data;

import com.example.blog.po.Favor;
import com.example.blog.po.FavorFolder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FavorMapper {

    List<Favor> getFavorsByUserId(int userId);

    void putFavor(Favor favor);

    void putFavorFolder(@Param("userId") int userId,@Param("folder_name") String folder_name);

    void deleteFavorFolder(@Param("userId") int userId,@Param("folder_name") String folder_name);

}
