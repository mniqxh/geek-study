package cn.com.dodo.geek.study.week07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.dodo.geek.study.week07.country.dao.ICountryDao;
import cn.com.dodo.geek.study.week07.country.model.Country;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Week07Application.class)
public class Week07ApplicationTests {

	@Autowired
	ICountryDao countryDao;

	@Test
	public void findOne() {
		Long id = 1L;
		Country country = countryDao.findOne(id);
		System.out.println(country);
	}
	
	@Test
	public void save(){
		Country country = new Country();
		country.setCountryName("china");
		country.setCountryCode("12");
		
		countryDao.saveOne(country);
		
		countryDao.updateOne(country);
		
		countryDao.deleteOne(country.getId());
	}

}
