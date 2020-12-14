package com.monk.study.transaction.test;

import com.monk.study.config.AppConfig;
import com.monk.study.config.TransactionAppConfig;
import com.monk.study.transaction.UserDao;
import com.monk.study.transaction.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;

public class TransactionTestMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.register(TransactionAppConfig.class);
		applicationContext.scan("com.monk.study.transaction");
		applicationContext.refresh();

		UserService userService = applicationContext.getBean(UserService.class);
		userService.insert1();
		//userService.insert2();
		userService.query();
	}
}
