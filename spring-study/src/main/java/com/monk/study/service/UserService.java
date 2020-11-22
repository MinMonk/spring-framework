package com.monk.study.service;

import com.monk.study.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserService{

	@Autowired
	private User user;

	@Autowired
	public UserService(User user) {
		this.user = user;
		user.setUserName("111");
		System.out.println("一个参数构造方法");
	}

	public void getUser(){
		System.out.println(this.user);
	}

}
