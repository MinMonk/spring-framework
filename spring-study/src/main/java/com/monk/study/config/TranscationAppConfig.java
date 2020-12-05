package com.monk.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
public class TranscationAppConfig {

//	@Bean
//	public PlatformTransactionManager platformTransactionManager() {
//		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
//		dataSourceTransactionManager.setDataSource(dataSource());
//		return dataSourceTransactionManager;
//	}
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		//dataSource.setUrl();
//		return dataSource;
//	}
}
