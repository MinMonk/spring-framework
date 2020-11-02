package com.monk.study;

import com.monk.study.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * @ClassName MessageResourceTest
 * @Description: 国际化消息单元测试类
 * @Author Monk
 * @Date 2020/10/28
 * @Version V1.0
 **/
public class MessageResourceTest {

	@Test
	void printMessage(){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getMessage("name", null, new Locale("en")));
		System.out.println(ctx.getMessage("name", null, new Locale("")));
	}
}
