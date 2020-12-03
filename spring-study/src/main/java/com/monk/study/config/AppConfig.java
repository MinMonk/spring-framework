package com.monk.study.config;

import com.monk.study.bean.User;
import com.monk.study.service.StringToUserPropertyEditor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyEditor;
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
//@MapperScan("com.monk.study.mapper")
@CustomScan("com.monk.study.mapper")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public PlatformTransactionManager platformTransactionManager(){
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//dataSource.setUrl();
		return dataSource;
	}

	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("proxyService");
		//beanNameAutoProxyCreator.set



		return beanNameAutoProxyCreator;
	}

//	@Bean
//	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//
//		return defaultAdvisorAutoProxyCreator;
//	}

	/*@Bean
	public User user(){
		User user = new User();
		user.setUserName("jack");
		return user;
	}*/

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

	/**
	 * 配置一个@Value的值转换器
	 * @return
	 */
	/*@Bean
	public CustomEditorConfigurer customEditorConfigurer(){
		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
		Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
		customEditors.put(User.class, StringToUserPropertyEditor.class);
		customEditorConfigurer.setCustomEditors(customEditors);
		return customEditorConfigurer;
	}*/

	/*@Bean
	public ConversionServiceFactoryBean conversionServiceFactoryBean(){
		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		conversionServiceFactoryBean.setConverters(Collections.singleton(new StringToUserConvertService()));

		return conversionServiceFactoryBean;
	}*/
}
