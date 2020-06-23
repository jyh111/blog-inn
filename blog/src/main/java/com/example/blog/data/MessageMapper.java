package com.example.blog.data;


import com.example.blog.po.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
	public List<Message> getMessageByUserID(int userId);

}
