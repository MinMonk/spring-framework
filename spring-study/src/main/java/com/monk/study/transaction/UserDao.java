package com.monk.study.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Component
public class UserDao {

	public static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	private JdbcTemplate jdbcTemplate;

	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public void insert1(){
		jdbcTemplate.execute("insert into test_user (id, name) values(1, \"zhangsan1\")");
		//int a = 100/0;
	}

	@Transactional
	public void insert2(){
		jdbcTemplate.execute("insert into test_user (id, name) values(2, \"zhangsan2\")");
		//int a = 100/0;
	}

	public void query(){
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList("select id, name from test_user");
		logger.info("query size:{}", queryResult.size());
		queryResult.forEach(map -> {
			map.forEach((key, value) -> {
				logger.info("key:{}, value:{}", key, value);
			});
		});
	}


}
