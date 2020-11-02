package com.monk.study;

import com.monk.study.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName ApplicationEventTest
 * @Description: 事件发布
 * @Author Monk
 * @Date 2020/10/28
 * @Version V1.0
 **/
public class ApplicationEventTest {

	@Test
	void publishEvent(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.publishEvent("aaa");
	}
}
