package cn.com.dodo.geek.study.week07.country.dao;

import cn.com.dodo.geek.study.week07.country.model.Country;

public interface ICountryDao {
	public Country findOne(Long id);

	public int saveOne(Country country);

	public int deleteOne(Long id);

	public int updateOne(Country country);

}
