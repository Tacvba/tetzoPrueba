package mx.com.tetzo.persistence;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"mx.com.tetzo.persistence"})
@PropertySource(value = {"classpath:config.properties"})
@Profile("JEE")
public class HibernateConfigurationJEE {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		System.out.println("PROFILE: JEE");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"mx.com.tetzo.persistence"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource(){
		System.out.println("PROFILE: JEE");
		final JndiDataSourceLookup dsLookUp = new JndiDataSourceLookup();
		dsLookUp.setResourceRef(true);
		DataSource dataSource = dsLookUp.getDataSource(environment.getRequiredProperty("tetzo.jdbc.resource"));
		return dataSource;
	}
	
	@Bean
	public Properties hibernateProperties(){
		System.out.println("PROFILE: JEE");
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("tetzo.hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("tetzo.hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("tetzo.hibernate.format_sql"));
		properties.put("hibernate.default_schema", environment.getRequiredProperty("tetzo.hibernate.default_schema"));
		properties.put("hibernate.use_sql_comments", environment.getRequiredProperty("tetzo.hibernate.use_sql_comments"));
		properties.put("hibernate.entities.package", environment.getRequiredProperty("tetzo.hibernate.entities.package"));
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s){
		HibernateTransactionManager txManeger = new HibernateTransactionManager();
		txManeger.setSessionFactory(s);
		return txManeger;
	}
	
}
