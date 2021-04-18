package cn.com.dodo.geek.study.xmlconfig.impl;

import cn.com.dodo.geek.study.xmlconfig.IStudent;

public class Student implements IStudent {

	private String name;
	private int age;

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
