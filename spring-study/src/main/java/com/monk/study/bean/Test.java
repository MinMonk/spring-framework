package com.monk.study.bean;

import com.monk.study.service.BaseService;
import com.sun.xml.internal.rngom.parse.host.Base;

public class Test {

	public static void main(String[] args) {
		System.out.println(ParentEntity.class.isAssignableFrom(User.class));
		System.out.println(ParentInterface.class.isAssignableFrom(User.class));
	}
}
