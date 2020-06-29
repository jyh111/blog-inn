package com.example.blog.blImpl;

import com.example.blog.bl.MessageService;
import com.example.blog.data.MessageMapper;
import com.example.blog.po.Message;
import com.example.blog.vo.MessageVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
	private final static String ADD_Message_FAILURE = "添加消息失败";
	private final static String ADD_Message_SUCCESS = "添加消息成功";
	@Autowired
	MessageMapper messageMapper;

	@Override
	public List<Message> getMessageByUserID(int userId) {
		System.out.println(this.messageMapper.getMessageByUserID(userId));
		return this.messageMapper.getMessageByUserID(userId);
	}

	@Override
	public ResponseVO addMessage(MessageVO messageVO) {
		Message message = new Message();
//		message.setMessageId(messageVO.getMessageId());
		message.setSender(messageVO.getSender().getUserId());
		message.setRecipient(messageVO.getRecipient().getUserId());
		message.setBlogId(messageVO.getBlogId());
		message.setContent(messageVO.getContent());

		try {
			messageMapper.addMessage(message);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseVO.buildFailure(ADD_Message_FAILURE);
		}
		return ResponseVO.buildSuccess(ADD_Message_SUCCESS);
	}
}
