package com.monk.study.custommapper;

import org.springframework.beans.factory.annotation.Autowired;
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
