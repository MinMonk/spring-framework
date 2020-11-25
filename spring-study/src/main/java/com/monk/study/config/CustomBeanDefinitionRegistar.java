package com.monk.study.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName CustomBeanDefinitionRegistar
 * @Description: TODO
 * @Author Monk
 * @Date 2020/11/25
 * @Version V1.0
 **/
public class CustomBeanDefinitionRegistar extends AnnotationConfigApplicationContext implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		super.scan("com.monk.study.mapper");
	}
}
