package cn.com.dodo.geek.study.schoolstarter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.dodo.geek.study.schoolstarter.impl.Klass;
import cn.com.dodo.geek.study.schoolstarter.impl.School;
import cn.com.dodo.geek.study.schoolstarter.impl.Student;

@Configuration
@EnableConfigurationProperties(value = SchoolProperties.class)
@ConditionalOnClass({ School.class, Klass.class, Student.class })
public class SchoolAutoConfiguration {
	
	@Bean
	public IStudent student() {
		Student student = new Student();
		student.setAge(26);
		student.setName("zhangsan");
		return student;
	}

	@Bean
	public IKlass klass(IStudent student) {
		List<IStudent> students = new ArrayList<>();
		students.add(student);
		Klass klass = new Klass(students);
		klass.setGrade(1);
		klass.setKlass(1);
		return klass;
	}
	
	@Bean
	public ISchool school(IKlass klass, SchoolProperties prop) {
		School school = new School(prop.getName(), prop.getAddress());
		List<IKlass> klasss = new ArrayList<>();
		klasss.add(klass);
		school.setKlass(klasss);
		return school;
	}
}
