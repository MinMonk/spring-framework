package com.monk.study.aopproxy;

import com.monk.study.bean.User;
import com.monk.study.config.AppConfig;
import com.monk.study.config.ProxyAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProxyTestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.register(ProxyAppConfig.class);
		applicationContext.scan("com.monk.study.aopproxy");
		applicationContext.refresh();

		ProxyService proxyService = applicationContext.getBean(ProxyService.class);
		proxyService.say();
		System.out.println("=======================\r\n");

		/*ProxyServiceDemo proxyInterface = applicationContext.getBean(ProxyServiceDemo.class);
		proxyInterface.say("zhangsan", new User(1l, "lisi"));
		System.out.println("=======================\r\n");
		proxyInterface.returnStr();
		System.out.println("=======================\r\n");
		proxyInterface.throwError();*/
	}
}
