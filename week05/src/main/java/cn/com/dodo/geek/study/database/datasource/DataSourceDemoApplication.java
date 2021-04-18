package cn.com.dodo.geek.study.database.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(HikariCPConfigura.class)
public class DataSourceDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataSourceDemoApplication.class, args);
	}
}