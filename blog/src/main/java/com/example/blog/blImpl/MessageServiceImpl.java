package com.example.blog.blImpl;

import com.example.blog.bl.MessageService;
import com.example.blog.data.MessageMapper;
import com.example.blog.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageMapper messageMapper;

	@Override
	public List<Message> getMessageByUserID(int userId) {
		return this.messageMapper.getMessageByUserID(userId);
	}
}
