package com.monk.study;

import com.monk.study.bean.User;
import com.monk.study.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName FactoryBeanTest
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/29
 * @Version V1.0
 **/
public class FactoryBeanTest {

	@Test
	void testImplementFacatoryBean(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getBean("testFactoryBean"));
	}
}
