package cn.com.dodo.geek.study.bootautoconfig;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.dodo.geek.study.schoolstarter.ISchool;
import cn.com.dodo.geek.study.schoolstarter.SchoolApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class SchoolBootstrapTest {
	@Autowired
	private ISchool school;

	@org.junit.Test
	public void context() {
		school.print();
	}
}
