package com.monk.study;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @ClassName ResourceTest
 * @Description: 获取资源文件
 * @Author Monk
 * @Date 2020/10/28
 * @Version V1.0
 **/
public class ResourceTest {

	@Test
	void printResource() throws IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		Resource[] resources = ctx.getResources("classpath:com/monk/study/*");
		for (Resource resource : resources) {
			System.out.println(resource.getFile());
			System.out.println(resource.getFilename());
			System.out.println(resource.getDescription());
			System.out.println(resource.getURI());
			System.out.println(resource.getURL());
			System.out.println("----------");
		}
	}
}
