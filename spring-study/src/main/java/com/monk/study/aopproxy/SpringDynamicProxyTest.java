package com.monk.study.aopproxy;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 *
 * Spring封装的动态代理工具类
 * @ClassName DynamicProxyTest
 * @Description: TODO
 * @Author Monk
 * @Date 2020/12/1
 * @Version V1.0
 **/
public class SpringDynamicProxyTest {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory(new ProxyServiceImpl());
		//factory.setTarget(new ProxyServiceImpl());
		//factory.setInterfaces(ProxySerivce.class);
		//factory.setProxyTargetClass(true);
		//factory.setTargetClass(ProxySerivce.class);

		factory.addAdvice(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("before...");
			}
		});

		ProxyService serivce = (ProxyService) factory.getProxy();
		serivce.say();
		System.out.println(serivce);
	}

}
