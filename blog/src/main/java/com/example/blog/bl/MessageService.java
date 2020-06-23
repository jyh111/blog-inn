package com.example.blog.bl;

import com.example.blog.po.Message;
import com.example.blog.vo.MessageVO;
import com.example.blog.vo.ResponseVO;

import java.util.List;

public interface MessageService {
	List<Message> getMessageByUserID(int userId);

	ResponseVO addMessage(MessageVO messageVO);
}
