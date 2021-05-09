package cn.com.dodo.geek.study.week07.country.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import cn.com.dodo.geek.study.week07.country.model.Country;

public interface ICountryMapper {

	@Select("SELECT id,country_name,country_code FROM country WHERE id=#{id}")
	@Results(value = { @Result(column = "id", jdbcType = JdbcType.INTEGER, property = "id", javaType = Long.class),
			@Result(column = "country_name", jdbcType = JdbcType.VARCHAR, property = "countryName", javaType = String.class),
			@Result(column = "country_code", jdbcType = JdbcType.VARCHAR, property = "countryCode", javaType = String.class), })
	public Country findOne(Long id);

	@Insert("INSERT INTO country(country_name,country_code) VALUES(#{countryName},#{countryCode})")
	@SelectKey(keyColumn = "id", keyProperty = "id", statement = "select LAST_INSERT_ID()", before = false, resultType = Long.class)
	public int saveOne(Country country);

	@Delete("DELETE FROM country WHERE id=#{id}")
	public int deleteOne(Long id);

	@Update("UPDATE country SET country_name=#{countryName},country_code=#{countryCode} WHERE id=#{id}")
	public int updateOne(Country country);
}
