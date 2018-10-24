package com.app.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.app.repository")
@PropertySource("classpath:application.properties")
public class DataConfig {

    private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
    private final String PROPERTY_DIALECT = "spring.jpa.properties.hibernate.dialect";
    private final String PROPERTY_DDL = "spring.jpa.hibernate.ddl-auto";

    @Autowired
    private Environment env;

    @Bean
    DataSource dataSource() throws SQLException{
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUser(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    private Properties hibernateProps(){
        Properties properties = new Properties();
        properties.setProperty(PROPERTY_DIALECT,env.getProperty(PROPERTY_DIALECT));
        properties.setProperty(PROPERTY_SHOW_SQL, env.getProperty(PROPERTY_SHOW_SQL));
        properties.setProperty(PROPERTY_DDL, env.getProperty(PROPERTY_DDL));
        return properties;
    }


}
