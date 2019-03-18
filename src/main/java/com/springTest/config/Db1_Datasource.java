package com.springTest.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.springTest.repo.db1"},
        entityManagerFactoryRef = "db1EntityManager",
        transactionManagerRef = "db1TransactionManager")
@EnableTransactionManagement
public class Db1_Datasource {
	 @Autowired
	    private Environment env;
	    @Bean
	    @Primary
	    public LocalContainerEntityManagerFactoryBean db1EntityManager() {
	        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(db1Datasource());
	        em.setPackagesToScan(new String[]{"com.springTest.model.db1"});
	        em.setPersistenceUnitName("db1EntityManager");
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);
	        HashMap<String, Object> properties = new HashMap<String, Object>();
	        properties.put("hibernate.dialect",
	                env.getProperty("hibernate.dialect"));
	        properties.put("hibernate.show-sql",
	                env.getProperty("jdbc.show-sql"));
	        em.setJpaPropertyMap(properties);
	        return em;
	    }

	    @Primary
	    @Bean
	    public DataSource db1Datasource() {

	        DriverManagerDataSource dataSource
	                = new DriverManagerDataSource();
	        dataSource.setDriverClassName(
	                env.getProperty("jdbc.driver-class-name"));
	        dataSource.setUrl(env.getProperty("db1.datasource.url"));
	        dataSource.setUsername(env.getProperty("db1.datasource.username"));
	        dataSource.setPassword(env.getProperty("db1.datasource.password"));

	        return dataSource;
	    }

	    @Primary
	    @Bean
	    public PlatformTransactionManager db1TransactionManager() {

	        JpaTransactionManager transactionManager
	                = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(
	        		db1EntityManager().getObject());
	        return transactionManager;
	    }
	    
}
