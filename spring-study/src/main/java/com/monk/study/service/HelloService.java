package com.monk.study.service;

import com.monk.study.bean.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

/**
 * @ClassName HelloService
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/23
 * @Version V1.0
 **/
//@Service("helloService")
public class HelloService implements DisposableBean {

	//@Value("zhangsan")
	private User user;

	public void sayHello(){
		System.out.println("hello word");
	}

	public void sayHello1(){
		System.out.println("hello " + user.getUserName());
	}

	@PreDestroy
	public void destory(){
		System.out.println(" PreDestroy destory");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(" DisposableBean destory");
	}
}
