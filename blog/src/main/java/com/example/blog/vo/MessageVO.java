package com.example.blog.vo;


import com.example.blog.bl.UserService;
import com.example.blog.po.Message;
import com.example.blog.po.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageVO {
	private UserDisplayVO sender;
	private UserDisplayVO recipient;
	private Integer blogId;
	private String content;
	private Integer messageId;


	public MessageVO(Message msg, UserService userService) {
		this.messageId = msg.getMessageId();
		this.blogId = msg.getBlogId();
		this.content = msg.getContent();

		User userSender = userService.getUserInfo(msg.getSender());
		User userRecipient = userService.getUserInfo(msg.getRecipient());
		this.sender = new UserDisplayVO(userSender);
		this.recipient = new UserDisplayVO((userRecipient));
	}
}
