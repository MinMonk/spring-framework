package com.monk.study.bean;

import com.monk.study.service.OrderService;

/**
 * @ClassName User
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/28
 * @Version V1.0
 **/
public class User {

	private Long userId;

	private String userName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
