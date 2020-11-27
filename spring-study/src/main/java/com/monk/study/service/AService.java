package com.monk.study.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @ClassName AService
 * @Description: TODO
 * @Author Monk
 * @Date 2020/11/27
 * @Version V1.0
 **/
@Aspect
@Component
@Lazy
public class AService {

	@Autowired
	private BService bService;


	public AService(BService bService){
		this.bService = bService;
	}

//	@Autowired
//	private CService cService;

	@Pointcut("execution(public * com.monk.study.service.AService.test(..))")
	public void test(){
		System.out.println("before...");
	}
}
