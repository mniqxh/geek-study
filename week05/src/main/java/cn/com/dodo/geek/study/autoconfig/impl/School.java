package cn.com.dodo.geek.study.autoconfig.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.dodo.geek.study.autoconfig.IKlass;
import cn.com.dodo.geek.study.autoconfig.ISchool;

@Component
public class School implements ISchool {

	private List<IKlass> klass;
	private String name = "北京第一中学";
	private String address = "北京长安街1号";

	public School() {
		super();
	}

	public School(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public List<IKlass> getKlass() {
		return klass;
	}

	@Autowired
	public void setKlass(List<IKlass> klass) {
		this.klass = klass;
	}

	@Override
	public void print() {
		System.out.println(this.name + " school's address:" + this.address + " has " + this.klass.size() + " class");
	}

}
