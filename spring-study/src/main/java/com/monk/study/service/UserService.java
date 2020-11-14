package com.monk.study.service;

import org.springframework.stereotype.Component;

@Component
public class UserService extends BaseService<OrderService> {

	public void test(){
		System.out.println(getT());
	}

}
