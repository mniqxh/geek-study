package cn.com.dodo.geek.study.autoconfig.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dodo.geek.study.autoconfig.IKlass;
import cn.com.dodo.geek.study.autoconfig.IStudent;

@Component
public class Klass implements IKlass {

	private int grade = 1;
	private int klass = 1;
	private List<IStudent> students;

	@Autowired
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
