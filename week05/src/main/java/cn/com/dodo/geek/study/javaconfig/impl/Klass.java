package cn.com.dodo.geek.study.javaconfig.impl;

import java.util.List;

import cn.com.dodo.geek.study.javaconfig.IKlass;
import cn.com.dodo.geek.study.javaconfig.IStudent;


public class Klass implements IKlass {

	private int grade;
	private int klass;
	private List<IStudent> students;

	public Klass(List<IStudent> students) {
		super();
		this.students = students;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKlass() {
		return klass;
	}

	public void setKlass(int klass) {
		this.klass = klass;
	}

	public List<IStudent> getStudents() {
		return students;
	}

	public void setStudents(List<IStudent> students) {
		this.students = students;
	}

	@Override
	public void print() {
		System.out.println(this.grade + " grade " + this.klass + " class has " + this.students.size() + " student");
	}

}
