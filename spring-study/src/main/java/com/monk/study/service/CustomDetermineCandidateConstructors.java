package com.monk.study.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义构造方法推断过滤逻辑
 * @ClassName CustomDetermineCandidateConstructors
 * @Description: TODO
 * @Author Monk
 * @Date 2020/11/24
 * @Version V1.0
 **/
 //@Component
public class CustomDetermineCandidateConstructors implements SmartInstantiationAwareBeanPostProcessor {

	/**
	 * 这里只是一个简单的demo，过滤userService构造方法参数为一个的构造方法
	 * @param beanClass the raw class of the bean (never {@code null})
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		Constructor<?>[] rawCandidates = beanClass.getDeclaredConstructors();
		List<Constructor<?>> candidates = new ArrayList<>(rawCandidates.length);
		for (Constructor<?> candidate : rawCandidates) {
			if(beanName.equals("userService")){
				if(candidate.getParameterCount() == 1){
					candidates.add(candidate);
				}
			}else{
				candidates.add(candidate);
			}
		}

		return candidates.toArray(new Constructor<?>[0]);
	}
}
