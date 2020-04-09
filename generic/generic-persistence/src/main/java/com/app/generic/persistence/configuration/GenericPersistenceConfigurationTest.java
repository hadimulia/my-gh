package com.app.generic.persistence.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class GenericPersistenceConfigurationTest {

	@Autowired
	private DataSource dataSource;

	@Bean("dataSource")
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		basicDataSource.setUrl("jdbc:hsqldb:mem:standalone-test");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("");
		return basicDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean ApplicationEntityManager() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "create-drop");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.enable_lazy_load_no_trans", true);

		LocalContainerEntityManagerFactoryBean applicationEntityManager = new LocalContainerEntityManagerFactoryBean();
		applicationEntityManager.setDataSource(dataSource);
		applicationEntityManager.setPackagesToScan(getPackageScan());
		applicationEntityManager.setJpaProperties(properties);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		applicationEntityManager.setJpaVendorAdapter(vendorAdapter);

		return applicationEntityManager;
	}

	protected abstract String[] getPackageScan();

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(ApplicationEntityManager().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
