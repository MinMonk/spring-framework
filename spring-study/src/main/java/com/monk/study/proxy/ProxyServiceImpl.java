package com.monk.study.proxy;

import org.springframework.stereotype.Component;

/**
 * @ClassName ProxyServiceImpl
 * @Description: TODO
 * @Author Monk
 * @Date 2020/12/1
 * @Version V1.0
 **/
@Component("proxyService")
public class ProxyServiceImpl implements ProxySerivce {

	@Override
	public void say() {
		System.out.println("hello word.");
	}
}
