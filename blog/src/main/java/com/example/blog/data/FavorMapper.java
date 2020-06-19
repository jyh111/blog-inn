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

    List<Integer> getFavors(@Param("userId") int userId,@Param("classification") String classification);

    void putFavor(Favor favor);

}
