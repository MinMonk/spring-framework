package com.monk.study;

import com.monk.study.config.AppConfig;
import com.monk.study.service.destory.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName PropertyConvertTest
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/28
 * @Version V1.0
 **/
public class PropertyConvertTest {


	@Test
	void convertUserByPropertyEditor(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloService helloService = (HelloService) ctx.getBean("helloService");
		helloService.sayHello1();
	}

	@Test
	void convertUserBySpringConvertService(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloService helloService = (HelloService) ctx.getBean("helloService");
		helloService.sayHello1();
	}
}
