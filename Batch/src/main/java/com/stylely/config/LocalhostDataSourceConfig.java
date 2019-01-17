package com.stylely.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = { "com.stylely.db.localhost.mapper" }, sqlSessionFactoryRef = "localhostSqlSessionFactory")
public class LocalhostDataSourceConfig {

	/**
	 * 创建数据源
	 * 
	 * @return
	 */
	@Bean(name = "localhostDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.localhost-db")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 创建工厂
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "localhostSqlSessionFactory")
	@Primary
	public SqlSessionFactory localhostSqlSessionFactory(@Qualifier("localhostDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mapper/localhost/*.xml"));
		return bean.getObject();
	}

	/**
	 * 创建事务
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "localhostTransactionManager")
	@Primary
	public DataSourceTransactionManager localhostDataSourceTransactionManager(
			@Qualifier("localhostDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	/**
	 * 创建模板
	 * 
	 * @param sqlSessionFactory
	 * @return
	 */
	@Bean(name = "localhostSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate localhostSqlSessionTemplate(
			@Qualifier("localhostSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
