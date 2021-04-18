package cn.com.dodo.geek.study.autoconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.com.dodo.geek.study.autoconfig.impl.School;

@Configuration
@ComponentScan(value = "cn.com.dodo.geek.study.autoconfig")
public class BoostrapConfig {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BoostrapConfig.class);
		ISchool school = (School) ctx.getBean("school");
		school.print();
	}
}
