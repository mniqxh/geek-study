package cn.com.dodo.geek.study.database.datasource;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableConfigurationProperties(HikariCPProperties.class)
public class HikariCPConfigura {

	@Bean
	public DataSource dataSource(HikariCPProperties prop) {
		HikariDataSource dataSource = new HikariDataSource(prop);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

}
