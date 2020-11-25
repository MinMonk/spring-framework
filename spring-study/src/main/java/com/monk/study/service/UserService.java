package com.monk.study.service;

import com.monk.study.bean.User;
import com.monk.study.mapper.OrderMapper;
import com.monk.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class UserService{

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderMapper orderMapper;

	public void test(){
		userMapper.user();
		orderMapper.order();
	}

}
