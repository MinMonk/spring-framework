package com.monk.study;

import com.monk.study.bean.User;
import com.monk.study.config.AppConfig;
import com.monk.study.mapper.UserMapper;
import com.monk.study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Locale;
import java.util.function.Supplier;

/**
 * @ClassName App
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/23
 * @Version V1.0
 **/
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		//applicationContext.getBeanFactory().addBeanPostProcessor(new CustomDetermineCandidateConstructors());
		//applicationContext.register(CustomDetermineCandidateConstructors.class);

		// 自定义BeanName生成器
		// applicationContext.getBeanFactory().registerSingleton(AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR,new CustomBeanNameGenerator());
		applicationContext.refresh();
		//UserService userService = (UserService)applicationContext.getBean("userService");
		//userService.getUser();

		UserService userService = applicationContext.getBean(UserService.class);
		userService.test();
		applicationContext.close();

	}
}

