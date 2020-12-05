package com.monk.study.aopproxy;

import org.springframework.stereotype.Component;

@Component("proxyInterface")
public class ProxyInterfaceImpl implements ProxyInterface{

	@Override
	public void say() {
		System.out.println("hello word.");
	}
}
