package com.monk.study.aopproxy;

import com.monk.study.bean.User;
import org.springframework.stereotype.Component;

@Component
public class ProxyServiceDemo {

	public void say(String name, User user) {
		System.out.println("hello " + name + " ----source----");
	}

	public String returnStr(){
		System.out.println("return str ----source----");
		return "jack";
	}

	public void throwError(){
		System.out.println("throw Error ----source----");
		int i = 100/0;
	}
}
