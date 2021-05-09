package cn.com.dodo.geek.study.week07.spring.conf;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

import cn.com.dodo.geek.study.week07.country.dao.ICountryDao;
import cn.com.dodo.geek.study.week07.country.dao.impl.CountryDaoImpl;
import cn.com.dodo.geek.study.week07.spring.SimpleRoutingDataSource;

@Configuration
@ConditionalOnProperty(prefix = "dynamic.dataSource", name = "type", havingValue = "simple")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DataSourceConfiguration {

	@Primary
	@Bean
	public DataSource SimpleRoutingDataSource() {
		SimpleRoutingDataSource dataSource = new SimpleRoutingDataSource();
		Map<Object, Object> targetDataSources = new HashMap<>(2);
		targetDataSources.put("read", readDataSource());
		targetDataSources.put("write", writeDataSource());
		dataSource.setTargetDataSources(targetDataSources);
		dataSource.setDefaultTargetDataSource(writeDataSource());

		return dataSource;
	}

	@Bean
	@ConfigurationProperties(prefix = "geek.hakaricp.read")
	public DataSource readDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean
	@ConfigurationProperties(prefix = "geek.hakaricp.write")
	public DataSource writeDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean
	public ICountryDao iCountryDao(DataSource dataSource) {
		return new CountryDaoImpl(dataSource);
	}

	@Bean
	public DataSourceChangeAspect dataSourceChangeAspect() {
		return new DataSourceChangeAspect();
	}

}
