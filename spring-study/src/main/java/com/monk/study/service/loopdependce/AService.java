package com.monk.study.service.loopdependce;

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
@Component
@Lazy
public class AService {

	@Autowired
	private BService bService;

	/**
	 * 如果通过构造方法的方式去循环依赖自动注入,spring默认情况下会失败,但是可以通过在类上加@Lazy的方式来完成自动注入
	 * @param bService
	 */
	public AService(BService bService){
		this.bService = bService;
	}

//	@Autowired
//	private CService cService;

	public void test(){
		System.out.println("test...");
	}
}
