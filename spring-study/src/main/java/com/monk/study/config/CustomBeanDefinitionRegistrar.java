package com.monk.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomBeanDefinitionRegistar
 * @Description: TODO
 * @Author Monk
 * @Date 2020/11/25
 * @Version V1.0
 **/
public class CustomBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public static final Logger logegr = LoggerFactory.getLogger(CustomBeanDefinitionRegistrar.class);

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(CustomScan.class.getName()));

		logegr.info("annoAttrs:{}", annoAttrs);
		List<String> basePackages = new ArrayList<String>();
		for (String pkg : annoAttrs.getStringArray("value")) {
			if (StringUtils.hasText(pkg)) {
				basePackages.add(pkg);
			}
		}

		CustomScanner scanner = new CustomScanner(registry);
		scanner.doScan(StringUtils.toStringArray(basePackages));
	}
}
