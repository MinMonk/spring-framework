package com.monk.study;

import com.monk.study.bean.User;
import com.monk.study.config.AppConfig;
import com.monk.study.service.HelloService;
import com.monk.study.service.TestFactoryBean;
import com.monk.study.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Locale;

/**
 * @ClassName App
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/23
 * @Version V1.0
 **/
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = ctx.getBean("userService", UserService.class);

		ctx.close();

	}
}

