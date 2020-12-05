package com.monk.study.aopproxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * JDK动态代理工具类
 */
public class JdkProxyInterfaceTest {

	public static void main(String[] args) {
		ProxyInterfaceImpl target = new ProxyInterfaceImpl();

		ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
				System.out.println("before...");

//				method.invoke(target,args);

				System.out.println("after...");
				return null;
			}
		});

		proxy.say();
	}
}
