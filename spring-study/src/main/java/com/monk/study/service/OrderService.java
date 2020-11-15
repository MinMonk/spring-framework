package com.monk.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class OrderService {

	@Autowired
	private HelloService helloService;

	@PreDestroy
	public void destory(){
		System.out.println(" OrderService destory");
	}
}
