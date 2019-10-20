package com.atanas.web.config;

import java.util.*;
import javax.sql.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;

@Configuration
@EnableJpaRepositories(basePackages =
{
  "com.atanas.web.repositories"
})
@EnableTransactionManagement
public class DatabaseConfig
{
  @Bean
  public DataSource dataSource()
  {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/web_news");
    dataSource.setUsername("web_news_user");
    dataSource.setPassword("Test-1234");

    return dataSource;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter()
  {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    return jpaVendorAdapter;
  }

  private Properties jpaProperties()
  {
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    jpaProperties.setProperty("hibernate.show_sql", "true");
    jpaProperties.setProperty("hibernate.format_sql", "true");

    return jpaProperties;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
  {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setDataSource(dataSource());
    entityManagerFactory.setPackagesToScan("com.atanas.web.entities");
    entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
    entityManagerFactory.setJpaProperties(jpaProperties());

    return entityManagerFactory;
  }

  @Bean
  public JdbcTemplate jdbcTemplate()
  {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource());
    return jdbcTemplate;
  }

  @Bean
  public PlatformTransactionManager transactionManager()
  {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }
}
