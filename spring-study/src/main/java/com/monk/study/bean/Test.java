package com.monk.study.bean;

public class Test {

	public static void main(String[] args) {
		System.out.println(ParentEntity.class.isAssignableFrom(User.class));
		System.out.println(ParentInterface.class.isAssignableFrom(User.class));
	}
}
