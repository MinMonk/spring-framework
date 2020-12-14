package com.monk.study.transaction;

import com.sun.javafx.tk.TKPulseListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author Monk
 * @Date 2020/12/11
 * @Version V1.0
 **/
@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Transactional
	public void insert1(){
		userDao.insert1();
		userService.insert2();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insert2(){
		userDao.insert2();
		//int a = 100/0;
	}

	public void query(){
		userDao.query();
	}
}
