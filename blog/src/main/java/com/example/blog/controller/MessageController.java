package com.example.blog.controller;

import com.example.blog.bl.MessageService;
import com.example.blog.bl.UserService;
import com.example.blog.po.Message;
import com.example.blog.vo.MessageVO;
import com.example.blog.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/message")
public class MessageController {

	@Autowired
	MessageService messageService;

	@Autowired
	UserService userService;


	@GetMapping("/{userID}/getMessages")
	public ResponseVO getMessageByUserID(@PathVariable Integer userID) {
		List<Message> messageList = messageService.getMessageByUserID(userID);
		List<MessageVO> messageVOList = new ArrayList<>();
		for (Message message : messageList) {
			MessageVO messageVO = new MessageVO(message, userService);

		}

		return ResponseVO.buildSuccess(messageVOList);
	}

	@PostMapping("/addMessage")
	public ResponseVO addMessage(MessageVO messageVO) {
		return messageService.addMessage(messageVO);
	}
}
