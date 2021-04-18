package cn.com.dodo.geek.study.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Boostrap {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
		IStudent student1 = (IStudent) ctx.getBean("student1");
		student1.print();
		IKlass klass1 = (IKlass) ctx.getBean("klass1");
		klass1.print();
		IKlass klass2 = (IKlass) ctx.getBean("klass2");
		klass2.print();
		ISchool school = (ISchool) ctx.getBean("school");
		school.print();

	}

}
