package com.example.blog.data;

import com.example.blog.po.Favor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FavorMapper {

    List<Favor> getFavorsByUserId(int userId);

    int putFavor(Favor favor);

}
