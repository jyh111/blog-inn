package com.example.blog.data;


import com.example.blog.po.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
	List<Message> getMessageByUserID(@Param("id") int userId);

	int addMessage(Message message);
}
