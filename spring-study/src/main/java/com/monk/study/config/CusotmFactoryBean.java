package com.monk.study.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName CusotmFactoryBean
 * @Description: TODO
 * @Author Monk
 * @Date 2020/11/25
 * @Version V1.0
 **/
@Component
public class CusotmFactoryBean<T> implements FactoryBean<T> {

	public static final Logger logegr = LoggerFactory.getLogger(CusotmFactoryBean.class);

	private Class<T> mapperInterface;

	public CusotmFactoryBean() {
	}

	public CusotmFactoryBean(Class<T> mapperInterface){
		this.mapperInterface = mapperInterface;
	}

	@Override
	public T getObject() throws Exception {

		Object object = Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				logegr.info("动态代理执行的逻辑:{}", method.getName());
				return proxy;
			}
		});
		return (T) object;
	}

	@Override
	public Class<T> getObjectType() {
		return mapperInterface;
	}

	public void setMapperInterface(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}
}
