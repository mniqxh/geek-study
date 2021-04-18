package cn.com.dodo.geek.study.xmlconfig.impl;

import java.util.List;

import cn.com.dodo.geek.study.xmlconfig.IKlass;
import cn.com.dodo.geek.study.xmlconfig.ISchool;

public class School implements ISchool {

	private List<IKlass> klass;
	private String name;
	private String address;

	public School(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public List<IKlass> getKlass() {
		return klass;
	}

	public void setKlass(List<IKlass> klass) {
		this.klass = klass;
	}

	@Override
	public void print() {
		System.out.println(this.name + " school's address:" + this.address + " has " + this.klass.size() + " class");
	}

}
