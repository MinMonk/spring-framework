package com.monk.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

public class CustomScanner extends ClassPathBeanDefinitionScanner {

	private static final Logger logger = LoggerFactory.getLogger(CustomScanner.class);

	public void setCustomFactoryBean(CusotmFactoryBean customFactoryBean) {
		this.customFactoryBean = customFactoryBean;
	}

	private CusotmFactoryBean<?> customFactoryBean = new CusotmFactoryBean<Object>();

	public CustomScanner(BeanDefinitionRegistry registry) {
		super(registry, false);

		addIncludeFilter(new TypeFilter() {
			@Override
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				return true;
			}
		});
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
	}

	@Override
	protected boolean checkCandidate(String beanName, BeanDefinition beanDefinition) {
		if (super.checkCandidate(beanName, beanDefinition)) {
			return true;
		} else {
			logger.warn("Skipping MapperFactoryBean with name '" + beanName
					+ "' and '" + beanDefinition.getBeanClassName() + "' mapperInterface"
					+ ". Bean already defined with the same name!");
			return false;
		}
	}

	@Override
	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
		logger.info("base packages:{}", basePackages);
		Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);

		if (beanDefinitions.isEmpty()) {
			System.out.println("No mapper was found in '" + Arrays.toString(basePackages)
					+ "' package. Please check your configuration.");
		} else {
			processBeanDefinitions(beanDefinitions);
		}

		return beanDefinitions;
	}

	private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
		GenericBeanDefinition beanDefinition;
		for (BeanDefinitionHolder holder : beanDefinitions) {
			beanDefinition = (GenericBeanDefinition) holder.getBeanDefinition();
			String beanClassName = beanDefinition.getBeanClassName();
			beanDefinition.setBeanClass(customFactoryBean.getClass());
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
			beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
			beanDefinition.setLazyInit(false);
		}

	}

}
