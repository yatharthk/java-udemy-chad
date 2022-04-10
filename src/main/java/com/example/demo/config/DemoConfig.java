package com.example.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.*")
@PropertySource(value = "classpath:database-mysql.properties")
public class DemoConfig implements WebMvcConfigurer {
    @Autowired
    private Environment environment;

    public DataSource getDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        try {
            comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e.getCause());
        }
        comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
        comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));

        comboPooledDataSource.setInitialPoolSize(getIntProperty(environment.getProperty("connection.pool.initialPoolSize")));
        comboPooledDataSource.setMaxPoolSize(getIntProperty(environment.getProperty("connection.pool.maxPoolSize")));
        comboPooledDataSource.setMinPoolSize(getIntProperty(environment.getProperty("connection.pool.minPoolSize")));
        comboPooledDataSource.setMaxIdleTime(getIntProperty(environment.getProperty("connection.pool.maxIdleTime")));

        return comboPooledDataSource;
    }

    private int getIntProperty(String property) {

        String propVal = environment.getProperty(property);

        // now convert to int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }

    Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
        localSessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
        localSessionFactoryBean.setDataSource(getDataSource());
        return localSessionFactoryBean;
    }

    @Bean
    HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        transactionManager.setDataSource(getDataSource());
        return transactionManager;
    }


}
