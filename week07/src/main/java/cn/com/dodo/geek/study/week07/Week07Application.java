package cn.com.dodo.geek.study.week07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class Week07Application {

	public static void main(String[] args) {
		SpringApplication.run(Week07Application.class, args);
	}

}
