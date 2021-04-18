package cn.com.dodo.geek.study.autoconfig.impl;

import org.springframework.stereotype.Component;

import cn.com.dodo.geek.study.autoconfig.IStudent;

@Component
public class Student implements IStudent {

	private String name = "zhangsan";
	private int age = 26;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void print() {
		System.out.println(this.name + " is " + this.age + " years old.");
	}

}
