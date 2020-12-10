package com.monk.study.custommapper.test;

import com.monk.study.config.AppConfig;
import com.monk.study.config.CustomMapperScanConfig;
import com.monk.study.custommapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomMapperScanTestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.scan("com.monk.study.custommapper");
		applicationContext.register(CustomMapperScanConfig.class);

		applicationContext.refresh();

		UserMapper userService = applicationContext.getBean(UserMapper.class);
		userService.user();
	}

}
