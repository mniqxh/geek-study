package cn.com.dodo.geek.study.javaconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.dodo.geek.study.javaconfig.impl.School;

@Configuration
public class SchoolConfig {
	@Bean
	public ISchool school(IKlass klass) {
		School school = new School("深圳一中", "深圳福田区景田路1号");
		List<IKlass> klasss = new ArrayList<>();
		klasss.add(klass);
		school.setKlass(klasss);
		return school;
	}

}
