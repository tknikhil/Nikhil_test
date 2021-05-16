package com.nkhil.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nkhil.repository.CodeDtlRepository;
import com.nkhil.repository.OrgHrchyRepository;
import com.nkhil.repository.SysUserRepository;
import com.nkhil.repository.impl.CodeDtlRepositoryImpl;
import com.nkhil.repository.impl.OrgHrchyRepositoryImpl;
import com.nkhil.repository.impl.SysUserRepositoryImpl;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class RepositoryConfig {
	
	private static final String PACKAGES_TO_SCAN = "com.nkhil.dao";

	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
        sessionFactory.setHibernateProperties(hibernateProperties());
       
        return sessionFactory;
    }
	
	private DataSource dataSource() {
		  HikariDataSource ds = new HikariDataSource();
	        ds.setMaximumPoolSize(100);
	        ds.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
	        ds.addDataSourceProperty("url", "jdbc:mysql://localhost:3306/Test");
	        ds.addDataSourceProperty("user", "root");
	        ds.addDataSourceProperty("password", "nikhil123");
//	        ds.addDataSourceProperty("cachePrepStmts", true);
//	        ds.addDataSourceProperty("prepStmtCacheSize", 250);
//	        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
//	        ds.addDataSourceProperty("useServerPrepStmts", true);
//	        ds.addDataSourceProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
	        
	        return ds;
	}
	
	 private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
//	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	        hibernateProperties.setProperty("hibernate.format_sql", "true");
	        hibernateProperties.setProperty("show-sql", "true");

	        return hibernateProperties;
	    }

	@Bean
	public CodeDtlRepository codeDtl() {
		return new CodeDtlRepositoryImpl();
	}
	
	@Bean
	public OrgHrchyRepository hrchyRepository() {
		return new OrgHrchyRepositoryImpl();
	}
	
	@Bean
	public SysUserRepository sysUserRepository() {
		return new SysUserRepositoryImpl();
	}

}
