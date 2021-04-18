package cn.com.dodo.geek.study.javaconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cn.com.dodo.geek.study.javaconfig.impl.Klass;
import cn.com.dodo.geek.study.javaconfig.impl.Student;

@Configuration
@Import(SchoolConfig.class)
public class BoostarpConfig {
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

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BoostarpConfig.class);
		ISchool school = ctx.getBean(ISchool.class);
		school.print();
	}

}
