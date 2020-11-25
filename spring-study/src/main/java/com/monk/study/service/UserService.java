package com.monk.study.service;

import com.monk.study.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class UserService{

	public UserService(){
		System.out.println("无参构造方法");
	}

	//@Autowired
	public UserService(User user){
		System.out.println("1参构造方法");
	}

}
