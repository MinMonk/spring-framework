package com.monk.study;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.Assert;

/**
 * @ClassName EnvironmentTest
 * @Description: 获取环境变量
 * @Author Monk
 * @Date 2020/10/28
 * @Version V1.0
 **/
public class EnvironmentTest {

	@Test
	void printEnvironment(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ConfigurableEnvironment environment = ctx.getEnvironment();
		System.out.println("----SystemEnvironment------");
		System.out.println(environment.getSystemEnvironment());
		System.out.println("----SystemProperties------");
		System.out.println(environment.getSystemProperties());
		System.out.println("----JAVA_HOME------");
		System.out.println(environment.getSystemEnvironment().get("JAVA_HOME"));
	}
}
