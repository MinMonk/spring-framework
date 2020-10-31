package com.monk.study.service;

import com.monk.study.bean.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestFactoryBean
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/29
 * @Version V1.0
 **/
@Component
public class TestFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
