package com.monk.study.aopproxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Pointcut("execution(public * com.monk.study.aopproxy.ProxyService.*(..))")
	public void jdkMethod(){};

	@Pointcut("execution(public * com.monk.study.aopproxy.ProxyServiceDemo.*(..))")
	public void sayMethod(){};

	@Before("jdkMethod()")
	public void beforeJdkAdvice(JoinPoint joinPoint){
		System.out.println("beforeJdkAdvice ----proxy----");
	}

	/**
	 * 是允许存在多个@before的，会存在顺序，顺序应该是根据方法名进行排序的
	 * @param joinPoint
	 */
	@Before("jdkMethod()")
	public void beforeJdkAdvice1(JoinPoint joinPoint){
		System.out.println("beforeJdkAdvice1 ----proxy----");
	}

	@Before("sayMethod()")
	public void beforeAdvice(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(arg);
		}
		System.out.println("beforeAdvice ----proxy----");
	}

	@After("sayMethod()")
	public void afterAdvice(JoinPoint joinPoint){
		System.out.println("afterAdvice ----proxy----");
	}

	@AfterReturning(pointcut = "sayMethod()", returning = "returnVal")
	public void afterReturningAdvice(JoinPoint joinPoint,Object returnVal){
		System.out.println("afterReturningAdvice, return value = " + returnVal);
	}

	@AfterThrowing(pointcut="sayMethod()",throwing="error")
	public void afterThrowing(JoinPoint joinPoint,Throwable error){
		System.out.println("AfterThrowing ----proxy----");
	}

	@Around("sayMethod()")
	public void aroundAdvice(ProceedingJoinPoint pjp){
		System.out.println("AOP Around before... ----proxy----");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("AOP Around after... ----proxy----");
	}

}
