package com.monk.study.service;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

	@Autowired
	private T t;

	public T getT() {
		return t;
	}
}
