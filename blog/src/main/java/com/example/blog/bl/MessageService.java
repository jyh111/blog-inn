package com.example.blog.bl;

import com.example.blog.po.Message;

import java.util.List;

public interface MessageService {
	List<Message> getMessageByUserID(int userId);

}
