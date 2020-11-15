package com.monk.study.config;

import com.monk.study.bean.User;
import com.monk.study.service.StringToUserConvertService;
import com.monk.study.service.StringToUserPropertyEditor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AppConfig
 * @Description: TODO
 * @Author Monk
 * @Date 2020/10/23
 * @Version V1.0
 **/
@Configuration
@ComponentScan("com.monk.study")
public class AppConfig {

	/*@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}*/

	/**
	 * 注册一个事件监听器
	 * @return
	 */
	/*@Bean
	public ApplicationListener applicationListener(){
		return new ApplicationListener() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.println("收到了一个事件，event:" + event.toString());
			}
		};
	}*/

	@Bean
	public CustomEditorConfigurer customEditorConfigurer(){
		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
		Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
		customEditors.put(User.class, StringToUserPropertyEditor.class);
		customEditorConfigurer.setCustomEditors(customEditors);
		return customEditorConfigurer;
	}

	/*@Bean
	public ConversionServiceFactoryBean conversionServiceFactoryBean(){
		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConvertService()));

		return conversionServiceFactoryBean;
	}*/
}
