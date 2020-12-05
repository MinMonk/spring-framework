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
public class BService {

	@Autowired
	private AService aService;

	@Lazy
	public BService(AService service){
		this.aService = service;
	}
}
