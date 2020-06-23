package com.example.blog.vo;

import com.example.blog.po.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDisplayVO {
	private Integer userId;
	private String username;
	private String userImg;

	public UserDisplayVO() {
	}

	public UserDisplayVO(User user) {
		userId = user.getUserId();
		username = user.getUsername();
		userImg = user.getUserImg();
	}
}
