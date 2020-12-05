package com.monk.study;

import com.monk.study.config.AppConfig;
import com.monk.study.service.loopdependce.AService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName App
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/23
 * @Version V1.0
 **/
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		// 注册自定义spring构造方法推断过滤器
		//applicationContext.getBeanFactory().addBeanPostProcessor(new CustomDetermineCandidateConstructors());

		// 自定义BeanName生成器
		// applicationContext.getBeanFactory().registerSingleton(AnnotationConfigUtils.CONFIGURATION_BEAN_NAME_GENERATOR,new CustomBeanNameGenerator());
		applicationContext.refresh();

		// 循环依赖
		AService bean = applicationContext.getBean(AService.class);
		bean.test();

		/**
		 * 手动调用容器的销毁方法,会触发重写了销毁逻辑接口的销毁逻辑
		 * 添加注解@PreDestroy的方式 -->  @See com.monk.study.service.destory.OrderService
		 * 实现DisposableBean接口的方式 -->  @See com.monk.study.service.destory.HelloService
		 */
		//applicationContext.close();

	}
}

