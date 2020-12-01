package com.monk.study;

import com.monk.study.proxy.ProxySerivce;
import com.monk.study.proxy.ProxyServiceImpl;
import com.monk.study.service.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxyTest
 * @Description: TODO
 * @Author Monk
 * @Date 2020/12/1
 * @Version V1.0
 **/
public class DynamicProxyTest {
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

		ProxySerivce serivce = (ProxySerivce) factory.getProxy();
		serivce.say();
		System.out.println(serivce);
	}

}
