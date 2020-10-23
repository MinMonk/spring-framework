package com.monk.study;

import com.monk.study.config.AppConfig;
import com.monk.study.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		ctx.start();

		HelloService service = ctx.getBean(HelloService.class);
		service.sayHello();
	}
}

