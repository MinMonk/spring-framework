package com.monk.study.config;

import com.sun.deploy.net.proxy.ProxyUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
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
public class CusotmFactoryBean implements FactoryBean {

	private Class mapperInterface;

	public CusotmFactoryBean(Class mapperInterface){
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {

		Object object = Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method.getName());
				return null;
			}
		});
		return object;
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
